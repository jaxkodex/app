<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" -->
	<meta charset="utf-8">
	<title>Administraci�n</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/loadingbar.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/backbone.modal.css">
	
	<script type="text/javascript">
		var baseUrl = '${pageContext.request.contextPath}/api/admin';
	</script>
</head>
<body>

<!-- div class="navbar navbar-default navbar-fixed-top">
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
</div -->

<div class="container">
	<div id="workspace" class="row"></div>
</div>
	<!--div class="row">
		<div class="col-sm-10 col-sm-offset-2">
			<form>
				<div class="row">
				<div class="col-sm-2">
					<label>Docente</label>
					<input type="text" class="form-control input-sm" placeholder="DNI" />
				</div>
				<div class="col-sm-2">
					<label>Apellido paterno</label>
					<input type="text" class="form-control input-sm" placeholder="Apellido paterno" />
				</div>
				<div class="col-sm-2">
					<label>Apellido materno</label>
					<input type="text" class="form-control input-sm" placeholder="Apellido materno" />
				</div>
				<div class="col-sm-2">
					<label>Primer nombre</label>
					<input type="text" class="form-control input-sm" placeholder="Primer nombre" />
				</div>
				<div class="col-sm-4">
					<label>Segundo nombre</label>
					<input type="text" class="form-control input-sm" placeholder="Segundo nombre" />
				</div>
				</div>
				<div class="row">
				<div class="col-sm-2">
					<label>Nivel</label>
					<select class="form-control input-sm"></select>
				</div>
				<div class="col-sm-2">
					<label>Grado</label>
					<select class="form-control input-sm"></select>
				</div>
				<div class="col-sm-2">
					<label>Seccion</label>
					<select class="form-control input-sm"></select>
				</div>
				<div class="col-sm-2" style="margin-top: 10px;">
					<label>Turno</label>
				</div>
				<div class="col-sm-4">
					<div class="radio">
						<label><input name="turno" type="radio" value="M" /> Ma�ana</label>
					</div>
					<div class="radio">
						<label><input name="turno" type="radio" value="T" /> Tarde</label>
					</div>
				</div>
				</div>
				<div class="row">
				<div class="col-sm-2">
					<label>Periodo</label>
					<select class="form-control input-sm"></select>
				</div>
				<div class="col-sm-2">
					<label>Fecha inicio:</label>
					<input type="text" class="form-control input-sm" />
				</div>
				<div class="col-sm-8">&nbsp;</div>
				</div>
				<div class="row">
				<div class="col-sm-3">
					<label>Mujeres matriculadas:</label>
					<input type="text" class="form-control input-sm" />
				</div>
				<div class="col-sm-3">
					<label>Hombres matriculados:</label>
					<input type="text" class="form-control input-sm" />
				</div>
				<div class="col-sm-3">
					<label>Mujeres matriculadas:</label>
					<input type="text" class="form-control input-sm" />
				</div>
				<div class="col-sm-3">
					<label>Hombres matriculados:</label>
					<input type="text" class="form-control input-sm" />
				</div>
				</div>
			</form>
		</div>
	</div-->

<!-- Templates -->

<script type="text/template" id="workspaceTemplate">
<div class="col-sm-2">
	<img src="${pageContext.request.contextPath}/resources/img/educando.png" class="img-responsive" alt="Educando" />
	<ul class="list-unstyled">
		<li class="text-center"><a href="#"><span class="glyphicon glyphicon-user"></span> Jorge Vilca</a></li>
	</ul>

	<ul class="list-unstyled menu">
		<li>Configuraci�n
			<ul class="list-unstyled">
				<li><a href="#config/fichamonitoreo">Ficha de Monitoreo</a></li>
			</ul>
		</li>
		<li>Administraci�n
			<ul class="list-unstyled">
				<li><a href="#institucioneducativa">Institucion Educativa</a></li>
				<li><a href="#cargo">Cargo</a></li>
				<li><a href="#periodoacademico">Periodo Academico</a></li>
				<li><a href="#estructuraie">Estructura IE</a></li>
				<li><a href="#admin/planadocente">Plana Docente</a></li>
			</ul>
		</li>
	</ul>
