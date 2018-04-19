package com.tipa.Controller.UserControllers

import com.tipa.configuration
import org.omg.CORBA.Object
import spark.Request
import spark.Response
import spark.Spark
import java.io.StringWriter
import java.util.HashMap
class UserRenderController {
    companion object {
        fun renderCreateUserView(req: Request, resp: Response): String {
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/User/createUser.ftl")
            formTemplate.process( HashMap<String, Any>(), writer)
            return writer.toString()
        }

        fun renderLoginUserView(req: Request, resp: Response): String {
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/Login/login.ftl")
            formTemplate.process(null, writer)
            return writer.toString()
        }

        fun renderUserNotFoundView(req:Request,resp:Response):String{
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/Login/noUserFound.ftl")
            formTemplate.process( null, writer)
            return writer.toString();
        }

        fun renderWrongCredentialsView(req:Request,resp: Response):String{
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/Login/wrongCredentials.ftl")
            formTemplate.process( null, writer)
            return writer.toString();
        }

        fun renderUserInformation(req:Request,resp: Response):String{
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/User/userInfo.ftl")
            formTemplate.process( null, writer)
            return writer.toString();
        }
    }
}