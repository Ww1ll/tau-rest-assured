package examples;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Chapter01Test {

    @Test
    public void requestUSZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills(){
        given()
        .when()
                .get("http://zippopotam.us/us/90210")
        .then()
                .assertThat()
                .body("places[0].'place name'", equalTo("Beverly Hills"))
        ;
    }
}
