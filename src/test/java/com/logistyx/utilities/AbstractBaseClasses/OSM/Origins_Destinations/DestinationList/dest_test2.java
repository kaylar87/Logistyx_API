package com.logistyx.utilities.AbstractBaseClasses.OSM.Origins_Destinations.DestinationList;

import com.logistyx.pojo.osm.OSMPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.OffsetDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class dest_test2 {

    public static String requestJsonBodyShipments;
    public static RequestSpecification requestSpecShipments;
    public static ResponseSpecification responseSpecShipments;
    public static ValidatableResponse validateResponseShipments;
    public static OSMPojo osmPojoShipments;
    public static String encodedStringFromPostmanShipments;
    public static String decodedStringShipments;
    public static byte[] decodedBytesShipments;
    public static double weightInKilos;
    public static double volumeInCubicMetre;
    public static String checkString;
    public static int checkDigit;

    public static RequestSpecification requestSpecConveyances;
    public static ResponseSpecification responseSpecConveyances;
    public static ValidatableResponse validateResponseConveyances;
    public static OSMPojo osmPojoConveyances;
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

    public static String currentDateTimeUTC;
    public static String monthUTC;
    public static String dayUTC;
    public static int yearUTC;
    public static int centuryUTC;
    public static int hourUTC;
    public static String minuteUTC;
    public static String secondUTC;

    public static String carrierServiceFromJson;
    public static Map<String, String> carrierServiceLValueFromJsonMap;
    public static Map<String, String> carrierServiceE1ValueFromJsonMap;
    public static Map<String, String> carrierServiceE2ValueFromJsonMap;
    public static Map<String, String> carrierServiceMCValueFromJsonMap;
    public static Map<String, String> carrierServiceSTCValueFromJsonMap;
    public static String date1;
    public static String currentDateTime;
    public static OffsetDateTime dateTimeUTC;

    public static String sortCode1;
    public static String sortCode2;
    public static String sortCode4;

    public static List decodeArrListDomestic;
    public static List<String> decodedValuesDomestic;
    public static List<String> decodedHeadersDomestic;


    @BeforeAll
    public static void init1() {
        baseURI = "https://as-cdt-dev-logistyx-qa1-docs.azurewebsites.net";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/pt_2.csv", numLinesToSkip = 1)
    public void test1(String CountryCode, String CountryName, String Reference, String Address1, String PostalCode, String LocalityName, String SubdivisionCode, String Remark) {



        requestJsonBodyShipments = "{\n" +
                "    \"ProjectCode\": \"LX_CHICAGO\",\n" +
                "    \"ForwarderDivisionCode\": \"OSM\",\n" +
                "    \"ForwarderServiceCode\": \"OSM-GLOBAL-STANDARD\",\n" +
                "    \"ShipperRef\": \"Shipper Reference\",\n" +
                "    \"ReceiverRef\": \"Receiver Reference\",\n" +
                "    \"Addresses\": [\n" +
                "        {\n" +
                "            \"Reference\": \"" + Reference + "\",\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"" + Address1 + "\",\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"" + PostalCode + "\",\n" +
                "            \"LocalityName\": \"" + LocalityName + "\",\n" +
                "            \"CountryCode\": \"" + CountryCode + "\",\n" +
                "            \"SubdivisionCode\": \"" + SubdivisionCode + "\",\n" +
                "            \"SubdivisionName\": null,\n" +
                "            \"CountryName\": \"" + CountryName + "\",\n" +
                "            \"Description\": null,\n" +
                "            \"Remark\": \"" + Remark + "\",\n" +
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
                "        },\n" +
                "        {\n" +
                "            \"Reference\": \"JOHN SILVER\",\n" +
                "            \"AddressLines\": [\n" +
                "                {\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Value\": \"111 E 21st St\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"PostalCode\": \"11230\",\n" +
                "            \"LocalityName\": \"Brooklyn\",\n" +
                "            \"SubdivisionCode\": \"NY\",\n" +
                "            \"SubdivisionName\": \"New York\",\n" +
                "            \"CountryCode\": \"US\",\n" +
                "            \"Contacts\": [\n" +
                "                {\n" +
                "                    \"ContactTypeCode\": \"RETURN\",\n" +
                "                    \"Name\": \"John@Silver.com\",\n" +
                "                    \"PhoneNumber\": \"718-000-1111\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Residential\": false,\n" +
                "            \"AddressTypes\": [\n" +
                "                {\n" +
                "                    \"AddressTypeCode\": \"RETURN\"\n" +
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
                "                    \"Value\": 1.0,\n" +
                "                    \"ValueCurrencyCode\": \"USD\",\n" +
                "                    \"Quantity\": 2,\n" +
                "                    \"QuantityUnitOfMeasure\": \"PCS\",\n" +
                "                    \"Weight\": 1.33,\n" +
                "                    \"WeightUnitOfMeasure\": \"LB\",\n" +
                "                    \"Description\": \"COLD WEATHER KIT A/C HSB1\",\n" +
                "                    \"CountryOfOrigin\": \"US\",\n" +
                "                    \"HarmonisedSystemCode\": \"8516808000\",\n" +
                "                    \"ProductCode\": \"G0062120\",\n" +
                "                    \"Fragile\": false,\n" +
                "                    \"Liquids\": false,\n" +
                "                    \"AdditionalValues\": [\n" +
                "                        {\n" +
                "                            \"AdditionalValueKey\": \"CATEGORY_OF_GOODS\",\n" +
                "                            \"Value\": \"6\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"AdditionalValueKey\": \"COMMENTS\",\n" +
                "                            \"Value\": \"Something\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Value\": 2.25,\n" +
                "                    \"ValueCurrencyCode\": \"USD\",\n" +
                "                    \"Quantity\": 2,\n" +
                "                    \"QuantityUnitOfMeasure\": \"PCS\",\n" +
                "                    \"Weight\": 1.33,\n" +
                "                    \"WeightUnitOfMeasure\": \"LB\",\n" +
                "                    \"Description\": \"COLD WEATHER KIT A/C HSB2\",\n" +
                "                    \"CountryOfOrigin\": \"US\",\n" +
                "                    \"HarmonisedSystemCode\": \"8516808000\",\n" +
                "                    \"ProductCode\": \"G0062120\",\n" +
                "                    \"Fragile\": false,\n" +
                "                    \"Liquids\": false,\n" +
                "                    \"AdditionalValues\": [\n" +
                "                        {\n" +
                "                            \"AdditionalValueKey\": \"CATEGORY_OF_GOODS\",\n" +
                "                            \"Value\": \"6\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"AdditionalValueKey\": \"COMMENTS\",\n" +
                "                            \"Value\": \"Something\"\n" +
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
        responseSpecShipments = expect().statusCode(200)
                .and()
                .contentType(ContentType.JSON);
        validateResponseShipments = given().spec(requestSpecShipments)
                .when()
                .post("/shipments/label")
                .then()
                .spec(responseSpecShipments);
        osmPojoShipments = validateResponseShipments.extract().as(OSMPojo.class);
        encodedStringFromPostmanShipments = osmPojoShipments.getDocuments().get(0).getContent();
        decodedBytesShipments = Base64.getDecoder().decode(encodedStringFromPostmanShipments);
        decodedStringShipments = new String(decodedBytesShipments);


//        System.out.println("osmPojoShipments.getAddresses().get(0).getCountryCode() = " + osmPojoShipments.getAddresses().get(0).getCountryCode());
//        System.out.println("osmPojoShipments.getAddresses().get(0).getCountryName() = " + osmPojoShipments.getAddresses().get(0).getCountryName());
//        System.out.println("osmPojoShipments.getAddresses().get(0).getReference() = " + osmPojoShipments.getAddresses().get(0).getReference());
//        System.out.println("osmPojoShipments.getAddresses().get(0).getAddressLines().get(0).getValue() = " + osmPojoShipments.getAddresses().get(0).getAddressLines().get(0).getValue());
//        System.out.println("osmPojoShipments.getAddresses().get(0).getPostalCode() = " + osmPojoShipments.getAddresses().get(0).getPostalCode());
//        System.out.println("osmPojoShipments.getAddresses().get(0).getLocalityName() = " + osmPojoShipments.getAddresses().get(0).getLocalityName());
//        System.out.println("osmPojoShipments.getAddresses().get(0).getSubdivisionCode() = " + osmPojoShipments.getAddresses().get(0).getSubdivisionCode());
//        System.out.println("osmPojoShipments.getAddresses().get(0).getRemark() = " + osmPojoShipments.getAddresses().get(0).getRemark());

        assertThat(osmPojoShipments.getShipmentId(), is(notNullValue()));
        assertThat(encodedStringFromPostmanShipments, is(notNullValue()));
        assertThat(encodedStringFromPostmanShipments.length(), is(greaterThan(500)));
        System.out.println("requestJsonBodyShipments = " + requestJsonBodyShipments);
        validateResponseShipments.extract().response().prettyPrint();

    }


}
