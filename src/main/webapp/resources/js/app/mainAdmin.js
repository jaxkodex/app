/**
 * Monitoreo Web v1.0
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
	app.collections = app.collections || {};
	app.workspace = new WorkspaceView ();
	app.workspace.render();
	new WorkspaceRouter;
	new AdminRouter;
	new ConfigRouter;
	Backbone.history.start();
});