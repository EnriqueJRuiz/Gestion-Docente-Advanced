<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%><!--  -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!--  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<spring:message var="men" code="form.crear" text="nombre" />
<c:if test="${alumno.codigo > 0}" >
	<spring:message var="men"  code="form.editar" text="nombre" />
</c:if>   
<spring:message var="seccion" code="alumnos.titulo" text="alumno" />
<c:set scope="request" var="seccion" value="${men} ${seccion}"/>

<jsp:include page="../includes/header.jsp" />
	<main>
		<form:form action="save" nethod="post" commandName="alumno">
			<c:if test="${not empty alumno}">
				<form:hidden path="codigo"/>
			</c:if>
			<div>
				<form:label path="nombre" for="nombre">Nombre:</form:label>
				<form:input path="nombre" cssErrorClass="" cssClass="" />
				<form:errors path="nombre" cssClass="" />
			</div>
			<div>
				<form:label path="apellidos" for="apellidos">Apellidos:</form:label>
				<form:input path="apellidos" cssErrorClass="" cssClass="" />
				<form:errors path="apellidos" cssClass="" />
			</div>
			<div>
				<form:label path="dni" for="dni">DNI:</form:label>
				<form:input path="dni" cssErrorClass="" cssClass="" />
				<form:errors path="dni" cssClass="" />
			</div>
			<div>
				<form:label path="email" for="email">Email:</form:label>
				<form:input path="email" cssErrorClass="" cssClass="" />
				<form:errors path="email" cssClass="" />
			</div>
			<div>
				<form:label path="telefono" for="telefono">Teléfono:</form:label>
				<form:input path="telefono" cssErrorClass="" cssClass="" />
				<form:errors path="telefono" cssClass="" />
			</div>
			<div>
				<form:label path="fNacimiento" for="fNacimiento">Fecha de nacimineto:</form:label>
				<form:input path="fNacimiento" cssErrorClass="" cssClass="" />
				<form:errors path="fNacimiento" placeholder="dd/MM/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" cssClass="" />
			</div>
			<div>
				<form:label path="direccion" for="direccion">Dirección:</form:label>
				<form:input path="direccion" cssErrorClass="" cssClass="" />
				<form:errors path="direccion" cssClass="" />
			</div>
			<div>
				<form:label path="poblacion" for="poblacion">Poblacion:</form:label>
				<form:input path="poblacion" cssErrorClass="" cssClass="" />
				<form:errors path="poblacion" cssClass="" />
			</div>
			<div>
				<form:label path="codigoPostal" for="codigoPostal">Código Postal:</form:label>
				<form:input path="codigoPostal" pattern="{5}" cssErrorClass="" cssClass="" />
				<form:errors path="codigoPostal" cssClass="" />
			</div>
			<div>
				<form:label path="nHermanos" for="nHermanos">Numero de hermanos:</form:label>
				<form:input path="nHermanos" cssErrorClass="" cssClass="" />
				<form:errors path="nHermanos" cssClass="" />
			</div>
			<c:set var="menssg" value ="Crear" />
			<c:if test="${0 < alumno.codigo}">
				<c:set var="menssg" value ="Editar" />
			</c:if>
			<input type="submit" value="${menssg}" />
		</form:form>
	</main>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>