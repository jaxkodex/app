<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" -->
	<meta charset="utf-8">
	<title>Administración</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/backbone.modal.css">
	
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
			 	<li class="active"><a href="${pageContext.request.contextPath}/admin">Administración</a></li>
			 </ul>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div id="workspace" class="row"></div>
</div>

<!-- Templates -->

<script type="text/template" id="workspaceTemplate">
<div class="col-sm-2">
	<ul class="list-unstyled">
		<li>Configuración
			<ul>
				<li><a href="#config/fichamonitoreo">Ficha de Monitoreo</a></li>
			</ul>
		</li>
		<li>Administración
			<ul>
				<li><a href="#institucioneducativa">Institucion Educativa</a></li>
				<li><a href="#cargo">Cargo</a></li>
				<li><a href="#periodoacademico">Periodo Academico</a></li>
				<li><a href="#estructuraie">Estructura IE</a></li>
				<li><a href="#planadocente">Plana Docente</a></li>
			</ul>
		</li>
	</ul>
</div>
<div class="col-sm-10"></div>
</script>
<script type="text/template" id="institucionEducativaList">
<div class="col-sm-12"><button class="btn btn-sm btn-primary pull-right new"><span class="glyphicon glyphicon-plus"></span></button></div>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Lema</th>
			<th>Estado</th>
			<th></th>
		</tr>
	</thead>
	<tbody></tbody>
</table>
</script>
<script type="text/template" id="institucionEducativaItemList">
<td><\%=institucionNombre%></td>
<td><\%=institucionLema%></td>
<td><input type="checkbox" <\% if (institucionActivo == true) { %>checked<\% }%> /></td>
<td>
	<button class="btn btn-sm btn-default edit"><span class="glyphicon glyphicon-pencil"></span></button>
	<button class="btn btn-sm btn-default delete"><span class="glyphicon glyphicon-remove"></span></button>
</td>
</script>
<script type="text/template" id="institucionEducativaForm">
<form>
<div class="form-group">
	<label class="control-label" for="institucionNombre">Nombre:</label>
	<input type="text" class="form-control" id="institucionNombre" value="<\%=institucionNombre%>" />
	<span class="help-block hidden">Este campo es obligatorio.</span>
</div>
<div class="form-group">
	<label class="control-label" for="institucionLema">Lema:</label>
	<input type="text" class="form-control" id="institucionLema" value="<\%=institucionLema%>" />
</div>
<div class="checkbox">
	<label>
		<input type="checkbox" <\% if (institucionActivo == true) { %>checked<\% }%> />
		Activo
	</label>
</div>
<input type="button" class="btn btn-default cancel" value="Cancelar" />
<input type="submit" class="btn btn-default" value="Guardar" />
</from>
</script>
<script type="text/template" id="periodoAcademicoList">
<a class="btn btn-default btn-sm pull-right" href="#periodoacademico/edit"><span class="glyphicon glyphicon-plus"></span></a>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Fecha de Inicio</th>
			<th>Fecha de Fin</th>
			<th>Estado</th>
			<th></th>
		</tr>
	</thead>
	<tbody></tbody>
</table>
</script>
<script type="text/template" id="periodoAcademicoItemList">
<td><\%=periodoNombre%></td>
<td><\%=new Date(periodoFinicio).toString('dd/MM/yyyy')%></td>
<td><\%=new Date(periodoFfin).toString('dd/MM/yyyy')%></td>
<td><input type="checkbox" <\% if (periodoActivo == true) { %>checked<\% }%> /></td>
<td>
	<button class="btn btn-sm btn-default edit"><span class="glyphicon glyphicon-pencil"></span></button>
	<button class="btn btn-sm btn-default delete"><span class="glyphicon glyphicon-remove"></span></button>
</td>
</script>
<script type="text/template" id="periodoAcademicoForm">
<form>
<div class="form-group">
	<label for="periodoNombre">Periodo:</label>
	<input type="text" class="form-control" id="periodoNombre" value="<\%=periodoNombre%>" />
</div>
<div class="form-group">
	<label for="periodoFinicio">Desde:</label>
	<input type="text" class="form-control" id="periodoFinicio" value="<\%=new Date(periodoFinicio).toString('dd/MM/yyyy')%>" />
</div>
<div class="form-group">
	<label for="periodoFfin">Hasta:</label>
	<input type="text" class="form-control" id="periodoFfin" value="<\%=new Date(periodoFfin).toString('dd/MM/yyyy')%>" />
</div>
<div class="checkbox">
	<label>
		<input type="checkbox" id="periodoActivo" <\% if (periodoActivo == true) { %>checked<\% }%> />
		Activo
	</label>
