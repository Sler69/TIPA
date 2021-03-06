
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bulma/bulma.css">>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/javascript/angular/angular.min.js"></script>
    <script src="/javascript/controller/ListProjectController.js"></script>
</head>
<body>
<div>
    <#include "../Base/header.ftl">
    <div>
        <img src="/images/logoCenter.png" width="10%" align=left>
        <h1 class="title is-1" style="margin-top: 2%"> TIPA: Lista de Proyectos</h1>
        <hr width="90%" align="right" >
    </div>
    <div ng-app="listProjects" ng-controller="ListProjectController as lstProjectCont" style="margin-top: 5%;width: 90%;margin-left: auto;margin-right: auto">
    <article class="media" style="box-shadow: 0 1px 6px rgba(0, 0, 0, 0.12), 0 1px 4px rgba(0, 0, 0, 0.24);" ng-repeat="project in lstProjectCont.listProjectsInfo">
        <figure class="media-left" >
            <p class="title" style="margin-top: 50%;margin-left: 15%;">
                {{project.getPerentageProject()}}%
            </p>
        </figure>
        <div class="media-content is-info">
            <div class="content">
                <p>
                    <strong>Nombre de Proyecto: </strong> <small>{{project.getProjectName()}}</small>
                    <br>
                    <strong>Organizacion: </strong> <small>{{project.getNameOrganization()}}</small>
                    <br>
                    <strong>Fecha de Inicio: </strong> {{project.getDateProject()}}<small></small>
                    <br>
                    <strong>Precio por hora: </strong>$ {{project.getPriceProject()}}<small></small>
                </p>
                <progress class="progress is-info" value="{{project.getPerentageProject()}}" max="100" style="margin-bottom: 1%;width: 50%">{{project.getPerentageProject()}}%</progress>
            </div>
        </div>
        <div class="media-right columns">
            <div class="column">
                <a class="button is-dark is-small" style="margin-top: 2%"
                   ng-if="!project.getFnPointsDone()"
                   href="/calculateFunPnts/{{project.getIdProject()}}" >
                    <span class="icon is-small ">
                        <i class="fas fa-plus"></i>
                    </span>
                    <span>Puntos funcion</span>
                </a>
                <a class="button is-dark is-small" style="margin-top: 2%"
                   ng-if="!project.getMultipDone()"
                   href="/effortMultipliers/{{project.getIdProject()}}">
                    <span class="icon is-small">
                        <i class="fas fa-plus"></i>
                    </span>
                    <span>Multiplicadores de Ezfuerzo</span>
                </a>
                <a class="button is-dark is-small"
                   ng-if="!project.getScaleFactorsDone()" style="margin-top: 2%"
                   href="/scaleFactors/{{project.getIdProject()}}">
                    <span class="icon is-small">
                        <i class="fas fa-plus"></i>
                    </span>
                    <span>Scale factors</span>
                </a>
            </div>
            <div class="column">
                <a class="button is-success is-small" style="margin-top: 2%"" disabled
                   ng-if="project.getFnPointsDone()">
                        <span class="icon is-small ">
                            <i class="fas fa-check"></i>
                        </span>
                    <span>Puntos funcion</span>
                </a>
                <a class="button is-success is-small " style="margin-top: 2%" disabled
                   ng-if="project.getMultipDone()">
                        <span class="icon is-small">
                            <i class="fas fa-check"></i>
                        </span>
                    <span>Multiplicadores de Ezfuerzo</span>
                </a>
                <a class="button is-success is-small " style="margin-top: 2%" disabled
                   ng-if="project.getScaleFactorsDone()">
                        <span class="icon is-small">
                            <i class="fas fa-check"></i>
                        </span>
                    <span>Scale factors</span>
                </a>
                <a class="button is-dark is-small" style="margin-top: 2%"
                   ng-if="project.getReadyEstimation()"
                   href="/estimation/{{project.getIdProject()}}">
                    <span class="icon is-small">
                        <i class="fas fa-plus"></i>
                    </span>
                    <span>Estimacion</span>
                </a>
            </div>
        </div>
    </article>
    </div>
</div>
</body>
