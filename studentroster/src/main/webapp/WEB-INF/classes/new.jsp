<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Class</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>New Class</h3>
		</div>
		<div class="row">
			<form:form action="/classes" method="post" modelAttribute="c">
				<div class="col-sm-12">
					<div class="row form-group">
						<div class="col-sm-4">
							<form:label path="name">Name:</form:label>
						</div>
						<div class="col-sm-8">
							<form:errors path="name"/>
			        		<form:input path="name"  class="form-control"/>
						</div>
					</div>
					<div class="row form-group">
						<div class="col text-center">
							<input type="submit" value="Create" class="btn btn-dark"/>
						</div>
					</div>
				</div>
			</form:form>
		</div>
		<div class="row padding"></div>
		<div class="row">
			<div class="col text-center">
			
				<a href="/students" class="btn btn-outline-dark btn-sm" role="button">Back</a>
			</div>
		</div>
	</div>
</body>
</html>