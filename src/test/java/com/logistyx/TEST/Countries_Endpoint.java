package com.logistyx.TEST;

import static io.restassured.RestAssured.baseURI;

import com.logistyx.pojo.countries.Countries;
import com.logistyx.pojo.countries.Country;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class Countries_Endpoint {

    @BeforeAll
    public static void init(){
        baseURI = "https://as-cdt-dev-logistyx-qa1-bios.azurewebsites.net/";


    }

    @DisplayName("1.0: Returns the country by Country Code: Sweden")
    @Test
    public void test1(){

        given().accept(ContentType.JSON).when().get("api/v1/countries/SE")
                .then().statusCode(200).extract().response().prettyPrint();

        Response response = given().accept(ContentType.JSON).when().get("api/v1/countries/SE");

        String name = response.path("countries[0].countryName");
        System.out.println("name = " + name);
        assertThat(name, is("Sweden"));

        given().accept(ContentType.JSON).when().get("api/v1/countries/SE")
                .then().statusCode(200)
                .and().assertThat()
                .body("countries[0].countryName", is("Sweden"));

    }

    @DisplayName("1.1: Returns a list of Countries: All")
    @Test
    public void get2(){

        given().accept(ContentType.JSON).when().get("api/v1/countries")
                .then().statusCode(200).extract().response().prettyPrint();

    }


    @DisplayName("Countries List POJO")
    @Test
    public void get3(){

        Countries countries = get("api/v1/countries").then().statusCode(200).extract().response().as(Countries.class);

        List<String> countryCodes = new ArrayList<>();
        List<String> countryNames = new ArrayList<>();
        List<String> phoneCodes = new ArrayList<>();
        List<String> continentCode = new ArrayList<>();
        List<String> currencyCode = new ArrayList<>();

        List<Country> countryList = countries.getCountries();

        for (Country country : countryList){
            countryCodes.add(country.getCountryCode());
            countryNames.add(country.getCountryName());
            phoneCodes.add(country.getPhoneCode());
            continentCode.add(country.getContinentCode());
            currencyCode.add(country.getCurrencyCode());

        }
        System.out.println("countryCodes = " + countryCodes);
        System.out.println("countryNames = " + countryNames);
        System.out.println("phoneCodes = " + phoneCodes);
        System.out.println("continentCode = " + continentCode);
        System.out.println("currencyCode = " + currencyCode);

    }

}
