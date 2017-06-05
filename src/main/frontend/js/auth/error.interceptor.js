//Need to define as old school function because of how interceptors get allocated
/* @ngInject */
export default function ErrorInterceptor($log, $q, $location) {
    
    var interceptor = {
        responseError: responseError
    };
    
    return interceptor;
    
    //Intercepts responseErrors and checks error code
    function responseError(rejection) {
        switch (rejection.status) {
            case 403:
                $location.path("/welcome");
                break;
        }
        
        return $q.reject(rejection);
    }
}
