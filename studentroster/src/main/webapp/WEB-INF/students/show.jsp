<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Student</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3><c:out value="${student.firstName} ${student.lastName}"/></h3>
		</div>
		<div class="row padding"></div>
		<div class="row">
			<div class="col-sm-5">
				Add Class:
			</div>
			<div class="col-sm-7">
				<form action="/students/${student.id}/add" method="post">
					<input type="hidden" name="_method" value="put">
					<div class="form-group">
					    <select class="form-control" name="classID">
					    	<option value="0" label="--- Select ---" selected disabled>
					    	<c:forEach items="${addclasses}" var="c">
				        	<option value="${c.id}"><c:out value="${c.name}"/></option>
				        	</c:forEach>
					    </select>
					</div>
					<div>
						<input type="submit" value="Add" class="btn btn-dark btn-sm"/>
					</div>
				</form>
			</div>
		</div>
		<div class="row padding"></div>
		<div class="row">
			<h4>Your Schedule:</h4>
		</div>
		<div class="row">
			<table class="table table-striped">
				<thead class="thead-dark">
				    <tr>
				      <th scope="col">Class Name</th>
				      <th scope="col">Action</th>
				    </tr>
				</thead>
				<tbody>
				  	<c:forEach items="${student.classes}" var="c1">
				    <tr>
				      	<td><c:out value="${c1.name}"/></td>
				      	<td>
					      	<form action="/students/${student.id}/remove/${c1.id}" method="post">
	    						<input type="hidden" name="_method" value="delete">
	    						<input type="submit" value="Drop" class="btn btn-link">
							</form>
						</td>
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