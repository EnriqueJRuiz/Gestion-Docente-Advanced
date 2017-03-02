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
				
				<c:choose>
				<c:when test="${not empty curso}">	
			 			<c:forEach var="cdmodulo" items="${curso.modulos}">
			 				<br>
			 				${cdmodulo.modulo.nombre}
			 				${cdmodulo.fInicio}
			 				${cdmodulo.fFin}
			 				${cdmodulo.imparticion.profesor.nombre}
			 			</c:forEach>	
			 		</c:when>
			 		<c:otherwise>
			 			No se han encontrado cursos en la Base de Datos
			 		</c:otherwise>
			 	</c:choose>
			 	<hr>
			 	Alumnos:
			 	<br>
			 	<c:choose>
				<c:when test="${not empty curso}">	
			 			<c:forEach var="cdmodulo" items="${curso.modulos}">
			 				<c:forEach var="asistentes" items="${cdmodulo.imparticion.alumnos}">
			 				<br>
			 					<a href="<c:url value='../alumnos/verAlumno/${asistentes.codigo}'/>" >${asistentes.nombre}</a>
			 				</c:forEach>
			 			</c:forEach>	
			 		</c:when>
			 		<c:otherwise>
			 			No se han encontrado cursos en la Base de Datos
			 		</c:otherwise>
			 	</c:choose>  
			</div>
		</main>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>