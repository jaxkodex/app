<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Administración</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/backbone.modal.css">
	<script type="text/javascript">
	var formatosData = ${formatosJSON};
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
			 	<li class="active"><a href="${pageContext.request.contextPath}/admin">Administración</a></li>
			 </ul>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div id="workspace" class="row"></div>
</div>

<script type="text/template" id="formatoEvaluacion">
		<div class="col-sm-2">
			<h2>Educando</h2>
		</div>
		<div class="col-sm-10">
			<div class="col-sm-12">
				<h3>Ficha de monitoreo</h3>
				<form>
					<div class="col-sm-12 clearfix">
						<div class="btn-group pull-right">
							<button class="btn btn-default btn-sm"><span class="glyphicon glyphicon-chevron-left"></span></button>
							<button class="btn btn-default btn-sm"><span class="glyphicon glyphicon-chevron-right"></span></button>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="col-sm-12">
							<h4>DATOS GENERALES</h4>
							<div class="col-sm-12">
								<h5>Datos de la sesión observada <small>(Datos a ser registrados mediante la observación)</small></h5>
								<div class="form-group">
									<label>Área o áreas desarrolladas</label>
									<input class="form-control input-sm" type="text" />
								</div>
								<div class="form-group">
									<label>Denominación de la sesión y/o proyecto de aprendizaje</label>
									<input class="form-control input-sm" type="text" />
								</div>
								<div class="row">
									<div class="col-sm-2" style="margin-top: 10px;">
										<label>Nivel educativo:</label>
									</div>
									<div class="col-sm-2">
										<div class="checkbox">
											<label><input type="checkbox" /> Inicial</label>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="checkbox">
											<label><input type="checkbox" /> Primaria</label>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="checkbox">
											<label><input type="checkbox" /> Secundaria</label>
										</div>
									</div>
									<div class="col-sm-2">
										<label>Grado/año</label>
										<input type="text" class="form-control input-sm" />
									</div>
									<div class="col-sm-2">
										<label>Seccion</label>
										<input type="text" class="form-control input-sm" />
									</div>
								</div>
								<div class="row">
									<div class="col-sm-2" style="margin-top: 10px;">
										<label>Turno:</label>
									</div>
									<div class="col-sm-2">
										<div class="checkbox">
											<label><input type="checkbox" /> Mañana</label>
										</div>
										<div class="checkbox">
											<label><input type="checkbox" /> Tarde</label>
										</div>
									</div>
									<div class="col-sm-4" style="margin-top: 10px;">
										<label>Tiempo de duración de la sesión observada</label>
									</div>
									<div class="col-sm-2">
										<label>Horas</label>
										<input type="text" class="form-control input-sm" />
									</div>
									<div class="col-sm-2">
										<label>Minutos</label>
										<input type="text" class="form-control input-sm" />
									</div>
								</div>
								<div class="row">
									<div class="col-sm-2">
										<label>Estudiantes matriculados:</label>
									</div>
									<div class="col-sm-4">
										<div class="col-sm-6">
											<label>Mujeres</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" />
										</div>
										<div class="col-sm-6">
											<label>Hombres</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" />
										</div>
										<div class="col-sm-6">
											<label>Total</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" />
										</div>
									</div>
									<div class="col-sm-2">
										<label>Estudiantes asistentes:</label>
									</div>
									<div class="col-sm-4">
										<div class="col-sm-6">
											<label>Mujeres</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" />
										</div>
										<div class="col-sm-6">
											<label>Hombres</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" />
										</div>
										<div class="col-sm-6">
											<label>Total</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-2">
										<label>Estudiantes inclusivos matriculados:</label>
									</div>
									<div class="col-sm-4">
										<div class="col-sm-6">
											<label>Mujeres</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" />
										</div>
										<div class="col-sm-6">
											<label>Hombres</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" />
										</div>
										<div class="col-sm-6">
											<label>Total</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" />
										</div>
									</div>
									<div class="col-sm-2">
										<label>Estudiantes inclusivos asistentes:</label>
									</div>
									<div class="col-sm-4">
										<div class="col-sm-6">
											<label>Mujeres</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" />
										</div>
										<div class="col-sm-6">
											<label>Hombres</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" />
										</div>
										<div class="col-sm-6">
											<label>Total</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<h4>DESARROLLO DE LA SESIÓN DE APRENDIZAJE</h4>
							<div class="col-sm-12"></div>
						</div>
						<div class="col-sm-12">
							<h4>CONCLUSIONES GENERALES PRODUCTO DE LA ASESORÍA PERSONALIZADA</h4>
							<div class="row">
								<div class="col-sm-12">
									<div class="col-sm-6">
										<label>Fortalezas</label>
										<input type="text" class="form-control" />
									</div>
									<div class="col-sm-6"></div>
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="col-sm-12">
								<div class="form-group">
									<label>Compromiso</label>
									<textarea class="form-control"></textarea>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
</script>


	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/underscore.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/backbone.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/date.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/backbone.modal.js"></script>
</body>
</html>