</div>
<input type="button" class="btn btn-default cancel" value="Cancelar" />
<input type="submit" class="btn btn-default" value="Guardar" />
</from>
</script>
<script type="text/template" id="cargoList">
<a class="btn btn-default btn-sm pull-right" href="#cargo/edit"><span class="glyphicon glyphicon-plus"></span></a>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Código</th>
			<th>Descripción</th>
			<th>Estado</th>
			<th></th>
		</tr>
	</thead>
	<tbody></tbody>
</table>
</script>
<script type="text/template" id="cargoItemList">
<td><\%=cargoCodigo%></td>
<td><\%=cargoDescripcion%></td>
<td><input type="checkbox" <\% if (activo == true) { %>checked<\% }%> /></td>
<td>
	<button class="btn btn-sm btn-default edit"><span class="glyphicon glyphicon-pencil"></span></button>
	<button class="btn btn-sm btn-default delete"><span class="glyphicon glyphicon-remove"></span></button>
</td>
</script>
<script type="text/template" id="cargoForm">
<form>
<div class="form-group">
	<label for="cargoCodigo">Código</label>
	<input type="text" class="form-control" id="cargoCodigo" value="<\%=cargoCodigo%>" />
</div>
<div class="form-group">
	<label for="cargoDescripcion">Descripción</label>
	<input type="text" class="form-control" id="cargoDescripcion" value="<\%=cargoDescripcion%>" />
</div>
<div class="checkbox">
	<label>
		<input type="checkbox" id="cargoActivo" <\% if (activo == true) { %>checked<\% }%> />
		Activo
	</label>
</div>
<input type="button" class="btn btn-default cancel" value="Cancelar" />
<input type="submit" class="btn btn-default" value="Guardar" />
</from>
</script>
<script type="text/template" id="estructuraInstitucionEducativa">
<div class="col-sm-12">
<button class="btn btn-default btn-sm pull-right addnivel"><span class="glyphicon glyphicon-plus"></span> Agregar nivel</button>
<div class="col-sm-2 pull-left"><select class="form-control input-sm" name="intitucion_educativa"></select></div>
</div>
<ul class="tree list-unstyled"><!--Main-->
</ul>
</script>
<script type="text/template" id="estructuraInstitucionEducativaNivel">
<span class="desc hidden_on_editing"><\%=nivelNombre%></span>
<button class="btn btn-link btn-xs editbtn hidden_on_editing"><span class="glyphicon glyphicon-pencil"></span></button>
<button class="btn btn-link btn-xs addgradobtn hidden_on_editing"><span class="glyphicon glyphicon-plus"></span></button>
<button class="btn btn-link btn-xs removenivelbtn hidden_on_editing"><span class="glyphicon glyphicon-remove"></span></button>
<input type="text" value="<\%=nivelNombre%>" class="form-control input-sm edit">
<ul></ul>
</script>
<script type="text/template" id="estructuraInstitucionEducativaGrado">
<span class="hidden_on_editing"><\%=gradoNombre%></span>
<button class="btn btn-link btn-xs editbtn hidden_on_editing"><span class="glyphicon glyphicon-pencil"></span></button>
<button class="btn btn-link btn-xs addbtn hidden_on_editing"><span class="glyphicon glyphicon-plus"></span></button>
<button class="btn btn-link btn-xs removebtn hidden_on_editing"><span class="glyphicon glyphicon-remove"></span></button>
<input type="text" value="<\%=gradoNombre%>" class="form-control input-sm edit">
<ul></ul>
</script>
<script type="text/template" id="estructuraInstitucionEducativaSeccion">
<span class="hidden_on_editing"><\%=seccionNombre%></span>
<button class="btn btn-link btn-xs editbtn hidden_on_editing"><span class="glyphicon glyphicon-pencil"></span></button>
<button class="btn btn-link btn-xs removebtn hidden_on_editing"><span class="glyphicon glyphicon-remove"></span></button>
<input type="text" value="<\%=seccionNombre%>" class="form-control input-sm edit">
<ul></ul>
</script>
<script type="text/template" id="asignacionDocenteList">
<form class="form-inline">
	<div class="form-group">
		<label for="filtroInstitucionEducativa">Institucion Educativa</label>
		<select class="form-control input-sm" id="filtroInstitucionEducativa">
		</select>
	</div>
</form>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Docente</th>
			<th>Grado</th>
			<th>Sección</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
</script>
<script type="text/template" id="asignacionDocenteForm">
<form>
<div class="form-group">
	<label for="personaDni">DNI</label>
	<input class="form-control input-sm" id="personaDni" value="<\%=personaDni%>" />
