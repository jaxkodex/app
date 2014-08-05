/**
 * Monitoreo Web v1.0
 */

/*var app = {
		router: {},
		views: {},
		models: {},
		collections: {},
		workspaceLoaded: false
};*/

var app = app || {};

app.meta = {
		views: {}
};
$(function () {
	/*
	app.models.persona = new Persona();
	app.collections.personas = new PersonaCollection();
	app.views.workspace = new WorkspaceView();
	app.views.config = new ConfigView();
	app.views.personaform = new PersonaFormView({
		model: app.models.persona,
		collection: app.collections.personas
	});
	app.views.personalist = new PersonaListView({
		collection: app.collections.personas
	});
	
	app.router.workspace = new WorkspaceRouter();
	app.router.evaluacion = new EvaluacionRouter();
	app.router.configuracion = new ConfiguracionRouter();
	
	app.router.workspace.home();
	Backbone.history.start();
	*/
	app.workspace = new WorkspaceView ();
	app.workspace.render();
	new WorkspaceRouter;
	Backbone.history.start();
});