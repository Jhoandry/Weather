package com.weather.weatherService.services;

import java.util.List;

import com.weather.weatherService.models.Locacion;
import com.weather.weatherService.models.User;

public interface UserService {

	User findByName(String nombre);
	List<User> findAllUser();
	User saveUser(User person);
	boolean isUserExist(String email);
}
