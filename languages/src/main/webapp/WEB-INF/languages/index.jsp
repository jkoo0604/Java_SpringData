<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>All Languages</h1>
	<table>
    	<thead>
        	<tr>
            	<th>Name</th>
            	<th>Creator</th>
            	<th>Version</th>
            	<th>Action</th>
        	</tr>
    	</thead>
    	<tbody>
        	<c:forEach items="${languages}" var="language">
        	<tr>
            	<td><a href="/languages/<c:out value="${language.id}"/>"><c:out value="${language.name}"/></a></td>
            	<td><c:out value="${language.creator}"/></td>
            	<td><c:out value="${language.version}"/></td>
            	<td>
            		<form action="/languages/${language.id}" method="post">
    					<input type="hidden" name="_method" value="delete">
    					<input type="submit" value="delete" class="submitlink">
					</form> | 
            		<a href="/languages/<c:out value="${language.id}"/>/edit">edit</a>
            	</td>
        	</tr>
        	</c:forEach>
    	</tbody>
	</table>
	<h3>Add a new language</h3>
	<form:form action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="version">Version</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>   
    <input type="submit" value="Submit"/>
	</form:form>
	
</body>
</html>