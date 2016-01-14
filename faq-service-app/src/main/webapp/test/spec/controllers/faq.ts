/// <reference path="../../../typings/angularjs/angular-mocks.d.ts" />
/// <reference path="../../../typings/jasmine/jasmine.d.ts" />
/// <reference path="../../../app/scripts/controllers/faq.ts" />

'use strict';

describe('Controller: FaqCtrl', () => {

  // load the controller's module
  beforeEach(module('yoAngularTestApp'));

  var FaqCtrl: yoAngularTestApp.FaqCtrl,
    scope: yoAngularTestApp.IFaqScope;

  // Initialize the controller and a mock scope
  beforeEach(inject(($controller: ng.IControllerService, $rootScope: ng.IRootScopeService) => {
    scope = <any>$rootScope.$new();
    FaqCtrl = $controller('FaqCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', () => {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
