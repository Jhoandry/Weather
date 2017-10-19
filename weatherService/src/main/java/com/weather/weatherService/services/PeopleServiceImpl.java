package com.weather.weatherService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.weatherService.models.People;
import com.weather.weatherService.repositories.PeopleRepository;

@Service("PeopleService")

public class PeopleServiceImpl implements PeopleService {

	@Autowired
	private PeopleRepository peopleRepository;
	
	@Override
	public People findById(Integer id) {
		return peopleRepository.findOne(id);
	}

	@Override
	public List<People> findAllPeople() {
		return (List<People>) peopleRepository.findAll();
	}

	@Override
	public People savePerson(People person) {
		return peopleRepository.save(person);
	}

	

}
