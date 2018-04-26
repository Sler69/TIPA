<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bulma/bulma.css">>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/javascript/angular/angular.min.js"></script>
    <script src="/javascript/controller/FunctionPointsController.js"></script>
</head>
<body>
<div>
    <#include "../Base/header.ftl">
    <div>
        <img src="/images/logoCenter.png" width="10%" align=left>
        <h1 class="title is-1" style="margin-top: 2%"> TIPA: Lista de Proyectos</h1>
        <hr width="90%" align="right" >
    </div>
    <div ng-app="functionPnts" ng-controller="FunctionPointsController as fnPnt" style="margin-top: 5%;width: 90%;margin-left: auto;margin-right: auto">
        <div>
            <p class="title"><strong>Punto Funcion</strong> <small></small></p>
            <div class="field">
                <label class="label">Tipo de Funcion</label>
                <div class="control">
                    <div class="select">
                        <select>
                            <option>Entrada Externa/Peticion Externa</option>
                            <option>Salida Externa</option>
                            <option>Archivos Logicos Internos</option>
                            <option>Archivos Logicos Externos</option>
                        </select>
                    </div>
                </div>
            </div>

            <div class="field">
                <label class="label">No.Entitades</label>
                <div class="control">
                    <input class="input" type="number" placeholder="No. Entidades">
                </div>
            </div>

            <div class="field">
                <label class="label">No. de Atributos</label>
                <div class="control">
                    <input class="input" type="number" placeholder="No. Atrributos">
                </div>
            </div>
        </div>
    </div>
</div>
</body>