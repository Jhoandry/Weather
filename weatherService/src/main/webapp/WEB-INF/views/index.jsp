<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="weatherService">
<head>
	<meta charset="utf-8">
	<title>Weather</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>	
	<!-- Loading third party fonts -->
	<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
	<link href="<c:url value='css/bootstrap.min.css' />" rel="stylesheet"></link
	<!-- Loading main css file -->
	<link rel="stylesheet" href="<c:url value='css/style.css' />">
	<script src="<c:url value='js/app.js' />"></script>
    <script src="<c:url value='js/services/userService.js' />"></script>
    <script src="<c:url value='js/controllers/controller.js' />"></script>
    
</head>
<body ng-controller="generalControlador as GC">
	
	<div class="site-content">
		<div class="site-header">
			<div class="container">
				<a href="" class="branding">
					<img src="images/logo.png" alt="" class="logo" >
					<div class="logo-type">
						<h1 class="site-title">WS</h1>
						<small class="site-description">Jhoandry Sequera</small>
					</div>
				</a>
				<!-- Default snippet for navigation -->
				<div class="main-navigation">
					<button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
					<ul class="menu" ng-show='GC.botonSubscribirse'>
							<li class="menu-item current-menu-item"><a ng-click='GC.mostrarFormLogueo()'>Login</a></li>
							<li class="menu-item current-menu-item"><a ng-click='GC.mostrarFormSubscribirse()'>Subscrirse</a></li>
					</ul>
					<ul class="menu"  ng-show='GC.menu'>
							<li class="menu-item current-menu-item"><a>{{GC.user.nombre}}</a></li>
<!-- 						<li class="menu-item"><a href="">Modificar Datos</a></li> -->
							<li class="menu-item current-menu-item"><a ng-click='GC.salir()'>Salir</a></li>
					</ul>
					<div ng-show='GC.formSubscribirse' align="right" id="formSubscribirse">
						<form  ng-submit="GC.submitSubscribirse()" name="myForm" method="POST" >
						    <input type="text" ng-model="GC.user.nombre" placeholder="Nombre" required>
							<input type="email"  ng-model="GC.user.email" placeholder="Email" required>
							<button type="submit" >Ok</button>							
						</form>
						<a  ng-click='GC.salir()' >Cancelar</a>
					</div>
					<div ng-show='GC.formLogin' align="right" id="formLogin">
						<form  ng-submit="GC.submitLogin()" name="myForm" method="POST" >
							<input type="text" ng-model="GC.user.nombre" placeholder="Nombre" required>
							<button type="submit" >Ok</button>
							
						</form>
						<a  ng-click='GC.salir()' >Cancelar</a>
					</div>
				</div> <!-- .main-navigation -->

				<div class="mobile-navigation"></div>
			</div>		
		</div> <!-- .site-header -->
		<div class="row hero" data-bg-image="images/banner.png">
		
			<div class="container col-sm-10" >
				<form ng-submit="GC.getLocation()" class="find-location">
					<input type="text" ng-model="GC.location" placeholder="buscar locacion...">
					<input type="submit" value="Buscar">
				</form>
				<br/>
				<div class="">
					<table class="table table-striped" ng-show='GC.locations.length > 0'>
						<thead>
					    	<tr>
					      		<th width="50%;">Distrito - Ciudad <br/>Provincia - Estado</th>
						  		<th width="25%;">Pais</th>
						  		<th width="25%;">WOEID</th>
					      	</tr>
					    </thead>
					    <tbody>
					      	<tr ng-repeat="place in GC.locations" >					      	
						      		<td ng-click="GC.getWeatherLocation(place.woeid)">{{place.name}} <br/> {{place.admin1.content}}</td>
						    		<td ng-click="GC.getWeatherLocation(place.woeid)">{{place.country.content}}</td>
						    		<td ng-click="GC.getWeatherLocation(place.woeid)">{{place.woeid}}</td>
						      					   			
					  		</tr>
					    </tbody>
					</table>
					
				</div>
			</div>		
			<br/>
			<div class="container col-sm-10">
				<div class="forecast-table" ng-show='GC.climaLocation.forecast.length > 0' align="center">
						<div class="forecast-container">
							<div class="today forecast">
								<div class="forecast-header">
									<div class="day">{{GC.climaLocation.forecast[0].day}}</div>
									<div class="date">{{GC.climaLocation.forecast[0].date}}</div>
								</div> <!-- .forecast-header -->
								<div class="forecast-content">
									<div class="location">{{GC.locationFind.city}}</div>
									<div class="degree">
										<div class="num">{{GC.climaLocation.condition.temp}}<sup>o</sup>C</div>
										<div class="forecast-icon">
											<img ng-src="{{GC.getIcon(GC.climaLocation.condition.code)}}" alt="" width=90>
										</div>	
										<span>{{GC.climaLocation.condition.text}}</span>
									</div>
									<span><img src="images/cold.png" width=20>{{GC.climaLocation.forecast[0].high}}</span>
									<span><img src="images/hot.png" width=20>{{GC.climaLocation.forecast[0].low}}</span>
								</div>
							</div>
							<div class="forecast"  ng-repeat="clima in GC.climaLocation.forecast track by $index" ng-show ='$index > 0'>
									<div class="forecast-header">
										<div class="day">{{clima.day}}</div>
									</div> <!-- .forecast-header -->
									<div class="forecast-content">
										<div class="forecast-icon">
											<img ng-src="{{GC.getIcon(clima.code)}}" alt="" width=44>
										</div>
										<div class="degree">
											<div align="right"><img src="images/cold.png" style="float: left;" width=25></div>
											<div align="center">{{clima.high}}<sup>o</sup>C</div>
										</div>
										<div class="degree">
											<div align="right"><img src="images/hot.png" style="float: left;" width=25></div>
											<div align="center">{{clima.low}}<sup>o</sup>C</div>
										</div>
									</div> 
									<small>{{clima.text}}</small>
							</div>											
						</div>
				</div>
			</div>
        	        	
		</div>
	</div>
	
	
<!-- 	MENSAJES DE ALERTA -->

<!-- 	<div class="alert alert-success"> -->
<!-- 	  <button type="button" class="close" data-dismiss="alert">&times;</button> -->
<!-- 	  <strong>¡Cuidado!</strong> Es muy importante que leas este mensaje de alerta. -->
<!-- 	</div> -->

<!-- 			<div class=""> -->
<!--         		<h3>usuarios</h3> -->
<!-- 				<ul> -->
<!-- 					<li ng-repeat="usuario in GC.users"> -->
<!-- 						{{usuario.nombre}} - <strong>{{usuario.email}}</strong> -->
<!-- 					</li> -->
<!-- 				</ul> -->
<!--         	</div> -->
<!-- FIN MENSAJES ALERTA -->




</body>
</html>