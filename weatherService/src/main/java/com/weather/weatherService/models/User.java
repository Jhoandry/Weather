package com.weather.weatherService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	@Id
	private String email;
	private String nombre;
	

	
	public User(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
	}
	
	public User() {
		this.nombre = "";
		this.email = "";
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
	@Override
	public String toString() {
		return String.format("[email = %s, nombre = %s]", this.getEmail(), this.getNombre());
	}
	
}
