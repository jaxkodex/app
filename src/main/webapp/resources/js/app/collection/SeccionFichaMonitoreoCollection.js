/**
 * 
 */

var SeccionFichaMonitoreoCollection = Backbone.Collection.extend({
	url: baseUrl+'/fichamonitoreo/seccion',
	model: SeccionFichaMonitoreoModel
});