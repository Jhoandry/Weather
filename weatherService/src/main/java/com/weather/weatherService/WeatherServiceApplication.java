package com.weather.weatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.weather.weatherService.models.People;
import com.weather.weatherService.repositories.PeopleRepository;

@SpringBootApplication
public class WeatherServiceApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WeatherServiceApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}
	
}
