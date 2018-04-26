
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/bulma/bulma.css">
    <link rel="stylesheet" href="css/users/login.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    <script src="javascript/angular/angular.min.js"></script>
    <script src="javascript/controller/LoginController.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script>
        $(document).ready(function() {
            document.getElementById("loginUser").onclick = function() {
                document.getElementById("formLogin").submit();
            }
        });

    </script>
</head>
    <body>

    <div class="card-login">
        <form method="POST" action="/login" id="formLogin">
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
                            <input name="usernameTIPA" name="usernameTIPA" class="input" type="text" placeholder="Email" >
                            <span class="icon is-small is-left">
                                <i class="fas fa-user"></i>
                            </span>
                        </p>
                    </div>
                    <div class="field field-login">
                        <p class="control has-icons-left">
                            <input name="passwordTIPA" id="passwordTIPA" class="input" type="password" placeholder="Password">
                            <span class="icon is-small is-left">
                                <i class="fas fa-lock"></i>
                            </span>
                        </p>
                    </div>
                    <a class="button is-dark login-button" id="loginUser">Login</a><br>
                    <a href="/createuser" class="button is-info login-button">Create User</a>
                </div>
            </div>
        </form>
        </div>
    </body>
</html>