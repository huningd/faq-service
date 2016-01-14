/// <reference path="../app.ts" />
/// <reference path="../../../typings/angularjs/angular-resource.d.ts" />
/// <reference path="../../../typings/angularjs/angular.d.ts" />
'use strict';

module yoAngularTestApp {
  export interface IFaqScope extends ng.IScope {
    awesomeThings: any[];
  }

  export class FaqCtrl {

    constructor (private $scope: IFaqScope, private $resource: ng.resource.IResourceService, private $http: ng.IHttpService) {
      $http.defaults.headers.common['Authorization'] = 'Basic dXNlcjpwYXNzd29yZA==';
      // btoa("user" + ':' + "password");
      
      var faq:ng.resource.IResourceClass<ng.resource.IResource<any>> = $resource('http://localhost:8081/faq', {}, 
      {
        get: { method : 'GET' },
        options: { method : 'OPTIONS' },
        headers: {
          'Authorization': 'Basic dXNlcjpwYXNzd29yZA=='
        }
        
      }
      );
      faq.get((data:any) => {
        var questions = data;
        console.log(questions); 
      })
    }
  }
}

angular.module('yoAngularTestApp')
  .controller('FaqCtrl', yoAngularTestApp.FaqCtrl);
