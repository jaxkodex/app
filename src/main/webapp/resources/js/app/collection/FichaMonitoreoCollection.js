/**
 * 
 */
var app = app || {};

var FichaMonitoreoCollection;
app.meta.collections.FichaMonitoreoCollection = FichaMonitoreoCollection = Backbone.Collection.extend({
	url: baseUrl + '/fichamonitoreo',
	model: FichaMonitoreoModel
});