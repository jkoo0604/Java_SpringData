<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top Ten Songs</title>
<link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9">Top Ten Songs</div>
			<div class="col-sm-3 text-right"><a href="/dashboard">Dashboard</a></div>
		</div>
		<div class="row justify-content-center">
			<div class="col-sm-7">
			
				<c:forEach items="${songs}" var="song">
					<div class="row">
						<div class="col-sm-2"><c:out value="${song.rating }"/></div>
						<div class="col-sm-6"><a href="/songs/<c:out value="${song.id}"/>"><c:out value="${song.title}"/></a></div>
						<div class="col-sm-4"><c:out value="${song.artist }"/></div>
					</div>
		        </c:forEach>
			</div>
		</div>
	</div>
</body>
</html>