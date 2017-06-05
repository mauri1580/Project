import angular from "angular";

import AuthService from "./auth.service";
import ErrorInterceptor from "./error.interceptor";

export default angular
    .module("bdms.auth", [])
    .service("AuthService", AuthService)
    .service("ErrorInterceptor", ErrorInterceptor)
    .name;
