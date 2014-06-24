/**
 * 
 */


var app = app || {};

app.templates = app.templates || {};

app.templates.configViewTemplate = '<div class="row">\
	<div class="col-sm-2">\
	<ul class="list-unstyled">\
		<li><a href="#config/persona">Personal</a></li>\
	</ul>\
	</div>\
	<div class="col-sm-10"></div>\
</div>';
	
var ConfigView = Backbone.View.extend({
	tagName: 'div',
	className: 'container',
	template: _.template(app.templates.configViewTemplate),
	render: function () {
		this.$el.html(this.template());
		return this;
	}
});