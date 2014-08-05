/**
 * 
 */

define(['backbone', 'AdminApplication'], function (Backbone, app) {
	app.meta.models.PeriodoAcademicoModel = Backbone.Model.extend({
		idAttribute: 'idPeriodo',
		defaults: {
			periodoActivo: true,
			periodoFfin: Date.today().getTime(),
			periodoFinicio: Date.today().getTime(),
			periodoNombre: ''
		}
	});
	return app.meta.models.PeriodoAcademicoModel;
});