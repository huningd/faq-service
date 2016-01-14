/// <reference path="../app.ts" />
'use strict';
var yoAngularTestApp;
(function (yoAngularTestApp) {
    var MainCtrl = (function () {
        function MainCtrl($scope) {
            this.$scope = $scope;
            $scope.awesomeThings = [
                'HTML5 Boilerplate',
                'AngularJS',
                'Karma'
            ];
        }
        return MainCtrl;
    })();
    yoAngularTestApp.MainCtrl = MainCtrl;
})(yoAngularTestApp || (yoAngularTestApp = {}));
angular.module('yoAngularTestApp')
    .controller('MainCtrl', yoAngularTestApp.MainCtrl);
