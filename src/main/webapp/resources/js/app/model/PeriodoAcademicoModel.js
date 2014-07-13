/**
 * 
 */


var PeriodoAcademicoModel = Backbone.Model.extend({
	idAttribute: 'idPeriodo',
	defaults: {
		periodoActivo: true,
		/*periodoFfin: new Date(),
		periodoFinicio: new Date(),*/
		periodoFfin: Date.today().getTime(),
		periodoFinicio: Date.today().getTime(),
		periodoNombre: ''
	}
});