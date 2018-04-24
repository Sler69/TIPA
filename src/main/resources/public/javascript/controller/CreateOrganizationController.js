(function() {
    var createOrgannization = angular.module('createOrganization',[]);

    createOrgannization.controller('CreateOrganizationController', ['$http','$scope',function($http , $scope){
        var vm = this;
        vm.organizatioName ="";
        vm.buttonDisabled = true;
        vm.successModalClass = "";
        vm.errorModalClass = "";

        vm.checkOrganization = checkOrganization;
        vm.saveOrganization = saveOrganization;
        vm.closeSuccessModal = closeSuccessModal;
        vm.closeErrorModal = closeErrorModal;

        function checkOrganization(){
            if(vm.organizatioName != ''){
                vm.buttonDisabled = false;
            }else{
                vm.buttonDisabled = true;
            }
        }

        function saveOrganization(){
            var data = {
                "organizationName":vm.organizatioName
            }

            $http.post('/saveOrganization/',data)
                .then(function successCallback(response) {
                    var info = response.data.statusInsert;
                    if(info){
                        vm.successModalClass = "is-active";
                    }else{
                        vm.errorModalClass = "is-active";
                    }
                },function errorCallback() {
                    vm.errorModalClass = "is-active";
                });
        }

        function closeSuccessModal(){
            vm.organizatioName = "";
            vm.successModalClass = "";
            vm.buttonDisabled = true;
        }

        function closeErrorModal(){
            vm.errorModalClass = "";
        }

    }]);

})(angular);