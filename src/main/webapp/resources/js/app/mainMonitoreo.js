/**
 * 
 */

var app = {
		meta: {
			models: {},
			collections: {},
			routers: {},
			views: {}
		},
		instance: {
			collections: {}
		},
		controller: {}
};

$(function () {
	// MonitoreoController definition
	app.meta.controller = {
			showEvaluacionMonitoreo: function (idEvaluacion) {
				var formato, evaluacion, formatoCollection, evaluacionCollection, displayForm, view;
				evaluacionCollection = app.instance.collections.evaluacionCollection;
				formatoCollection = app.instance.collections.formatoEvaluacionCollection;
				evaluacion = {};
				
				displayForm = function () {
					formato = formatoCollection.get(evaluacion.get('formatoEvaluacion'));
					view = new app.meta.views.MonitoreoFormView({
						model: evaluacion,
						formatoEvaluacion: formato
					});
					app.workspace.setMainView(view);
				};
				
				evaluacion = evaluacionCollection.get(idEvaluacion);
				if (evaluacion == null || typeof evaluacion == 'undefined') {
					evaluacion = new app.meta.models.EvaluacionModel({ idEvaluacion: idEvaluacion });
					evaluacionCollection.add(evaluacion);
					evaluacion.fetch({
						success: displayForm
					});
				} else {
					displayForm();
				}
			}
	};
	
	// initialization
	app.instance.collections.evaluacionCollection = new app.meta.collections.EvaluacionCollection;
	app.instance.collections.formatoEvaluacionCollection = new app.meta.collections.FichaMonitoreoCollection(formatosData);
	
	app.workspace = new app.meta.views.WorkspaceView;
	app.workspace.render();
	
	// Routing
	new app.meta.routers.MonitoreoRouter;
	Backbone.history.start();
});