package com.weather.weatherService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.weather.weatherService.models.Locacion;
import com.weather.weatherService.models.User;
import com.weather.weatherService.repositories.GeneralRepository;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private GeneralRepository userRepository;
	
	@Override
	public List<User> findAllUser() {
		List<User> User = new ArrayList<User>();
		userRepository.findAllUser().forEach(User::add);
		
		return User;
	}

	@Override
	public User saveUser(User person) {
		List<User> User = findAllUser();
		return userRepository.saveUser(person);
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

	@Override
	public User findByName(String nombre) {
		User user = new User();
		try {
			user = userRepository.finUserName(nombre);
		}catch(Exception e) {
			user = new User();
		}
		
		return user;
	}

	@Override
	public User setLocacion(User user) {
		user = userRepository.setLocacion(user);
		return user;
	}
	

	
}
