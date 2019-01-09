<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client : <jsp:getProperty name="client" property="prenom" />
	<jsp:getProperty name="client" property="nom" /></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/styles.css" />
</head>
<body>
	<div id="divParent" class="container">
		<h1>
			Bienvenue
			<jsp:getProperty name="client" property="prenom" />
			<jsp:getProperty name="client" property="nom" /></h1>
	</div>
	<div id="divParent" class="container">
		<p style="color: red">${empty msg ? '' : msg }</p>
	</div>
	<%@include file="Menu_C.html"%>
</body>
</html>