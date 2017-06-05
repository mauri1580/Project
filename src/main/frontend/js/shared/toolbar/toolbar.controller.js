/*@ngInject*/
export default class ToolbarController {
    constructor($state, AuthService) {
        this.$state = $state;
        this.AuthService = AuthService;
    }

    logout() {
        this.AuthService.logout()
            .then((response) => {
                this.$state.go("welcome");
            });
    }
}
