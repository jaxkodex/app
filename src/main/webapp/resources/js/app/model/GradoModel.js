/**
 * 
 */

define(['backbone', 'AdminApplication'], function (Backbone, app) {
	app.meta.models.GradoModel = Backbone.Model.extend({
		idAttribute: 'idGrado',
		defaults: {
			gradoNombre: ''
		}
	});
	
	return app.meta.models.GradoModel;
});