<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bulma/bulma.css">
    <link rel="stylesheet" href="/css/icons/icons.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.6/angular-material.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/javascript/angular/angular.min.js"></script>
    <script src="/javascript/controller/CreateProjectController.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-aria.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-messages.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.6/angular-material.min.js"></script>

</head>
<body>
    <#include "../Base/header.ftl">
<div>
    <img src="/images/logoCenter.png" width="10%" align=left>
    <h1 class="title is-1" style="margin-top: 2%"> TIPA: Crear un Proyecto</h1>
    <hr width="90%" align="right" >
</div>
<div ng-app="createProject" ng-controller="CreateProjectController as crtProject" style="width: 50%;margin-top: 1%;margin-right: auto;margin-left:auto">
    <div class="field">
        <label class="label">Nombre de Proyecto</label>
        <div class="control">
            <input class="input"  type="text" ng-model="crtProject.nameProyect" ng-change="crtProject.checkInformation()" placeholder="Nombre de Proyecto">
        </div>
    </div>
    <div class="field">
        <label class="label">Organizacion asociada al proyecto</label>
        <div class="select ">
            <select ng-model="crtProject.selectedOrganizationId" ng-change="crtProject.checkInformation()">
                <option ng-repeat="organization in crtProject.lstOrganizations" value="{{organization.getId()}}">{{organization.getName()}}</option>
            </select>
        </div>
    </div>
    <div class="field">
        <label class="label">Seleccionar Lenguaje</label>
            <div class="control">
                <div class="select is-info">
                    <select ng-model="crtProject.selectedLanguageId" ng-change="crtProject.checkInformation()" >
                        <option ng-repeat="language in crtProject.lstLanguages" value="{{language.getId()}}">{{language.getName()}}</option>
                    </select>
            </div>
        </div>
    </div>
    <div class="field">
        <label class="label">Seleccionar Modelo</label>
        <div class="control">
            <div class="select is-primary">
                <select ng-model="crtProject.selectedModelId" ng-change="crtProject.checkInformation()">
                    <option ng-repeat="model in crtProject.lstModels" value="{{model.getId()}}">{{model.getName()}}</option>
                </select>
            </div>
        </div>
    </div>

    <div class="field">
        <label class="label">Escoger la Fecha</label>
    </div>

    <md-datepicker ng-model="crtProject.startingDate" md-placeholder="Enter date"></md-datepicker>

    <div class="field">
        <label class="label">Precio del Proyecto(Pesos por hora)</label>
        <div class="control">
            <input class="input" step="0.01" ng-change="crtProject.checkInformation()" type="number" placeholder="Costo de Proyecto" ng-model="crtProject.pricePerHour">
        </div>
    </div>

    <div class="field ">
        <label class="label">Agregar Puntos Funcion</label>
        <button class="button is-primary" ng-click="crtProject.addFunctionPoint();crtProject.checkInformation()">Agregar un Punto Funcion +</button>
    </div>
    <div class="is-rounded" style="height: 15%;overflow: auto;border:1px solid black">
        <div class="field has-addons" ng-repeat="functionPoint in crtProject.lstFunctionPoints">
            <div class="control" style="width: 80%">
                <input class="input" ng-model="functionPoint.value" ng-change="crtProject.checkInformation()" type="text" placeholder="Nombre de punto Funcion"/>
            </div>
            <div class="control">
                <a class="button is-danger" ng-click="crtProject.removeFunctionPoint(functionPoint)">
                    X
                </a>
            </div>
        </div>
    </div>

    <div class="control" style="padding-left:35%;margin-top: 2%;">
        <button class="button is-dark" ng-click="crtProject.addProyect()" ng-disabled="crtProject.disableButton" style="width: 70%" >Crear Proyecto</button>
    </div>

</div>
</body>