/// <reference path="../app.ts" />
'use strict';
var yoAngularTestApp;
(function (yoAngularTestApp) {
    var AboutCtrl = (function () {
        function AboutCtrl($scope) {
            this.$scope = $scope;
            $scope.awesomeThings = [
                'HTML5 Boilerplate',
                'AngularJS',
                'Karma'
            ];
        }
        return AboutCtrl;
    })();
    yoAngularTestApp.AboutCtrl = AboutCtrl;
})(yoAngularTestApp || (yoAngularTestApp = {}));
angular.module('yoAngularTestApp')
    .controller('AboutCtrl', yoAngularTestApp.AboutCtrl);
