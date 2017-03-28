<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:message var="men" code="form.crear" text="nombre" />
<c:if test="${curso.codigo > 0}" >
	<spring:message var="men"  code="form.editar" text="nombre" />
</c:if>   
<spring:message var="seccion" code="${curso.nombre}" text="curso" />
<c:set scope="request" var="seccion" value="${men} ${seccion}"/> >

	<jsp:include page="../includes/header.jsp" />

		<main>
			<section>
		<header><h2>Datos del curso</h2></header>
		<div>
			<p>Nombre: ${curso.nombre}</p>
			<p>F.Inicio: <fmt:formatDate pattern="dd/MM/yyyy" value="${curso.fInicio}" /></p>
			<p>F.Fin: <fmt:formatDate pattern="dd/MM/yyyy"  value="${curso.fFin}" /></p>
	        <p>Horas: ${curso.nHoras}</p>
	        <p>Temario: ${curso.temario}</p>
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
		</main>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>