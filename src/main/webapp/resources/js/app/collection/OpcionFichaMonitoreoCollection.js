/**
 * 
 */

var OpcionFichaMonitoreoCollection = Backbone.Collection.extend({
	url: baseUrl+'/fichamonitoreo/opcion',
	model: OpcionFichaMonitoreoModel
});