
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bulma/bulma.css">
    <link rel="stylesheet" href="/css/icons/icons.css">
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
    <article class="media" style="box-shadow: 0 1px 6px rgba(0, 0, 0, 0.12), 0 1px 4px rgba(0, 0, 0, 0.24);border: 1px solid #209cee" ng-repeat="project in lstProjectCont.listProjectsInfo">
        <figure class="media-left" >
            <p class="title">
                0%
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
            </div>
        </div>
        <div class="media-right">
            <button class="delete"></button>
        </div>
    </article>
    </div>
</div>
</body>
