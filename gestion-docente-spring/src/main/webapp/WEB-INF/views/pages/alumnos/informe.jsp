<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
 
					<div class="container">
						<h3 >Nombre: ${alumno.nombre}</h3>
						<h3> Email: ${alumno.email}</h3>
					</div>
					
					<div class="container">
						<c:choose>
							<c:when test="${not empty alumno.cursos}">	
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
							 			<c:forEach var="cursoentry" items="${alumno.cursos}">
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