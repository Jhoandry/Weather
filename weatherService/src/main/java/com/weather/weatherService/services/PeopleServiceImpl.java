package com.weather.weatherService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weather.weatherService.models.People;

@Service("PeopleService")

public class PeopleServiceImpl implements PeopleService {

	List<People> people = generarUsuarios();
	
	@Override
	public People findById(long id) {
		
		for(People person : this.people) {
			if(person.getId() == id)
				return person;
		}
		return null;
	}

	@Override
	public List<People> findAllPeople() {
		return this.people;
	}

	
	//metodos privados 
	
	private List<People> generarUsuarios(){
		List<People> people = new ArrayList<People>();
		
		people.add(new People(0,"Andres"));
		people.add(new People(1,"Adolfo"));
		people.add(new People(2,"Emil"));
		people.add(new People(3,"Exiober"));
		people.add(new People(4,"Arnaldo"));
		
		return people;
	}
}
