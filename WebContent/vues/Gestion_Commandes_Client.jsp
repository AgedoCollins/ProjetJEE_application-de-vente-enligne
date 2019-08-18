<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<h1>Liste de commande du client</h1>

		<p style="color: red">${empty msg ? '' : msg }</p>
		<table class="table table-striped table-responsive-md btn-table">
		<tr>
			<th>Date de la commande :</th>
			<th>État de la commande : </th>
			<th>Total</th>
			<th>Détail </th>
		</tr>
			<tbody >
				<c:forEach items="${listCommandes}" var="commande">
					<c:set var="index" value="${index + 1}" />

					<tr>
						<td><strong>${commande.dateCommande}</strong></td>
						<td><strong>${commande.etat}</strong></td>
						<td><strong>${commande.getPrixTotale()}</strong></td>
						<td>
							<form action="showCommande" method="get">
								<input type="submit" class="btn btn-info"
									value="Voir le détail de la commande" />
								<input type="hidden" name="index" value="${index-1}" />
							</form>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>