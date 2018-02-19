package Controller

import Util.LoggableRoute
import Util.bodyAs
import Util.prepare
import spark.Request
import spark.Response



object PostTest1 : LoggableRoute()  {
    override fun handle(request: Request, response: Response): Any {
        val post = ResultInfo(
                name = "Arturo",
                lastName = "Velazquez",
                days = "2"
        )
        return response.prepare(200, post)
    }
}

data class ResultInfo(
    val name: String? = null,
    val lastName: String? = null,
    val days: String? = null
)