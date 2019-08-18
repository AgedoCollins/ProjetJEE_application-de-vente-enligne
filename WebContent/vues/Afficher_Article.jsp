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
	
		<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	
	<div class="navbar navbar-expand navbar-dark bg-dark justify-content-center">
			<%@include file="Menu_C.html"%>
	</div>
<div id="divParent" class="container">
	<h1>Article : ${article.getLibelle()}</h1>

		<p style="color : red">${empty msg ? '' : msg }</p>
		
	<table class="table table-striped table-responsive-md btn-table">
  		<tbody>
  		<tr>
     		 <td>
     		 		<img alt="Image de ${article.getLibelle()}" src="${pageContext.request.contextPath}/images${article.getNomImage()}" class="img-fluid" height="auto">    		
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
  			<td>
  				<a href="ajouterPanier?id=${article.getId()}" class="btn btn-success" role="button">Ajouter au panier</a>
  				</td>
  				<td><a href="catalogue" class="btn btn-primary btn-lg active" role="button" aria-pressed="true"> Retour</a>
  				</td>
  			</tr>
  		</tbody>
	</table>
	</div>
</body>
</html>