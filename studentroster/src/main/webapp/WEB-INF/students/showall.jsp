<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Students</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/style.css">
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
				      <th scope="col">City</th>
				      <th scope="col">State</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${students}" var="student">
				    <tr>
				      <th scope="row"><c:out value="${student.firstName} ${student.lastName}"/></th>
				      <td><c:out value="${student.age}"/></td>
				      <td><c:out value="${student.contact.address}"/></td>
				      <td><c:out value="${student.contact.city}"/></td>
				      <td><c:out value="${student.contact.state}"/></td>
				    </tr>
				    </c:forEach>
				  </tbody>
			</table>
		</div>
	</div>
</body>
</html>