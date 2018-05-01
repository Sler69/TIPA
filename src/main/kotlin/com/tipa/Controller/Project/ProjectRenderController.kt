package com.tipa.Controller.Project

import com.tipa.configuration
import spark.Request
import spark.Response
import java.io.StringWriter
import java.util.HashMap

class ProjectRenderController {
    companion object {


        fun renderListProyectView(req: Request,resp: Response):String{
            val writer = StringWriter();
            val formTemplate = configuration.getTemplate("templates/Projects/listProjects.ftl")
            formTemplate.process(null,writer)
            return writer.toString()
        }

        fun renderCreateProyectView(req: Request,resp: Response):String{
            val writer = StringWriter();
            val formTemplate = configuration.getTemplate("templates/Projects/createProject.ftl")
            formTemplate.process(null,writer)
            return writer.toString()
        }



        fun renderEffortMultipliers(req: Request,resp: Response):String{
            val info = req.params(":id")
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/PojectValues/effortMultipliers.ftl")
            val model = HashMap<String,Any>()
            model.put("projectId",info);
            formTemplate.process(model,writer)
            return writer.toString()
        }

        fun renderScaleFactors(req: Request,resp: Response):String{
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/PojectValues/scaleFactors.ftl")
            formTemplate.process(null,writer)
            return writer.toString()
        }

        fun renderFunctionPoints(req: Request,resp: Response):String{
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/PojectValues/functionPoints.ftl")
            formTemplate.process(null,writer)
            return writer.toString()
        }
    }
}