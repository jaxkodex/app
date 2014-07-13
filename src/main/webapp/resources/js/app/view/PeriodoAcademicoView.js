/**
 * 
 */

var PeriodoAcademicoListView = Backbone.View.extend({
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
	template: _.template($('#periodoAcademicoList').html()),
	render: function () {
		var me = this, container = document.createDocumentFragment();
		this.$el.html(this.template());
		this.collection.each(function (val) {
			var view = new PeriodoAcademicoItemListView({
				model: val,
				router: me.router
			});
			container.appendChild(view.render().el);
		});
		me.$el.find('tbody').append(container);
		return this;
	},
	addNew: function () {
		this.router.navigate('periodoacademico/edit', {trigger: true});
	}
});

var PeriodoAcademicoItemListView = Backbone.View.extend({
	initialize: function (options) {
		var options = options || {};
		if (typeof options.router != 'undefined') {
			this.router = options.router;
		}
		
		this.listenTo(this.model, 'change', this.render);
	},
	tagName: 'tr',
	template: _.template($('#periodoAcademicoItemList').html()),
	events: {
		'click input[type=checkbox]': 'toggleActive',
		'click .delete': 'destroy',
		'click .edit': 'edit'
	},
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	toggleActive: function (evt) {
		evt.preventDefault();
		//this.model.save({ institucionActivo: (!this.model.get('institucionActivo'))*1 });
	},
	destroy: function (evt) {
		evt.preventDefault();
		this.model.destroy();
	},
	edit: function (evt) {
		evt.preventDefault();
		this.router.navigate('periodoacademico/edit/'+this.model.id, {trigger: true});
	}
});

var PeriodoAcademicoFormView = Backbone.View.extend({
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
	template: _.template($('#periodoAcademicoForm').html()),
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		
		for (key in this.model.validationError) {
			this.$('#'+key).parent().addClass('has-error').find('.help-block').removeClass('hidden');
		}
		return this;
	},
	cancelar: function (evt) {
		evt.preventDefault();
		this.router.navigate('periodoacademico', {trigger: true});
	},
	guardarDatos: function (evt) {
		evt.preventDefault();
		var me = this;
		me.$('input[type=submit]').prop('disabled', 'disabled');
		me.model.set({
			periodoActivo: me.$('input[type=checkbox]').prop('checked')*1,
			periodoFfin: Date.parseExact(me.$('#periodoFfin').val(), "dd/MM/yyyy").getTime(),
			periodoFinicio: Date.parseExact(me.$('#periodoFinicio').val(), "dd/MM/yyyy").getTime(),
			periodoNombre: me.$('#periodoNombre').val()
		});
		me.collection.create(me.model.toJSON(), {
			success: function () {
				me.router.navigate('periodoacademico', {trigger: true});
			},
			error: function () {
				alert('A ocurrido un error al realizar el registro');
				me.$('input[type=submit]').prop('disabled', '');
			}
		});
	}
});