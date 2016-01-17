/// <reference path="../app.d.ts" />
declare module faq.webapptest {
    interface IMainScope extends ng.IScope {
        awesomeThings: any[];
    }
    class MainCtrl {
        private $scope;
        constructor($scope: IMainScope);
    }
}
