<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
  

<spring:message var="seccion" code="listaclientes.titulo"/>
<c:set scope="request" var="seccion" value="${seccion}"/>

	<jsp:include page="../includes/header.jsp" />
				<main>
					<div class="container">
						<h3 >${cliente.nombre}</h3>
						<h3> Email: ${cliente.email}</h3>
					</div>
					
					<div class="container">
						<c:choose>
							<c:when test="${not empty cliente.cursos}">	
								<table id="table-1" class="table table-hover">
									<thead>
										<tr>
											<th>Nombre</th>
											<th>identificador</th>
											<th>Fecha inicio</th>
											<th>Fecha fin</th>
											<th>Nº de horas</th>
										</tr>
									</thead>
									<tbody>
							 			<c:forEach var="cursoentry" items="${cliente.cursos}">
							 				<tr>
								 				<td><c:out value="${cursoentry.value.nombre}"/></td> 
								 				<td><c:out value="${cursoentry.value.identificador}"/></td>
								 				<td><c:out value="${cursoentry.value.fInicio}"/></td>
								 				<td><c:out value="${cursoentry.value.fFin}"/></td> 
								 				<td><c:out value="${cursoentry.value.nHoras}"/></td>  
								 			</tr>	
							 			</c:forEach>	
									</tbody>
								</table>
							</c:when>
				 		<c:otherwise>
				 			<td colspan="3">No se han encontrado clientes en la Base de Datos</td>
				 		</c:otherwise>
				 	</c:choose>
				</div>
			</main>
		<jsp:include page="../includes/footer.jsp" />
	</body>
</html>