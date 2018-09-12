<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login : </title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<spring:url value="/user/login" var="formUrl" />
			<form:form action="${formUrl}" method="GET" modelAttribute="user">
				<div class="form-group">
					<label for="e-mail">E-mail:</label>
					<form:input id="e-mail" cssClass="form-control" path="email" />
				</div>
				<div class="form-group">
					<label for="user-password">Password:</label>
					<form:input id="user-password" cssClass="form-control" path="password" />
				</div>

				<button type="submit" class="btn btn-default">Login</button>
				</form:form>
		</div>
	</div>
</body>
</html>