</div>
<div class="col-sm-10">
	<div class="col-sm-12 clearfix">
		<ul class="nav nav-pills pull-right custom-nav">
			<li><a href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-home"></span> Inicio</a></li>
			<li class="active"><a href="${pageContext.request.contextPath}/admin"><span class="glyphicon glyphicon-cog"></span> Administraci�n</a></li>
			<li><a href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
		</ul>
	</div>
	<div class="col-sm-12 displayArea"></div>
</div>
</script>
<script type="text/template" id="institucionEducativaList">
<h2>Instituciones educativas</h2>
<div class="col-sm-12 clearfix">
	<a class="btn btn-link pull-right" href="#intitucioneducativa/edit"><span class="glyphicon glyphicon-plus"></span></a>
	<!--button class="btn btn-sm btn-primary pull-right new"><span class="glyphicon glyphicon-plus"></span></button-->
</div>
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
<h2>Periodo Acad�mico</h2>
<div class="col-sm-12 clearfix">
<a class="btn btn-link btn-sm pull-right" href="#periodoacademico/edit"><span class="glyphicon glyphicon-plus"></span></a>
</div>
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
<h2>Cargos</h2>
<div class="col-sm-12 clearfix">
<a class="btn btn-link btn-sm pull-right" href="#cargo/edit"><span class="glyphicon glyphicon-plus"></span></a>
</div>
<table class="table table-striped">
	<thead>
		<tr>
			<th>C�digo</th>
			<th>Descripci�n</th>
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
	<button class="btn btn-sm btn-link"><span class="glyphicon glyphicon-pencil"></span></button>
	<button class="btn btn-sm btn-link delete"><span class="glyphicon glyphicon-remove"></span></button>
</td>
</script>
<script type="text/template" id="cargoForm">
<form>
<div class="form-group">
	<label for="cargoCodigo">C�digo</label>
	<input type="text" class="form-control" id="cargoCodigo" value="<\%=cargoCodigo%>" />
</div>
<div class="form-group">
	<label for="cargoDescripcion">Descripci�n</label>
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
<h2>Estructura IE</h2>
<div class="col-sm-12 clearfix">
<button class="btn btn-default btn-sm pull-right addnivel"><span class="glyphicon glyphicon-plus"></span> Agregar nivel</button>
<div class="col-sm-2 pull-left"><select class="form-control input-sm" name="intitucion_educativa"></select></div>
</div>
<div class="col-sm-12">
<ul class="tree list-unstyled"><!--Main-->
</ul>
</div>
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
			<th>Secci�n</th>
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
<script type="text/template" id="planadocenteTemplate">
<h2>Plana Docente</h2>
<form>
<div class="col-sm-6">
	<label>IE</label>
	<select class="form-control input-sm"></select>
</div>
<div class="col-sm-6">
	<label>Periodo</label>
	<select class="form-control input-sm"></select>
