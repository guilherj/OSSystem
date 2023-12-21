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
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		 		
		repository.save(new Tecnico(null, tecnicoDTO.getNome(), tecnicoDTO.getCpf(), tecnicoDTO.getTelefone()));
		return "Técnico criado com sucesso!";
	}
	
	private Tecnico findByCPF(TecnicoDTO dto) {
		Tecnico obj = repository.findByCPF(dto.getCpf());
		
		if(obj != null) {
			return obj;
		}
		return null;
	}

}