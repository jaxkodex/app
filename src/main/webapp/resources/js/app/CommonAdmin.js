/**
 * 
 */


define(['view/AdminWorkspaceView',
        'view/InstitucionEducativaView',
        'view/CargoView',
        'view/PeriodoAcademicoView',
        'view/EstructuraInstitucionEducativaView',
        'view/PlanadocenteView',
        'router/AdminRouter',
        'AdminApplication',
        'require'], function (AdminWorkspaceView,
        		IntitucionEducativaView,
        		CargoView,
        		PeriodoAcademicoView,
        		EstructuraInstitucionEducativaView,
        		PlanadocenteView,
        		AdminRouter, 
        		app,
        		require) {
	var loaded;
	loaded = {};
	
	app.initialize = function () {
		this.workspace = new AdminWorkspaceView;
		this.workspace.render();
		
		new AdminRouter;
		Backbone.history.start();
	};
	
	app.load = function (file, component, callback) {
		if (!_.isUndefined(loaded[file])) return;
		loaded[file] = true;
		require([file], function (m) {
			/*_.each(m, function (val, index) {
				app.meta[component][index] = val;
			});*/
			callback();
			return m;
		});
	};
	
	app.renderCurrentView = function () {
		app.workspace.getDisplayArea().empty().append(this.currView.render().$el);
	};
	
	app.showInstitucionEducativaListView = function () {
		if (_.isUndefined(app.meta.views.InstitucionEducativaListView)) {
			app.load('view/InstitucionEducativaView', 'views', app.showInstitucionEducativaListView);
			return;
		}
		app.currView = new app.meta.views.InstitucionEducativaListView({
			collection: new app.meta.collections.InstitucionEducativaCollection
		});
		app.currView.collection.fetch({
			silent: true,
			success: function () {
				app.renderCurrentView();
			}
		});
	};
	
	app.showCargoListView = function () {
		app.currView = new app.meta.views.CargoListView({
			collection: new app.meta.collections.CargoCollection
		});
		app.currView.collection.fetch({
			silent: true,
			success: function () {
				app.renderCurrentView();
			}
		});
	};
	
	app.showPeriodoAcademico = function () {
		app.currView = new app.meta.views.PeriodoAcademicoListView ({
			collection: new app.meta.collections.PeriodoAcademicoCollection
		});
		app.currView.collection.fetch({
			silent: true,
			success: function () {
				app.renderCurrentView();
			}
		});
	};
	
	app.showEstructuraie = function () {
		this.currView = new this.meta.views.EstructuraInstitucionEducativaView ({
			collection: new this.meta.collections.NivelCollection,
			institucionCollection: new this.meta.collections.InstitucionEducativaCollection,
			gradoCollection: this.meta.collections.GradoCollection,
			seccionCollection: this.meta.collections.SeccionCollection
		});
		this.currView.collection.fetch({
			silent: true,
			success: function () {
				app.renderCurrentView();
			}
		});
	};
	
	app.showPlanadocente = function () {
		this.currView = new this.meta.views.PlanadocenteView ({
		});
		app.renderCurrentView();
	};

	return app;
});