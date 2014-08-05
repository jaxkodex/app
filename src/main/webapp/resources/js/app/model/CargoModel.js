/**
 * 
 */

define(['backbone', 'AdminApplication'], function (Backbone, app) {
	app.meta.models.CargoModel = Backbone.Model.extend({
		idAttribute: 'idCargo',
		defaults: {
			activo: true,
			cargoCodigo: '',
			cargoDescripcion: ''
		}
	});
	
	return app.meta.models.CargoModel;
});