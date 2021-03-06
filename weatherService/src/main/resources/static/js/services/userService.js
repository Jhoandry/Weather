'use strict';

app.factory('UserService', ['$http', '$q', function($http, $q){

	return {
		    
		    createUser: function(user){
					return $http.post('http://localhost:8080/user/', user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    addLocacion : function(user){
		    	console.log(user);
		    	return $http.put('http://localhost:8080/locaciones/', user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating user');
										return $q.reject(errResponse);
									}
							);
			},
			
			findUserName: function(nombre){
				return $http.post('http://localhost:8080/user/'+nombre, nombre)
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while creating user');
									return $q.reject(errResponse);
								}
						);
		    },
		    
		    findWeather : function(woeid) {
		    	
		    	 var searchtext = "select * from weather.forecast where woeid="+woeid+" and u='c'"
	    	     return $http.get("https://query.yahooapis.com/v1/public/yql?q=" + searchtext + "&format=json")
		    	       .then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Error find weather');
									return $q.reject(errResponse);
								}
						);
		    },
		    
		    findLocation : function(nombreLocacion){
		    	var searchText = "select * from geo.places where text='"+nombreLocacion+"*'";
		    	return $http.get("https://query.yahooapis.com/v1/public/yql?q=" + searchText + "&format=json")
		    	 		.then(
		    	 				function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Error find location');
									return $q.reject(errResponse);
								}
		    	 		
		    	 		);
		    }
		
	};

}]);
