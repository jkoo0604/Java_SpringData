<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Contact</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>New Contact</h3>
		</div>
		<div class="row">
			<form:form action="/contacts" method="post" modelAttribute="contact">
			    <p>
			        <form:label path="student">Student:</form:label>
			        <form:errors path="student"/>
			        <form:select path="student">
			        	<c:forEach items="${addstudents}" var="student">
			        	<form:option value="${student.id}"><c:out value="${student.firstName} ${student.lastName}"/></form:option>
			        	</c:forEach>
			        </form:select>
			    </p>
			    <p>
			        <form:label path="address">Address:</form:label>
			        <form:errors path="address"/>
			        <form:input path="address"/>
			    </p>  
			    <p>
			        <form:label path="city">City:</form:label>
			        <form:errors path="city"/>
			        <form:input path="city"/>
			    </p>  
			    <p>
			        <form:label path="state">State:</form:label>
			        <form:errors path="state"/>
			        <form:input path="state"/>
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