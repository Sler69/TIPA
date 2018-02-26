import Controller.ExampleFTL
import Controller.ExampleJSON
import ControllerJV.ExampleFTLJV
import ControllerJV.ExampleJSONJV
import Util.LocalDateSerializer
import Util.LocalDateTimeSerializer
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
import java.io.StringWriter



val gson: Gson = GsonBuilder()
        .registerTypeAdapter(LocalDate::class.java, LocalDateSerializer())
        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeSerializer())
        .create()
val configuration = Configuration(Version(2, 3, 0))

object TipaApp {
    @JvmStatic fun main(args: Array<String>) {
        BasicConfigurator.configure()

        configuration.setClassForTemplateLoading(TipaApp::class.java, "/");
        Service.ignite().apply {
            port(8050)
            staticFileLocation("/public")

            //Intializing without using their own controller
            get("/", { _, _ ->
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

            get("login", { _, _ ->
                val writer = StringWriter()
                try {
                    val formTemplate = configuration.getTemplate("templates/Login/login.ftl")
                    formTemplate.process(null, writer)
                } catch (e: Exception) {
                    Spark.halt(500)
                }
                writer
            })

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
            }
        }
    }
}