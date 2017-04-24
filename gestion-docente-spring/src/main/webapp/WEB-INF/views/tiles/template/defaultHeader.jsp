<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<body>
	<header class="container-fluid">
		<div class="row">
			<nav class="navbar navbar-inverse">
		    	<div class="navbar-header">
			      	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>                        
			      	</button>
			       	<a class="navbar-brand" href="/gestiondocente">${nombreApp}</a>
			    </div>
			
				<div class="collapse navbar-collapse" id="myNavbar">
			      <ul class="nav navbar-nav">
				      <li>
				      	<a href="<c:url value='/alumnos'/>" >
				      		<spring:message code="menu.alumnos" text="G.Alumnos" />
						</a>
				      </li>
				      <li>
				        <a href="<c:url value='/profesores'/>">
							<spring:message code="menu.profesores" text="G.Profesores" />
						</a>
				      </li>
				      <li>
				        <a href="<c:url value='/clientes'/>">
							<spring:message code="menu.clientes" text="G.Clientes" />
						</a>
				      </li>
				      <li>
				      	<sec:authorize access="isAuthenticated()">
				        <a href="<c:url value='/cursos'/>">
							<spring:message code="menu.cursos" text="G.Cursos" />
						</a>
						</sec:authorize>
				      </li>
				      
				    </ul>
				    	
		    		<ul class="nav navbar-nav navbar-right  btn-group">
			    		<li class="dropdown">
		        			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
		        			Idioma<span class="caret"></span>
		        			</a>
		       			 	<ul class="dropdown-menu">
								<li>
									<a class="nav-link" href="?locale=es">				
			 							<spring:message code="idioma.castellano" />
			 						</a>
			 					</li>	
			 					<li>
			 						<a class="nav-link" href="?locale=en">
			 							<spring:message code="idioma.ingles" />
			 						</a>
			 					</li>	
			 					<li>
			 						<a class="nav-link" href="?locale=eu">
			 							<spring:message code="idioma.euskera" />
			 						</a>
			 					</li>
			 				</ul>
				 		</li>
				 		<li>
				 		<sec:authorize access="isAnonymous()">
			                <form method="POST" action="<c:url value='/login'/>">
			                    Username: <input name="userId" type="text" value="${SPRING_SECURITY_LAST_USERNAME}" /> 
			                    Password: <input name="password" type="password" />
			                    <!-- 
			                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
			                     --> 
			                    <input type="submit" value="Login" />
			                </form>
			            </sec:authorize>
			            <sec:authorize access="isAuthenticated()">
			                <a class="btn btn-default" href="<c:url value="/logout" />">Logout</a>
			            </sec:authorize>
				 		</li>
			 		</ul>
	 			</div>
			</nav>
		</div>
		<div class="row lead">
			<h1 class="col-xs-12"><samp class="text-center text-uppercase">${seccion}</samp></h1>
		</div>
		<div class="container">
			<c:if test="${not empty mensaje}">
				<div class="${mensaje.type.styles}">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		   			<strong>${mensaje.msg}</strong> 
		  		</div>
	  		</c:if>
		</div>
	</header>