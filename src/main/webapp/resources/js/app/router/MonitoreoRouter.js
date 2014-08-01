/**
 * 
 */

var app = app || {};

app.meta.routers.MonitoreoRouter = Backbone.Router.extend({
	initialize: function () {
		this.evaluacionCollection = app.instance.collections.evaluacionCollection;
	},
	routes: {
		'monitoreo/evaluacion': 'evaluacionList',
		'monitoreo/evaluacion/:id': 'evaluacion'
	},
	evaluacionList: function () {
		//
	},
	evaluacion: function (id) {
		app.meta.controller.showEvaluacionMonitoreo(id);
	}
});