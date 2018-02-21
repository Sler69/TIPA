package Controller

import Util.LoggableRoute
import Util.render
import spark.Request
import spark.Response
import java.util.HashMap

/**
 * Example on how to return a view with FTL
 */

object ExampleFTL : LoggableRoute()  {
    override fun handle(request: Request, response: Response): Any {
        val model = HashMap<String, Any>()
        model.put("message", "Hello Devs")
        return response.render(model,"hello.ftl");
    }
}