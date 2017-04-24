<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%><!--  -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!--  -->

		<div class="container" >
		<form:form action="save" nethod="post" commandName="alumno" cssClass="form-horizontal" style="margin-bottom: 50px;">
			<c:if test="${not empty alumno}">
				<form:hidden path="codigo"/>
			</c:if>
		
			<div class="form-group row ">
				<form:label path="nombre" for="nombre" cssClass="col-2 col-form-label">Nombre:</form:label>
				<div class=" col-4">
					<form:input path="nombre" cssErrorClass="form-control alert-danger" cssClass="form-control"  />
				</div>
				<div class=""> 
					<form:errors path="nombre" cssClass="badge badge-danger " />
				</div>
			</div>
			
			<div class="form-group row">
				<form:label path="apellidos" for="apellidos" cssClass="col-2 col-form-label ">Apellidos:</form:label>
				<div class="col-4">	
					<form:input path="apellidos" cssErrorClass="form-control alert-danger" cssClass="form-control" />
				</div>
				<div class=""> 	
					<form:errors path="apellidos" cssClass="badge badge-danger" />
				</div>
			</div>
			
			<div class="form-group row">
				<form:label path="dni" for="dni" cssClass="col-2 col-form-label">DNI:</form:label>
				<div class=" col-4">
					<form:input path="dni" cssErrorClass="form-control alert-danger" cssClass="form-control" />
				</div>
				<div class=""> 
					<form:errors path="dni" cssClass="badge badge-danger" />
				</div>
			</div>
			
			<div class="form-group row">
				<form:label path="email" for="email" cssClass="col-2 col-form-label">Email:</form:label>
				<div class="col-4">
					<form:input path="email" cssErrorClass="form-control alert-danger" cssClass="form-control" />
				</div>
				<div class=""> 
					<form:errors path="email" cssClass="badge badge-danger" />
				</div>
			</div>
			
			<div class="form-group row">
				<form:label path="telefono" for="telefono" cssClass="col-2 col-form-label">Tel�fono</form:label>
				<div class="col-4" >
					<form:input path="telefono" cssErrorClass="form-control alert-danger" cssClass="form-control" />
				</div>
				<div class=""> 
					<form:errors path="telefono" cssClass="badge badge-danger"  />
				</div>
			</div>
			
			<div class="form-group row">
				<form:label path="fNacimiento" for="fNacimiento" cssClass="col-2 col-form-label">Fecha de nacimineto:</form:label>
				<div class="col-4">
					<form:input path="fNacimiento" placeholder="dd/MM/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" cssErrorClass="form-control alert-danger" cssClass="form-control" />
				</div>
				<div class="">
					<form:errors path="fNacimiento"  cssClass="badge badge-pill badge-danger" />
				</div>
			</div>
			
			<div class="form-group row">
				<form:label path="direccion" for="direccion" cssClass="col-2 col-form-label">Direcci�n:</form:label>
				<div class="col-4">
					<form:input path="direccion" cssErrorClass="form-control alert-danger" cssClass="form-control" />
				</div>
				<div class="form-group container">
					<form:errors path="direccion" cssClass="badge  badge-danger" />
				</div>
			</div>
			
			<div class="form-group row">
				<form:label path="poblacion" for="poblacion" cssClass="col-2 col-form-label">Poblacion:</form:label>
				<div class="col-4">
					<form:input path="poblacion" cssErrorClass="form-control alert-danger" cssClass="form-control" />
				</div>
				<div class="">
					<form:errors path="poblacion" cssClass="badge  badge-danger" />
				</div>
			</div>
			
			<div class="form-group row">
				<form:label path="codigoPostal" for="codigoPostal" cssClass="col-2 col-form-label">C�digo Postal:</form:label>
				<div class="col-4">
					<form:input path="codigoPostal" pattern="{5}" cssErrorClass="form-control alert-danger" cssClass="form-control" />
				</div>
				<div class="">
					<form:errors path="codigoPostal" cssClass="badge  badge-danger" />
				</div>
			</div>
			
			<div class="form-group row">
				<form:label path="nHermanos" for="nHermanos" cssClass="col-2 col-form-label">Numero de hermanos:</form:label>
				<div class="col-4">
					<form:input path="nHermanos" cssErrorClass="form-control alert-danger" cssClass="form-control" />
				</div>
				<div class="">
					<form:errors path="nHermanos" cssClass="badge  badge-danger" />
				</div>
			</div>
			
			<c:set var="menssg" value ="Crear" />
			<c:if test="${0 < alumno.codigo}">
				<c:set var="menssg" value ="Editar" />
			</c:if>
			
			<button type="submit"  class="btn btn-success" >${menssg}</button>
		</form:form>
		</div>
	