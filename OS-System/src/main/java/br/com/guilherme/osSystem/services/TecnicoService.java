package br.com.guilherme.osSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.osSystem.domain.Tecnico;
import br.com.guilherme.osSystem.dtos.TecnicoDTO;
import br.com.guilherme.osSystem.exceptions.DataIntegratyViolationException;
import br.com.guilherme.osSystem.exceptions.ObjectNotFoundException;
import br.com.guilherme.osSystem.repositories.TecnicoRepository;
import br.com.guilherme.osSystem.util.OsSystemConstans;
import jakarta.validation.Valid;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Técnico com id: " + id + " não encontrado!"));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public String create(TecnicoDTO tecnicoDTO) {	
		
		if(findByCPF(tecnicoDTO) != null) {
			throw new DataIntegratyViolationException(OsSystemConstans.CPF_JA_CADASTRADO);
		}
		 		
		repository.save(new Tecnico(null, tecnicoDTO.getNome(), tecnicoDTO.getCpf(), tecnicoDTO.getTelefone()));
		return OsSystemConstans.SAVE_TECNICO;
	}	
	
	public String update(Integer id, @Valid TecnicoDTO tecnicoDTO) {
		Tecnico oldObj = findById(id);
		
		if(findByCPF(tecnicoDTO) != null && findByCPF(tecnicoDTO).getId() != id) {
			throw new DataIntegratyViolationException(OsSystemConstans.CPF_JA_CADASTRADO);
		}
		
		oldObj.setNome(tecnicoDTO.getNome());
		oldObj.setCpf(tecnicoDTO.getCpf());
		oldObj.setTelefone(tecnicoDTO.getTelefone());
		repository.save(oldObj);		
		return OsSystemConstans.UPDATE_TECNICO;
	}
	
	public String delete(Integer id) {
		Tecnico obj = findById(id);
		
		if(obj.getList().size() > 0) {
			throw new DataIntegratyViolationException(OsSystemConstans.TECNICO_NAO_DELETADO);
		}
		
		repository.delete(obj);
		
		return OsSystemConstans.DELETE_TECNICO;
	}
	
	private Tecnico findByCPF(TecnicoDTO dto) {
		Tecnico obj = repository.findByCPF(dto.getCpf());
		
		if(obj != null) {
			return obj;
		}
		return null;
	}


}
