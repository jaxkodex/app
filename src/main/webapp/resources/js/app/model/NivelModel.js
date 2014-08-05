/**
 * 
 */

define(['backbone', 
        'AdminApplication'], function (Backbone, app) {
	app.meta.models.NivelModel = Backbone.Model.extend({
		idAttribute: 'idNivel',
		defaults: {
			nivelNombre: '',
			grados: []
		}
	});
	
	return app.meta.models.NivelModel;
});