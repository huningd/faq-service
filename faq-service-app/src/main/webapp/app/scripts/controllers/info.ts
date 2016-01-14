/// <reference path="../app.ts" />

'use strict';

module yoAngularTestApp {
  export interface IInfoScope extends ng.IScope {
    awesomeThings: any[];
  }

  export class InfoCtrl {

    constructor (private $scope: IInfoScope) {
      $scope.awesomeThings = [
        'HTML5 Boilerplate',
        'AngularJS',
        'Karma'
      ];
    }
  }
}

angular.module('yoAngularTestApp')
  .controller('InfoCtrl', yoAngularTestApp.InfoCtrl);
