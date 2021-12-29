package com.logistyx.TEST;

import static io.restassured.RestAssured.baseURI;

import com.logistyx.pojo.bring.parcel.BringParcelPojo;
import com.sun.xml.bind.v2.TODO;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


@DisplayName("1b - NL-NO,  weight 2 KG")
public class $1bNL$NoWeight2KG {

    @BeforeAll
    public static void init() {
        baseURI = "https://as-cdt-dev-logistyx-qa1-docs.azurewebsites.net";
    }

    @DisplayName("ShippingId is not NULL")
    @Test
    public void test1() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);

        assertThat(bringParcelPojoShipments.getShipmentId(), is(notNullValue()));
        System.out.println("bringParcelPojo.getShipmentId() = " + bringParcelPojoShipments.getShipmentId());

    }

    @DisplayName("ZPL ('Documents/0/Content') is not NULL")
    @Test
    public void test2() {

        String requestJsonBodyShipments = "{\n" +
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

        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        assertThat(encodedStringFromPostmanShipments, is(notNullValue()));
        System.out.println("encodedStringFromPostmanShipments = " + encodedStringFromPostmanShipments);

    }

    @DisplayName("ZPL size > 500 characters")
    @Test
    public void test3() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        assertThat(encodedStringFromPostmanShipments.length(), is(greaterThan(500)));
        System.out.println("encodedStringFromPostmanShipments.length() = " + encodedStringFromPostmanShipments.length());

        String pickUpAddressName1FromJson = bringParcelPojoShipments.getAddresses().get(0).getAddressLines().get(0).getValue();
        System.out.println("pickUpAddressName1FromJson = " + pickUpAddressName1FromJson);
        int pickUpAddressName1FromLabelStart = decodedStringShipments.indexOf("^FT30,133^A0N,27,27^FD") + 22;
        String pickUpAddressName1FromLabel = decodedStringShipments.substring(pickUpAddressName1FromLabelStart, pickUpAddressName1FromLabelStart + pickUpAddressName1FromJson.length());
        System.out.println("pickUpAddressName1FromLabel = " + pickUpAddressName1FromLabel);
        assertThat(pickUpAddressName1FromJson, is(equalTo(pickUpAddressName1FromLabel)));

        String pickUpAddressName2FromJson = bringParcelPojoShipments.getAddresses().get(0).getCountryCode() + "-" + bringParcelPojoShipments.getAddresses().get(0).getPostalCode() + " " + bringParcelPojoShipments.getAddresses().get(0).getLocalityName();
        System.out.println("pickUpAddressName2FromJson = " + pickUpAddressName2FromJson);
        int pickUpAddressName2FromLabelStart = decodedStringShipments.indexOf("^FT30,162^A0N,30,30^FD") + 22;
        String pickUpAddressName2FromLabel = decodedStringShipments.substring(pickUpAddressName2FromLabelStart, pickUpAddressName2FromLabelStart + pickUpAddressName2FromJson.length());
        System.out.println("pickUpAddressName2FromLabel = " + pickUpAddressName2FromLabel);
        assertThat(pickUpAddressName2FromJson, is(equalTo(pickUpAddressName2FromLabel)));

        String deliveryAddressName1FromJson = bringParcelPojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue();
        System.out.println("deliveryAddressName1FromJson = " + deliveryAddressName1FromJson);
        int deliveryAddressName1FromLabelStart = decodedStringShipments.indexOf("^FT51,304^A0N,33,33^FD") + 22;
        String deliveryAddressName1FromLabel = decodedStringShipments.substring(deliveryAddressName1FromLabelStart, deliveryAddressName1FromLabelStart + deliveryAddressName1FromJson.length());
        System.out.println("deliveryAddressName1FromLabel = " + deliveryAddressName1FromLabel);
        assertThat(deliveryAddressName1FromJson, is(equalTo(deliveryAddressName1FromLabel)));

        String deliveryAddressName2FromJson = bringParcelPojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue();
        System.out.println("deliveryAddressName2FromJson = " + deliveryAddressName2FromJson);
        int deliveryAddressName2FromLabelStart = decodedStringShipments.indexOf("^FT51,337^A0N,33,33^FD") + 22;
        String deliveryAddressName2FromLabel = decodedStringShipments.substring(deliveryAddressName2FromLabelStart, deliveryAddressName2FromLabelStart + deliveryAddressName2FromJson.length());
        System.out.println("deliveryAddressName2FromLabel = " + deliveryAddressName2FromLabel);
        assertThat(deliveryAddressName2FromJson, is(equalTo(deliveryAddressName2FromLabel)));

        String deliveryAddressName3FromJson = bringParcelPojoShipments.getDeliveryAddress().getCountryCode() + "-" + bringParcelPojoShipments.getDeliveryAddress().getPostalCode() + " " + bringParcelPojoShipments.getDeliveryAddress().getLocalityName();
        System.out.println("deliveryAddressName3FromJson = " + deliveryAddressName3FromJson);
        int deliveryAddressName3FromLabelStart = decodedStringShipments.indexOf("^FT51,380^A0N,46,46^FD") + 22;
        String deliveryAddressName3FromLabel = decodedStringShipments.substring(deliveryAddressName3FromLabelStart, deliveryAddressName3FromLabelStart + deliveryAddressName3FromJson.length());
        System.out.println("deliveryAddressName3FromLabel = " + deliveryAddressName3FromLabel);
        assertThat(deliveryAddressName3FromJson, is(equalTo(deliveryAddressName3FromLabel)));

    }

    @DisplayName("PICKUP address details: Earl Bakkenstraat 7, NL-6422 PJ, HEERLEN")
    @Test
    public void test4() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);


        String pickUpAddressName1FromJson = bringParcelPojoShipments.getAddresses().get(0).getAddressLines().get(0).getValue();
        System.out.println("pickUpAddressName1FromJson = " + pickUpAddressName1FromJson);
        int pickUpAddressName1FromLabelStart = decodedStringShipments.indexOf("^FT30,133^A0N,27,27^FD") + 22;
        String pickUpAddressName1FromLabel = decodedStringShipments.substring(pickUpAddressName1FromLabelStart, pickUpAddressName1FromLabelStart + pickUpAddressName1FromJson.length());
        System.out.println("pickUpAddressName1FromLabel = " + pickUpAddressName1FromLabel);
        assertThat(pickUpAddressName1FromJson, is(equalTo(pickUpAddressName1FromLabel)));

        String pickUpAddressName2FromJson = bringParcelPojoShipments.getAddresses().get(0).getCountryCode() + "-" + bringParcelPojoShipments.getAddresses().get(0).getPostalCode() + " " + bringParcelPojoShipments.getAddresses().get(0).getLocalityName();
        System.out.println("pickUpAddressName2FromJson = " + pickUpAddressName2FromJson);
        int pickUpAddressName2FromLabelStart = decodedStringShipments.indexOf("^FT30,162^A0N,30,30^FD") + 22;
        String pickUpAddressName2FromLabel = decodedStringShipments.substring(pickUpAddressName2FromLabelStart, pickUpAddressName2FromLabelStart + pickUpAddressName2FromJson.length());
        System.out.println("pickUpAddressName2FromLabel = " + pickUpAddressName2FromLabel);
        assertThat(pickUpAddressName2FromJson, is(equalTo(pickUpAddressName2FromLabel)));

    }

    @DisplayName("DELIVERY address details: Grand Hotel Oslo, NO-0159, OSLO")
    @Test
    public void test5() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);


        String deliveryAddressName1FromJson = bringParcelPojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue();
        System.out.println("deliveryAddressName1FromJson = " + deliveryAddressName1FromJson);
        int deliveryAddressName1FromLabelStart = decodedStringShipments.indexOf("^FT51,304^A0N,33,33^FD") + 22;
        String deliveryAddressName1FromLabel = decodedStringShipments.substring(deliveryAddressName1FromLabelStart, deliveryAddressName1FromLabelStart + deliveryAddressName1FromJson.length());
        System.out.println("deliveryAddressName1FromLabel = " + deliveryAddressName1FromLabel);
        assertThat(deliveryAddressName1FromJson, is(equalTo(deliveryAddressName1FromLabel)));

        String deliveryAddressName2FromJson = bringParcelPojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue();
        System.out.println("deliveryAddressName2FromJson = " + deliveryAddressName2FromJson);
        int deliveryAddressName2FromLabelStart = decodedStringShipments.indexOf("^FT51,337^A0N,33,33^FD") + 22;
        String deliveryAddressName2FromLabel = decodedStringShipments.substring(deliveryAddressName2FromLabelStart, deliveryAddressName2FromLabelStart + deliveryAddressName2FromJson.length());
        System.out.println("deliveryAddressName2FromLabel = " + deliveryAddressName2FromLabel);
        assertThat(deliveryAddressName2FromJson, is(equalTo(deliveryAddressName2FromLabel)));

        String deliveryAddressName3FromJson = bringParcelPojoShipments.getDeliveryAddress().getCountryCode() + "-" + bringParcelPojoShipments.getDeliveryAddress().getPostalCode() + " " + bringParcelPojoShipments.getDeliveryAddress().getLocalityName();
        System.out.println("deliveryAddressName3FromJson = " + deliveryAddressName3FromJson);
        int deliveryAddressName3FromLabelStart = decodedStringShipments.indexOf("^FT51,380^A0N,46,46^FD") + 22;
        String deliveryAddressName3FromLabel = decodedStringShipments.substring(deliveryAddressName3FromLabelStart, deliveryAddressName3FromLabelStart + deliveryAddressName3FromJson.length());
        System.out.println("deliveryAddressName3FromLabel = " + deliveryAddressName3FromLabel);
        assertThat(deliveryAddressName3FromJson, is(equalTo(deliveryAddressName3FromLabel)));

    }

    @DisplayName("Delivery person details: DY.Contact Name")
    @Test
    public void test6() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        String deliveryPersonDetailsFromJson = bringParcelPojoShipments.getDeliveryAddress().getContacts().get(0).getName();
        System.out.println("deliveryPersonDetailsFromJson = " + deliveryPersonDetailsFromJson);
        int deliveryPersonDetailsFromLabelStart = decodedStringShipments.indexOf("^FT51,272^A0N,33,33^FD") + 22;
        String deliveryPersonDetailsFromLabel = decodedStringShipments.substring(deliveryPersonDetailsFromLabelStart, deliveryPersonDetailsFromLabelStart + deliveryPersonDetailsFromJson.length());
        System.out.println("deliveryPersonDetailsFromLabel = " + deliveryPersonDetailsFromLabel);
        assertThat(deliveryPersonDetailsFromJson, is(equalTo(deliveryPersonDetailsFromLabel)));

    }

    @DisplayName("Delivery phone number: +(06)2-222222")
    @Test
    public void test7() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        String deliveryPhoneNumberFromJson = bringParcelPojoShipments.getDeliveryAddress().getContacts().get(0).getPhoneNumber();
        System.out.println("deliveryPhoneNumberFromJson = " + deliveryPhoneNumberFromJson);
        int deliveryPhoneNumberFromLabelStart = decodedStringShipments.indexOf("^FT559,423^A0N,27,27^FD") + 23;
        String deliveryPhoneNumberFromLabel = decodedStringShipments.substring(deliveryPhoneNumberFromLabelStart, deliveryPhoneNumberFromLabelStart + deliveryPhoneNumberFromJson.length());
        System.out.println("deliveryPhoneNumberFromLabel = " + deliveryPhoneNumberFromLabel);
        assertThat(deliveryPhoneNumberFromJson, is(equalTo(deliveryPhoneNumberFromLabel)));

    }

    //TODO
    @DisplayName("Ship date (format: dd.MM.yyyy): 06.10.2020")
    @Test
    public void test8() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        String shipDateFromJson = bringParcelPojoShipments.getRequestedPickupDateTime().replace("-", ".").substring(0, 10);
        shipDateFromJson.replace("-", ".");
        String shipDayFromJsonFormat = shipDateFromJson.substring(8);
        //System.out.println("shipDayFromJsonFormat = " + shipDayFromJsonFormat);
        String shipMonthFromJsonFormat = shipDateFromJson.substring(5, 7);
        //System.out.println("shipMonthFromJsonFormat = " + shipMonthFromJsonFormat);
        String shipYearFromJsonFormat = shipDateFromJson.substring(0, 4);
        //System.out.println("shipYearFromJsonFormat = " + shipYearFromJsonFormat);
        String shipDateFromJsonFormat = shipDayFromJsonFormat + "." + shipMonthFromJsonFormat + "." + shipYearFromJsonFormat;
        //System.out.println("shipDateFromJsonFormat = " + shipDateFromJsonFormat);

        System.out.println("shipDateFromJson = " + shipDateFromJson);
        int shipDateFromLabelStart = decodedStringShipments.indexOf("^FT559,246^A0N,27,27^FD") + 23;
        String shipDateFromLabel = decodedStringShipments.substring(shipDateFromLabelStart, shipDateFromLabelStart + 10);
        System.out.println("shipDateFromLabel = " + shipDateFromLabel);
        assertThat(shipDateFromJsonFormat, containsString(shipDateFromLabel));

    }

    @DisplayName("Service (BNP-BUS-PRCL) on the label, destination country = NO, product = Bring Parcel Business Parcel, product code = 0330 and handling code = 2")
    @Test
    public void test9() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        String productIdFromLabel = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT169,988^A0N,54,54^FD") + 23, decodedStringShipments.indexOf("^FT169,988^A0N,54,54^FD") + 23 + 4);
        System.out.println("productIdFromLabel = " + productIdFromLabel);
        String productFromJson = bringParcelPojoShipments.getForwarderDivisionService().getName();
        System.out.println("productFromJson = " + productFromJson);
        String productFromLabel = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT169,892^A0N,35,35^FD") + 23, decodedStringShipments.indexOf("^FT169,892^A0N,35,35^FD") + 23 + productFromJson.length());
        System.out.println("productFromLabel = " + productFromLabel);
        String deliveryCountryCodeFromJson = bringParcelPojoShipments.getDeliveryAddress().getCountryCode();
        System.out.println("deliveryCountryCodeFromJson = " + deliveryCountryCodeFromJson);
        String handlingCodeFromLabel = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT691,982^A0N,128,128^FD") + 25, decodedStringShipments.indexOf("^FT691,982^A0N,128,128^FD") + 26);
        System.out.println("handlingCodeFromLabel = " + handlingCodeFromLabel);
        String weightFromLabel = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT620,500^A0N,27,27^FD") + 23, decodedStringShipments.indexOf("^FT620,500^A0N,27,27^FD") + 26);
        System.out.println("weightFromLabel = " + weightFromLabel);

        System.out.println("bringParcelPojoShipments.getForwarderServiceCode() = " + bringParcelPojoShipments.getForwarderServiceCode());
        assertThat(bringParcelPojoShipments.getForwarderServiceCode(), is(equalTo("BNP-BUS-PRCL")));

        if (bringParcelPojoShipments.getForwarderServiceCode().equals("BNP-BUS-PRCL")) {
            assertThat(productIdFromLabel, is(equalTo("0330")));
            assertThat(productFromLabel, is(equalTo("Bring Parcel Business Parcel")));
            if (deliveryCountryCodeFromJson.equals("NO")) {
                assertThat(handlingCodeFromLabel, is(equalTo("2")));
                String maxWeight = "35";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
            if (deliveryCountryCodeFromJson.equals("SE")) {
                String maxWeight = "35";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
        } else if (bringParcelPojoShipments.getForwarderServiceCode().equals("BNP-BUS-PRCL-BLK")) {
            assertThat(productIdFromLabel, is(equalTo("0332")));
            assertThat(productFromLabel, is(equalTo("Bring Parcel Business Parcel Bulk")));
            if (deliveryCountryCodeFromJson.equals("NO")) {
                assertThat(handlingCodeFromLabel, is(equalTo("2")));
                String maxWeight = "35";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
            if (deliveryCountryCodeFromJson.equals("SE")) {
                String maxWeight = "35";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
        } else if (bringParcelPojoShipments.getForwarderServiceCode().equals("BNP-PICKUP-PRCL")) {
            assertThat(productIdFromLabel, is(equalTo("0340")));
            assertThat(productFromLabel, is(equalTo("Bring Parcel Pick-up Parcel")));
            if (deliveryCountryCodeFromJson.equals("NO")) {
                assertThat(handlingCodeFromLabel, is(equalTo("3")));
                String maxWeight = "35";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
            if (deliveryCountryCodeFromJson.equals("SE")) {
                String maxWeight = "20";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
        } else if (bringParcelPojoShipments.getForwarderServiceCode().equals("BNP-PICKUP-PRCL-BLK")) {
            assertThat(productIdFromLabel, is(equalTo("0342")));
            assertThat(productFromLabel, is(equalTo("Bring Parcel Pick-up Parcel Bulk")));
            if (deliveryCountryCodeFromJson.equals("NO")) {
                assertThat(handlingCodeFromLabel, is(equalTo("3")));
                String maxWeight = "35";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
            if (deliveryCountryCodeFromJson.equals("SE")) {
                String maxWeight = "20";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
        } else if (bringParcelPojoShipments.getForwarderServiceCode().equals("BNP-BUS-PALLET")) {
            assertThat(productIdFromLabel, is(equalTo("0336")));
            assertThat(productFromLabel, is(equalTo("Bring Parcel Business Pallet")));
            if (deliveryCountryCodeFromJson.equals("NO")) {
                String maxWeight = "1000";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
            if (deliveryCountryCodeFromJson.equals("SE")) {
                String maxWeight = "1000";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
        } else {
            System.out.println("Forwarder Service Code is " + bringParcelPojoShipments.getForwarderServiceCode());
        }
    }

    @DisplayName("Unique Shipment Identity, 12345670000019437")
    @Test
    public void test10() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        String shipmentIdFromJson = bringParcelPojoShipments.getForwarderRef();
        System.out.println("shipmentIdFromJson = " + shipmentIdFromJson);
        int shipmentIdFromLabelStart = decodedStringShipments.indexOf("^FT30,567^A0N,27,27^FD") + 22;
        String shipmentIdFromLabel = decodedStringShipments.substring(shipmentIdFromLabelStart, shipmentIdFromLabelStart + shipmentIdFromJson.length());
        System.out.println("shipmentIdFromLabel = " + shipmentIdFromLabel);
        assertThat(shipmentIdFromJson, is(equalTo(shipmentIdFromLabel)));

    }

    @DisplayName("(Hard-coded) Customer ID check, 12BAC3DE")
    @Test
    public void test11() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        int customerNoFromLabelStart = decodedStringShipments.indexOf("^FT620,560^A0N,27,27^FD") + 23;
        String customerNoFromLabel = decodedStringShipments.substring(customerNoFromLabelStart, customerNoFromLabelStart + 8);
        System.out.println("customerNoFromLabel = " + customerNoFromLabel);
        assertThat(customerNoFromLabel, is(equalTo("12BAC3DE")));
    }

    @DisplayName("Bring LOGO")
    @Test
    public void test12() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        String bringLogoFromLabel = "^FO35,854^GFA,630,1596,12,:Z64:eJytlU1qAzEMhW20";
        assertThat(decodedStringShipments, containsString(bringLogoFromLabel));
    }

    //TODO
    @Disabled
    @DisplayName("Icon, based on 1. package weight: 2 KGM --> Light, up to 15 kg, Converted weight: 2.0 kg")
    @Test
    public void test13() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

    }

    //TODO
    @Disabled
    @DisplayName("1. package's' & shipment weight: 2 KGM, Converted weight: 2.0 kg. Total (shipment) weight is 2.0 kg")
    @Test
    public void test14() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

    }

    @DisplayName("1. package's Unique Package Identity, (00)112345670000024094")
    @Test
    public void test15() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        String packageIdFromJson = bringParcelPojoShipments.getShippingUnits().get(0).getForwarderRef();
        System.out.println("packageIdFromJson = " + packageIdFromJson);
        int packageIdFromLabelStart = decodedStringShipments.indexOf("^FT30,500^A0N,27,27^FD") + 22;
        String packageIdFromLabel = decodedStringShipments.substring(packageIdFromLabelStart, packageIdFromLabelStart + packageIdFromJson.length() + 2).replace("(", "").replace(")", "");
        System.out.println("packageIdFromLabel = " + packageIdFromLabel);
        assertThat(packageIdFromJson, is(equalTo(packageIdFromLabel)));

    }

    //TODO
    @Disabled
    @DisplayName("1. package's Package-ID, printed under barcode, (00)112345670000024094")
    @Test
    public void test16() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

    }

    //TODO
    @DisplayName("1. package's Package number identifier, 1 / {1|1} for CEVA")
    @Test
    public void test17() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        String numberOfShippingUnitsFromJson = String.valueOf(bringParcelPojoShipments.getNumberOfShippingUnits());
        System.out.println("numberOfShippingUnitsFromJson = " + numberOfShippingUnitsFromJson);
        int packagesFromLabelStart = decodedStringShipments.indexOf("^FT366,500^A0N,27,27^FD") + 23;
        String packagesSuffix = " / -";
        String packagesFromLabel = decodedStringShipments.substring(packagesFromLabelStart, packagesFromLabelStart + numberOfShippingUnitsFromJson.length() + packagesSuffix.length());
        System.out.println("packagesFromLabel = " + packagesFromLabel);
        assertThat(numberOfShippingUnitsFromJson + packagesSuffix, is(equalTo(packagesFromLabel)));
    }

    @DisplayName("1. package's sender / shipper reference, SU.ShipperRef")
    @Test
    public void test18() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        assertThat(decodedStringShipments, containsString("^FT30,1039^A0N,22,22^FDSenders reference:^FS"));
        String shipperRefFromJson = bringParcelPojoShipments.getShippingUnits().get(0).getShipperRef();
        System.out.println("shipperRefFromJson = " + shipperRefFromJson);
        int sendersRefFromLabelStart = decodedStringShipments.indexOf("^FT30,1077^A0N,30,30^FD") + 23;
        String sendersRefFromLabel = decodedStringShipments.substring(sendersRefFromLabelStart, sendersRefFromLabelStart + shipperRefFromJson.length());
        System.out.println("sendersRefFromLabel = " + sendersRefFromLabel);
        assertThat(shipperRefFromJson, is(equalTo(sendersRefFromLabel)));

    }

    //TODO
    @Disabled
    @DisplayName("Verify number of non-DG (1) vs. DG labels (0)")
    @Test
    public void test19() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

    }


    @DisplayName("UNB+UNOC:3+12BAC3DE:ZZZ+7080003248381:14+211222:1416+00000000002119 checks.")
    @Test
    public void test20() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);


        int shipmentIdFromShipmentsRequest = bringParcelPojoShipments.getShipmentId();
        System.out.println("shipmentIdFromShipmentsRequest = " + shipmentIdFromShipmentsRequest);
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);

        Response responseConveyances = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(objectShipmentIdFromShipmentsRequest)
                .when()
                .post("/conveyances/confirm");
        BringParcelPojo bringParcelPojoConveyances = responseConveyances.as(BringParcelPojo.class);
        String encodedStringFromPostmanConveyances = bringParcelPojoConveyances.getDocuments().get(0).getContent();
        byte[] decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        String decodedStringConveyances = new String(decodedBytesConveyances);


        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        String month = date1.substring(0, 2);
        String day = date1.substring(3, 5);
        int year = Integer.parseInt(date1.substring(6, 10));
        int century = (year / 100) + 1;
        int hour = Integer.parseInt(date1.substring(11, 13)) + 5;
        String minute = date1.substring(14, 16);
        String second = date1.substring(17, 19);
        System.out.println("hour = " + hour);

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        System.out.println("decodeArrList.get(1) = " + decodeArrList.get(1));

