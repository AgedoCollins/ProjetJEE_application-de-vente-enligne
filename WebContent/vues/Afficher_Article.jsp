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
	
	<div class="container">
		<%@include file="Dashboard_Client.jsp" %>
</div>
<div id="divParent" class="container">
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
  			<tr>
  			<td><a href="ajouterPanier?id=${article.getId()}"
								class="card-link">Ajouter au panier</a></td>
<!--   			<form action="" method="get"> -->
<!--  					<td><input type="submit" class="btn btn-info" value="Ajouter au panier"/></td> -->
<%-- 					<td><input type="hidden" name ="index" value="${article.getId()}"/></td> --%>
<!-- 					</form> -->
<!--   			<td> -->
<!-- 		      <a class="btn btn-primary" href="#" role="button">Ajouter au panier</a> -->
<!-- 		      </td> -->
  			</tr>
  		</tbody>
	</table>
	</div>
</body>
</html>