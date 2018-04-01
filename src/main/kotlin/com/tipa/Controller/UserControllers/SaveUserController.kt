package com.tipa.Controller.UserControllers

import com.tipa.Dao.UserDao
import com.tipa.TipaApp
import com.tipa.Util.LoggableRoute
import com.tipa.Util.bodyAs
import com.tipa.Util.prepare
import spark.Request
import spark.Response
import java.util.HashMap

object SaveUserController : LoggableRoute()  {
    override fun handle(request: Request, response: Response): Any {
        val userform = request.bodyAs(UserForm::class.java)

        val model = HashMap<String, Any>()

        TipaApp.logger.warn { "Creating user to Database!" }

        val statusInsert = UserDao.addUser(userform)

        val succesfulInsert = statusInsert == 1

        model.put("statusInsert" , false)

        return response.prepare(200, model)
    }
}
data class UserForm(
        val username: String? = "",
        val firstName: String? = "",
        val secondName:String?  = "",
        val name: String? = "",
        val email: String? = "",
        val password: String? = "",
        val gender:String? = ""
)