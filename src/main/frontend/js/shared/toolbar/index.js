import angular from "angular";

import ToolbarDirective from "./toolbar.directive";
import ToolbarService from "./toolbar.service";
import AuthService from "../../auth/auth.service";
import ToolbarController from "./toolbar.controller";

export default angular
    .module("bdms.toolbar", [])
    .directive("toolbar", () => new ToolbarDirective())
    .service("AuthService", AuthService)
    .service("ToolbarService", ToolbarService)
    .controller("ToolbarController", ToolbarController)
    .name;
