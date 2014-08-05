/**
 * 
 */

define (['backbone', 
         'model/CargoModel', 
         'AdminApplication'], function (Backbone, model, app) {
	app.meta.collections.CargoCollection = Backbone.Collection.extend({
		url: baseUrl+'/cargo',
		model: model
	});
});