package com.weather.weatherService.repositories;

import org.springframework.data.repository.CrudRepository;

import com.weather.weatherService.models.People;

public interface PeopleRepository extends CrudRepository<People, Integer> {

}
