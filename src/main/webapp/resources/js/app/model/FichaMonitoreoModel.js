/**
 * 
 */


var FichaMonitoreoModel = Backbone.Model.extend({
	defaults: {
		formatoVersion: '1.0',
		formatoFecha: '',
		seccionEvaluacions: []
	},
	addSeccion: function (seccion) {
		var obj, secciones;
		obj = _.extend({
			seccionCodigo: '0000',
			seccionNombre: 'Nueva Sección',
			criterios: []
		}, seccion || {});
		secciones = _.extend([], this.get('seccionEvaluacions'));
		secciones.push(obj);
		this.set('seccionEvaluacions', secciones);
		return this;
	},
	addCriterio: function (seccionIndex, criterio) {
		var obj, secciones, seccion;
		if (typeof seccionIndex == 'undefined' ||
				this.get('seccionEvaluacions').length <= seccionIndex ||
				seccionIndex < 0) return this;
		obj = _.extend({
			criterioDescripcion: 'Nuevo criterio',
			opcions: []
		}, criterio || {});
		secciones = _.extend([], this.get('seccionEvaluacions'));
		seccion = _.extend({}, secciones[seccionIndex]);
		seccion.criterios.push(obj);
		secciones[seccionIndex] = seccion;
		this.set('seccionEvaluacions', secciones);
		this.trigger('change');
		return this;
	},
	addOpcion: function (seccionIndex, criterioIndex, opcion) {
		var obj, secciones, criterio;
		if (typeof seccionIndex == 'undefined' || typeof criterioIndex == 'undefined' ||
				this.get('seccionEvaluacions').length <= seccionIndex ||
				seccionIndex < 0) return this;
		secciones = _.extend([], this.get('seccionEvaluacions'));
		seccion = _.extend({}, secciones[seccionIndex]);
		if (seccion.criterios.length <= criterioIndex ||
				criterioIndex < 0) return this;
		criterio = _.extend({}, seccion.criterios[criterioIndex]);
		obj = _.extend({
			opcionDescripcion: 'Nueva opcion'
		}, opcion);
		criterio.opcions.push(obj);
		seccion.criterios[criterioIndex] = criterio;
		secciones[seccionIndex] = seccion;
		this.trigger('change');
		return this;
	}
});