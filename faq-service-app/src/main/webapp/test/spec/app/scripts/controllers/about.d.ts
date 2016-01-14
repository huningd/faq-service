/// <reference path="../app.d.ts" />
declare module yoAngularTestApp {
    interface IAboutScope extends ng.IScope {
        awesomeThings: any[];
    }
    class AboutCtrl {
        private $scope;
        constructor($scope: IAboutScope);
    }
}
