/*@ngInject*/
export default class TestController {
    constructor($state, AuthService, TestService) {
        this.$state = $state;
        this.AuthService = AuthService;
        this.TestService = TestService;
        this.user = {};
        this.active = false;
        this.currentClass = 'test-card';
    }

    $onInit() {
        this.retrieve();
        this.getNullTests();
    }

    retrieve() {
        this.AuthService.getUser()
            .then((result) => {
                this.user = result;
            });
    }

    getNullTests() {
        this.TestService.getNullTests().then((response) => {
            console.log(response);
            this.neededTests = response.data;
        });
    }

    update(testId, value) {
        this.TestService.updateTest(testId, value).then((response) => {
            this.getNullTests();
        });
    }





}
