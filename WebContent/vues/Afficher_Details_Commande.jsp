<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/styles.css" />
</head>
<body>
<div class="container">
		<%@include file="Menu_C.html" %>
	</div>
	<div id="divParent" class="container">
		<p  style="color : red">
			${empty msg ? '' : msg }
		</p>
		<p  style="color : DarkBlue"> 
			Prix total de la commande : ${empty prixTotal ? '' : prixTotal } euros
		</p>
		
		<h1>${empty IdArticle ? '' : IdArticle}</h1>
		<c:forEach items="${listArticles}" var="article">
			<div class="table table-hover" style="width: 18rem;">
				<table class="table table-striped table-responsive-md btn-table">
					<tbody>
						<tr>
							<td><img alt="Image de ${article.getLibelle()}"
								src="file://${sessionScope.path_image}${article.getNomImage()}"
								class="img-fluid" height="auto"></td>
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
					</tbody>
				</table>
		</c:forEach>
		<!-- 	session.getAttribute("path_image") + "//"+ article.getNomImage() -->
</body>
</div>
</html>