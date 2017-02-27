<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
  
<spring:message var="seccion" code="alumnos.titulo" />
<c:set scope="request" var="seccion" value="${seccion}"/>

	<jsp:include page="../includes/header.jsp" />
		<main>
			<div class="container">
				<a href="<c:url value='alumnos/addAlumno'/>" class="btn btn-info " style="margin: 5px 0" role="button">Crear alumno</a>
			</div>
			<div class="container">
				
				<table id="table-1" class="table table-hover ">
					<thead  class="table-success">
						<tr class="info">
							<th>Nombre</th>
							<th>Apellidos</th>
							<th></th>
						</tr>
					</thead>
					<tfoot class="table-success">
						<tr class="info">
							<th>Nombre</th>
							<th>Apellidos</th>
							<th></th>
						</tr>
					</tfoot>
					<tbody>
						 <c:choose>
						 	<c:when test="${not empty listadoAlumnos}">	<!-- alumnoController -->
						 		<c:forEach var="alumno" items="${listadoAlumnos}">
						 			<tr>
							 			<td >${alumno.nombre}</td> 
							 			<td >${alumno.apellidos}</td> 
							 			<td>
							 				<a href="<c:url value='alumnos/verAlumno/${cliente.codigo}'/>" class="btn btn-success" role="button">Ver informe</a>
							 				<a href="<c:url value='alumnos/${alumno.codigo}'/>"  class="btn btn-success" role="button">Editar</a><!--  URL CANONICAS -->
							 				<a href="<c:url value='alumnos/deleteAlumno/${alumno.codigo}'/>" class="btn btn-danger" role="button"><span class="glyphicon glyphicon-name"></span> Borrar </a>
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
			</div>
		</main>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>