//        System.out.println("bringParcelPojo.getDocuments().get(0).getReference() = " + bringParcelPojoConveyances.getDocuments().get(0).getReference());
//        String str = (String) bringParcelPojoConveyances.getDocuments().get(0).getReference();

        assertThat(decodeArrList.get(1).toString(), containsString("UNB+UNOC:3+12BAC3DE:ZZZ+7080003248381:14+" + century + month + day + ":" + hour + minute));
    }


    @DisplayName("UNH+312427+IFTMIN:D:04A:UN:BIG14 checks.")
    @Test
    public void test21() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        int shipmentIdFromShipmentsRequest = bringParcelPojoShipments.getShipmentId();
        System.out.println("shipmentIdFromShipmentsRequest = " + shipmentIdFromShipmentsRequest);

        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);

        Response responseConveyances = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(objectShipmentIdFromShipmentsRequest)
                .when()
                .post("/conveyances/confirm");
        BringParcelPojo bringParcelPojoConveyances = responseConveyances.as(BringParcelPojo.class);
        String encodedStringFromPostmanConveyances = bringParcelPojoConveyances.getDocuments().get(0).getContent();
        byte[] decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        String decodedStringConveyances = new String(decodedBytesConveyances);

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        System.out.println("decodeArrList.get(2) = " + decodeArrList.get(2));
        assertThat(decodeArrList.get(2), is(equalTo("UNH+" + bringParcelPojoShipments.getShipmentId() + "+IFTMIN:D:04A:UN:BIG14")));

    }


    @DisplayName("BGM+610+20211222141626282+9 checks.")
    @Test
    public void test22() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        int shipmentIdFromShipmentsRequest = bringParcelPojoShipments.getShipmentId();
        System.out.println("shipmentIdFromShipmentsRequest = " + shipmentIdFromShipmentsRequest);
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);

        Response responseConveyances = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(objectShipmentIdFromShipmentsRequest)
                .when()
                .post("/conveyances/confirm");
        BringParcelPojo bringParcelPojoConveyances = responseConveyances.as(BringParcelPojo.class);
        String encodedStringFromPostmanConveyances = bringParcelPojoConveyances.getDocuments().get(0).getContent();
        byte[] decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        String decodedStringConveyances = new String(decodedBytesConveyances);

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        String month = date1.substring(0, 2);
        String day = date1.substring(3, 5);
        int year = Integer.parseInt(date1.substring(6, 10));
        int century = (year / 100) + 1;
        int hour = Integer.parseInt(date1.substring(11, 13)) + 5;
        String minute = date1.substring(14, 16);
        String second = date1.substring(17, 19);

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        System.out.println("decodeArrList.get(3) = " + decodeArrList.get(3));

        assertThat(decodeArrList.get(3).toString(), containsString("BGM+610+" + year + month + day + hour + minute));
        assertThat(decodeArrList.get(3).toString(), containsString("+9"));

    }


    @DisplayName("DTM+137:202112221416:203 checks.")
    @Test
    public void test23() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);


        int shipmentIdFromShipmentsRequest = bringParcelPojoShipments.getShipmentId();
        System.out.println("shipmentIdFromShipmentsRequest = " + shipmentIdFromShipmentsRequest);
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);

        Response responseConveyances = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(objectShipmentIdFromShipmentsRequest)
                .when()
                .post("/conveyances/confirm");
        BringParcelPojo bringParcelPojoConveyances = responseConveyances.as(BringParcelPojo.class);
        String encodedStringFromPostmanConveyances = bringParcelPojoConveyances.getDocuments().get(0).getContent();
        byte[] decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        String decodedStringConveyances = new String(decodedBytesConveyances);

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        String month = date1.substring(0, 2);
        String day = date1.substring(3, 5);
        int year = Integer.parseInt(date1.substring(6, 10));
        int century = (year / 100) + 1;
        int hour = Integer.parseInt(date1.substring(11, 13)) + 5;
        String minute = date1.substring(14, 16);
        String second = date1.substring(17, 19);

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        System.out.println("decodeArrList.get(4) = " + decodeArrList.get(4));
        assertThat(decodeArrList.get(4).toString(), containsString("DTM+137:" + year + month + day + hour + minute + ":203"));

    }


    @DisplayName("DTM+234:20211222:102 checks.")
    @Test
    public void test24() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        int shipmentIdFromShipmentsRequest = bringParcelPojoShipments.getShipmentId();
        System.out.println("shipmentIdFromShipmentsRequest = " + shipmentIdFromShipmentsRequest);
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);

        Response responseConveyances = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(objectShipmentIdFromShipmentsRequest)
                .when()
                .post("/conveyances/confirm");
        BringParcelPojo bringParcelPojoConveyances = responseConveyances.as(BringParcelPojo.class);
        String encodedStringFromPostmanConveyances = bringParcelPojoConveyances.getDocuments().get(0).getContent();
        byte[] decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        String decodedStringConveyances = new String(decodedBytesConveyances);

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);


        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        String month = date1.substring(0, 2);
        String day = date1.substring(3, 5);
        int year = Integer.parseInt(date1.substring(6, 10));
        int century = (year / 100) + 1;
        int hour = Integer.parseInt(date1.substring(11, 13)) + 5;
        String minute = date1.substring(14, 16);
        String second = date1.substring(17, 19);

        System.out.println("decodeArrList.get(5) = " + decodeArrList.get(5));
        assertThat(decodeArrList.get(5).toString(), containsString("DTM+234:" + year + month + day + ":102"));

    }


    @DisplayName("FTX+PRD+++0330 checks.")
    @Test
    public void test25() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);
        String productIdFromLabelShipments = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT169,988^A0N,54,54^FD") + 23, decodedStringShipments.indexOf("^FT169,988^A0N,54,54^FD") + 23 + 4);
        System.out.println("productIdFromLabelShipments = " + productIdFromLabelShipments);


        int shipmentIdFromShipmentsRequest = bringParcelPojoShipments.getShipmentId();
        System.out.println("shipmentIdFromShipmentsRequest = " + shipmentIdFromShipmentsRequest);
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);

        Response responseConveyances = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(objectShipmentIdFromShipmentsRequest)
                .when()
                .post("/conveyances/confirm");
        BringParcelPojo bringParcelPojoConveyances = responseConveyances.as(BringParcelPojo.class);
        String encodedStringFromPostmanConveyances = bringParcelPojoConveyances.getDocuments().get(0).getContent();
        byte[] decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        String decodedStringConveyances = new String(decodedBytesConveyances);

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);

        System.out.println("decodeArrList.get(6) = " + decodeArrList.get(6));
        assertThat(decodeArrList.get(6).toString(), containsString("FTX+PRD+++" + productIdFromLabelShipments));

    }

    //TODO PRECISION? (weight gross or weight) (from Json or Label)
    @DisplayName("Total: 2.0, PRECISION (!) - CNT+7:2.0:KGM checks.")
    @Test
    public void test26() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);
        System.out.println("bringParcelPojoShipments.getShippingUnits().get(0).getGrossWeight() = " + bringParcelPojoShipments.getShippingUnits().get(0).getGrossWeight());


        int shipmentIdFromShipmentsRequest = bringParcelPojoShipments.getShipmentId();
        System.out.println("shipmentIdFromShipmentsRequest = " + shipmentIdFromShipmentsRequest);
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);

        Response responseConveyances = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(objectShipmentIdFromShipmentsRequest)
                .when()
                .post("/conveyances/confirm");
        BringParcelPojo bringParcelPojoConveyances = responseConveyances.as(BringParcelPojo.class);
        String encodedStringFromPostmanConveyances = bringParcelPojoConveyances.getDocuments().get(0).getContent();
        byte[] decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        String decodedStringConveyances = new String(decodedBytesConveyances);

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);

        System.out.println("decodeArrList.get(7) = " + decodeArrList.get(7));
        assertThat(decodeArrList.get(7).toString(), containsString("CNT+7:" + bringParcelPojoShipments.getShippingUnits().get(0).getGrossWeight() + ":KGM"));

    }

    //TODO (total packages from Json or Label )
    @DisplayName("Total packages 1, CNT+11:1:PCE checks.")
    @Test
    public void test27() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);
        System.out.println("bringParcelPojoShipments.getShippingUnits().get(0).getIndex() = " + bringParcelPojoShipments.getShippingUnits().get(0).getIndex());


        int shipmentIdFromShipmentsRequest = bringParcelPojoShipments.getShipmentId();
        System.out.println("shipmentIdFromShipmentsRequest = " + shipmentIdFromShipmentsRequest);
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);

        Response responseConveyances = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(objectShipmentIdFromShipmentsRequest)
                .when()
                .post("/conveyances/confirm");
        BringParcelPojo bringParcelPojoConveyances = responseConveyances.as(BringParcelPojo.class);
        String encodedStringFromPostmanConveyances = bringParcelPojoConveyances.getDocuments().get(0).getContent();
        byte[] decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        String decodedStringConveyances = new String(decodedBytesConveyances);

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);

        System.out.println("decodeArrList.get(8) = " + decodeArrList.get(8));
        assertThat(decodeArrList.get(8).toString(), containsString("CNT+11:" + bringParcelPojoShipments.getShippingUnits().get(0).getIndex() + ":PCE"));

    }


    @DisplayName("Total volume 13.36, CNT+15:0.00001336:MTQ checks.")
    @Test
    public void test28() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);

        Double totalVolume = bringParcelPojoShipments.getVolume() / 1000000;
        System.out.println(String.format("%.8f", totalVolume));

        int shipmentIdFromShipmentsRequest = bringParcelPojoShipments.getShipmentId();
        System.out.println("shipmentIdFromShipmentsRequest = " + shipmentIdFromShipmentsRequest);
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);

        Response responseConveyances = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(objectShipmentIdFromShipmentsRequest)
                .when()
                .post("/conveyances/confirm");
        BringParcelPojo bringParcelPojoConveyances = responseConveyances.as(BringParcelPojo.class);
        String encodedStringFromPostmanConveyances = bringParcelPojoConveyances.getDocuments().get(0).getContent();
        byte[] decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        String decodedStringConveyances = new String(decodedBytesConveyances);

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);

        System.out.println("decodeArrList.get(9) = " + decodeArrList.get(9));
        assertThat(decodeArrList.get(9).toString(), containsString("CNT+15:" + String.format("%.8f", totalVolume) + ":MTQ"));

    }

    @DisplayName("RFF+CU:s.ShipperRef checks.")
    @Test
    public void test29() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);
        System.out.println("bringParcelPojoShipments.getShipperRef() = " + bringParcelPojoShipments.getShipperRef());


        int shipmentIdFromShipmentsRequest = bringParcelPojoShipments.getShipmentId();
        System.out.println("shipmentIdFromShipmentsRequest = " + shipmentIdFromShipmentsRequest);
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);

        Response responseConveyances = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(objectShipmentIdFromShipmentsRequest)
                .when()
                .post("/conveyances/confirm");
        BringParcelPojo bringParcelPojoConveyances = responseConveyances.as(BringParcelPojo.class);
        String encodedStringFromPostmanConveyances = bringParcelPojoConveyances.getDocuments().get(0).getContent();
        byte[] decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        String decodedStringConveyances = new String(decodedBytesConveyances);

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);

        System.out.println("decodeArrList.get(10) = " + decodeArrList.get(10));
        assertThat(decodeArrList.get(10).toString(), containsString("RFF+CU:" + bringParcelPojoShipments.getShipperRef()));

    }


    @DisplayName("RFF+SRN:12345670000020662 checks.")
    @Test
    public void test30() {

        String requestJsonBodyShipments = "{\n" +
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


        Response responseShipments = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestJsonBodyShipments)
                .when()
                .post("/shipments/label");

        BringParcelPojo bringParcelPojoShipments = responseShipments.as(BringParcelPojo.class);
        String encodedStringFromPostmanShipments = bringParcelPojoShipments.getDocuments().get(0).getContent();
        byte[] decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        String decodedStringShipments = new String(decodedBytesShipments);
        System.out.println("bringParcelPojoShipments.getForwarderRef() = " + bringParcelPojoShipments.getForwarderRef());

        int shipmentIdFromShipmentsRequest = bringParcelPojoShipments.getShipmentId();
        System.out.println("shipmentIdFromShipmentsRequest = " + shipmentIdFromShipmentsRequest);
        JSONObject objectShipmentIdFromShipmentsRequest = new JSONObject();
        JSONArray array = new JSONArray();
        objectShipmentIdFromShipmentsRequest.put("Shipments", array);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("ShipmentId", shipmentIdFromShipmentsRequest);
        array.add(map);

        Response responseConveyances = given().header("Shipper-Code", "CEVA")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(objectShipmentIdFromShipmentsRequest)
                .when()
                .post("/conveyances/confirm");
        BringParcelPojo bringParcelPojoConveyances = responseConveyances.as(BringParcelPojo.class);
        String encodedStringFromPostmanConveyances = bringParcelPojoConveyances.getDocuments().get(0).getContent();
        byte[] decodedBytesConveyances = Base64.getDecoder().decode(encodedStringFromPostmanConveyances);
        String decodedStringConveyances = new String(decodedBytesConveyances);

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        System.out.println("decodeArrList.get(11) = " + decodeArrList.get(11));
        assertThat(decodeArrList.get(11).toString(), containsString("RFF+SRN:" + bringParcelPojoShipments.getForwarderRef()));

    }


}




