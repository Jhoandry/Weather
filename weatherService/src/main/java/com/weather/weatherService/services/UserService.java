package com.weather.weatherService.services;

import java.util.List;

import com.weather.weatherService.models.User;

public interface UserService {

	User findById(Integer id);
	List<User> findAllUser();
	User saveUser(User person);
	boolean isUserExist(Integer id);
}