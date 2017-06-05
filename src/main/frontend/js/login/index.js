import angular from "angular";
import uirouter from "angular-ui-router";

import routing from "./login.routes";
import LoginController from "./login.controller";
import auth from "../auth";

export default angular
    .module("bdms.login", [
        uirouter,
        auth
    ])
    .config(routing)
    .controller("LoginController", LoginController)
    .name;
