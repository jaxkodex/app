/**
 * Monitoreo Web v1.0
 */
'use strict';

/*
var app = {
		meta: {
			models: {},
			collections: {},
			routers: {},
			views: {}
		},
		instance: {
			collections: {}
		},
		controller: {}
};
$(function () {
	app.collections = app.collections || {};
	app.workspace = new WorkspaceView ();
	app.workspace.render();
	new WorkspaceRouter;
	new AdminRouter;
	new ConfigRouter;
	Backbone.history.start();
});
*/

require.config({
	shim: {
		underscore: {
			exports: '_'
		},
		backbone: {
			deps: ['underscore', 'jquery'],
			exports: 'Backbone'
		},
		bootstrap: {
			deps: ['jquery'],
			exports: '$.fn.popover'
		}
	},
	paths: {
		jquery: '../jquery-1.11.1',
		underscore: '../underscore',
		backbone: '../backbone',
		bootstrap: '../bootstrap.min'
	}
});


require(['AdminApplication', 'CommonAdmin', 'jquery'], function (app, common, $) {
	$(document).ajaxStart(function () {
		if ($("#loadingbar").length < 1) {
			var div = $('<div>');
			div.prop('id', 'loadingbar')
				.appendTo('body')
				.addClass('waiting')
				.append($("<dt/><dd/>"))
				.css({width: (50 + Math.random() * 30) + '%'});
		}
	}).ajaxStop(function () {
        $("#loadingbar").width("101%").delay(200).fadeOut(400, function() {
            $(this).remove();
        });
	});
	app.initialize();
});