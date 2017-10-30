package com.weather.weatherService.repositories;

import java.util.List;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weather.weatherService.models.User;
import com.weather.weatherService.models.Locacion;;

@RepositoryRestResource
public interface GeneralRepository  {
	
	User finUserName(String nombre);
	List<User> findAllUser();
	User saveUser(User user);
	User setLocacion(User user);

}
