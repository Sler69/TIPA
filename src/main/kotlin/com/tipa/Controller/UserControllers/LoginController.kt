package com.tipa.Controller.UserControllers

import com.tipa.TipaApp
import com.tipa.Util.LoggableRoute
import com.tipa.Util.bodyAs
import com.tipa.Util.prepare
import spark.Request
import spark.Response
import java.util.HashMap

object LoginController : LoggableRoute()  {
    override fun handle(request: Request, response: Response): Any {
        val username = if (request.queryParams("usernameTIPA") != null) request.queryParams("usernameTIPA") else "anonymous"
        val password = if (request.queryParams("passwordTIPA") != null) request.queryParams("passwordTIPA") else "unknown"


        return response.redirect("dashboard/")
    }
}