<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/bulma/bulma.css">
    <link rel="stylesheet" href="css/icons/icons.css">
    <link rel="stylesheet" href="css/users/createuser.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="javascript/angular/angular.min.js"></script>
    <script src="javascript/controller/CreateUserController.js"></script>
    <script src="javascript/zxcvbn/zxcvbn.js"></script>
</head>
<body>
<#include "../Base/header.ftl">
<div class="card-form" ng-app="createUser" ng-controller="CreateUserController as createuser">
        <div class="card">
            <div class="card-image is-1by2">
                <figure class="image is-centered" style="width:30%;margin-left: auto;margin-right: auto">
                    <img src="images/logoCenter.png" alt="Placeholder image" >
                </figure>
            </div>
            <div class="card-content">
                <h1 class="title is-centered" style="margin-left:40%">TIPA</h1>
                <div name="form" ng-show="createuser.hideForm">
                <div class="field is-horizontal">
                    <div class="field-label is-normal">
                        <label class="label">Nombre</label>
                    </div>
                    <div class="field-body">
                        <div class="field">
                            <p class="control is-expanded">
                                <input class="input" type="text" placeholder="Nombre"
                                       ng-model="createuser.name"
                                       ng-change="createuser.checkName()"
                                       ng-blur="createuser.checkForm()">
                            </p>
                            <p class="help is-danger" ng-show="createuser.requiredName">Campo requerido*</p>
                        </div>
                        <div class="field">
                            <p class="control is-expanded">
                                <input class="input " type="text" placeholder="Primer Apellido"
                                       ng-model="createuser.firstName"
                                       ng-change="createuser.checkFirstName()"
                                       ng-blur="createuser.checkForm()">
                            </p>
                            <p class="help is-danger" ng-show="createuser.requiredFirstName">Campo requerido*</p>
                        </div>
                    </div>
                </div>
                <div class="field">
                    <div class="control">
                        <input class="input" type="text" placeholder="Segundo Apellido" ng-model="createuser.secondName">
                    </div>
                </div>
                <div class="field">
                    <label class="label">Usuario</label>
                    <div class="control">
                        <input class="input" type="text" placeholder="Text input"
                               ng-model="createuser.userName"
                               ng-change="createuser.checkUserName()"
                               ng-blur="createuser.checkForm()">
                    </div>
                    <p class="help is-danger" ng-show="createuser.requiredUserName">Campo requerido*</p>
                </div>

                <div class="field">
                    <label class="label">Email</label>
                    <div class="control">
                        <input class="input" type="text" placeholder="Text input"
                               ng-model="createuser.email"
                               ng-class="createuser.userEmailClass"
                               ng-change="createuser.checkEmail()"
                               ng-blur="createuser.checkForm();createuser.removeClass()">
                    </div>
                    <p class="help is-danger" ng-show="createuser.requiredEmail">Campo requerido*</p>
                    <p class="help is-danger" ng-show="createuser.errorEmail">No es un email valido*</p>
                </div>

                <div class="field">
                    <label class="label">Contraseña</label>
                    <div class="control">
                        <input class="input" type="password" placeholder="Text input"
                               ng-model="createuser.password"
                               ng-change="createuser.checkPassword()"
                               ng-blur="createuser.checkForm()">
                    </div>
                    <p class="help is-danger" ng-show="createuser.requiredPassword">Campo requerido*</p>
                </div>
                <div class="strength-meter">
                    <div class="strength-meter-fill" data-strength='{{createuser.passwordStrength}}'></div>
                </div>
                <div class="field">
                    <label class="label">Validar Contraseña</label>
                    <div class="control">
                        <input class="input" type="password" placeholder="Text input"
                               ng-model="createuser.validatePassword"
                               ng-change="createuser.checkMatchPassword();createuser.checkForm()"
                               ng-blur="createuser.checkForm()">
                    </div>
                    <p class="help is-danger" ng-show="createuser.passwordsMatch">Contraseñas no concuerdan</p>
                </div>
                <div class="control">
                    <label class="label">Genero</label>
                    <div class="select">
                        <select ng-model="createuser.gender"
                                ng-change="createuser.checkForm()">
                            <option>Masculino</option>
                            <option>Femenino</option>
                        </select>
                    </div>
                </div>
                <a class="button is-info login-button create-user-button" ng-click="createuser.createUser()" ng-disabled="createuser.enabledButton">Crear usuario</a>
                </div>
                <div ng-show="createuser.succesfullInsert">
                    <h2 class="title has-text-centered">¡Usuario creado exitosamente!</h2>
                    <p class=" is-center">Se ha creado su usuario de forma exitosa por favor ingresar con su mail o usuario con la contraseña que usted escogio.</p>
                    <a class="button is-success login-button is-centered" href="/">Login</a>
                </div>
            </div>
        </div>
    <div class="modal" ng-class="createuser.errorModalClass">
        <div class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head">
                <p class="modal-card-title">Error en el Sistema</p>
                <button class="delete" aria-label="close" ng-click="createuser.closeModal()"></button>
            </header>
            <section class="modal-card-body">
                <p class="is-danger has-text-centered">Hubo un error en el sistema por favor tratar mas tarde</p>
                <a class="button is-danger create-user-button " href="/">Regresar a pagina principal</a>
            </section>
            <footer class="modal-card-foot">
                <button class="button" ng-click="createuser.closeModal()">Cancelar</button>
            </footer>
        </div>
    </div>
</div>
</body>
</html>