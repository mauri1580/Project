/*@ngInject*/
export default function routes($stateProvider) {
    $stateProvider
        .state("login", {
            url: "/login",
            template: require("./login.html"),
            controller: "LoginController",
            controllerAs: "login",
            resolve: {
                authenticated: function($q, $state, AuthService) {
                    let deferred = $q.defer();

                    return AuthService.isAuthenticated()
                        .then(result => {

                            let isAuthenticated = result;

                            if (!isAuthenticated) {
                                return deferred.resolve(isAuthenticated);
                            } else {
                                $state.go("home");
                                return deferred.reject(isAuthenticated);
                            }
                        });
                }
            }
        });
}
