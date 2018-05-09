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
import com.tipa.Controller.OrganizationControllers.OrganizationLogicController
import com.tipa.Controller.Project.ProjectRenderController
import com.tipa.Controller.UserControllers.LoginController
import com.tipa.Controller.UserControllers.SaveUserController
import com.tipa.Controller.UserControllers.UserRenderController
import com.tipa.Controller.UserControllers.UserVerificationController
import com.tipa.Controller.OrganizationControllers.OrganizationRenderController
import com.tipa.Controller.Project.ProjectLogicController
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
            val idUser = req.session().attribute<String>(StringConstants.ID)

             if(idUser == null) {
                logger.warn("Secured Area! Login is REQUIRED")
                res.redirect("/")
                halt(401)
            }
        }

        before("/*/*"){
            req, res ->
            val idUser = req.session().attribute<String>(StringConstants.ID)

            if(idUser == null) {
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
        get("listProjects/",{request:Request,response:Response ->ProjectRenderController.renderListProyectView(request,response)})
        get("/createProject/",{request: Request, response: Response -> ProjectRenderController.renderCreateProyectView(request,response) })


        get("getLstProjects/",{request: Request, response: Response ->  ProjectLogicController.getProjectsForUser(request,response)})
        
        //Data driven functions
        post("/findEmail",{request: Request, response: Response -> UserVerificationController.findEmail(response,request) })
        get("/getOrganizations/",{request: Request, response: Response -> OrganizationLogicController.getOrganizations(request,response) })
        get("/projectBasicInfo/",{request: Request, response: Response -> ProjectLogicController.getBaseProyectInfo(request,response) })
        get("/scaleFactors/:id",{request: Request, response: Response -> ProjectRenderController.renderScaleFactors(request,response) })
        get("/effortMultipliers/:id",{request: Request, response: Response -> ProjectRenderController.renderEffortMultipliers(request,response) })
        get("/calculateFunPnts/:id",{request: Request, response: Response -> ProjectRenderController.renderFunctionPoints(request,response)  })
        get("/estimation/:id",{request: Request, response: Response -> ProjectRenderController.getEstimation(request,response) })

        //Logic Controllers for users
        post("saveuser", SaveUserController)
        post("login",LoginController)
        post("/saveOrganization/",{request: Request, response: Response -> OrganizationLogicController.createOrganization(request,response) })
        post("updateOrganization/",{request: Request, response: Response -> OrganizationLogicController.updateOrganization(request,response)  })
        post("/createProject/",{request: Request, response: Response -> ProjectLogicController.saveProject(request,response) })
        post("/saveEffortMultipliers/",{request: Request, response: Response -> ProjectLogicController.saveEfforMultipliers(request,response)  })
        post("/saveScaleFactors/",{request: Request, response: Response ->  ProjectLogicController.saveScaleFactors(request,response)})
        post("/functionPointsProject/",{request: Request, response: Response -> ProjectLogicController.getFunctionPoints(request,response)  })
        post("/saveFunctionPoints/",{request: Request, response: Response -> ProjectLogicController.saveFunctionPoints(request,response)  })


        get("logout/", LogoutController)


        //Example of Jsons
        post("jsonEX", ExampleJSON)
        get("ftlEX", ExampleFTL)
        get("ftlJVEX", ExampleFTLJV.INSTANCE)
        post("jsonEXJV", ExampleJSONJV.INSTANCE)

    }
}