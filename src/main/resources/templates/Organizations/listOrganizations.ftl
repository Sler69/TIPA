<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bulma/bulma.css">
    <link rel="stylesheet" href="/css/icons/icons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/javascript/angular/angular.min.js"></script>
    <script src="/javascript/controller/ListOrganizationsController.js"></script>
</head>
<body>
<div>
    <#include "../Base/header.ftl">
    <div>
        <img src="/images/logoCenter.png" width="10%" align=left>
        <h1 class="title is-1" style="margin-top: 2%"> TIPA: Lista de Organizaciones</h1>
        <hr width="90%" align="right" >
    </div>
    <div  ng-app="listOrganizations" ng-controller="ListOrganizationsController as lstOrganizations" style="margin-top: 2%">
        <div class="tile is-ancestor" style="margin-left: -1.75rem;margin-top:-1.75rem;margin-right:-1.75rem;height: 90%;width: 85%;">
            <div class="tile is-vertical ">
                <table class="table is-striped is-hoverable">
                    <thead>
                        <tr>
                            <th>Nombre de Organizacion</th>
                            <th>No.de Proyectos</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="organization in lstOrganizations.listOrganizations" ng-class="organization.getSelectedClass()" ng-click="lstOrganizations.selectOrganization(organization)">
                            <td>{{organization.getName()}}</td>
                            <td>{{organization.getNumberOfProjects()}}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="tile is-parent">
                <article class="tile is-child notification is-white">
                    <div class="content">
                        <p class="title">Detalles de la Organizacion</p>
                        <div class="content" style="margin-top:10%" ng-show="!lstOrganizations.isSelectedOrganization">
                            <p>No se ha a selecionado ninguna oraganization</p>
                        </div>
                        <div class="content" style="margin-top: 2%" ng-show="lstOrganizations.isSelectedOrganization">
                            <h3>Nombre</h3>
                            <div class="field">
                                <div class="control">
                                    <input class="input" type="text" placeholder="Nombre" ng-model="lstOrganizations.nameOrganization" ng-disabled="lstOrganizations.enabledInput">
                                </div>
                            </div>
                            <a class="button is-dark  " ng-show="!lstOrganizations.showChangeButton" ng-click="lstOrganizations.editOrganization()">Editar Nombre</a>
                            <a class="button is-info " ng-show="lstOrganizations.showChangeButton" ng-click="lstOrganizations.updateOrganizationName()">Cambiar Nombre</a>
                            <a class="button is-dark  " ng-show="lstOrganizations.showChangeButton" ng-click="lstOrganizations.cancelEditOrfganization()">Cancelar</a>
                        </div>
                    </div>
                </article>
            </div>
        </div>
        <div class="modal has-text-centered has-addons-centered" ng-class="lstOrganizations.successModalClass">
            <div class="modal-background"></div>
            <div class="modal-card">
                <header class="modal-card-head">
                    <p class="modal-card-title">Organizacion</p>
                    <button class="delete" aria-label="close" ng-click="lstOrganizations.closeSuccessModal()"></button>
                </header>
                <section class="modal-card-body">
                    <p class=" has-text-centered">Se cambio el nombre de la organizacion de forma exitosa.</p>
                </section>
                <footer class="modal-card-foot has-text-centered" style="margin-top: 2%">
                    <a class="button is-success  is-centered" style="margin-left: auto; margin-right: auto" ng-click="lstOrganizations.closeSuccessModal()">Ok</a>
                </footer>
            </div>
        </div>

        <div class="modal" ng-class="lstOrganizations.errorModalClass">
            <div class="modal-background"></div>
            <div class="modal-card">
                <header class="modal-card-head ">
                    <p class="modal-card-title">Error:No se cambio el nombre de la organizacion</p>
                    <button class="delete" aria-label="close" ng-click="lstOrganizations.closeErrorModal()"></button>
                </header>
                <section class="modal-card-body">
                    <p class="is-danger has-text-centered">Hubo un error en el sistema por favor tratar mas tarde</p>
                </section>
                <footer class="modal-card-foot">
                    <button class="button is-danger" style="margin-left: auto; margin-right: auto" ng-click="lstOrganizations.closeErrorModal()">Cancelar</button>
                </footer>
            </div>
        </div>
    </div>
</div>
</body>
