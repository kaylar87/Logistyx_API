package com.logistyx.utilities;

import com.logistyx.pojo.fedex.fuse.NotDG.FedExFusePojo;
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

public abstract class FedExFuseBaseNotDG {

    public static String requestJsonBodyShipments;
    public static RequestSpecification requestSpecShipments;
    public static ResponseSpecification responseSpecShipments;
    public static ValidatableResponse validateResponseShipments;
    public static FedExFusePojo fedExFusePojoShipments;
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
    public static String currentDateTime;

    public static int totalGrossWeight;
    public static List<Float> grossWeight;
    public static int detectedNumberOfPackages;

    public static RequestSpecification requestSpecConveyances;
    public static ResponseSpecification responseSpecConveyances;
    public static ValidatableResponse validateResponseConveyances;
    public static FedExFusePojo fedExFusePojoConveyances;
    public static String encodedStringFromPostmanConveyancesEDI;
    public static String encodedStringFromPostmanConveyancesManifest;
    public static String decodedStringConveyancesEDI;
    public static String decodedStringConveyancesManifest;
    public static byte[] decodedBytesConveyancesEDI;
    public static byte[] decodedBytesConveyancesManifest;

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
                "    \"ProjectCode\": \"DC6\",\n" +
                "    \"ShippingFlowCode\": \"OUTBOUND\",\n" +
                "    \"ForwarderDivisionCode\": \"FFG\",\n" +
                "    \"ForwarderServiceCode\": \"FFG-HOME\",\n" +
                "    \"AdditionalValues\": [\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"Location\",\n" +
                "            \"Value\": \"DC6\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"OriginalServiceGroupCode\",\n" +
                "            \"Value\": \"F5\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"RateEngineCode\",\n" +
                "            \"Value\": \"LBI\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"RateEngineVersion\",\n" +
                "            \"Value\": \"v8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"CurrentDateTime\",\n" +
                "            \"Value\": \"2020-07-15 11:17:00\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"IncludeAllDeliveryTimes\",\n" +
                "            \"Value\": \"true\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"ReturnInvalidResults\",\n" +
                "            \"Value\": \"true\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"StrictUNNumberCompliance\",\n" +
                "            \"Value\": \"true\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"RateCode\",\n" +
                "            \"Value\": \"FFG-HOME-05\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"Zone\",\n" +
                "            \"Value\": \"2DAYS\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"ShippingPoint\",\n" +
                "            \"Value\": \"FFGCOL\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"ShipVia\",\n" +
                "            \"Value\": \"FGRR\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdditionalValueKey\": \"TransactionId\",\n" +
                "            \"Value\": \"MD2020-10-21T13:41:37.000Z4pD2DwLtIrLiEccfDlJe23\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Addresses\": [\n" +
                "        {\n" +
                "            \"Reference\": null,\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"123 Sesame St.\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Index\": 2,\n" +
                "                    \"Value\": \"2nd Address Line\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"77378-0000\",\n" +
                "            \"LocalityName\": \"Jamestown\",\n" +
                "            \"SubdivisionCode\": \"NM\",\n" +
                "            \"SubdivisionName\": \"New York\",\n" +
                "            \"CountryCode\": \"US\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"Name\": \"Enter Sandman\",\n" +
                "                    \"EmailAddress\": null,\n" +
                "                    \"PhoneNumber\": \"(987) 654-3211\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Residential\": true,\n" +
                "            \"AddressTypes\": [\n" +
                "                {\n" +
                "                    \"AddressTypeCode\": \"DELIVERY\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Reference\": \"L Brands\",\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 0,\n" +
                "                    \"Value\": \"3 Limited Pkwy\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"Stop 4\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"43219\",\n" +
                "            \"LocalityName\": \"Gahanna\",\n" +
                "            \"SubdivisionCode\": \"OH\",\n" +
                "            \"SubdivisionName\": \"Ohio\",\n" +
                "            \"CountryCode\": \"US\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"Name\": \"Lx Reception\",\n" +
                "                    \"EmailAddress\": \"support@logistyx.com\",\n" +
                "                    \"PhoneNumber\": \"020 808 0007\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Residential\": false,\n" +
                "            \"AddressTypes\": [\n" +
                "                {\n" +
                "                    \"AddressTypeCode\": \"PICKUP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Value\": null,\n" +
                "    \"ValueCurrencyCode\": \"USD\",\n" +
                "    \"CustomsValue\": null,\n" +
                "    \"CustomsValueCurrencyCode\": \"USD\",\n" +
                "    \"IncotermCode\": null,\n" +
                "    \"IncotermLocalityCode\": null,\n" +
                "    \"IncotermLocalityName\": null,\n" +
                "    \"Weight\": null,\n" +
                "    \"WeightUnitOfMeasure\": null,\n" +
                "    \"RequestedPickupDateTime\": \"2022-01-12T20:02:51.985Z\",\n" +
                "    \"RequestedDeliveryDateTime\": \"2022-01-18T20:02:51.985Z\",\n" +
                "    \"ForwarderServiceIndicators\": {\n" +
                "        \"HoldAtLocation\": \"NO_HOLD\",\n" +
                "        \"DeliverySignature\": \"NONE\",\n" +
                "        \"DirectDeliveryOnly\": false,\n" +
                "        \"AdditionalServices\": null\n" +
                "    },\n" +
                "    \"ServiceLevelAgreementDeliveryDateTime\": \"2022-01-18T20:02:51.985Z\",\n" +
                "    \"ShipperCode\": \"LBI\",\n" +
                "    \"FreightPayer\": \"SHIPPER\",\n" +
                "    \"DutiesPayer\": \"SHIPPER\",\n" +
                "    \"TaxesPayer\": \"SHIPPER\",\n" +
                "    \"ShippingUnits\": [\n" +
                "        {\n" +
                "            \"PackageType\": \"EC\",\n" +
                "            \"Content\": null,\n" +
                "            \"GrossWeight\": 0.99,\n" +
                "            \"GrossWeightUnitOfMeasure\": \"lb\",\n" +
                "            \"Volume\": 0.0,\n" +
                "            \"VolumeUnitOfMeasure\": \"in3\",\n" +
                "            \"Length\": 6.2,\n" +
                "            \"Width\": 5.3,\n" +
                "            \"Height\": 4.4,\n" +
                "            \"DimensionsUnitOfMeasure\": \"in\",\n" +
                "            \"Oversize\": null,\n" +
                "            \"AdditionalHandling\": null,\n" +
                "            \"AdditionalValues\": [\n" +
                "                {\n" +
                "                    \"AdditionalValueKey\": \"Key 2\",\n" +
                "                    \"Value\": \"C300004829\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"AdditionalValueKey\": \"Key 3\",\n" +
                "                    \"Value\": \"2\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"AdditionalValueKey\": \"Key 4\",\n" +
                "                    \"Value\": \"2020-04-27\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"AdditionalValueKey\": \"NONRECTANGULAR\",\n" +
                "                    \"Value\": \"true\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"ShippingUnitItems\": [\n" +
                "                {\n" +
                "                    \"ShippingUnitItemId\": 0,\n" +
                "                    \"ShippingUnitId\": 0,\n" +
                "                    \"ProductCode\": \"S09624562056\",\n" +
                "                    \"Value\": 15.99,\n" +
                "                    \"ValueCurrencyCode\": \"USD\",\n" +
                "                    \"Quantity\": 1,\n" +
                "                    \"QuantityUnitOfMeasure\": \"EA\",\n" +
                "                    \"Weight\": 0.0,\n" +
                "                    \"WeightUnitOfMeasure\": \"LBS\",\n" +
                "                    \"Description\": \"SFSCARFSTYLEBANDEAU,CAN_S106037\",\n" +
                "                    \"CountryOfOrigin\": null,\n" +
                "                    \"HarmonisedSystemCode\": null,\n" +
                "                    \"AdditionalValues\": null,\n" +
                "                    \"DangerousGoods\": null\n" +
                "                }\n" +
                "            ],\n" +
                "            \"ForwarderRef\": null,\n" +
                "            \"ShipperRef\": \"time test\",\n" +
                "            \"ReceiverRef\": null,\n" +
                "            \"Index\": 0\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        requestSpecShipments = given().headers("Shipper-Code", "LBI", "Project-Code", "DC6")
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
        fedExFusePojoShipments = validateResponseShipments.extract().as(FedExFusePojo.class);
        encodedStringFromPostmanShipments = fedExFusePojoShipments.getDocuments().get(0).getContent();
        decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        decodedStringShipments = new String(decodedBytesShipments);

