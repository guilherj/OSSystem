package br.com.guilherme.osSystem.controllers;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.guilherme.osSystem.domain.Tecnico;
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
	
	@PostMapping(produces = {"application/json"})
	public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO tecnicoDTO) {
		Tecnico tecnico =  service.create(tecnicoDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tecnico.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}", produces = {"application/json"})
	public ResponseEntity<TecnicoDTO> update(@PathVariable Integer id, @Valid @RequestBody TecnicoDTO tecnicoDTO) {
		TecnicoDTO newObj = new TecnicoDTO(service.update(id, tecnicoDTO)); 
		
		return ResponseEntity.ok().body(newObj);		
	}
	
	@DeleteMapping(value = "/{id}", produces = {"application/json"})
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
	}

}
