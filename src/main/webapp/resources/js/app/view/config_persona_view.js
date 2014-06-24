/**
 * 
 */

var app = app || {};

app.templates = app.templates || {};

//<form class="form-horizontal" role="form"></form>
app.templates.configPersonaViewTemplate = '\
	<div class="form-group">\
		<label for="dni" class="col-sm-2 control-label">DNI</label>\
		<div class="col-sm-2">\
			<input type="text" class="form-control input-sm" id="dni" placeholder="" value="<%=personaDni%>" maxlength="8" />\
		</div>\
	</div>\
	<div class="form-group">\
		<label for="primer_nombre" class="col-sm-2 control-label">Primer Nombre</label>\
		<div class="col-sm-10">\
			<input type="text" class="form-control input-sm" id="primer_nombre" placeholder="" value="<%=personaPnombre%>" maxlength="245" />\
		</div>\
	</div>\
	<div class="form-group">\
		<label for="segundo_nombre" class="col-sm-2 control-label">Segundo Nombre</label>\
		<div class="col-sm-10">\
			<input type="text" class="form-control input-sm" id="segundo_nombre" placeholder="" value="<%=personaSnombre%>" maxlength="245" >\
		</div>\
	</div>\
	<div class="form-group">\
		<label for="apellido_paterno" class="col-sm-2 control-label">Apellido Paterno</label>\
		<div class="col-sm-10">\
			<input type="text" class="form-control input-sm" id="apellido_paterno" placeholder="" value="<%=personaApaterno%>" maxlength="245" >\
		</div>\
	</div>\
	<div class="form-group">\
		<label for="apellido_materno" class="col-sm-2 control-label">Apellido Materno</label>\
		<div class="col-sm-10">\
			<input type="text" class="form-control input-sm" id="apellido_materno" placeholder="" value="<%=personaAmaterno%>" maxlength="245" >\
		</div>\
	</div>\
	<div class="form-group">\
		<div class="col-sm-offset-2 col-sm-10">\
			<button type="submit" class="btn btn-default sendData">Guardar</button>\
		</div>\
	</div>';

var PersonaFormView = Backbone.View.extend({
	tagName: 'form',
	className: 'form-horizontal',
	events: {
		'submit': 'guardaPersona'
	},
	template: _.template(app.templates.configPersonaViewTemplate),
	render: function () {
		this.$el.html(this.template(this.model.toJSON() || {}));
		this.delegateEvents();
		return this;
	},
	guardaPersona: function (evt) {
		evt.preventDefault();
		var me = this;
		this.$('button').prop('disabled', 'disabled');
		this.model.set({
			'personaDni': this.$('#dni').val(),
			'personaAmaterno': this.$('#apellido_materno').val(),
			'personaApaterno': this.$('#apellido_paterno').val(),
			'personaPnombre': this.$('#primer_nombre').val(),
			'personaSnombre': this.$('#segundo_nombre').val()
		});
		this.collection.create(this.model.toJSON(), {
			success: function () {
				me.$('button').removeProp('disabled', 'disabled');
			}
		});
	}
});

app.templates.configPersonaListViewTemplate = '<a href="#config/persona/edit" class="btn btn-default btn-sm">Nueva</a>\
	<table class="table">\
	<thead><tr><th>DNI</th><th>Apellido Paterno</th><th>Apellido Materno</th><th>Primer Nombre</th><th>Segundo Nombre</th><th></th></tr>\
	</thead>\
	<tbody>\
	</tbody>\
</table>';

var PersonaListView = Backbone.View.extend({
	tagName: 'div',
	template: _.template(app.templates.configPersonaListViewTemplate),
	render: function () {
		var me = this;
		this.$el.html(this.template({}));
		this.collection.fetch({
			success: function () {
				me.collection.each(function (val, index) {
					var tmp = new PersonaItemListView({
						model: val
					});
					me.$('tbody').append(tmp.render().$el);
				});
			}
		});
		return this;
	}
});

app.templates.configPersonaItemListViewTemplate = '<td><%=personaDni%></td><td><%=personaAmaterno%></td><td><%=personaApaterno%></td><td><%=personaPnombre%></td><td><%=personaSnombre%><td><a href="#config/persona/edit/<%=personaDni%>"><span class="glyphicon glyphicon-pencil"></span></a></td>';

var PersonaItemListView = Backbone.View.extend({
	tagName: 'tr',
	template: _.template(app.templates.configPersonaItemListViewTemplate),
	render: function () {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	}
});