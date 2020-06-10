<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="row text-right">
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="row justify-content-center">
			<div class="col-sm-7">
				<div class="row">
					<div class="col-sm-5">Title</div>
					<div class="col-sm-7"><c:out value="${song.title }"/></div>
				</div>
				<div class="row">
					<div class="col-sm-5">Artist</div>
					<div class="col-sm-7"><c:out value="${song.artist }"/></div>
				</div>
				<div class="row">
					<div class="col-sm-5">Rating (1-10)</div>
					<div class="col-sm-7"><c:out value="${song.rating }"/></div>
				</div>
				<div class="row">
					<form action="/songs/${song.id}" method="post">
		    			<input type="hidden" name="_method" value="delete">
		    			<input type="submit" value="Delete" class="btn btn-link">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>