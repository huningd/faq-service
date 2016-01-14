/// <reference path="../app.ts" />
'use strict';
var yoAngularTestApp;
(function (yoAngularTestApp) {
    var FaqCtrl = (function () {
        function FaqCtrl($scope) {
            this.$scope = $scope;
            $scope.awesomeThings = [
                'HTML5 Boilerplate',
                'AngularJS',
                'Karma'
            ];
        }
        return FaqCtrl;
    })();
    yoAngularTestApp.FaqCtrl = FaqCtrl;
})(yoAngularTestApp || (yoAngularTestApp = {}));
angular.module('yoAngularTestApp')
    .controller('FaqCtrl', yoAngularTestApp.FaqCtrl);
