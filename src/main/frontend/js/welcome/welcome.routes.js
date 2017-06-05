/*@ngInject*/
export default function routes($stateProvider) {
    $stateProvider
        .state("welcome", {
            url: "/",
            template: require("./welcome.html"),
            controller: "WelcomeController",
            controllerAs: "welcome",
            resolve: {
                authenticated: function($q, $state, AuthService) {
                    let deferred = $q.defer();

                    return AuthService.isAuthenticated()
                        .then(result => {
                            let isAuthenticated = result.data;

                            if (!isAuthenticated) {
                                return deferred.resolve(isAuthenticated);
                            } else {
                                $state.go("user.games");
                                return deferred.reject(isAuthenticated);
                            }
                    });
                }
            }
        });
}
