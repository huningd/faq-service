/// <reference path="../../typings/angularjs/angular.d.ts" />
/// <reference path="../../typings/angularjs/angular-route.d.ts" />

'use strict';

module faq.webapp{

   export var app = angular.module('faq.webapp', [
        'ngResource',
        'ngRoute',
        'ngAlertify',
        'faq.webapp.controllers',
        'faq.webapp.factories',
        'faq.webapp.services'
    ]);
    
    app.config(($routeProvider:ng.route.IRouteProvider) => {
        $routeProvider
        .when('/', {
            templateUrl: 'views/main.html',
            controller: 'MainCtrl'
        })
        .when('/faq', {
            templateUrl: 'views/faq.html',
            controller: 'faq.webapp.faqCtrl'
        })
        .when('/faq/:faqId', {
            templateUrl: 'views/faqDetails.html',
            controller: 'faq.webapp.faqDetailCtrl'
        })
        .when('/info', {
            templateUrl: 'views/info.html',
            controller: 'InfoCtrl',
            controllerAs: 'info'
        })
        .otherwise({
            redirectTo: '/'
        });
    });
    
    export var controllers = angular.module('faq.webapp.controllers', []);
    export var factories = angular.module('faq.webapp.factories', ['ngResource']);
    export var services = angular.module('faq.webapp.services', ['faq.webapp.factories']);
  
}
