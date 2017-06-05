/*@ngInject*/
export default class Test {
    constructor($http, $q) {
        this.$http = $http;
        this.$q = $q;
    }

    getNullTests() {
        return this.$http({
            method: 'GET',
            url: "/api/test/null",
        }).then(
            (response) => {
                return response;
            },
            (response) => {
                return response;
            }
        );
    }

    update(testId, pass) {
        let test = {testId: testId,
        pass: pass};

        return this.$http({
            method: 'GET',
            url: "/api/test/update",
            params: test
        }).then(
            (response) => {
                return response;
            },
            (response) => {
                return response;
            }
        );
    }

}
