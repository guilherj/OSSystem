package br.com.guilherme.osSystem.controllers;

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

import br.com.guilherme.osSystem.dtos.OSDTO;
import br.com.guilherme.osSystem.services.OSService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/os")
public class OsController {
	
	@Autowired
	private OSService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OSDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(new OSDTO(service.findById(id)));
	}
	
	@GetMapping
	public ResponseEntity<List<OSDTO>> findAll() {
		List<OSDTO> list = service.finAll().stream().map(obj -> new OSDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);		
	}
	
	@PostMapping
	public ResponseEntity<String> create(@Valid @RequestBody OSDTO obj) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));	
		
	}
	
	@PutMapping
	public ResponseEntity<String> update(@Valid @RequestBody OSDTO obj) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(obj));	
		
	}

}
