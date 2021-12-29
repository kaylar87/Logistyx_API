package com.logistyx.utilities;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.baseURI;


public abstract class BNPBase {

    public static String requestJsonBodyShipments;

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

    }
}


