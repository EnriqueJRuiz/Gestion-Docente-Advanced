<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
  
<spring:message var="seccion" code="cursos.titulo"/>
<c:set scope="request" var="seccion" value="${seccion}"/>

	<jsp:include page="../includes/header.jsp" />

		<main>
			<div class="container">
			<a href="curso/addCurso" class="btn btn-info" class="btn btn-info " style="margin: 5px 0" role="button">Crear Curso</a>
			<table id="table-1" class="table table-hover">
					<thead class="table-success">
						<tr class="info">
							<th>Nombre</th>
							<th>Identificador</th>
							<th>Nº Horas</th>
							<th>Precio</th>
							<th></th>
						</tr>
					</thead>
					<tfoot class="table-success">
						<tr class="info">
							<th>Nombre</th>
							<th>Identificador</th>
							<th>Nº Horas</th>
							<th>Precio</th>
							<th></th>
						</tr>
					</tfoot>
					<tbody>
					 	<c:choose>
					 		<c:when test="${not empty listadoCursos}">	
					 			<c:forEach var="curso" items="${listadoCursos}">
					 				<tr>
						 				<td>${curso.nombre}</td> 
						 				<td>${curso.identificador}</td>
						 				<td>${curso.nHoras}</td>
						 				<td>${curso.precio}</td>  
						 				<td>
						 					<a href="<c:url value='cursos/verCurso/${curso.codigo}'/>" class="btn btn-success" role="button">Ver informe</a>
						 					<a href="<c:url value='cursos/${curso.codigo}'/>" class="btn btn-warning" role="button">Editar</a><!--  URL CANONICAS -->
						 					<a href="<c:url value='cursos/deleteCurso/${curso.codigo}'/>" class="btn btn-danger" role="button">Borrar</a>
						 				</td>
						 			</tr>	
					 			</c:forEach>	
					 		</c:when>
					 		<c:otherwise>
					 			<td colspan="4">No se han encontrado cursos en la Base de Datos</td>
					 		</c:otherwise>
					 	</c:choose>
					</tbody>
				</table>
			</div>
		</main>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>