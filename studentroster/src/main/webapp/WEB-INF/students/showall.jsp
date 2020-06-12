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
<title>All Students</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>All Students</h3>
		</div>
		<div class="row">
		
			<table class="table table-striped">
				<thead class="thead-dark">
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Age</th>
				      <th scope="col">Address</th>
				      <th scope="col">Dorm</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${students}" var="student">
				    <tr>
				      <th scope="row"><c:out value="${student.firstName} ${student.lastName}"/></th>
				      <td><c:out value="${student.age}"/></td>
				      <td><c:out value="${student.contact.address}, ${student.contact.city}, ${student.contact.state}"/></td>
				      <td><a href="/dorms/${student.dorm.id}"><c:out value="${student.dorm.name}"/></a></td>
				    </tr>
				    </c:forEach>
				  </tbody>
			</table>
		</div>
		<div class="row">
			<h3>All Dorms</h3>
		</div>
		<div class="row">
		
			<table class="table table-striped">
				<thead class="thead-dark">
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col"># of Students</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${dorms}" var="dorm">
				    <tr>
				      <th scope="row"><a href="/dorms/${dorm.id}"><c:out value="${dorm.name}"/></a></th>
				      <td><c:out value="${fn:length(dorm.students)}"/></td>
				    </tr>
				    </c:forEach>
				  </tbody>
			</table>
		</div>
		<div class="row">
			<div class="col-sm-4 text-center">
				<a href="/students/new" class="btn btn-dark btn-sm" role="button">Create Student</a>
			</div>
			<div class="col-sm-4 text-center">
				<a href="/contacts/new" class="btn btn-dark btn-sm" role="button">Create Contact</a>
			</div>
			<div class="col-sm-4 text-center">
				<a href="/dorms/new" class="btn btn-dark btn-sm" role="button">Create Dorm</a>
			</div>
		</div>
	</div>
</body>
</html>