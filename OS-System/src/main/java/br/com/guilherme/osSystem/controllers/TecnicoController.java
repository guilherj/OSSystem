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

import br.com.guilherme.osSystem.dtos.TecnicoDTO;
import br.com.guilherme.osSystem.services.TecnicoService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/tecnicos")
public class TecnicoController {
	
	@Autowired
	private TecnicoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {		
		
		return ResponseEntity.ok().body(new TecnicoDTO(service.findById(id)));		
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream().map(t -> new TecnicoDTO(t)).collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<String> create(@Valid @RequestBody TecnicoDTO tecnicoDTO) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(tecnicoDTO));		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @Valid @RequestBody TecnicoDTO tecnicoDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(service.update(id, tecnicoDTO));		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
	}

}
