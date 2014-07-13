/**
 * 
 */

var baseUrl = baseUrl || '';

var PeriodoAcademicoCollection = Backbone.Collection.extend({
	url: baseUrl+'/periodoacademico',
	model: PeriodoAcademicoModel
});