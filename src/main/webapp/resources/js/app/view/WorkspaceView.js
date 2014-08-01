/**
 * 
 */
var app = app || {};

var WorkspaceView;
app.meta.views.WorkspaceView = WorkspaceView = Backbone.View.extend({
	el: '#workspace',
	template: _.template($('#workspaceTemplate').html()),
	render: function () {
		this.$el.html(this.template());
		return this;
	},
	getWorkspaceArea: function () {
		return this.$el.find('.col-sm-10');
	},
	setMainView: function (view) {
		this.$('.main').empty().append(view.render().$el);
		return this;
	}
});