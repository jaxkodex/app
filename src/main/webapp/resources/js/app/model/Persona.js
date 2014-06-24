/**
 * 
 */

var Persona = Backbone.Model.extend({
	//idAttribute: 'personaDni',
	urlRoot: 'config/persona',
	defaults: {
		'personaDni': '',
		'personaAmaterno': '',
		'personaApaterno': '',
		'personaPnombre': '',
		'personaSnombre': ''
		}
});