package Controller

import Util.LoggableRoute
import Util.prepare
import spark.Request
import spark.Response

/**
* Example of how to return a JSON object
*/

object ExampleJSON : LoggableRoute()  {
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