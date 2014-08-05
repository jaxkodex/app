/**
 * 
 */


define(['backbone',
        'AdminApplication'], function (Backbone, app) {
	app.meta.views.PlanadocenteView = Backbone.View.extend({
		initialize: function (options) {
			this.options = options;
		},
		template: _.template($('#planadocenteTemplate').html()),
		render: function () {
			this.$el.empty().html(this.template());
			return this;
		}
	});
	
	return app.meta.views.PlanadocenteView;
});