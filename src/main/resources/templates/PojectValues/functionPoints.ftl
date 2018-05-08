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
        <h1 class="title is-1" style="margin-top: 2%"> TIPA: Puntos Funcion</h1>
        <hr width="90%" align="right" >
    </div>
    <div ng-app="functionPnts" ng-controller="FunctionPointsController as fnPnt" style="margin-top: 5%;width: 90%;margin-left: auto;margin-right: auto">
        <div ng-repeat="requirement in fnPnt.listRequirements">
            <hr width="70%" align="left" ng-if="!$first">
            <p class="title"><strong>Requerimiento:</strong> <small>{{requirement.getName()}}</small></p>
            <button class="button is-success" ng-click="fnPnt.addFunctionPoint(requirement)">Agregar Punto Funcion</button>
            <div ng-repeat="fntPoint in requirement.getListFunctionPoints()" style="margin-top: 2%;border: 1px solid black" >
                <div class="message-header" ng-if="requirement.getButtonShow()">
                    <button class="delete is-large" ng-click="fnPnt.removeFunctionPoint(requirement,fntPoint.getIdFunctionPoint())"></button>
                </div>
                <div class="field">
                    <label class="label" style="margin-top: 2%">Tipo de Funcion</label>
                    <div class="control">
                        <div class="select">
                            <select ng-model="fntPoint.tipoFuncion">
                                <option value="Entrada Externa/Peticion Externa">Entrada Externa/Peticion Externa</option>
                                <option value="Salida Externa">Salida Externa</option>
                                <option value="Archivos Logicos Internos">Archivos Logicos Internos</option>
                                <option value="Archivos Logicos Externos">Archivos Logicos Externos</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field">
                    <label class="label">No.Entitades</label>
                    <div class="control">
                        <input class="input" type="number" ng-model="fntPoint.numberOfEntities" placeholder="No. Entidades">
                    </div>
                </div>

                <div class="field" style="margin-bottom: 2%">
                    <label class="label">No. de Atributos</label>
                    <div class="control">
                        <input class="input" type="number" ng-model="fntPoint.numberOfAttributes" placeholder="No. Atrributos">
                    </div>
                </div>
            </div>
        </div>
        <a class="button is-dark is-center" ng-click="fnPnt.submitFunctionPoints()" style="margin-bottom: 5%;margin-top: 5%;margin-right: auto;margin-left: auto">Subir Puntos Funcion</a>

        <div class="modal has-text-centered has-addons-centered" ng-class="fnPnt.successModalClass">
            <div class="modal-background"></div>
            <div class="modal-card">
                <header class="modal-card-head">
                    <p class="modal-card-title">Puntos Funcions</p>
                    <button class="delete" aria-label="close" ng-click="fnPnt.closeSuccessModal()"></button>
                </header>
                <section class="modal-card-body">
                    <p class=" has-text-centered">Se guardaron existosamento los Puntos Funcion</p>
                </section>
                <footer class="modal-card-foot has-text-centered" style="margin-top: 2%">
                    <a class="button is-success  is-centered" style="margin-left: auto; margin-right: auto" href="/listProjects/">Ir a Proyectos</a>
                </footer>
            </div>
        </div>

        <div class="modal" ng-class="fnPnt.errorModalClass">
            <div class="modal-background"></div>
            <div class="modal-card">
                <header class="modal-card-head ">
                    <p class="modal-card-title">Error en el Sistema :No se guardaron los multiplicadores</p>
                    <button class="delete" aria-label="close" ng-click="fnPnt.closeErrorModal()"></button>
                </header>
                <section class="modal-card-body">
                    <p class="is-danger has-text-centered">Hubo un error en el sistema por favor tratar mas tarde</p>
                </section>
                <footer class="modal-card-foot">
                    <button class="button is-danger" style="margin-left: auto; margin-right: auto" ng-click="fnPnt.closeErrorModal()">Cancelar</button>
                </footer>
            </div>
        </div>
    </div>
</div>
</body>