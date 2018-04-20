

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bulma/bulma.css">
    <link rel="stylesheet" href="/css/icons/icons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/javascript/angular/angular.min.js"></script>
</head>
<body>
<div>
    <#include "../Base/header.ftl">
    <div>
        <img src="/images/logoCenter.png" width="10%" align=left>
        <h1 class="title is-1" style="margin-top: 2%"> TIPA: Lista de Organizaciones</h1>
        <hr width="90%" align="right" >
    </div>
    <div class="tile is-ancestor" style="margin-left: -1.75rem;margin-top:-1.75rem;margin-right:-1.75rem;height: 90%;width: 85%">
        <div class="tile is-vertical is-8">
            <div class="tile">
                <div class="tile is-parent is-vertical">
                    <article class="tile is-child notification is-dark">
                        <div class="content">
                            <!-- Content for list -->
                        </div>
                    </article>
                </div>
            </div>
        </div>
        <div class="tile is-parent">
            <article class="tile is-child notification is-white">
                <div class="content">
                    <p class="title">Detalles de la Organizacion</p>
                    <div class="content">
                        <!-- Content for details-->
                    </div>
                </div>
            </article>
        </div>
    </div>
</div>
</body>
