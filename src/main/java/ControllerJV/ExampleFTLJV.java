package ControllerJV;

import com.tipa.Controller.ExampleFTL;
import com.tipa.Util.LoggableRoute;

import com.tipa.Util.SparkUtilKt;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class ExampleFTLJV extends LoggableRoute {
    public static final ExampleFTLJV INSTANCE;
    @Override
    public Object handle(Request request, Response response) throws Exception {
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("message", "Hello Devs");
        return SparkUtilKt.render(response, model, "hello.ftl");
    }

    static {
        ExampleFTLJV var0 = new ExampleFTLJV();
        INSTANCE = var0;
    }
}
