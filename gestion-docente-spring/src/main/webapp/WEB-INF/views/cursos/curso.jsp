<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<spring:message var="men" code="form.crear" text="nombre" />
<c:if test="${curso.codigo > 0}" >
	<spring:message var="men"  code="form.editar" text="nombre" />
</c:if>   
<spring:message var="seccion" code="${curso.nombre}" text="curso" />
<c:set scope="request" var="seccion" value="${men} ${seccion}"/> >

	<jsp:include page="../includes/header.jsp" />

		<main>
			<div class="container">
				<section>
				<header><h2>Datos del curso</h2></header>
			 			<c:forEach var="cdmodulo" items="${curso.modulos}">
			 				<br>
			 				<a href="<c:url value='/cursos/${cdmodulo.modulo.codigo}/detalle/${cdmodulo.codigo}'/>" >${cdmodulo.modulo.nombre}</a>
			 				${cdmodulo.fInicio}
			 				${cdmodulo.fFin}
			 				${cdmodulo.imparticion.profesor.nombre}
			 			</c:forEach>	
			 </section>
			 <section>	
			 	<header><h3>Listado de alumnos</h3></header>
			 			<c:forEach var="alumno" items="${curso.alumnos}">
			 					<a href="<c:url value='/cursos/${cdmodulo.modulo.codigo}/alumnos/${alumno.codigo}'/>" >${alumno.nombre}</a>
			 			</c:forEach>	 
			 	</section>
			</div>
		</main>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>