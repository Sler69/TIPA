package com.tipa.Controller

import com.tipa.Util.LoggableRoute
import com.tipa.Util.prepare
import spark.Request
import spark.Response
import java.util.ArrayList
import java.util.HashMap

/**
 * Example of how to return a JSON object
 * This will return this Json Object
 *
  {
    "arrEx": [
        1,
        2,
        3,
        4
    ],
    "stringEx": "This is a message example",
    "intEx": 2,
    "booleanEx": true
  }
*/

object ExampleJSON : LoggableRoute()  {
    override fun handle(request: Request, response: Response): Any {
        val arrInt : MutableCollection<Int> = ArrayList()
        arrInt.add(1)
        arrInt.add(2)
        arrInt.add(3)
        arrInt.add(4)

        val model = HashMap<String, Any>()
        model.put("stringEx", "This is a message example")
        model.put("booleanEx" , true)
        model.put("intEx", 2)
        model.put("arrEx",arrInt)

        return response.prepare(200, model)
    }
}
