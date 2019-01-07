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
		<%@include file="Dashboard_Client.jsp" %>
</div>
<div id="divParent" class="container">
		<p  style="color : blue">
			${empty msg ? '' : msg }
		</p>
<c:forEach items="${listArticlesPanier}" var="article">
	<table class="table table-striped table-responsive-md btn-table">
  		<tbody>
  		<tr>
     		 <td>
     		 		<img alt="Image de ${article.getLibelle()}" src="file://${sessionScope.path_image}${article.getNomImage()}" class="img-fluid" height="auto">    		
     		 </td>
  			</tr>
    		<tr>
     		 <th>Libellé : </th>
     		 <td>${article.getLibelle()}</td>
  			</tr>
  			<tr>
     		 <th>Prix : </th>
     		 <td>${article.getPrix()}</td>
  			</tr>
  			<tr>
     		 <th>Description : </th>
     		 <td>${article.getDescriptif()}</td>
  			</tr>
  		</tbody>
	</table>
	</c:forEach>
	<table>
	<tr>
	<td><a href="passerCommande?id=${article.getId()}"
								class="card-link">Commander</a></td>
	</tr>
	</table>
	</div>
</body>
</html>