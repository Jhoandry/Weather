<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="weatherService">
<head>
	<meta charset="utf-8">
	<title>Weather</title>
	<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>	
	<link href="<c:url value='css/style.css' />" rel="stylesheet"></link>
	<link href="<c:url value='css/bootstrap.min.css' />" rel="stylesheet"></link>
    <script src="<c:url value='js/app.js' />"></script>
    <script src="<c:url value='js/services/userService.js' />"></script>
    <script src="<c:url value='js/controllers/controller.js' />"></script>
    <!-- Custom styles for this template -->
    <style>
      body {
        padding-top: 54px;
      }
      @media (min-width: 992px) {
        body {
          padding-top: 56px;
        }
      }

    </style>
</head>
<body class="ng-cloak" ng-controller="generalControlador as GC">
								
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    	<div class="container">
        	<a class="navbar-brand" href="#">Weather Service</a>
        	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          		<span class="navbar-toggler-icon"></span>
        	</button>
	        <div class="collapse navbar-collapse" id="navbarResponsive">
	        	<ul class="navbar-nav ml-auto" ng-show='GC.botonSubscribirse'>
	            	<li class="nav-item active">
	              		<a class="nav-link" ng-click='GC.mostrarFormSubscribirse()'>Subscribete
	                		<span class="sr-only">(current)</span>
	              		</a>
	            	</li>
	          	</ul>
	          	<ul class="navbar-nav ml-auto" ng-show='GC.menuLogueo'>
	          		<li class="nav-item">
		              	<a class="nav-link" >{{GC.user.nombre}}</a>
		            </li>
	            	<li class="nav-item">
		              	<a class="nav-link" >Modificar Mail</a>
		            </li>
		            <li class="nav-item">
		              	<a class="nav-link" >Salir</a>
		            </li>
	          	</ul>
	        </div>
	        <div class="col-lg-6 navbar-right" ng-show='GC.formSubscribirse' align="right" id="formSubscribirse">
				<form class="form-inline my-2 my-lg-0" ng-show='GC.formSubscribirse' ng-submit="GC.submit()" name="myForm" method="POST" >
				    <input type="text" class="form-control mr-sm-3" ng-model="GC.user.nombre" placeholder="Nombre">
					<input type="email" class="form-control mr-sm-3" ng-model="GC.user.email" placeholder="Email">
					<button type="submit" class="btn btn-outline-success my-2 my-sm-0">Ok</button>
				</form>
			</div>
      	</div>
    </nav>


	<!-- Page Content -->
    <div class="container">
    	<div class="row">
        	<div class="col-lg-12 text-center">
        		<h3>usuarios</h3>
				<ul>
					<li ng-repeat="usuario in GC.users">
						{{usuario.nombre}} - <strong>{{usuario.email}}</strong>
					</li>
				</ul>
        	</div>
        </div>
	</div>
  </body>
</html>