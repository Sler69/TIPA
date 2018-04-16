(function () {
    var scaleFactors = angular.module('scaleFactors',[]);
    scaleFactors.controller('ScaleFactorsController',['$http','$scope', function($http,$scope){
        var vm = this;
        vm.precedentedness = "";
        vm.development = "";

        //Buttons Precedents
        vm.bP1 = "";
        vm.bP2 = "";
        vm.bP3 = "";
        vm.bP4 = "";
        vm.bP5 = "";
        vm.bP6 = "";

        vm.flag = true;

        //Functions
        vm.optionPrecedents = optionPrecedents;
        vm.optionDevelp = optionDevelp;

        function optionPrecedents(optionValue){
            vm.precedentedness = optionValue;
            console.log(vm.precedentedness);
            switch (optionValue) {
                case 1:
                    vm.bP1="is-info";
                    vm.bP2="buttom-style";
                    vm.bP3="buttom-style";
                    vm.bP4="buttom-style";
                    vm.bP5="buttom-style";
                    vm.bP6="buttom-style";
                    break;
                case 2:
                    vm.bP2="is-info";
                    vm.bP1="buttom-style";
                    vm.bP3="buttom-style";
                    vm.bP4="buttom-style";
                    vm.bP5="buttom-style";
                    vm.bP6="buttom-style";
                    break;
                case 3:
                    vm.bP3="is-info";
                    vm.bP2="buttom-style";
                    vm.bP1="buttom-style";
                    vm.bP4="buttom-style";
                    vm.bP5="buttom-style";
                    vm.bP6="buttom-style";
                    break;
                case 4:
                    vm.bP4="is-info";
                    vm.bP2="buttom-style";
                    vm.bP3="buttom-style";
                    vm.bP1="buttom-style";
                    vm.bP5="buttom-style";
                    vm.bP6="buttom-style";
                    break;
                case 5:
                    vm.bP5="is-info";
                    vm.bP2="buttom-style";
                    vm.bP3="buttom-style";
                    vm.bP4="buttom-style";
                    vm.bP1="buttom-style";
                    vm.bP6="buttom-style";
                    break;
                case 6:
                    vm.bP6="is-info";
                    vm.bP2="buttom-style";
                    vm.bP3="buttom-style";
                    vm.bP4="buttom-style";
                    vm.bP5="buttom-style";
                    vm.bP1="buttom-style";
                    break;
            }


        }

        function optionDevelp(optionValue){
            vm.precedentedness = optionValue;
            console.log(vm.precedentedness)
        }
    }]);
})(angular);