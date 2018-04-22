<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bulma/bulma.css">
    <link rel="stylesheet" href="/css/icons/icons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/javascript/angular/angular.min.js"></script>
    <script src="/javascript/controller/CreateOrganizationController.js"></script>
</head>
<body>
    <#include "../Base/header.ftl">
<div>
    <img src="/images/logoCenter.png" width="10%" align=left>
    <h1 class="title is-1" style="margin-top: 2%"> TIPA: Crear una Organizaciòn</h1>
    <hr width="90%" align="right" >
</div>
<div ng-app="createOrganization" ng-controller="CreateOrganizationController as crtOrganization"style="width: 50%;margin-top: 5%;margin-right: auto;margin-left:auto">
    <div class="field">
        <label class="label">Nombre de Oraganización</label>
        <div class="control">
            <input class="input" ng-model="crtOrganization.organizatioName" ng-change="crtOrganization.checkOrganization()" type="text" placeholder="Nombre">
        </div>
    </div>
    <div class="control" style="padding-left:35%;">
        <button class="button is-dark" ng-disabled="crtOrganization.buttonDisabled" ng-click="crtOrganization.saveOrganization()">Crear Organizacion</button>
    </div>

    <div class="modal has-text-centered has-addons-centered" ng-class="crtOrganization.successModalClass">
        <div class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head">
                <p class="modal-card-title">Organizacion</p>
                <button class="delete" aria-label="close" ng-click="crtOrganization.closeSuccessModal()"></button>
            </header>
            <section class="modal-card-body">
                <p class=" has-text-centered">Se creo de forma exitosa la organizacion, ya puede crear proyectos para esta organizacion.</p>
            </section>
            <footer class="modal-card-foot has-text-centered" style="margin-top: 2%">
                <a class="button is-success  is-centered" style="margin-left: auto; margin-right: auto" href="/organizations/">Ir a la pagina de organizaciones</a>
            </footer>
        </div>
    </div>

    <div class="modal" ng-class="crtOrganization.errorModalClass">
        <div class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head ">
                <p class="modal-card-title">Error en el Sistema:No se creo la Organizacion</p>
                <button class="delete" aria-label="close" ng-click="crtOrganization.closeErrorModal()"></button>
            </header>
            <section class="modal-card-body">
                <p class="is-danger has-text-centered">Hubo un error en el sistema por favor tratar mas tarde</p>
            </section>
            <footer class="modal-card-foot">
                <button class="button is-danger" style="margin-left: auto; margin-right: auto" ng-click="crtOrganization.closeErrorModal()">Cancelar</button>
            </footer>
        </div>
    </div>
</div>
</body>