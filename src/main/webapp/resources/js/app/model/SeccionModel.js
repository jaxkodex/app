/**
 * 
 */

define(['backbone', 'AdminApplication'], function (Backbone, app) {
	app.meta.models.SeccionModel = Backbone.Model.extend({
		idAttribute: 'idSeccion',
		defaults: {
			seccionNombre: ''
		}
	});
	
	return app.meta.models.SeccionModel;
});