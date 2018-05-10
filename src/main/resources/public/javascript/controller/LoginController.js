(function () {

    var appLogin = angular.module('appLogin',[]);

    appLogin.controller('LoginController', ['$http', function($http) {
        var vm = this;
        vm.userName = "";
        vm.password = "";
        vm.getCredentials = getCredentials;
        
        function getCredentials() {

            var data = {
                "username":vm.userName
            }
           $http({
               method: 'POST',
               url: "/dashboard",
               data: data,
               headers: {'Content-Type': 'application/x-www-form-urlencoded'}
           })
        }
    }]);

})(angular);