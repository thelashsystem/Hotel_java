(function() {
    angular.module('module.auth.route', [])
        .config(function ($stateProvider, $httpProvider, $locationProvider) {
	    /*$locationProvider.html5Mode({
	      enabled: true,
	      requireBase: false
	      });*/

            $stateProvider.state('login', {
                url: '/login',
                templateUrl: 'modules/auth/templates/login.html',
                controller: 'LoginController'
            });

            $httpProvider.defaults.withCredentials = true;
        }).run(function($rootScope, $location, Restangular, UserService){
            // Redirect to login when error code == 401
            Restangular.setErrorInterceptor(function(response, deferred, responseHandler) {
                if (response.status === 401) {
                    UserService.clearUser();
                    $location.path('/login');
                    return false;
                }
            });

            $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
                if (!UserService.getUser()) {
                    $location.path('/login');
                }
            });

            $rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams) {
                if (UserService.getUser() && toState.name === 'login') {
                    $location.path('/dashboard');
                }
            });

            if (!UserService.getUser()) {
                $location.path('/login');
            }
        });
})();
