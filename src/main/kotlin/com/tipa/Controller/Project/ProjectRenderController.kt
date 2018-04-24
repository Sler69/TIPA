package com.tipa.Controller.Project

import com.tipa.configuration
import spark.Request
import spark.Response
import java.io.StringWriter
import java.util.HashMap

class ProjectRenderController {
    companion object {

        fun renderScaleFactorsView(req:Request,resp:Response):String{
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/PojectValues/scaleFactors.ftl")
            val hasshecito = HashMap<String,Any>()
            hasshecito.put("message","HOLA MARINA2!!!!!!!")
            formTemplate.process( hasshecito, writer)
            return writer.toString();
        }

        fun renderEffortMultipliers(req:Request,resp:Response):String{
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/PojectValues/effortMultipliers.ftl")
            formTemplate.process(null,writer)
            return writer.toString()
        }
    }
}