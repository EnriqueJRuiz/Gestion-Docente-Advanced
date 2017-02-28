<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

 <spring:message var="nombreApp" scope="request" code="aplicacion.nombre" />  
   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<title>${nombreApp} - ${seccion} </title>
</head>
<body >
<header>

	<nav class="navbar navbar-toggleable-md navbar-inverse bg-primary fixed-top">
	  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <a class="navbar-brand"  href="/gestiondocente">${nombreApp}</a>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/alumnos'/>" >
				<spring:message code="menu.alumnos" text="G.Alumnos" />
			</a>
	      </li>
	      <li class="nav-item">
	        <a  class="nav-link" href="<c:url value='/profesores'/>">
				<spring:message code="menu.profesores" text="G.Profesores" />
			</a>
	      </li>
	      <li class="nav-item">
	        <a  class="nav-link" href="<c:url value='/clientes'/>">
				<spring:message code="menu.clientes" text="G.Clientes" />
			</a>
	      </li>
	      <li class="nav-item">
	        <a  class="nav-link" href="<c:url value='/cursos'/>">
				<spring:message code="menu.cursos" text="G.Cursos" />
			</a>
	      </li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
					<a class="nav-link" href="?locale=es">				
 						<spring:message code="idioma.castellano" />
 					</a>
 					<a class="nav-link" href="?locale=en">
 						<spring:message code="idioma.ingles" />
 					</a>
 					<a class="nav-link" href="?locale=eu">
 						<spring:message code="idioma.euskera" />
 					</a>
 			</ul>
	  </div>
	</nav>
	<div class="container">
	<h1 class="display-5" style="margin-top: 55px">${seccion}</h1>
	</div>
</header>