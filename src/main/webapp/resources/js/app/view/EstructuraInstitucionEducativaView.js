/**
 * 
 */

var EstructuraInstitucionEducativaView = Backbone.View.extend({
	initialize: function (options) {
		var options = options || {};
		if (typeof options.router != 'undefined') {
			this.router = options.router;
		}
		if (typeof options.institucionCollection != 'undefined') {
			this.institucionCollection = options.institucionCollection;
		}

		this.listenTo(this.collection, 'reset add remove', this.render);
		this.listenTo(this.institucionCollection, 'reset add remove', this.render);
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
				model: val,
				router: me.router
			});
			container.appendChild(view.render().el);
		});
		me.$el.find('ul').append(container);

		this.institucionCollection.each(function (val) {
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
		});
	}
});

var EstructuraInstitucionEducativaNivelView = Backbone.View.extend({
	initialize: function (options) {
		var options = options || {};
		if (typeof options.router != 'undefined') {
			this.router = options.router;
		}
		
		
		this.listenTo(this.model, 'change', this.render);
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
		this.$el.addClass('edit');
		this.$el.find('input').focus();
	},
	update: function (evt) {
		this.model.save({
			nivelNombre: this.$('input').val()
		});
		this.$el.removeClass('edit');
	},
	destroy: function (evt) {
		evt.preventDefault();
		//this.model.destroy();
		console.log('Delete nivel');
	},
	addGrado: function (evt) {
		evt.preventDefault();
	}
});