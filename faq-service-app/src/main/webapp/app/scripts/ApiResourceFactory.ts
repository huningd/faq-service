/// <reference path="app.ts" />
/// <reference path="../../typings/angularjs/angular-resource.d.ts" />
/// <reference path="../../typings/angularjs/angular.d.ts" />
'use strict';

angular.module("faq.webapp").factory('faq.webapp.apiResource', ['$resource', '$http', 
        ($resource:ng.resource.IResourceService, $http:ng.IHttpService):
            ng.resource.IResourceClass<ng.resource.IResource<any>> => {
            $http.defaults.headers.common.Authorization = 'Basic ' + btoa("user" + ':' + "password");    
            var apiRoot:ng.resource.IResourceClass<ng.resource.IResource<any>> =
                $resource('http://localhost:8081/faq/:oid');

            return apiRoot;
        }]);