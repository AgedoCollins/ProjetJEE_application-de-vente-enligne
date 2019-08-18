<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendeur : <jsp:getProperty name="vendeur"
		property="prenom" /> <jsp:getProperty name="vendeur" property="nom" /></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/styles.css" />
	
		<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="navbar navbar-expand navbar-dark bg-dark justify-content-center">
			<%@include file="Menu_V.html"%>
	</div>
	<div id="divParent" class="container">
	<h1>Liste d'articles du vendeur commandés</h1>

		<p style="color: red">${empty msg ? '' : msg }</p>
		<table class="table table-striped table-responsive-md btn-table">
			<thead>
				<tr>
					<th>Libellé</th>
					<th>Prix</th>
					<th>Description</th>
					<th>Etat</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listArticles}" var="article">
					<c:set var="index" value="${index + 1}" />
					<tr>
						<td><strong>${article.libelle}</strong></td>
						<td><strong>${article.prix}</strong></td>
						<td><strong>${article.descriptif}</strong></td>
						<td><strong>${article.etat}</strong></td>
						
						<td>
							<form action="traiterCommande" method="get">
								<input type="submit" class="btn btn-info"
									value="Traiter l'article" /> <input type="hidden" name="index_article"
									value="${article.id}" />
									<input type="hidden" name="index_commande"
									value="${article.id_commande}" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>