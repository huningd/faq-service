/// <reference path="../app.ts" />

'use strict';

module yoAngularTestApp {
  export interface IAboutScope extends ng.IScope {
    awesomeThings: any[];
  }

  export class AboutCtrl {

    constructor (private $scope: IAboutScope) {
      $scope.awesomeThings = [
        'HTML5 Boilerplate',
        'AngularJS',
        'Karma'
      ];
    }
  }
}

angular.module('yoAngularTestApp')
  .controller('AboutCtrl', yoAngularTestApp.AboutCtrl);
