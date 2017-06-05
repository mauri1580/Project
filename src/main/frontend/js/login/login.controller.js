/*@ngInject*/
export default class LoginController {
    constructor($state, AuthService) {
        this.$state = $state;
        this.AuthService = AuthService;
    }

    submit() {
        this.AuthService.authenticate(this.formData)
            .then((response) => {
                if (response.data){
                    this.$state.go("home");
                } else {
                    this.invalid = true;
                }
            });
    }


}
