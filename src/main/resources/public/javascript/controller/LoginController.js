(function () {

    var appLogin = angular.module('appLogin',[]);

    appLogin.controller('LoginController', ['$http', function($http) {
        var vm = this;
        vm.userName = "";
        vm.password = "";
        vm.getCredentials = getCredentials;
        
        function getCredentials() {
            console.log(vm.userName + "  " +  vm.password);
            var data = {
                "username":vm.userName
            }
            $http.post("/lol",data).then();
        }
    }]);

})(angular);