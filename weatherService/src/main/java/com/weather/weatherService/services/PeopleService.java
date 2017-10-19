package com.weather.weatherService.services;

import java.util.List;

import com.weather.weatherService.models.People;

public interface PeopleService {

	People findById(Integer id);
	List<People> findAllPeople();
	People savePerson(People person);
}
