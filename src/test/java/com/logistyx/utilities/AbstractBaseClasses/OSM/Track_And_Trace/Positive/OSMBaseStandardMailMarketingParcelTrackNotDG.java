package com.logistyx.utilities.AbstractBaseClasses.OSM.Track_And_Trace.Positive;


import com.logistyx.pojo.osm.OSMPojo;
import com.logistyx.utilities.ExcelUtil;
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
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

import static io.restassured.RestAssured.*;

public abstract class OSMBaseStandardMailMarketingParcelTrackNotDG {

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

    public static String trackAndTrace;


    @BeforeAll
    public static void init() {
        baseURI = "https://as-cdt-dev-logistyx-qa1-docs.azurewebsites.net";
    }

    @Test
    public static void shipmentsLabel() {

        requestJsonBodyShipments = "{\n" +
                "    \"ProjectCode\": \"LX_CHICAGO\",\n" +
                "    \"ForwarderDivisionCode\": \"OSM\",\n" +
                "    \"ForwarderServiceCode\": \"OSM-STD-MAIL-MP\",\n" +
                "    \"ShipperRef\": \"Shipper Reference\",\n" +
                "    \"ReceiverRef\": \"Receiver Reference\",\n" +
                "    \"ForwarderServiceIndicators\": \n" +
                "    \t{\n" +
                "        \"TrackAndTrace\": true\n" +
                "        },\n" +
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
                "            \"GrossWeight\": 0.86,\n" +
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
                "                    \"Liquids\": false\n" +
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

        checkString = osmPojoShipments.getShippingUnits().get(0).getForwarderRef().substring(8, 29);
        int evenSum = 0;
        int oddSum = 0;
        if (checkString.length() != 21) {
            throw new IllegalArgumentException("Data length must be 17 to calculate SSCC-18 check digit.");
        } else {
            for (int i = 0; i < checkString.length(); i++) {
                if ((i + 1) % 2 == 0) {
                    evenSum += Integer.parseInt(String.valueOf(checkString.charAt(i)));
                } else {
                    oddSum += Integer.parseInt(String.valueOf(checkString.charAt(i)));
                }
            }
//            if checkdigit is 10 use 0, otherwise use checkdigit dynamic value
            if ((10 - ((evenSum + (oddSum * 3)) % 10)) == 10) {
                checkDigit = 0;
            } else {
                checkDigit = 10 - ((evenSum + (oddSum * 3)) % 10);
            }
        }

        int shipmentIdFromShipmentsRequest = osmPojoShipments.getShipmentId();
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
        osmPojoConveyances = validateResponseConveyances.extract().as(OSMPojo.class);
        encodedStringFromPostmanConveyances = osmPojoConveyances.getDocuments().get(0).getContent();
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

        dateTimeUTC = OffsetDateTime.now(ZoneOffset.UTC);
        //    System.out.println(dateTimeUTC);
        monthUTC = date1.substring(0, 2);
        dayUTC = date1.substring(3, 5);
        yearUTC = Integer.parseInt(date1.substring(6, 10));
        centuryUTC = (yearUTC / 100) + 1;
        hourUTC = Integer.parseInt(date1.substring(11, 13)) + 5;
        minuteUTC = date1.substring(14, 16);
        secondUTC = date1.substring(17, 19);

        currentDateTimeUTC = yearUTC + "-" + monthUTC + "-" + dayUTC + "T" + hourUTC + ":" + minuteUTC + ":" + secondUTC + "Z";
        currentDateTime = year + "-" + month + "-" + day + "T" + hour + ":" + minute + ":" + second + "Z";

        carrierServiceLValueFromJsonMap = new LinkedHashMap<>();
        carrierServiceFromJson = osmPojoShipments.getForwarderServiceCode();
        switch (carrierServiceFromJson) {
            case "OSM-FIRST-CLASS-MAIL":
                carrierServiceLValueFromJsonMap.put("OSM-FIRST-CLASS-MAIL", "F");
                break;
            case "OSM-PRIORITY-MAIL":
                carrierServiceLValueFromJsonMap.put("OSM-PRIORITY-MAIL", "P");
                break;
        }

        carrierServiceE1ValueFromJsonMap = new LinkedHashMap<>();
        carrierServiceFromJson = osmPojoShipments.getForwarderServiceCode();
        switch (carrierServiceFromJson) {
            case "OSM-FIRST-CLASS-MAIL":
                carrierServiceE1ValueFromJsonMap.put("OSM-FIRST-CLASS-MAIL", "FIRST-CLASS PKG");
                break;
            case "OSM-PRIORITY-MAIL":
                carrierServiceE1ValueFromJsonMap.put("OSM-PRIORITY-MAIL", "PRIORITY MAIL");
                break;
            case "OSM-BP-MATTER":
                carrierServiceE1ValueFromJsonMap.put("OSM-BP-MATTER", "PRSRT BPM");
                break;
            case "OSM-MEDIA-MAIL":
                carrierServiceE1ValueFromJsonMap.put("OSM-MEDIA-MAIL", "PRSRT MEDIA MAIL");
                break;
            case "OSM-PARCEL-SELECT":
                carrierServiceE1ValueFromJsonMap.put("OSM-PARCEL-SELECT", "PARCEL SELECT");
                break;
            case "OSM-STD-MAIL-MP":
                carrierServiceE1ValueFromJsonMap.put("OSM-STD-MAIL-MP", "PRSRT STD");
                break;
            case "OSM-PARCEL-SELECT-LW":
                carrierServiceE1ValueFromJsonMap.put("OSM-PARCEL-SELECT-LW", "PS LIGHTWEIGHT");
                break;
        }

        carrierServiceE2ValueFromJsonMap = new LinkedHashMap<>();
        carrierServiceFromJson = osmPojoShipments.getForwarderServiceCode();
        if (requestJsonBodyShipments.contains("TrackAndTrace")) {
            trackAndTrace = String.valueOf(osmPojoShipments.getForwarderServiceIndicators().getTrackAndTrace());
            if (trackAndTrace == "true") {
                switch (carrierServiceFromJson) {
                    case "OSM-BP-MATTER":
                        carrierServiceE2ValueFromJsonMap.put("OSM-BP-MATTER", "U.S POSTAGE AND FEES PAID");
                        break;
                    case "OSM-MEDIA-MAIL":
                        carrierServiceE2ValueFromJsonMap.put("OSM-MEDIA-MAIL", "U.S POSTAGE AND FEES PAID");
                        break;
                    case "OSM-PARCEL-SELECT":
                        carrierServiceE2ValueFromJsonMap.put("OSM-PARCEL-SELECT", "U.S POSTAGE AND FEES PAID");
                        break;
                    case "OSM-STD-MAIL-MP":
                        carrierServiceE2ValueFromJsonMap.put("OSM-STD-MAIL-MP", "U.S POSTAGE AND FEES PAID");
                        break;
                    case "OSM-PARCEL-SELECT-LW":
                        carrierServiceE2ValueFromJsonMap.put("OSM-PARCEL-SELECT-LW", "U.S POSTAGE AND FEES PAID");
                        break;
                }
            } else if (trackAndTrace == "false") {
                switch (carrierServiceFromJson) {
                    case "OSM-FIRST-CLASS-MAIL":
                        carrierServiceE2ValueFromJsonMap.put("OSM-FIRST-CLASS-MAIL", "U.S POSTAGE PAID");
                        break;
                    case "OSM-PRIORITY-MAIL":
                        carrierServiceE2ValueFromJsonMap.put("OSM-PRIORITY-MAIL", "U.S POSTAGE PAID");
                        break;
                    case "OSM-MEDIA-MAIL":
                        carrierServiceE2ValueFromJsonMap.put("OSM-MEDIA-MAIL", "U.S POSTAGE PAID");
                        break;
                    case "OSM-STD-MAIL-MP":
                        carrierServiceE2ValueFromJsonMap.put("OSM-STD-MAIL-MP", "U.S POSTAGE PAID");
                        break;
                }
            }
        } else {
            switch (carrierServiceFromJson) {
                case "OSM-FIRST-CLASS-MAIL":
                    carrierServiceE2ValueFromJsonMap.put("OSM-FIRST-CLASS-MAIL", "U.S POSTAGE PAID");
                    break;
                case "OSM-PRIORITY-MAIL":
                    carrierServiceE2ValueFromJsonMap.put("OSM-PRIORITY-MAIL", "U.S POSTAGE PAID");
                    break;
                case "OSM-BP-MATTER":
                    carrierServiceE2ValueFromJsonMap.put("OSM-BP-MATTER", "U.S POSTAGE AND FEES PAID");
                    break;
                case "OSM-MEDIA-MAIL":
                    carrierServiceE2ValueFromJsonMap.put("OSM-MEDIA-MAIL", "U.S POSTAGE PAID");
                    break;
                case "OSM-PARCEL-SELECT":
                    carrierServiceE2ValueFromJsonMap.put("OSM-PARCEL-SELECT", "U.S POSTAGE AND FEES PAID");
                    break;
                case "OSM-STD-MAIL-MP":
                    carrierServiceE2ValueFromJsonMap.put("OSM-STD-MAIL-MP", "U.S POSTAGE PAID");
                    break;
                case "OSM-PARCEL-SELECT-LW":
                    carrierServiceE2ValueFromJsonMap.put("OSM-PARCEL-SELECT-LW", "U.S POSTAGE AND FEES PAID");
                    break;
            }
        }


        carrierServiceMCValueFromJsonMap = new LinkedHashMap<>();
        carrierServiceFromJson = osmPojoShipments.getForwarderServiceCode();
        switch (carrierServiceFromJson) {
            case "OSM-FIRST-CLASS-MAIL":
                carrierServiceMCValueFromJsonMap.put("OSM-FIRST-CLASS-MAIL", "FC");
                break;
            case "OSM-PRIORITY-MAIL":
                carrierServiceMCValueFromJsonMap.put("OSM-PRIORITY-MAIL", "PM");
                break;
            case "OSM-BP-MATTER":
                carrierServiceMCValueFromJsonMap.put("OSM-BP-MATTER", "BP");
                break;
            case "OSM-MEDIA-MAIL":
                carrierServiceMCValueFromJsonMap.put("OSM-MEDIA-MAIL", "MM");
                break;
            case "OSM-PARCEL-SELECT":
                carrierServiceMCValueFromJsonMap.put("OSM-PARCEL-SELECT", "PS");
                break;
            case "OSM-STD-MAIL-MP":
                carrierServiceMCValueFromJsonMap.put("OSM-STD-MAIL-MP", "MP");
                break;
            case "OSM-PARCEL-SELECT-LW":
                carrierServiceMCValueFromJsonMap.put("OSM-PARCEL-SELECT-LW", "LW");
                break;
        }

        carrierServiceSTCValueFromJsonMap = new LinkedHashMap<>();
        carrierServiceFromJson = osmPojoShipments.getForwarderServiceCode();
        if (requestJsonBodyShipments.contains("TrackAndTrace")) {
            trackAndTrace = String.valueOf(osmPojoShipments.getForwarderServiceIndicators().getTrackAndTrace());
            if (trackAndTrace == "true") {
                switch (carrierServiceFromJson) {
                    case "OSM-BP-MATTER":
                        carrierServiceSTCValueFromJsonMap.put("OSM-BP-MATTER", "419");
                        break;
                    case "OSM-MEDIA-MAIL":
                        carrierServiceSTCValueFromJsonMap.put("OSM-MEDIA-MAIL", "490");
                        break;
                    case "OSM-PARCEL-SELECT":
                        carrierServiceSTCValueFromJsonMap.put("OSM-PARCEL-SELECT", "612");
                        break;
                    case "OSM-STD-MAIL-MP":
                        carrierServiceSTCValueFromJsonMap.put("OSM-STD-MAIL-MP", "704");
                        break;
                    case "OSM-PARCEL-SELECT-LW":
                        carrierServiceSTCValueFromJsonMap.put("OSM-PARCEL-SELECT-LW", "748");
                        break;
                    case "OSM-GLOBAL-PRIO":
                        carrierServiceSTCValueFromJsonMap.put("OSM-GLOBAL-PRIO", "002");
                        break;
                    case "OSM-GLOBAL-PRIO-EPKT":
                        carrierServiceSTCValueFromJsonMap.put("OSM-GLOBAL-PRIO-EPKT", "003");
                        break;
                    case "OSM-GLOBAL-PRIO-PRCL":
                        carrierServiceSTCValueFromJsonMap.put("OSM-GLOBAL-PRIO-PRCL", "004");
                        break;
                }
            } else if (trackAndTrace == "false") {
                switch (carrierServiceFromJson) {
                    case "OSM-FIRST-CLASS-MAIL":
                        carrierServiceSTCValueFromJsonMap.put("OSM-FIRST-CLASS-MAIL", "001");
                        break;
                    case "OSM-PRIORITY-MAIL":
                        carrierServiceSTCValueFromJsonMap.put("OSM-PRIORITY-MAIL", "055");
                        break;
                    case "OSM-MEDIA-MAIL":
                        carrierServiceSTCValueFromJsonMap.put("OSM-MEDIA-MAIL", "521");
                        break;
                    case "OSM-STD-MAIL-MP":
                        carrierServiceSTCValueFromJsonMap.put("OSM-STD-MAIL-MP", "703");
                        break;
                    case "OSM-GLOBAL-STANDARD":
                        carrierServiceSTCValueFromJsonMap.put("OSM-GLOBAL-STANDARD", "001");
                        break;
                }
            }
        } else {
            switch (carrierServiceFromJson) {
                case "OSM-FIRST-CLASS-MAIL":
                    carrierServiceSTCValueFromJsonMap.put("OSM-FIRST-CLASS-MAIL", "001");
                    break;
                case "OSM-PRIORITY-MAIL":
                    carrierServiceSTCValueFromJsonMap.put("OSM-PRIORITY-MAIL", "055");
                    break;
                case "OSM-BP-MATTER":
                    carrierServiceSTCValueFromJsonMap.put("OSM-BP-MATTER", "419");
                    break;
                case "OSM-MEDIA-MAIL":
                    carrierServiceSTCValueFromJsonMap.put("OSM-MEDIA-MAIL", "521");
                    break;
                case "OSM-PARCEL-SELECT":
                    carrierServiceSTCValueFromJsonMap.put("OSM-PARCEL-SELECT", "612");
                    break;
                case "OSM-STD-MAIL-MP":
                    carrierServiceSTCValueFromJsonMap.put("OSM-STD-MAIL-MP", "703");
                    break;
                case "OSM-PARCEL-SELECT-LW":
                    carrierServiceSTCValueFromJsonMap.put("OSM-PARCEL-SELECT-LW", "748");
                    break;
                case "OSM-GLOBAL-STANDARD":
                    carrierServiceSTCValueFromJsonMap.put("OSM-GLOBAL-STANDARD", "001");
                    break;
                case "OSM-GLOBAL-PRIO":
                    carrierServiceSTCValueFromJsonMap.put("OSM-GLOBAL-PRIO", "002");
                    break;
                case "OSM-GLOBAL-PRIO-EPKT":
                    carrierServiceSTCValueFromJsonMap.put("OSM-GLOBAL-PRIO-EPKT", "003");
                    break;
                case "OSM-GLOBAL-PRIO-PRCL":
                    carrierServiceSTCValueFromJsonMap.put("OSM-GLOBAL-PRIO-PRCL", "004");
                    break;
            }
        }

        ExcelUtil SortCodesFile = new ExcelUtil("src/test/resources/OSM_SortCodes.xlsx", "OSM_SortCodes");
        List<Map<String, String>> dataList = SortCodesFile.getDataList();
        Map<String, String> sortCodesMap;
        double deliveryZipCodeFromJson = Double.parseDouble(osmPojoShipments.getDeliveryAddress().getPostalCode());
        //    System.out.println("deliveryZipCodeFromJson = " + deliveryZipCodeFromJson);
        String deliveryZipCodeFromJsonConverted = String.valueOf(deliveryZipCodeFromJson);
        //    System.out.println("deliveryZipCodeFromJsonConverted = " + deliveryZipCodeFromJsonConverted);
        for (Map<String, String> rowmap : dataList) {
            if (rowmap.containsValue(deliveryZipCodeFromJsonConverted)) {
                sortCodesMap = rowmap;
                sortCode1 = sortCodesMap.get("Sort Code 1");
                sortCode2 = sortCodesMap.get("Sort Code 2");
                sortCode4 = sortCodesMap.get("Sort Code 4");
                //    System.out.println("sortCode1 = " + sortCode1);
            }
        }

        String[] decodeArrDomestic = decodedStringConveyances.split("\r\n");
        decodeArrListDomestic = Arrays.asList(decodeArrDomestic);

        Object a = decodeArrListDomestic.get(0);
        decodedHeadersDomestic = new ArrayList<>();
        //    System.out.println("a = " + a);
        for (String s : a.toString().split("\",\"")) {
            decodedHeadersDomestic.add(s);
        }
        Object b = decodeArrListDomestic.get(1);
        decodedValuesDomestic = new ArrayList<>();
        //    System.out.println("b = " + b);
        for (String s : b.toString().split("\",\"")) {
            decodedValuesDomestic.add(s);
        }

//        if (requestJsonBodyShipments.contains("TrackAndTrace")) {
//            trackAndTrace = String.valueOf(osmPojoShipments.getForwarderServiceIndicators().getTrackAndTrace());
//            if (trackAndTrace == "true") {
//                System.out.println(1);
//            } else if (trackAndTrace == "false") {
//                System.out.println("2 = " + 2);
//            }
//        } else {
//            System.out.println("3 = " + 3);
//        }

//        carrierServiceE1ValueFromJsonMap = new LinkedHashMap<>();
//        carrierServiceFromJson = osmPojoShipments.getForwarderServiceCode();
//        switch (carrierServiceFromJson) {
//            case "OSM-FIRST-CLASS-MAIL":
//                carrierServiceE1ValueFromJsonMap.put("OSM-FIRST-CLASS-MAIL", "FIRST-CLASS PKG");
//                break;
//            case "OSM-PRIORITY-MAIL":
//                carrierServiceE1ValueFromJsonMap.put("OSM-PRIORITY-MAIL", "PRIORITY MAIL");
//                break;
//            case "OSM-BP-MATTER":
//                carrierServiceE1ValueFromJsonMap.put("OSM-BP-MATTER", "PRSRT BPM");
//                break;
//            case "OSM-MEDIA-MAIL":
//                carrierServiceE1ValueFromJsonMap.put("OSM-MEDIA-MAIL", "PRSRT MEDIA MAIL");
//                break;
//            case "OSM-PARCEL-SELECT":
//                carrierServiceE1ValueFromJsonMap.put("OSM-PARCEL-SELECT", "PARCEL SELECT");
//                break;
//            case "OSM-STD-MAIL-MP":
//                carrierServiceE1ValueFromJsonMap.put("OSM-STD-MAIL-MP", "PRSRT STD");
//                break;
//            case "OSM-PARCEL-SELECT-LW":
//                carrierServiceE1ValueFromJsonMap.put("OSM-PARCEL-SELECT-LW", "PS LIGHTWEIGHT");
//                break;
//            case "OSM-GLOBAL-STANDARD":
//                carrierServiceE1ValueFromJsonMap.put("OSM-GLOBAL-STANDARD", "CHEP EURO");
//                break;
//            case "OSM-GLOBAL-PRIO":
//                carrierServiceE1ValueFromJsonMap.put("OSM-GLOBAL-PRIO", "DUSS");
//                break;
//            case "OSM-GLOBAL-PRIO-EPKT":
//                carrierServiceE1ValueFromJsonMap.put("OSM-GLOBAL-PRIO-EPKT", "COLLI");
//                break;
//            case "OSM-GLOBAL-PRIO-PRCL":
//                carrierServiceE1ValueFromJsonMap.put("OSM-GLOBAL-PRIO-PRCL", "PAK");
//                break;
//
//        }
    }
}