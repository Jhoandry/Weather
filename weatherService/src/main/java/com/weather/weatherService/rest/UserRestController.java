package com.weather.weatherService.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.MediaType;

import com.weather.weatherService.models.Locacion;
import com.weather.weatherService.models.User;
import com.weather.weatherService.services.UserService;

@RestController
public class UserRestController {

	@Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
 

    //-------------------Retrieve All Users--------------------------------------------------------
     
      @RequestMapping(value = "/user/", method = RequestMethod.GET)
      public ResponseEntity<List<User>> listAllUsers() {
          List<User> User = userService.findAllUser();
          if(User.isEmpty()){
              return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
          }
          return new ResponseEntity<List<User>>(User, HttpStatus.OK);
		}
 
 
    
  //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/user/{nombre}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("nombre") String nombre) {
        System.out.println("Fetching User with nomnbre :  " + nombre);
        User person = userService.findByName(nombre);
        if (person == null) {
            System.out.println("User with name " + nombre + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(person, HttpStatus.OK);
    }
 
    
  //-------------------Create a User--------------------------------------------------------
    
    @RequestMapping(method=RequestMethod.POST, value="/user/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {

    	System.out.println("Creating User " + user.getNombre());
    		 
	        if (userService.isUserExist(user.getEmail())) {
	            System.out.println("A User with name " + user.getNombre() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        userService.saveUser(user);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getEmail()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
         
  //-------------------Create a User--------------------------------------------------------
    
    @RequestMapping(value = "/user/places", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Locacion>> getPlaces(@PathVariable("email") String email) {
        System.out.println("Fetching locaciones de :  " + email);
        List<Locacion> locaciones = userService.findLocacionesFav(email);
        if(locaciones.isEmpty()){
            return new ResponseEntity<List<Locacion>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Locacion>>(locaciones, HttpStatus.OK);
    }
}	
