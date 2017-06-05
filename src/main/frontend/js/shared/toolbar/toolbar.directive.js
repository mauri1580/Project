/*@ngInject*/
export default class ToolbarDirective {
    constructor() {
        let toolbar = this;

        toolbar.template = require("./toolbar.html");
        toolbar.restrict = "EA";
        toolbar.scope = {
            authorities: '=authorities'
        };

        toolbar.controller = "ToolbarController";
        toolbar.controllerAs = "toolbar";
        toolbar.bindToController = true;
    }

    compile() {

    }

    link() {

    }
}
