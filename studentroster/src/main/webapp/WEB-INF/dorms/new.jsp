<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dorm</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>New Dorm</h3>
		</div>
		<div class="row">
			<form:form action="/dorms" method="post" modelAttribute="dorm">
			    
			    <p>
			        <form:label path="name">Name:</form:label>
			        <form:errors path="name"/>
			        <form:input path="name"/>
			    </p> 
			    <input type="submit" value="Create" class="btn btn-dark"/>
			</form:form>
		</div>
		<div class="row">
			<div class="col text-center">			
				<a href="/students" class="btn btn-dark btn-sm" role="button">Back</a>
			</div>
		</div>
	</div>
</body>
</html>