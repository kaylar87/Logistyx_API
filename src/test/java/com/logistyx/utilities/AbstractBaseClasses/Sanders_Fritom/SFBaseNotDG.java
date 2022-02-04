package com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom;


import com.logistyx.pojo.sanders.fritom.SandersFritomPojo;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.math3.util.Precision;
import org.json.JSONException;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

import static io.restassured.RestAssured.*;

public abstract class SFBaseNotDG {

    public static String requestJsonBodyShipments;
    public static RequestSpecification requestSpecShipments;
    public static ResponseSpecification responseSpecShipments;
    public static ValidatableResponse validateResponseShipments;
    public static SandersFritomPojo sandersFritomPojoShipments;
    public static String encodedStringFromPostmanShipments;
    public static String decodedStringShipments;
    public static byte[] decodedBytesShipments;
    public static String upTo15kgIcon;
    public static String mediumWeightIcon;
    public static String heavyWeightIcon;
    public static double weightInKilos;
    public static double volumeInCubicMetre;
    public static double lengthInMetre;
    public static double widthInMetre;
    public static double heightInMetre;
    public static String checkString;
    public static int checkDigit;

    public static int totalGrossWeight;
    public static List<Float> grossWeight;
    public static int detectedNumberOfPackages;

    public static RequestSpecification requestSpecConveyances;
    public static ResponseSpecification responseSpecConveyances;
    public static ValidatableResponse validateResponseConveyances;
    public static SandersFritomPojo sandersFritomPojoConveyances;
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

    public static org.json.JSONObject jsonDataEDI;
    public static String puCountryFromCountryCodeFromJson;
    public static String dyCountryFromCountryCodeFromJson;
    public static String unitcodeFromJson;
    public static List<String> restrictionFromJsonList;
    public static Map<String, String> restrictionValueFromJsonMap;
    public static Map<String, String> unitcodeValueFromJsonMap;
    public static String date1;
    public static String currentDateTime;
    public static OffsetDateTime dateTimeUTC;


    @BeforeAll
    public static void init() {
        baseURI = "https://as-cdt-dev-logistyx-qa1-docs.azurewebsites.net";
    }

