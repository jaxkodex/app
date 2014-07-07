/**
 * 
 */

var InstitucionEducativaListView = Backbone.View.extend({
	initialize: function (options) {
		var options = options || {};
		this.listenTo(this.collection, 'reset add remove', this.render);
		if (typeof options.router != 'undefined') {
			this.router = options.router;
		}
	},
	events: {
		'click .new': 'addNew'
	},
	tagName: 'div',
	className: 'col-sm-12',
	template: _.template($('#institucionEducativaList').html()),
	render: function () {
		var me = this, container = document.createDocumentFragment();
		this.$el.html(this.template());
		this.collection.each(function (val) {
			var view = new InstitucionEducativaListItemView({
				model: val
			});
			container.appendChild(view.render().el);
		});
		me.$el.find('tbody').append(container);
		return this;
	},
	addNew: function () {
		this.router.navigate('institucioneducativa/edit', {trigger: true});
	}
});

var InstitucionEducativaListItemView = Backbone.View.extend({
	initialize: function () {
		this.listenTo(this.model, 'change', this.render);
	},
	tagName: 'tr',
	template: _.template($('#institucionEducativaItemList').html()),
	events: {
		'click input[type=checkbox]': 'toggleActive',
		'click .delete': 'destroy'
	},
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	toggleActive: function () {
		this.model.save({ institucionActivo: (!this.model.get('institucionActivo'))*1 });
	},
	destroy: function () {
		this.model.destroy();
	}
});

var InstitucionEducativaFormView = Backbone.View.extend({
	initialize: function () {
		this.listenTo(this.model, 'change', this.render);
	},
	tagName: 'div',
	className: 'col-sm-12',
	template: _.template($('#institucionEducativaForm').html()),
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	}
});