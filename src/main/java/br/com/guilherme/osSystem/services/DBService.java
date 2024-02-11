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
		
		Tecnico t1 = new Tecnico(null, "Stenio Bravo Cosme Robadey", "180.527.430-95", "(21) 96925-7311");
		Tecnico t2 = new Tecnico(null, "Emanoel Meyer Bravo Evangelista", "708.895.230-02", "(24) 97937-8551");
		Tecnico t3 = new Tecnico(null, "Luiz Torres Silva Damasceno", "332.136.850-11", "(22) 96872-6156");
		Tecnico t4 = new Tecnico(null, "Nathan Saldanha Quindeler Furtado", "092.036.840-93", "(22) 97502-5540");
		Tecnico t5 = new Tecnico(null, "Yago Celestino Mayerhofer Silveira", "603.871.330-11", "(22) 98528-8385");
		Tecnico t6 = new Tecnico(null, "Francisco Gripp Santomauro Amaral", "107.040.000-91", "(22) 97932-4118");
		
		Cliente c1 = new Cliente(null, "Laboratório Borges", "067.850.130-03", "(21) 3786-8626");
		Cliente c2 = new Cliente(null, "Lavanderia Lucas", "194.071.737-04", "(21) 3419-4194");
		Cliente c3 = new Cliente(null, "Doces Lima", "228.450.877-48", "(24) 3295-6228");
		Cliente c4 = new Cliente(null, "Bar Vogas", "777.382.217-47", "(24) 2631-3414");
		Cliente c5 = new Cliente(null, "Buffet Barroso", "853.122.367-99", "(22) 2347-3822");
		Cliente c6 = new Cliente(null, "Restaurante Nigro", "175.757.577-40", "(24) 2123-8557");
		
		OS os1 = new OS(null, Prioridade.BAIXA, "Manutenção PC Recepção.", Status.ABERTO, t2, c2);
		OS os2 = new OS(null, Prioridade.ALTA, "Servidor não liga.", Status.ANDAMENTO, t1, c1);
		OS os3 = new OS(null, Prioridade.BAIXA, "Configuração de email do usuário novo.", Status.ENCERRADO, t3, c3);
		OS os4 = new OS(null, Prioridade.MEDIA, "PDV desligando sozinho.", Status.ANDAMENTO, t4, c4);
		OS os5 = new OS(null, Prioridade.ALTA, "Micro do dono não liga.", Status.ENCERRADO, t1, c5);
		OS os6 = new OS(null, Prioridade.MEDIA, "Troca de Monitor do pc recepção", Status.ABERTO, t5, c6);
		
		t1.getList().add(os2);
		t1.getList().add(os5);
		t2.getList().add(os1);
		t3.getList().add(os3);
		t4.getList().add(os4);
		t5.getList().add(os6);
		
		
		c1.getList().add(os2);
		c2.getList().add(os1);
		c3.getList().add(os3);
		c4.getList().add(os4);
		c5.getList().add(os5);
		c6.getList().add(os6);
		
		tecnicoRepository.save(t1);
		tecnicoRepository.save(t2);
		tecnicoRepository.save(t3);
		tecnicoRepository.save(t4);
		tecnicoRepository.save(t5);
		tecnicoRepository.save(t6);
		
		clienteRepository.save(c1);
		clienteRepository.save(c2);
		clienteRepository.save(c3);
		clienteRepository.save(c4);
		clienteRepository.save(c5);
		clienteRepository.save(c6);
		
		osRepository.save(os1);			
		osRepository.save(os2);			
		osRepository.save(os3);			
		osRepository.save(os4);			
		osRepository.save(os5);			
		osRepository.save(os6);			
	}

}
