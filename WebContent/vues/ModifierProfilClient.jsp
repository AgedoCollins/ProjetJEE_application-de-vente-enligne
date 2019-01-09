<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification profil</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styles.css"/>
</head>
<body>
<%@ page import="Bean.Client" %>
	<div id="divParent" class="container">

		<p  style="color : red">
			${empty msg ? '' : msg }
		</p>
		<%Client cli = (Client)session.getAttribute("client"); %>
	<form action=modifcli method="post">
		<table>
			<tr>
				<td><label for="nom">Nom(*)</label></td>
				<td><input type="text" name="nom" value="<%=cli.getNom()%>"/></td>
			</tr>
			
			<tr>
				<td><label for="prenom">Prenom(*)</label></td>
				<td><input type="text" name="prenom" value="<%=cli.getPrenom()%>"/></td>
			</tr>
			
			<tr>
				<td><label for="telephone">Numero de téléphone(*)</label></td>
				<td><input type="text" name="telephone" value="<%=cli.getTelephone()%>"/></td>
			</tr>
			<tr>
				<td><label for="dateNaissance">Date de naissance(*)</label></td>
				<td><input type="text" name="dateNaissance" value="<%=cli.getDateNaissance()%>"/></td>
			</tr>
			
			<tr>
				<td><label for="email">Email(*)</label></td>
				<td><input type="text" name="email" value="<%=cli.getEmail()%>"/></td>
			</tr>
			
			<tr>
				<td><label for="password">Mot de passe(*)</label></td>
				<td><input type="password" name="password" value="<%=cli.getPassword()%>"/></td>
			</tr>
			<tr>
				<td><label for="confirmerPassword">Confimer le mot de passe(*)</label></td>
				<td><input type="password" name="confirmerPassword" value="<%=cli.getPassword()%>"/></td>
			</tr>
		</table>
		<input type="submit" class="btn btn-info" value="Modifier"/>
	</form>
	</div>
</body>
</html>