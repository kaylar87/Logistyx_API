package com.logistyx.TEST;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class FtrExemption_Endpoint {

    @BeforeAll
    public static void init(){
        baseURI = "https://as-cdt-dev-logistyx-qa1-bios.azurewebsites.net/";


    }

    @DisplayName("Returns a list of ACTIVE FTR exemptions codes, optionally filtered by code")
    @Test
    public void test1(){

        given().accept(ContentType.JSON).when().get("/api/v1/FtrExemption")
                .then().statusCode(200).extract().response().prettyPrint();


    }


}
