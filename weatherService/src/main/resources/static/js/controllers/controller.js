
app.controller("generalControlador",  ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    
    self.formSubscribirse = false;
    self.menu = false;
    self.formLogin = false;
    self.botonSubscribirse = true;
    
    self.user={nombre:'',email:''};
    self.users=[];
        
    self.fetchAllUsers = function(){
        UserService.fetchAllUsers()
            .then(
					       function(d) {
						        self.users = d;
					       },
      					function(errResponse){
      						console.error('Error while fetching Currencies');
      					}
			       );
    };
    self.findUserName = function(email){
    	UserService.findUserName(email)
    	.then(
    		function(data) {
			    self.user = data;
			    if(self.user.email!="")
			    	self.mostrarMenu();
		    },
      		function(errResponse){
		    	console.error('Error while creating User.');
	        }	
  );
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

    self.fetchAllUsers();

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
        
    self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id == id) {
               self.user = angular.copy(self.users[i]);
               break;
            }
        }
    };
        
    self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
           self.reset();
        }
        self.deleteUser(id);
    };
    
    self.reset = function(){
        self.user={id:null,nombre:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    };
    
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
    	self.user={nombre:'',email:''};
    	self.menu = false; 
    	self.formSubscribirse = false;
    	self.formLogin = false;
    	self.botonSubscribirse = true;
    };

}]);
