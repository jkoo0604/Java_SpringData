<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Class</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3><c:out value="${c.name}"/></h3>
		</div>
		<div class="row padding"></div>
		<div class="row">
			<h5>Students taking this class:</h5>
		</div>		
		<div class="row padding"></div>
		<div class="row">
			<table class="table table-striped">
				<thead class="thead-dark">
				    <tr>
				      <th scope="col">Name</th>
				    </tr>
				</thead>
				<tbody>
				  	<c:forEach items="${c.students}" var="s">
				    <tr>
				      	<td><c:out value="${s.firstName} ${s.lastName}"/></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row padding"></div>
		<div class="row">
			<div class="col text-center">
			
				<a href="/students" class="btn btn-outline-dark btn-sm" role="button">Back</a>
			</div>
		</div>
	</div>
</body>
</html>