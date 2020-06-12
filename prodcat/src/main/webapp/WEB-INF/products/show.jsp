<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Product</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h3><c:out value="${product.name}"/></h3>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="row">
					Categories:
				</div>
				<div class="row">
					<ul>
						<c:forEach items="${product.categories}" var="c">
						<li><c:out value="${c.name}"/></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="row">
					<div class="col-sm-5">
						Add Category:
					</div>
					<div class="col-sm-7">
						<form action="/products/${product.id}/add" method="post">
							<input type="hidden" name="_method" value="put">
							<div class="form-group">
							    <select class="form-control" name="categoryID">
							    	<option value="0" label="--- Select ---" selected>
							    	<c:forEach items="${addcats}" var="cat">
						        	<option value="${cat.id}"><c:out value="${cat.name}"/></option>
						        	</c:forEach>
							    </select>
							</div>
							<div>
								<input type="submit" value="Add" class="btn btn-dark btn-sm"/>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col text-center">
			
				<a href="/prodcat" class="btn btn-outline-dark btn-sm" role="button">Back</a>
			</div>
		</div>
	</div>
</body>
</html>