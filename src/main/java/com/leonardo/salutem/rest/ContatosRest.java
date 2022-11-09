package com.leonardo.salutem.rest;


import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.salutem.domain.Contatos;
import com.leonardo.salutem.service.ContatosService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "contatos")
public class ContatosRest {
	
	@Autowired
	private ContatosService service;
	
	@GetMapping
	public ResponseEntity<List<Contatos>> findAll() {
		List<Contatos> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Contatos> findById(@PathVariable Long id) {
		Contatos obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Contatos insert(@RequestBody Contatos obj) {
		return service.insert(obj);
	}
	
	@PutMapping("/{id}")
	public Contatos update(@PathVariable Long id, @RequestBody Contatos obj) {
		return service.update(id, obj);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
