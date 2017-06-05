/*@ngInject*/
export default class AuthService {
    constructor($http, $q) {
        this.$http = $http;
        this.$q = $q;
        this.currentUser = null;
    }

    isAuthenticated() {
        return this.$http({
            method: 'GET',
            url: "api/authenticated"
        }).then((response) => {
                return response.data;
            }
        );
    }

    authenticate(credentials) {
        //Headers for Basic Auth
        let headers = credentials ?
            {authorization: 'Basic ' + btoa(credentials.email + ':' + credentials.password)} : {};

        return this.$http({
            method: 'GET',
            url: "api/authenticated",
            headers: headers
        }).then(
            (response) => {
                return response;
            },
            (response) => {
                return response;
            }
        );
    }

    getUser() {
        let deferred = this.$q.defer();

        if (this.isAuthenticated()) {
            return this.$http.get("/api/user")
                .then(result => {
                    this.currentUser = result.data;
                    return result.data;
                });
        }
    }

    logout() {
        return this.$http({
            method: 'POST',
            url: "/api/logout",
        }).then(
            (response) => {
                return response;
            }
        );
    }

}
