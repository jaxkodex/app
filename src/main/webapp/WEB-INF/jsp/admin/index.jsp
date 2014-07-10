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
	
	<script type="text/javascript">
		baseUrl = '${pageContext.request.contextPath}';
	</script>
</head>
<body>

<div class="container-fluid">
	<div id="workspace" class="row"></div>
</div>

<!-- Templates -->

<script type="text/template" id="workspaceTemplate">
<div class="col-sm-2">
	<ul class="list-unstyled">
		<li>Administración
			<ul>
				<li><a href="#institucioneducativa">Institucion Educación</a></li>
				<li><a href="#cargo">Cargo</a></li>
			</ul>
		</li>
	</ul>
</div>
<div class="col-sm-10"></div>
<!--div></div-->
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
<td><\%=periodoFinicio%></td>
<td><\%=periodoFfin%></td>
<td><input type="checkbox" value="<\%=periodoActivo%>" /></td>
<td>
	<button class="btn btn-sm btn-default"><span class="glyphicon glyphicon-pencil"></span></button>
	<button class="btn btn-sm btn-default"><span class="glyphicon glyphicon-remove"></span></button>
</td>
</script>
<script type="text/template" id="cargoList">
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
<td><input type="checkbox" value="<\%=cargoActivo%>" /></td>
<td>
	<button class="btn btn-sm btn-default"><span class="glyphicon glyphicon-pencil"></span></button>
	<button class="btn btn-sm btn-default"><span class="glyphicon glyphicon-remove"></span></button>
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
		<input type="checkbox" id="cargoActivo" value="<\%=cargoActivo%>" />
		Activo
	</label>
</div>
<input type="button" class="btn btn-default cancel" value="Cancelar" />
<input type="submit" class="btn btn-default" value="Guardar" />
</from>
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


	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/underscore.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/backbone.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/PersonaModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/InstitucionEducativaModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/model/CargoModel.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/PersonaCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/InstitucionEducativaCollection.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/collection/CargoCollection.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/WorkspaceView.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/InstitucionEducativaView.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/view/CargoView.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/router/WorkspaceRouter.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/router/AdminRouter.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/main.js"></script>
</body>
</html>