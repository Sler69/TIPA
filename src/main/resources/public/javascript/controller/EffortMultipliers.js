(function () {
    var scaleFactors = angular.module('effortMultipliers',[]);
    scaleFactors.controller('EffortMultipliersController',['$http','$scope', function($http,$scope){
        var vm = this;
        //Variables
        vm.softwareReliability = -1;
        vm.dataCost = -1;
        vm.complexity = -1;
        vm.reusability = -1;
        vm.documentation = -1;
        vm.execution =-1;
        vm.storage =-1;
        vm.volatility =-1;
        vm.analyst =-1;
        vm.programmer =-1;
        vm.continuity =-1;
        vm.applicationExp =-1;
        vm.platformExp =-1;
        vm.languageExp =-1;
        vm.useSoftware =-1;
        vm.multisiteDev  =-1;
        vm.schedule =-1;

        vm.successModalClass = "";
        vm.errorModalClass = "";

        vm.idProject = "";

        vm.last=-1;
        vm.enabledButton =true;

        //Buttons class softwareReliability
        vm.bSR1 = "";
        vm.bSR2 = "";
        vm.bSR3 = "";
        vm.bSR4 = "";
        vm.bSR5 = "";
        vm.bSR6 = "";

        //Buttons class DataCost
        vm.bDC1 = "";
        vm.bDC2 = "";
        vm.bDC3 = "";
        vm.bDC4 = "";

        //Buttons class Complexity
        vm.bCom1 = "";
        vm.bCom2 = "";
        vm.bCom3 = "";
        vm.bCom4 = "";
        vm.bCom5 = "";
        vm.bCom6 = "";

        //Buttons class Rehusability
        vm.bRe1 = "";
        vm.bRe2 = "";
        vm.bRe3 = "";
        vm.bRe4 = "";
        vm.bRe5 = "";

        //Buttons class Documentation
        vm.bDoc1 = "";
        vm.bDoc2 = "";
        vm.bDoc3 = "";
        vm.bDoc4 = "";
        vm.bDoc5 = "";
        vm.bDoc6 = "";

        //Buttons class Execution
        vm.bEx1 = "";
        vm.bEx2 = "";
        vm.bEx3 = "";
        vm.bEx4 = "";

        //Buttons class Storage
        vm.bSt1 =  "";
        vm.bSt2 =  "";
        vm.bSt3 =  "";
        vm.bSt4 =  "";

        //Buttons class Volatility
        vm.bVol1 = "";
        vm.bVol2 = "";
        vm.bVol3 = "";
        vm.bVol4 = "";

        //Buttons class Analyst
        vm.bAn1 = "";
        vm.bAn2 = "";
        vm.bAn3 = "";
        vm.bAn4 = "";
        vm.bAn5 = "";

        //Buttons class Programmer
        vm.bProg1 = "";
        vm.bProg2 = "";
        vm.bProg3 = "";
        vm.bProg4 = "";
        vm.bProg5 = "";

        //Buttons class Continuity
        vm.bCon1 = "";
        vm.bCon2 = "";
        vm.bCon3 = "";
        vm.bCon4 = "";
        vm.bCon5 = "";

        //Buttons class Aplication Experience
        vm.bAppEx1 = "";
        vm.bAppEx2 = "";
        vm.bAppEx3 = "";
        vm.bAppEx4 = "";
        vm.bAppEx5 = "";

        //Buttons class Platform Experience
        vm.bPlatExp1 = "";
        vm.bPlatExp2 = "";
        vm.bPlatExp3 = "";
        vm.bPlatExp4 = "";
        vm.bPlatExp5 = "";

        //Buttons class Language and Tool Experience
        vm.bLanExp1 = "";
        vm.bLanExp2 = "";
        vm.bLanExp3 = "";
        vm.bLanExp4 = "";
        vm.bLanExp5 = "";

        //Buttons class use software tools
        vm.bUseSf1 = "";
        vm.bUseSf2 = "";
        vm.bUseSf3 = "";
        vm.bUseSf4 = "";
        vm.bUseSf5 = "";

        //Buttons class Multisite Develope
        vm.bMultDev1 = "";
        vm.bMultDev2 = "";
        vm.bMultDev3 = "";
        vm.bMultDev4 = "";
        vm.bMultDev5 = "";
        vm.bMultDev6 = "";

        //Buttons class Required Development Schedule
        vm.bSche1 = "";
        vm.bSche2 = "";
        vm.bSche3 = "";
        vm.bSche4 = "";
        vm.bSche5 = "";

        //Functions
        vm.optionSoftwareReliability = optionSoftwareReliability;
        vm.optionDataCost = optionDataCost;
        vm.optionComplexity = optionComplexity;
        vm.optionReusability = optionReusability;
        vm.optionDocumentation = optionDocumentation;
        vm.optionExecution = optionExecution;
        vm.optionStorage = optionStorage;
        vm.optionVolatility = optionVolatility;
        vm.optionAnalyst = optionAnalyst;
        vm.optionProgrammer = optionProgrammer;
        vm.optionContinuity = optionContinuity;
        vm.optionapplicationExp = optionapplicationExp;
        vm.optionplatformExp = optionplatformExp;
        vm.optionLanguageExp = optionLanguageExp;
        vm.optionUseSoftware = optionUseSoftware;
        vm.optionMultisiteDev = optionMultisiteDev;
        vm.optionSchedule = optionSchedule;
        vm.checkInfo = checkInfo;
        vm.uploadMultipliers = uploadMultipliers;
        vm.closeSuccessModal = closeSuccessModal;
        vm.closeErrorModal = closeErrorModal;

        getIdProject();

        function optionSoftwareReliability(optionValue){
            console.log(vm.softwareReliability);
            switch (vm.softwareReliability) {
                case 0.82:
                    vm.bSR1="buttom-style";
                    break;
                case  0.92 :
                    vm.bSR2="buttom-style";
                    break;
                case 1.00:
                    vm.bSR3="buttom-style";
                    break;
                case 1.10:
                    vm.bSR4="buttom-style";
                    break;
                case 1.26:
                    vm.bSR5="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeSoftwareReliabilityToInfo(optionValue);
            vm.softwareReliability = optionValue;
        }

        function changeSoftwareReliabilityToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 0.82:
                    vm.bSR1 = "is-info";
                    break;
                case 0.92:
                    vm.bSR2 = "is-info";
                    break;
                case 1.00:
                    vm.bSR3 = "is-info";
                    break;
                case 1.10:
                    vm.bSR4 = "is-info";
                    break;
                case 1.26:
                    vm.bSR5 = "is-info";
                    break;

            }
        }

        function optionDataCost(optionValue){
            console.log(vm.dataCost);
            switch (vm.dataCost) {
                case 0.90:
                    vm.bDC1="buttom-style";
                    break;
                case 1.00:
                    vm.bDC2="buttom-style";
                    break;
                case 1.14:
                    vm.bDC3="buttom-style";
                    break;
                case 1.28:
                    vm.bDC4="buttom-style";
                    break;

            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeDataCostToInfo(optionValue);
            vm.dataCost = optionValue;
        }

        function changeDataCostToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 0.90:
                    vm.bDC1 = "is-info";
                    break;
                case 1.00:
                    vm.bDC2 = "is-info";
                    break;
                case 1.14:
                    vm.bDC3 = "is-info";
                    break;
                case 1.28:
                    vm.bDC4 = "is-info";
                    break;
            }
        }

        function optionComplexity(optionValue){
            console.log(vm.complexity);
            switch (vm.complexity) {
                case 0.73:
                    vm.bCom1="buttom-style";
                    break;
                case 0.87:
                    vm.bCom2="buttom-style";
                    break;
                case 1.00:
                    vm.bCom3="buttom-style";
                    break;
                case 1.17:
                    vm.bCom4="buttom-style";
                    break;
                case 1.34:
                    vm.bCom5="buttom-style";
                    break;
                case 1.74:
                    vm.bCom6="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeComplexityToInfo(optionValue);
            vm.complexity = optionValue;
        }

        function changeComplexityToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 0.73:
                    vm.bCom1 = "is-info";
                    break;
                case 0.87:
                    vm.bCom2 = "is-info";
                    break;
                case 1.00:
                    vm.bCom3 = "is-info";
                    break;
                case 1.17:
                    vm.bCom4 = "is-info";
                    break;
                case 1.34:
                    vm.bCom5 = "is-info";
                    break;
                case 1.74:
                    vm.bCom6 = "is-info";
                    break;
            }
        }

        function optionReusability(optionValue){
            console.log(vm.reusability);
            switch (vm.reusability) {
                case 0.95:
                    vm.bRe1="buttom-style";
                    break;
                case 1.00:
                    vm.bRe2="buttom-style";
                    break;
                case 1.07:
                    vm.bRe3="buttom-style";
                    break;
                case 1.15:
                    vm.bRe4="buttom-style";
                    break;
                case 1.24:
                    vm.bRe5="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeReusabilityToInfo(optionValue);
            vm.reusability = optionValue;
        }

        function changeReusabilityToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 0.95:
                    vm.bRe1 = "is-info";
                    break;
                case 1.00:
                    vm.bRe2 = "is-info";
                    break;
                case 1.07:
                    vm.bRe3 = "is-info";
                    break;
                case 1.15:
                    vm.bRe4 = "is-info";
                    break;
                case 1.24:
                    vm.bRe5 = "is-info";
                    break;
            }
        }

        function optionDocumentation(optionValue){
            console.log(vm.documentation);
            switch (vm.documentation) {
                case 0.81:
                    vm.bDoc1="buttom-style";
                    break;
                case 0.91:
                    vm.bDoc2="buttom-style";
                    break;
                case 1.00:
                    vm.bDoc3="buttom-style";
                    break;
                case 1.11:
                    vm.bDoc4="buttom-style";
                    break;
                case 1.23:
                    vm.bDoc5="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeDocumentationToInfo(optionValue);
            vm.documentation = optionValue;
        }

        function changeDocumentationToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 0.81:
                    vm.bDoc1 = "is-info";
                    break;
                case 0.91:
                    vm.bDoc2 = "is-info";
                    break;
                case 1.00:
                    vm.bDoc3 = "is-info";
                    break;
                case 1.11:
                    vm.bDoc4 = "is-info";
                    break;
                case 1.23:
                    vm.bDoc5 = "is-info";
                    break;
            }
        }

        function optionExecution(optionValue){
            console.log(vm.execution);
            switch (vm.execution) {
                case 1.00:
                    vm.bEx1="buttom-style";
                    break;
                case 1.11:
                    vm.bEx2="buttom-style";
                    break;
                case 1.29:
                    vm.bEx3="buttom-style";
                    break;
                case 1.63:
                    vm.bEx4="buttom-style";
                    break;

            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeExecutionToInfo(optionValue);
            vm.execution = optionValue;
        }

        function changeExecutionToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 1.00:
                    vm.bEx1 = "is-info";
                    break;
                case 1.11:
                    vm.bEx2 = "is-info";
                    break;
                case 1.29:
                    vm.bEx3 = "is-info";
                    break;
                case 1.63:
                    vm.bEx4 = "is-info";
                    break;
            }
        }

        function optionStorage(optionValue){
            console.log(vm.storage);
            switch (vm.storage) {
                case 1.00:
                    vm.bSt1="buttom-style";
                    break;
                case 1.05:
                    vm.bSt2="buttom-style";
                    break;
                case 1.17:
                    vm.bSt3="buttom-style";
                    break;
                case 1.46:
                    vm.bSt4="buttom-style";
                    break;

            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeStorageToInfo(optionValue);
            vm.storage = optionValue;
        }

        function changeStorageToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 1.00:
                    vm.bSt1 = "is-info";
                    break;
                case 1.05:
                    vm.bSt2 = "is-info";
                    break;
                case 1.17:
                    vm.bSt3 = "is-info";
                    break;
                case 1.46:
                    vm.bSt4 = "is-info";
                    break;
            }
        }

        function optionVolatility(optionValue){
            console.log(vm.volatility);
            switch (vm.volatility) {
                case 0.86:
                    vm.bVol1="buttom-style";
                    break;
                case 1.00:
                    vm.bVol2="buttom-style";
                    break;
                case 1.15:
                    vm.bVol3="buttom-style";
                    break;
                case 1.30:
                    vm.bVol4="buttom-style";
                    break;


            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeVolatilityToInfo(optionValue);
            vm.volatility = optionValue;
        }

        function changeVolatilityToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 0.86:
                    vm.bVol1 = "is-info";
                    break;
                case 1.00:
                    vm.bVol2 = "is-info";
                    break;
                case 1.15:
                    vm.bVol3 = "is-info";
                    break;
                case 1.30:
                    vm.bVol4 = "is-info";
                    break;
            }
        }

        function optionAnalyst(optionValue){
            console.log(vm.analyst);
            switch (vm.analyst) {
                case 1.42:
                    vm.bAn1="buttom-style";
                    break;
                case 1.19:
                    vm.bAn2="buttom-style";
                    break;
                case 1.00:
                    vm.bAn3="buttom-style";
                    break;
                case 0.85:
                    vm.bAn4="buttom-style";
                    break;
                case 0.71:
                    vm.bAn5="buttom-style";
                    break;


            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeAnalystToInfo(optionValue);
            vm.analyst = optionValue;
        }

        function changeAnalystToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 1.42:
                    vm.bAn1 = "is-info";
                    break;
                case 1.19:
                    vm.bAn2 = "is-info";
                    break;
                case 1.00:
                    vm.bAn3 = "is-info";
                    break;
                case 0.85:
                    vm.bAn4 = "is-info";
                    break;
                case 0.71:
                    vm.bAn5 = "is-info";
                    break;
            }
        }

        function optionProgrammer(optionValue){
            console.log(vm.programmer);
            switch (vm.programmer) {
                case 1.34:
                    vm.bProg1="buttom-style";
                    break;
                case 1.15:
                    vm.bProg2="buttom-style";
                    break;
                case 1.00:
                    vm.bProg3="buttom-style";
                    break;
                case 0.88:
                    vm.bProg4="buttom-style";
                    break;
                case 0.76:
                    vm.bProg5="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeProgrammerToInfo(optionValue);
            vm.programmer = optionValue;
        }

        function changeProgrammerToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 1.34:
                    vm.bProg1 = "is-info";
                    break;
                case 1.15:
                    vm.bProg2 = "is-info";
                    break;
                case 1.00:
                    vm.bProg3 = "is-info";
                    break;
                case 0.88:
                    vm.bProg4 = "is-info";
                    break;
                case 0.76:
                    vm.bProg5 = "is-info";
                    break;
            }
        }

        function optionContinuity(optionValue){
            console.log(vm.continuity);
            switch (vm.continuity) {
                case 1.29:
                    vm.bCon1="buttom-style";
                    break;
                case 1.12:
                    vm.bCon2="buttom-style";
                    break;
                case 1.00:
                    vm.bCon3="buttom-style";
                    break;
                case 0.90:
                    vm.bCon4="buttom-style";
                    break;
                case 0.81:
                    vm.bCon5="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeContinuityToInfo(optionValue);
            vm.continuity = optionValue;
        }

        function changeContinuityToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 1.29:
                    vm.bCon1 = "is-info";
                    break;
                case 1.12:
                    vm.bCon2 = "is-info";
                    break;
                case 1.00:
                    vm.bCon3 = "is-info";
                    break;
                case 0.90:
                    vm.bCon4 = "is-info";
                    break;
                case 0.81:
                    vm.bCon5 = "is-info";
                    break;
            }
        }

        function optionapplicationExp(optionValue){
            console.log(vm.applicationExp);
            switch (vm.applicationExp) {
                case 1.22:
                    vm.bAppEx1="buttom-style";
                    break;
                case 1.10:
                    vm.bAppEx2="buttom-style";
                    break;
                case 1.00:
                    vm.bAppEx3="buttom-style";
                    break;
                case 0.88:
                    vm.bAppEx4="buttom-style";
                    break;
                case 0.81:
                    vm.bAppEx5="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeApplicationExpToInfo(optionValue);
            vm.applicationExp = optionValue;
        }

        function changeApplicationExpToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 1.22:
                    vm.bAppEx1 = "is-info";
                    break;
                case 1.10:
                    vm.bAppEx2 = "is-info";
                    break;
                case 1.00:
                    vm.bAppEx3 = "is-info";
                    break;
                case 0.88:
                    vm.bAppEx4 = "is-info";
                    break;
                case 0.81:
                    vm.bAppEx5 = "is-info";
                    break;
            }
        }

        function optionplatformExp(optionValue){
            console.log(vm.platformExp);
            switch (vm.platformExp) {
                case 1.19:
                    vm.bPlatExp1="buttom-style";
                    break;
                case 1.09:
                    vm.bPlatExp2="buttom-style";
                    break;
                case 1.00:
                    vm.bPlatExp3="buttom-style";
                    break;
                case 0.91:
                    vm.bPlatExp4="buttom-style";
                    break;
                case 0.85:
                    vm.bPlatExp5="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changePlatformExpToInfo(optionValue);
            vm.platformExp = optionValue;
        }

        function changePlatformExpToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 1.19:
                    vm.bPlatExp1 = "is-info";
                    break;
                case 1.09:
                    vm.bPlatExp2 = "is-info";
                    break;
                case 1.00:
                    vm.bPlatExp3 = "is-info";
                    break;
                case 0.91:
                    vm.bPlatExp4 = "is-info";
                    break;
                case 0.85:
                    vm.bPlatExp5 = "is-info";
                    break;
            }
        }

        function optionLanguageExp(optionValue){
            console.log(vm.languageExp);
            switch (vm.languageExp) {
                case 1.20:
                    vm.bLanExp1="buttom-style";
                    break;
                case 1.09:
                    vm.bLanExp2="buttom-style";
                    break;
                case 1.00:
                    vm.bLanExp3="buttom-style";
                    break;
                case 0.91:
                    vm.bLanExp4="buttom-style";
                    break;
                case 0.84:
                    vm.bLanExp5="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeLanguageExpToInfo(optionValue);
            vm.languageExp = optionValue;
        }

        function changeLanguageExpToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 1.20:
                    vm.bLanExp1 = "is-info";
                    break;
                case 1.09:
                    vm.bLanExp2 = "is-info";
                    break;
                case 1.00:
                    vm.bLanExp3 = "is-info";
                    break;
                case 0.91:
                    vm.bLanExp4 = "is-info";
                    break;
                case 0.84:
                    vm.bLanExp5 = "is-info";
                    break;
            }
        }

        function optionUseSoftware(optionValue){
            console.log(vm.useSoftware);
            switch (vm.useSoftware) {
                case 1.17:
                    vm.bUseSP1="buttom-style";
                    break;
                case 1.09:
                    vm.bUseSP2="buttom-style";
                    break;
                case 1.00:
                    vm.bUseSP3="buttom-style";
                    break;
                case 0.90:
                    vm.bUseSP4="buttom-style";
                    break;
                case 0.78:
                    vm.bUseSP5="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeUseSoftwareToInfo(optionValue);
            vm.useSoftware = optionValue;
        }

        function changeUseSoftwareToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 1.17:
                    vm.bUseSP1 = "is-info";
                    break;
                case 1.09:
                    vm.bUseSP2 = "is-info";
                    break;
                case 1.00:
                    vm.bUseSP3 = "is-info";
                    break;
                case 0.90:
                    vm.bUseSP4 = "is-info";
                    break;
                case 0.78:
                    vm.bUseSP5 = "is-info";
                    break;
            }
        }

        function optionMultisiteDev(optionValue){
            console.log(vm.multisiteDev);
            switch (vm.multisiteDev) {
                case 1.22:
                    vm.bMultDev1="buttom-style";
                    break;
                case 1.09:
                    vm.bMultDev2="buttom-style";
                    break;
                case 1.00:
                    vm.bMultDev3="buttom-style";
                    break;
                case 0.93:
                    vm.bMultDev4="buttom-style";
                    break;
                case 0.86:
                    vm.bMultDev5="buttom-style";
                    break;
                case 0.80:
                    vm.bMultDev6="buttom-style";
                    break;
            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeMultisiteDevToInfo(optionValue);
            vm.multisiteDev = optionValue;
        }

        function changeMultisiteDevToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 1.22:
                    vm.bMultDev1 = "is-info";
                    break;
                case 1.09:
                    vm.bMultDev2 = "is-info";
                    break;
                case 1.00:
                    vm.bMultDev3 = "is-info";
                    break;
                case 0.93:
                    vm.bMultDev4 = "is-info";
                    break;
                case 0.86:
                    vm.bMultDev5 = "is-info";
                    break;
                case 0.80:
                    vm.bMultDev6 = "is-info";
                    break;
            }
        }

        function optionSchedule(optionValue){
            console.log(vm.schedule);
            switch (vm.last) {
                case 1:
                    vm.bSche1="buttom-style";
                    break;
                case 2:
                    vm.bSche2="buttom-style";
                    break;
                case 3:
                    vm.bSche3="buttom-style";
                    break;
                case 4:
                    vm.bSche4="buttom-style";
                    break;
                case 5:
                    vm.bSche5="buttom-style";
                    break;

            }

            //Valor actual quie tenemos que ponerle la clase is-ifno
            changeScheduleToInfo(optionValue);
            vm.last = optionValue;
        }

        function changeScheduleToInfo(bottonSelected) {
            switch (bottonSelected) {
                case 1:
                    vm.bSche1 = "is-info";
                    vm.schedule=1.43;
                    break;
                case 2:
                    vm.bSche2 = "is-info";
                    vm.schedule=1.14;
                    break;
                case 3:
                    vm.bSche3 = "is-info";
                    vm.schedule=1.00;
                    break;
                case 4:
                    vm.bSche4 = "is-info";
                    vm.schedule=1.00;
                    break;
                case 5:
                    vm.bSche5 = "is-info";
                    vm.schedule=1.00;
                    break;

            }
        }



        function checkInfo(){
            if (vm.softwareReliability >= 0 &&
                vm.dataCost >= 0 &&
                vm.complexity >=0 &&
                vm.reusability >=0 &&
                vm.documentation >=0 &&
                vm.execution >=0 &&
                vm.storage >=0 &&
                vm.volatility >=0 &&
                vm.analyst >=0 &&
                vm.programmer >=0 &&
                vm.continuity>=0 &&
                vm.applicationExp >=0 &&
                vm.platformExp >=0 &&
                vm.languageExp >=0 &&
                vm.useSoftware >=0 &&
                vm.multisiteDev >=0 &&
                vm.schedule >=0

            ){
                vm.enabledButton = false;
            }else{
                vm.enabledButton = true;
            }
        }
        
        function uploadMultipliers() {

            var data = {
                "softwareReliability":vm.softwareReliability,
                "dataCost":vm.dataCost,
                "complexity":vm.complexity,
                "reusability":vm.reusability,
                "documentation":vm.documentation,
                "execution":vm.execution,
                "storage":vm.storage,
                "volatility": vm.volatility,
                "analyst" : vm.analyst,
                "programmer" : vm.programmer,
                "continuity" : vm.continuity,
                "applicationExp" : vm.applicationExp,
                "platformExp":vm.platformExp,
                "languageExp":vm.languageExp,
                "useSoftware":vm.useSoftware,
                "multisiteDev":vm.multisiteDev,
                "schedule":vm.schedule,
                "projectId":vm.projectId
            }

            $http.post('/saveEffortMultipliers/',data)
                .then(function successCallback(response) {
                    debugger
                    var info = response.data.insertStatus;
                    if(info){
                        vm.successModalClass = "is-active";
                    }else{
                        vm.errorModalClass = "is-active";
                    }
                },function errorCallback() {
                    vm.errorModalClass = "is-active";
                });

        }

        function getIdProject (){
            var information =  window.location.href
            var id = information.substr(information.lastIndexOf('/') + 1);
            vm.projectId = id;
        }


        function closeSuccessModal(){
            vm.successModalClass = "";
        }

        function closeErrorModal(){
            vm.errorModalClass = "";
        }
    }]);
})(angular);