package com.tipa.Controller.DashboardController

import com.tipa.TipaApp
import com.tipa.Util.LoggableRoute
import com.tipa.configuration
import spark.Request
import spark.Response
import java.io.StringWriter
import java.util.HashMap

class DashboardRenderController{
    companion object {
        fun renderDashboardView(req:Request,resp:Response):Any{
            com.tipa.configuration.setClassForTemplateLoading(TipaApp::class.java, "/");

            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/Dashboard/dashboard.ftl")
            formTemplate.process( HashMap<String, Any>(), writer)
            return writer
        }
    }
}