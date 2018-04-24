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
                vm.listProjectsInfo.push(projectInfo);
            })
        }
    }]);

})(angular);