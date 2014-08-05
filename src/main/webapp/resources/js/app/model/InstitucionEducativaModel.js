/**
 * 
 */
	
/*
var InstitucionEducativaModel = Backbone.Model.extend({
	urlRoot: baseUrl+'/institucion',
	idAttribute: 'idInstitucion',
	defaults: {
		institucionNombre: '',
		institucionLema: '',
		institucionActivo: 1
	},
	validate: function (attrs, options) {
		var errs = {};
		if (attrs.institucionNombre.trim().length == 0) {
			errs.institucionNombre = 'El nombre de la Institución es requerido';
		}
		if (!$.isEmptyObject(errs)) {
			return errs;
		}
	}
}); */

define (['backbone', 'AdminApplication'], function (Backbone, app) {
	var InstitucionEducativaModel;
	InstitucionEducativaModel = Backbone.Model.extend({
		idAttribute: 'idInstitucion',
		defaults: {
			institucionNombre: '',
			institucionLema: '',
			intitucionActivo: 1
		},
		validate: function (attrs, options) {
			errs = {};
			if (attrs.institucionNombre.trim().length == 0) {
				errs.institucionNombre = 'El nombre de la Institución es requerido';
			}
			if (!$.isEmptyObject(errs)) {
				return errs;
			}
		}
	});
	
	app.meta.models.InstitucionEducativaModel = InstitucionEducativaModel;
	return InstitucionEducativaModel;
});