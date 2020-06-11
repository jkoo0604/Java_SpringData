<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos and Ninjas</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>All Dojos</h3>
		</div>
		<div class="row">
			<table class="table table-striped">
				<thead class="thead-dark">
				    <tr>
				      <th scope="col">Dojo Name</th>
				      <th scope="col">Ninja Count</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${dojos}" var="dojo">
				    <tr>
				      <th scope="row"><c:out value="${dojo.name}"/></th>
				      <td><c:out value="${fn:length(dojo.ninjas)}"/> ninjas</td>
				    </tr>
				    </c:forEach>
				  </tbody>
			</table>
		</div>
		<div class="row">
			<div class="col-sm-6 text-center">
				<a href="/dojos/new" class="btn btn-dark btn-sm" role="button">Create Dojo</a>
			</div>
			<div class="col-sm-6 text-center">
				<a href="/ninjas/new" class="btn btn-dark btn-sm" role="button">Create Ninja</a>
			</div>
		</div>
	</div>
</body>
</html>