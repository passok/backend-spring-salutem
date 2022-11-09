package com.leonardo.salutem.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_pessoas") 
public class Pessoas implements Serializable{		
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@NotEmpty(message = "{campo.cpf.obrigatorio}")
	//@CPF(message = "{campo.cpf.invalido}")
	private String cpf;
	
	@NotEmpty(message = "{campo.data.obrigatorio}")
	private String data;
	
	@JsonIgnore
    @OneToMany(mappedBy = "pessoas")
	private List<Contatos> contatos =  new ArrayList<>();

	public Pessoas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pessoas(Long id, @NotEmpty(message = "{campo.nome.obrigatorio}") String nome,
			@NotEmpty(message = "{campo.cpf.obrigatorio}") String cpf,
			@NotEmpty(message = "{campo.data.obrigatorio}") String data) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Contatos> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contatos> contatos) {
		this.contatos = contatos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
	

}
