<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un article</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>
	<div class="container">

		<p  style="color : red">
			${empty msg ? '' : msg }
		</p>
	<form action=modificationCorrect method="post">
		<table>
		<tr>
				<td><label for="id">id</label></td>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<td><label for="libelle">Libelle</label></td>
				<td><input type="text" name="libelle"/></td>
			</tr>
			
			<tr>
				<td><label for="prix">Prix</label></td>
				<td><input type="text" name="prix"/></td>
			</tr>
			
			<tr>
				<td><label for="descriptif">Descriptif</label></td>
				<td><input type="text" name="descriptif"/></td>
			</tr>
		</table>
		<input type="submit" value="Modifier"/>
	</form>
	</div>
</body>
</html>