/**
 * 
 */

var EstructuraInstitucionEducativaView = Backbone.View.extend({
	initialize: function (options) {
		var options = options || {};
		if (typeof options.router != 'undefined') {
			this.router = options.router;
		}

		this.listenTo(this.collection, 'reset add remove', this.render);
	},
	tagName: 'div',
	className: 'col-sm-12',
	template: _.template($('#estructuraInstitucionEducativa').html()),
	render: function () {
		var me = this, container = document.createDocumentFragment();
		this.$el.html(this.template());
		this.collection.each(function (val) {
			var view = new EstructuraInstitucionEducativaNivelView({
				model: val,
				router: me.router
			});
			container.appendChild(view.render().el);
		});
		me.$el.find('ul').append(container);
		return this;
	}
});

var EstructuraInstitucionEducativaNivelView = Backbone.View.extend({
	initialize: function (options) {
		var options = options || {};
		if (typeof options.router != 'undefined') {
			this.router = options.router;
		}
		
		this.listenTo(this.model, 'change', this.render);
	},
	tagName: 'li',
	template: _.template($('#estructuraInstitucionEducativaNivel').html()),
	events: {
		//'click input[type=checkbox]': 'toggleActive',
		//'click .delete': 'destroy',
		//'click .edit': 'edit'
	},
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	edit: function (evt) {
		evt.preventDefault();
		this.router.navigate('cargo/edit/'+this.model.id, {trigger: true});
	}, 
	destroy: function (evt) {
		evt.preventDefault();
		this.model.destroy();
	}
});