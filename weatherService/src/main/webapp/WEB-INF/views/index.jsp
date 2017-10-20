<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="weatherService">
<head>
	<meta charset="utf-8">
	<title>Weather</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="<c:url value='js/app.js' />"></script>
    <script src="<c:url value='js/services/userService.js' />"></script>
    <script src="<c:url value='js/controllers/controller.js' />"></script>
</head>
<body class="ng-cloak" ng-controller="generalControlador as GC">
	<div class="row">
		<div class="content-wrapper full-page-wrapper d-flex align-items-center">
	    	<div class="card col-lg-4 offset-lg-4">
	        	<div class="card-block">
	        		<div align="center">
	        			<h1>Weather Service</h1>
	        		</div>
					<form ng-submit="GC.submit()" name="myForm" method="POST">
		                <div class="form-group">
		                  <div class="input-group">
		                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
		                    <input type="text" ng-model="GC.user.nombre" class="form-control p_input" placeholder="Nombre">		                    
		                  </div>
		                </div>
		                <div class="form-group">
		                  <div class="input-group">
		                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
		                    <input type="text" ng-model="GC.user.email" class="form-control p_input" placeholder="email">
		                  </div>
		                </div>
		                <div class="text-center">
		                  <button type="submit" class="btn btn-primary">Login</button>
		                </div>
	              	</form>
	            </div>
	            <div>
	            	<h3>usuarios</h3>
					<ul>
						<li ng-repeat="usuario in GC.users">
							{{usuario.nombre}} - <strong>{{usuario.email}}</strong>
						</li>
					</ul>
	            </div>
	        </div>
		</div>
	</div>
      

  </body>
</html>