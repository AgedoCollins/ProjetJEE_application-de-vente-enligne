<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un article</title>
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
	<div class="navbar navbar-expand navbar-dark bg-dark justify-content-center">
			<%@include file="Menu_V.html"%>
	</div>
	<div id="divParent" class="container">
	<h1>Ajout d'un nouvel article</h1>
		<p  style="color : red">
			${empty msg ? '' : msg }
		</p>
	<form action=addItem enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td><label for="libelle">Libelle (*)</label></td>
				<td><input type="text" class="form-control m-md-3" name="libelle"/></td>
			</tr>
			
			<tr>
				<td><label for="prix">Prix (*)</label></td>
				<td><input type="text" class="form-control m-md-3" name="prix"/></td>
			</tr>
			
			<tr>
				<td><label for="descriptif">Descriptif (*)</label></td>
				<td><input type="text" class="form-control m-md-3" name="descriptif"/></td>
			</tr>
			<tr>
				<td><label for="image">Image (*)</label></td>
				<td><input type="file" class="form-control m-md-3" name="image" accept="image/*"/></td>
			</tr>
		</table>
		<input type="submit" class="btn btn-success" value="Ajouter"/>
		<a href="items" class="btn btn-danger m-md-3">Annuler</a>
	</form>
	</div>
</body>
</html>