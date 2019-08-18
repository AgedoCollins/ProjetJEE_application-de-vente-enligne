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
		var hidden_prix_total = document.getElementById("hidden_prixTotale")
		var prix_article = document.getElementsByClassName("prix_article");
		var quantite_article = document.getElementsByClassName("quantite_article");

		var total = 0.0;

		for (var i = 0; i < prix_article.length; i++) {
			total += prix_article[i].innerHTML * quantite_article[i].value;
		}

		prix_total.innerHTML = total + " euros.";
		hidden_prix_total.value = total;
	}
	
	$(document).ready(function(){
		var tbody = $("#panierCommande tbody");
		var tbody = $("#panierCommande tbody");

		if (tbody.children().length == 0) {
		    $("#btnCommander").prop('disabled', true);
		    console.log("empty");
		}
		else
		{
		    console.log(" not empty");
		    CalculTotal();
		    $("#btnCommander").prop('disabled', false);
		}
	}); 
</script>
</head>
<body>
	<div class="navbar navbar-expand navbar-dark bg-dark justify-content-center">
			<%@include file="Menu_C.html"%>
	</div>
	<div id="divParent" class="container">
		<h1>Panier</h1>
	
		<p style="color: red; font-weight:bold">${empty msg ? '' : msg }</p>
		<table class="table table-striped table-responsive-md btn-table" id="panierCommande">
			<thead>
				<tr>
					<th>Libellé :</th>
					<th>Prix :</th>
					<th>Description :</th>
					<th>Quantite :</th>
				</tr>
			</thead>
				<%
					int index = 0;
				%>
				
				<form action="passerCommande?id=${article.getId()}" method="get">
					<tbody>
						<c:forEach items="${listArticlesPanier}" var="article">
							<c:set var="index" value="<%=index%>" />
							<tr>
								<td>${article.getLibelle()}</td>
	
								<td class="prix_article">${article.getPrix()}</td>
	
								<td>${article.getDescriptif()}</td>
	
								<td><input type="number" class="form-control m-md-3" value="1" class="quantite_article" onchange="CalculTotal()" name="quantite<%=index%>" min="1" /></td>
	
								<td><input type="hidden" name="index" value="${index}" /></td>
								<td><a href="supprimerItemFromPanier?id_article=${index}"  class="btn btn-danger m-md-3">Supprimer</a></td>
	
							</tr>
							<%
								index++;
							%>
						</c:forEach>
					</tbody>

						<table>
							<tr>
								<th>Prix total de la commande :</th>
								<td id="prix_total"></td>
								<td><input type="hidden" name="hidden_prixTotale" value="" id="hidden_prixTotale"/></td>
							</tr>
							<tr>
								<td><input type="submit" class="btn btn-info" value="Commander" id="btnCommander" /></td>
							</tr>
						</table>					
				</form>
		</table>
		<table>
			<tr>

				<td>
			</tr>
		</table>
	</div>
</body>
</html>