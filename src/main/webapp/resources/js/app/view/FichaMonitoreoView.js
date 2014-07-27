/**
 * 
 */
var app = app || {};

var FichaMonitoreoListView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;
		
		this.listenTo(this.collection, 'add remove reset', this.render);
	},
	template: _.template($('#fichaMonitoreoListTemplate').html()),
	render: function () {
		var container = document.createDocumentFragment();
		this.$el.html(this.template());
		
		this.collection.each(function (val) {
			var itemView = new FichaMonitoreoItemListView({
				model: val
			});
			container.append(itemView.render().el);
		});
		this.$('tbody').append(container);
		return this;
	}
});

var FichaMonitoreoItemListView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;
		this.listenTo(this.model, 'change', this.render);
	},
	template: _.template($('#fichaMonitoreoItemListTemplate').html()),
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	}
});

app.FichaMonitoreoFormView = Backbone.View.extend({
	initialize: function () {
		this.listenTo(this.model, 'change', this.render);
		this.listenTo(this, 'render', this.render);
	},
	template: _.template($('#fichaMonitoreoFormTemplate').html()),
	events: {
		'click .btn-add-seccion': 'addSeccion',
		'click .btn-add-criterio': 'addCriterio',
		'click .btn-add-opcion': 'addOpcion',
		'click .btn-remove-seccion': 'removeSeccion',
		'click .btn-remove-criterio': 'removeCriterio',
		'click .btn-remove-opcion': 'removeOpcion',
		'click .btn-edit-seccion': 'edit',
		'click .btn-save-seccion': 'updateObject',
		'submit form': 'guardar'
	},
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	addSeccion: function (evt) {
		evt.preventDefault();
		this.model.addSeccion();
	},
	addCriterio: function (evt) {
		evt.preventDefault();
		var target, seccionIndex;
		target = $(evt.target).hasClass('btn-add-criterio') ? $(evt.target) : $(evt.target).parent();
		seccionIndex = target.data('seccion');
		this.model.addCriterio(seccionIndex);
	},
	addOpcion: function (evt) {
		evt.preventDefault();
		var target, seccionIndex, opcionIndex;
		target = $(evt.target).hasClass('btn-add-opcion') ? $(evt.target) : $(evt.target).parent();
		seccionIndex = target.data('seccion');
		criterioIndex = target.data('criterio');
		this.model.addOpcion(seccionIndex, criterioIndex);
	},
	guardar: function (evt) {
		evt.preventDefault();
		this.updateObject(evt);
		this.model.save();
	},
	edit: function (evt) {
		evt.preventDefault();
		console.log('edit');
		var target;
		target = $(evt.target).hasClass('btn-edit-seccion') ? $(evt.target) : $(evt.target).parent();
		$('#seccion-wrapper-'+target.data('seccion')).addClass('editing');
		$('#criterios-wrapper-'+target.data('seccion')).addClass('editing');
	},
	updateObject: function (evt) {
		evt.preventDefault();
		var me, inputs, seccions, obj;
		inputs = $('input');
		me = this;
		obj = this.model.toJSON();
		seccions = obj.seccionEvaluacions;//_.extend([], this.model.get('seccionEvaluacions'));
		_.each(inputs, function (val) {
			var seccion, criterio, opcion, seccionIndex, criterioIndex, opcionIndex, input;
			input = $(val);
			seccionIndex = input.data('seccion');
			criterioIndex = input.data('criterio');
			opcionIndex = input.data('opcion');
			if (typeof seccionIndex == 'undefined') {
				obj[input.data('field')] = input.val();
				return;
			}
			seccion = seccions[seccionIndex];
			if (typeof opcionIndex == 'undefined' && typeof criterioIndex == 'undefined') {
				seccion[input.data('field')] = input.val();
				return;
			}
			criterio = seccion.criterios[criterioIndex];
			if (typeof opcionIndex == 'undefined') {
				criterio[input.data('field')] = input.val();
				return;
			}
			opcion = criterio.opcions[opcionIndex];
			opcion[input.data('field')] = input.val();
		});
		this.model.set(obj);
		this.trigger('render');
	},
	removeOpcion: function (evt) {
		evt.preventDefault();
		var target;
		target = $(evt.target).hasClass('btn-remove-opcion') ? $(evt.target) : $(evt.target).parent();
		this.model.removeOpcion(target.data('seccion'), target.data('criterio'), target.data('opcion'));
	},
	removeCriterio: function (evt) {
		evt.preventDefault();
		var target;
		target = $(evt.target).hasClass('btn-remove-criterio') ? $(evt.target) : $(evt.target).parent();
		this.model.removeCriterio(target.data('seccion'), target.data('criterio'));
	},
	removeSeccion: function (evt) {
		evt.preventDefault();
		var target;
		target = $(evt.target).hasClass('btn-remove-seccion') ? $(evt.target) : $(evt.target).parent();
		this.model.removeSeccion(target.data('seccion'));
	}
}); 

