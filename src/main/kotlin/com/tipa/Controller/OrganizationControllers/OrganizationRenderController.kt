package com.tipa.Controller.OrganizationControllers

import com.tipa.configuration
import spark.Request
import spark.Response
import java.io.StringWriter

class OrganizationRenderController {
    companion object {
        fun renderOraganizations(req: Request, resp: Response):String{
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/Organizations/listOrganizations.ftl")
            formTemplate.process( null, writer)
            return writer.toString();
        }

        fun renderCreateOrganization(req: Request, resp: Response):String{
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/Organizations/createOrganization.ftl")
            formTemplate.process( null, writer)
            return writer.toString();
        }    }
}