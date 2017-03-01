<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<spring:message var="men" code="form.crear" text="nombre" />
<c:if test="${curso.codigo > 0}" >
	<spring:message var="men"  code="form.editar" text="nombre" />
</c:if>   
<spring:message var="seccion" code="cliente.titulo" text="curso" />
<c:set scope="request" var="seccion" value="${men} ${seccion}"/> >

	<jsp:include page="../includes/header.jsp" />

		<main>
			<div class="container">
	
			</div>
		</main>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>