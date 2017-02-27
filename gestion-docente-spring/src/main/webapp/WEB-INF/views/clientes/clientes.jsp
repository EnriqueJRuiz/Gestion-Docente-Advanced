<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
  
<spring:message var="seccion" code="clientes.titulo"/>
<c:set scope="request" var="seccion" value="${seccion}"/>

	<jsp:include page="../includes/header.jsp" />

		<main>
			<div class="container">
			<a href="clientes/addCliente" class="btn btn-info" role="button">Crear Cliente</a>
			<table id="table-1" class="table table-hover">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Email</th>
							<th>Teléfono</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					 	<c:choose>
					 		<c:when test="${not empty listadoClientes}">	
					 			<c:forEach var="cliente" items="${listadoClientes}">
					 				<tr>
						 				<td>${cliente.nombre}</td> 
						 				<td>${cliente.email}</td>
						 				<td>${cliente.telefono}</td> 
						 				<td>
						 					<a href="<c:url value='clientes/verCliente/${cliente.codigo}'/>" class="btn btn-success" role="button">Ver informe</a>
						 					<a href="<c:url value='clientes/${cliente.codigo}'/>" class="btn btn-warning" role="button">Editar</a><!--  URL CANONICAS -->
						 					<a href="<c:url value='clientes/deleteCliente/${cliente.codigo}'/>" class="btn btn-danger" role="button">Borrar</a>
						 				</td>
						 			</tr>	
					 			</c:forEach>	
					 		</c:when>
					 		<c:otherwise>
					 			<td colspan="3">No se han encontrado clientes en la Base de Datos</td>
					 		</c:otherwise>
					 	</c:choose>
					</tbody>
				</table>
			</div>
		</main>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>