package com.weather.weatherService.models;


public class People {
	
	private long id;
	private String nombre;
	
	
	public People(long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public People() {
		this.id = 0;
		this.nombre = "";
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
