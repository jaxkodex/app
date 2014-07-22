/**
 * 
 */


var CriterioFichaMonitoreoCollection = Backbone.Collection.extend({
	url: baseUrl+'/fichamonitoreo/criterio',
	model: CriterioFichaMonitoreoModel
});