/*

var FichaMonitoreoFormView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;
		this.seccionFichaMonitoreoCollection = new SeccionFichaMonitoreoCollection(this.model.get('seccionEvaluacions'));

		this.listenTo(this.model, 'change', this.render);
		this.listenTo(this.seccionFichaMonitoreoCollection, 'add remove reset', this.renderSeccionMonitoreo);
	},
	template: _.template($('#fichaMonitoreoFormTemplate').html()),
	events: {
		'click .btn-add-seccion': 'addSeccion',
		'submit form': 'guardarData'
	},
	render: function () {
		var me = this;
		this.$el.html(this.template(this.model.toJSON()));
		this.$('.secciones').empty();
		this.seccionFichaMonitoreoCollection.each(function (val) {
			var view = new FichaMonitoreoSeccionFormView({
				model: val,
				parent: me
			});
			me.$('.secciones').append(view.render().$el);
		});
		return this;
	},
	renderSeccionMonitoreo: function () {
		this.model.set('seccionEvaluacions', this.seccionFichaMonitoreoCollection.toJSON());
		return this;
	},
	addSeccion: function () {
		console.log(this.model.toJSON());
		console.log(this.seccionFichaMonitoreoCollection.toJSON());
		this.seccionFichaMonitoreoCollection.add({});
	},
	removeSeccion: function (model) {
		this.seccionFichaMonitoreoCollection.remove(model);
	},
	guardarData: function (evt) {
		evt.preventDefault();
		console.log('Guardar');
		console.log(this.model.toJSON());
	}
});

var FichaMonitoreoSeccionFormView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;
		this.criterioFichaMonitoreoCollection = new CriterioFichaMonitoreoCollection(this.model.get('criterios'));

		this.listenTo(this.model, 'change', this.render);
		this.listenTo(this.criterioFichaMonitoreoCollection, 'add remove reset', this.updateCriterioMonitoreo);
	},
	tagName: 'div',
	className: 'seccion',
	template: _.template($('#fichaMonitoreoSeccionFormTemplate').html()),
	events: {
		'click .btn-add-criterio': 'addCriterio',
		'click .btn-remove-seccion': 'removeSeccion'	
	},
	render: function () {
		var me = this;
		this.$el.html(this.template(this.model.toJSON()));
		this.$('.criterios').empty();
		this.criterioFichaMonitoreoCollection.each(function (val) {
			var view = new FichaMonitoreoCriterioFormView({
				model: val,
				parent: me
			});
			me.$('.criterios').append(view.render().$el);
		});
		return this;
	},
	updateCriterioMonitoreo: function () {
		this.model.set('criterios', this.criterioFichaMonitoreoCollection.toJSON());
		return this;
	},
	addCriterio: function () {
		this.criterioFichaMonitoreoCollection.add({});
	},
	removeCriterio: function (model) {
		this.criterioFichaMonitoreoCollection.remove(model);
	},
	removeSeccion: function () {
		this.options.parent.removeSeccion(this.model);
	}
});

var FichaMonitoreoCriterioFormView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;
		this.opcionFichaMonitoreoCollection = new OpcionFichaMonitoreoCollection(this.model.get('opcions'));

		this.listenTo(this.model, 'change', this.render);
		this.listenTo(this.opcionFichaMonitoreoCollection, 'add remove reset', this.updateOpcionMonitoreo);
	},
	tagName: 'div',
	className: 'row',
	template: _.template($('#fichaMonitoreoCriterioFormTemplate').html()),
	events: {
		'click .btn-add-opcion': 'addOpcion',
		'click .btn-remove-criterio': 'removeCriterio'
	},
	render: function () {
		var me = this;
		this.$el.addClass('criterio');
		this.$el.html(this.template(this.model.toJSON()));
		this.$('.opciones').empty();
		this.opcionFichaMonitoreoCollection.each(function (val) {
			var view = new FichaMonitoreoOpcionFormView({
				model: val,
				parent: me
			});
			me.$('.opciones').append(view.render().$el);
		});
		return this;
	},
	updateOpcionMonitoreo: function () {
		this.model.set('opcions', this.opcionFichaMonitoreoCollection.toJSON());
		return this;
	},
	addOpcion: function () {
		this.opcionFichaMonitoreoCollection.add({});
	},
	removeOpcion: function (model) {
		this.opcionFichaMonitoreoCollection.remove(model);
	},
	removeCriterio: function () {
		this.options.parent.removeCriterio(this.model);
	}
});

var FichaMonitoreoOpcionFormView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options;

		this.listenTo(this.model, 'change', this.render);
	},
	tagName: 'div',
	className: 'row',
	template: _.template($('#fichaMonitoreoOpcionFormTemplate').html()),
	events: {
		'click .btn-edit-opcion': 'edit',
		'click .btn-remove-opcion': 'remove',
		'blur input': 'update'
	},
	render: function () {
		this.$el.addClass('opcion');
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	edit: function (evt) {
		evt.preventDefault();
		this.$el.addClass('editing');
		this.$('input[type=text]').focus();
	},
	remove: function (evt) {
		evt.preventDefault();
		//this.options.parent.removeOpcion(this.model);
		this.trigger('remove');
	},
	update: function (evt) {
		evt.stopPropagation();
		this.model.set('opcionDescripcion', this.$('input[type=text]').val());
		this.$el.removeClass('editing');
	}
});

*/