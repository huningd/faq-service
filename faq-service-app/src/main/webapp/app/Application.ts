/// <reference path="../../../../typings/angularjs/angular.d.ts" />
modulefaq.app {
    exportvarapp = angular.module('app',
['ngAlertify ']);

export var controllers = angular.module('faq.app.controllers', []);

angular.element(document).ready(() => {
        angular.bootstrap(document, ["app"]);
    });
}
