<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bulma/bulma.css">
    <link rel="stylesheet" href="/css/icons/icons.css">
    <link rel="stylesheet" href="/css/users/userinfo.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/javascript/angular/angular.min.js"></script>
</head>
<body>
<div>
    <#include "../Base/header.ftl">
    <div>
        <img src="/images/logoCenter.png" width="10%" align=left>
        <h1 class="title is-1" style="margin-top: 2%"> TIPA: Bienvenido</h1>
        <hr width="90%" align="right" >
    </div>
    <div class="content" style="width: 50%;margin-left: 2%">
        <h1>Su Información</h1>
        <p>En esta seccion encontrara su informacion personal. Tambien puede actualizarla pero tome en cuenta que los campos de usuario
        y mail se tienen que verificar la disponibilidad de estos.</p>
    </div>
    <div class="card-form" style="width:75%;">
        <div class="card-content">
            <div class="field">
                <label class="label">Nombre</label>
                <div class="control">
                    <input class="input" type="text" placeholder="Text input"/>
                </div>
            </div>
            <div class="field">
                <label class="label">Apellido</label>
                <div class="control">
                    <input class="input" type="text"  placeholder="Text input"/>
                </div>
            </div>
            <div class="field">
                <label class="label">Segundo Apellido</label>
                <div class="control">
                    <input class="input" type="text"  placeholder="Text input"  />
                </div>
            </div>
            <div class="field">
                <label class="label">Username</label>
                <div class="control">
                    <input class="input" type="text" placeholder="Text input"/>
                </div>
            </div>
            <div class="field">
                <label class="label">Email</label>
                <div class="control">
                    <input class="input" type="text" placeholder="Text input"/>
                </div>
            </div>
            <div>
                <a class="button is-info login-button create-user-button">Cambiar Informacion</a>
                <a class="button is-dark ">Cambiar Contraseña</a>
            </div>
        </div>
    </div>
</div>
</body>