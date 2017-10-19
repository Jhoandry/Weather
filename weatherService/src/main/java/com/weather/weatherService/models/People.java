package com.weather.weatherService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document 
public class People {
	@Id
	private Integer id;
	private String nombre;
	private String usuario;
	
	
	public People(Integer id, String nombre, String usuario) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
	}
	
	public People() {
		this.id = 0;
		this.nombre = "";
		this.usuario = "";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
}
