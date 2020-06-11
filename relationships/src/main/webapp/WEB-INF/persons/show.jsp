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
			<h2 class="name"><c:out value="${person.firstName} ${person.lastName}"/></h2>
		</div>
		<div class="row justify-content-center">
			<div class="col-sm-7">
				<div class="row">
					<div class="col-sm-5">License Number:</div>
					<div class="col-sm-7"><c:out value="${person.license.number }"/></div>
				</div>
				<div class="row">
					<div class="col-sm-5">State:</div>
					<div class="col-sm-7"><c:out value="${person.license.state }"/></div>
				</div>
				<div class="row">
					<div class="col-sm-5">Expiration Date:</div>
					<div class="col-sm-7"><c:out value="${person.license.expirationDate }"/></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>