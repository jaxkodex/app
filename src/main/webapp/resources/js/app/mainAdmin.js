/**
 * Monitoreo Web v1.0
 */


var app = app || {};

$(function () {
	app.workspace = new WorkspaceView ();
	app.workspace.render();
	new WorkspaceRouter;
	new AdminRouter;
	Backbone.history.start();
});