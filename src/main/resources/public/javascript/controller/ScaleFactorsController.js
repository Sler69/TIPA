(function () {
    var scaleFactors = angular.module('scaleFactors',[]);
    scaleFactors.controller('ScaleFactorsController',['$http','$scope', function($http,$scope){
        var vm = this;
        vm.precedentedness = 0;
        vm.development = 0;
        vm.architecture = 0;
        vm.cohesion = 0;
        vm.maturity = 0;

        //Buttons class Precedents
        vm.bP1 = "";
        vm.bP2 = "";
        vm.bP3 = "";
        vm.bP4 = "";
        vm.bP5 = "";
        vm.bP6 = "";

        //Buttons class Development
        vm.bD1 = "";
        vm.bD2 = "";
        vm.bD3 = "";
        vm.bD4 = "";
        vm.bD5 = "";
        vm.bD6 = "";

        //Buttons class Architecture
        vm.bA1 = "";
        vm.bA2 = "";
        vm.bA3 = "";
        vm.bA4 = "";
        vm.bA5 = "";
        vm.bA6 = "";

        //Buttons class Cohesion
        vm.bA1 = "";
        vm.bA2 = "";
        vm.bA3 = "";
        vm.bA4 = "";
        vm.bA5 = "";
        vm.bA6 = "";

        //Buttons class Maturity
        vm.bM1 = "";
        vm.bM2 = "";
        vm.bM3 = "";
        vm.bM4 = "";
        vm.bM5 = "";
        vm.bM6 = "";

        //Functions
        vm.optionPrecedents = optionPrecedents;
        vm.optionDevelopment = optionDevelopment;
        vm.optionArchitecture = optionArchitecture;
        vm.optionCohesion = optionCohesion;
        vm.optionMaturity = optionMaturity;

        function optionPrecedents(optionValue){
            console.log(vm.precedentedness);
            switch (vm.precedentedness) {
                case 6.20:
                    vm.bP1="buttom-style";
                    break;
                case 4.96:
                    vm.bP2="buttom-style";
                    break;
                case 3.72:
                    vm.bP3="buttom-style";
                    break;
                case 2.48:
                    vm.bP4="buttom-style";
                    break;
                case 1.24:
                    vm.bP5="buttom-style";
                    break;
                case 0.0:
                    vm.bP6="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changePrecendceToInfo(optionValue);
            vm.precedentedness = optionValue;
        }

        function changePrecendceToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 6.20:
                    vm.bP1 = "is-info";
                    break;
                case 4.96:
                    vm.bP2 = "is-info";
                    break;
                case 3.72:
                    vm.bP3 = "is-info";
                    break;
                case 2.48:
                    vm.bP4 = "is-info";
                    break;
                case 1.24:
                    vm.bP5 = "is-info";
                    break;
                case 0.0:
                    vm.bP6 = "is-info";
                    break;

            }
        }

        function optionDevelopment(optionValue){
            console.log(vm.development);
            switch (vm.development) {
                case 5.07:
                    vm.bD1="buttom-style";
                    break;
                case 4.05:
                    vm.bD2="buttom-style";
                    break;
                case 3.04:
                    vm.bD3="buttom-style";
                    break;
                case 2.03:
                    vm.bD4="buttom-style";
                    break;
                case 1.01:
                    vm.bD5="buttom-style";
                    break;
                case 0.0:
                    vm.bD6="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeDevelopmenToInfo(optionValue);
            vm.development = optionValue;
        }

        function changeDevelopmenToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 5.07:
                    vm.bD1 = "is-info";
                    break;
                case 4.05:
                    vm.bD2 = "is-info";
                    break;
                case 3.04:
                    vm.bD3 = "is-info";
                    break;
                case 2.03:
                    vm.bD4 = "is-info";
                    break;
                case 1.01:
                    vm.bD5 = "is-info";
                    break;
                case 0.0:
                    vm.bD6 = "is-info";
                    break;
            }
        }

        function optionArchitecture(optionValue){
            console.log(vm.architecture);
            switch (vm.architecture) {
                case 7.07:
                    vm.bA1="buttom-style";
                    break;
                case 5.65:
                    vm.bA2="buttom-style";
                    break;
                case 4.24:
                    vm.bA3="buttom-style";
                    break;
                case 2.83:
                    vm.bA4="buttom-style";
                    break;
                case 1.41:
                    vm.bA5="buttom-style";
                    break;
                case 0.0:
                    vm.bA6="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeArchitectureToInfo(optionValue);
            vm.architecture = optionValue;
        }

        function changeArchitectureToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 7.07:
                    vm.bA1 = "is-info";
                    break;
                case 5.65:
                    vm.bA2 = "is-info";
                    break;
                case 4.24:
                    vm.bA3 = "is-info";
                    break;
                case 2.83:
                    vm.bA4 = "is-info";
                    break;
                case 1.41:
                    vm.bA5 = "is-info";
                    break;
                case 0.0:
                    vm.bA6 = "is-info";
                    break;
            }
        }

        function optionCohesion(optionValue){
            console.log(vm.cohesion);
            switch (vm.cohesion) {
                case 5.48:
                    vm.bC1="buttom-style";
                    break;
                case 4.38:
                    vm.bC2="buttom-style";
                    break;
                case 3.29:
                    vm.bC3="buttom-style";
                    break;
                case 2.19:
                    vm.bC4="buttom-style";
                    break;
                case 1.10:
                    vm.bC5="buttom-style";
                    break;
                case 0.0:
                    vm.bC6="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeCohesionToInfo(optionValue);
            vm.cohesion = optionValue;
        }

        function changeCohesionToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 5.48:
                    vm.bC1 = "is-info";
                    break;
                case 4.38:
                    vm.bC2 = "is-info";
                    break;
                case 3.29:
                    vm.bC3 = "is-info";
                    break;
                case 2.19:
                    vm.bC4 = "is-info";
                    break;
                case 1.10:
                    vm.bC5 = "is-info";
                    break;
                case 0.0:
                    vm.bC6 = "is-info";
                    break;
            }
        }

        function optionMaturity(optionValue){
            console.log(vm.maturity);
            switch (vm.maturity) {
                case 7.80:
                    vm.bM1="buttom-style";
                    break;
                case 6.24:
                    vm.bM2="buttom-style";
                    break;
                case 4.68:
                    vm.bM3="buttom-style";
                    break;
                case 3.12:
                    vm.bM4="buttom-style";
                    break;
                case 1.56:
                    vm.bM5="buttom-style";
                    break;
                case 0.0:
                    vm.bM6="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeMaturityToInfo(optionValue);
            vm.maturity = optionValue;
        }

        function changeMaturityToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 7.80:
                    vm.bM1 = "is-info";
                    break;
                case 6.24:
                    vm.bM2 = "is-info";
                    break;
                case 4.68:
                    vm.bM3 = "is-info";
                    break;
                case 3.12:
                    vm.bM4 = "is-info";
                    break;
                case 1.56:
                    vm.bM5 = "is-info";
                    break;
                case 0.0:
                    vm.bM6 = "is-info";
                    break;
            }
        }

    }]);
})(angular);