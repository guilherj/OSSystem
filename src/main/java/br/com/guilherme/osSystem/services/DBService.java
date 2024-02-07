package br.com.guilherme.osSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.osSystem.domain.Cliente;
import br.com.guilherme.osSystem.domain.OS;
import br.com.guilherme.osSystem.domain.Tecnico;
import br.com.guilherme.osSystem.domain.enums.Prioridade;
import br.com.guilherme.osSystem.domain.enums.Status;
import br.com.guilherme.osSystem.repositories.ClienteRepository;
import br.com.guilherme.osSystem.repositories.OSRepository;
import br.com.guilherme.osSystem.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OSRepository osRepository;
	
	public void instanciarDB() {
		
		Tecnico t1 = new Tecnico(null, "Denis", "180.527.430-95", "(21) 99999-8888");
		Tecnico t2 = new Tecnico(null, "Varelinha", "708.895.230-02", "(21) 99999-8888");
		Cliente c1 = new Cliente(null, "Campeão", "067.850.130-03", "(21) 97999-8888");
		
		OS os1 = new OS(null, Prioridade.ALTA, "Teste OS", Status.ANDAMENTO, t1, c1);
		
		t1.getList().add(os1);
		c1.getList().add(os1);
		
		tecnicoRepository.save(t1);
		tecnicoRepository.save(t2);
		clienteRepository.save(c1);
		osRepository.save(os1);			
	}

}
