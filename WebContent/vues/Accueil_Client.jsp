<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client : <jsp:getProperty name="client" property="prenom"/> <jsp:getProperty name="client" property="nom"/></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styles.css"/>
</head>
<body>
	<h1>Bienvenue <jsp:getProperty name="client" property="prenom"/> <jsp:getProperty name="client" property="nom"/></h1>
	<%@include file="Menu_C.html"%>
</body>
</html>