/**
 * 
 */

var app = app || {};

var AdminRouter = Backbone.Router.extend({
	initialize: function () {
		this.institucionCollection = new InstitucionEducativaCollection;
		this.cargoCollection = new CargoCollection;
		this.periodoAcademicoCollection = new PeriodoAcademicoCollection;
		this.nivelCollection = new NivelCollection;
		this.gradoCollection = new GradoCollection;
		this.seccionCollection = new SeccionCollection;
	},
	routes: {
		'institucioneducativa': 'institucioneducativa',
		'institucioneducativa/edit(/:id)': 'editinstitucioneducativa',
		'cargo': 'cargoIndex',
		'cargo/edit(/:id)': 'editcargo',
		'periodoacademico(/)': 'periodoacademicoIndex',
		'periodoacademico/edit(/:id)': 'editperiodoacademico',
		'estructuraie(/)': 'estructuraieIndex',
		'admin/planadocente(/)': 'planaDocente'
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
		// try to get cached model
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
		// try to get cached model
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
	},
	periodoacademicoIndex: function () {
		var view = new PeriodoAcademicoListView({
			collection: this.periodoAcademicoCollection,
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
	editperiodoacademico: function (id) {
		// try to get cached model
		var model = this.periodoAcademicoCollection.get(id);
		if (id == null) model = new PeriodoAcademicoModel ();
		if (typeof model == 'undefined') { // not cached
			model = new PeriodoAcademicoModel ({
				idCargo: id
			});
			this.periodoAcademicoCollection.add(model);
		}
		var view = new PeriodoAcademicoFormView({
			model: model,
			collection: this.periodoAcademicoCollection,
			router: this
		});
		app.workspace.getWorkspaceArea().empty().append(view.render().$el);
		if (id != null) view.model.fetch();
	},
	estructuraieIndex: function () {
		console.log(this.gradoCollection);
		var view = new EstructuraInstitucionEducativaView({
			collection: this.nivelCollection,
			router: this,
			institucionCollection: this.institucionCollection,
			gradoCollection: this.gradoCollection,
			seccionCollection: this.seccionCollection
		});
		app.workspace.getWorkspaceArea().empty().append(view.$el);
		view.collection.fetch({
			silent: true, 
			success: function () {
				view.collection.trigger('add');
			}
		});
		view.options.institucionCollection.fetch({
			silent: true, 
			success: function () {
				view.options.institucionCollection.trigger('add');
			}
		});
	},
	planaDocente: function () {
		//
	}
});