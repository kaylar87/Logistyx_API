package com.logistyx.utilities.abstractBaseClasses.Weight_Cases_NL_SE_Base;

import com.logistyx.pojo.bring.parcel.NotDG.BringParcelPojo;
import com.logistyx.utilities.interfaces.BNP.BNP_BUS_PRCL.Weight_Cases_NL_NO.BNPJson5;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.math3.util.Precision;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static io.restassured.RestAssured.*;

public abstract class BNPBaseNotDG9 {

    public static String requestJsonBodyShipments;
    public static RequestSpecification requestSpecShipments;
    public static ResponseSpecification responseSpecShipments;
    public static ValidatableResponse validateResponseShipments;
    public static BringParcelPojo bringParcelPojoShipments;
    public static String encodedStringFromPostmanShipments;
    public static String decodedStringShipments;
    public static byte[] decodedBytesShipments;
    public static String upTo15kgIcon;
    public static String mediumWeightIcon;
    public static String heavyWeightIcon;
    public static double weightInKilos;
    public static double volumeInCubicMetre;
    public static String checkString;
    public static int checkDigit;

    public static int totalGrossWeight;
    public static List<Float> grossWeight;
    public static int detectedNumberOfPackages;

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
                "            \"ForwarderDivisionAccounts\": null,\n" +
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
                "            \"Reference\": \"Freys Hotel\",\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"Bryggargatan 12\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"10131\",\n" +
                "            \"LocalityName\": \"STOCKHOLM\",\n" +
                "            \"CountryCode\": \"SE\",\n" +
                "            \"Remark\": \"Delivery/Sweden\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"Name\": \"Carl Gustav King\",\n" +
                "                    \"EmailAddress\": \"stockholm@email.com\",\n" +
                "                    \"PhoneNumber\": \"+46633333333\"\n" +
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
                "    \"Weight\": 62,\n" +
                "    \"WeightUnitOfMeasure\": \"LBR\",\n" +
                "    \"Info\": \"S.Info\",\n" +
                "    \"RequestedPickupDateTime\": \"2022-01-21T15:17:17.147Z\",\n" +
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
                "            \"PackageType\": \"BX\",\n" +
                "            \"GrossWeight\": 62,\n" +
                "            \"GrossWeightUnitOfMeasure\": \"LBR\",\n" +
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

        upTo15kgIcon = "^FO690,601^GFA,358,711,9,:Z64:eJyFkTtOAzEQQGcxWlOsCOUWVkQkDrAlRSRyFI6QMuVEIKWnocxFUvgoLjhAyhQIM55PtBtHyrh5erZnxh64Hj4rvGUU2DRJ4EirRBNhKWcR5lNoiRkeARyqcWw6vkgRRgC3oNziPPcEVkIye6vlzoClrnQYpOdksIFXgaUZv+oEmmMLd0+fC3phS8/OGV10MJTKDhtk8JRTAQSoj2TwzkDpnisYGB4qQ930DL0BmTDdGqqttRmCjiGZSXpmG9V8GOxQYQ966wBqykBDeXL57P7l++dLPt3LyKm3P9R5zE4+soGck8Asq6Ef4FFRrEYmTE20M3FkQmUugJr7NThBFf+O+ldF:486D^FS";
        mediumWeightIcon = "^FO690,601^GFA,346,711,9,:Z64:eJyNkTFOAzEQRf/GYpciCilTRIKCA1BSwR6BZvs9wpYpImFOkCtwlOEmLikp05nZPzORKFbEcvH8POMZ27h2NI8OrzUbHFMxmGDQFBwMMvaEFLACWkLHCS4vkHjihon/ggXPWfgDKQ7UyDZgYx0KdgYFzwaHgJfYupG931TW6GqtuSmtg3QOORl02sYMkrQKTat5DigErT0yJiCvA24DtOQDQZuYAp6Ypf3taBS2sWVmciNTmDFiRjcf4uZL3JyymxPcnOGmhJmvv0Vz5jtouftPM7j7XvU0+v2FBmkGe7vRDGHJ9GH6MLIcczHvtf4QhmF4w/L4BaLZkiY=:F1CF^FS";
        heavyWeightIcon = "^FO677,601^GFA,510,869,11,:Z64:eJxt0j1Ow0AQBeDZbBQjEeEDgGQfgZKKHAVfAImSzttR5jSI0kYcgCNkJSoa5Aq5cDy8mf2JFWEp8ZfxZryzM3R2mTGz7DKvXlziM/WJT+TldouPxw8swZ+NoxvrNY8lcCA7ExVE63KkInBTTWTZ0YZoBRL3tAbbIZPB3UBbJEGEdqNElVivxNuQbaPfiaXQsnKSYri3TvIIvemp1Q3jPZ5YicSNYRd5awNLpkrTIjFT8Tklrg6BSEzdpCsZ5N/I0fCXy/xIUcvvMTojSR9ZZjKK8pEH7CiSF/RpQQc2iY7qwD3TP+yWdCf6RF5yOHHMfJikv7rf/Zx4RBV3MYojq3PFfZ2PxGe2I3j5+A3uhETXTL6a6nioTTk3wooPvmCNVkf2NnXo1RsZB8zGgMpDVM9DuymtaEKPpXteBkQ7iKgOgQyFl6lArokwBNpkdNv0PyzUsdOjkLSG+U1vYcwrPGzD8FdYcE/nLPBwe+JFoKXl9QeoUytL:4EBF^FS";


