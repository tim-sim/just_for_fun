import com.google.gson.Gson;
import spark.ResponseTransformer;

import static spark.Spark.*;

public class SparkApp {
    public static void main(String[] args) {
        port(8080);
        DummyData data = new DummyData();
        Gson gson = new Gson();

        get("/users",
                (req, res) -> data.getUsers(),
                model -> gson.toJson(model));
        get("/users/:id",
                (req, res) -> data.getUserById(Integer.valueOf(req.params(":id"))),
                model -> gson.toJson(model));
    }
}
