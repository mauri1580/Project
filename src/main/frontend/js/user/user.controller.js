/*@ngInject*/
export default class UserController {
    constructor($state, AuthService) {
        let user = this;

        user.$state = $state;
        user.AuthService = AuthService;
        // user.SocketService.subscribe();
    }
}
