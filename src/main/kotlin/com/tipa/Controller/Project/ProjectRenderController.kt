package com.tipa.Controller.Project

import com.tipa.configuration
import org.omg.CORBA.Object
import spark.Request
import spark.Response
import spark.Spark
import java.io.StringWriter
import java.util.HashMap

class ProjectRenderController {
    companion object {

        fun renderScaleFactorsView(req:Request,resp:Response):String{
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/ScaleFactors/scaleFactors.ftl")
            formTemplate.process( null, writer)
            return writer.toString();
        }

        fun renderCreateProjectView(req: Request,resp: Response):String{
            val writer = StringWriter();
            val formTemplate = configuration.getTemplate("templates/Projects/listProjects.ftl")
            formTemplate.process(null,writer)
            return writer.toString()
        }
    }
}