/**
 * 
 */


define(['backbone', 
        'model/InstitucionEducativaModel', 
        'AdminApplication'], function (Backbone, InstitucionEducativaModel, app) {
	var InstitucionEducativaCollection;
	
	InstitucionEducativaCollection = Backbone.Collection.extend({
		url: app.baseUrl+'/institucion',
		model: InstitucionEducativaModel
	});
	
	app.meta.collections.InstitucionEducativaCollection = InstitucionEducativaCollection;
	
	return InstitucionEducativaCollection;
});