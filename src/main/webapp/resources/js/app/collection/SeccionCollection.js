/**
 * 
 */

var SeccionCollection = Backbone.Collection.extend({
	url: baseUrl+'/estructuraie/seccion',
	model: SeccionModel
});