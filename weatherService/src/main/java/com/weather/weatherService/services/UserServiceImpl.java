package com.weather.weatherService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.weather.weatherService.models.User;
import com.weather.weatherService.repositories.UserRepository;

@Service("UserService")

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private MongoOperations mongo;
	
	@Override
	public User findById(Integer id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAllUser() {
		List<User> User = new ArrayList<User>();
		userRepository.findAll().forEach(User::add);
		
		return User;
	}

	@Override
	public User saveUser(User person) {
		List<User> User = findAllUser();
		return userRepository.save(person);
	}

	@Override
	public boolean isUserExist(String email) {
		List<User> users = findAllUser();
		for(User user : users) {
			if(user.getEmail().equals(email))
				return true;
		}
		return false;
	}
	
}
