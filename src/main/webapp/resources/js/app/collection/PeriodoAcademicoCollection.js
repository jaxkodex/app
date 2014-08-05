/**
 * 
 */

define(['backbone', 
        'model/PeriodoAcademicoModel', 
        'AdminApplication'], function (Backbone, PeriodoAcademicoModel, app) {
	app.meta.collections.PeriodoAcademicoCollection = Backbone.Collection.extend({
		url: app.baseUrl+'/periodoacademico',
		model: PeriodoAcademicoModel
	});
});