    @Test
    public static void shipmentsLabel() {

        requestJsonBodyShipments = "{\n" +
                "    \"ProjectCode\": null,\n" +
                "    \"ShippingFlowCode\": \"OUTBOUND\",\n" +
                "    \"ForwarderDivisionCode\": \"SFT\",\n" +
                "    \"ForwarderServiceCode\": \"STANDARD\",\n" +
                "    \"ShipperRef\": \"4706850\",\n" +
                "    \"ReceiverRef\": \"RR123456\",\n" +
                "    \"Addresses\": [\n" +
                "        {\n" +
                "            \"Reference\": \"FLE >><<01105\",\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"Weena 10017 TEST\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Index\": 2,\n" +
                "                    \"Value\": \"Delivery address two\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"0001001\",\n" +
                "            \"LocalityName\": \"VITORIA\",\n" +
                "            \"CountryCode\": \"CH\",\n" +
                "            \"Description\": \"Desc><ription\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"Name\": \"Delivery Co<<ntact Name 1\",\n" +
                "                    \"EmailAddress\": \"vaiser@hotmail.com\",\n" +
                "                    \"PhoneNumber\": \"(31)497-532-323\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"AddressTypes\": [\n" +
                "                {\n" +
                "                    \"AddressTypeCode\": \"DELIVERY\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Reference\": \"PUREF0001\",\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"De Grens 27 TEST\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"5921CC\",\n" +
                "            \"LocalityName\": \"Heijen\",\n" +
                "            \"CountryCode\": \"ES\",\n" +
                "            \"Remark\": \"Remark value\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"Name\": \"Pickup Name One\",\n" +
                "                    \"EmailAddress\": \"vaiser@hotmail.com\",\n" +
                "                    \"PhoneNumber\": \"31497532323\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"VatNumber\": \"FR33452645948\",\n" +
                "            \"AddressTypes\": [\n" +
                "                {\n" +
                "                    \"AddressTypeCode\": \"PICKUP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Value\": 200,\n" +
                "    \"ValueCurrencyCode\": \"USD\",\n" +
                "    \"NonDutiable\": false,\n" +
                "    \"IncotermCode\": \"CPT\",\n" +
                "    \"Weight\": 18.18,\n" +
                "    \"WeightUnitOfMeasure\": \"KGM\",\n" +
                "    \"RequestedPickupDateTime\": \"2022-01-26T21:16:17.565Z\",\n" +
                "    \"RequestedPickupWindowBeginDateTime\": \"2022-01-26T21:16:17.565Z\",\n" +
                "    \"RequestedPickupWindowEndDateTime\": \"2022-01-26T21:15:13.000Z\",\n" +
                "    \"RequestedDeliveryDateTime\": \"2022-01-29T21:16:17.565Z\",\n" +
                "    \"ForwarderServiceIndicators\": {\n" +
                "        \"AdditionalServices\": [\n" +
                "            \"PICKUP_ROOF_LOAD\",\n" +
                "            \"PICKUP_HIAB\",\n" +
                "            \"PICKUP_SIDE_LOAD\",\n" +
                "            \"DELIVERY_ROOF_LOAD\"\n" +
                "        ]\n" +
                "    },\n" +
                "    \"ShippingUnits\": [\n" +
                "        {\n" +
                "            \"Index\": 1,\n" +
                "            \"ShipperRef\": \"4706850\",\n" +
                "            \"ReceiverRef\": \"3058986\",\n" +
                "            \"Value\": 1212,\n" +
                "            \"ValueCurrencyCode\": \"EUR\",\n" +
                "            \"Length\": 37,\n" +
                "            \"Width\": 26.5,\n" +
                "            \"Height\": 4,\n" +
                "            \"DimensionsUnitOfMeasure\": \"CM\",\n" +
                "            \"Volume\": 135200.36,\n" +
                "            \"VolumeUnitOfMeasure\": \"CMQ\",\n" +
                "            \"PackageType\": \"PC\",\n" +
                "            \"GrossWeight\": 12.13,\n" +
                "            \"GrossWeightUnitOfMeasure\": \"KG\",\n" +
                "            \"Content\": \"This is the description of the sUnit content value\",\n" +
                "            \"ShippingUnitItems\": [\n" +
                "                {\n" +
                "                    \"Description\": \"This <is <z<>the description\",\n" +
                "                    \"ShipperRef\": \"00401000000000000017\",\n" +
                "                    \"CountryOfOrigin\": \"NL\",\n" +
                "                    \"HarmonisedSystemCode\": \"6604002011\",\n" +
                "                    \"Value\": 12.12,\n" +
                "                    \"ValueCurrencyCode\": \"EUR\",\n" +
                "                    \"Weight\": 12.13,\n" +
                "                    \"WeightUnitOfMeasure\": \"KG\",\n" +
                "                    \"Quantity\": 100,\n" +
                "                    \"QuantityUnitOfMeasure\": \"KG\",\n" +
                "                    \"DangerousGoods\": []\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"NumberOfShippingUnits\": 1\n" +
                "}";


        requestSpecShipments = given().header("Shipper-Code", "VDL-NL")
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
        sandersFritomPojoShipments = validateResponseShipments.extract().as(SandersFritomPojo.class);
        encodedStringFromPostmanShipments = sandersFritomPojoShipments.getDocuments().get(0).getContent();
        decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        decodedStringShipments = new String(decodedBytesShipments);
//
//        upTo15kgIcon = "^FO690,601^GFA,358,711,9,:Z64:eJyFkTtOAzEQQGcxWlOsCOUWVkQkDrAlRSRyFI6QMuVEIKWnocxFUvgoLjhAyhQIM55PtBtHyrh5erZnxh64Hj4rvGUU2DRJ4EirRBNhKWcR5lNoiRkeARyqcWw6vkgRRgC3oNziPPcEVkIye6vlzoClrnQYpOdksIFXgaUZv+oEmmMLd0+fC3phS8/OGV10MJTKDhtk8JRTAQSoj2TwzkDpnisYGB4qQ930DL0BmTDdGqqttRmCjiGZSXpmG9V8GOxQYQ966wBqykBDeXL57P7l++dLPt3LyKm3P9R5zE4+soGck8Asq6Ef4FFRrEYmTE20M3FkQmUugJr7NThBFf+O+ldF:486D^FS";
//        mediumWeightIcon = "^FO690,601^GFA,346,711,9,:Z64:eJyNkTFOAzEQRf/GYpciCilTRIKCA1BSwR6BZvs9wpYpImFOkCtwlOEmLikp05nZPzORKFbEcvH8POMZ27h2NI8OrzUbHFMxmGDQFBwMMvaEFLACWkLHCS4vkHjihon/ggXPWfgDKQ7UyDZgYx0KdgYFzwaHgJfYupG931TW6GqtuSmtg3QOORl02sYMkrQKTat5DigErT0yJiCvA24DtOQDQZuYAp6Ypf3taBS2sWVmciNTmDFiRjcf4uZL3JyymxPcnOGmhJmvv0Vz5jtouftPM7j7XvU0+v2FBmkGe7vRDGHJ9GH6MLIcczHvtf4QhmF4w/L4BaLZkiY=:F1CF^FS";
//        heavyWeightIcon = "^FO677,601^GFA,510,869,11,:Z64:eJxt0j1Ow0AQBeDZbBQjEeEDgGQfgZKKHAVfAImSzttR5jSI0kYcgCNkJSoa5Aq5cDy8mf2JFWEp8ZfxZryzM3R2mTGz7DKvXlziM/WJT+TldouPxw8swZ+NoxvrNY8lcCA7ExVE63KkInBTTWTZ0YZoBRL3tAbbIZPB3UBbJEGEdqNElVivxNuQbaPfiaXQsnKSYri3TvIIvemp1Q3jPZ5YicSNYRd5awNLpkrTIjFT8Tklrg6BSEzdpCsZ5N/I0fCXy/xIUcvvMTojSR9ZZjKK8pEH7CiSF/RpQQc2iY7qwD3TP+yWdCf6RF5yOHHMfJikv7rf/Zx4RBV3MYojq3PFfZ2PxGe2I3j5+A3uhETXTL6a6nioTTk3wooPvmCNVkf2NnXo1RsZB8zGgMpDVM9DuymtaEKPpXteBkQ7iKgOgQyFl6lArokwBNpkdNv0PyzUsdOjkLSG+U1vYcwrPGzD8FdYcE/nLPBwe+JFoKXl9QeoUytL:4EBF^FS";
//
//
        switch (sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeightUnitOfMeasure()) {
            case "KG":
            case "KGM":
            case "KGS":
                weightInKilos = sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeight();
                break;
            case "G":
            case "G ":
            case "G  ":
            case "GM":
            case "GM ":
            case "GR ":
            case "GRM":
            case "KG ": // Can't help, DOCS or the component thinks this is grams, no conversion
                weightInKilos = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeight() * 0.001, 1);
                break;
            case "LB":
            case "LB ":
            case "LBR":
            case "LBS":
                weightInKilos = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeight() * 0.45359237, 1);
                break;
        }

        switch (sandersFritomPojoShipments.getShippingUnits().get(0).getVolumeUnitOfMeasure()) {
            case "MTQ":
                volumeInCubicMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getVolume(), 8);
                break;
            case "CMQ":
                volumeInCubicMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getVolume() / 1000000, 8);
                break;
        }

        switch (sandersFritomPojoShipments.getShippingUnits().get(0).getDimensionsUnitOfMeasure()) {
            case "M":
                lengthInMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getLength(), 2);
                widthInMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getLength(), 2);
                heightInMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getLength(), 2);
                break;
            case "CM":
                lengthInMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getLength() / 100, 2);
                widthInMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getLength() / 100, 2);
                heightInMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getLength() / 100, 2);
                break;
        }
