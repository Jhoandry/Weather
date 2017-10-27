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
	private String email;
	
	public Locacion(Integer woeid, String city, String country, String region, String email) {
		this.woeid = woeid;
		this.city = city;
		this.country = country;
		this.region = region;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("[woeid:%i, city:%s, country:%s, region:%s, email:%s]", this.getWoeid(), this.getCity(), this.getCountry(), this.getRegion(), this.getEmail());
	}

}
