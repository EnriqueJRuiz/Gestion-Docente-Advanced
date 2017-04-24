
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%><!--  -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!--  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  


			<section class="col-xs-12">
				<div class="col-xs-10 col-md-offset-1">
				<c:url var="postUrl" value="/cursos/save"/>
					<form:form action="${postUrl}" nethod="post" commandName="curso" cssClass="form-horizontal" enctype="multipart/form-data" >
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
								<form:input path="fInicio"  cssErrorClass="form-control alert-danger" cssClass="form-control"  />
							</div>
						</div>
						
						<div class="form-group">
						<form:label path="fFin" for="fFin" cssClass="col-xs-2 form-label">Fecha fin:</form:label>
							<div class=" col-xs-8">
								<form:input path="fFin" cssErrorClass="form-control alert-danger" cssClass="form-control"  />
							</div>
						</div>
						
						<div class="form-group">
							<form:label path="precio" for="precio" cssClass="col-xs-2 form-label">Precio:</form:label>
							<div class=" col-xs-8">
								<form:input path="precio" cssErrorClass="form-control alert-danger" cssClass="form-control"  />
							</div>
						</div>
						<div class="form-group">
		            		<form:label path="temario" cssClass="control-label  col-xs-2">Temario:</form:label>
		            		<div class="col-xs-4">
		            			<c:set var="string" value="${curso.temario}" />
		   						<c:set var="names" value="${fn:split(string, '/')}" />
		   						<c:set var="len" value="${fn:length(numList)}"/>
		   						<c:set var="value" value="${names[len-1]}" />
		   						${value}
								<form:input value="${value}" path="temario" disabled="disabled" cssClass="form-control" cssErrorClass="text-danger"/>
							</div>
							<form:errors path="temario" cssClass="text-danger col-xs-6"></form:errors>
							 <label class="btn btn-primary">
		                		Examinar&hellip; <input type="file" id="fichero" name="fichero" style="display: none;">
		            		</label>
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