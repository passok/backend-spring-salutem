package com.leonardo.salutem.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "tb_contatos")
public class Contatos implements Serializable{		
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@NotNull(message = "{campo.telefone.obrigatorio}")
	private String telefone;
	
	@NotNull(message = "{campo.email.obrigatorio}")
	private String email;
	
	@ManyToOne
	private Pessoas pessoas;

	public Contatos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contatos(Long id, @NotEmpty(message = "{campo.nome.obrigatorio}") String nome,
			@NotNull(message = "{campo.telefone.obrigatorio}") String telefone,
			@NotNull(message = "{campo.email.obrigatorio}") String email, Pessoas pessoas) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.pessoas = pessoas;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pessoas getPessoas() {
		return pessoas;
	}

	public void setPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	

}
