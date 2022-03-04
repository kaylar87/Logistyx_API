package com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom;


import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public abstract class SFBaseNotDG_AddresLine_1 {

    public static String requestJsonBodyShipments;
    public static RequestSpecification requestSpecShipments;
    public static ResponseSpecification responseSpecShipments;
    public static ValidatableResponse validateResponseShipments;



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
                "            \"AddressLines\": [],\n" +
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
                "    \"RequestedPickupDateTime\": \"2022-01-27T21:16:17.565Z\",\n" +
                "    \"RequestedPickupWindowBeginDateTime\": null,\n" +
                "    \"RequestedPickupWindowEndDateTime\": null,\n" +
                "    \"RequestedDeliveryDateTime\": \"2022-01-29T21:16:17.565Z\",\n" +
                "    \"RequestedDeliveryWindowBeginDateTime\": null,\n" +
                "    \"RequestedDeliveryWindowEndDateTime\": null,\n" +
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
                "            \"Length\": null,\n" +
                "            \"Width\": 26.5,\n" +
                "            \"Height\": 4,\n" +
                "            \"DimensionsUnitOfMeasure\": \"CM\",\n" +
                "            \"Volume\": 135200.36,\n" +
                "            \"VolumeUnitOfMeasure\": \"CMQ\",\n" +
                "            \"PackageType\": \"CT\",\n" +
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
        responseSpecShipments = expect().statusCode(400)
                .and()
                .contentType(ContentType.JSON);
        validateResponseShipments = given().spec(requestSpecShipments)
                .when()
                .post("/shipments/label")
                .then()
                .spec(responseSpecShipments);






    }
}