        switch (bringParcelPojoShipments.getShippingUnits().get(0).getGrossWeightUnitOfMeasure()) {
            case "KG":
            case "KGM":
            case "KGS":
                weightInKilos = bringParcelPojoShipments.getShippingUnits().get(0).getGrossWeight();
                break;
            case "G":
            case "G ":
            case "G  ":
            case "GM":
            case "GM ":
            case "GR ":
            case "GRM":
            case "KG ": // Can't help, DOCS or the component thinks this is grams, no conversion
                weightInKilos = Precision.round(bringParcelPojoShipments.getShippingUnits().get(0).getGrossWeight() * 0.001, 1);
                break;
            case "LB":
            case "LB ":
            case "LBR":
            case "LBS":
                weightInKilos = Precision.round(bringParcelPojoShipments.getShippingUnits().get(0).getGrossWeight() * 0.45359237, 1);
                break;
        }

        switch (bringParcelPojoShipments.getVolumeUnitOfMeasure()) {
            case "MTQ":
                volumeInCubicMetre = Precision.round(bringParcelPojoShipments.getVolume(), 8);
                break;
            case "CMQ":
                volumeInCubicMetre = Precision.round(bringParcelPojoShipments.getVolume() / 1000000, 8);
                break;
        }

        checkString = bringParcelPojoShipments.getShippingUnits().get(0).getForwarderRef().substring(2, 19);
        int evenSum = 0;
        int oddSum = 0;
        if (checkString.length() != 17) {
            throw new IllegalArgumentException("Data length must be 17 to calculate SSCC-18 check digit.");
        } else {
            for (int i = 0; i < checkString.length(); i++) {
                if ((i + 1) % 2 == 0) {
                    evenSum += Integer.parseInt(String.valueOf(checkString.charAt(i)));
                } else {
                    oddSum += Integer.parseInt(String.valueOf(checkString.charAt(i)));
                }
            }
            checkDigit = 10 - ((evenSum + (oddSum * 3)) % 10);
        }


        JsonPath jsonPath = validateResponseShipments.extract().jsonPath();
        grossWeight = jsonPath.get("ShippingUnits.GrossWeight");
        detectedNumberOfPackages = bringParcelPojoShipments.getShippingUnits().size();
        //    System.out.println("grossWeight = " + grossWeight);
        for (int i = 0; i < detectedNumberOfPackages; i++) {
            totalGrossWeight = (int) (totalGrossWeight + grossWeight.get(i));
        }


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