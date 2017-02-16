<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

 <spring:message var="nombreApp" scope="request" code="aplicacion.nombre" />  
   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	  	 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>${nombreApp} - ${seccion} </title>
</head>
<body>
<header>
	<nav class="navbar navbar-inverse bg-primary" >
	  	<div class="container-fluid">
		    <div class="navbar-header">
		    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>                        
		      </button>
		    	<a class="navbar-brand" href="/gestiondocente">${nombreApp}</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
				
					<li>
						<a href="<c:url value='/alumnos'/>">
							<spring:message code="menu.alumnos" text="G.Alumnos" />
						</a>
					</li>
					<li>
						<a href="<c:url value='/profesores'/>">
							<spring:message code="menu.profesores" text="G.Profesores" />
						</a>
					</li>
					<li>
						<a href="<c:url value='/clientes'/>">
							<spring:message code="menu.clientes" text="G.Clientes" />
						</a>
					</li>
				</ul>
			
				<ul class="nav navbar-nav navbar-right">
					
						<a href="?locale=es">				
							<spring:message code="idioma.castellano" />
						</a>
						<a href="?locale=en">
							<spring:message code="idioma.ingles" />
						</a>
						<a href="?locale=eu">
							<spring:message code="idioma.euskera" />
						</a>
					
				</ul>
			</div>	
		</div>
	</nav>
	<div class="container">
	<h1>${seccion}</h1>
	</div>
</header>