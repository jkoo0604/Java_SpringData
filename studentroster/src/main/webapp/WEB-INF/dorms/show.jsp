<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dorm Detail</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3><c:out value="${dorm.name}"/> Dormitory</h3>
		</div>
		<div class="row">
			<div class="col-sm-3">
				Students
			</div>
			<div class="col-sm-4">
				<form action="/dorms/${dorm.id}/add" method="post">
					<input type="hidden" name="_method" value="put">
					<div class="form-group">
					    <select class="form-control" name="studentID">
					    	<option value="0" label="--- Select ---" selected>
					    	<c:forEach items="${addstudents}" var="s">
				        	<option value="${s.id}"><c:out value="${s.firstName} ${s.lastName}"/></option>
				        	</c:forEach>
					    </select>
					</div>
					<div>
						<input type="submit" value="Add" class="btn btn-dark btn-sm"/>
					</div>
				</form>
				<%-- <form:form action="/dorms/${dorm.id}/add" method="post">
				<input type="hidden" name="_method" value="put">
				
				    <p>
				        <form:errors path="id"/>
				        <form:select path="id">
				        	<form:option value="0" label="--- Select ---" selected="selected"/>
				        	<c:forEach items="${addstudents}" var="s">
				        	<form:option value="${s.id}"><c:out value="${s.firstName} ${s.lastName}"/></form:option>
				        	</c:forEach>
			        	</form:select>
			        </p>
				      
				    <input type="submit" value="Add" class="btn btn-dark btn-sm"/>
				</form:form> --%>
			</div>
		</div>
		<div class="row padding"></div>
		<div class="row">
			<table class="table table-striped">
				<thead class="thead-dark">
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${dorm.students}" var="student">
				    <tr>
				      	<td><c:out value="${student.firstName} ${student.lastName}"/></td>
				      	<td>
					      	<form action="/dorms/${dorm.id}/remove/${student.id}" method="post">
	    						<input type="hidden" name="_method" value="delete">
	    						<input type="submit" value="Remove" class="btn btn-link">
							</form>
						</td>
				    </tr>
				    </c:forEach>
				  </tbody>
			</table>
		</div>
		<div class="row">
			<div class="col text-center">			
				<a href="/students" class="btn btn-dark btn-sm" role="button">Back</a>
			</div>
		</div>
	</div>
</body>
</html>