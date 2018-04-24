(function() {
    var createOrgannization = angular.module('listOrganizations',[]);

    createOrgannization.factory('Organization',[function () {
        var Organization = function () {

        };

        Organization.prototype.setName= function (name) {
            this.name = name;
        };

        Organization.prototype.getName = function(){
            return this.name;
        };
        
        Organization.prototype.setId = function (id) {
            this.id = id;
        };
        
        Organization.prototype.getId = function () {
            return this.id;
        };

        Organization.prototype.setSelectedClass = function (classSelected) {
            this.classSelected = classSelected;
        };

        Organization.prototype.getSelectedClass = function () {
            return this.classSelected;
        };
        return Organization;
    }]);


    createOrgannization.controller('ListOrganizationsController', ['$http','$scope','Organization',function($http , $scope, Organization){
        var vm = this;
         vm.isSelectedOrganization = false;
         vm.listOrganizations = [];
         vm.selectedOrganizationId = -1;
         vm.nameOrganization = "";
         vm.numberOfProyects = -1;
         vm.showChangeButton = false;
         vm.enabledInput = true;
         vm.successModalClass = "";
         vm.errorModalClass = "";

         vm.selectOrganization = selectOrganization;
         vm.editOrganization = editOrganization;
         vm.cancelEditOrfganization = cancelEditOrfganization;
         vm.updateOrganizationName = updateOrganizationName;
         vm.closeSuccessModal = closeSuccessModal;
         vm.closeErrorModal = closeErrorModal;

        initializeList();

        function initializeList(){
            $http.get('/getOrganizations/')
                .then(function successCallback(response) {
                    var listOrganizationsRaw = response.data.organizations;
                    initList(listOrganizationsRaw);
                });
        }

        function initList (organizations){
            angular.forEach(organizations,function (organization) {
                var newOrganization = new Organization();
                newOrganization.setId(organization.id);
                newOrganization.setName(organization.name);
                newOrganization.setSelectedClass("");
                vm.listOrganizations.push(newOrganization);
            });
        }

        function selectOrganization (selectedOrganization){
            debugger
            angular.forEach(vm.listOrganizations,function (organization) {
                var idOrganization = organization.getId();
                if(idOrganization === vm.selectedOrganizationId ){
                    organization.setSelectedClass("");
                }
            });
            vm.isSelectedOrganization = true;
            selectedOrganization.setSelectedClass("is-selected");
            vm.selectedOrganizationId = selectedOrganization.getId();
            vm.nameOrganization = selectedOrganization.getName();
        }

        function editOrganization(){
            vm.showChangeButton = true;
            vm.enabledInput = false;
        }

        function cancelEditOrfganization(){
            vm.showChangeButton = false;
            vm.enabledInput = true;
        }

        function updateOrganizationName(){
            var data = {
                "organizationName":vm.nameOrganization,
                "organizationId":vm.selectedOrganizationId
            }

            $http.post('/updateOrganization/',data)
                .then(function successCallback(response) {
                    var info = response.data.statusUpdate;
                    if(info){
                        vm.successModalClass = "is-active";
                        resetDetailsOrganization();
                        initializeList();
                    }else{
                        vm.errorModalClass = "is-active";
                    }
                },function errorCallback() {
                    vm.errorModalClass = "is-active";
                });
        }

        function closeErrorModal(){
            vm.errorModalClass = "";
        }

        function closeSuccessModal(){
            vm.successModalClass = "";
        }

        function resetDetailsOrganization(){
            vm.selectedOrganizationId = -1;
            vm.nameOrganization = "";
            vm.numberOfProyects = -1;
            vm.showChangeButton = false;
            vm.enabledInput = true;
            vm.listOrganizations = [];
            vm.isSelectedOrganization = false;
        }
    }]);

})(angular);