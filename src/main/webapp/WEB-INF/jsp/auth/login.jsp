<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Inicie Sesión | Educando</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>

	<div class="login-box center-block">
		<div class="login-box-head">Inicie sesión</div>
		<div class="login-box-body">
			<form action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
				<div class="form-group">
					<label for="username">Usuario</label>
					<input type="text" class="form-control input-sm" name="username" id="username" placeholder="username" />
				</div>
				<div class="form-group">
					<label for="password">Contraseña</label>
					<input type="password" class="form-control input-sm" name="password" id="password" placeholder="contraseña" />
				</div>
				<button class="btn btn-sm btn-primary">Ingresar</button>
			</form>
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>