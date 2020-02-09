(function() {
    function AuthService($http) {
        var api = {};

        api.login = function(username, password) {
            var url = finGlobalConfig.apiPrefix + '/login';
            var payload = {
                username: username,
                password: password
            };

            return $http.post(url, payload, {
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                transformRequest: function(obj) {
                    var str = [];
                    for(var p in obj)
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    return str.join("&");
                }
            });
        };

        api.logout = function() {
            var url = finGlobalConfig.apiPrefix + '/logout';
            return $http.get(url);
        };

        return api;
    }

    function UserService($window) {
        var api = {};

        api.getUser = function() {
            return $window.localStorage.getItem('user');
        };

        api.setUser = function(user) {
            return $window.localStorage.setItem('user', user);
        };

        api.clearUser = function() {
            return $window.localStorage.removeItem('user');
        };

        return api;
    }

    angular.module('module.auth.service', [])
        .factory('AuthService', AuthService)
        .factory('UserService', UserService);
})();
