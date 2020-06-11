<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<h2>New License</h2>
		</div>
		<div class="row">		
			<form:form action="/licenses" method="post" modelAttribute="license">
			    <p>
			        <form:label path="person">Person:</form:label>
			        <form:errors path="person"/>
			        <form:select path="person">
			        	<c:forEach items="${persons}" var="person">
			        	<form:option value="${person.id}"><c:out value="${person.firstName} ${person.lastName}"/></form:option>
			        	</c:forEach>
			        </form:select>
			    </p>
			    <p>
			        <form:label path="state">State:</form:label>
			        <form:errors path="state"/>
			        <form:input path="state"/>
			    </p>  
			    <p>
			        <form:label path="expirationDate">Expiration Date:</form:label>
			        <form:errors path="expirationDate"/>
			        <form:input path="expirationDate" type="date"/>
			    </p>  
			    <input type="submit" value="Create" class="btn btn-dark"/>
			</form:form>
		</div>
	</div>
</body>
</html>