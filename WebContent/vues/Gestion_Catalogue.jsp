<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Bean.Article"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client : <jsp:getProperty name="client" property="prenom" />
	<jsp:getProperty name="client" property="nom" /></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/styles.css" />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="navbar navbar-expand navbar-dark bg-dark justify-content-center">
			<%@include file="Menu_C.html"%>
	</div>
	<div id="divParent" class="container">
		<h1>Catalogue</h1>

		<p style="color: green; font-weight:bold;">${empty msg ? '' : msg }</p>
		<h1>${empty IdArticle ? '' : IdArticle}</h1>
		<div id="gestion-catalogue" style="width: 18rem;">

			<c:forEach items="${listeArticles}" var="article">
				<%
					Article article = (Article) pageContext.getAttribute("article");
				%>
				<div class="card carte" style="width: 18rem;">
				  <img alt="Image de ${article.getLibelle()}"
								src="${pageContext.request.contextPath}/images${article.getNomImage()}"
								height="224" width="250" class="img-fluid">
				  <div class="card-body">
				    <h5 class="card-title">${article.getLibelle()}</h5>
				    <p class="card-text"><strong>Description :</strong> ${article.getDescriptif()}</p>
				  </div>
				  <ul class="list-group list-group-flush">
				    <li class="list-group-item"><strong>Prix :</strong> ${article.getPrix()}</li>
				  </ul>
				  <div class="card-body">
				    <a href="showArticle?id=${article.getId()}"
								class="card-link">Voir article</a>
				  </div>
				</div>
			</c:forEach>

			<!-- 	session.getAttribute("path_image") + "//"+ article.getNomImage() -->
		</div>
	</div>
</body>
</html>