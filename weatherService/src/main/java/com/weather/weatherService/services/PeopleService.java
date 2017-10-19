package com.weather.weatherService.services;

import java.util.List;

import com.weather.weatherService.models.People;

public interface PeopleService {

	People findById(long id);
	List<People> findAllPeople();
}
