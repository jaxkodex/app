/**
 * 
 */
var app = app || {};

var FichaMonitoreoListView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;
		
		this.listenTo(this.collection, 'add remove reset', this.render);
	},
	template: _.template($('#fichaMonitoreoListTemplate').html()),
	render: function () {
		var container = document.createDocumentFragment();
		this.$el.html(this.template());
		
		this.collection.each(function (val) {
			var itemView = new FichaMonitoreoItemListView({
				model: val
			});
			container.append(itemView.render().el);
		});
		this.$('tbody').append(container);
		return this;
	}
});

var FichaMonitoreoItemListView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;
		this.listenTo(this.model, 'change', this.render);
	},
	template: _.template($('#fichaMonitoreoItemListTemplate').html()),
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	}
});

var FichaMonitoreoFormView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;
		this.seccionFichaMonitoreoCollection = new SeccionFichaMonitoreoCollection;

		this.listenTo(this.model, 'change', this.render);
		this.listenTo(this.seccionFichaMonitoreoCollection, 'add remove reset', this.renderSeccionMonitoreo);
	},
	template: _.template($('#fichaMonitoreoFormTemplate').html()),
	events: {
		'click .btn-add-seccion': 'addSeccion'
	},
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	renderSeccionMonitoreo: function () {
		var me = this;
		me.$('.secciones').empty();
		this.seccionFichaMonitoreoCollection.each(function (val) {
			var view = new FichaMonitoreoSeccionFormView({
				model: val
			});
			me.$('.secciones').append(view.render().$el);
		});
		return this;
	},
	addSeccion: function () {
		this.seccionFichaMonitoreoCollection.add({});
	}
});

var FichaMonitoreoSeccionFormView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;
		this.criterioFichaMonitoreoCollection = new CriterioFichaMonitoreoCollection;

		this.listenTo(this.model, 'change', this.render);
		this.listenTo(this.criterioFichaMonitoreoCollection, 'add remove reset', this.renderCriterioMonitoreo);
	},
	tagName: 'div',
	className: 'seccion',
	template: _.template($('#fichaMonitoreoSeccionFormTemplate').html()),
	events: {
		'click .btn-add-criterio': 'addCriterio'
	},
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	renderCriterioMonitoreo: function () {
		var me = this;
		me.$('.criterios').empty();
		this.criterioFichaMonitoreoCollection.each(function (val) {
			var view = new FichaMonitoreoCriterioFormView({
				model: val
			});
			me.$('.criterios').append(view.render().$el);
		});
		return this;
	},
	addCriterio: function () {
		this.criterioFichaMonitoreoCollection.add({});
	}
});

var FichaMonitoreoCriterioFormView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;
		this.opcionFichaMonitoreoCollection = new OpcionFichaMonitoreoCollection;

		this.listenTo(this.model, 'change', this.render);
		this.listenTo(this.opcionFichaMonitoreoCollection, 'add remove reset', this.renderOpcionMonitoreo);
	},
	tagName: 'div',
	className: 'row',
	template: _.template($('#fichaMonitoreoCriterioFormTemplate').html()),
	events: {
		'click .btn-add-opcion': 'addOpcion'
	},
	render: function () {
		this.$el.addClass('criterio');
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	renderOpcionMonitoreo: function () {
		var me = this;
		me.$('.opciones').empty();
		this.opcionFichaMonitoreoCollection.each(function (val) {
			var view = new FichaMonitoreoOpcionFormView({
				model: val
			});
			me.$('.opciones').append(view.render().$el);
		});
		return this;
	},
	addOpcion: function () {
		this.opcionFichaMonitoreoCollection.add({});
	}
});

var FichaMonitoreoOpcionFormView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;

		this.listenTo(this.model, 'change', this.render);
	},
	tagName: 'div',
	className: 'row',
	template: _.template($('#fichaMonitoreoOpcionFormTemplate').html()),
	render: function () {
		this.$el.addClass('opcion');
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	}
});