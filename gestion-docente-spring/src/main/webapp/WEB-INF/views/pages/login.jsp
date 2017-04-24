<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<main class ="container-fluid">
	<section class="col-xs-12">
		<c:url var="loginURL"  value='/login'/>
		<div class="col-xs-6 col-md-offset-3">
		<form:form method="post"  action="${loginURL}" >
			<div class="input-group input-sm ">
				<input type="text" id="userId" name="userId" Class="form-control col-xs-6 " required />
			</div>
			<div class="input-group input-sm ">
					<input type="password" id="password" name="password" Class="form-control col-xs-6 " required />
			</div>
			<input type="submit" value="Log In" class="btn btn-block btn-primary col-xs-4 col-md-offset-1">
		</form:form>
		</div>
	</section>
</main>
