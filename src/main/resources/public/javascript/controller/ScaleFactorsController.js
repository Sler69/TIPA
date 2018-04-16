(function () {
    var scaleFactors = angular.module('scaleFactors',[]);
    scaleFactors.controller('ScaleFactorsController',['$http','$scope', function($http,$scope){
        var vm = this;
        vm.precedentedness = "";
        vm.development = "";
        vm.buttonClass = "";

        vm.flag = true;

        //Functions
        vm.optionPrecedents = optionPrecedents;
        vm.optionDevelp = optionDevelp;

        function optionPrecedents(optionValue){
            vm.precedentedness = optionValue;
            console.log(vm.precedentedness);
            if(vm.flag==true){
                vm.buttonClass="is-info"
                vm.flag=false;
            }else{
                vm.buttonClass="buttom-style"
                vm.flag=true;
            }


        }

        function optionDevelp(optionValue){
            vm.precedentedness = optionValue;
            console.log(vm.precedentedness)
        }
    }]);
})(angular);