package com.tipa.Controller

import Util.Database.Database
import com.tipa.Util.LoggableRoute
import com.tipa.configuration
import spark.Request
import spark.Response
import java.io.StringWriter
import java.util.HashMap


/**
 * Example on how to return a view with FTL
 */

object ExampleFTL : LoggableRoute()  {
    override fun handle(request: Request, response: Response): Any {
        val model = HashMap<String, Any>()
        model.put("message", "Hello Devs")
         configuration.setClassForTemplateLoading(ExampleFTL::class.java, "/")
        val formTemplate = configuration.getTemplate("templates/Example/hello.ftl")
        val writer = StringWriter()

        formTemplate.process(model, writer);
        return writer
    }
}