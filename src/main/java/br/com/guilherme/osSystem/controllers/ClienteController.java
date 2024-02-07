package br.com.guilherme.osSystem.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guilherme.osSystem.dtos.ClienteDTO;
import br.com.guilherme.osSystem.services.ClienteService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {		
		
		return ResponseEntity.ok().body(new ClienteDTO(service.findById(id)));		
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream().map(t -> new ClienteDTO(t)).collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<String> create(@Valid @RequestBody ClienteDTO ClienteDTO) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(ClienteDTO));		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO ClienteDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(service.update(id, ClienteDTO));		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
	}

}
