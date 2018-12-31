<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>
	<h1>Bienvenue <jsp:getProperty name="vendeur" property="prenom"/> <jsp:getProperty name="vendeur" property="nom"/> </h1>
	 <ul class="nav navbar-nav">
	 <li><a href="items">Consulter mes articles</a></li>
    <li><a href="order">Consulter mes commandes</a></li>
    <li><a href="logout">Déconnexion</a></li>
	</ul>
</body>
</html>