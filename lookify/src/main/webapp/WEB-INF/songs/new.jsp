<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Song</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="row text-right">
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="row">		
			<form:form action="/songs" method="post" modelAttribute="song">
			    <p>
			        <form:label path="title">Title</form:label>
			        <form:errors path="title"/>
			        <form:input path="title"/>
			    </p>
			    <p>
			        <form:label path="artist">Artist</form:label>
			        <form:errors path="artist"/>
			        <form:input path="artist"/>
			    </p>
			    <p>
			        <form:label path="rating">Rating</form:label>
			        <form:errors path="rating"/>
			        <form:input path="rating"/>
			    </p>   
			    <input type="submit" value="Add Song"/>
			</form:form>
		</div>
	</div>
</body>
</html>