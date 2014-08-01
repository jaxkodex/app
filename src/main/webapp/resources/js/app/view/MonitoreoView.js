/**
 * 
 */

var app = app || {};

app.meta.views.MonitoreoFormView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;
		this.listenTo(this.model, 'change', this.render);
	},
	tagName: 'div',
	className: 'col-sm-12',
	template: _.template($('#fichaMonitoreoFormTemplate').html()),
	render: function () {
		this.$el.html(this.template(_.extend(this.model.toJSON(), {
			seccions: this.options.formatoEvaluacion.get('seccionEvaluacions')
		})));
		return this;
	}
});