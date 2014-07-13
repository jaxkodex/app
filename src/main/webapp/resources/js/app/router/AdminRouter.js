/**
 * 
 */

var app = app || {};

var AdminRouter = Backbone.Router.extend({
	initialize: function () {
		this.institucionCollection = new InstitucionEducativaCollection()
		this.cargoCollection = new CargoCollection();
	},
	routes: {
		'institucioneducativa': 'institucioneducativa',
		'institucioneducativa/edit(/:id)': 'editinstitucioneducativa',
		'cargo': 'cargoIndex',
		'cargo/edit(/:id)': 'editcargo',
	},
	institucioneducativa: function () {
		var view = new InstitucionEducativaListView ({
			collection: this.institucionCollection,
			router: this
		});
		app.workspace.getWorkspaceArea().empty().append(view.$el);
		//$('#workspace').empty().append(view.$el);
		view.collection.fetch({
			silent: true, 
			success: function () {
				view.collection.trigger('add');
			}
		});
	},
	editinstitucioneducativa: function (id) {
		// try to get catched model
		var model = this.institucionCollection.get(id);
		if (id == null) model = new InstitucionEducativaModel ();
		if (typeof model == 'undefined') { // not cached
			model = new InstitucionEducativaModel ({
				idInstitucion: id
			});
		}
		var view = new InstitucionEducativaFormView ({
			model: model,
			router: this
		});
		app.workspace.getWorkspaceArea().empty().append(view.render().$el);
		//$('#workspace').empty().append(view.render().$el);
		if (id != null) view.model.fetch(); 
	},
	cargoIndex: function () {
		var view = new CargoListView({
			collection: this.cargoCollection,
			router: this
		});
		app.workspace.getWorkspaceArea().empty().append(view.$el);
		view.collection.fetch({
			silent: true, 
			success: function () {
				view.collection.trigger('add');
			}
		});
	},
	editcargo: function (id) {
		console.log(id);
		// try to get catched model
		var model = this.cargoCollection.get(id);
		if (id == null) model = new CargoModel ();
		if (typeof model == 'undefined') { // not cached
			model = new CargoModel ({
				idCargo: id
			});
			this.cargoCollection.add(model);
		}
		var view = new CargoFormView({
			model: model,
			collection: this.cargoCollection,
			router: this
		});
		app.workspace.getWorkspaceArea().empty().append(view.render().$el);
		if (id != null) view.model.fetch(); 
	}
});