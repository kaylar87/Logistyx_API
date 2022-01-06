package com.logistyx.TEST;

import com.logistyx.pojo.bring.parcel.BringParcelPojo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.*;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class Test {

    public String requestJsonBodyShipments;
    public RequestSpecification requestSpecShipments;
    public ResponseSpecification responseSpecShipments;
    public ValidatableResponse validateResponseShipments;
    public BringParcelPojo bringParcelPojoShipments;
    public String encodedStringFromPostmanShipments;
    public String decodedStringShipments;
    public byte[] decodedBytesShipments;

    @BeforeAll
    public static void init() {
        baseURI = "https://as-cdt-dev-logistyx-qa1-docs.azurewebsites.net";
    }


    @org.junit.jupiter.api.Test
    public void test1() {
        requestJsonBodyShipments = "{\n" +
                "    \"ShipperCode\": \"CEVA\",\n" +
                "    \"ProjectCode\": \"THESTAND\",\n" +
                "    \"ShippingFlowCode\": \"OUTBOUND\",\n" +
                "    \"ForwarderDivisionCode\": \"BNP\",\n" +
                "    \"ForwarderServiceCode\": \"BNP-BUS-PRCL\",\n" +
                "    \"ShipperRef\": \"s.ShipperRef\",\n" +
                "    \"Addresses\": [\n" +
                "        {\n" +
                "            \"Reference\": \"CEVA pickups\",\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"Earl Bakkenstraat 7\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"6422 PJ\",\n" +
                "            \"LocalityName\": \"HEERLEN\",\n" +
                "            \"CountryCode\": \"NL\",\n" +
                "            \"Remark\": \"Pickup location / CEVA\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"Name\": \"Randall Flagg\",\n" +
                "                    \"EmailAddress\": \"r.flagg@thestand.com\",\n" +
                "                    \"PhoneNumber\": \"31688877766\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"ForwarderDivisionAccounts\": [\n" +
                "                {\n" +
                "                    \"ForwarderDivisionCode\": \"BNP\",\n" +
                "                    \"AccountCode\": \"01053548\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"AddressTypes\": [\n" +
                "                {\n" +
                "                    \"AddressTypeCode\": \"PICKUP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"AddressTypes\": [\n" +
                "                {\n" +
                "                    \"AddressTypeCode\": \"DELIVERY\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Reference\": \"DY.REFERENCE\",\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"Grand Hotel Oslo\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Index\": 2,\n" +
                "                    \"Value\": \"Karl Johans gate 31\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"0159\",\n" +
                "            \"LocalityName\": \"OSLO\",\n" +
                "            \"CountryCode\": \"NO\",\n" +
                "            \"Remark\": \"DY.Remark\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"Name\": \"DY.Contact Name\",\n" +
                "                    \"EmailAddress\": \"delivery@email.com\",\n" +
                "                    \"PhoneNumber\": \"+(06)2-222222\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Value\": 10,\n" +
                "    \"InsuranceValue\": 10,\n" +
                "    \"CustomsValue\": 10,\n" +
                "    \"IncotermCode\": \"DAP\",\n" +
                "    \"Volume\": 13.36,\n" +
                "    \"VolumeUnitOfMeasure\": \"CMQ\",\n" +
                "\n" +
                "    \"Info\": \"S.Info\",\n" +
                "    \"RequestedPickupDateTime\": \"2020-10-06T11:32:15Z\",\n" +
                "    \"ShippingUnits\": [\n" +
                "        {\n" +
                "            \"ShipperRef\": \"SU.ShipperRef\",\n" +
                "            \"ReceiverRef\": \"SU.ReceiverRef\",\n" +
                "            \"Length\": 33,\n" +
                "            \"Width\": 27,\n" +
                "            \"Height\": 15,\n" +
                "            \"DimensionsUnitOfMeasure\": \"CMT\",\n" +
                "            \"Volume\": 13360,\n" +
                "            \"VolumeUnitOfMeasure\": \"QCM\",\n" +
                "            \"PackageType\": \"PD\",\n" +
                "            \"GrossWeight\": 2,\n" +
                "            \"GrossWeightUnitOfMeasure\": \"KGM\",\n" +
                "            \"Content\": \"001010000000008853\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ShipperRef\": \"SU.ShipperRef\",\n" +
                "            \"ReceiverRef\": \"SU.ReceiverRef\",\n" +
                "            \"Length\": 33,\n" +
                "            \"Width\": 27,\n" +
                "            \"Height\": 15,\n" +
                "            \"DimensionsUnitOfMeasure\": \"CMT\",\n" +
                "            \"Volume\": 13360,\n" +
                "            \"VolumeUnitOfMeasure\": \"QCM\",\n" +
                "            \"PackageType\": \"PD\",\n" +
                "            \"GrossWeight\": 3,\n" +
                "            \"GrossWeightUnitOfMeasure\": \"KGM\",\n" +
                "            \"Content\": \"001010000000008853\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ShipperRef\": \"SU.ShipperRef\",\n" +
                "            \"ReceiverRef\": \"SU.ReceiverRef\",\n" +
                "            \"Length\": 33,\n" +
                "            \"Width\": 27,\n" +
                "            \"Height\": 15,\n" +
                "            \"DimensionsUnitOfMeasure\": \"CMT\",\n" +
                "            \"Volume\": 13360,\n" +
                "            \"VolumeUnitOfMeasure\": \"QCM\",\n" +
                "            \"PackageType\": \"PD\",\n" +
                "            \"GrossWeight\": 5,\n" +
                "            \"GrossWeightUnitOfMeasure\": \"KGM\",\n" +
                "            \"Content\": \"001010000000008853\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        requestSpecShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments);
        responseSpecShipments = expect().statusCode(200)
                .and()
                .contentType(ContentType.JSON);
        validateResponseShipments = given().spec(requestSpecShipments)
                .when()
                .post("/shipments/label")
                .then()
                .spec(responseSpecShipments);
        bringParcelPojoShipments = validateResponseShipments.extract().as(BringParcelPojo.class);
        encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        decodedStringShipments = new String(decodedBytesShipments);

        int totalWeight = 0;
        JsonPath jsonPath = validateResponseShipments.extract().jsonPath();
        List<Float> grossWeight = jsonPath.get("ShippingUnits.GrossWeight");
        System.out.println("grossWeight = " + grossWeight);
        for (int i = 0; i < grossWeight.size(); i++) {
            totalWeight = (int) (totalWeight + grossWeight.get(i));
        }
        System.out.println("totalWeight = " + totalWeight);

        }
    }


