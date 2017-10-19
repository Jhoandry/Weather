package com.weather.weatherService.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weather.weatherService.models.People;

@RepositoryRestResource
public interface PeopleRepository extends MongoRepository<People, Integer> {

}
