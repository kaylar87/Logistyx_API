package com.logistyx.TEST;

import static io.restassured.RestAssured.baseURI;

import com.logistyx.pojo.forwarders.Forwarder;
import com.logistyx.pojo.forwarders.ForwarderDivision;
import com.logistyx.pojo.forwarders.Forwarders;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;


public class Forwarders_Endpoint {

    @BeforeAll
    public static void init() {
        baseURI = "https://as-cdt-dev-logistyx-qa1-bios.azurewebsites.net/";

    }

    @DisplayName("Returns a list of Forwarders including underlying divisions and services")
    @Test
    public void test1() {

        given().accept(ContentType.JSON).when().get("api/v1/forwarders")
                .then().statusCode(200).extract().response().prettyPrint();

    }

    @DisplayName("Forwarders List POJO")
    @Test
    public void get3() {

        Forwarders forwarders = get("api/v1/forwarders").then().statusCode(200).extract().response().as(Forwarders.class);

        List<String> forwarderCode = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List<List<ForwarderDivision>> forwarderDivision = new ArrayList<>();
        List<String> forwarderDivisionCode = new ArrayList<>();
        List<String> forwarderDivisionName = new ArrayList<>();
        List<String> countryCode = new ArrayList<>();
        List<String> forwarderServiceCode = new ArrayList<>();
        List<String> nameForwarderDivisionService = new ArrayList<>();
        List<Object> description = new ArrayList<>();


        List<Forwarder> forwarderList = forwarders.getForwarders();

        for (Forwarder forwarder : forwarderList) {
            forwarderCode.add(forwarder.getForwarderCode());
            name.add(forwarder.getName());
            forwarderDivision.add(forwarder.getForwarderDivisions());

        }

        System.out.println("name = " + name);
        //System.out.println("forwarderList = " + forwarderList);

    }
}

