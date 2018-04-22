package com.tipa.Controller.UserControllers

import com.tipa.Util.StringConstants
import spark.Request

class UserSessionInfo{
    //Functions to get Info of the user inside the session

    companion object {
        fun getIdUserSession(req:Request):Int{
            val idUser = req.session().attribute<String>(StringConstants.ID)
            return idUser.toInt()
        }

        fun getUserNameSession(req:Request):String{
            return req.session().attribute(StringConstants.USERNAME);
        }

        fun geteMAIL(req:Request):String{
            return req.session().attribute(StringConstants.EMAIL);
        }
    }
}