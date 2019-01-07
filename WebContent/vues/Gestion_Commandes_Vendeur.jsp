<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendeur : <jsp:getProperty name="vendeur" property="prenom" />
	<jsp:getProperty name="vendeur" property="nom" /></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/styles.css" />
</head>
<body>
<div class="container">
		<%@include file="Dashboard_Vendeur.jsp" %>
</div>
<div id="divParent" class="container">

		<p  style="color : red">
			${empty msg ? '' : msg }
		</p>
	<c:forEach items="${listCommandes}" var="commande">
	<c:set var="index" value="${index + 1}" />
			<table class="table table-striped table-responsive-md btn-table">
				<tbody>
					<tr>
						<th>Date de la commande :</th>
						<td>${commande.dateCommande}</td>
					</tr>
					<tr>
						<th>Etat :</th>
						<td>${commande.etat}</td>
					</tr>
					<tr>
 					<form action="showCommande" method="get">
 					<td><input type="submit" class="btn btn-info" value="Voir le détail de la commande"/></td>
					<td><input type="hidden" name ="index" value="${index-1}"/></td>
					</form>
					</tr>
					<tr>
					<form action="traiterCommande" method="get">
 					<td><input type="submit" class="btn btn-info" value="Traiter la commande"/></td>
					<td><input type="hidden" name ="index" value="${index-1}"/></td>
					</form>
<%-- 						<td><a href="showCommande?id=${commande.getId()}" class="card-link">Voir --%>
<!--  				        le détail de la commande</a></td>  -->
					</tr>
				</tbody>
			</table>
	</c:forEach>
</body>
</div>
</html>