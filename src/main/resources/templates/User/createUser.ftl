<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/bulma/bulma.css">
    <link rel="stylesheet" href="css/icons/icons.css">
    <link rel="stylesheet" href="css/users/login.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="javascript/angular/angular.min.js"></script>
    <script src="javascript/controller/CreateUserController.js"></script>
</head>
<body>
<div class="card-form" ng-app="createUser" ng-controller="CreateUserController as createuser">
        <div class="card">
            <div class="card-image is-1by2">
                <figure class="image is-centered" style="width:50%;margin-left: auto;margin-right: auto">
                    <img src="images/logoCenter.png" alt="Placeholder image" >
                </figure>
            </div>
            <div class="card-content">
                <h1 class="title is-centered" style="margin-left:40%">TIPA</h1>
                <div class="field is-horizontal">
                    <div class="field-label is-normal">
                        <label class="label">Nombre</label>
                    </div>
                    <div class="field-body">
                        <div class="field">
                            <p class="control is-expanded has-icons-left">
                                <input class="input" type="text" placeholder="Nombre" ng-model="createuser.name">
                            </p>
                        </div>
                        <div class="field">
                            <p class="control is-expanded has-icons-left has-icons-right">
                                <input class="input " type="text" placeholder="Apellido" ng-model="createuser.firstName">
                            </p>
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
                        <input class="input" type="text" placeholder="Text input" ng-model="createuser.userName">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Email</label>
                    <div class="control">
                        <input class="input" type="email" placeholder="Text input" ng-model="createuser.email">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Contraseña</label>
                    <div class="control">
                        <input class="input" type="password" placeholder="Text input" ng-model="createuser.password">
                    </div>
                </div>
                <div class="control">
                    <label class="label">Genero</label>
                    <div class="select">
                        <select>
                            <option>Masculino</option>
                            <option>Femenino</option>
                        </select>
                    </div>
                </div>
                <a class="button is-info login-button" ng-click="createuser.createUser()">Crear usuario</a>
            </div>
        </div>
</div>
</body>
</html>