(function() {
    var fnPoints = angular.module('functionPnts',[]);

    fnPoints.factory('Requirement',[function () {
        var Requirement = function () {
            
        };
        
        Requirement.prototype.setId = function (id) {
            this.id = id;
        };
        
        Requirement.prototype.getId = function () {
            return this.id;
        };
        
        Requirement.prototype.setName = function (name) {
            this.name = name;
        };
        
        Requirement.prototype.getName = function () {
            return this.name;
        };
        
        Requirement.prototype.setListFunctionPoints = function (lstFunctionPoints) {
            this.functionPnts = lstFunctionPoints;
        }
        
        Requirement.prototype.getListFunctionPoints = function () {
            return this.functionPnts;
        }
        
        Requirement.prototype.setButtonShow = function (showButton) {
            this.showButton = showButton;
        }
        
        Requirement.prototype.getButtonShow = function () {
            return this.showButton;
        }
        return Requirement;
    }]);

    fnPoints.factory('FunctionPoint',[function () {
        var FunctionPoint = function () {

        };
        
        FunctionPoint.prototype.setTipoFuncion = function (tipoFuncion) {
            this.tipoFuncion = tipoFuncion;
        };
        
        FunctionPoint.prototype.getTipoFuncion = function () {
            return this.tipoFuncion;
        };

        FunctionPoint.prototype.getNumberEntities = function () {
            return this.numberOfEntities
        };
        
        FunctionPoint.prototype.setNumberEntitites = function (numberEntities) {
            this.numberOfEntities = numberEntities
        };

        FunctionPoint.prototype.getNumberAttributes =function (){
            return this.numberOfAttributes;
        };

        FunctionPoint.prototype.setNumberAttributes = function (numberAttributes) {
            this.numberOfAttributes = numberAttributes;
        }
        
        FunctionPoint.prototype.getIdFunctionPoint = function () {
            return this.idFunctionPoint;
        }
        
        FunctionPoint.prototype.setIdFunctionPoint = function (idFunctionPoint) {
            this.idFunctionPoint = idFunctionPoint;
        }

        return FunctionPoint;
    }]);


    fnPoints.controller('FunctionPointsController', ['$http','$scope','FunctionPoint','Requirement',function($http , $scope, FunctionPoint,Requirement){
        var vm = this;
        vm.listRequirements = [];
        vm.projectId = "";
        vm.successModalClass = "";
        vm.errorModalClass = "";

        vm.submitFunctionPoints = submitFunctionPoints;
        vm.addFunctionPoint = addFunctionPoint;
        vm.removeFunctionPoint = removeFunctionPoint;
        vm.closeSuccessModal = closeSuccessModal;
        vm.closeErrorModal = closeErrorModal;

        getIdProject();
        getFunctionPntsOfProject();


        function getIdProject (){
            var information =  window.location.href
            var id = information.substr(information.lastIndexOf('/') + 1);
            vm.projectId = id;
        }

        function getFunctionPntsOfProject(){
            var data = {
                "projecId": vm.projectId
            }

            $http.post("/functionPointsProject/",data)
                .then(function successCallback(response) {

                var lstFunctionPoints = response.data.lstRequirements;

                initList(lstFunctionPoints);
            },function errorCallback() {

            });

        }

        function initList(lstRequirements){
            angular.forEach(lstRequirements,function (requirement) {
                var newRequirement = new Requirement();
                var lstFnPoints = [];
                var fnPnt = new FunctionPoint();
                newRequirement.setId(requirement.id);
                newRequirement.setName(requirement.name);
                newRequirement.setButtonShow(false);
                fnPnt.setNumberAttributes(0);
                fnPnt.setNumberEntitites(0);
                fnPnt.setIdFunctionPoint(0);
                fnPnt.setTipoFuncion("Entrada Externa/Peticion Externa");

                lstFnPoints.push(fnPnt);
                newRequirement.setListFunctionPoints(lstFnPoints);

                vm.listRequirements.push(newRequirement)
            })
            console.log(vm.listRequirements)
        }

        function addFunctionPoint(requirement){
            var fnPnt = new FunctionPoint();
            fnPnt.setNumberAttributes(0);
            fnPnt.setNumberEntitites(0);
            fnPnt.setIdFunctionPoint(0);
            fnPnt.setTipoFuncion("Entrada Externa/Peticion Externa");

            var lstFntPoints = requirement.getListFunctionPoints();
            var lstFntPointSize  = lstFntPoints.length;
            fnPnt.setIdFunctionPoint(lstFntPointSize);
            requirement.setButtonShow(true);
            lstFntPoints.push(fnPnt);
        }

        function removeFunctionPoint(requirement,id){
            var lstFntPoints = requirement.getListFunctionPoints();
            lstFntPoints.splice(id,1);
            for(var i = id;i<lstFntPoints.length;i++){
                var requirementInfo = lstFntPoints[i];
                var requirementNewIndex = requirementInfo.getIdFunctionPoint()-1;
                requirementInfo.setIdFunctionPoint(requirementNewIndex)
            }
            if(lstFntPoints.length>1){
                requirement.setButtonShow(true);
            }else{
                requirement.setButtonShow(false);
            }
        }

        function closeSuccessModal(){
            vm.successModalClass = "";
        }

        function closeErrorModal(){
            vm.errorModalClass = "";
        }
        
        function submitFunctionPoints() {

            var data = {
                "idProject": vm.projectId,
                "lstRequirements":vm.listRequirements
            };
            console.log(data);
            $http.post("/saveFunctionPoints/",data)
                .then(function successCallback(response) {
                    vm.successModalClass = "is-active";
                    },function errorCallback() {
                    vm.errorModalClass = "is-active";
                });
        }
    }]);

})(angular);