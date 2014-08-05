/**
 * 
 */


define(['backbone', 
        'model/NivelModel', 
        'AdminApplication'], function (Backbone, NivelModel, app) {
	app.meta.collections.NivelCollection = Backbone.Collection.extend({
		url: baseUrl+'/estructuraie/nivel',
		model: NivelModel
	});
	
	return app.meta.collections.NivelCollection;
});