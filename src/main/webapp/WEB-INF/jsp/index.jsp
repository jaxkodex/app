<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title>Administración</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
	
	<script type="text/javascript">
		baseUrl = '${pageContext.request.contextPath}';
	</script>
</head>
<body>

<div class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}">Educando</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar">
			 <ul class="nav navbar-nav">
			 	<li><a href="${pageContext.request.contextPath}/admin">Administración</a></li>
			 </ul>
		</div>
	</div>
</div>
<!-- 	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SME</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#evaluaciones">Evaluaciones</a></li>
					<li><a href="#">Configuración</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div id="workspace" class="container">
		<div class="row">
			<h2>Bienvenido!</h2>
		</div>
	</div> -->

<div class="container-fluid">
	<div id="workspace" class="row"></div>
</div>

<!-- Templates -->

<script type="text/template" id="workspaceTemplate">
<div class="col-sm-12"></div>
</script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/underscore.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/backbone.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/date.js"></script>
	

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/WorkspaceView.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/router/WorkspaceRouter.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/main.js"></script>
</body>
</html>
