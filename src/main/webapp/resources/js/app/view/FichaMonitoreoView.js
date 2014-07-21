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
	},
	template: _.template($('#fichaMonitoreoFormTemplate').html()),
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	}
});