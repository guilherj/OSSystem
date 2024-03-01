package br.com.guilherme.osSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.osSystem.domain.Cliente;
import br.com.guilherme.osSystem.dtos.ClienteDTO;
import br.com.guilherme.osSystem.exceptions.DataIntegratyViolationException;
import br.com.guilherme.osSystem.exceptions.ObjectNotFoundException;
import br.com.guilherme.osSystem.repositories.ClienteRepository;
import br.com.guilherme.osSystem.util.OsSystemConstans;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PessoaService pessoaService;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente com id: " + id + " não encontrado!"));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO ClienteDTO) {	
		
		if(pessoaService.findByCPF(ClienteDTO.getCpf()) != null) {
			throw new DataIntegratyViolationException(OsSystemConstans.CPF_JA_CADASTRADO);
		}		 		
		
		return repository.save(new Cliente(null, ClienteDTO.getNome(), ClienteDTO.getCpf(), ClienteDTO.getTelefone()));
	}	
	
	public Cliente update(Integer id, ClienteDTO ClienteDTO) {
		Cliente oldObj = findById(id);
		
		if(pessoaService.findByCPF(ClienteDTO.getCpf()) != null && pessoaService.findByCPF(ClienteDTO.getCpf()).getId() != id) {
			throw new DataIntegratyViolationException(OsSystemConstans.CPF_JA_CADASTRADO);
		}
		
		oldObj.setNome(ClienteDTO.getNome());
		oldObj.setCpf(ClienteDTO.getCpf());
		oldObj.setTelefone(ClienteDTO.getTelefone());
				
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Cliente obj = findById(id);
		
		if(obj.getList().size() > 0) {
			throw new DataIntegratyViolationException(OsSystemConstans.CLIENTE + OsSystemConstans.POSSUI_OS_NAO_PODE_DELETAR);
		}
		
		repository.delete(obj);		
	}
	
}
