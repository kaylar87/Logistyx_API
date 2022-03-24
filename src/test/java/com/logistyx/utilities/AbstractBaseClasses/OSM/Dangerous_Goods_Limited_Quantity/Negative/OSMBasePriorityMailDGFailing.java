package com.logistyx.utilities.AbstractBaseClasses.OSM.Dangerous_Goods_Limited_Quantity.Negative;


import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public abstract class OSMBasePriorityMailDGFailing {

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
                "    \"ProjectCode\": \"LX_CHICAGO\",\n" +
                "    \"ForwarderDivisionCode\": \"OSM\",\n" +
                "    \"ForwarderServiceCode\": \"OSM-PRIORITY-MAIL\",\n" +
                "    \"ShipperRef\": \"Shipper Reference\",\n" +
                "    \"ReceiverRef\": \"Receiver Reference\",\n" +
                "    \"Addresses\": [\n" +
                "        {\n" +
                "            \"Reference\": \"LOWE'S COMPANIES, INC.\",\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"15 Main St\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"53534\",\n" +
                "            \"LocalityName\": \"Edgerton\",\n" +
                "            \"SubdivisionCode\": \"WI\",\n" +
                "            \"SubdivisionName\": \"Wisconsin\",\n" +
                "            \"CountryCode\": \"US\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"Name\": \"LOWE'S COMPANIES, INC.\",\n" +
                "                    \"EmailAddress\": \"\",\n" +
                "                    \"PhoneNumber\": \"555-555-5555\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Residential\": false,\n" +
                "            \"AddressTypes\": [\n" +
                "                {\n" +
                "                    \"AddressTypeCode\": \"DELIVERY\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Reference\": \"GEN_BERLIN\",\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"745 E Knopf Rd\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"54923\",\n" +
                "            \"LocalityName\": \"Berlin\",\n" +
                "            \"SubdivisionCode\": \"WI\",\n" +
                "            \"SubdivisionName\": \"Wisconsin\",\n" +
                "            \"CountryCode\": \"US\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"ContactTypeCode\": \"PICKUP\",\n" +
                "                    \"Name\": \"Logistics@Generac.com\",\n" +
                "                    \"PhoneNumber\": \"262-544-4811\"\n" +
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
                "    \"FreightPayer\": \"SHIPPER\",\n" +
                "    \"ShippingUnits\": [\n" +
                "        {\n" +
                "            \"ShipperRef\": \"99000018364\",\n" +
                "            \"Length\": 10.0,\n" +
                "            \"Width\": 10.0,\n" +
                "            \"Height\": 10.0,\n" +
                "            \"DimensionsUnitOfMeasure\": \"IN\",\n" +
                "            \"VolumeUnitOfMeasure\": \"IN3\",\n" +
                "            \"PackageType\": \"ZZ\",\n" +
                "            \"GrossWeight\": 5.86,\n" +
                "            \"GrossWeightUnitOfMeasure\": \"LB\",\n" +
                "            \"Content\": \"Widget. Widget\",\n" +
                "            \"Remark\": \"Does not apply on materials regulated by the U.S. Department of Transportation as hazardous and required tobear a Hazard Class or Hazard Division label. For classes applicable to such hazardous materials, see provisionselsewhere inthis Classification.\",\n" +
                "            \"NumberOfShippingUnitItems\": 1,\n" +
                "            \"ShippingUnitItems\": [\n" +
                "                {\n" +
                "                    \"ForwarderRef\": 9999999999,\n" +
                "                    \"Value\": 1.0,\n" +
                "                    \"ValueCurrencyCode\": \"USD\",\n" +
                "                    \"Quantity\": 2,\n" +
                "                    \"QuantityUnitOfMeasure\": \"PCS\",\n" +
                "                    \"Weight\": 1.33,\n" +
                "                    \"WeightUnitOfMeasure\": \"LB\",\n" +
                "                    \"Description\": \"COLD WEATHER KIT A/C HSB\",\n" +
                "                    \"CountryOfOrigin\": \"US\",\n" +
                "                    \"HarmonisedSystemCode\": \"8516808000\",\n" +
                "                    \"ProductCode\": \"G0062120\",\n" +
                "                    \"Fragile\": false,\n" +
                "                    \"Liquids\": false,\n" +
                "                    \"DangerousGoods\": [\n" +
                "                        {\n" +
                "                            \"LimitedQuantity\": true,\n" +
                "                            \"ReportableQuantity\": false,\n" +
                "                            \"ExceptedQuantity\": false,\n" +
                "                            \"HazardousMaterialIdentificationNumber\": \"UN1991\",\n" +
                "                            \"ClassIdDivisionCompatibilityGroup\": \"3\",\n" +
                "                            \"Weight\": 2.3,\n" +
                "                            \"WeightUnitOfMeasure\": \"LB\",\n" +
                "                            \"TechnicalName\": \"STOMAHESIVE PASTE\",\n" +
                "                            \"ProperShippingName\": \"Flammable liquid, n.o.s\",\n" +
                "                            \"SpecialProvisions\": [\n" +
                "                                \"DOT-SP 21015\"\n" +
                "                            ]\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"ValueCurrencyCode\": \"USD\",\n" +
                "    \"RequestedPickupDateTime\": \"2022-02-01T12:03:00\",\n" +
                "    \"ServiceLevelAgreementDeliveryDateTime\": \"2022-02-07T00:00:00Z\",\n" +
                "    \"ExpectedDeliveryDateTime\": \"2022-02-07T00:00:00Z\"\n" +
                "}";


        requestSpecShipments = given().header("Shipper-Code", "LBI")
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