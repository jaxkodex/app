/**
 * 
 */

var FichaMonitoreoCollection = Backbone.Collection.extend({
	url: baseUrl + '/fichamonitoreo',
	model: FichaMonitoreoModel
});