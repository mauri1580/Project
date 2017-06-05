/*@ngInject*/
export default class HomeController {
    constructor($state, AuthService) {
        this.$state = $state;
        this.AuthService = AuthService;
        this.user = {};



    }

    $onInit() {
        this.retrieve();
    }

    retrieve() {
        this.AuthService.getUser()
            .then((result) => {
                this.user = result;
            });
    }

}
