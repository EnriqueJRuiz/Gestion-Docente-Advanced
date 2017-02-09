<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%><!--  -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!--  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Gestion Docente - Cliente</title>
</head>
<body>
	<header>
	</header>
	<main>
		<form:form action="save" nethod="post" commandName="cliente">
			<c:if test="${not empty cliente}">
				<form:hidden path="codigo"/>
			</c:if>
			<div>
				<form:label path="nombre" for="nombre">Nombre:</form:label>
				<form:input path="nombre" cssErrorClass="" cssClass="" />
				<form:errors path="nombre" cssClass="" />
			</div>
			<div>
				<form:label path="identificador" for="identificador">Identificador:</form:label>
				<form:input path="identificador" cssErrorClass="" cssClass="" />
				<form:errors path="identificador" cssClass="" />
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
			<c:set var="menssg" value ="Crear" />
			<c:if test="${0 < alumno.codigo}">
				<c:set var="menssg" value ="Editar" />
			</c:if>
			<input type="submit" value="${menssg}" />
		</form:form>
	</main>
	<footer>
	</footer>
</body>
</html>