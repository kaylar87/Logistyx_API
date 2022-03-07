package com.logistyx.utilities.AbstractBaseClasses.OSM;


import com.logistyx.pojo.osm.OSMPojo;
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

public abstract class OSMBaseNotDG {

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
    public static List decodeArrList;


    @BeforeAll
    public static void init() {
        baseURI = "https://as-cdt-dev-logistyx-qa1-docs.azurewebsites.net";
    }

    @Test
    public static void shipmentsLabel() {

        requestJsonBodyShipments = "{\n" +
                "\t\"ShippingId\": 0,\n" +
                "\t\"ShipperCode\": \"LBI\",\n" +
                "\t\"ShippingTypeCode\": null,\n" +
                "\t\"ProjectCode\": \"LX_CHICAGO\",\n" +
                "\t\"ForwarderDivisionCode\": \"OSM\",\n" +
                "\t\"ForwarderServiceCode\": \"OSM-PRIORITY-MAIL\",\n" +
                "\t\"ShipperRef\": \"Shipper Reference\",\n" +
                "\t\"Addresses\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"AddressId\": 0,\n" +
                "\t\t\t\"ForwarderDivisionCode\": null,\n" +
                "\t\t\t\"Reference\": \"LOWE'S COMPANIES, INC.\",\n" +
                "\t\t\t\"AddressLines\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"Index\": 1,\n" +
                "\t\t\t\t\t\"Value\": \"15 Main St\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"AddressId\": 0,\n" +
                "\t\t\t\t\t\"Index\": 2,\n" +
                "\t\t\t\t\t\"Value\": \"\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"Index\": 3,\n" +
                "\t\t\t\t\t\"Value\": \"\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"PostalCode\": \"53534\",\n" +
                "\t\t\t\"LocalityName\": \"Edgerton\",\n" +
                "\t\t\t\"SubdivisionCode\": \"WI\",\n" +
                "\t\t\t\"SubdivisionName\": \"Wisconsin\",\n" +
                "\t\t\t\"CountryCode\": \"US\",\n" +
                "\t\t\t\"Contacts\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"ContactTypeCode\": \"DELIVERY\",\n" +
                "\t\t\t\t\t\"Name\": \"LOWE'S COMPANIES, INC.\",\n" +
                "\t\t\t\t\t\"EmailAddress\": \"\",\n" +
                "\t\t\t\t\t\"PhoneNumber\": \"555-555-5555\",\n" +
                "\t\t\t\t\t\"FaxNumber\": \"\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"Residential\": false,\n" +
                "\t\t\t\"AddressTypes\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"AddressTypeCode\": \"DELIVERY\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Reference\": \"LOWE ELECTRIC SUPPLY COMPANY\",\n" +
                "\t\t\t\"AddressLines\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"Index\": 1,\n" +
                "\t\t\t\t\t\"Value\": \"PO BOX 4767\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"Index\": 2,\n" +
                "\t\t\t\t\t\"Value\": \"\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"Index\": 3,\n" +
                "\t\t\t\t\t\"Value\": \"\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"PostalCode\": \"31208-4767\",\n" +
                "\t\t\t\"LocalityName\": \"MACON\",\n" +
                "\t\t\t\"SubdivisionCode\": \"GA\",\n" +
                "\t\t\t\"SubdivisionName\": \"Georgia\",\n" +
                "\t\t\t\"CountryCode\": \"US\",\n" +
                "\t\t\t\"Contacts\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"ContactTypeCode\": \"BILLING\",\n" +
                "\t\t\t\t\t\"Name\": \"LOWE ELECTRIC SUPPLY COMPANY\",\n" +
                "\t\t\t\t\t\"PhoneNumber\": \"2294239335\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"Residential\": false,\n" +
                "\t\t\t\"AddressTypes\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"AddressTypeCode\": \"BILLING\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Reference\": \"GEN_BERLIN\",\n" +
                "\t\t\t\"AddressLines\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"Index\": 1,\n" +
                "\t\t\t\t\t\"Value\": \"745 E Knopf Rd\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"Index\": 2,\n" +
                "\t\t\t\t\t\"Value\": null\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"Index\": 3,\n" +
                "\t\t\t\t\t\"Value\": null\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"PostalCode\": \"54923\",\n" +
                "\t\t\t\"LocalityName\": \"Berlin\",\n" +
                "\t\t\t\"SubdivisionCode\": \"WI\",\n" +
                "\t\t\t\"SubdivisionName\": \"Wisconsin\",\n" +
                "\t\t\t\"CountryCode\": \"US\",\n" +
                "\t\t\t\"Contacts\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"ContactTypeCode\": \"PICKUP\",\n" +
                "\t\t\t\t\t\"Name\": \"Logistics@Generac.com\",\n" +
                "\t\t\t\t\t\"PhoneNumber\": \"262-544-4811\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"ContactTypeCode\": \"HAZMAT_EMERGENCY\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"Residential\": false,\n" +
                "\t\t\t\"AddressTypes\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"AddressTypeCode\": \"PICKUP\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"FreightPayer\": \"SHIPPER\",\n" +
                "\t\"ShippingUnits\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"Index\": 0,\n" +
                "\t\t\t\"ShipperRef\": \"99000018364\",\n" +
                "\t\t\t\"AdditionalValues\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"AdditionalValueKey\": \"BOL_DESCRIPTION\",\n" +
                "\t\t\t\t\t\"Value\": \"Widget\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"AdditionalValueKey\": \"INSIDE_DELIVERY\",\n" +
                "\t\t\t\t\t\"Value\": \"false\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"AdditionalValueKey\": \"INSIDE_PICKUP\",\n" +
                "\t\t\t\t\t\"Value\": \"false\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"Length\": 10.0,\n" +
                "\t\t\t\"Width\": 10.0,\n" +
                "\t\t\t\"Height\": 10.0,\n" +
                "\t\t\t\"DimensionsUnitOfMeasure\": \"IN\",\n" +
                "\t\t\t\"VolumeUnitOfMeasure\": \"IN3\",\n" +
                "\t\t\t\"PackageType\": \"ZZ\",\n" +
                "\t\t\t\"SpecificPackageType\": \"\",\n" +
                "\t\t\t\"GrossWeight\": 5.86,\n" +
                "\t\t\t\"GrossWeightUnitOfMeasure\": \"LB\",\n" +
                "\t\t\t\"Content\": \"Widget. Widget\",\n" +
                "\t\t\t\"Remark\": \"Does not apply on materials regulated by the U.S. Department of Transportation as hazardous and required tobear a Hazard Class or Hazard Division label. For classes applicable to such hazardous materials, see provisionselsewhere inthis Classification.\",\n" +
                "\t\t\t\"NumberOfShippingUnitItems\": 0,\n" +
                "\t\t\t\"ShippingUnitItems\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"Value\": 1.0,\n" +
                "\t\t\t\t\t\"ValueCurrencyCode\": \"USD\",\n" +
                "\t\t\t\t\t\"Quantity\": 2,\n" +
                "\t\t\t\t\t\"QuantityUnitOfMeasure\": \"PCS\",\n" +
                "\t\t\t\t\t\"Weight\": 1.33,\n" +
                "\t\t\t\t\t\"WeightUnitOfMeasure\": \"LB\",\n" +
                "\t\t\t\t\t\"Description\": \"COLD WEATHER KIT A/C HSB\",\n" +
                "\t\t\t\t\t\"CountryOfOrigin\": \"US\",\n" +
                "\t\t\t\t\t\"HarmonisedSystemCode\": \"8516808000\",\n" +
                "\t\t\t\t\t\"ProductCode\": \"G0062120\",\n" +
                "\t\t\t\t\t\"Fragile\": false,\n" +
                "\t\t\t\t\t\"Liquids\": false\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"ValueCurrencyCode\": \"USD\",\n" +
                "\t\"IncotermCode\": \"EXW\",\n" +
                "\t\"RequestedPickupDateTime\": \"2022-02-01T12:03:00\",\n" +
                "\t\"ServiceLevelAgreementDeliveryDateTime\": \"2022-02-07T00:00:00Z\",\n" +
                "\t\"DangerousGoodsRegulationSet\": \"NONE\",\n" +
                "\t\"ExpectedDeliveryDateTime\": \"2022-02-07T00:00:00Z\"\n" +
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

//        switch (sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeightUnitOfMeasure()) {
//            case "KG":
//            case "KG ":
//            case "KGM":
//            case "KGS":
//                weightInKilos = sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeight();
//                break;
//            case "G":
//            case "G ":
//            case "G  ":
//            case "GM":
//            case "GM ":
//            case "GR ":
//            case "GRM":
//                weightInKilos = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeight() * 0.001, 1);
//                break;
//            case "LB":
//            case "LB ":
//            case "LBR":
//            case "LBS":
//                weightInKilos = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeight() * 0.45359237, 1);
//                break;
//        }
//
//        switch (sandersFritomPojoShipments.getShippingUnits().get(0).getVolumeUnitOfMeasure()) {
//            case "MTQ":
//                volumeInCubicMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getVolume(), 8);
//                break;
//            case "CMQ":
//                volumeInCubicMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getVolume() / 1000000, 8);
//                break;
//        }
//
//        switch (sandersFritomPojoShipments.getShippingUnits().get(0).getDimensionsUnitOfMeasure()) {
//            case "M":
//                lengthInMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getLength(), 2);
//                widthInMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getLength(), 2);
//                heightInMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getLength(), 2);
//                break;
//            case "CM":
//                lengthInMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getLength() / 100, 2);
//                widthInMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getLength() / 100, 2);
//                heightInMetre = Precision.round(sandersFritomPojoShipments.getShippingUnits().get(0).getLength() / 100, 2);
//                break;
//        }
//
//        checkString = sandersFritomPojoShipments.getShippingUnits().get(0).getAdditionalValues().get(0).getValue().substring(2, 19);
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
//            if ((10 - ((evenSum + (oddSum * 3)) % 10)) == 10) {
//                checkDigit = 0;
//            } else {
//                checkDigit = 10 - ((evenSum + (oddSum * 3)) % 10);
//            }
//        }
//if checkdigit is 10 use 0, otherwise use checkdigit dynamic value


//        JsonPath jsonPath = validateResponseShipments.extract().jsonPath();
//        grossWeight = jsonPath.get("ShippingUnits.GrossWeight");
//        detectedNumberOfPackages = sandersFritomPojoShipments.getShippingUnits().size();
//        //    System.out.println("grossWeight = " + grossWeight);
//        for (int i = 0; i < detectedNumberOfPackages; i++) {
//            totalGrossWeight = (int) (totalGrossWeight + grossWeight.get(i));
//        }


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

        try {
            jsonDataEDI = XML.toJSONObject(decodedStringConveyances);
            String jsonString = jsonDataEDI.toString(4);
            //System.out.println(jsonString);
        } catch (JSONException e) {
            System.out.println(e.toString());
        }

//        puCountryFromCountryCodeFromJson = sandersFritomPojoShipments.getAddresses().get(1).getCountryCode();
//        switch (puCountryFromCountryCodeFromJson) {
//            case "NL":
//                puCountryFromCountryCodeFromJson = "Netherlands";
//                break;
//            case "IT":
//                puCountryFromCountryCodeFromJson = "Italy";
//                break;
//            case "AE":
//                puCountryFromCountryCodeFromJson = "Arabic Emirates";
//                break;
//            case "KW":
//                puCountryFromCountryCodeFromJson = "Kuwait";
//                break;
//            case "ES":
//                puCountryFromCountryCodeFromJson = "Spain";
//                break;
//            case "CH":
//                puCountryFromCountryCodeFromJson = "Switzerland";
//                break;
//            case "DE":
//                puCountryFromCountryCodeFromJson = "Germany";
//                break;
//            case "PT":
//                puCountryFromCountryCodeFromJson = "Portugal";
//                break;
//
//        }
//
//        dyCountryFromCountryCodeFromJson = sandersFritomPojoShipments.getAddresses().get(0).getCountryCode();
//        switch (dyCountryFromCountryCodeFromJson) {
//            case "NL":
//                dyCountryFromCountryCodeFromJson = "Netherlands";
//                break;
//            case "IT":
//                dyCountryFromCountryCodeFromJson = "Italy";
//                break;
//            case "AE":
//                dyCountryFromCountryCodeFromJson = "Arabic Emirates";
//                break;
//            case "KW":
//                dyCountryFromCountryCodeFromJson = "Kuwait";
//                break;
//            case "ES":
//                dyCountryFromCountryCodeFromJson = "Spain";
//                break;
//            case "CH":
//                dyCountryFromCountryCodeFromJson = "Switzerland";
//                break;
//            case "DE":
//                dyCountryFromCountryCodeFromJson = "Germany";
//                break;
//            case "PT":
//                dyCountryFromCountryCodeFromJson = "Portugal";
//                break;
//        }

//        restrictionValueFromJsonMap = new LinkedHashMap<>();
//        restrictionFromJsonList = sandersFritomPojoShipments.getForwarderServiceIndicators().getAdditionalServices();
//        for (int i = 0; i < restrictionFromJsonList.size(); i++) {
//            if (restrictionFromJsonList.get(i).equals("PICKUP_ROOF_LOAD")) {
//                restrictionValueFromJsonMap.put("PICKUP_ROOF_LOAD", "Dak");
//            } else if (restrictionFromJsonList.get(i).equals("PICKUP_HIAB")) {
//                restrictionValueFromJsonMap.put("PICKUP_HIAB", "Kraan");
//            } else if (restrictionFromJsonList.get(i).equals("PICKUP_SIDE_LOAD")) {
//                restrictionValueFromJsonMap.put("PICKUP_SIDE_LOAD", "Zijkant");
//            } else if (restrictionFromJsonList.get(i).equals("DELIVERY_ROOF_LOAD")) {
//                restrictionValueFromJsonMap.put("DELIVERY_ROOF_LOAD", "Dak");
//            }
//
//        }

//        unitcodeValueFromJsonMap = new LinkedHashMap<>();
//        unitcodeFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getPackageType();
//        switch (unitcodeFromJson) {
//            case "PB":
//                unitcodeValueFromJsonMap.put("PB", "PAL3");
//                break;
//            case "AH":
//                unitcodeValueFromJsonMap.put("AH", "PAL1");
//                break;
//            case "DG":
//                unitcodeValueFromJsonMap.put("DG", "CHEP BLOK");
//                break;
//            case "ED":
//                unitcodeValueFromJsonMap.put("ED", "IBC");
//                break;
//            case "EH":
//                unitcodeValueFromJsonMap.put("EH", "IBC EURO");
//                break;
//            case "EE":
//                unitcodeValueFromJsonMap.put("EE", "EURO");
//                break;
//            case "PE":
//                unitcodeValueFromJsonMap.put("PB", "PAL2");
//                break;
//            case "DH":
//                unitcodeValueFromJsonMap.put("DH", "CHEP EURO");
//                break;
//            case "AF":
//                unitcodeValueFromJsonMap.put("AF", "DUSS");
//                break;
//            case "CL":
//                unitcodeValueFromJsonMap.put("CL", "COLLI");
//                break;
//            case "PC":
//                unitcodeValueFromJsonMap.put("PC", "PAK");
//                break;
//            case "PK":
//                unitcodeValueFromJsonMap.put("PK", "PAK");
//                break;
//            case "IG":
//                unitcodeValueFromJsonMap.put("IG", "PAK");
//                break;
//            case "PA":
//                unitcodeValueFromJsonMap.put("PA", "PAK");
//                break;
//            case "BX":
//                unitcodeValueFromJsonMap.put("BX", "PAK");
//                break;
//            case "CT":
//                unitcodeValueFromJsonMap.put("CT", "PAK");
//                break;
//            case "CS":
//                unitcodeValueFromJsonMap.put("CS", "PAK");
//                break;
//        }
//
//
//
//        int barcode2DFromLabelStart = decodedStringShipments.indexOf("UNA:");
//        //    System.out.println("barcode2DFromLabelStart = " + barcode2DFromLabelStart);
//        int barcode2DFromLabelEnd = decodedStringShipments.indexOf("UNZ") + 13;
//        //    System.out.println("barcode2DFromLabelEnd = " + barcode2DFromLabelEnd);
//        String barcode2DFromLabel = decodedStringShipments.substring(barcode2DFromLabelStart, barcode2DFromLabelEnd);
//        //     System.out.println("barcode2DFromLabel = " + barcode2DFromLabel);
//        String[] decodeArr = barcode2DFromLabel.split("\'");
//        decodeArrList = Arrays.asList(decodeArr);
//        //    System.out.println("decodeArrList = " + decodeArrList);

    }
}