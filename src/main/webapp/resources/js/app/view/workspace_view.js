/**
 * 
 */

var app = app || {};

app.templates = app.templates || {};

app.templates.workspaceViewTemplate = '<nav class="navbar navbar-default navbar-fixed-top" role="navigation">\
	<div class="container">\
<div class="navbar-header">\
	<a class="navbar-brand" href="#">SME</a>\
</div>\
<div class="collapse navbar-collapse">\
	<ul class="nav navbar-nav">\
		<li><a href="#evaluaciones">Evaluaciones</a></li>\
		<li><a href="#config">Configuración</a></li>\
	</ul>\
</div>\
</div>\
</nav>\
<div id="workspace"><div class="container">Bienvenido!!</div></div>';

var WorkspaceView = Backbone.View.extend({
	tagName: 'div',
	events: {
		'click .navbar-nav li': 'onNavLinkClick'
	},
	template: _.template(app.templates.workspaceViewTemplate),
	render: function () {
		this.$el.empty().html(this.template());
		return this;
	},
	onNavLinkClick: function (evt) {
		this.$el.find('.navbar-nav li').removeClass('active');
		$(evt.currentTarget).addClass('active');
	}
});