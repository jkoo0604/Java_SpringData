<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">Songs by Artist: <c:out value="${artist }"/></div>
			<div class="col-sm-6">
				<form action="/search/artist" method="POST" class="inline-form">
					<input name="search" type="text" placeholder="${artist }">
					<input type="submit" value="Search Artists" class="btn btn-dark btn-sm" />	
				</form>
			</div>
			<div class="col-sm-3 text-right"><a href="/dashboard">Dashboard</a></div>
		</div>
		<div class="row">
			<table>
		    	<thead>
		        	<tr>
		            	<th>Name</th>
		            	<th>Rating</th>
		            	<th>Action</th>
		        	</tr>
		    	</thead>
		    	<tbody>
		        	<c:forEach items="${songs}" var="song">
		        	<tr>
		            	<td><a href="/songs/<c:out value="${song.id}"/>"><c:out value="${song.title}"/></a></td>
		            	<td><c:out value="${song.rating}"/></td>
		            	<td>
		            		<form action="/songs/${song.id}" method="post">
		    					<input type="hidden" name="_method" value="delete">
		    					<input type="submit" value="delete" class="btn btn-link">
						</form>
		            	</td>
		        	</tr>
		        	</c:forEach>
		    	</tbody>
			</table>
		</div>
	
	</div>
</body>
</html>