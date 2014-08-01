/**
 * 
 */

var app = app || {};

app.meta.collections.EvaluacionCollection = Backbone.Collection.extend({
	url: baseUrl+'/evaluacion',
	model: app.EvaluacionModel
});