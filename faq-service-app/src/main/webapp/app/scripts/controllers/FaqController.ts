/// <reference path="../app.ts" />
/// <reference path="../../../typings/angularjs/angular-resource.d.ts" />
/// <reference path="../../../typings/angularjs/angular.d.ts" />
/// <reference path="../model/Faq.ts" />
/// <reference path="../services/FaqService.ts" />
'use strict';

module faq.webapp {
  
  export interface IFaqScope extends ng.IScope {
    faqs: Faq[];
    refreshFaqs(): void;
  }

  export class FaqCtrl {
    static $inject = ['$scope', 'faq.webapp.faqService'];  
      
    constructor (private $scope: IFaqScope, private faqService:faq.webapp.FaqService){
        this.refreshFaqs();
        
        $scope.refreshFaqs = () => {
            this.refreshFaqs();
        }
    }  
    
    private refreshFaqs(){
        console.log('Refresh FAQs');
        this.faqService.getAllFaqs((faqs: faq.webapp.Faq[]) => {
            this.$scope.faqs = faqs;
        });         
    }
  }
}

faq.webapp.controllers
  .controller('faq.webapp.faqCtrl', faq.webapp.FaqCtrl);
  
  
