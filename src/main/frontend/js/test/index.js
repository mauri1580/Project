import angular from "angular";
import uirouter from "angular-ui-router";

import routing from "./test.routes";
import TestController from "./test.controller";
import TestService from "./test.service";
import auth from "../auth";

export default angular
    .module("bdms.test", [
        uirouter,
        auth
    ])
    .config(routing)
    .controller("TestController", TestController)
    .service("TestService", TestService)
    .name;
