/**
 * 
 */

var ConfiguracionRouter = Backbone.Router.extend({
	routes: {
		'config': 'index',
		'config/persona': 'listPersona',
		'config/persona/new': 'newPersona',
		'config/persona/edit/:id': 'editPersona'
	},
	initWorkspace: function () {
		if (typeof this.mainView == 'undefined') {
			this.mainView = app.views.config;
			this.index();
		}
	},
	index: function () {
		this.mainView = app.views.config;
		$('#workspace').empty().append(this.mainView.render().$el);
	},
	listPersona: function () {
		this.initWorkspace();
		//this.mainView.$('.col-sm-10').empty().append(app.views.personalist.render().$el);
		var view = new PersonaListView({
			collection: new PersonaCollection()
		});
		$('#workspace').empty().append(this.mainView.render().$el);
		this.mainView.$('.col-sm-10').empty().append(view.render().$el);
		console.log(view.$el);
	},
	newPersona: function () {
		this.initWorkspace();
		var view = new PersonaFormView({
			model: new Persona(),
			collection: new PersonaCollection()
		});
		$('#workspace').empty().append(this.mainView.render().$el);
		this.mainView.$('.col-sm-10').empty().append(view.render().$el);
	} ,
	editPersona: function (id) {
		var persona = new Persona({
			id: id
		}), me = this;
		persona.fetch({
			success: function () {
				me.initWorkspace();
				var view = new PersonaFormView({
					model: persona,
					collection: app.collections.personas
				});
				$('#workspace').empty().append(me.mainView.render().$el);
				me.mainView.$('.col-sm-10').empty().append(view.render().$el);
			}
		});
	} 
});