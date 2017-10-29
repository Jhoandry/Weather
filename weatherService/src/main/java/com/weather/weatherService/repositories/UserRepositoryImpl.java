package com.weather.weatherService.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.weather.weatherService.models.Locacion;
import com.weather.weatherService.models.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	MongoOperations mongoOperations;
	
	@Override
	public User finUserName(String nombre) {
		Query query = new Query(Criteria.where("nombre").is(nombre));
		// search operation
			User user = (User) mongoOperations.findOne(query, User.class);
			System.out.println("##################  finUserEmail");
			System.out.println(user.toString());
			
		return user;
	}

	@Override
	public List<User> findAllUser() {
		List<User> users =  mongoOperations.findAll(User.class);
		System.out.println("################## findAllUsers");
		System.out.println(users.size());
		
		return users;
	}

	@Override
	public User saveUser(User user) {
		System.out.println("################## saveUser");
		mongoOperations.save(user);
		
		return user;
	}

}
