/*@ngInject*/
export default function routes($stateProvider) {
    $stateProvider
        .state("test", {
            url: "/test",
            template: require("./test.html"),
            controller: "TestController",
            controllerAs: "test",
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
