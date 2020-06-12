<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products and Categories</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>Products</h3>
		</div>
		<div class="row">
			<table class="table table-striped">
				<thead class="thead-dark">
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Price</th>
				      <th scope="col">Description</th>
				      <th scope="col">Categories</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${products}" var="p">
				    <tr>
				      <th scope="row"><a href="/products/${p.id}"><c:out value="${p.name}"/></a></th>
				      <td>$<c:out value="${p.price}"/></td>
				      <td><c:out value="${p.description}"/></td>
				      <td>
				      	<ul>
				      		<c:forEach items="${p.categories}" var="cat">
				      		<li><c:out value="${cat.name}"/></li>
				      		</c:forEach>
				      	</ul>	
				      </td>
				    </tr>
				    </c:forEach>
				  </tbody>
			</table>
		</div>
		<div class="row padding"></div>
		<div class="row">
			<h3>Categories</h3>
		</div>
		<div class="row">
			<table class="table table-striped">
				<thead class="thead-dark">
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col"># of Products</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${categories}" var="c">
				    <tr>
				      <th scope="row"><a href="/categories/${c.id}"><c:out value="${c.name}"/></a></th>
				      <td><c:out value="${fn:length(c.products)}"/></td>
				    </tr>
				    </c:forEach>
				  </tbody>
			</table>
		</div>
		<div class="row padding"></div>
		<div class="row">
			<div class="col-sm-6 text-center">
				<a href="/products/new" class="btn btn-dark btn-sm" role="button">New Product</a>
			</div>
			<div class="col-sm-6 text-center">
				<a href="/categories/new" class="btn btn-dark btn-sm" role="button">New Category</a>
			</div>
		</div>
	</div>
</body>
</html>