</div>
<div class="col-sm-12">
	<table class="table">
		<thead>
			<tr>
				<th>Nivel</th>
				<th>Grado</th>
				<th>Seccion</th>
				<th>�rea</th>
				<th>Docente</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Inicial</td>
				<td>PRIMERO</td>
				<td>A</td>
				<td>COM</td>
				<td>JUAn</td>
			</tr>
		</tbody>
	</table>
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
		<th>Versi�n</th>
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
		<label for="formatoVersion">Versi�n</label>
		<input data-field="formatoVersion" type="text" class="form-control input-sm" id="formatoVersion" value="<\%=formatoVersion%>" />
	</div>
	<div class="form-group">
		<label for="formatoFecha">Fecha</label>
		<input data-field="formatoFecha" type="text" class="form-control input-sm" id="formatoFecha" value="<\%=formatoFecha%>" />
	</div>
	<div class="form-group clearfix">
		<label>Secciones</label>
		<a class="btn btn-link btn-xs pull-right btn-add-seccion" href="javascript:void(0);"><span class="glyphicon glyphicon-plus"></span></a>
	</div>
	<div class="form-group secciones">
		<\% _.each(seccionEvaluacions, function (val, index) { if (val == undefined) return; %>
			<div class="row seccion-header" id="seccion-wrapper-<\%=index%>">
				<div class="col-sm-12">
					<div class="col-sm-1 text-right">
						<span class="hidden_on_editing"><\%=val.seccionCodigo%></span>
						<input data-seccion="<\%=index%>" data-field="seccionCodigo" type="text" class="form-control input-sm edit" value="<\%=val.seccionCodigo%>" />
					</div>
					<div class="col-sm-9">
						<span class="hidden_on_editing"><\%=val.seccionNombre%></span>
						<input data-seccion="<\%=index%>" data-field="seccionNombre" type="text" class="form-control input-sm edit" value="<\%=val.seccionNombre%>" />
					</div>
					<div class="col-sm-2">
						<a data-seccion="<\%=index%>" href="javascript:void(0);" class="btn btn-link btn-sm btn-save-seccion edit"><span class="glyphicon glyphicon-floppy-disk"></span></a>
						<a data-seccion="<\%=index%>" href="javascript:void(0);" class="btn btn-link btn-sm btn-edit-seccion hidden_on_editing"><span class="glyphicon glyphicon-pencil"></span></a>
						<a data-seccion="<\%=index%>" href="javascript:void(0);" class="btn btn-link btn-sm btn-add-criterio hidden_on_editing"><span class="glyphicon glyphicon-plus"></span></a>
						<a data-seccion="<\%=index%>" href="javascript:void(0);" class="btn btn-link btn-sm btn-remove-seccion hidden_on_editing"><span class="glyphicon glyphicon-remove"></span></a>
					</div>
				</div>
			</div>
			<div class="criterios" id="criterios-wrapper-<\%=index%>">
				<\% _.each(val.criterios, function (v, i) { if (v == undefined) return; %>
				<div class="col-sm-12">
					<div class="col-sm-7 col-sm-offset-1">
						<span class="hidden_on_editing"><\%=v.criterioDescripcion%></span>
						<input data-seccion="<\%=index%>" data-criterio="<\%=i%>" data-field="criterioDescripcion" type="text" class="form-control input-sm edit" value="<\%=v.criterioDescripcion%>" />
					</div>
					<div class="col-sm-1 text-center">
						<input type="checkbox" />
					</div>
					<div class="col-sm-1 text-center">
						<input type="checkbox" />
					</div>
					<div class="col-sm-2">
						<a data-seccion="<\%=index%>" data-criterio="<\%=i%>" href="javascript:void(0);" class="btn btn-link btn-sm btn-add-opcion hidden_on_editing"><span class="glyphicon glyphicon-plus"></span></a>
						<a data-seccion="<\%=index%>" data-criterio="<\%=i%>" href="javascript:void(0);" class="btn btn-link btn-sm btn-remove-criterio hidden_on_editing"><span class="glyphicon glyphicon-remove"></span></a>
					</div>
				</div>
				<div class="col-sm-12 opciones">
				<\% _.each(v.opcions, function (o, ix) { if (o == undefined) return; %>
				<div class="col-sm-12" id="opcion-wrapper-<\%=ix%>">
					<div class="col-sm-6 col-sm-offset-2">
						<span class="hidden_on_editing"><\%=o.opcionDescripcion%></span>
						<input data-seccion="<\%=index%>" data-criterio="<\%=i%>" data-opcion="<\%=ix%>" data-field="opcionDescripcion" type="text" class="form-control input-sm edit" value="<\%=o.opcionDescripcion%>" />
					</div>
					<div class="col-sm-1 text-center">
						<input type="checkbox" />
					</div>
					<div class="col-sm-1 text-center">
						<input type="checkbox" />
					</div>
					<div class="col-sm-2">
						<a data-seccion="<\%=index%>" data-criterio="<\%=i%>" data-opcion="<\%=ix%>" href="javascript:void(0);" class="btn btn-link btn-sm btn-remove-opcion hidden_on_editing"><span class="glyphicon glyphicon-remove"></span></a>
					</div>
				</div>
				<\% }); %>
				</div>
				<\% }); %>
			</div>
		<\% }); %>
	</div>
	<div class="col-sm-12 clearfix">
		<input class="btn btn-primary btn-sm" type="submit" value="Guardar" />
	</div>
</form>
<!--form>
	<div class="form-group">
		<label for="formatoVersion">Versi�n</label>
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
	<div class="col-sm-12 clearfix">
		<input class="btn btn-primary btn-sm" type="submit" value="Guardar" />
	</div>
