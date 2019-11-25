package com.example.demo.controller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;



@Entity
public class Professor{	
	
	@Id
	@GeneratedValue
	
	
	private Long id;
	
	@NotBlank(message = "data é obrigatório")
	@Column
	private String data;
	
	@NotBlank(message = "intervalo é obrigatório")
	@Column
	private String intervalo;
	
	@NotNull(message = "nome é obrigatório")
	@Column
	private String nome;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(String intervalo) {
		this.intervalo = intervalo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data; 
	}
	
}
