/*@ngInject*/
export default class ToolbarService {
    constructor($http) {
        let toolbar = this;
        
        toolbar.$http = $http;
    }

    getCurrentNotifications() {
        let toolbar = this;

        return toolbar.$http({
                url: "/api/currentNotifications",
                method: "GET",
                params: {toUserId: 5}
            })
            .then(result => {
                return result.data;
            });
    }
    
}
