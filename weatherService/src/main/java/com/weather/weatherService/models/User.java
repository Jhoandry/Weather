package com.weather.weatherService.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "user")
public class User {
	@Id
	private String nombre;
	private String email;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<Locacion> locaciones;
	
	public User(String nombre, String email, List<Locacion> locaciones) {
		this.nombre = nombre;
		this.email = email;
		this.locaciones = locaciones;
	}
	
	public User() {
		this.nombre = "";
		this.email = "";
		this.locaciones = new ArrayList<Locacion>();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Locacion> getLocaciones() {
		return locaciones;
	}

	public void setLocaciones(List<Locacion> locaciones) {
		this.locaciones = locaciones;
	}
	
	
}