        upTo15kgIcon = "^FO690,601^GFA,358,711,9,:Z64:eJyFkTtOAzEQQGcxWlOsCOUWVkQkDrAlRSRyFI6QMuVEIKWnocxFUvgoLjhAyhQIM55PtBtHyrh5erZnxh64Hj4rvGUU2DRJ4EirRBNhKWcR5lNoiRkeARyqcWw6vkgRRgC3oNziPPcEVkIye6vlzoClrnQYpOdksIFXgaUZv+oEmmMLd0+fC3phS8/OGV10MJTKDhtk8JRTAQSoj2TwzkDpnisYGB4qQ930DL0BmTDdGqqttRmCjiGZSXpmG9V8GOxQYQ966wBqykBDeXL57P7l++dLPt3LyKm3P9R5zE4+soGck8Asq6Ef4FFRrEYmTE20M3FkQmUugJr7NThBFf+O+ldF:486D^FS";
        mediumWeightIcon = "^FO690,601^GFA,346,711,9,:Z64:eJyNkTFOAzEQRf/GYpciCilTRIKCA1BSwR6BZvs9wpYpImFOkCtwlOEmLikp05nZPzORKFbEcvH8POMZ27h2NI8OrzUbHFMxmGDQFBwMMvaEFLACWkLHCS4vkHjihon/ggXPWfgDKQ7UyDZgYx0KdgYFzwaHgJfYupG931TW6GqtuSmtg3QOORl02sYMkrQKTat5DigErT0yJiCvA24DtOQDQZuYAp6Ypf3taBS2sWVmciNTmDFiRjcf4uZL3JyymxPcnOGmhJmvv0Vz5jtouftPM7j7XvU0+v2FBmkGe7vRDGHJ9GH6MLIcczHvtf4QhmF4w/L4BaLZkiY=:F1CF^FS";
        heavyWeightIcon = "^FO677,601^GFA,510,869,11,:Z64:eJxt0j1Ow0AQBeDZbBQjEeEDgGQfgZKKHAVfAImSzttR5jSI0kYcgCNkJSoa5Aq5cDy8mf2JFWEp8ZfxZryzM3R2mTGz7DKvXlziM/WJT+TldouPxw8swZ+NoxvrNY8lcCA7ExVE63KkInBTTWTZ0YZoBRL3tAbbIZPB3UBbJEGEdqNElVivxNuQbaPfiaXQsnKSYri3TvIIvemp1Q3jPZ5YicSNYRd5awNLpkrTIjFT8Tklrg6BSEzdpCsZ5N/I0fCXy/xIUcvvMTojSR9ZZjKK8pEH7CiSF/RpQQc2iY7qwD3TP+yWdCf6RF5yOHHMfJikv7rf/Zx4RBV3MYojq3PFfZ2PxGe2I3j5+A3uhETXTL6a6nioTTk3wooPvmCNVkf2NnXo1RsZB8zGgMpDVM9DuymtaEKPpXteBkQ7iKgOgQyFl6lArokwBNpkdNv0PyzUsdOjkLSG+U1vYcwrPGzD8FdYcE/nLPBwe+JFoKXl9QeoUytL:4EBF^FS";


