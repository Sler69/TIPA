<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/bulma/bulma.css">
    <link rel="stylesheet" href="css/Tables/buttons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="javascript/angular/angular.min.js"></script>
    <script src="javascript/controller/ScaleFactorsController.js"></script>

</head>
<body>

<div>
    <img src="images/logoCenter.png" width="10%" align=left>
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
                    <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.optionPrecedents(1)" ng-class="sf.bP1"> Thoroughly unprecedent</button></td>
                    <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.optionPrecedents(2)" ng-class="sf.bP2" > Largely unprecedent </button></td>
                    <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.optionPrecedents(3)" ng-class="sf.bP3"> Somewhat unprecedent </button ></td>
                    <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.optionPrecedents(4)" ng-class="sf.bP4"> Generaly familiar </button ></td>
                    <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.optionPrecedents(5)" ng-class="sf.bP5"> Largely familiar</button ></td>
                    <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.optionPrecedents(6)" ng-class="sf.bP6"> Thoroughly familiar </button ></td>

            </tr>
            <tr>
                <th style="text-align: center"> <p>Development</p> <p>Flexibility</p> </th>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" ng-click="sf.optionDevelp()" > Rigorous </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" ng-click="sf.optionDevelp()" > Occasional relaxation  </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" ng-click="sf.optionDevelp()" > Some relaxation </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" ng-click="sf.optionDevelp()" > Generaly Conformity </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" ng-click="sf.optionDevelp()" > Some conformity</button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" ng-click="sf.optionDevelp()" > General goals </button ></td>
            </tr>
            <tr>
                <th style="text-align: center"> <p>Architecture /</p> <p>Risk Resolution</p> </th>
                <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.option()" > 20% </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.option()" > 40% </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.option()" > 60% </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.option()" > 75% </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.option()" > 90% </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.option()" > 100% </button ></td>
            </tr>
            <tr>
                <th style="text-align: center"> Team cohesion </th>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" ng-click="sf.option()" > Very difficult </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" ng-click="sf.option()" > Some difficult </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" ng-click="sf.option()" > Basically cooperative </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" ng-click="sf.option()" > Largely cooperative </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" ng-click="sf.option()" > Highly Cooperative </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style-2" ng-click="sf.option()" > Seamless interaction </button ></td>
            </tr>
            <tr>
                <th style="text-align: center"> <p>Equivalent </p> <p>Process Maturity </p> </th>
                <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.option()" > Level 1 low </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.option()" > Level 1 upper </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.option()" > Level 2 </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.option()" > Level 3 </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.option()" > Level 4 </button ></td>
                <td style="text-align: center"> <button class="button is-small buttom-style" ng-click="sf.option()" ng-click="sf.option()" ng-click="sf.option()" > Level 5 </button ></td>

            </tr>
        </tbody>
    </table>

    <div >
        <button class="button is-medium " style="margin-left: 90%" > Next </button>
    </div>
</div>


</body>
</html>