<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%><!--  -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!--  -->

		<form:form action="save" nethod="post" commandName="profesor">
			<c:if test="${not empty profesor}">
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
				<form:label path="telefono" for="telefono">Tel�fono:</form:label>
				<form:input path="telefono" cssErrorClass="" cssClass="" />
				<form:errors path="telefono" cssClass="" />
			</div>
			<div>
				<form:label path="fNacimiento" for="fNacimiento">Fecha de nacimineto:</form:label>
				<form:input path="fNacimiento" cssErrorClass="" cssClass="" />
				<form:errors path="fNacimiento" placeholder="dd/MM/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" cssClass="" />
			</div>
			<div>
				<form:label path="direccion" for="direccion">Direcci�n:</form:label>
				<form:input path="direccion" cssErrorClass="" cssClass="" />
				<form:errors path="direccion" cssClass="" />
			</div>
			<div>
				<form:label path="poblacion" for="poblacion">Poblacion:</form:label>
				<form:input path="poblacion" cssErrorClass="" cssClass="" />
				<form:errors path="poblacion" cssClass="" />
			</div>
			<div>
				<form:label path="codigoPostal" for="codigoPostal">C�digo Postal:</form:label>
				<form:input path="codigoPostal" pattern="{5}" cssErrorClass="" cssClass="" />
				<form:errors path="codigoPostal" cssClass="" />
			</div>
			<div>
				<form:label path="nSS" for="nSS">Numero de Seguridad Social:</form:label>
				<form:input path="nSS" cssErrorClass="" cssClass="" />
				<form:errors path="nSS" cssClass="" />
			</div>
			<c:set var="menssg" value ="Crear" />
			<c:if test="${0 < profesor.codigo}">
				<c:set var="menssg" value ="Editar" />
			</c:if>
			<input type="submit" value="${menssg}" />
		</form:form>
	