package br.com.guilherme.osSystem.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.osSystem.domain.OS;
import br.com.guilherme.osSystem.domain.enums.Prioridade;
import br.com.guilherme.osSystem.domain.enums.Status;
import br.com.guilherme.osSystem.dtos.OSDTO;
import br.com.guilherme.osSystem.exceptions.ObjectNotFoundException;
import br.com.guilherme.osSystem.repositories.OSRepository;
import br.com.guilherme.osSystem.util.OsSystemConstans;
import jakarta.validation.Valid;

@Service
public class OSService {
	
	@Autowired
	private OSRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(OsSystemConstans.OBJETO_NAO_EONCONTRADO + " id:" + id + " Tipo: " + OS.class.getName()));		
	}

	public List<OS> finAll() {		
		return repository.findAll();
	}

	public OS create(@Valid OSDTO obj) {		
		return fromDTO(obj);
	}
	
	public OS update(@Valid OSDTO obj) {
		findById(obj.getId());		
		return fromDTO(obj);
	}
	

	private OS fromDTO(OSDTO dto) {
		OS os = new OS();
		
		os.setId(dto.getId());
		os.setObservacoes(dto.getObservacoes());
		os.setPrioridade(Prioridade.toEnum(dto.getPrioridade()));
		os.setStatus(Status.toEnum(dto.getStatus()));
		os.setTecnico(tecnicoService.findById(dto.getTecnico()));
		os.setCliente(clienteService.findById(dto.getCliente()));
		
		if(os.getStatus().getCod().equals(2)) {
			os.setDataFechamento(LocalDateTime.now());
		}
		
		return repository.save(os);
		
	}


}
