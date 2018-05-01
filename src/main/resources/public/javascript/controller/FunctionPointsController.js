(function() {
    var fnPoints = angular.module('functionPnts',[]);

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
        
        FunctionPoint.prototype.getFunctionName = function () {
            return this.functionName;
        };
        
        FunctionPoint.prototype.setFunctionName = function (functionName) {
            return this.functionName = functionName
        }

        return FunctionPoint;
    }]);


    fnPoints.controller('FunctionPointsController', ['$http','$scope','FunctionPoint',function($http , $scope, FunctionPoint){
        var vm = this;
        vm.listFunctionPoints = [];
        vm.projectId = "";
        vm.successModalClass = "";
        vm.errorModalClass = "";

        vm.submitFunctionPoints = submitFunctionPoints;

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
                var lstFunctionPoints = response.data.fntPoints;

                initList(lstFunctionPoints);
            },function errorCallback() {

            });

        }

        function initList(lstFunctionPoints){
            angular.forEach(lstFunctionPoints,function (fntPoint) {
                var fntPointObject = new FunctionPoint();
                fntPointObject.setFunctionName(fntPoint.strFunctionName);
                fntPointObject.setNumberAttributes(fntPoint.intAtributes);
                fntPointObject.setNumberEntitites(fntPoint.intEntities);
                fntPointObject.setIdFunctionPoint(fntPoint.intIdFunctionPoint);
                fntPointObject.setTipoFuncion("Entrada Externa/Peticion Externa");
                vm.listFunctionPoints.push(fntPointObject);
            })
        }
        
        function submitFunctionPoints() {
            debugger
            var data = {
                "idProject": vm.projectId,
                "lstFunctionPoints":vm.listFunctionPoints
            };

            $http.post("/saveFunctionPoints/",data)
                .then(function successCallback(response) {

                    },function errorCallback() {
                    vm.errorModalClass = "is-active";
                });
        }
    }]);

})(angular);