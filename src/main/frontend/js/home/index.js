import angular from "angular";
import uirouter from "angular-ui-router";

import routing from "./home.routes";
import HomeController from "./home.controller";
import auth from "../auth";

export default angular
    .module("bdms.home", [
        uirouter,
        auth
    ])
    .config(routing)
    .controller("HomeController", HomeController)
    .name;
