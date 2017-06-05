import angular from "angular";
import uirouter from "angular-ui-router";

import routing from "./welcome.routes";
import WelcomeController from "./welcome.controller";

export default angular
    .module("bdms.welcome", [
        uirouter
    ])
    .config(routing)
    .controller("WelcomeController", WelcomeController)
    .name;
