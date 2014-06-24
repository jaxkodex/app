/**
 * 
 */

var EvaluacionRouter = Backbone.Router.extend({
	routes: {
		'evaluaciones': 'index'
	},
	index: function () {
		console.log('Go to Evaluaciones');
	}
});