/**
 * 
 */

var EstructuraInstitucionEducativaView = Backbone.View.extend({
	initialize: function (options) {
		this.options = options || {};

		this.listenTo(this.collection, 'reset add remove', this.render);
		this.listenTo(this.options.institucionCollection, 'reset add remove', this.render);
		this.InstitucionEducativaSelectOptionView = Backbone.View.extend({
			tagName: 'option',
			template: _.template('<%=institucionNombre%>'),
			render: function () {
				this.$el.html(this.template(this.model.toJSON())).val(this.model.get('idInstitucion'));
				return this;
			}
		});
	},
	tagName: 'div',
	className: 'col-sm-12',
	template: _.template($('#estructuraInstitucionEducativa').html()),
	events: {
		'click .addnivel': 'addNivel'
	},
	render: function () {
		var me = this, container = document.createDocumentFragment(), 
		selectContainer = document.createDocumentFragment();
		this.$el.html(this.template());
		this.collection.each(function (val) {
			var view = new EstructuraInstitucionEducativaNivelView({
				gradoCollection: me.options.gradoCollection,
				model: val,
				router: me.options.router
			});
			container.appendChild(view.render().el);
		});
		me.$el.find('ul').append(container);

		this.options.institucionCollection.each(function (val) {
			var view = new me.InstitucionEducativaSelectOptionView({
				model: val
			});
			selectContainer.appendChild(view.render().el);
		});
		me.$el.find('select').append(selectContainer);
		return this;
	},
	addNivel: function (evt) {
		evt.preventDefault();
		this.collection.create({
			institucionEducativa: { idInstitucion: this.$el.find('select').val() },
			nivelNombre: 'Nuevo nivel'
		}, { wait: true });
	}
});

var EstructuraInstitucionEducativaNivelView = Backbone.View.extend({
	initialize: function (options) {
		var me = this;
		this.options = options || {};
		this.gradoCollection = new GradoCollection;
		
		this.gradoCollection.fetch({
			data: {
				idNivel: this.model.get('idNivel')
			},
			reset: true,
			silent: true,
			success: function () { me.gradoCollection.trigger('add'); }
		});

		this.listenTo(this.model, 'change', this.render);
		this.listenTo(this.gradoCollection, 'add reset remove', this.renderGradoList);
	},
	tagName: 'li',
	className: 'estructuraie-nivel',
	template: _.template($('#estructuraInstitucionEducativaNivel').html()),
	events: {
		'click .editbtn': 'edit',
		'blur input': 'update',
		'click .addgradobtn': 'addGrado',
		'click .removenivelbtn': 'destroy',
	},
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	edit: function (evt) {
		evt.preventDefault();
		this.$el.find('*').removeClass('editing');
		this.$el.addClass('editing');
		this.$el.find('input').focus();
	},
	update: function (evt) {
		this.model.save({
			nivelNombre: this.$('input').val()
		});
		this.$el.removeClass('editing');
	},
	destroy: function (evt) {
		evt.preventDefault();
		this.model.destroy();
	},
	addGrado: function (evt) {
		evt.preventDefault();
		this.options.gradoCollection.create({
			nivel: { idNivel: this.model.get('idNivel'), }
		}, { wait: true });
	},
	renderGradoList: function () {
		var container = document.createDocumentFragment();
		this.gradoCollection.each(function (val) {
			var gradoView = new EstructuraInstitucionEducativaGradoView ({
				model: val
			});
			container.appendChild(gradoView.render().el);
		});
		this.$('ul').empty().append(container);
	}
});

var EstructuraInstitucionEducativaGradoView = Backbone.View.extend({
	initialize: function (options) {
		var me = this;
		this.options = options;
		this.seccionCollection = new SeccionCollection;
		
		this.seccionCollection.fetch({
			data: {
				idGrado: this.model.get('idGrado')
			},
			reset: true,
			silent: true,
			success: function () { me.seccionCollection.trigger('add'); }
		});
		
		this.listenTo(this.model, 'change', this.render);
		this.listenTo(this.seccionCollection, 'add reset remove', this.renderSeccionList);
	},
	tagName: 'li',
	className: 'estructuraie-grado',
	template: _.template($('#estructuraInstitucionEducativaGrado').html()),
	events: {
		'click .editbtn': 'edit',
		'blur input': 'update',
		'click .removebtn': 'remove',
		'click .addbtn': 'addSeccion'
	},
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	edit: function (evt) {
		evt.preventDefault();
		evt.stopPropagation();
		this.$el.addClass('editing');
		this.$('input').focus();
	},
	update: function (evt) {
		evt.preventDefault();
		evt.stopPropagation();
		this.model.save({
			gradoNombre: this.$('input').val()
		});
		this.$el.removeClass('editing');
	},
	remove: function (evt) {
		evt.preventDefault();
		evt.stopPropagation();
		this.model.destroy();
	},
	addSeccion: function (evt) {
		evt.preventDefault();
		evt.stopPropagation();
		this.seccionCollection.create({
			grado: { idGrado: this.model.get('idGrado'), }
		}, { wait: true });
	},
	renderSeccionList: function () {
		this.render();
		var container = document.createDocumentFragment();
		this.seccionCollection.each(function (val) {
			var seccionView = new EstructuraInstitucionEducativaSeccionView ({
				model: val
			});
			container.appendChild(seccionView.render().el);
		});
		this.$('ul').empty().append(container);
	}
});

var EstructuraInstitucionEducativaSeccionView = Backbone.View.extend({
	initialize: function (options) {
		this.listenTo(this.model, 'change', this.render);
	},
	tagName: 'li',
	className: 'estructuraie-seccion',
	template: _.template($('#estructuraInstitucionEducativaSeccion').html()),
	events: {
		'click .editbtn': 'edit',
		'blur input': 'update',
		'click .removebtn': 'remove'
	},
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	},
	edit: function (evt) {
		evt.preventDefault();
		evt.stopPropagation();
		this.$el.addClass('editing');
		this.$('input').focus();
	},
	update: function (evt) {
		evt.preventDefault();
		evt.stopPropagation();
		this.model.save({
			seccionNombre: this.$('input').val()
		});
		this.$el.removeClass('editing');
	},
	remove: function (evt) {
		evt.preventDefault();
		evt.stopPropagation();
		this.model.destroy();
	}
});




/****/