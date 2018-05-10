(function() {
    var createProject = angular.module('createProject',['ngMaterial','ngMessages']);


    createProject.factory('Organization',[function () {
        var Organization = function () {

        }

        Organization.prototype.setName= function (name) {
            this.name = name;
        }

        Organization.prototype.getName = function(){
            return this.name;
        }

        Organization.prototype.setId = function (id) {
            this.id = id;
        }

        Organization.prototype.getId = function () {
            return this.id;
        }

        return Organization;
    }]);

    createProject.factory('ModelProgramming',[function () {
        var ModelProgramming = function () {

        }

        ModelProgramming.prototype.setName= function (name) {
            this.name = name;
        }

        ModelProgramming.prototype.getName = function(){
            return this.name;
        }

        ModelProgramming.prototype.setId = function (id) {
            this.id = id;
        }

        ModelProgramming.prototype.getId = function () {
            return this.id;
        }

        return ModelProgramming;
    }]);

    createProject.factory('Language',[function () {
        var Language = function () {

        }

        Language.prototype.setName= function (name) {
            this.name = name;
        }

        Language.prototype.getName = function(){
            return this.name;
        }

        Language.prototype.setId = function (id) {
            this.id = id;
        }

        Language.prototype.getId = function () {
            return this.id;
        }

        return Language;
    }]);

    createProject.factory('Requirement',[function () {
        var Requirement = function () {

        }

        Requirement.prototype.setName= function (name) {
            this.name = name;
        }

        Requirement.prototype.getName = function(){
            return this.name;
        }

        Requirement.prototype.getId = function () {
            return this.id;
        }
        Requirement.prototype.setId= function (id) {
            this.id = id;
        }
        
        return Requirement;
    }]);


    createProject.controller('CreateProjectController', ['$http','$scope','Organization','ModelProgramming','Language','Requirement',function($http , $scope,Organization,ModelProgramming,Language,FunctionPoint){
        var vm = this;
        vm.startingDate = new Date();

        vm.lstOrganizations =[];
        vm.lstLanguages = [];
        vm.lstModels = [];
        vm.lstRequirements = [];

        vm.pricePerHour = 0;
        vm.selectedOrganizationId = "";
        vm.selectedModelId = "";
        vm.selectedLanguageId = "";
        vm.nameProyect = "";

        vm.errorModalClass = "";
        vm.successModalClass = "";

        vm.disableButton = true;

        vm.addRequirement = addRequirement;
        vm.removeRequirement = removeRequirement;
        vm.addProyect = addProyect;
        vm.checkInformation = checkInformation;
        vm.closeErrorModal = closeErrorModal;
        vm.closeSuccessModal = closeSuccessModal;

        $http.get('/projectBasicInfo/')
            .then(function successCallback(response) {
                var dataInformation = response.data;
                var rawLstOrganizations = dataInformation.lstOrganizations;
                var rawLstLanguages = dataInformation.lstLanguages;
                var rawLstModels = dataInformation.lstModels;

                cleanLstOrganizations(rawLstOrganizations);
                cleanLstLanguages(rawLstLanguages);
                cleanLstModels(rawLstModels);
            });

        function checkInformation(){
            if(vm.nameProyect != "" && vm.lstRequirements.length != 0 && vm.pricePerHour != 0
                && vm.selectedModelId != "" && vm.selectedOrganizationId != "" && vm.selectedLanguageId != "" ){
                vm.disableButton = false;
            }else{
                vm.disableButton = true;
            }
        }

        function addProyect(){

            var nombreProyecto = vm.nameProyect;
            var dateProject = vm.startingDate.getTime();
            var language = parseInt(vm.selectedLanguageId);
            var model = parseInt(vm.selectedModelId);
            var organization = parseInt(vm.selectedOrganizationId);
            var price = vm.pricePerHour;
            var lstRequirements = vm.lstRequirements;

            var data = {
                "projectName":nombreProyecto,
                "dateProject":dateProject,
                "languageProject":language,
                "modelProject":model,
                "organizationProject":organization,
                "priceProject":price,
                "lstRequirements":lstRequirements
            }

            $http.post('/createProject/',data)
                .then(function successCallback(response) {
                    var info = response.data.insertStatus;
                    if(info){
                        vm.successModalClass = "is-active";
                        resetViewForNewProject();
                    }else{
                        vm.errorModalClass = "is-active"
                    }
                },function errorCallback() {
                   ;
                });
        }

        function  closeSuccessModal(){
            vm.successModalClass = "";
        }

        function closeErrorModal(){
            vm.errorModalClass = "";
        }

        function addRequirement(){
            var idForNewFunctionPoint = vm.lstRequirements.length;
            var newFunctionPoint = new FunctionPoint();
            newFunctionPoint.setId(idForNewFunctionPoint);
            vm.lstRequirements.push(newFunctionPoint);
        }

        function removeRequirement(requirement){
            var requirementIndex = requirement.getId();
            vm.lstRequirements.splice(requirementIndex,1);
            for(var i = requirementIndex;i<vm.lstRequirements.length;i++){
                var requirementInfo = vm.lstRequirements[i];
                var requirementNewIndex = requirementInfo.getId()-1;
                requirementInfo.setId(requirementNewIndex)
            }
        }

        function resetViewForNewProject (){
            vm.lstRequirements = [];
            vm.pricePerHour = 0;
            vm.selectedOrganizationId = "";
            vm.selectedModelId = "";
            vm.selectedLanguageId = "";
            vm.nameProyect = "";
        }

        function cleanLstOrganizations(rawOrganizations){
            angular.forEach(rawOrganizations,function (organization) {
                var newOrganization = new Organization();
                newOrganization.setId(organization.id);
                newOrganization.setName(organization.name);
                vm.lstOrganizations.push(newOrganization);
            });

        }

        function cleanLstLanguages(rawLanguages){

            angular.forEach(rawLanguages,function (language) {
                var newLanguage = new Language();
                newLanguage.setId(language.id);
                newLanguage.setName(language.name);
                vm.lstLanguages.push(newLanguage);
            });

        }

        function cleanLstModels (rawModels){

            angular.forEach(rawModels,function (model) {
                var  newModelProgramming = new ModelProgramming();
                newModelProgramming.setId(model.id);
                newModelProgramming.setName(model.name);
                vm.lstModels.push(newModelProgramming);
            });

        }
    }]);

})(angular);