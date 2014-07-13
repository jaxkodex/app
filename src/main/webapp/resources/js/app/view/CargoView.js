/**
 * 
 */

var CargoListView = Backbone.View.extend({
	initialize: function (options) {
		var options = options || {};
		if (typeof options.router != 'undefined') {
			this.router = options.router;
		}

		this.listenTo(this.collection, 'reset add remove', this.render);
	},
	tagName: 'div',
	className: 'col-sm-12',
	template: _.template($('#cargoList').html()),
	render: function () {
		var me = this, container = document.createDocumentFragment();
		this.$el.html(this.template());
		this.collection.each(function (val) {
			var view = new CargoListItemView({
				model: val,
				router: me.router
			});
			container.appendChild(view.render().el);
		});
		me.$el.find('tbody').append(container);
		return this;
	}
});

var CargoListItemView = Backbone.View.extend({
	initialize: function (options) {
		var options = options || {};
		if (typeof options.router != 'undefined') {
			this.router = options.router;
		}
		
		this.listenTo(this.model, 'change', this.render);
	},
	tagName: 'tr',
	template: _.template($('#cargoItemList').html()),
	events: {
		//'click input[type=checkbox]': 'toggleActive',
		'click .delete': 'destroy',
		'click .edit': 'edit'
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


var CargoFormView = Backbone.View.extend({
	initialize: function (options) {
		var options = options || {};
		if (typeof options.router != 'undefined') {
			this.router = options.router;
		}
		
		this.listenTo(this.model, 'change', this.render);
	},
	tagName: 'div',
	className: 'col-sm-12',
	template: _.template($('#cargoForm').html()),
	events: {
		'click .cancel': 'cancelar',
		'submit form': 'guardarDatos'
	},
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	cancelar: function (evt) {
		evt.preventDefault();
		this.router.navigate('cargo', {trigger: true});
	},
	guardarDatos: function (evt) {
		evt.preventDefault();
		var me = this;
		console.log(this.collection.toJSON());
		this.model.set({
			cargoCodigo: me.$('#cargoCodigo').val(),
			cargoDescripcion: me.$('#cargoDescripcion').val(),
			activo: me.$('#cargoActivo').prop('checked')*1
		});
		this.collection.create(this.model.toJSON(), {
			wait: true,
			success: function () {
				me.router.navigate('cargo', {trigger: true});
			}
		});
	}
});