import angular from "angular";
import uirouter from "angular-ui-router";

import routing from "./user.routes";
import UserController from "./user.controller";
import auth from "../auth";

export default angular
    .module("bdms.user", [
        uirouter,
        auth
    ])
    .config(routing)
    .controller("UserController", UserController)
    .name;
