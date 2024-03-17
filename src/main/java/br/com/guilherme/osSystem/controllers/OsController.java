package br.com.guilherme.osSystem.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.guilherme.osSystem.dtos.OSDTO;
import br.com.guilherme.osSystem.dtos.respose.OSGetDTO;
import br.com.guilherme.osSystem.services.OSService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/os")
public class OsController {
	
	@Autowired
	private OSService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OSGetDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(new OSGetDTO(service.findById(id)));
	}
	
	@GetMapping
	public ResponseEntity<List<OSGetDTO>> findAll() {
		List<OSGetDTO> list = service.finAll().stream().map(obj -> new OSGetDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);		
	}
	
	@PostMapping(produces = {"application/json"})
	public ResponseEntity<OSDTO> create(@Valid @RequestBody OSDTO obj) {
		obj = new OSDTO(service.create(obj));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping(produces = {"application/json"})
	public ResponseEntity<OSDTO> update(@Valid @RequestBody OSDTO obj) {		
		return ResponseEntity.ok().body(new OSDTO(service.update(obj)));
		
	}

}
