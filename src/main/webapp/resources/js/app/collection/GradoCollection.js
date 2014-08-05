/**
 * 
 */

define(['backbone', 
        'model/GradoModel',
        'AdminApplication'], function (Backbone, GradoModel, app) {
	app.meta.collections.GradoCollection = Backbone.Collection.extend({
		url: app.baseUrl+'/estructuraie/grado',
		model: GradoModel
	});
	
	return app.meta.collections.GradoCollection;
});