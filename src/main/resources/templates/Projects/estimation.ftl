<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bulma/bulma.css">>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/javascript/angular/angular.min.js"></script>
</head>
<body>
<div>
    <#include "../Base/header.ftl">
    <div>
        <img src="/images/logoCenter.png" width="10%" align=left>
        <h1 class="title is-1" style="margin-top: 2%"> TIPA: Lista de Proyectos</h1>
        <hr width="90%" align="right" >
    </div>
    <div class="columns">
        <div class="column">
            <div class="card" style="height: 100%">
                <div class="card-content has-text-centered">
                    <span class="icon has-text-black">
                        <i class="fas fa-3x fa-users"></i>
                    </span>
                    <p class="title" style="margin-top: 15%">
                      <strong>  No. Integrantes</strong>
                    </p>
                    <p class="subtitle" style="margin-top: 4%">
                        ${teamSize}
                    </p>
                </div>
            </div>
        </div>
        <div class="column">
            <div class="card" style="height: 100%">
                <div class="card-content has-text-centered">
                    <span class="icon has-text-success">
                        <i class="fas fa-3x fa-dollar-sign"></i>
                    </span>
                    <p class="subtitle" style="margin-top: 15%" >
                        <strong> Precio de Proyecto en Pesos</strong>
                    </p>
                    <p class="subtitle">
                    ${costTeam}
                    </p>
                </div>
            </div>
        </div>
        <div class="column">
            <div class="card" style="height: 100%">
                <div class="card-content has-text-centered">
                    <span class="icon has-text-info">
                        <i class="fas fa-3x fa-calendar-alt"></i>
                    </span>
                    <p class="Title" style="margin-top: 10%">
                        <strong> Tiempo del proyecto </strong>
                    </p>
                    <p class="subtitle">
                        ${timeProject} Meses
                    </p>
                    <p class="subtitle">
                        <strong> Esfuerzo </strong>
                    </p>
                    <p class="subtitle">
                        ${esfuerzo}
                    </p>
                </div>
            </div>
        </div>
        <div class="column">
            <div class="card"style="height: 100%">
                <div class="card-content has-text-centered">
                    <span class="icon has-text-black">
                        <i class="fas fa-3x fa-code"></i>
                    </span>
                    <p class="title" style="margin-top: 4%">
                        Informacion del Proyecto
                    </p>
                    <p class="subtitle">
                        <strong>Nombre del lenguaje</strong>
                    </p>
                    <p class="subtitle is-6">
                        ${languageName}
                    </p>
                    <p class="subtitle">
                        <strong>KSLOCS</strong>
                    </p>
                    <p class="subtitle is-6">
                        ${ksloc}
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>