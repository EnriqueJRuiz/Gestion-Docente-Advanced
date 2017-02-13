<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
  
<spring:message var="seccion" code="alumnos.titulo" />
<c:set scope="request" var="seccion" value="${seccion}"/>

<c:import url="../includes/header.jsp"/>
	<main>
		<a href="<c:url value='alumnos/addAlumno'/>">Crear alumno</a>
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
					 					<a href="<c:url value='alumnos/${alumno.codigo}'/>">Editar</a><!--  URL CANONICAS -->
					 					<a href=<c:url value='"alumnos/deleteAlumno/${alumno.codigo}'/>">Borrar</a>
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