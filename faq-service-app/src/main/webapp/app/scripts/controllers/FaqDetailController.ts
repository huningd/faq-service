/// <reference path="../app.ts" />
/// <reference path="../../../typings/angularjs/angular-resource.d.ts" />
/// <reference path="../../../typings/angularjs/angular.d.ts" />
/// <reference path="../model/Faq.ts" />
/// <reference path="../services/FaqService.ts" />
'use strict';

module faq.webapp {
  
  export interface IFaqDetailScope extends ng.IScope {
    faq: Faq;
    refreshFaq(oid: string): void;
  }

  export class FaqDetailCtrl {
    static $inject = ['$scope', '$routeParams', 'faq.webapp.faqService'];  
      
    constructor (private $scope: IFaqDetailScope, private $routeParams: ng.route.IRouteParamsService, private faqService:faq.webapp.FaqService){
        this.refreshFaq($routeParams['faqId']);
    }  
    
    private refreshFaq(oid: string){
        console.log('Refresh FAQ');
        this.faqService.getFaq(oid, (faq: faq.webapp.Faq) => {
            this.$scope.faq = faq;
            console.log(faq);
        });         
    }
  }
}

faq.webapp.controllers
  .controller('faq.webapp.faqDetailCtrl', faq.webapp.FaqDetailCtrl);
  
  
