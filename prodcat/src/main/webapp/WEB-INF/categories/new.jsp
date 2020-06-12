<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>New Category</h3>
		</div>
		<div class="row">
			<form:form action="/categories" method="post" modelAttribute="category">
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
			
				<a href="/prodcat" class="btn btn-outline-dark btn-sm" role="button">Back</a>
			</div>
		</div>
	</div>
</body>
</html>