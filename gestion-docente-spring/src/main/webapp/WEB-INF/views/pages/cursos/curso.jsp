<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
	<section>
		<div>
			<p>Nombre: ${curso.nombre}</p>w
			<p>F.Inicio: <fmt:formatDate pattern="dd/MM/yyyy" value="${curso.fInicio}" /></p>
			<p>F.Fin: <fmt:formatDate pattern="dd/MM/yyyy"  value="${curso.fFin}" /></p>
	        <p>Horas: ${curso.nHoras}</p>
	        <p>Temario: <a href="<c:url value="/resources/docs/${curso.temario}"/>"  download >Ver</a></p>
	       	<p>Precio: ${curso.precio}</p>
	       	<p>Cliente: ${curso.cliente.nombre}</p>
        </div>
		<section>
			<header><h3>Listado de alumnos</h3></header>
			<c:forEach var="alumno" items="${curso.alumnos}">
				<div>
					<a href="<c:url value='/cursos/${curso.codigo}/alumnos/${alumno.codigo}'/>">${alumno.nombre} ${alumno.apellidos} ${alumno.email}</a>
				</div>
			</c:forEach>
		</section>
	</section>