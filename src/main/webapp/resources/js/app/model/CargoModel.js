/**
 * 
 */


var CargoModel = Backbone.Model.extend({
	idAttribute: 'idCargo',
	defaults: {
		activo: true,
		cargoCodigo: '',
		cargoDescripcion: ''
	}
});
