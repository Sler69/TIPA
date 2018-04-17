package com.tipa.Controller.UserControllers

import com.tipa.Dao.UserDao
import com.tipa.Dto.UserDTO
import com.tipa.Util.LoggableRoute
import com.tipa.Util.StringConstants
import spark.Request
import spark.Response

object LogoutController : LoggableRoute(){

    override fun handle(request: Request, response: Response): Any {
        request.session().removeAttribute(StringConstants.ID)
        request.session().removeAttribute(StringConstants.AUTH)
        request.session().removeAttribute(StringConstants.EMAIL)
        request.session().removeAttribute(StringConstants.USERNAME)
        return response.redirect("/")
    }
}