<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vos articles</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/styles.css" />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<%@include file="Menu_V.html"%>
	</div>
	<div id="divParent" class="container">

		<p style="color: red">${empty msg ? '' : msg }</p>
		<br> <br>
		<c:set var="index" value="${-1}" scope="page" />
		<table class="table table-hover">
			<tr>
				<td>Libelle</td>
				<td>Prix</td>
				<td>Descriptif</td>
			</tr>
			<c:forEach items="${listArticles}" var="article">
				<c:set var="index" value="${index + 1}" />
				<tr>
					<td>${article.libelle}</td>
					<td>${article.prix}</td>
					<td>${article.descriptif}</td>
					<form action="modifierItem" method="get">
						<td><input type="hidden" name="index" value="${index}" /></td>
						<td><input type="submit" class="btn btn-info"
							value="Modifier" /></td>
					</form>
					<form action="deleteItem" method="get">
						<td><input type="hidden" name="index" value="${index}" /></td>
						<td><input type="submit" class="btn btn-info"
							value="Supprimer" /></td>
					</form>
				</tr>
			</c:forEach>
			<tr>
				<td>
					<form action="addItem" method="get">
						<button type="submit" class="btn btn-info">Ajouter un
							article</button>
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>