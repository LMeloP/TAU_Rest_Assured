package examples;


import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ValidateSchema {

    @Test
    public void testJsonSchema(){

        given()
                .when()
                .get("http://zippopotam.us/us/50309")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchemaFile.json"));

    }
}
