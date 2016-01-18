/// <reference path="../app.ts" />
/// <reference path="../../../typings/angularjs/angular-resource.d.ts" />
/// <reference path="../../../typings/angularjs/angular.d.ts" />
'use strict';

module faq.webapp {
    
  export interface Question{
      getText(): string;
  }  
  
  export interface Rating{
      getUser(): string;
      getRating(): number;
  }
  
  export interface Answer{
      getText(): string;
      getRatings(): Rating[];
  }
  export interface Faq{
      getOid(): string;
      getQuestion(): Question;
      getAnswers(): Answer[];
  }  
  
  export interface FaqResource extends Faq, ng.resource.IResource<Faq>{
      
  }
  
  export interface FaqsResource extends ng.resource.IResource<FaqResource>{
    
  }
  
}