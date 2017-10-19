package com.weather.weatherService.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.weather.weatherService.models.People;

public interface PeopleRepository extends MongoRepository<People, Integer> {

}
