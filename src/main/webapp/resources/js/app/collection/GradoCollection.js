/**
 * 
 */

var GradoCollection = Backbone.Collection.extend({
	url: baseUrl+'/estructuraie/grado',
	model: GradoModel
});