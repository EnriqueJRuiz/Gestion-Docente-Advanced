<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  

		<div class="container">
		<a href="<c:url value='profesores/addProfesor'/>" class="btn btn-info " style="margin: 5px 0" role="button">Crear profesor</a>
		<table id="table-1" class="table table-hover">
				<thead class="table-success">
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
				 		<c:when test="${not empty listadoProfesores}">	
				 			<c:forEach var="profesor" items="${listadoProfesores}">
				 				<tr>
					 				<td>${profesor.nombre}</td> 
					 				<td>${profesor.apellidos}</td> 
					 				<td>
					 					<a href="<c:url value='profesores/${profesor.codigo}'/> "  class="btn btn-success" role="button">Editar</a>
					 					<a href="<c:url value='profesores/deleteProfesor/${profesor.codigo}'/> " class="btn btn-danger" role="button">Borrar</a>
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
			</div>
		