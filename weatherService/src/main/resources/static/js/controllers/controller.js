
app.controller("generalControlador",  ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    
    self.formSubscribirse = false;
    self.menu = false;
    self.formLogin = false;
    self.botonSubscribirse = true;
    
    self.user = {email:'',nombre:'', locaciones: []};
    self.location = '';
    self.locations = [];
    self.climalocation = {};
    self.locationFind = { woeid:0, city:'', country:'', region:''}
    self.locacionesFav = [];

    //************* CRUD Usuario ***********************
    
	    self.findUserName = function(email){
	    	UserService.findUserName(email)
	    	.then(
	    		function(data) {
				    self.user = data;
				    if(self.user.email!=""){
				    	self.mostrarMenu();
				    	self.buscarClimaFav();
				    }
			    },
	      		function(errResponse){
			    	console.error('Error while creating User.');
		        });
	    };
	    
	    self.createUser = function(user){
	        UserService.createUser(user)
		    .then(
		          self.mostrarMenu(), 
				  	function(errResponse){
		        	  console.error('Error while creating User.');
				    }	
	        );
	    };
	
	   self.updateUser = function(user, id){
	        UserService.updateUser(user, id)
		              .then(
		            		  self.mostrarMenu(), 
				              function(errResponse){
					               console.error('Error while updating User.');
				              }	
	            );
	    };
	
	   self.deleteUser = function(id){
	        UserService.deleteUser(id)
		              .then(
				              self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while deleting User.');
				              }	
	            );
	    };
	
	    self.submitSubscribirse = function() {
	        if(self.user.id==null){
	            console.log('Saving New User', self.user);    
	            self.createUser(self.user);
	        }else{
	            self.updateUser(self.user, self.user.id);
	            console.log('User updated with id ', self.user.id);
	        }
	    };
	    
	    self.submitLogin = function() {
	    	console.log('find User', self.user.email);      	
	    	self.findUserName(self.user.nombre);
	    };
	        
	//    self.edit = function(id){
	//        console.log('id to be edited', id);
	//        for(var i = 0; i < self.users.length; i++){
	//            if(self.users[i].id == id) {
	//               self.user = angular.copy(self.users[i]);
	//               break;
	//            }
	//        }
	//    };
	        
	//    self.remove = function(id){
	//        console.log('id to be deleted', id);
	//        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
	//           self.reset();
	//        }
	//        self.deleteUser(id);
	//    };
	    
    
    
    
    //**********************Opciones del menu *********************
    
	    self.mostrarFormSubscribirse = function() {
	    	self.formSubscribirse = !self.formSubscribirse;
	    	self.botonSubscribirse = !self.botonSubscribirse;
	    };  
	    
	    self.mostrarMenu = function(){
	    	console.log('mostrar menu')
	    	self.menu = !self.menu; 
	    	self.formSubscribirse = false;
	    	self.formLogin = false;
	    	self.botonSubscribirse = false;
	    };
	    
	    self.mostrarFormLogueo = function(){
	    	console.log('mostrar form loguearse')
	    	self.formLogin = !self.formLogin;
	    	self.botonSubscribirse = !self.botonSubscribirse;
	    };
	    
	    self.salir = function(){
	    	console.log('salir')
	    	self.user = {email:'',nombre:'', locaciones: []};
		    self.location = '';
		    self.locations = [];
		    self.locacionesFav = [];
	    	self.menu = false; 
	    	self.formSubscribirse = false;
	    	self.formLogin = false;
	    	self.botonSubscribirse = true;
	    	self.locacionesFav = [];
	    };

	//**********************Wheater Services*********************
	    self.getIcon = function(cod){
	    	var url= "images/icons/";
	    	if(cod==1 || cod==2 || cod==3 || cod==37 ||cod==0)
	    		return url+"icon-8.svg";
	    	else if(cod==4 || cod==5 || cod==6 || cod==7 || cod==45 || cod==47 || cod==38 || cod==39)
	    		return url+"icon-11.svg";
	    	else if(cod==8 || cod==10 || cod==13 || cod==14 || cod==35 || cod==17 ||cod==18)
	    		return url+"icon-13.svg";
	    	else if(cod==40 || cod==9 || cod==11 || cod==12)
	    		return url+"icon-9.svg";	    	
	    	else if(cod==15 || cod==19 || cod==20 || cod==21 || cod==22 || cod==23 ||cod==24)
		    	return url+"icon-7.svg";
	    	else if(cod==26 || cod==27 || cod==28)
		    	return url+"icon-6.svg";
	    	else if(cod==29 || cod==30 || cod==44)
		    	return url+"icon-3.svg";
	    	else if(cod==31 || cod==32 || cod==33 || cod==34 || cod==36)
	    		return url+"icon-2.svg";
	    	else if(cod==16 || cod==25 || cod==41 || cod==42 || cod==43 || cod==46)
	    		return url+"cold.png";
	    };
	    
	    self.buscarClimaFav = function(){
	    	var x;
	    	self.locacionesFav = [];
    		for (x in self.user.locaciones) {

    			UserService.findWeather(self.user.locaciones[x].woeid)
    	    	.then(
    	    		function(data) {
    				    if(data.query.results != null){
    				    	 self.locacionesFav.push(data.query.results.channel);
    				    }
    			    },
    	      		function(errResponse){
    			    	console.error('Error weatherLocation.');
    		        });
    		}
	    };
	    	    
	    
	    self.weatherLocation = function(woeid){
	    	UserService.findWeather(woeid)
	    	.then(
	    		function(data) {
				    console.log(data);
				    if(data.query.results != null){
				    	self.locationFind.woeid=woeid;
				    	self.locationFind.city= data.query.results.channel.location.city;
				    	self.locationFind.country= data.query.results.channel.location.country;
				    	self.locationFind.region= data.query.results.channel.location.region;
				    	self.climaLocation = data.query.results.channel.item;
				    }
			    },
	      		function(errResponse){
			    	console.error('Error weatherLocation.');
		        });
	    };
	    
	    self.findLocation = function(nombreLocacion){
	    	UserService.findLocation(nombreLocacion)
	    	.then(
	    		function(data) {
				    console.log(data);	
				    if(data.query.results != null)
				    	self.locations = data.query.results.place;
			    },
	      		function(errResponse){
			    	console.error('Error findLocation.');
		        });
	    };
	    
	    self.getWeatherLocation = function(woeid) {
	    	console.log('getWeather function ', woeid );  
	    	self.tablePlace = false;   
	    	self.locations = [];
	    	self.weatherLocation(woeid);
	    };
	    
	    self.getLocation = function(){
	    	console.log('Obteniendo locacion ', self.location);
	        self.locations = [];
	        self.climaLocation = {};
	    	self.findLocation(self.location);
	    };
	    

		//**********************Locaciones Favoritas*********************
	    
	    self.updateLocation = function(user){
	    	UserService.addLocacion(user)
	    	.then(
	    		function(data) {
				    console.log(data);
				    self.user.locaciones = data.locaciones;
				    self.buscarClimaFav();
			    },
	      		function(errResponse){
			    	console.error('Error weatherLocation.');
		        });
	    };
	    
	    self.exiteLocacion = function(){
	    	if(self.user.locaciones.length==0)
	    		return false;
	    	else{
	    		var x;
	    		for (x in self.user.locaciones) {
	    			if(self.user.locaciones[x].woeid==self.locationFind.woeid)
	    				return true;
	    		}
	    	}
	    	return false;
	    };
	    
	    self.setLocacion = function(){
	    	console.log("add locaciones favoritas");    	
	    	self.user.locaciones.push(self.locationFind);
	    	self.updateLocation(self.user);
	    };
	    
	    self.removeLocacion = function(city){
	    	console.log("remove locacion "+ city);
	    	for(var x in self.user.locaciones){
	    		if(self.user.locaciones[x].city==city){
	    	    	delete self.user.locaciones[x];
	    	    	self.user.locaciones.splice(x,1);
	    			break;
	    		}
	    	}
	    	
	    	self.updateLocation(self.user);
	    	
	    };
}]);
