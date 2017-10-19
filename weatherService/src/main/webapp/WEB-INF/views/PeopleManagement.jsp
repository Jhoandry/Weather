<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

    <link href="<c:url value='css/style.css' />" rel="stylesheet"></link>
</head>
 <body>
	<div class="row">
		<div class="content-wrapper full-page-wrapper d-flex align-items-center">
	    	<div class="card col-lg-4 offset-lg-4">
	        	<div class="card-block">
	        		<div align="center">
	        			<h1>Weather Service</h1>
	        		</div>
					<st:form action="validarlogin">
		                <div class="form-group">
		                  <div class="input-group">
		                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
		                    <input type="text" name="usuario" class="form-control p_input" placeholder="Usuario">		                    
		                  </div>
		                </div>
		                <div class="form-group">
		                  <div class="input-group">
		                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
		                    <input type="password" name="password" class="form-control p_input" placeholder="Contraseña">
		                  </div>
		                </div>
		                <div class="text-center">
		                  <button type="submit" class="btn btn-primary">Login</button>
		                </div>
	              	</st:form>
	            </div>
	        </div>
		</div>
	</div>
      

  </body>
</html>