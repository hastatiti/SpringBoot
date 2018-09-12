<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Barbecues</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
<h2>Barbecues:</h2>
<table style="width:50%">
<tr>
<th>Barbecue Id </th>
<th>Authorized Funds </th>
<th>Authorized Hours </th>
<th>Description </th>
<th>Name </th>
</tr>

<c:forEach items="${barbecues}" var="barbecues">
<tr>
<td>${barbecues.barbecueId}</td>
<td>${barbecues.authorizedFunds}</td>
<td>${barbecues.authorizedHours}</td>
<td>${barbecues.description}</td>
<td>${barbecues.name}</td>
</tr>

</c:forEach>

</table>

</body>
</html> 
