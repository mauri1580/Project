import angular from "angular";
import uirouter from "angular-ui-router";

import routing from "./donation.routes";
import DonationController from "./donation.controller";
import DonationService from "./donation.service";
import auth from "../auth";

export default angular
    .module("bdms.donation", [
        uirouter,
        auth
    ])
    .config(routing)
    .controller("DonationController", DonationController)
    .service("DonationService", DonationService)
    .name;
