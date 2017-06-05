/*@ngInject*/
export default function routes($stateProvider) {
    $stateProvider
        .state("home", {
            url: "/home",
            template: require("./home.html"),
            controller: "HomeController",
            controllerAs: "home",
            resolve: {
                authenticated: function($q, $state, AuthService) {
                    let deferred = $q.defer();

                    return AuthService.isAuthenticated()
                        .then(result => {

                            let isAuthenticated = result;

                            if (isAuthenticated) {
                                return deferred.resolve(isAuthenticated);
                            } else {
                                $state.go("login");
                                return deferred.reject(isAuthenticated);
                            }
                        });
                }
            }
        });
}
