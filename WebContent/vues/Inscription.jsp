<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
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
<div class="container">
	<form action="regit" method="post">
     <fieldset class="type-utilisateur">
         <legend>Inscription</legend>
         <table>
        	 <tr>
         		<td><input type=radio name="utilisateur" value="client">Client</td>
         		<td><input type=radio name="utilisateur" value="vendeur">Vendeur</td>
         	</tr>
         	<tr>
         		<td colspan=2><p  style="color : red">${empty msg ? '' : msg }</p></td>
         	</tr>
         	<tr>
	        	<td> <label for="nom">Nom (*)</label></td>
	         	<td><input id="nom" name="nom" type="text" value="${empty nom ? '' : nom }"/></td>
	         </tr>
	         <tr>
	        	 <td><label for="prenom">Prénom (*)</label></td>
	         	<td><input id="prenom" name="prenom" type="text" value="${empty prenom ? '' : prenom }"/></td>
	         </tr>
	         <tr>
	        	 <td><label for="dateNaissance">Date de naissance (*)</label></td>
	         	<td><input id="dateNaissance" name="dateNaissance" type="text" value="${empty dateNaissance ? '' : dateNaissance }"/></td>
	         </tr>
	         <tr>
	         	<td><label for="telephone">Téléphone (*)</label></td>
	         	<td><input id="telephone" name="telephone" type="text" value="${empty telephone ? '' : telephone }"/></td>
	         </tr>
	         <tr>
	         	<td><label for="email">Email (*)</label></td>
	         	<td><input id="email" name="email" type="text" value="${empty email ? '' : email }"/></td>
	         </tr>
	          <tr>
	         	<td><label for="password">Mot de passe (*)</label></td>
	         	<td><input id="password" name="password" type="password"value="${empty motdepasse ? '' : motdepasse }"/></td>
	         </tr>
	          <tr>
	         	<td><label for="password">Confirmer mot de passe (*)</label></td>
	         	<td><input id="confirmerPassword" name="confirmerPassword" type="password" value="${empty confirmerMotdepasse ? '' : confirmerMotdepasse }"/></td>
	         </tr>
         </table>
         
     </fieldset>
     <button type="submit" class="btn btn-info"id="submit">Valider</button>
     <button type= "reset" class="btn btn-info">Reset</button>
	</form>
</div>
</body>
</html>