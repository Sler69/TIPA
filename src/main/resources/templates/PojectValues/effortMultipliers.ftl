<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bulma/bulma.css">
    <link rel="stylesheet" href="/css/ProjectValues/buttons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/javascript/angular/angular.min.js"></script>
    <script src="/javascript/controller/EffortMultipliers.js"></script>

</head>
<body>
<#include "../Base/header.ftl">
<div>
    <img src="/images/logoCenter.png" width="10%" align=left>
    <h1 class="title is-1"> TIPA </h1>
    <hr width="90%" align="right" >
</div>


<h1 class="title" style="margin-left: 40% "> Effort Multipliers </h1>
<div  ng-app="effortMultipliers" ng-controller="EffortMultipliersController as em">

    <table  class="table  is-striped " style=" margin-top: 50px; alignment: center">
        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th style="text-align: center">Product Factors </th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <tr>
            <th style="text-align: center"> <abbr></abbr></th>
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
            <th style="text-align: center"> <p>Required</p><p>Software Reliability</p></th>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionSoftwareReliability(0.82); em.checkInfo()" ng-class="em.bSR1">  Slight inconvenience </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionSoftwareReliability(0.92); em.checkInfo()" ng-class="em.bSR2" > Easily recoverable losses </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionSoftwareReliability(1.00); em.checkInfo()" ng-class="em.bSR3"> Moderate recoverable losses </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionSoftwareReliability(1.10); em.checkInfo()" ng-class="em.bSR4"> High financial loss</button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionSoftwareReliability(1.26); em.checkInfo()" ng-class="em.bSR5"> Risk to human life </button ></td>
            <td style="text-align: center">n/a</td>

        </tr>
        <tr>
            <th style="text-align: center"> <p>Data</p> <p>cost driver</p> </th>
            <td style="text-align: center">n/a</td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionDataCost(0.90); em.checkInfo()" ng-class="em.bDC1"> Testing DB bytes / Pgm SLOC < 10   </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionDataCost(1.00); em.checkInfo()" ng-class="em.bDC2"> 10 <= D/P <100 </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionDataCost(1.14); em.checkInfo()" ng-class="em.bDC3"> 100 <= D/P <1000 </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionDataCost(1.28); em.checkInfo()" ng-class="em.bDC4">  D/P >= 1000 </button ></td>
            <td style="text-align: center">n/a</td>
        </tr>
        <tr>
            <th style="text-align: center"> <p>Product</p> <p>Complexity</p> </th>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionComplexity(0.73); em.checkInfo()" ng-class="em.bCom1"> 1 </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionComplexity(0.87); em.checkInfo()" ng-class="em.bCom2"> 2 </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionComplexity(1.00); em.checkInfo()" ng-class="em.bCom3"> 3 </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionComplexity(1.17); em.checkInfo()" ng-class="em.bCom4"> 4 </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionComplexity(1.34); em.checkInfo()" ng-class="em.bCom5"> 5 </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionComplexity(1.74); em.checkInfo()"  ng-class="em.bCom6"> 6 </button ></td>
        </tr>
        <tr>
            <th style="text-align: center"> <p>Development</p> <p>for reusability</p> </th>
            <td style="text-align: center">n/a</td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionReusability(0.95); em.checkInfo()" ng-class="em.bRe1"> None </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionReusability(1.00); em.checkInfo()" ng-class="em.bRe2"> Across project </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionReusability(1.07); em.checkInfo()" ng-class="em.bRe3"> Across program </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionReusability(1.15); em.checkInfo()" ng-class="em.bRe4"> Across product line </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionReusability(1.24); em.checkInfo()" ng-class="em.bRe5"> Across multiple product line </button ></td>

        </tr>

        <tr>
            <th style="text-align: center"> <p>Documentation match</p> <p>to Life-Cycle needs</p> </th>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionDocumentation(0.81); em.checkInfo()" ng-class="em.bDoc1"> Many </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionDocumentation(0.91); em.checkInfo()" ng-class="em.bDoc2"> Some </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionDocumentation(1.00); em.checkInfo()" ng-class="em.bDoc3"> Rigth sized  </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionDocumentation(1.11); em.checkInfo()" ng-class="em.bDoc4"> Excessive </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionDocumentation(1.23); em.checkInfo()" ng-class="em.bDoc5"> Very excessive </button ></td>
            <td style="text-align: center">n/a</td>
        </tr>
        </tbody>

        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th style="text-align: center">Platform  Factors </th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <tr>
            <th style="text-align: center"> <abbr></abbr></th>
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
            <th style="text-align: center"> <p>Execution</p><p>Time Constraint</p></th>
            <td style="text-align: center">n/a</td>
            <td style="text-align: center">n/a</td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionExecution(1.00); em.checkInfo()" ng-class="em.bEx1" > 50% </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionExecution(1.11); em.checkInfo()" ng-class="em.bEx2"> 70% </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionExecution(1.29); em.checkInfo()" ng-class="em.bEx3"> 85% </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionExecution(1.63); em.checkInfo()" ng-class="em.bEx4"> 95% </button ></td>

        </tr>
        <tr>
            <th style="text-align: center"> <p>Main</p> <p>storage</p> </th>
            <td style="text-align: center">n/a</td>
            <td style="text-align: center">n/a</td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionStorage(1.00); em.checkInfo()" ng-class="em.bSt1" > 50% </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionStorage(1.05); em.checkInfo()" ng-class="em.bSt2"> 70% </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionStorage(1.17); em.checkInfo()" ng-class="em.bSt3"> 85% </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionStorage(1.46); em.checkInfo()"  ng-class="em.bSt4"> 95% </button ></td>
        </tr>
        <tr>
            <th style="text-align: center"> <p>Plataform</p> <p>volatility</p> </th>
            <td style="text-align: center">n/a</td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionVolatility(0.86); em.checkInfo()" ng-class="em.bVol1" > 1-12months </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionVolatility(1.00); em.checkInfo()" ng-class="em.bVol2"> 2 weeks - 6 months </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionVolatility(1.15); em.checkInfo()" ng-class="em.bVol3"> 1 week - 2 months </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionVolatility(1.30); em.checkInfo()"  ng-class="em.bVol4"> 1 day - 2 weeks </button ></td>
            <td style="text-align: center">n/a</td>
        </tr>
        </tbody>

        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th style="text-align: center">Personnel  Factors </th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <tr>
            <th style="text-align: center"> <abbr></abbr></th>
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
            <th style="text-align: center"> <p>Analyst</p><p>Capability</p></th>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionAnalyst(1.42); em.checkInfo()" ng-class="em.bAn1" > 15th percentile  </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionAnalyst(1.19); em.checkInfo()" ng-class="em.bAn2" > 35th percentile </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionAnalyst(1.00); em.checkInfo()" ng-class="em.bAn3"> 55th percentile </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionAnalyst(0.85); em.checkInfo()" ng-class="em.bAn4"> 75th percentile </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionAnalyst(0.71); em.checkInfo()"  ng-class="em.bAn5"> 90th percentile </button ></td>
            <td style="text-align: center">n/a</td>
        </tr>
        <tr>
            <th style="text-align: center"> <p>Programmer</p> <p>Capability</p> </th>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionProgrammer(1.34); em.checkInfo()" ng-class="em.bProg1" > 15th percentile  </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionProgrammer(1.15); em.checkInfo()" ng-class="em.bProg2" > 35th percentile </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionProgrammer(1.00); em.checkInfo()" ng-class="em.bProg3"> 55th percentile </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionProgrammer(0.88); em.checkInfo()" ng-class="em.bProg4"> 75th percentile </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionProgrammer(0.76); em.checkInfo()"  ng-class="em.bProg5"> 90th percentile </button ></td>
            <td style="text-align: center">n/a</td>
        </tr>
        <tr>
            <th style="text-align: center"> <p>Personnel</p> <p>Continuity</p> </th>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionContinuity(1.29); em.checkInfo()" ng-class="em.bCon1" > 48%/year  </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionContinuity(1.12); em.checkInfo()" ng-class="em.bCon2"> 24%/year </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionContinuity(1.00); em.checkInfo()" ng-class="em.bCon3"> 12%/year </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionContinuity(0.90); em.checkInfo()" ng-class="em.bCon4"> 6%/year </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionContinuity(0.81); em.checkInfo()" ng-class="em.bCon5"> 3%/year </button ></td>
            <td style="text-align: center">n/a</td>
        </tr>
        <tr>
            <th style="text-align: center"> <p>Application</p> <p>Experience</p> </th>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionapplicationExp(1.22); em.checkInfo()" ng-class="em.bAppEx1" > 2 months </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionapplicationExp(1.10); em.checkInfo()" ng-class="em.bAppEx2">  6 months </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionapplicationExp(1.00); em.checkInfo()" ng-class="em.bAppEx3"> 1 year </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionapplicationExp(0.88); em.checkInfo()" ng-class="em.bAppEx4"> 3 years  </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionapplicationExp(0.81); em.checkInfo()" ng-class="em.bAppEx5"> 6 years </button ></td>
            <td style="text-align: center">n/a</td>
        </tr>
        <tr>
            <th style="text-align: center"> <p>Platform </p> <p>Experience</p> </th>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionplatformExp(1.19); em.checkInfo()" ng-class="em.bPlatExp1" > 2 months </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionplatformExp(1.09); em.checkInfo()" ng-class="em.bPlatExp2">  6 months </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionplatformExp(1.00); em.checkInfo()" ng-class="em.bPlatExp3"> 1 year </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionplatformExp(0.91); em.checkInfo()" ng-class="em.bPlatExp4"> 3 years  </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionplatformExp(0.85); em.checkInfo()" ng-class="em.bPlatExp5"> 6 years </button ></td>
            <td style="text-align: center">n/a</td>
        </tr>
        <tr>
            <th style="text-align: center"> <p>Language and Tool</p> <p>Experience</p> </th>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionLanguageExp(1.20); em.checkInfo()" ng-class="em.bLanExp1" > 2 months </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionLanguageExp(1.09); em.checkInfo()" ng-class="em.bLanExp2">  6 months </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionLanguageExp(1.00); em.checkInfo()" ng-class="em.bLanExp3"> 1 year </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionLanguageExp(0.91); em.checkInfo()" ng-class="em.bLanExp4"> 3 years  </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionLanguageExp(0.84); em.checkInfo()" ng-class="em.bLanExp5"> 6 years </button ></td>
            <td style="text-align: center">n/a</td>
        </tr>
        </tbody>
        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th style="text-align: center">Project Factors </th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <tr>
            <th style="text-align: center"> <abbr></abbr></th>
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
            <th style="text-align: center"> <p>Use of</p><p>Software Tools</p></th>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionUseSoftware(1.17); em.checkInfo()" ng-class="em.bUseSP1" > Edit, code, debug </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionUseSoftware(1.09); em.checkInfo()" ng-class="em.bUseSP2" > CASE (front / backend) </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionUseSoftware(1.00); em.checkInfo()" ng-class="em.bUseSP3"> Basic life-cycle tools </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionUseSoftware(0.90); em.checkInfo()" ng-class="em.bUseSP4"> Strong integrated life-cycle tools </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionUseSoftware(0.78); em.checkInfo()" ng-class="em.bUseSP5"> Processes methods reuse </button ></td>
            <td style="text-align: center">n/a</td>
        </tr>
        <tr>
            <th style="text-align: center"> <p>Multisite </p><p>Development </p></th>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionMultisiteDev(1.22); em.checkInfo()" ng-class="em.bMultDev1" > International </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionMultisiteDev(1.09); em.checkInfo()" ng-class="em.bMultDev2" > Multi-city, Multi-company </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionMultisiteDev(1.00); em.checkInfo()" ng-class="em.bMultDev3"> Multi-city, Multi-company </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionMultisiteDev(0.93); em.checkInfo()" ng-class="em.bMultDev4"> Same city or metro area </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionMultisiteDev(0.86); em.checkInfo()" ng-class="em.bMultDev5"> Same Building or complex </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style-2" style="width:90%" ng-click="em.optionMultisiteDev(0.80); em.checkInfo()" ng-class="em.bMultDev6"> Fully Collocated </button ></td>
        </tr>
        <tr>
            <th style="text-align: center"> <p>Required </p><p> Development Schedule </p></th>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionSchedule(1); em.checkInfo()" ng-class="em.bSche1" >  75% of Nominal </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionSchedule(2); em.checkInfo()" ng-class="em.bSche2" > 85% of Nominal </button></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionSchedule(3); em.checkInfo()" ng-class="em.bSche3"> 100% of Nominal </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionSchedule(4); em.checkInfo()" ng-class="em.bSche4"> 130% of Nominal </button ></td>
            <td style="text-align: center"> <button class="button is-small buttom-style" style="width:90%" ng-click="em.optionSchedule(5); em.checkInfo()" ng-class="em.bSche5"> 160% of Nominal </button ></td>
            <td style="text-align: center">n/a</td>
        </tr>
        </tbody>

    </table>

    <div >
        <a class="button is-medium " style="margin-left: 50%" ng-disabled="em.enabledButton" ng-click="em.uploadMultipliers()"> Save </a>
        <a class="button is-medium " style="margin-left: 90%" > Next </a>
    </div>

    <div class="modal has-text-centered has-addons-centered" ng-class="em.successModalClass">
        <div class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head">
                <p class="modal-card-title">Multiplicadores</p>
                <button class="delete" aria-label="close" ng-click="em.closeSuccessModal()"></button>
            </header>
            <section class="modal-card-body">
                <p class=" has-text-centered">Se guardaron existosamento los multiplicadores</p>
            </section>
            <footer class="modal-card-foot has-text-centered" style="margin-top: 2%">
                <a class="button is-success  is-centered" style="margin-left: auto; margin-right: auto" href="/organizations/">Ir a la pagina de organizaciones</a>
            </footer>
        </div>
    </div>

    <div class="modal" ng-class="em.errorModalClass">
        <div class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head ">
                <p class="modal-card-title">Error en el Sistema :No se guardaron los multiplicadores</p>
                <button class="delete" aria-label="close" ng-click="em.closeErrorModal()"></button>
            </header>
            <section class="modal-card-body">
                <p class="is-danger has-text-centered">Hubo un error en el sistema por favor tratar mas tarde</p>
            </section>
            <footer class="modal-card-foot">
                <button class="button is-danger" style="margin-left: auto; margin-right: auto" ng-click="em.closeErrorModal()">Cancelar</button>
            </footer>
        </div>
    </div>

</div>


</body>
</html>