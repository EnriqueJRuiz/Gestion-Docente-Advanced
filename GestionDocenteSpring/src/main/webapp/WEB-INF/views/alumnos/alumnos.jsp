<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Gestion Docente - Listado Alumnos</title>
</head>
<body>
	<header>
		<h1>Gestion Docente - Listado Alumnos</h1>
	</header>
	<main>
		<a href="alumnos/addAlumno">Crear alumno</a>
		<table id="table-1" border="2">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellidos</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				 	<c:choose>
				 		<c:when test="${not empty listadoAlumnos}">	<!-- alumnoController -->
				 			<c:forEach var="alumno" items="${listadoAlumnos}">
				 				<tr>
					 				<td>${alumno.nombre}</td> 
					 				<td>${alumno.apellidos}</td> 
					 				<td>
					 					<a href="alumnos/${alumno.codigo}">Editar</a><!--  URL CANONICAS -->
					 					<a href="alumnos/deleteAlumno/${alumno.codigo}">Borrar</a>
					 				</td>
					 			</tr>	
				 			</c:forEach>	
				 		</c:when>
				 		<c:otherwise>
				 			<td colspan="3">No se han encontrado alumnos en la Base de Datos</td>
				 		</c:otherwise>
				 	</c:choose>
				</tbody>
			</table>
		</main>
	<footer>
		<p>Creado por Enrique J. Ruiz</p>
	</footer>
</body>
</html>