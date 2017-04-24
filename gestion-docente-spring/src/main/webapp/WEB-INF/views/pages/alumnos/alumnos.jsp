<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 

			<section class="col-xs-12">
				<header class="col-xs-12 "><h2 class="text-center text-capitalize">Lista de Alumnos</h2></header>
				<a href="<c:url value='alumnos/addAlumno'/>" class="btn btn-info ">Crear alumno</a>
				<a href="#" class="btn btn-danger">Borrar alumnos</a>
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-1"><input type="checkbox"></div>
						<div class="col-md-1 hidden-xs col-sm-2">Nombre</div>
						<div class="col-md-2 hidden-xs col-sm-3">Apellidos</div>
						<div class="col-md-2 hidden-xs col-sm-2">Email</div>
						<div class="col-md-1 hidden-xs col-sm-1">teléfono</div>
						<div class="col-md-2 hidden-xs hidden-sm">direccion</div>
						<div class="col-md-3 hidden-xs"></div>
					</div>
					<c:choose>
						 	<c:when test="${not empty listadoAlumnos}">	<!-- alumnoController -->
						 		<c:forEach var="alumno" items="${listadoAlumnos}">
							 		<div class="row">
								 		<div class="col-xs-1"><input id="selecall" type="checkbox" value="${alumno.codigo}"></div>	
								 		<div class="col-md-1 col-xs-4 col-sm-2">${alumno.nombre}</div> 
								 		<div class="col-md-2 col-xs-5 col-sm-3">${alumno.apellidos}</div> 
								 		<div class="col-md-2 col-xs-10 col-sm-2">${alumno.email}</div>
								 		<div class="col-md-1 hidden-xs col-sm-1">${alumno.telefono}</div>
										<div class="col-md-2 hidden-xs hidden-sm">${alumno.direccion}</div>
								 		<div class="col-md-3 col-xs-10 col-sm-3">	
								 				<a href="<c:url value='alumnos/verAlumno/${alumno.codigo}'/>"  class="btn btn-success" role="button">Informe</a><!--  URL CANONICAS -->
								 				<a href="<c:url value='alumnos/${alumno.codigo}'/>"  class="btn btn-warning" role="button">Editar</a><!--  URL CANONICAS -->
								 				<a href="<c:url value='alumnos/deleteAlumno/${alumno.codigo}'/>" class="btn btn-danger" role="button"><span class="glyphicon glyphicon-name"></span> Borrar </a>
								 		</div>
							 		</div>
						 		</c:forEach>	
						 	</c:when>
						 	<c:otherwise>
						 		<div class="row">No se han encontrado alumnos en la Base de Datos.</div>
						 	</c:otherwise>
						 </c:choose>
				</div>
			</section>