//
//        checkString = bringParcelPojoShipments.getShippingUnits().get(0).getForwarderRef().substring(2, 19);
//        int evenSum = 0;
//        int oddSum = 0;
//        if (checkString.length() != 17) {
//            throw new IllegalArgumentException("Data length must be 17 to calculate SSCC-18 check digit.");
//        } else {
//            for (int i = 0; i < checkString.length(); i++) {
//                if ((i + 1) % 2 == 0) {
//                    evenSum += Integer.parseInt(String.valueOf(checkString.charAt(i)));
//                } else {
//                    oddSum += Integer.parseInt(String.valueOf(checkString.charAt(i)));
//                }
//            }
//            checkDigit = 10 - ((evenSum + (oddSum * 3)) % 10);
//        }
//
//
        JsonPath jsonPath = validateResponseShipments.extract().jsonPath();
        grossWeight = jsonPath.get("ShippingUnits.GrossWeight");
        detectedNumberOfPackages = sandersFritomPojoShipments.getShippingUnits().size();
        //    System.out.println("grossWeight = " + grossWeight);
        for (int i = 0; i < detectedNumberOfPackages; i++) {
            totalGrossWeight = (int) (totalGrossWeight + grossWeight.get(i));
        }


        int shipmentIdFromShipmentsRequest = sandersFritomPojoShipments.getShipmentId();
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);
        requestSpecConveyances = given().header("Shipper-Code", "VDL-NL")
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
        sandersFritomPojoConveyances = validateResponseConveyances.extract().as(SandersFritomPojo.class);
        encodedStringFromPostmanConveyances = sandersFritomPojoConveyances.getDocuments().get(0).getContent();
        decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        decodedStringConveyances = new String(decodedBytesConveyances);

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        date1 = dateFormat.format(date);
        month = date1.substring(0, 2);
        day = date1.substring(3, 5);
        year = Integer.parseInt(date1.substring(6, 10));
        century = (year / 100) + 1;
        hour = Integer.parseInt(date1.substring(11, 13)) + 5;
        minute = date1.substring(14, 16);
        second = date1.substring(17, 19);

        currentDateTime = year + "-" + month + "-" + day + "T" + hour + ":" + minute + ":" + second + "Z";

        try {
            jsonDataEDI = XML.toJSONObject(decodedStringConveyances);
            String jsonString = jsonDataEDI.toString(4);
            //System.out.println(jsonString);
        } catch (JSONException e) {
            System.out.println(e.toString());
        }

        puCountryFromCountryCodeFromJson = sandersFritomPojoShipments.getAddresses().get(1).getCountryCode();
        switch (puCountryFromCountryCodeFromJson) {
            case "NL":
                puCountryFromCountryCodeFromJson = "Netherlands";
                break;
            case "IT":
                puCountryFromCountryCodeFromJson = "Italy";
                break;
            case "AE":
                puCountryFromCountryCodeFromJson = "Arabic Emirates";
                break;
            case "KW":
                puCountryFromCountryCodeFromJson = "Kuwait";
                break;
            case "ES":
                puCountryFromCountryCodeFromJson = "Spain";
                break;
            case "CH":
                puCountryFromCountryCodeFromJson = "Switzerland";
                break;
            case "DE":
                puCountryFromCountryCodeFromJson = "Germany";
                break;
            case "PT":
                puCountryFromCountryCodeFromJson = "Portugal";
                break;

        }

        dyCountryFromCountryCodeFromJson = sandersFritomPojoShipments.getAddresses().get(0).getCountryCode();
        switch (dyCountryFromCountryCodeFromJson) {
            case "NL":
                dyCountryFromCountryCodeFromJson = "Netherlands";
                break;
            case "IT":
                dyCountryFromCountryCodeFromJson = "Italy";
                break;
            case "AE":
                dyCountryFromCountryCodeFromJson = "Arabic Emirates";
                break;
            case "KW":
                dyCountryFromCountryCodeFromJson = "Kuwait";
                break;
            case "ES":
                dyCountryFromCountryCodeFromJson = "Spain";
                break;
            case "CH":
                dyCountryFromCountryCodeFromJson = "Switzerland";
                break;
            case "DE":
                dyCountryFromCountryCodeFromJson = "Germany";
                break;
            case "PT":
                dyCountryFromCountryCodeFromJson = "Portugal";
                break;
        }

        restrictionValueFromJsonMap = new LinkedHashMap<>();
        restrictionFromJsonList = sandersFritomPojoShipments.getForwarderServiceIndicators().getAdditionalServices();
        for (int i = 0; i < restrictionFromJsonList.size(); i++) {
            if (restrictionFromJsonList.get(i).equals("PICKUP_ROOF_LOAD")) {
                restrictionValueFromJsonMap.put("PICKUP_ROOF_LOAD", "Dak");
            } else if (restrictionFromJsonList.get(i).equals("PICKUP_HIAB")) {
                restrictionValueFromJsonMap.put("PICKUP_HIAB", "Kraan");
            } else if (restrictionFromJsonList.get(i).equals("PICKUP_SIDE_LOAD")) {
                restrictionValueFromJsonMap.put("PICKUP_SIDE_LOAD", "Zijkant");
            } else if (restrictionFromJsonList.get(i).equals("DELIVERY_ROOF_LOAD")) {
                restrictionValueFromJsonMap.put("DELIVERY_ROOF_LOAD", "Dak");
            }

        }

        unitcodeValueFromJsonMap = new LinkedHashMap<>();
        unitcodeFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getPackageType();
        switch (unitcodeFromJson) {
            case "PB":
                unitcodeValueFromJsonMap.put("PB", "PAL3");
                break;
            case "AH":
                unitcodeValueFromJsonMap.put("AH", "PAL1");
                break;
            case "DG":
                unitcodeValueFromJsonMap.put("DG", "CHEP BLOK");
                break;
            case "ED":
                unitcodeValueFromJsonMap.put("ED", "IBC");
                break;
            case "EH":
                unitcodeValueFromJsonMap.put("EH", "IBC EURO");
                break;
            case "EE":
                unitcodeValueFromJsonMap.put("EE", "EURO");
                break;
            case "PE":
                unitcodeValueFromJsonMap.put("PB", "PAL2");
                break;
            case "DH":
                unitcodeValueFromJsonMap.put("DH", "CHEP EURO");
                break;
            case "AF":
                unitcodeValueFromJsonMap.put("AF", "DUSS");
                break;
            case "CL":
                unitcodeValueFromJsonMap.put("CL", "COLLI");
                break;
            case "PC":
                unitcodeValueFromJsonMap.put("PC", "PAK");
                break;
            case "PK":
                unitcodeValueFromJsonMap.put("PK", "PAK");
                break;
            case "IG":
                unitcodeValueFromJsonMap.put("IG", "PAK");
                break;
            case "PA":
                unitcodeValueFromJsonMap.put("PA", "PAK");
                break;
            case "BX":
                unitcodeValueFromJsonMap.put("BX", "PAK");
                break;
            case "CT":
                unitcodeValueFromJsonMap.put("CT", "PAK");
                break;
            case "CS":
                unitcodeValueFromJsonMap.put("CS", "PAK");
                break;
        }


        dateTimeUTC = OffsetDateTime.now(ZoneOffset.UTC);
        //    System.out.println(dateTimeUTC);

    }
}