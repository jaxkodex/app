/**
 * 
 */

var WorkspaceView = Backbone.View.extend({
	el: '#workspace',
	template: _.template($('#workspaceTemplate').html()),
	render: function () {
		this.$el.html(this.template());
	},
	getWorkspaceArea: function () {
		return this.$el.find('.col-sm-10');
	}
});