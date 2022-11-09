package com.leonardo.salutem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.salutem.domain.Pessoas;
import com.leonardo.salutem.service.PessoasService;

@RestController
@RequestMapping(value = "pessoas")
public class PessoasRest {
	
	@Autowired
	private PessoasService service;
	
	@GetMapping
	public ResponseEntity<List<Pessoas>> findAll() {
		List<Pessoas> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Pessoas> findById(@PathVariable Long id) {
		Pessoas obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoas insert(@RequestBody Pessoas obj) {
		return service.insert(obj);
	}
	
	@PutMapping(path = "/{id}")
	public Pessoas update(@PathVariable Long id, @RequestBody Pessoas obj) {
		return service.update(id, obj);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
