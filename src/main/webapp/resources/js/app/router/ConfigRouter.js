/**
 * 
 */

var app = app || {};

var ConfigRouter = Backbone.Router.extend({
	initialize: function () {
		this.fichaMonitoreoCollection = app.collections.fichaMonitoreoCollection || new FichaMonitoreoCollection;
		this.seccionFichaMonitoreoCollection = app.collections.seccionFichaMonitoreoCollection || new SeccionFichaMonitoreoCollection;
	},
	routes: {
		'config/fichamonitoreo': 'fichamonitoreo',
		'config/fichamonitoreo/edit(/:id)': 'editfichamonitoreo'
	},
	fichamonitoreo: function () {
		var view = new FichaMonitoreoListView({
			collection: this.fichaMonitoreoCollection
		});
		app.workspace.getWorkspaceArea().empty().append(view.render().$el);
		view.collection.fetch({
			silent: true, 
			success: function () {
				view.collection.trigger('add');
			}
		});
	},
	editfichamonitoreo: function (id) {
		// try to get cached model
		var model = this.fichaMonitoreoCollection.get(id);
		if (id == null) model = new FichaMonitoreoModel ();
		if (typeof model == 'undefined') { // not cached
			model = new FichaMonitoreoModel ({
				idInstitucion: id
			});
			this.fichaMonitoreoCollection.add(model);
		}
		var view = new FichaMonitoreoFormView ({
			model: model, 
			router: this // This is not supposed to be done
		});
		app.workspace.getWorkspaceArea().empty().append(view.render().$el);
		//$('#workspace').empty().append(view.render().$el);
		if (id != null) view.model.fetch();
	}
});