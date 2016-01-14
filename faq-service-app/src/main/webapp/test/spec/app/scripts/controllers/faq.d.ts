/// <reference path="../app.d.ts" />
declare module yoAngularTestApp {
    interface IFaqScope extends ng.IScope {
        awesomeThings: any[];
    }
    class FaqCtrl {
        private $scope;
        constructor($scope: IFaqScope);
    }
}
