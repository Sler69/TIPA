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

    createProject.factory('FunctionPoint',[function () {
        var FunctionPoint = function () {

        }

        FunctionPoint.prototype.setName= function (name) {
            this.name = name;
        }

        FunctionPoint.prototype.getName = function(){
            return this.name;
        }

        FunctionPoint.prototype.getId = function () {
            return this.id;
        }
        FunctionPoint.prototype.setId= function (id) {
            this.id = id;
        }
        
        return FunctionPoint;
    }]);


    createProject.controller('CreateProjectController', ['$http','$scope','Organization','ModelProgramming','Language','FunctionPoint',function($http , $scope,Organization,ModelProgramming,Language,FunctionPoint){
        var vm = this;
        vm.startingDate = new Date();

        vm.lstOrganizations =[];
        vm.lstLanguages = [];
        vm.lstModels = [];
        vm.lstFunctionPoints = [];

        vm.pricePerHour = 0;
        vm.selectedOrganizationId = "";
        vm.selectedModelId = "";
        vm.selectedLanguageId = "";
        vm.nameProyect = "";

        vm.disableButton = true;

        vm.addFunctionPoint = addFunctionPoint;
        vm.removeFunctionPoint = removeFunctionPoint;
        vm.addProyect = addProyect;
        vm.checkInformation = checkInformation;

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
            if(vm.nameProyect != "" && vm.lstFunctionPoints.length != 0 && vm.pricePerHour != 0
                && vm.selectedModelId != "" && vm.selectedOrganizationId != "" && vm.selectedLanguageId != "" ){
                vm.disableButton = false;
            }else{
                vm.disableButton = true;
            }
        }

        function addProyect(){

            var nombreProyecto = vm.nameProyect;
            var dateProyect = vm.startingDate.getTime();
            var languaje = parseInt(vm.selectedLanguageId);
            var model = parseInt(vm.selectedModelId);
            var organization = parseInt(vm.selectedOrganizationId);
            var price = vm.pricePerHour;
            var functionPn = vm.lstFunctionPoints;
            debugger
        }

        function addFunctionPoint(){
            var idForNewFunctionPoint = vm.lstFunctionPoints.length;
            var newFunctionPoint = new FunctionPoint();
            newFunctionPoint.setId(idForNewFunctionPoint);
            vm.lstFunctionPoints.push(newFunctionPoint);
            console.log(vm.lstFunctionPoints);
        }

        function removeFunctionPoint(functionPoint){
            var functionPointIndex = functionPoint.getId();
            vm.lstFunctionPoints.splice(functionPointIndex,1);
            for(var i = functionPointIndex;i<vm.lstFunctionPoints.length;i++){
                var fnPoint = vm.lstFunctionPoints[i];
                var fnPointNewIndex = fnPoint.getId()-1;
                fnPoint.setId(fnPointNewIndex)
            }
            console.log(vm.lstFunctionPoints)
        }

        function cleanLstOrganizations(rawOrganizations){
            debugger
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