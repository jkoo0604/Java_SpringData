<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Person</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<h2>New Person</h2>
		</div>
		<div class="row">		
			<form:form action="/persons" method="post" modelAttribute="person">
			    <p>
			        <form:label path="firstName">First Name:</form:label>
			        <form:errors path="firstName"/>
			        <form:input path="firstName"/>
			    </p>
			    <p>
			        <form:label path="lastName">Last Name:</form:label>
			        <form:errors path="lastName"/>
			        <form:input path="lastName"/>
			    </p>  
			    <input type="submit" value="Create" class="btn btn-dark"/>
			</form:form>
		</div>
	</div>
</body>
</html>