/**
 * 
 */

var AdminRouter = Backbone.Router.extend({
	initialize: function () {
		this.institucionCollection = new InstitucionEducativaCollection()
	},
	routes: {
		'institucioneducativa': 'institucioneducativa',
		'institucioneducativa/edit(/:id)': 'editinstitucioneducativa'
	},
	institucioneducativa: function () {
		var view = new InstitucionEducativaListView ({
			collection: this.institucionCollection,
			router: this
		});
		view.$el.appendTo('#workspace');
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
			model: model
		});
		view.$el.appendTo('#workspace');
		if (id != null) view.model.fetch();
	}
});