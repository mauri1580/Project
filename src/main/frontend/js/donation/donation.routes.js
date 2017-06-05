/*@ngInject*/
export default function routes($stateProvider) {
    $stateProvider
        .state("donation", {
            url: "/donation",
            template: require("./donation.html"),
            controller: "DonationController",
            controllerAs: "donation",
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
