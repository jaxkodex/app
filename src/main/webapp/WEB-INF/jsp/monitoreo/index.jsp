<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Administraci�n</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/backbone.modal.css">
	<script type="text/javascript">
	var formatosData, baseUrl;
	formatosData = ${formatosJSON};
	baseUrl = '${pageContext.request.contextPath}/api';
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
			 	<li class="active"><a href="${pageContext.request.contextPath}/admin">Administraci�n</a></li>
			 </ul>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div id="workspace" class="row"></div>
</div>

<script type="text/template" id="workspaceTemplate">
<div class="col-sm-2"></div>
<div class="col-sm-10 main"></div>
</script>

<script type="text/template" id="fichaMonitoreoFormTemplate">
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
								<h5>Datos de la sesi�n observada <small>(Datos a ser registrados mediante la observaci�n)</small></h5>
								<div class="form-group">
									<label>�rea o �reas desarrolladas</label>
									<input class="form-control input-sm" type="text" />
								</div>
								<div class="form-group">
									<label>Denominaci�n de la sesi�n y/o proyecto de aprendizaje</label>
									<input class="form-control input-sm" type="text" />
								</div>
								<div class="row">
									<div class="col-sm-2" style="margin-top: 10px;">
										<label>Nivel educativo:</label>
									</div>
									<div class="col-sm-2">
										<div class="checkbox">
											<label><input type="checkbox" <\% if(clase.seccion.grado.nivel.nivelNombre=='INICIAL') { %>checked<\% }%> disabled /> Inicial</label>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="checkbox">
											<label><input type="checkbox" <\% if(clase.seccion.grado.nivel.nivelNombre=='PRIMARIA') { %>checked<\% }%> disabled /> Primaria</label>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="checkbox">
											<label><input type="checkbox" <\% if(clase.seccion.grado.nivel.nivelNombre=='SECUNDARIA') { %>checked<\% }%> disabled /> Secundaria</label>
										</div>
									</div>
									<div class="col-sm-2">
										<label>Grado/a�o</label>
										<input type="text" class="form-control input-sm" value="<\%=clase.seccion.grado.gradoNombre%>" disabled />
									</div>
									<div class="col-sm-2">
										<label>Seccion</label>
										<input type="text" class="form-control input-sm" value="<\%=clase.seccion.seccionNombre%>" disabled />
									</div>
								</div>
								<div class="row">
									<div class="col-sm-2" style="margin-top: 10px;">
										<label>Turno:</label>
									</div>
									<div class="col-sm-2">
										<div class="checkbox">
											<label><input type="checkbox" <\% if(clase.turno.turnoCodigo=='M') { %>checked<\% }%> disabled /> Ma�ana</label>
										</div>
										<div class="checkbox">
											<label><input type="checkbox" <\% if(clase.turno.turnoCodigo=='T') { %>checked<\% }%> disabled /> Tarde</label>
										</div>
									</div>
									<div class="col-sm-4" style="margin-top: 10px;">
										<label>Tiempo de duraci�n de la sesi�n observada</label>
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
											<input class="form-control input-sm" type="text" value="<\%=clase.claseNmujeres%>" disabled />
										</div>
										<div class="col-sm-6">
											<label>Hombres</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" value="<\%=clase.claseNhombres%>" disabled />
										</div>
										<div class="col-sm-6">
											<label>Total</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" value="<\%=clase.claseNmujeres+clase.claseNhombres%>" disabled />
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
											<input class="form-control input-sm" type="text" value="<\%=clase.claseNminclusivos%>" disabled />
										</div>
										<div class="col-sm-6">
											<label>Hombres</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" value="<\%=clase.claseNhinclusivos%>" disabled />
										</div>
										<div class="col-sm-6">
											<label>Total</label>
										</div>
										<div class="col-sm-6">
											<input class="form-control input-sm" type="text" value="<\%=clase.claseNhinclusivos+clase.claseNminclusivos%>" disabled />
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
							<h4>DESARROLLO DE LA SESI�N DE APRENDIZAJE</h4>
							<div class="col-sm-12">
								<\% _.each(seccions, function (value, index) { %>
								<div class="row seccion-monitoreo">
								<div class="col-sm-1 text-right"><b><\%=value.seccionCodigo%></b></div>
								<div class="col-sm-11"><b><\%=value.seccionNombre%></b></div>
								</div>
								<div class="row">
								<div class="col-sm-1 col-sm-offset-10 text-center"><b>SI</b></div>
								<div class="col-sm-1 text-center"><b>NO</b></div>
								</div>
									<\% _.each(value.criterios, function (val, ind) { %>
									<div class="row criterio-monitoreo">
									<div class="col-sm-1 text-right"><\%=ind+1%></div>
									<div class="col-sm-9"><\%=val.criterioDescripcion%></div>
									<\% if (val.opcions.length < 1) { %>
									<div class="col-sm-1 text-center"><input type="radio" name="criterio-<\%=index%>-<\%=ind%>" /></div>
									<div class="col-sm-1 text-center"><input type="radio" name="criterio-<\%=index%>-<\%=ind%>" /></div>
									<\% } else { %>
									<div class="col-sm-2">&nbsp;</div>
									<\% } %>
									</div>
										<\% _.each(val.opcions, function (v, i) { %>
											<div class="row opcion-monitoreo">
											<div class="col-sm-1 col-sm-offset-1"><\%=i+1%></div>
											<div class="col-sm-8"><\%=v.opcionDescripcion%></div>
											<div class="col-sm-1 text-center"><input type="radio" name="opcion-<\%=index%>-<\%=ind%>-<\%=i%>" /></div>
											<div class="col-sm-1 text-center"><input type="radio" name="opcion-<\%=index%>-<\%=ind%>-<\%=i%>" /></div>
											</div>
										<\% }); %>
									<\% }); %>
								<\% }) %>
								</tbody>
								</table>
							</div>
						</div>
						<div class="col-sm-12">
							<h4>CONCLUSIONES GENERALES PRODUCTO DE LA ASESOR�A PERSONALIZADA</h4>
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
</script>


	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/underscore.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/backbone.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/date.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/backbone.modal.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/mainMonitoreo.js"></script>
	
	<!-- Models -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/FichaMonitoreoModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/EvaluacionModel.js"></script>
	
	<!-- Collections -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/FichaMonitoreoCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/EvaluacionCollection.js"></script>
	
	<!-- Views -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/MonitoreoView.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/WorkspaceView.js"></script>
	
	<!-- Routers -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/router/MonitoreoRouter.js"></script>
</body>
</html>