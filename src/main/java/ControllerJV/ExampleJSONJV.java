package ControllerJV;

import Util.LoggableRoute;
import Util.SparkUtilKt;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ExampleJSONJV extends LoggableRoute {
    public static final ExampleJSONJV INSTANCE;
    @Override
    public Object handle(Request request, Response response) throws Exception {
        Map<String,Object> model = new HashMap<String, Object>();
        Collection<Integer> arrInt = new ArrayList();
        arrInt.add(1);
        arrInt.add(2);
        arrInt.add(3);
        arrInt.add(4);

        model.put("stringEx", "This is a message example");
        model.put("booleanEx" , true);
        model.put("intEx", 2);
        model.put("arrEx",arrInt);

        model.put("message", "Hello Devs");
        return SparkUtilKt.prepare(response, 200, model);
    }

    static {
        ExampleJSONJV var0 = new ExampleJSONJV();
        INSTANCE = var0;
    }
}
