/**
 * 
 */

var InstitucionEducativaModel = Backbone.Model.extend({
	urlRoot: baseUrl+'/institucion',
	idAttribute: 'idInstitucion',
	defaults: {
		institucionNombre: '',
		institucionActivo: 1
	}
});