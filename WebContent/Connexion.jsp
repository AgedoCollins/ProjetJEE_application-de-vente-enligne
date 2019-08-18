<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styles.css"/>
<title>Connexion</title>
</head>
<body>

	<div id="divConnexion" class="container">
		<form action="login" method="post">
			<fieldset class="connexion">
				<h1>Connexion</h1>
				<p  style="color : red">
					${empty msg ? '' : msg }
					${empty nouveauUtilisateur ? '' : nouveauUtilisateur}
				</p>
	  			<div class="input-group">
    				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    				<input id="email" type="text" class="form-control" name="email" value="${empty email ? '' : email}" placeholder="Email">
  				</div>
  				<div class="input-group">
    				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    				<input id="password" type="password" class="form-control" name="password" value="${empty password ? '' : password}" placeholder="Password">
 				</div>
 				<br>
  				<div class="input-group">
  					<input type="submit" class="btn btn-info" value="Connexion"/>
  					ou 
  					<a href="regit"class="btn btn-info">Créer un compte</a>
  				</div>
			</fieldset>
		</form>
	</div>

<!-- 	<div id="divInscription" class="container"> -->
<!-- 		<br> -->
<!-- 		<p>ou</p> -->
<!-- 		<br> -->
<!-- 		<form action="regit" method="get"> -->
<!-- 			<input type="submit" class="btn btn-info" value="Créer un compte"/> -->
<!-- 		</form> -->
<!-- 	</div> -->
</body>
</html>