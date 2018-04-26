(function() {
    var fnPoints = angular.module('functionPnts',[]);

    fnPoints.factory('FunctionPoint',[function () {

    }]);


    fnPoints.controller('FunctionPointsController', ['$http','$scope','FunctionPoint',function($http , $scope, FunctionPoint){
        var vm = this;
        vm.listFunctionPoints = [];
        vm.projectId = "";

        getIdProject();
        getFunctionPntsOfProject();

        $http.get("/getLstProjects/")
            .then(function successCallback(response) {
                var listFnPointsRaw = response.data.fnPnts;
                initList(listFnPointsRaw);
            });


        function initList(lstFunctionPoints){

        }

        function getIdProject (){
            var information =  window.location.href
            var id = information.substr(information.lastIndexOf('/') + 1);
            vm.projectId = id;
        }

        function getFunctionPntsOfProject(){
            var data = {
                "projecId": vm.projectId
            }

            $http.post("/functionPointsProyect/",data)
                .then(function successCallback(response) {

            },function errorCallback() {

            });

        }
    }]);

})(angular);