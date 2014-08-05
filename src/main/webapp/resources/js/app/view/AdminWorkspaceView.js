/**
 * 
 */

define(['backbone'], function (Backbone) {
	var AdminWorkspaceView;
	
	AdminWorkspaceView = Backbone.View.extend({
		el: '#workspace',
		template: _.template($('#workspaceTemplate').html()),
		events: {
			'click .menu > li a': 'onMenuClick'
		},
		render: function () {
			this.$el.html(this.template());
			return this;
		},
		getDisplayArea: function () {
			return this.$('.displayArea');
		},
		onMenuClick: function (evt) {
			var target;
			target = $(evt.target);
			$('li > ul.list-unstyled > li').removeClass('active');
			target.parent().addClass('active');
		}
	});
	
	return AdminWorkspaceView;
});