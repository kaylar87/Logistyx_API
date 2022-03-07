package com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom;


import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public abstract class SFBaseNotDG_No_ShipperAddress_Reference_Or_ContactName {

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
                "    \"FreightPayer\": \"SHIPPER\",\n" +
                "    \"DutiesPayer\": \"DELIVERY\",\n" +
                "    \"TaxesPayer\": \"DELIVERY\",\n" +
                "    \"ForwarderServiceCode\": \"STANDARD\",\n" +
                "    \"ShipperRef\": \"theshipperref\",\n" +
                "      \"ReceiverRef\": \"11000110001100011\",\n" +
                "    \"Addresses\": [\n" +
                "        {\n" +
                "            \"Reference\": null,\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"De Grens 28\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"5921 CC\",\n" +
                "            \"LocalityName\": \"Venlo\",\n" +
                "            \"CountryCode\": \"NL\",\n" +
                "            \"Remark\": \"Remark value\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"Name\": \"the pickup contact name\",\n" +
                "                    \"EmailAddress\": \"info.pickup@email.com\",\n" +
                "                    \"PhoneNumber\": \"+31 (0)40 292 50 00\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"AddressTypes\": [\n" +
                "                {\n" +
                "                    \"AddressTypeCode\": \"PICKUP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Reference\": \"VDL / Delivery\",\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"Wacholderweg 52a\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"26133\",\n" +
                "            \"LocalityName\": \"OLDENBURG\",\n" +
                "            \"CountryCode\": \"DE\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"Name\": \"W.A. Mozart\",\n" +
                "                    \"EmailAddress\": \"info.delivery@mail.com\",\n" +
                "                    \"PhoneNumber\": \"(31)497-532-323\",\n" +
                "                    \"FaxNumber\": null\n" +
                "                }\n" +
                "            ],\n" +
                "            \"AddressTypes\": [\n" +
                "                {\n" +
                "                    \"AddressTypeCode\": \"DELIVERY\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Reference\": \"VDL / Receiver\",\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"Wacholderweg 52b\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Index\": 2,\n" +
                "                    \"Value\": \"Back door\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"26133\",\n" +
                "            \"LocalityName\": \"OLDENBURG\",\n" +
                "            \"CountryCode\": \"DE\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"Name\": \"J. Sibelius\",\n" +
                "                    \"EmailAddress\": \"info.receiver@mail.com\",\n" +
                "                    \"PhoneNumber\": \"+31 06 112233445\",\n" +
                "                    \"FaxNumber\": \"+3106222233445\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"VatNumber\": \"123\",\n" +
                "            \"BankAccountNumber\": \"456\",\n" +
                "            \"AddressTypes\": [\n" +
                "                {\n" +
                "                    \"AddressTypeCode\": \"RECEIVER\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Reference\": null,\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"Wacholderweg 52G\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Index\": 2,\n" +
                "                    \"Value\": \"Line two\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"26133\",\n" +
                "            \"LocalityName\": \"OLDENBURG\",\n" +
                "            \"CountryCode\": \"DE\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"Name\": null,\n" +
                "                    \"EmailAddress\": \"info.shipper@mail.com\",\n" +
                "                    \"PhoneNumber\": \"+31 06 112233445\",\n" +
                "                    \"FaxNumber\": \"+3106222233445\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"VatNumber\": \"321\",\n" +
                "            \"BankAccountNumber\": \"654\",\n" +
                "            \"AddressTypes\": [\n" +
                "                {\n" +
                "                    \"AddressTypeCode\": \"SHIPPER\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Value\": 300,\n" +
                "    \"ValueCurrencyCode\": \"EUR\",\n" +
                "    \"InsuranceValue\": 300,\n" +
                "    \"InsuranceValueCurrencyCode\": \"EUR\",\n" +
                "    \"CustomsValue\": 300,\n" +
                "    \"CustomsValueCurrencyCode\": \"EUR\",\n" +
                "    \"NonDutiable\": false,\n" +
                "    \"IncotermCode\": \"CPT\",\n" +
                "    \"Volume\": 3,\n" +
                "    \"VolumeUnitOfMeasure\": \"MTQ\",\n" +
                "    \"Weight\": 30,\n" +
                "    \"WeightUnitOfMeasure\": \"KGM\",\n" +
                "    \"Info\": \"Shipment level info\",\n" +
                "    \"Remark\": \"Shipment level remark\",\n" +
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
                "            \"Reference\": \"SU.47068501\",\n" +
                "            \"ShipperRef\": \"4706850\",\n" +
                "            \"ReceiverRef\": \"3058986\",\n" +
                "            \"Value\": 100,\n" +
                "            \"ValueCurrencyCode\": \"EUR\",\n" +
                "            \"InsuranceValue\": 100,\n" +
                "            \"InsuranceValueCurrencyCode\": \"EUR\",\n" +
                "            \"CustomsValue\": 100,\n" +
                "            \"CustomsValueCurrencyCode\": \"EUR\",\n" +
                "            \"Length\": 1,\n" +
                "            \"Width\": 1,\n" +
                "            \"Height\": 1,\n" +
                "            \"DimensionsUnitOfMeasure\": \"MTR\",\n" +
                "            \"Volume\": 1,\n" +
                "            \"VolumeUnitOfMeasure\": \"MTQ\",\n" +
                "            \"PackageType\": \"PT\",\n" +
                "            \"NetWeight\": 10,\n" +
                "            \"NetWeightUnitOfMeasure\": \"KGM\",\n" +
                "            \"GrossWeight\": 10,\n" +
                "            \"GrossWeightUnitOfMeasure\": \"KGM\",\n" +
                "            \"Content\": \"git\",\n" +
                "            \"Remark\": \"Remark, 1st package\",\n" +
                "            \"Fragile\": true,\n" +
                "            \"Liquids\": true,\n" +
                "            \"Stackable\": true,\n" +
                "            \"Returnable\": false,\n" +
                "            \"ShippingUnitItems\": [\n" +
                "                {\n" +
                "                    \"Reference\": \"47068501\",\n" +
                "                    \"Description\": \"Something blue\",\n" +
                "                    \"ShipperRef\": \"4706850\",\n" +
                "                    \"CountryOfOrigin\": \"NL\",\n" +
                "                    \"HarmonisedSystemCode\": \"6402991000\",\n" +
                "                    \"Value\": 100,\n" +
                "                    \"ValueCurrencyCode\": \"EUR\",\n" +
                "                    \"Weight\": 10,\n" +
                "                    \"WeightUnitOfMeasure\": \"KGM\",\n" +
                "                    \"Quantity\": 1,\n" +
                "                    \"QuantityUnitOfMeasure\": \"EA\",\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Index\": 2,\n" +
                "            \"Reference\": \"SU.47068502\",\n" +
                "            \"ShipperRef\": \"4706850\",\n" +
                "            \"ReceiverRef\": \"3058986\",\n" +
                "            \"Value\": 1,\n" +
                "            \"ValueCurrencyCode\": \"EUR\",\n" +
                "            \"InsuranceValue\": 1,\n" +
                "            \"InsuranceValueCurrencyCode\": \"EUR\",\n" +
                "            \"CustomsValue\": 1,\n" +
                "            \"CustomsValueCurrencyCode\": \"EUR\",\n" +
                "            \"Length\": 1,\n" +
                "            \"Width\": 1,\n" +
                "            \"Height\": 1,\n" +
                "            \"DimensionsUnitOfMeasure\": \"CMT\",\n" +
                "            \"Volume\": 1,\n" +
                "            \"VolumeUnitOfMeasure\": \"CMQ\",\n" +
                "            \"PackageType\": \"CT\",\n" +
                "            \"NetWeight\": 1,\n" +
                "            \"NetWeightUnitOfMeasure\": \"KGM\",\n" +
                "            \"TareWeight\": 1,\n" +
                "            \"TareWeightUnitOfMeasure\": \"KGM\",\n" +
                "            \"GrossWeight\": 1000,\n" +
                "            \"GrossWeightUnitOfMeasure\": \"GRM\",\n" +
                "            \"Content\": \"Description, 2nd package\",\n" +
                "            \"Remark\": \"Remark, 2nd package\",\n" +
                "            \"Fragile\": true,\n" +
                "            \"Liquids\": true,\n" +
                "            \"Stackable\": false,\n" +
                "            \"Returnable\": false,\n" +
                "            \"ShippingUnitItems\": [\n" +
                "                {\n" +
                "                    \"Reference\": \"47068502\",\n" +
                "                    \"Description\": \"Something old\",\n" +
                "                    \"ShipperRef\": \"4706850\",\n" +
                "                    \"CountryOfOrigin\": \"NL\",\n" +
                "                    \"HarmonisedSystemCode\": \"6402991000\",\n" +
                "                    \"Value\": 75,\n" +
                "                    \"ValueCurrencyCode\": \"EUR\",\n" +
                "                    \"Weight\": 7.5,\n" +
                "                    \"WeightUnitOfMeasure\": \"KGM\",\n" +
                "                    \"Quantity\": 1,\n" +
                "                    \"QuantityUnitOfMeasure\": \"EA\",\n" +
                "                    \"CollectOnDeliveryAmount\": null,\n" +
                "                    \"CollectOnDeliveryAmountCurrencyCode\": null,\n" +
                "                    \"DangerousGoods\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Index\": 3,\n" +
                "            \"ShipperRef\": \"4706850\",\n" +
                "            \"ReceiverRef\": \"3058986\",\n" +
                "            \"Value\": 1,\n" +
                "            \"ValueCurrencyCode\": \"EUR\",\n" +
                "            \"InsuranceValue\": 1,\n" +
                "            \"InsuranceValueCurrencyCode\": \"EUR\",\n" +
                "            \"CustomsValue\": 1,\n" +
                "            \"CustomsValueCurrencyCode\": \"EUR\",\n" +
                "            \"Length\": 1,\n" +
                "            \"Width\": 1,\n" +
                "            \"Height\": 1,\n" +
                "            \"DimensionsUnitOfMeasure\": \"CMT\",\n" +
                "            \"Volume\": 1,\n" +
                "            \"VolumeUnitOfMeasure\": \"CMQ\",\n" +
                "            \"PackageType\": \"PD\",\n" +
                "            \"NetWeight\": 1,\n" +
                "            \"NetWeightUnitOfMeasure\": \"KGM\",\n" +
                "            \"TareWeight\": 1,\n" +
                "            \"TareWeightUnitOfMeasure\": \"KGM\",\n" +
                "            \"GrossWeight\": 1000,\n" +
                "            \"GrossWeightUnitOfMeasure\": \"GRM\",\n" +
                "            \"Content\": \"Description, 3rd package\",\n" +
                "            \"Remark\": \"Remark, 3rd package\",\n" +
                "            \"Fragile\": true,\n" +
                "            \"Liquids\": true,\n" +
                "            \"Stackable\": false,\n" +
                "            \"Returnable\": false,\n" +
                "            \"ShippingUnitItems\": [\n" +
                "                {\n" +
                "                    \"Reference\": \"47068503\",\n" +
                "                    \"Description\": \"Something new\",\n" +
                "                    \"ShipperRef\": \"4706850\",\n" +
                "                    \"CountryOfOrigin\": \"NL\",\n" +
                "                    \"HarmonisedSystemCode\": \"6402991000\",\n" +
                "                    \"Value\": 125,\n" +
                "                    \"ValueCurrencyCode\": \"EUR\",\n" +
                "                    \"Weight\": 12.5,\n" +
                "                    \"WeightUnitOfMeasure\": \"KGM\",\n" +
                "                    \"Quantity\": 1,\n" +
                "                    \"QuantityUnitOfMeasure\": \"EA\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"NumberOfShippingUnits\": 3\n" +
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