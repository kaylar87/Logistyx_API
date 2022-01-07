package com.logistyx.utilities;

import com.logistyx.pojo.bring.parcel.shipments.BringParcelPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public abstract class BNPBaseVERSION2 {

    public static String requestJsonBodyShipments;
    public static RequestSpecification requestSpecShipments;
    public static ResponseSpecification responseSpecShipments;
    public static ValidatableResponse validateResponseShipments;
    public static BringParcelPojo bringParcelPojoShipments;
    public static String encodedStringFromPostmanShipments;
    public static String decodedStringShipments;
    public static byte[] decodedBytesShipments;

    public static RequestSpecification requestSpecConveyances;
    public static ResponseSpecification responseSpecConveyances;
    public static ValidatableResponse validateResponseConveyances;
    public static BringParcelPojo bringParcelPojoConveyances;
    public static String encodedStringFromPostmanConveyances;
    public static String decodedStringConveyances;
    public static byte[] decodedBytesConveyances;

    public static String month;
    public static String day;
    public static int year;
    public static int century;
    public static int hour;
    public static String minute;
    public static String second;


    @BeforeAll
    public static void init() {
        baseURI = "https://as-cdt-dev-logistyx-qa1-docs.azurewebsites.net";
    }

    @Test
    public static void shipmentsLabel() {

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
                "    \"Weight\": 2,\n" +
                "    \"WeightUnitOfMeasure\": \"KGM\",\n" +
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


        int shipmentIdFromShipmentsRequest = bringParcelPojoShipments.getShipmentId();
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);
        requestSpecConveyances = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(objectShipmentIdFromShipmentsRequest);
        responseSpecConveyances = expect().statusCode(200)
                .and()
                .contentType(ContentType.JSON);
        validateResponseConveyances = given().spec(requestSpecConveyances)
                .when()
                .post("/conveyances/confirm")
                .then()
                .spec(responseSpecConveyances);
        bringParcelPojoConveyances = validateResponseConveyances.extract().as(BringParcelPojo.class);
        encodedStringFromPostmanConveyances = bringParcelPojoConveyances.getDocuments().get(0).getContent();
        decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        decodedStringConveyances = new String(decodedBytesConveyances);

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        month = date1.substring(0, 2);
        day = date1.substring(3, 5);
        year = Integer.parseInt(date1.substring(6, 10));
        century = (year / 100) + 1;
        hour = Integer.parseInt(date1.substring(11, 13)) + 5;
        minute = date1.substring(14, 16);
        second = date1.substring(17, 19);


    }
}



