/// <reference path="../app.d.ts" />
declare module yoAngularTestApp {
    interface IMainScope extends ng.IScope {
        awesomeThings: any[];
    }
    class MainCtrl {
        private $scope;
        constructor($scope: IMainScope);
    }
}
