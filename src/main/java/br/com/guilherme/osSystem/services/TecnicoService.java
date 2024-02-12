package br.com.guilherme.osSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.osSystem.domain.Pessoa;
import br.com.guilherme.osSystem.domain.Tecnico;
import br.com.guilherme.osSystem.dtos.TecnicoDTO;
import br.com.guilherme.osSystem.exceptions.DataIntegratyViolationException;
import br.com.guilherme.osSystem.exceptions.ObjectNotFoundException;
import br.com.guilherme.osSystem.repositories.PessoaRepository;
import br.com.guilherme.osSystem.repositories.TecnicoRepository;
import br.com.guilherme.osSystem.util.OsSystemConstans;
import jakarta.validation.Valid;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaService pessoaService;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Técnico com id: " + id + " não encontrado!"));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO tecnicoDTO) {	
		
		if(pessoaService.findByCPF(tecnicoDTO.getCpf()) != null) {
			throw new DataIntegratyViolationException(OsSystemConstans.CPF_JA_CADASTRADO);
		}
		 		
		return repository.save(new Tecnico(null, tecnicoDTO.getNome(), tecnicoDTO.getCpf(), tecnicoDTO.getTelefone()));
	}	
	
	public Tecnico update(Integer id, TecnicoDTO tecnicoDTO) {
		Tecnico oldObj = findById(id);
		
		if(pessoaService.findByCPF(tecnicoDTO.getCpf()) != null && pessoaService.findByCPF(tecnicoDTO.getCpf()).getId() != id) {
			throw new DataIntegratyViolationException(OsSystemConstans.CPF_JA_CADASTRADO);
		}
		
		oldObj.setNome(tecnicoDTO.getNome());
		oldObj.setCpf(tecnicoDTO.getCpf());
		oldObj.setTelefone(tecnicoDTO.getTelefone());
			
		return repository.save(oldObj);
	}
	
	public String delete(Integer id) {
		Tecnico obj = findById(id);
		
		if(obj.getList().size() > 0) {
			throw new DataIntegratyViolationException(OsSystemConstans.TECNICO + OsSystemConstans.POSSUI_OS_NAO_PODE_DELETAR);
		}
		
		repository.delete(obj);
		
		return OsSystemConstans.TECNICO + OsSystemConstans.DELETE_SUCESSO;
	}

}
