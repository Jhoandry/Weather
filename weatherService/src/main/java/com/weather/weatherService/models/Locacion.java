package com.weather.weatherService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locacion")
public class Locacion {
	@Id
	private Integer woeid;
	private String city;
	private String country;
	private String region;
	
	public Locacion(Integer woeid, String city, String country, String region) {
		this.woeid = woeid;
		this.city = city;
		this.country = country;
		this.region = region;
	}

	public Integer getWoeid() {
		return woeid;
	}
	public void setWoeid(Integer woeid) {
		this.woeid = woeid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

}
