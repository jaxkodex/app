/**
 * 
 */

var CargoCollection = Backbone.Collection.extend({
	url: baseUrl+'/cargo',
	model: CargoModel
});