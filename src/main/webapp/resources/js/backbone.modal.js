/**
 * 
 */

var Modal = Backbone.View.extend({
	initialize: function (options) {
		this.options = _.extend({
			width: 500,
			height: 300,
			title: '',
			view: new Backbone.View,
			modal: true,
			background: '#fff'
		}, options);
		
		this.modaltmpl = '<div class="modal-container"><div class="title clearfix">\
			<span class="pull-left"><%=title%></span>\
			<a class="btn btn-link btn-xs pull-right modal-close" href="javascript:void(0);">\
			<span class="glyphicon glyphicon-remove"></span></a></div>\
			<div class="body"></div><div class="footer"></div></div>';
		
		this.template = _.template(this.modaltmpl);
		
		this.listenTo(this, 'render', this.render);
	},
	tagName: 'div',
	className: 'modal-wrapper',
	events: {
		'click .modal-close': 'close'
	},
	render: function () {
		var top = 50,//($(window).height()-this.options.height)/2,
			left = ($(window).width()-this.options.width)/2;
		this.$el.empty();
		this.$el.html(this.template({
			title: this.options.title
		}));
		this.$('.modal-container').css({
			width: this.options.width,
			height: this.options.height,
			//top: (top < 0 ? 10 : top)+'px',
			left: (left < 0 ? 10 : left)+'px',
			background: this.options.background,
		});
		// Body
		this.$('.body').append(this.options.view.render().$el);
		this.$('.modal-container').draggable();
		return this;
	},
	show: function () {
		$('body').append(this.render().$el);
		return this;
	},
	close: function (evt) {
		evt.preventDefault();
		this.$el.remove();
		if (typeof this.options.callback != 'undefined') {
			this.options.callback();
		}
		return this;
	}
});