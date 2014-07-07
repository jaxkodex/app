/**
 * 
 */

var InstitucionEducativaCollection = Backbone.Collection.extend({
	url: baseUrl+'/institucion',
	model: InstitucionEducativaModel
});