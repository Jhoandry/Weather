package com.weather.weatherService.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.weather.weatherService.models.People;
import com.weather.weatherService.services.PeopleService;

@RestController
public class PeopleRestController {

	@Autowired
    PeopleService peopleService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<People>> listAllUsers() {
        List<People> people = peopleService.findAllPeople();
        if(people.isEmpty()){
            return new ResponseEntity<List<People>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<People>>(people, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<People> getUser(@PathVariable("id") Integer id) {
        System.out.println("Fetching User with id " + id);
        People person = peopleService.findById(id);
        if (person == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<People>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<People>(person, HttpStatus.OK);
    }
 
     
     
	
}
