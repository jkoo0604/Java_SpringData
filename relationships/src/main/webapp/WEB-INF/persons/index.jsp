<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="row text-left">
			<h2 class="name">People Index</h2>
		</div>
		<div class="row">
			<table>
		    	<thead>
		        	<tr>
		            	<th>First Name</th>
		            	<th>Last Name</th>
		            	<th>License #</th>
		            	<th>State</th>
		            	<th>Expiration Date</th>
		        	</tr>
		    	</thead>
		    	<tbody>
		        	<c:forEach items="${persons}" var="person">
		        	<tr>
		            	<td><c:out value="${person.firstName}"/></td>
		            	<td><c:out value="${person.lastName}"/></td>
		            	<td><c:out value="${person.license.number}"/></td>
		            	<td><c:out value="${person.license.state}"/></td>
		            	<td><c:out value="${person.license.expirationDate}"/></td>
		            	
		        	</tr>
		        	</c:forEach>
		    	</tbody>
			</table>
		</div>
		
		
		<div class="row justify-content-center">
			<a class="btn btn-dark" href="/persons/new" role="button">Create New Person</a>
		</div>
	</div>
</body>
</html>