<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>New Ninja</h3>
		</div>
		<div class="row">
			<form:form action="/ninjas" method="post" modelAttribute="ninja">
			    <p>
			        <form:label path="dojo">Dojo:</form:label>
			        <form:errors path="dojo"/>
			        <form:select path="dojo">
			        	<form:option value="0" label="--- Select ---"/>
			        	<c:forEach items="${dojos}" var="dojo">
			        	<form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
			        	</c:forEach>
			        </form:select>
			    </p>
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
			    <p>
			        <form:label path="age">Age:</form:label>
			        <form:errors path="age"/>
			        <form:input path="age" type="number"/>
			    </p>  
			    <input type="submit" value="Create" class="btn btn-dark"/>
			</form:form>
		</div>
	</div>
</body>
</html>