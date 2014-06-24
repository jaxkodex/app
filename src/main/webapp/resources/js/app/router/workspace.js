/**
 * Main Workspace Router
 */

var app = app || {};

var WorkspaceRouter = Backbone.Router.extend ({
	routes: {
		'': 'home',
		'home': 'home'
	},
	home: function () {
		app.views.workspace.$el.remove();
		$('body').append(app.views.workspace.render().$el);
		app.workspaceLoaded = true;
	}
});