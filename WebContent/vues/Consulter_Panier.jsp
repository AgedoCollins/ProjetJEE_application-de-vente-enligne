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
				<%int index = 0; %>
			<tbody>
			<form action="passerCommande?id=${article.getId()}"
						method="get">
				<c:forEach items="${listArticlesPanier}" var="article">
				<c:set var="index" value="<%= index %>" />
					<tr>
						<td>${article.getLibelle()}</td>

						<td>${article.getPrix()}</td>

						<td>${article.getDescriptif()}</td>
						
						<td><input type="number" value="" name="quantite<%=index%>"/></td>
					</tr>
					<%index++; %>
				</c:forEach>
				
				<input type="submit" value="Commander" />
				
				
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