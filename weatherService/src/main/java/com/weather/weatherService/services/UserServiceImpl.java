package com.weather.weatherService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.Counter;

import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;
 
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
		person.setId(getNextSequence("user"));
		return userRepository.save(person);
	}

	@Override
	public boolean isUserExist(Integer id) {
		List<User> users = findAllUser();
		for(User user : users) {
			if(user.getId().equals(id))
				return true;
		}
		return false;
	}
	
	//**************************************************
	//**************Metodos Privados********************
	
	private Integer getNextSequence(String collectionName) {
		 
	    Counter counter = mongo.findAndModify(
	      query(where("_id").is(collectionName)), 
	      new Update().inc("seq", 1),
	      options().returnNew(true),
	      Counter.class);
	       
	    return (counter==null? 0 : counter.hashCode());
	  }

}
