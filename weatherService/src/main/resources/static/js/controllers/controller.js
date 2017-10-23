
app.controller("generalControlador",  ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    
    self.formSubscribirse = false;
    self.menuLogueo = false;
    self.botonSubscribirse = true;
    
    self.user={id:null,nombre:'',email:''};
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
     
    self.createUser = function(user){
        UserService.createUser(user)
	              .then(
	            		  self.mostrarMenuLogueo(), 
			              function(errResponse){
				               console.error('Error while creating User.');
			              }	
            );
    };

   self.updateUser = function(user, id){
        UserService.updateUser(user, id)
	              .then(
	            		  self.mostrarMenuLogueo(), 
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

    self.submit = function() {
        if(self.user.id==null){
            console.log('Saving New User', self.user);    
            self.createUser(self.user);
        }else{
            self.updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
        }
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
    
    self.mostrarMenuLogueo = function(){
    	console.log('mostrar menu logueo')
    	self.menuLogueo = !self.menuLogueo; 
    	self.formSubscribirse = !self.formSubscribirse;
    }

}]);
