/**
 * 
 */

var InstitucionEducativaListView = Backbone.View.extend({
	initialize: function (options) {
		var options = options || {};
		if (typeof options.router != 'undefined') {
			this.router = options.router;
		}

		this.listenTo(this.collection, 'reset add remove', this.render);
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
				model: val,
				router: me.router
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
	initialize: function (options) {
		var options = options || {};
		if (typeof options.router != 'undefined') {
			this.router = options.router;
		}
		
		this.listenTo(this.model, 'change', this.render);
	},
	tagName: 'tr',
	template: _.template($('#institucionEducativaItemList').html()),
	events: {
		'click input[type=checkbox]': 'toggleActive',
		'click .delete': 'destroy',
		'click .edit': 'edit'
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
	},
	edit: function () {
		this.router.navigate('institucioneducativa/edit/'+this.model.id, {trigger: true});
	}
});

var InstitucionEducativaFormView = Backbone.View.extend({
	initialize: function (options) {
		var options = options || {};
		if (typeof options.router != 'undefined') {
			this.router = options.router;
		}

		this.listenTo(this.model, 'change', this.render);
		this.listenTo(this.model, 'invalid', this.render);
	},
	events: {
		'click .cancel': 'cancelar',
		'submit form': 'guardarDatos'
	},
	tagName: 'div',
	className: 'col-sm-12',
	template: _.template($('#institucionEducativaForm').html()),
	render: function () {
		console.log(this.model.validationError);
		this.$el.html(this.template(this.model.toJSON()));
		
		for (key in this.model.validationError) {
			this.$('#'+key).parent().addClass('has-error').find('.help-block').removeClass('hidden');
		}
		return this;
	},
	cancelar: function (evt) {
		evt.preventDefault();
		console.log('Cancelando');
		this.router.navigate('institucioneducativa', {trigger: true});
	},
	guardarDatos: function (evt) {
		evt.preventDefault();
		var me = this;
		me.$('input[type=submit]').prop('disabled', 'disabled');
		me.model.save({
			institucionNombre: me.$('#institucionNombre').val(),
			institucionLema: me.$('#institucionLema').val(),
			institucionActivo: me.$('input[type=checkbox]').prop('checked')*1
		}, {
			success: function () {
				me.router.navigate('institucioneducativa', {trigger: true});
			},
			error: function () {
				alert('A ocurrido un error al realizar el registro');
				me.$('input[type=submit]').prop('disabled', '');
			}
		});
	}
});