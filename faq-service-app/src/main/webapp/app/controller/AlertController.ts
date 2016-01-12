/// <reference path="../../../../../typings/angularjs/angular.d.ts" />
/// <reference path="../Application.ts"/>
modulefaq.app {
    exportclassAlertController {
        msg: string = "msg";

constructor(private $scope, private alertify) {

        }

        show(){
            this.alertify.log(this.msg);
        }
    }
}

faq.app.controllers.controller('faq.app.alertController', faq.app.AlertController)
