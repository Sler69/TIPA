package com.tipa

import com.tipa.Controller.ExampleFTL
import com.tipa.Controller.ExampleJSON
import ControllerJV.ExampleFTLJV
import ControllerJV.ExampleJSONJV
import com.tipa.Util.LocalDateSerializer
import com.tipa.Util.LocalDateTimeSerializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tipa.Controller.DashboardController.DashboardRenderController
import com.tipa.Controller.Project.ProjectRenderController
import com.tipa.Controller.UserControllers.LoginController
import com.tipa.Controller.UserControllers.SaveUserController
import com.tipa.Controller.UserControllers.UserRenderController
import com.tipa.Controller.UserControllers.UserVerificationController
import com.tipa.Controller.OrganizationControllers.OrganizationRenderController
import com.tipa.Controller.UserControllers.*
import com.tipa.Util.StringConstants
import org.apache.log4j.BasicConfigurator
import spark.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.HashMap
import spark.Spark
import freemarker.template.Configuration
import freemarker.template.Version
import mu.NamedKLogging
import org.slf4j.LoggerFactory
import spark.Request
import spark.Response
import java.io.StringWriter



val gson: Gson = GsonBuilder()
        .registerTypeAdapter(LocalDate::class.java, LocalDateSerializer())
        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeSerializer())
        .create()

internal var configuration = Configuration(Version(2, 3, 0))
internal var logger = LoggerFactory.getLogger(TipaApp::class.java)

class TipaApp {
    companion object : NamedKLogging("NewsApplication")
}
fun main(args: Array<String>) {
    BasicConfigurator.configure()

    configuration.setClassForTemplateLoading(TipaApp::class.java, "/");
    Service.ignite().apply {

        //-------------------Configuration---------------
        port(8050)
        staticFileLocation("/public")
        //-------------------Paths-----------------------

        //------------Check Session------------------
        before("/*/") { req, res ->
            val idUser = req.session().attribute<String>(StringConstants.ID);
            logger.warn("The id user in the session is: $idUser")

            //Comment out this if block if you want to test out things without a session
            if (idUser == null) {
                logger.warn("Secured Area! Login is REQUIRED")
                res.redirect("/")
                halt(401)
            }
        }

        //---------------------GET Paths-----------------
        //RenderViews
        get("/", { request:Request,response:Response -> UserRenderController.renderLoginUserView(request,response)})
        get("createuser",{request: Request, response:Response-> UserRenderController.renderCreateUserView(request,response) })
        get("nouserfound",{request: Request, response:Response-> UserRenderController.renderUserNotFoundView(request,response) })
        get("wrongcredentials",{request: Request, response:Response-> UserRenderController.renderWrongCredentialsView(request,response) })
        get("dashboard/",{request: Request, response: Response -> DashboardRenderController.renderDashboardView(request,response) })
        get("userinfo/",{request:Request,response:Response -> UserRenderController.renderUserInformation(request,response)})
        get("organizations/",{request: Request, response: Response -> OrganizationRenderController.renderOraganizations(request,response) })
        get("createorganization/",{request: Request, response: Response -> OrganizationRenderController.renderCreateOrganization(request,response) })

        get("scalefactors", {request:Request,response:Response -> ProjectRenderController.renderScaleFactorsView(request,response) })
        get("effortmultipliers",{request: Request, response: Response -> ProjectRenderController.renderEffortMultipliers(request,response) })


        //Data driven functions
        post("lol",{request: Request, response: Response -> UserVerificationController.findEmail(response,request) })

        //Logic Controllers for users
        post("saveuser", SaveUserController)
        post("login",LoginController)
        get("logout/", LogoutController)

        //Tryout PATHS!!
        get("/hellodevs", { _, _ ->
            val writer = StringWriter()
            try {
                val formTemplate = configuration.getTemplate("templates/Example/hello.ftl")
                val map = HashMap<String, Any>()
                map.put("message","Hello DEVS")
                formTemplate.process(map, writer)
            } catch (e: Exception) {
                Spark.halt(500)
            }
            writer
        })

        get("duda") { request, response ->
            val writer = StringWriter()
            try {
                val formTemplate = configuration.getTemplate("templates/Example/form.ftl")

                formTemplate.process(null, writer)
            } catch (e: Exception) {
                Spark.halt(500)
            }
            writer
        }

        post("sait") { request, response ->
            val writer = StringWriter()
            if(false) {
                try {
                    val name = if (request.queryParams("name") != null) request.queryParams("name") else "anonymous"
                    val email = if (request.queryParams("email") != null) request.queryParams("email") else "unknown"

                    val resultTemplate = configuration.getTemplate("templates/Example/result.ftl")

                    val map = HashMap<String, Any>()
                    map["name"] = name
                    map["email"] = email

                    resultTemplate.process(map, writer)
                } catch (e: Exception) {
                    Spark.halt(500)
                }

                writer
            }else{
                response.redirect("login",404);
            }
        }

        post("jsonEX", ExampleJSON)
        get("ftlEX", ExampleFTL)
        get("ftlJVEX", ExampleFTLJV.INSTANCE)
        post("jsonEXJV", ExampleJSONJV.INSTANCE)

    }
}