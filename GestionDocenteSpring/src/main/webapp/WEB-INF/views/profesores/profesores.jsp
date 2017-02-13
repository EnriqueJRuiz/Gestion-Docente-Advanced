<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<spring:message var="seccion" code="profesores.titulo" />   
<c:set scope="request" var="seccion" value="${seccion}"/>
<c:import url="../includes/header.jsp"/>
	<main>
		<a href="profesores/addProfesor">Crear profesor</a>
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
				 		<c:when test="${not empty listadoProfesores}">	
				 			<c:forEach var="profesor" items="${listadoProfesores}">
				 				<tr>
					 				<td>${profesor.nombre}</td> 
					 				<td>${profesor.apellidos}</td> 
					 				<td>
					 					<a href="profesores/">Editar</a>
					 					<a href="profesores/deleteProfesor/">Borrar</a>
					 				</td>
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