
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/bulma/bulma.css">
    <link rel="stylesheet" href="css/icons/icons.css">
    <link rel="stylesheet" href="css/users/login.css">
    <script src="javascript/angular/angular.min.js"></script>
    <script src="javascript/controller/LoginController.js"></script>

</head>
    <body>

    <div class="card-login" ng-app="appLogin" ng-controller="LoginController as login">
        <div class="card">
            <div class="card-image is-1by2">
                    <figure class="image">
                        <img src="images/logoCenter.png" alt="Placeholder image" >
                    </figure>
                </div>
                <div class="card-content">
                    <h1 class="title is-centered" style="margin-left:40%">TIPA</h1>
                    <div class="field field-login">
                        <p class="control has-icons-left ">
                            <input class="input" type="email" placeholder="Email" ng-model="login.userName">
                            <span class="icon is-small is-left">
                                <svg class="icon-avatar field-icon" >

                                </svg>
                            </span>
                        </p>
                    </div>
                    <div class="field field-login">
                        <p class="control has-icons-left">
                            <input class="input" type="password" placeholder="Password" ng-model="login.password">
                            <span class="icon is-small is-left">
                                <i class="icon-cancel field-icon"></i>
                            </span>
                        </p>
                    </div>
                    <a class="button is-dark login-button" ng-click="login.getCredentials()">Login</a><br>
                    <a class="button is-info login-button">Create User</a>
                </div>
            </div>
        </div>
    </body>
</html>