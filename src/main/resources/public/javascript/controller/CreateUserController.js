(function () {

    var createUser = angular.module('createUser',[]);

    createUser.controller('CreateUserController', ['$http','$scope', function($http,$scope) {
        var vm = this;
        //input binding
        vm.userName = "";
        vm.password = "";
        vm.firstName ="";
        vm.secondName= "";
        vm.email ="";
        vm.name = "";
        vm.validatePassword="";
        vm.gender="Masculino";

        //Boolean Binding
        vm.userCreated = false;
        vm.errorEmail=false;
        vm.requiredEmail=true;
        vm.requiredName=true;
        vm.requiredFirstName =true;
        vm.requiredUserName = true;
        vm.requiredPassword = true;
        vm.enabledButton =true;
        vm.passwordsMatch =false;

        vm.hideForm = true;
        vm.succesfullInsert = false;
        vm.errorInsert = false;
        //Info-view
        vm.passwordStrength = -1;

        //Class Binding
        vm.userEmailClass="";

        //Functions
        vm.createUser = createUser;
        vm.checkForm = checkForm;
        vm.checkEmail = checkEmail;
        vm.checkPassword = checkPassword;
        vm.checkUserName = checkUserName;
        vm.removeClass = removeClass;
        vm.checkName = checkName;
        vm.checkFirstName = checkFirstName;
        vm.checkMatchPassword = checkMatchPassword;

        function createUser() {

            var data = {
                "username":vm.userName,
                "firstName":vm.firstName,
                "secondName":vm.secondName,
                "name":vm.name,
                "email":vm.email,
                "password":vm.password,
                "gender":vm.gender
            }

            $http.post('/saveuser',data)
                .then(function successCallback(response) {
                    debugger
                    var info = response.data.statusInsert;
                    if(info){
                        vm.hideForm = false;
                        vm.succesfullInsert = true;
                        vm.errorInsert = false;
                    }else{
                        vm.errorInsert = true;
                    }
                    },function errorCallback() {
                        vm.errorInsert = true;
                });

        }

        function checkEmail(){
            if(vm.email.length >0) {
                vm.requiredEmail = false;
                if (validateEmail(vm.email)) {
                    vm.userEmailClass = "is-success";
                    vm.errorEmail = false;
                } else {
                    vm.userEmailClass = "is-danger";
                    vm.errorEmail = true;
                }
            }else{
                vm.requiredEmail = true;
                vm.errorEmail = false;
                vm.userEmailClass = "";
            }
        }

        function checkPassword(){
            if(vm.password.length>0){
                var passwordInfo = zxcvbn(vm.password);
                vm.passwordStrength = passwordInfo.score;
                vm.requiredPassword = false;
            }else{
                vm.requiredPassword = true;
                vm.passwordStrength = -1;
            }
        }

        function removeClass (){
            if(!vm.errorEmail){
                vm.userEmailClass="";
            }
        }

        function checkUserName(){
            if(vm.userName.length>0){
                vm.requiredUserName = false;
            }else{
                vm.requiredUserName = true;
            }
        }

        function checkName(){
            if(vm.name.length>0){
                vm.requiredName = false;
            }else {
                vm.requiredName = true;
            }
        }

        function checkFirstName(){
            if(vm.firstName.length>0){
                vm.requiredFirstName = false;
            }else{
                vm.requiredFirstName = true;
            }
        }

        function checkMatchPassword(){
            if(vm.validatePassword.length>0){
                if(!(vm.validatePassword === vm.password)){
                    vm.passwordsMatch= true;
                }else{
                    vm.passwordsMatch = false;
                }
            }
        }

        function checkForm(){
            if(!vm.requiredFirstName && !vm.requiredName && !vm.errorEmail && !vm.requiredEmail && !vm.requiredUserName && !vm.requiredPassword && vm.validatePassword && !vm.passwordsMatch ){
                vm.enabledButton = false;
            }else{
                vm.enabledButton = true;
            }
        }

        function validateEmail(email) {
            var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return re.test(email);
        }
    }]);

})(angular);