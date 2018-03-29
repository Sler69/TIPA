(function () {

    var createUser = angular.module('createUser',[]);

    createUser.controller('CreateUserController', ['$http','$scope', function($http,$scope) {
        var vm = this;
        vm.userName = "";
        vm.password = "";
        vm.firstName ="";
        vm.secondName= "";
        vm.email = "";
        vm.name = "";

        vm.createUser = createUser;

        function createUser() {
            console.log(vm.name + "  " +  vm.secondName + " " + vm.firstName);
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