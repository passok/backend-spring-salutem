package com.leonardo.salutem.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.salutem.domain.Contatos;
import com.leonardo.salutem.domain.Pessoas;
import com.leonardo.salutem.repository.ContatosRepository;
import com.leonardo.salutem.repository.PessoasRepository;

@Service
public class DBService {
	
	@Autowired
	private PessoasRepository pessoasRepository;
	@Autowired
	private ContatosRepository contatosRepository;

	public void instanciaBaseDeDados() {
		Pessoas p1 = new Pessoas(null, "Joao", "402.636.418-64", "25/03/1992");
		Pessoas p2 = new Pessoas(null, "Pedro", "402.636.418-64", "25/03/1992");
		Pessoas p3 = new Pessoas(null, "Rafael", "402.636.418-64", "25/03/1992");

		
		Contatos c1 = new Contatos(null, "Felipe", "36223887", "felipe@hotmail.com", p2);
		Contatos c2 = new Contatos(null, "Gustavo", "36223887", "felipe@hotmail.com", p2);
		Contatos c3 = new Contatos(null, "Anderlan", "36223887", "felipe@hotmail.com", p2);
		Contatos c4 = new Contatos(null, "Amanda", "36223887", "felipe@hotmail.com", p3);
		Contatos c5 = new Contatos(null, "Isabel", "36223887", "felipe@hotmail.com", p3);

		p2.getContatos().addAll(Arrays.asList(c1, c2, c3));
		p3.getContatos().addAll(Arrays.asList(c4, c5));

		this.pessoasRepository.saveAll(Arrays.asList(p1, p2, p3));
		this.contatosRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
	}

}
