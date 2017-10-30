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
public class GeneralRestController {

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
    public ResponseEntity<User> createUser(@RequestBody User user) {

    	System.out.println("Creating User " + user.getNombre());
    		 
	        if (userService.isUserExist(user.getEmail())) {
	            System.out.println("A User with name " + user.getNombre() + " already exist");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }else {
	        	user= userService.saveUser(user);
		        return new ResponseEntity<User>(user, HttpStatus.OK);
	        }
	 	        
	    }
         
//-------------------Update Location--------------------------------------------------------
    
    @RequestMapping(method=RequestMethod.PUT, value="/locaciones/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> setLocacion(@RequestBody User user) {

    	System.out.println("add Locaciones" + user.getNombre());
        user = userService.setLocacion(user);

        return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}	
