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
	<div class="container">
		<form:form action="save" nethod="post" commandName="alumno" cssClass="form-horizontal">
			<c:if test="${not empty alumno}">
				<form:hidden path="codigo"/>
			</c:if>
			<div class="form-group container">
				<form:label path="nombre" for="nombre" cssClass="control-label col-sm-3">Nombre:</form:label>
				<div class="col-sm-5">
					<form:input path="nombre" cssErrorClass="" cssClass="form-control"  />
				</div>
				<div class="label-control container"> 
					<h4><strong><form:errors path="nombre" cssClass="alert-danger col-sm-4" /></strong></h4>
				</div>
			</div>
			<div class="form-group container">
				<form:label path="apellidos" for="apellidos" cssClass="control-label col-sm-3">Apellidos:</form:label>
				<div class="col-sm-5">	
					<form:input path="apellidos" cssErrorClass="" cssClass="form-control" />
				</div>
				<div class=" col-sm-4"> 	
					<form:errors path="apellidos" cssClass="alert alert-danger" />
				</div>
			</div>
			
			<div class="form-group container">
				<form:label path="dni" for="dni" cssClass="control-label col-sm-3">DNI:</form:label>
				<div class="col-sm-5">
					<form:input path="dni" cssErrorClass="" cssClass="form-control" />
				</div>
				<div class=" col-sm-4"> 
					<form:errors path="dni" cssClass="alert alert-danger" />
					</div>
			</div>
			<div class="form-group container">
				<form:label path="email" for="email" cssClass="control-label col-sm-3">Email:</form:label>
				<div class="col-sm-5">
					<form:input path="email" cssErrorClass="" cssClass="form-control" />
				</div>
				<div class=" col-sm-4"> 
					<form:errors path="email" cssClass="alert alert-danger" />
				</div>
			
			</div>
			
				
			<div class="form-group container">
			
				<form:label path="telefono" for="telefono" cssClass="control-label col-sm-3">Teléfono</form:label>
				
				<div class="col-sm-5" >
					<form:input path="telefono" cssErrorClass=" " cssClass="form-control" />
				</div>
				<div class=" col-sm-4"> 
					<form:errors path="telefono" cssClass=" alert alert-danger"  />
				</div>
			
			</div>
			
			<div class="form-group container">
				<form:label path="fNacimiento" for="fNacimiento" cssClass="control-label col-sm-3">Fecha de nacimineto:</form:label>
				<div class="col-sm-5">
					<form:input path="fNacimiento" cssErrorClass="" cssClass="form-control" />
				</div>
				<form:errors path="fNacimiento" placeholder="dd/MM/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" cssClass="alert alert-danger" />
			</div>
			<div class="form-group container">
				<form:label path="direccion" for="direccion" cssClass="control-label col-sm-3">Dirección:</form:label>
				<div class="col-sm-5">
					<form:input path="direccion" cssErrorClass="" cssClass="form-control" />
				</div>
				<form:errors path="direccion" cssClass="alert alert-danger" />
			</div>
			<div class="form-group container">
				<form:label path="poblacion" for="poblacion" cssClass="control-label col-sm-3">Poblacion:</form:label>
				<div class="col-sm-5">
					<form:input path="poblacion" cssErrorClass="" cssClass="form-control" />
				</div>
				<form:errors path="poblacion" cssClass="alert alert-danger" />
			</div>
			<div class="form-group container">
				<form:label path="codigoPostal" for="codigoPostal" cssClass="control-label col-sm-3">Código Postal:</form:label>
				<div class="col-sm-5">
					<form:input path="codigoPostal" pattern="{5}" cssErrorClass="" cssClass="form-control" />
				</div>
				<form:errors path="codigoPostal" cssClass="alert alert-danger" />
			</div>
			<div class="form-group container">
				<form:label path="nHermanos" for="nHermanos" cssClass="control-label col-sm-3">Numero de hermanos:</form:label>
				<div class="col-sm-5">
					<form:input path="nHermanos" cssErrorClass="" cssClass="form-control" />
				</div>
				<form:errors path="nHermanos" cssClass="alert alert-danger" />
			</div>
			<c:set var="menssg" value ="Crear" />
			<c:if test="${0 < alumno.codigo}">
				<c:set var="menssg" value ="Editar" />
			</c:if>
			
			<button type="submit"  class="btn btn-success" >${menssg}</button>
		</form:form>
		</div>
	</main>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>