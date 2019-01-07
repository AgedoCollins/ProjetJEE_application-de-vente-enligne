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
</head>
<body>
	<div id="divParent" class="container">
		<p  style="color : red">
			${empty msg ? '' : msg }
		</p>
		<h1>
			Bienvenue
			<jsp:getProperty name="client" property="prenom" />
			<jsp:getProperty name="client" property="nom" /></h1>

		<ul class="nav navbar-nav">
			<li><a href="logout">Déconnexion</a></li>
		</ul>
		<h1>${empty IdArticle ? '' : IdArticle}</h1>
		<c:forEach items="${listeArticles}" var="article">
			<%
				Article article = (Article) pageContext.getAttribute("article");
			%>

			<div class="table table-hover" style="width: 18rem;">
				<table class="table table-striped table-responsive-md btn-table">
					<tbody>
						<tr>
							<td><img alt="Image de ${article.getLibelle()}"
								src="file://${sessionScope.path_image}${article.getNomImage()}"
								height="224" width="250"
								class="img-fluid"></td>
						</tr>
						<tr>
							<th>Libellé :</th>
							<td>${article.getLibelle()}</td>
						</tr>
						<tr>
							<th>Prix :</th>
							<td>${article.getPrix()}</td>
						</tr>
						<tr>
							<th>Description :</th>
							<td>${article.getDescriptif()}</td>
						</tr>
						<tr>
							<td><a href="showArticle?id=${article.getId()}"
								class="card-link">Voir article</a></td>
						</tr>
					</tbody>
				</table>
		</c:forEach>
		<!-- 	session.getAttribute("path_image") + "//"+ article.getNomImage() -->
</body>
</div>
</html>