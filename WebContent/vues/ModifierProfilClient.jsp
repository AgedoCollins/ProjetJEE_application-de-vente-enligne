<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification profil</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styles.css"/>

	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<%@ page import="Bean.Client" %>

	<div class="navbar navbar-expand navbar-dark bg-dark justify-content-center">
			<%@include file="Menu_C.html"%>
	</div>
	
	<div id="divParent" class="container">
	<h1>Modification du client</h1>
		<p  style="color : red">
			${empty msg ? '' : msg }
		</p>
		<%Client cli = (Client)session.getAttribute("client"); %>
	<form action=modifcli method="post">
		<table>
			<tr>
				<td><label for="nom">Nom(*)</label></td>
				<td><input type="text" name="nom" class="form-control m-md-3" value="<%=cli.getNom()%>"/></td>
			</tr>
			<tr></tr>
			
			<tr>
				<td><label for="prenom">Prenom(*)</label></td>
				<td><input type="text" name="prenom" class="form-control m-md-3" value="<%=cli.getPrenom()%>"/></td>
			</tr>
			<tr></tr>
			
			<tr>
				<td><label for="telephone">Numero de téléphone(*)</label></td>
				<td><input type="text" name="telephone" class="form-control m-md-3" value="<%=cli.getTelephone()%>"/></td>
			</tr>
			<tr></tr>
			
			<tr>
				<td><label for="dateNaissance">Date de naissance(*)</label></td>
				<td><input type="text" name="dateNaissance" class="form-control m-md-3" value="<%=cli.getDateNaissance()%>"/></td>
			</tr>
			<tr></tr>
			
			<tr>
				<td><label for="email">Email(*)</label></td>
				<td><input type="text" name="email" class="form-control m-md-3" value="<%=cli.getEmail()%>"/></td>
			</tr>
			<tr></tr>
			
			<tr>
				<td><label for="password">Mot de passe(*)</label></td>
				<td><input type="password" name="password" class="form-control m-md-3" value="<%=cli.getPassword()%>"/></td>
			</tr>
			<tr></tr>
			
			<tr>
				<td><label for="confirmerPassword">Confimer le mot de passe(*)</label></td>
				<td><input type="password" class="form-control m-md-3" name="confirmerPassword" value="<%=cli.getPassword()%>"/></td>
			</tr>
		</table>
		<input type="submit" class="btn btn-success m-md-3" value="Modifier"/>
		<a href="catalogue" class="btn btn-danger m-md-3">Annuler</a>
	</form>
	</div>
</body>
</html>