</form-->
</script>
<script type="text/template" id="fichaMonitoreoSeccionFormTemplate">
			<div class="row seccion-header">
				<div class="col-sm-12">
					<div class="col-sm-1">
						<span class="hidden_on_editing"><\%=seccionCodigo%></span>
						<input type="text" class="form-control input-sm edit" value="<\%=seccionCodigo%>" />
					</div>
					<div class="col-sm-9">
						<span class="hidden_on_editing"><\%=seccionNombre%></span>
						<input type="text" class="form-control input-sm edit" value="<\%=seccionNombre%>" />
					</div>
					<div class="col-sm-2">
						<a href="javascript:void(0);" class="btn btn-link btn-sm btn-add-criterio"><span class="glyphicon glyphicon-plus"></span></a>
						<a href="javascript:void(0);" class="btn btn-link btn-sm btn-remove-seccion"><span class="glyphicon glyphicon-remove"></span></a>
					</div>
				</div>
			</div>
			<div class="criterios"></div>
</script>
<script type="text/template" id="fichaMonitoreoCriterioFormTemplate">
				<div class="col-sm-12">
					<div class="col-sm-7 col-sm-offset-1">
						<span class="hidden_on_editing"><\%=criterioDescripcion%></span>
						<input type="text" class="form-control input-sm edit" value="<\%=criterioDescripcion%>" />
					</div>
					<div class="col-sm-1 text-center">
						<input type="checkbox" />
					</div>
					<div class="col-sm-1 text-center">
						<input type="checkbox" />
					</div>
					<div class="col-sm-2">
						<a href="javascript:void(0);" class="btn btn-link btn-sm"><span class="glyphicon glyphicon-pencil"></span></a>
						<a href="javascript:void(0);" class="btn btn-link btn-sm btn-add-opcion"><span class="glyphicon glyphicon-plus"></span></a>
						<a href="javascript:void(0);" class="btn btn-link btn-sm btn-remove-criterio"><span class="glyphicon glyphicon-remove"></span></a>
						<!--a href="javascript:void(0);" class="btn btn-link btn-sm"><span class="glyphicon glyphicon-th-list"></span></a-->
					</div>
				</div>
				<div class="col-sm-12 opciones"></div>
</script>
<script type="text/template" id="fichaMonitoreoOpcionFormTemplate">
				<div class="col-sm-12">
					<div class="col-sm-6 col-sm-offset-2">
						<span class="hidden_on_editing"><\%=opcionDescripcion%></span>
						<input type="text" class="form-control input-sm edit" value="<\%=opcionDescripcion%>" />
					</div>
					<div class="col-sm-1 text-center">
						<input type="checkbox" />
					</div>
					<div class="col-sm-1 text-center">
						<input type="checkbox" />
					</div>
					<div class="col-sm-2">
						<a href="javascript:void(0);" class="btn btn-link btn-sm btn-edit-opcion"><span class="glyphicon glyphicon-pencil"></span></a>
						<a href="javascript:void(0);" class="btn btn-link btn-sm btn-remove-opcion"><span class="glyphicon glyphicon-remove"></span></a>
					</div>
				</div>
</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/date.js"></script>

<!-- 
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/underscore.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/backbone.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/date.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/backbone.modal.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/mainAdmin.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/PersonaModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/InstitucionEducativaModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/CargoModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/PeriodoAcademicoModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/NivelModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/GradoModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/SeccionModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/FichaMonitoreoModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/SeccionFichaMonitoreoModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/CriterioFichaMonitoreoModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/OpcionFichaMonitoreoModel.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/PersonaCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/InstitucionEducativaCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/CargoCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/PeriodoAcademicoCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/NivelCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/GradoCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/SeccionCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/FichaMonitoreoCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/SeccionFichaMonitoreoCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/CriterioFichaMonitoreoCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/OpcionFichaMonitoreoCollection.js"></script>
	
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
	-->
	<script data-main="${pageContext.request.contextPath}/resources/js/app/mainAdmin.js" src="${pageContext.request.contextPath}/resources/js/require.js"></script>
</body>
</html>