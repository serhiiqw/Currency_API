package org.example;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class AllMoviesTests {
    private static Response response;

    @BeforeAll
    public static void setupResponse() {
        response = given().auth().oauth2(Consts.TOKEN).contentType("application/json").get(Consts.URL + Consts.END_POINT_MOVIES);
        System.out.println(response.asString());
    }

    @Test
    public void getAllBooksTestResponseCodeTest() {

        response.then().statusCode(200);
    }


}
