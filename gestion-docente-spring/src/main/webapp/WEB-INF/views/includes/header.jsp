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
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
		<spring:url var="misEstilos" value="/resources/css/styles.css"  />
		<link rel="stylesheet" href='${misEstilos}'>
		<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<!--[if lt IE 9]>
			  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<![endif]-->
		
	<title>${nombreApp} - ${seccion} </title>
</head>
<body >
	<header class="container-fluid">
	<div class="row">
		<nav class="navbar navbar-inverse navbar-fixed-top">
		  	
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
				      	<a href="<c:url value='/alumnos'/>" >
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
				      <li>
				        <a href="<c:url value='/cursos'/>">
							<spring:message code="menu.cursos" text="G.Cursos" />
						</a>
				      </li>
				    </ul>
				    	
				    		<ul class="nav navbar-nav navbar-right  btn-group">
					    		<li class="dropdown">
				        			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				        			Idioma<span class="caret"></span>
				        			</a>
				       			 	<ul class="dropdown-menu">
										<li>
											<a class="nav-link" href="?locale=es">				
					 							<spring:message code="idioma.castellano" />
					 						</a>
					 					</li>	
					 					<li>
					 						<a class="nav-link" href="?locale=en">
					 							<spring:message code="idioma.ingles" />
					 						</a>
					 					</li>	
					 					<li>
					 						<a class="nav-link" href="?locale=eu">
					 							<spring:message code="idioma.euskera" />
					 						</a>
					 					</li>
					 				</ul>
						 		</li>
					 		</ul>
			 			</div>
			 		
			  
		</nav>
		</div>
		<div class="row lead">
		<h1 class="col-xs-12"><samp class="text-center text-uppercase">${seccion}</samp></h1>
		</div>
	</header>