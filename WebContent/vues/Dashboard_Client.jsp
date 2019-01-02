<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Bean.Article" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styles.css"/>
</head>
<body>
	<h1>Bienvenue <jsp:getProperty name="client" property="prenom"/> <jsp:getProperty name="client" property="nom"/></h1>
	
	 <ul class="nav navbar-nav">
    <li><a href="logout">Déconnexion</a></li>
	</ul>
	<h1>${empty IdArticle ? '' : IdArticle}</h1>
	<c:forEach items="${listeArticles}" var="article">
	<%
	Article article = (Article) pageContext.getAttribute("article");
	%>
          <div class="card" style="width: 18rem;">
		  <img class="card-img-top" src="${pageContext.request.contextPath}/images" alt="Image de ${article.getLibelle()}">  		
		  <div class="card-body">
		    <h5 class="card-title">${article.getLibelle()}</h5>
		        <p class="card-text">${article.getPrix()}</p>
		  </div>
		  </div>
		    <a href="showArticle?id=${article.getId()}" class="card-link">Voir article</a>
      </c:forEach>
<!--  session.getAttribute("path_image") + "//"+ article.getNomImage()  -->
</body>
</html>