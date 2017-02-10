<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Gestion Docente - Listado Clientes</title>
</head>
<body>
	<header>
		<h1>Gestion Docente - Listado Clientes</h1>
	</header>
	<main>
		<a href="clientes/addCliente">Crear Cliente</a>
		<table id="table-1" border="2">
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
					 					<a href="clientes/${cliente.codigo}">Editar</a><!--  URL CANONICAS -->
					 					<a href="clientes/deleteCliente/${cliente.codigo}">Borrar</a>
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
		</main>
	<footer>
		<p>Creado por Enrique J. Ruiz</p>
	</footer>
</body>
</html>