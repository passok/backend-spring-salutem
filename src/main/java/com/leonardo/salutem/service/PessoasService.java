package com.leonardo.salutem.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.salutem.domain.Pessoas;
import com.leonardo.salutem.repository.PessoasRepository;
import com.leonardo.salutem.service.exceptions.ResourceNotFoundException;

@Service
public class PessoasService {
	
	@Autowired
	private PessoasRepository repository;
	
	public List<Pessoas> findAll() {
		return repository.findAll();
	}
	
	public Pessoas findById(Long id) {
		Optional<Pessoas> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Pessoas insert(Pessoas obj) {
		return repository.save(obj);
	}
	
	public Pessoas update(Long id, Pessoas obj) {
		if (!repository.existsById(id)) throw new EntityNotFoundException(
				"Pessoas não encontrada"
				);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Pessoas obj = this.findById(id);
		repository.delete(obj);
	}

}
