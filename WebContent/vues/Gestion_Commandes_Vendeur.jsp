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
</head>
<body>
	<div class="container">
		<%@include file="Menu_V.html"%>
	</div>
	<div id="divParent" class="container">

		<p style="color: red">${empty msg ? '' : msg }</p>
		<table class="table table-striped table-responsive-md btn-table">
			<thead>
				<tr>
					<th>Libellé</th>
					<th>Prix</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listArticles}" var="article">
					<c:set var="index" value="${index + 1}" />
					<tr>


						<td>${article.libelle}</td>


						<td>${article.prix}</td>


						<td>${article.descriptif}</td>
						
						<td>
							<form action="traiterCommande" method="get">
								<input type="submit" class="btn btn-info"
									value="Traiter l'article" /> <input type="hidden" name="index"
									value="${article.id}" />
							</form>
						</td>
						<%-- 						<td><a href="showCommande?id=${commande.getId()}" class="card-link">Voir --%>
						<!--  				        le détail de la commande</a></td>  -->
					</tr>

				</c:forEach>
			</tbody>
		</table>
</body>
</div>
</html>