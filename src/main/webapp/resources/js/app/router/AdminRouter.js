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
		$('#workspace').empty().append(view.$el);
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
		console.log(model);
		console.log(model.toJSON());
		var view = new InstitucionEducativaFormView ({
			model: model,
			router: this
		});
		$('#workspace').empty().append(view.render().$el);
		if (id != null) view.model.fetch(); 
	}
});