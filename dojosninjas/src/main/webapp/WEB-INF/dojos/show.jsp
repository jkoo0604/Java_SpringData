<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Detail</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3><c:out value="${dojo.name}"/> Ninjas</h3>
		</div>
		<div class="row">
			<table class="table table-striped">
				<thead class="thead-dark">
				    <tr>
				      <th scope="col">First Name</th>
				      <th scope="col">Last Name</th>
				      <th scope="col">Age</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${dojo.ninjas}" var="ninja">
				    <tr>
				      <td><c:out value="${ninja.firstName}"/></td>
				      <td><c:out value="${ninja.lastName}"/></td>
				      <td><c:out value="${ninja.age}"/></td>
				    </tr>
				    </c:forEach>
				  </tbody>
			</table>
		</div>
		<div class="row text-right">
			<a href="/dojos" class="btn btn-dark btn-sm" role="button">Back</a>
		</div>
	</div>
</body>
</html>