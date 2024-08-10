
package org.example;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class AuthorisationNegativeTest {

    @Test
    public void invalidTokenTest() {
        Response response = given().auth().oauth2("as654").contentType("application/json").get(Consts.URL + Consts.END_POINT_MOVIES);
        System.out.println(response.asString());
        response.then().statusCode(401);
        response.then().body("message", equalTo("Unauthorized."));
    }
}