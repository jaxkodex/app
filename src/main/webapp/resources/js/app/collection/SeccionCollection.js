/**
 * 
 */

define(['backbone', 
        'model/SeccionModel', 
        'AdminApplication'], function (Backbone, SeccionModel, app) {
	app.meta.collections.SeccionCollection = Backbone.Collection.extend({
		url: app.baseUrl+'/estructuraie/seccion',
		model: SeccionModel
	});
	
	return app.meta.collections.SeccionCollection;
});