<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bulma/bulma.css">
    <link rel="stylesheet" href="/css/Tables/buttons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/javascript/angular/angular.min.js"></script>
    <script src="/javascript/controller/ScaleFactorsController.js"></script>

</head>
<body>
<#include "../Base/header.ftl">
<div>
    <img src="/images/logoCenter.png" width="10%" align=left>
    <h1 class="title is-1"> TIPA </h1>
    <hr width="90%" align="right" >
</div>


<h1 class="title" style="margin-left: 40%"> Scale Factors </h1>
<div ng-app="scaleFactors" ng-controller="ScaleFactorsController as sf">
    <table class="table  is-striped " style=" margin-top: 50px; margin-left: 10%">
        <thead>
            <tr>
                <th style="text-align: center"> <abbr>SF</abbr></th>
                <th style="text-align: center"> <abbr>Very low</abbr></th>
                <th style="text-align: center"> <abbr>Low</abbr></th>
                <th style="text-align: center"> <abbr>Nominal</abbr></th>
                <th style="text-align: center"> <abbr>High</abbr></th>
                <th style="text-align: center"> <abbr>Very High</abbr></th>
                <th style="text-align: center"> <abbr>Extra high</abbr></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th style="text-align: center"> Precedentedness </th>
                    <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionPrecedents(6.20); sf.checkInfo()" ng-class="sf.bP1"> Thoroughly unprecedent</button></td>
                    <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionPrecedents(4.96); sf.checkInfo()" ng-class="sf.bP2" > Largely unprecedent </button></td>
                    <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionPrecedents(3.72); sf.checkInfo()" ng-class="sf.bP3"> Somewhat unprecedent </button ></td>
                    <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionPrecedents(2.48); sf.checkInfo()" ng-class="sf.bP4"> Generaly familiar </button ></td>
                    <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionPrecedents(1.24); sf.checkInfo()" ng-class="sf.bP5"> Largely familiar</button ></td>
                    <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionPrecedents(0.0); sf.checkInfo()"  ng-class="sf.bP6"> Thoroughly familiar </button ></td>

            </tr>
            <tr>
                <th style="text-align: center"> <p>Development</p> <p>Flexibility</p> </th>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="sf.optionDevelopment(5.07); sf.checkInfo()" ng-class="sf.bD1"> Rigorous </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="sf.optionDevelopment(4.05); sf.checkInfo()" ng-class="sf.bD2"> Occasional relaxation  </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="sf.optionDevelopment(3.04); sf.checkInfo()" ng-class="sf.bD3"> Some relaxation </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="sf.optionDevelopment(2.03); sf.checkInfo()" ng-class="sf.bD4"> Generaly Conformity </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="sf.optionDevelopment(1.01); sf.checkInfo()" ng-class="sf.bD5"> Some conformity</button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="sf.optionDevelopment(0.0); sf.checkInfo()"  ng-class="sf.bD6"> General goals </button ></td>
            </tr>
            <tr>
                <th style="text-align: center"> <p>Architecture /</p> <p>Risk Resolution</p> </th>
                <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionArchitecture(7.07); sf.checkInfo()" ng-class="sf.bA1"> 20% </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionArchitecture(5.65); sf.checkInfo()" ng-class="sf.bA2"> 40% </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionArchitecture(4.24); sf.checkInfo()" ng-class="sf.bA3"> 60% </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionArchitecture(2.83); sf.checkInfo()" ng-class="sf.bA4"> 75% </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionArchitecture(1.41); sf.checkInfo()" ng-class="sf.bA5"> 90% </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionArchitecture(0.0); sf.checkInfo()"  ng-class="sf.bA6"> 100% </button ></td>
            </tr>
            <tr>
                <th style="text-align: center"> Team cohesion </th>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="sf.optionCohesion(5.48); sf.checkInfo()" ng-class="sf.bC1"> Very difficult </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="sf.optionCohesion(4.38); sf.checkInfo()" ng-class="sf.bC2"> Some difficult </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="sf.optionCohesion(3.29); sf.checkInfo()" ng-class="sf.bC3"> Basically cooperative </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="sf.optionCohesion(2.19); sf.checkInfo()" ng-class="sf.bC4"> Largely cooperative </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="sf.optionCohesion(1.10); sf.checkInfo()" ng-class="sf.bC5"> Highly Cooperative </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="sf.optionCohesion(0.0); sf.checkInfo()"  ng-class="sf.bC6"> Seamless interaction </button ></td>
            </tr>
            <tr>
                <th style="text-align: center"> <p>Equivalent </p> <p>Process Maturity </p> </th>
                <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionMaturity(7.80); sf.checkInfo()" ng-class="sf.bM1"> Level 1 low </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionMaturity(6.24); sf.checkInfo()" ng-class="sf.bM2"> Level 1 upper </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionMaturity(4.68); sf.checkInfo()" ng-class="sf.bM3"> Level 2 </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionMaturity(3.12); sf.checkInfo()" ng-class="sf.bM4"> Level 3 </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionMaturity(1.56); sf.checkInfo()" ng-class="sf.bM5"> Level 4 </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="sf.optionMaturity(0.0); sf.checkInfo()"  ng-class="sf.bM6"> Level 5 </button ></td>

            </tr>
        </tbody>
    </table>

    <div >
        <a class="button is-medium " style="margin-left: 50%" ng-disabled="sf.enabledButton" ng-click="sf.uploadScaleFactors()"> Save </a>
        <a class="button is-medium " style="margin-left: 90%" > Next </a>
    </div>


    <div class="modal has-text-centered has-addons-centered" ng-class="sf.successModalClass">
        <div class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head">
                <p class="modal-card-title">Multiplicadores</p>
                <button class="delete" aria-label="close" ng-click="sf.closeSuccessModal()"></button>
            </header>
            <section class="modal-card-body">
                <p class=" has-text-centered">Se guardaron existosamento los multiplicadores</p>
            </section>
            <footer class="modal-card-foot has-text-centered" style="margin-top: 2%">
                <a class="button is-success  is-centered" style="margin-left: auto; margin-right: auto" href="/listProjects/">Ir a Proyectos</a>
            </footer>
        </div>
    </div>

    <div class="modal" ng-class="em.errorModalClass">
        <div class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head ">
                <p class="modal-card-title">Error en el Sistema :No se guardaron los multiplicadores</p>
                <button class="delete" aria-label="close" ng-click="sf.closeErrorModal()"></button>
            </header>
            <section class="modal-card-body">
                <p class="is-danger has-text-centered">Hubo un error en el sistema por favor tratar mas tarde</p>
            </section>
            <footer class="modal-card-foot">
                <button class="button is-danger" style="margin-left: auto; margin-right: auto" ng-click="sf.closeErrorModal()">Cancelar</button>
            </footer>
        </div>
    </div>

</div>


</body>
</html>