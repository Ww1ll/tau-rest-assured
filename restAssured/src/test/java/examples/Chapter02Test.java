package examples;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Chapter02Test {

    @Test
    public void requestUsZipCode90210_checkStatusCode_expectHttp200(){

        given()
        .when()
                .get("http://zippopotam.us/us/90210")
        .then()
                .assertThat()
                .statusCode(200)
        ;
    }

    @Test
    public void requestUsZipCode90210_checkContentTyoe_expectedApplicationJson(){
        given()
        .when()
                .get("http://zippopotam.us/us/90210")
        .then()
                .assertThat()
                .contentType(ContentType.JSON)
        ;
    }

    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetails(){
        given()
        .when()
                .get("http://zippopotam.us/us/90210")
        .then()
                .log().body()
        ;
    }
    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills(){
        given()
        .when()
                .get("http://zippopotam.us/us/90210")
        .then()
                .assertThat()
                .body("places[0].'place name'", equalTo("Beverly Hills"))
        ;
    }

    @Test
    public void requestUsZipCode90210_checkStateNameInResponseBody_expectCalifornia(){
        given()
        .when()
                .get("http://zippopotam.us/us/90210")
        .then()
                .assertThat()
                .body("places[0].state", equalTo("California"))
        ;
    }
    @Test
    public void requestUsZipCode90210_checkListOfPlaceNameInResponseBody_expectContainsBeverlyHills(){
        given()
        .when()
                .get("http://zippopotam.us/us/90210")
        .then()
                .assertThat()
                .body("places.'place name'", hasItem("Beverly Hills"))
        ;
    }
    @Test
    public void requestUsZipCode90210_checkNumberOfPlaceNamesInResponseBody_expectOne(){
        given()
        .when()
                .get("http://zippopotam.us/us/90210")
        .then()
                .assertThat()
                // verifica o tamanho de uma coleção(exemplo: lista)
                .body("places.'place name'", hasSize(1))
        ;
    }

}