</div>
<div class="form-group">
	<label for="personaApaterno">Nombres</label>
	<div class="row">
		<div class="col-sm-3">
			<input class="form-control input-sm" id="personaApaterno" value="<\%=personaApaterno%>" placeholder="Apellido paterno" />
		</div>
		<div class="col-sm-3">
			<input class="form-control input-sm" id="personaAmaterno" value="<\%=personaAmaterno%>" placeholder="Apellido materno" />
		</div>
		<div class="col-sm-3">
			<input class="form-control input-sm" id="personaPnombre" value="<\%=personaPnombre%>" placeholder="Primer Nombre" />
		</div>
		<div class="col-sm-3">
			<input class="form-control input-sm" id="personaSnombre" value="<\%=personaSnombre%>" placeholder="Nombres" />
		</div>
	</div>
</div>
<div class="form-group">
	<label for="idCargo">Cargo</label>
	<select class="form-control" id="idCargo">
	</select>
</div>
</form>
</script>


<!-- Configuracion -->
<script type="text/template" id="fichaMonitoreoListTemplate">
<h4>Ficha de monitoreo</h4>
<div class="row">
	<div class="col-sm-12 clearfix">
		<a class="btn btn-default btn-sm pull-right" href="#config/fichamonitoreo/edit"><span class="glyphicon glyphicon-plus"></span></a>
	</div>
</div>
<table class="table">
<thead>
	<tr>
		<th>Fecha</th>
		<th>Versión</th>
		<th></th>
	</tr>
</thead>
<tbody></tbody>
</table>
</script>
<script type="text/template" id="fichaMonitoreoItemListTemplate">
<td><\%=formatoFecha%></td>
<td><\%=formatoVersion%></td>
<td></td>
</script>
<script type="text/template" id="fichaMonitoreoFormTemplate">
<h4>Ficha de monitoreo</h4>
<form>
	<div class="form-group">
		<label for="formatoVersion">Versión</label>
		<input type="text" class="form-control input-sm" id="formatoVersion" />
	</div>
	<div class="form-group">
		<label for="formatoFecha">Fecha</label>
		<input type="text" class="form-control input-sm" id="formatoFecha" />
	</div>
	<div class="form-group clearfix">
		<label>Secciones</label>
		<a class="btn btn-link btn-xs pull-right btn-add-seccion" href="javascript:void(0);"><span class="glyphicon glyphicon-plus"></span></a>
	</div>
	<div class="form-group secciones">
	</div>
</form>
</script>
<script type="text/template" id="fichaMonitoreoSeccionFormTemplate">
			<div class="row seccion-header">
				<div class="col-sm-12">
					<div class="col-sm-1">
						<input type="text" class="form-control input-sm" />
					</div>
					<div class="col-sm-10">
						<input type="text" class="form-control input-sm" />
					</div>
					<div class="col-sm-1">
						<a href="javascript:void(0);" class="btn btn-link btn-sm"><span class="glyphicon glyphicon-pencil"></span></a>
						<a href="javascript:void(0);" class="btn btn-link btn-sm"><span class="glyphicon glyphicon-remove"></span></a>
					</div>
				</div>
			</div>
</script>
<script type="text/template" id="fichaMonitoreoCriterioFormTemplate">
				<div class="col-sm-12">
					<div class="col-sm-7 col-sm-offset-1">
						<input type="text" class="form-control input-sm" />
					</div>
					<div class="col-sm-1 text-center">
						<input type="checkbox" />
					</div>
					<div class="col-sm-1 text-center">
						<input type="checkbox" />
					</div>
					<div class="col-sm-2">
						<a href="javascript:void(0);" class="btn btn-link btn-sm"><span class="glyphicon glyphicon-pencil"></span></a>
						<a href="javascript:void(0);" class="btn btn-link btn-sm"><span class="glyphicon glyphicon-remove"></span></a>
						<a href="javascript:void(0);" class="btn btn-link btn-sm"><span class="glyphicon glyphicon-th-list"></span></a>
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
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/PersonaModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/InstitucionEducativaModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/CargoModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/PeriodoAcademicoModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/NivelModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/GradoModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/SeccionModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/FichaMonitoreoModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/SeccionFichaMonitoreoModel.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/PersonaCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/InstitucionEducativaCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/CargoCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/PeriodoAcademicoCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/NivelCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/GradoCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/SeccionCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/FichaMonitoreoCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/SeccionFichaMonitoreoCollection.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/WorkspaceView.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/InstitucionEducativaView.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/CargoView.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/PeriodoAcademicoView.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/EstructuraInstitucionEducativaView.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/FichaMonitoreoView.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/router/WorkspaceRouter.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/router/AdminRouter.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/router/EvaluacionDocenteRouter.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/router/ConfigRouter.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/mainAdmin.js"></script>
</body>
</html>