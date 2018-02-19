import Controller.PostTest1
import Util.LocalDateSerializer
import Util.LocalDateTimeSerializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.apache.log4j.BasicConfigurator
import spark.Service
import spark.Spark
import spark.ModelAndView
import spark.template.freemarker.FreeMarkerEngine
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.HashMap

val gson: Gson = GsonBuilder()
        .registerTypeAdapter(LocalDate::class.java, LocalDateSerializer())
        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeSerializer())
        .create()

fun main(args: Array<String>) {
    BasicConfigurator.configure()

    Service.ignite().apply {
        Spark.port(8050)
        Spark.staticFileLocation("/public")

        //Intializing the path
        Spark.get("/", { _, _ ->
            val model = HashMap<String, Any>()
            model.put("message", "Hello Devs")
            ModelAndView(model, "hello.ftl") // located in src/test/resources/spark/template/freemarker
        }, FreeMarkerEngine())


        //Intializing paths
        Spark.post("/postinfo",PostTest1)

    }
}