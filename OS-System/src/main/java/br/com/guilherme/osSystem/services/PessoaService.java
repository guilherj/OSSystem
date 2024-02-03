package br.com.guilherme.osSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.osSystem.domain.Pessoa;
import br.com.guilherme.osSystem.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	
	public Pessoa findByCPF(String cpf) {
		Pessoa obj = repository.findByCPF(cpf);
		
		if(obj != null) {
			return obj;
		}
		return null;
	}

}
