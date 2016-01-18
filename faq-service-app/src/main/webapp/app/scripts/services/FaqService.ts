/// <reference path="../app.ts" />
/// <reference path="../../../typings/angularjs/angular-resource.d.ts" />
/// <reference path="../../../typings/angularjs/angular.d.ts" />
/// <reference path="../model/Faq.ts" />
/// <reference path="../../../typings/alertify/alertify.d.ts" />

module faq.webapp {
    export interface FaqService {
        getAllFaqs(callback: (faqs: faq.webapp.Faq[]) => void);
        getFaq(oid: string, callback: (faq: faq.webapp.Faq) => void);
    }

    export class FaqServiceImpl implements FaqService {
        static $inject = ['faq.webapp.apiResource', '$resource', 'alertify'];

        faqContract: string = 'faq';

        constructor(private apiResource: ng.resource.IResourceClass<ng.resource.IResource<any>>,
            private $resource: ng.resource.IResourceService, private alert: alertify.IAlertifyStatic) {
            console.log('faq service started')
            alert.success('faq service started');
        }
        
        getAllFaqs(callback:(faqs:faq.webapp.Faq[]) => void) {
            this.apiResource.get((result:any) => {
                var faqs:faq.webapp.Faq[] = [];
                if (result.hasOwnProperty("_embedded") && result._embedded.hasOwnProperty(this.faqContract)) {
                    faqs = result._embedded['faq'];
                }
                callback(faqs);
            });
        }
        
        getFaq(oid: string, callback:(faq:faq.webapp.Faq) => void) {
            this.apiResource.get({ oid: oid }, (result:any) => {
                var faq:faq.webapp.Faq = result;
                callback(faq);
            });
        }
    }

}

faq.webapp.services.service("faq.webapp.faqService", faq.webapp.FaqServiceImpl);