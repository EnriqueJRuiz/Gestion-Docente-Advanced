<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion Docente - Listado Profesor</title>
</head>
<body>
	<header>
		<h1>Gestion Docente - Listado Profesor</h1>
	</header>
	<main>
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
				 		<c:when test="${not empty listadoProfesores}">	<!-- alumnoController -->
				 			<c:forEach var="profesor" items="${listadoProfesores}">
				 				<tr>
					 				<td>${profesor.nombre}</td> 
					 				<td>${profesor.apellidos}</td> 
					 				<td><a href="">modificar</a></td>
					 			</tr>	
				 			</c:forEach>	
				 		</c:when>
				 		<c:otherwise>
				 			<td colspan="3">No se han encontrado profesores en la Base de Datos</td>
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