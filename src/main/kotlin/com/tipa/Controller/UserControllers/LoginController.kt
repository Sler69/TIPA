package com.tipa.Controller.UserControllers

import com.tipa.Dao.UserDao
import com.tipa.Dto.UserDTO
import com.tipa.Util.IntConstant
import com.tipa.Util.LoggableRoute
import com.tipa.Util.StringConstants

import spark.Request
import spark.Response
import spark.Session
import java.util.HashMap
import java.util.regex.Matcher;
import java.util.regex.Pattern;


object LoginController : LoggableRoute()  {
    override fun handle(request: Request, response: Response): Any {
        val usernameEmail = if (request.queryParams("usernameTIPA") != null) request.queryParams("usernameTIPA") else "anonymous"
        val password = if (request.queryParams("passwordTIPA") != null) request.queryParams("passwordTIPA") else "password"

        var userForSession : List<UserDTO>
        //The user may access his account using the username or email. This verifies what was given to the server email or username
        //We use the correct methods depending on what was given

        if(verifyEmail(usernameEmail)){

            val foundUsername = UserDao.verifyEmail(usernameEmail);
            if(foundUsername){

                userForSession = UserDao.getUserWithEmail(usernameEmail,password)
                if(userForSession.isNotEmpty()){
                    val user = userForSession[0]
                    val session = request.session(true);
                    addUserToSession(user,session);
                    logger.info { "Found the user using his username and correct password: Username ${user.userName} and email ${user.email}" }
                    logger.info { "Added the information of the user to the session" }
                }else{
                    return response.redirect("wrongcredentials")
                }

            }else{
                return response.redirect("nouserfound");
            }
        }else{
            val foundEmail = UserDao.verifyUsername(usernameEmail);
            if(foundEmail){
                userForSession = UserDao.getUserWithUsername(usernameEmail,password)
                if(userForSession.isNotEmpty()){
                    val user = userForSession[0]
                    val session = request.session(true);
                    addUserToSession(user,session);
                    logger.info { "Found the user using his username and correct password: Username ${user.userName} and email ${user.email}" }
                    logger.info { "Added the information of the user to the session" }
                }else{
                    return response.redirect("wrongcredentials")
                }

            }else{
                return response.redirect("nouserfound");
            }
        }

        //We were able to retrieve the user successfully meaning that the password and email/username were correct for the Database.
        return response.redirect("dashboard/")
    }

    fun verifyEmail(email:String):Boolean{
        val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$"
        val pat = Pattern.compile(emailRegex)
        return pat.matcher(email).matches();
    }

    fun addUserToSession(user:UserDTO,session: Session){

        session.maxInactiveInterval(IntConstant.TIMEOUT_TIME)
        session.attribute(StringConstants.USERNAME, user.userName)
        session.attribute(StringConstants.ID, user.id.toString())
        session.attribute(StringConstants.AUTH, true)
        session.attribute(StringConstants.EMAIL, user.email)
    }

}