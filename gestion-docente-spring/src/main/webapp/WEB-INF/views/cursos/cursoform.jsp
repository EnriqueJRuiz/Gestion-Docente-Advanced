<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%><!--  -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!--  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<spring:message var="men" text="Nuevo Curso" />
<c:if test="${carta.codigo > 0}" >
	<spring:message var="men"  code="form.editar" text="Editar curso" />
</c:if>  
	<jsp:include page="../includes/header.jsp" />
		<main  class="container-fluid">
			<section class="col-xs-12">
				<header class="col-xs-12"><h2>${men}</h2></header>
				<div class="col-xs-10 col-md-offset-1">
				<c:url var="postUrl" value="/cursos/save"/>
					<form:form action="${postUrl}" nethod="post" commandName="curso" cssClass="form-horizontal">
						<c:if test="${not empty curso}">
							<form:hidden path="codigo"/>
						</c:if>
						<form:hidden path="activo"/>
						<div class="form-group">
						<form:label path="nombre" for="nombre" cssClass="col-xs-2 form-label">Nombre:</form:label>
							<div class=" col-xs-8">
								<form:input path="nombre" cssErrorClass="form-control alert-danger" cssClass="form-control"  />
							</div>
						</div>
						
						<div class="form-group">
						<form:label path="identificador" for="identificador" cssClass="col-xs-2 form-label">Identificador:</form:label>
							<div class=" col-xs-8">
								<form:input path="identificador" cssErrorClass="form-control alert-danger" cssClass="form-control"  />
							</div>
						</div>
						
						<div class="form-group">
						<form:label path="nHoras" for="nHoras" cssClass="col-xs-2 form-label">Numero de horas:</form:label>
							<div class=" col-xs-8">
								<form:input path="nHoras" cssErrorClass="form-control alert-danger" cssClass="form-control"  />
							</div>
						</div>
						
						<div class="form-group">
						<form:label path="fInicio" for="fInicio" cssClass="col-xs-2 form-label">Fecha inicio:</form:label>
							<div class=" col-xs-8">
								<form:input path="fInicio" placeholder="dd/MM/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" cssErrorClass="form-control alert-danger" cssClass="form-control"  />
							</div>
						</div>
						
						<div class="form-group">
						<form:label path="fFin" for="fFin" cssClass="col-xs-2 form-label">Fecha fin:</form:label>
							<div class=" col-xs-8">
								<form:input path="fFin" placeholder="dd/MM/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" cssErrorClass="form-control alert-danger" cssClass="form-control"  />
							</div>
						</div>
						
						<div class="form-group">
							<form:label path="temario" for="temario" cssClass="col-xs-2 form-label">Temario:</form:label>
							<div class=" col-xs-8">
								<form:input path="temario" cssErrorClass="form-control alert-danger" cssClass="form-control"  />
							</div>
						</div>
						
						<div class="form-group">
							<form:label path="precio" for="precio" cssClass="col-xs-2 form-label">Precio:</form:label>
							<div class=" col-xs-8">
								<form:input path="precio" cssErrorClass="form-control alert-danger" cssClass="form-control"  />
							</div>
						</div>
									
		  				<div class="form-group">
		 					<form:label path="profesor" for="profesor" cssClass="col-xs-2 form-labe" >Profesor:</form:label>
		 					<div class="col-xs-8">
		 						<form:select path="profesor" cssErrorClass="form-control alert-danger" cssClass="form-control">
		 			               	<form:option value="0" label="Elija un profesor"/>
		 							<form:options items="${listadoProfesores}" itemValue="codigo" itemLabel="nombre" />
		 			   			</form:select> 
 		           			</div>
						</div>
						
							<div class="form-group">
		 					<form:label path="cliente" for="cliente" cssClass="col-xs-2 form-labe" >Cliente:</form:label>
		 					<div class="col-xs-8">
		 						<form:select path="cliente" cssErrorClass="form-control alert-danger" cssClass="form-control">
		 			               	<form:option value="0" label="Elija un cliente"/>
		 							<form:options items="${listadoClientes}" itemValue="codigo" itemLabel="nombre" />
		 			   			</form:select> 
 		           			</div>
						</div>
						
						<div class="form-group">
		 					<form:label path="alumnos" for="alumnos" cssClass="col-xs-2 form-labe" >Alumnos:</form:label>
		 					<div class="col-xs-8">
		 						<form:checkboxes items="${listadoAlumnos}" itemValue="codigo" itemLabel="nombre" path="alumnos"/>
		 					</div>
		 				</div>
						
						<c:set var="menssg" value ="Crear" />
						<c:if test="${0 < curso.codigo}">
							<c:set var="menssg" value ="Editar" />
						</c:if>
						<button type="submit"  class="btn btn-success" >${menssg}</button>
					</form:form>
				</div>
			</section>
		</main>	
	</body>
</html>