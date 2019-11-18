package com.example.demo.controller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Professor{	
	
	@Id
	@GeneratedValue
	
	
	private Long id;
	
	@Column
	@NotNull(message = "data é obrigatório")
	private String data;
	
	@Column
	@NotNull(message = "intervalo é obrigatório")
	private String intervalo;
	
	@Column
	@NotNull(message = "nome é obrigatório")
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
