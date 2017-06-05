/*@ngInject*/
export default function routes($stateProvider) {
    $stateProvider
        .state("user", {
            url: "/user",
            template: require("./user.html"),
            controller: "UserController",
            controllerAs: "user",
            // resolve: {
            //     authenticated: function($q, $state, AuthService) {
            //         let deferred = $q.defer();
            //
            //         return AuthService.isAuthenticated()
            //             .then(result => {
            //                 let isAuthenticated = result.data;
            //
            //                 if (isAuthenticated) {
            //                     return deferred.resolve(isAuthenticated);
            //                 } else {
            //                     $state.go("welcome");
            //                     return deferred.reject(isAuthenticated);
            //                 }
            //             });
            //     }
            // }
        });
}
