(function() {
    var listProjectApp = angular.module('listProjects',[]);

    listProjectApp.factory('Project',[function () {
        var Project = function () {
            
        };

        Project.prototype.setIdProject = function(idProject){
            this.idProject = idProject;
        }

        Project.prototype.getIdProject = function(){
            return this.idProject;
        }

        Project.prototype.setProjectName = function(name){
            this.projectName = name;
        };

        Project.prototype.getProjectName = function(){
            return this.projectName;
        };

        Project.prototype.setDateProject = function (dateString) {
            this.dateProject = dateString;
        };

        Project.prototype.getDateProject = function () {
            return this.dateProject;
        };

        Project.prototype.setPriceProject = function (price) {
            this.priceProject = price;
        };
        
        Project.prototype.getPriceProject = function () {
            return this.priceProject;
        };

        Project.prototype.setNameOrganization = function (nameOrganization) {
            this.nameOrganization = nameOrganization;
        };
        
        Project.prototype.getNameOrganization = function () {
            return this.nameOrganization;
        };
        
        Project.prototype.setFnPointsDone = function (fnPointsDone) {
            this.fnPointsDone = fnPointsDone;
        }

        Project.prototype.getFnPointsDone = function () {
            return this.fnPointsDone;
        }
        
        Project.prototype.setMultipDone = function (multiplierDone) {
            this.multiplierDone = multiplierDone;
        }

        Project.prototype.getMultipDone = function () {
            return this.multiplierDone;
        }
        
        Project.prototype.setScaleFactorDone = function (scaleFactorsDone) {
            this.scaleFactorsDone = scaleFactorsDone;
        }
        
        Project.prototype.getScaleFactorsDone = function () {
            return this.scaleFactorsDone;
        }
        
        Project.prototype.setReadyEstimation = function (readyEstimation) {
            this.readyEstimation = readyEstimation;
        }
        
        Project.prototype.getReadyEstimation =function () {
            return this.readyEstimation;
        }

        Project.prototype.setPercentageProject = function (percentage) {
            this.percentageProject = percentage;
        }

        Project.prototype.getPerentageProject = function () {
            return this.percentageProject;
        }
        return Project;
    }]);


    listProjectApp.controller('ListProjectController', ['$http','$scope','Project',function($http , $scope, Project){
        var vm = this;
        vm.listProjectsInfo = [];

        $http.get("/getLstProjects/")
            .then(function successCallback(response) {
                var listProjectsRaw = response.data.projects;
                initList(listProjectsRaw);
            });

        function initList(lstProjects){
            angular.forEach(lstProjects,function (project) {
                var projectInfo = new Project();
                projectInfo.setDateProject(project.dateProject);
                projectInfo.setIdProject(project.idProject);
                projectInfo.setNameOrganization(project.nameOrganization);
                projectInfo.setProjectName(project.nameProject);
                var priceRaw = project.priceProject;
                projectInfo.setPriceProject(priceRaw.toFixed(2));

                var fnPointsDone = !!project.fntPointsDone;
                var scaleFactorsDone = !!project.scaleFactorsDone;
                var multipliersDone = !!project.multipliersDone;

                projectInfo.setMultipDone(multipliersDone);
                projectInfo.setScaleFactorDone(scaleFactorsDone);
                projectInfo.setFnPointsDone(fnPointsDone);

                if(fnPointsDone && scaleFactorsDone && multipliersDone){
                    projectInfo.setReadyEstimation(true);
                    projectInfo.setPercentageProject(100);
                }else{
                    if(fnPointsDone){
                        if(scaleFactorsDone || multipliersDone){
                            projectInfo.setPercentageProject(66);
                        }else{
                            projectInfo.setPercentageProject(33);
                        }
                    }else{
                        if(scaleFactorsDone && multipliersDone){
                            projectInfo.setPercentageProject(66);
                        }else if(scaleFactorsDone || multipliersDone){
                            projectInfo.setPercentageProject(33);
                        }else{
                            projectInfo.setPercentageProject(0);
                        }
                    }
                }
                vm.listProjectsInfo.push(projectInfo);
            })
        }
    }]);

})(angular);