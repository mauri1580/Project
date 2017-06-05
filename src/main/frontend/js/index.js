//Outside dependencies
import angular from "angular";
import materials from "angular-material";
import uirouter from "angular-ui-router";
import "../styles";

//Internal modules
import auth from "./auth";
import toolbar from "./shared/toolbar";
import user from "./user";
import welcome from "./welcome";
import login from "./login";
import home from "./home";
import donation from "./donation";
import test from "./test";


angular
    .module("bdms", [
        materials,
        uirouter,
        auth,
        toolbar,
        user,
        welcome,
        login,
        home,
        donation,
        test
    ])
    .config(routing)
    .config(intercepting)
    .config(mdThemes);

/*@ngInject*/
function routing ($urlRouterProvider, $locationProvider, $httpProvider){
    $locationProvider.html5Mode(false);
    $urlRouterProvider.otherwise("/");

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}

/*@ngInject*/
function intercepting ($httpProvider){
    $httpProvider.interceptors.push("ErrorInterceptor");
}

/*@ngInject*/
function mdThemes($mdThemingProvider) {

    $mdThemingProvider.theme("default")
        .primaryPalette("blue", {
            "default": "600"
        })
        .accentPalette("purple", {
            "default": "500"
        })
        .warnPalette("red");

}