        switch (fedExFusePojoShipments.getShippingUnits().get(0).getGrossWeightUnitOfMeasure()) {
            case "KG":
            case "KGM":
            case "KGS":
                weightInKilos = fedExFusePojoShipments.getShippingUnits().get(0).getGrossWeight();
                break;
            case "G":
            case "G ":
            case "G  ":
            case "GM":
            case "GM ":
            case "GR ":
            case "GRM":
            case "KG ": // Can't help, DOCS or the component thinks this is grams, no conversion
                weightInKilos = Precision.round(fedExFusePojoShipments.getShippingUnits().get(0).getGrossWeight() * 0.001, 1);
                break;
            case "LB":
            case "LB ":
            case "LBR":
            case "LBS":
                weightInKilos = Precision.round(fedExFusePojoShipments.getShippingUnits().get(0).getGrossWeight() * 0.45359237, 1);
                break;
        }

        if ("MTQ".equals(fedExFusePojoShipments.getVolumeUnitOfMeasure())) {
            volumeInCubicMetre = Precision.round((Double) fedExFusePojoShipments.getVolume(), 8);
        } else if ("CMQ".equals(fedExFusePojoShipments.getVolumeUnitOfMeasure())) {
            volumeInCubicMetre = Precision.round((Double) fedExFusePojoShipments.getVolume() / 1000000, 8);
        }

//        checkString = fedExFusePojoShipments.getShippingUnits().get(0).getForwarderRef().substring(2, 19);
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


        JsonPath jsonPath = validateResponseShipments.extract().jsonPath();
        grossWeight = jsonPath.get("ShippingUnits.GrossWeight");
        detectedNumberOfPackages = fedExFusePojoShipments.getShippingUnits().size();
        //    System.out.println("grossWeight = " + grossWeight);
        for (int i = 0; i < detectedNumberOfPackages; i++) {
            totalGrossWeight = (int) (totalGrossWeight + grossWeight.get(i));
        }


        int shipmentIdFromShipmentsRequest = fedExFusePojoShipments.getShipmentId();
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);
        requestSpecConveyances = given().header("Shipper-Code", "LBI")
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
        fedExFusePojoConveyances = validateResponseConveyances.extract().as(FedExFusePojo.class);
        encodedStringFromPostmanConveyancesEDI = fedExFusePojoConveyances.getDocuments().get(0).getContent();
        decodedBytesConveyancesEDI = Base64.getDecoder().decode(encodedStringFromPostmanConveyancesEDI);
        decodedStringConveyancesEDI = new String(decodedBytesConveyancesEDI);

        fedExFusePojoConveyances = validateResponseConveyances.extract().as(FedExFusePojo.class);
        encodedStringFromPostmanConveyancesManifest = fedExFusePojoConveyances.getDocuments().get(1).getContent();
        decodedBytesConveyancesManifest = Base64.getDecoder().decode(encodedStringFromPostmanConveyancesManifest);
        decodedStringConveyancesManifest = new String(decodedBytesConveyancesManifest);

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

        currentDateTime = year + "-" + month + "-" + day + "T" + hour + ":" + minute + ":" + second;


    }
}