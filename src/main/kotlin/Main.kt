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

    }
}