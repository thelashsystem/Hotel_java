(function() {
    function LoginController($scope, $location, notification, AuthService, UserService) {
        $scope.state = {
            username: '',
            password: ''
        };

        $scope.login = function(username, password) {
            AuthService.login(username, password)
                .then(function successCallback(res) {
                    UserService.setUser(username);
                    notification.log('Login successfully !');
                    $location.path('/dashboard');
                }, function errorCallback(err) {
                    notification.log('Username or password is incorrect !');
                });
        };
    };

    angular.module('module.auth.controller', [])
        .controller('LoginController', LoginController);
})();
