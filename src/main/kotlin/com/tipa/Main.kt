package com.tipa

import com.tipa.Controller.ExampleFTL
import com.tipa.Controller.ExampleJSON
import ControllerJV.ExampleFTLJV
import ControllerJV.ExampleJSONJV
import Util.Database.Database
import com.tipa.Util.LocalDateSerializer
import com.tipa.Util.LocalDateTimeSerializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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

val configuration = Configuration(Version(2, 3, 0))
internal var logger = LoggerFactory.getLogger(TipaApp::class.java)

class TipaApp {
    companion object : NamedKLogging("NewsApplication")
}
fun main(args: Array<String>) {
    BasicConfigurator.configure()

    configuration.setClassForTemplateLoading(TipaApp::class.java, "/");
    Service.ignite().apply {
        port(8050)
        staticFileLocation("/public")

        before("/*/") { req, res ->
            val session = req.session(true)

            if (false) {
                logger.warn("Secured Area! Login is REQUIRED")
                res.redirect("/login")
                halt(401)
            }
        }

        get("createuser",{_,_->
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/User/createUser.ftl")
            formTemplate.process( HashMap<String, Any>(), writer)
            writer
        })

        get("/", { _, _ ->
            val writer = StringWriter()
            try {
                val formTemplate = configuration.getTemplate("templates/Login/login.ftl")
                formTemplate.process(null, writer)
            } catch (e: Exception) {
                Spark.halt(500)
            }
            writer
        })
        
        get("health", { request: Request?, response: Response? ->
            Database.Builder().execute();
        });

        //Example Paths with their own controllers
        post("jsonEX", ExampleJSON)
        get("ftlEX", ExampleFTL)
        get("ftlJVEX", ExampleFTLJV.INSTANCE)
        post("jsonEXJV", ExampleJSONJV.INSTANCE)

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

        post("dashboard") { request, response ->
            val writer = StringWriter()

            try {
                val resultTemplate = configuration.getTemplate("templates/Example/hello.ftl")

                val map = HashMap<String, Any>()
                map.put("message","HELOOOOOOOOOOO")
                resultTemplate.process(map, writer)
            } catch (e: Exception) {
                Spark.halt(500)
            }

            writer
        }

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
    }
}