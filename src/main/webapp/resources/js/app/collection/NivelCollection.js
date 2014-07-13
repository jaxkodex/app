/**
 * 
 */

var NivelCollection = Backbone.Collection.extend({
	url: baseUrl+'/estructuraie/nivel',
	model: NivelModel
});