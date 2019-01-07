<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendeur : <jsp:getProperty name="vendeur" property="prenom"/> <jsp:getProperty name="vendeur" property="nom"/></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styles.css"/>
</head>
<body>
	<div id="divParent" class="container">
	<h1>Bienvenue <jsp:getProperty name="vendeur" property="prenom"/> <jsp:getProperty name="vendeur" property="nom"/> </h1>
	 <ul class="nav navbar-nav">
	 <li><a href="items">Consulter mes articles</a></li>
    <li><a href="order">Consulter mes commandes</a></li>
    <li><a href="logout">Déconnexion</a></li>
	</ul>
	</div>
</body>
</html>