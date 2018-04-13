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
    </br>
    <section class="hero is-dark">
        <div class="hero-body">
            <div class="container">
                <h1 class="title">
                    Bienvenido Usuario!
                </h1>
                <h2 class="subtitle">
                    Username
                </h2>
            </div>
        </div>
    </section>
    <div class="card-form">
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