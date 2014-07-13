/**
 * 
 */

var NivelModel = Backbone.Model.extend({
	idAttribute: 'idNivel',
	defaults: {
		nivelNombre: '',
		grados: []
	}
});