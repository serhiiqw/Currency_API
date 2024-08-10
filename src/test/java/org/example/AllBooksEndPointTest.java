package org.example;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class AllBooksEndPointTest {
    private static Response response;

    @BeforeAll
    public static void setupResponse() {
        response = given().get(Consts.URL + Consts.END_POINT);
        System.out.println(response.asString());
    }

    @Test
    public void getAllBooksTestResponseCodeTest() {

        response.then().statusCode(200);
    }

    @Test
    public void getAllBooksNumOfResultTest() {
        response.then().body("total", notNullValue());
        response.then().body("total", greaterThan(0));
        response.then().body("total", equalTo(3));
    }

    @Test
    public void getAllBooksHasItemsTest() {
        response.then().body("docs._id", notNullValue());
        response.then().body("docs._id", hasItem("5cf5805fb53e011a64671582"));
        response.then().body("docs.name", hasItem("The Fellowship Of The Ring"));
        response.then().body("docs.name", hasItems("The Fellowship Of The Ring", "The Two Towers", "The Return Of The King"));
    }

    @Test
    public void getAllBooksContainsTest(){
        response.then().body("docs.name", containsInAnyOrder("The Fellowship Of The Ring", "The Two Towers", "The Return Of The King"));
    }
}