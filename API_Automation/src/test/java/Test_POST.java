import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class Test_POST {

    @Test
    public void testCase(){
        JSONObject request = new JSONObject();
        request.put("email", "eve.holt@reqres.in");
        request.put("password", "cityslicka");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                body(request.toJSONString()).
        when().
                post("https://reqres.in/api/login").
                then().statusCode(400);
    }
}
