<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Bean.Panier"%>
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

<script type="text/javascript">
	function CalculTotal() {
		var prix_total = document.getElementById("prix_total")
		var prix_article = document.getElementsByClassName("prix_article");
		var quantite_article = document
				.getElementsByClassName("quantite_article");

		var total = 0.0;

		for (var i = 0; i < prix_article.length; i++) {
			total += prix_article[i].innerHTML * quantite_article[i].value;
		}

		prix_total.innerHTML = total + " euros.";
	}
</script>
</head>
<body>
	<div class="container">
		<%@include file="Menu_C.html"%>
	</div>
	<div id="divParent" class="container">
		<p style="color: blue">${empty msg ? '' : msg }</p>
		<table class="table table-striped table-responsive-md btn-table">
			<thead>
				<tr>
					<th>Libellé :</th>
					<th>Prix :</th>
					<th>Description :</th>
					<th>Quantite :</th>
				</tr>
				<%
					int index = 0;
				%>
			
			<tbody>
				<form action="passerCommande?id=${article.getId()}" method="get">
					<c:forEach items="${listArticlesPanier}" var="article">
						<c:set var="index" value="<%=index%>" />
						<tr>
							<td>${article.getLibelle()}</td>

							<td class="prix_article">${article.getPrix()}</td>

							<td>${article.getDescriptif()}</td>

							<td><input type="number" value="" class="quantite_article"
								onchange="CalculTotal()" name="quantite<%=index%>" /></td>

							<td><input type="hidden" name="index" value="${index}" /></td>
							<td><a href="supprimerItemFromPanier?id_article=${index}">Supprimer</a></td>

						</tr>
						<%
							index++;
						%>
					</c:forEach>



					<p style="color: blue">
					<table>
						<tr>
							<th>Prix total de la commande :</th>
							<td id="prix_total"></td>
						</tr>
					</table>
					</p>
					<tr>
						<td><input type="submit" class="btn btn-info"
							value="Commander" /></td>
					</tr>
				</form>
			</tbody>
		</table>
		<table>
			<tr>

				<td>
			</tr>
		</table>
	</div>
</body>
</html>