package com.weather.weatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.weather.weatherService.mongodb.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class WeatherServiceApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WeatherServiceApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}
	
}
