package com.logistyx.TEST.Sanders_Fritom;


import com.logistyx.utilities.AbstractBaseClasses.All_Bring_Parcel_BNP_v303_v311.Label_And_EDI_Requests.BNP_BUS_PRCL.Weight_Cases_NL_NO_Base.BNPBaseNotDG1;
import com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom.SFBaseNotDG;
import org.apache.commons.math3.util.Precision;
import org.json.simple.JSONArray;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@DisplayName("DANIEL.1")
public class DANIEL_1 extends SFBaseNotDG {

    static {
        SFBaseNotDG.shipmentsLabel();
    }


    @DisplayName("ShippingId is not NULL")
    @Test
    public void test1() {


//        assertThat(sandersFritomPojoShipments.getShipmentId(), is(notNullValue()));
//        System.out.println("requestJsonBodyShipments = " + requestJsonBodyShipments);
//        validateResponseShipments.extract().response().prettyPrint();
//        System.out.println("decodedStringShipments = " + decodedStringShipments);
//        validateResponseConveyances.extract().response().prettyPrint();
//        System.out.println("decodedStringConveyances = " + decodedStringConveyances);
//        System.out.println("jsonDataEDI = " + jsonDataEDI);


    }


    @DisplayName("ZPL ('Documents/0/Content') is not NULL")
    @Test
    public void test2() {

        assertThat(encodedStringFromPostmanShipments, is(notNullValue()));
    }


    @DisplayName("ZPL size > 500 characters")
    @Test
    public void test3() {

        assertThat(encodedStringFromPostmanShipments.length(), is(greaterThan(500)));
    }


    @DisplayName("ZPL - PU countryCode converted to Spain")
    @Test
    public void test4() {

        //    System.out.println("puCountryFromCountryCodeFromJson = " + puCountryFromCountryCodeFromJson);
        int puCountryFromCountryCodeFromLabelStart = decodedStringShipments.indexOf("^FT686,16^A0R,23,24^FH^FD") + 25;
        String puCountryFromCountryCodeFromLabel = decodedStringShipments.substring(puCountryFromCountryCodeFromLabelStart, puCountryFromCountryCodeFromLabelStart + puCountryFromCountryCodeFromJson.length());
        //    System.out.println("puCountryFromCountryCodeFromLabel = " + puCountryFromCountryCodeFromLabel);
        assertThat(puCountryFromCountryCodeFromJson, is(equalTo(puCountryFromCountryCodeFromLabel)));

    }


    @DisplayName("ZPL - DY countryCode converted to Switzerland")
    @Test
    public void test5() {

        //    System.out.println("dyCountryFromCountryCodeFromJson = " + dyCountryFromCountryCodeFromJson);
        int dyCountryFromCountryCodeFromLabelStart = decodedStringShipments.indexOf("^FT96,260^A0N,23,24^FH^FD") + 25;
        String dyCountryFromCountryCodeFromLabel = decodedStringShipments.substring(dyCountryFromCountryCodeFromLabelStart, dyCountryFromCountryCodeFromLabelStart + dyCountryFromCountryCodeFromJson.length());
        //    System.out.println("dyCountryFromCountryCodeFromLabel = " + dyCountryFromCountryCodeFromLabel);
        assertThat(dyCountryFromCountryCodeFromJson, is(equalTo(dyCountryFromCountryCodeFromLabel)));

    }


    @DisplayName("ZPL - SU index / Total SU 1 OF 1")
    @Test
    public void test6() {

        String suIndexFromJson = String.valueOf(sandersFritomPojoShipments.getShippingUnits().get(0).getIndex());
        //    System.out.println("suIndexFromJson = " + suIndexFromJson);
        String totalSuIndexFromJson = String.valueOf(sandersFritomPojoShipments.getNumberOfShippingUnits());
        //    System.out.println("totalSuIndexFromJson = " + totalSuIndexFromJson);
        int packagesFromLabelStart = decodedStringShipments.indexOf("^FT107,430^A0N,23,24^FH^FD") + 26;
        String packagesFromLabel = decodedStringShipments.substring(packagesFromLabelStart, packagesFromLabelStart + (suIndexFromJson + "/" + totalSuIndexFromJson).length());
        //    System.out.println("packagesFromLabel = " + packagesFromLabel);
        assertThat(suIndexFromJson + "/" + totalSuIndexFromJson, is(equalTo(packagesFromLabel)));
        assertThat(decodedStringShipments, containsString("^FT25,430^A0N,23,24^FH^FDSeq #:^FS"));

    }


    @DisplayName("EDI - contains - version Data : <?xml version=\"1.0\" encoding=\"UTF-8\" ?>")
    @Test
    public void test7() {

        assertThat(decodedStringConveyances, containsString("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"));
    }


    @DisplayName("EDI - contains <FRITOM_SHIPMENT_XML>")
    @Test
    public void test8() {


        assertThat(decodedStringConveyances, containsString("<FRITOM_SHIPMENT_XML>"));
    }


    @DisplayName("EDI - FritomCompany = SandersFritom")
    @Test
    public void test9() {

        String fritomCompanyEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getString("FRITOMCOMPANY");
        //    System.out.println("fritomCompanyEDI = " + fritomCompanyEDI);
        assertThat(fritomCompanyEDI, is(equalTo("SandersFritom")));

    }


    @DisplayName("EDI - TIMESTAMP: <TIMESTAMP>2022-02-04T16:04:34</TIMESTAMP>")
    @Test
    public void test10() {

        String timestampEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getString("TIMESTAMP");
    //    System.out.println("timestampEDI = " + timestampEDI);
        assertThat(timestampEDI.substring(0, 16), is(equalTo(dateTimeUTC.toString().substring(0, 16))));

    }


    @DisplayName("EDI - Version = <VERSION>1.5</VERSION>")
    @Test
    public void test11() {

        String versionEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getDouble("VERSION"));
        //    System.out.println("versionEDI = " + versionEDI);
        assertThat(versionEDI, is(equalTo("1.5")));
    }


    @DisplayName("EDI - trackingID = (set to s.ShipperRef) 4706850")
    @Test
    public void test12() {

        String trackingIdFromJson = sandersFritomPojoShipments.getShipperRef();
        //    System.out.println("trackingIdFromJson = " + trackingIdFromJson);
        String trackingIdEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getInt("TRACKINGID"));
        //    System.out.println("trackingIdEDI = " + trackingIdEDI);
        assertThat(trackingIdFromJson, is(equalTo(trackingIdEDI)));
    }


    @DisplayName("EDI - REFERENCE = (set to s.ShipperRef) 4706850")
    @Test
    public void test13() {

        String referenceFromJson = sandersFritomPojoShipments.getShipperRef();
    //    System.out.println("referenceFromJson = " + referenceFromJson);
        String referenceIdEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getInt("REFERENCE"));
    //    System.out.println("referenceIdEDI = " + referenceIdEDI);
        assertThat(referenceFromJson, is(equalTo(referenceIdEDI)));
    }


    @DisplayName("EDI - COD_AMOUNT present <COD_AMOUNT/>")
    @Test
    public void test14() {

        assertThat(decodedStringConveyances, containsString("<COD_AMOUNT/>"));
    }


    @DisplayName("EDI - COD_VAL present <COD_VAL/>")
    @Test
    public void test15() {

        assertThat(decodedStringConveyances, containsString("<COD_VAL/>"));
    }


    @DisplayName("EDI - IncotermCode = <INCOTERMS>CPT</INCOTERMS>")
    @Test
    public void test16() {

        String incotermCodeFromJson = sandersFritomPojoShipments.getIncotermCode();
        //    System.out.println("incotermCodeFromJson = " + incotermCodeFromJson);
        String incotermCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getString("INCOTERMS");
        //    System.out.println("incotermCodeEDI = " + incotermCodeEDI);
        assertThat(incotermCodeFromJson, is(equalTo(incotermCodeEDI)));
    }


    @DisplayName("EDI - customer CODE : <CODE>968888021</CODE>")
    @Test
    public void test17() {

        String customerCodeFromJson = sandersFritomPojoShipments.getPickupForwarderDivisionAccountCode();
        //    System.out.println("customerCodeFromJson = " + customerCodeFromJson);
        String customerCodeEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getInt("CODE"));
        //    System.out.println("customerCodeEDI = " + customerCodeEDI);
        assertThat(customerCodeFromJson, is(equalTo(customerCodeEDI)));
    }


    @DisplayName("EDI - customer Name : <NAME><![CDATA[PUREF0001]]></NAME>")
    @Test
    public void test18() {

        String customerNameFromJson = sandersFritomPojoShipments.getAddresses().get(1).getReference();
        //    System.out.println("customerNameFromJson = " + customerNameFromJson);
        String customerNameEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("NAME");
        //    System.out.println("customerNameEDI = " + customerNameEDI);
        assertThat(customerNameFromJson, is(equalTo(customerNameEDI)));
    }


    @DisplayName("EDI - customer Name2 : <NAME2><![CDATA[Pickup Name One]]></NAME2>")
    @Test
    public void test19() {

        String customerName2FromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getName();
        //    System.out.println("customerName2FromJson = " + customerName2FromJson);
        String customerName2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("NAME2");
        //    System.out.println("customerName2EDI = " + customerName2EDI);
        assertThat(customerName2FromJson, is(equalTo(customerName2EDI)));
    }


    @DisplayName("EDI - customer Address : <ADDRESS><![CDATA[De Grens 27 TEST]]></ADDRESS>")
    @Test
    public void test20() {

        String customerAddressFromJson = sandersFritomPojoShipments.getPickupAddress().getAddressLines().get(0).getValue();
        //    System.out.println("customerAddressFromJson = " + customerAddressFromJson);
        String customerAddressEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("ADDRESS");
        //    System.out.println("customerAddressEDI = " + customerAddressEDI);
        assertThat(customerAddressFromJson, is(equalTo(customerAddressEDI)));
    }


    @DisplayName("EDI - customer postalCode : <POSTALCODE>5921CC</POSTALCODE>")
    @Test
    public void test21() {

        String customerPostalCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("customerPostalCodeFromJson = " + customerPostalCodeFromJson);
        String customerPostalCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("POSTALCODE");
        //    System.out.println("customerPostalCodeEDI = " + customerPostalCodeEDI);
        assertThat(customerPostalCodeFromJson, is(equalTo(customerPostalCodeEDI)));
    }


    @DisplayName("EDI - customer City : <CITY><![CDATA[Heijen]]></CITY>")
    @Test
    public void test22() {

        String customerCityFromJson = sandersFritomPojoShipments.getPickupAddress().getLocalityName();
        //    System.out.println("customerCityFromJson = " + customerCityFromJson);
        String customerCityEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("CITY");
        //    System.out.println("customerCityEDI = " + customerCityEDI);
        assertThat(customerCityFromJson, is(equalTo(customerCityEDI)));
    }


    @DisplayName("EDI - customer countryCode : <COUNTRYCODE>ES</COUNTRYCODE>")
    @Test
    public void test23() {

        String customerCountryCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getCountryCode();
    //    System.out.println("customerCountryCodeFromJson = " + customerCountryCodeFromJson);
        String customerCountryCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("COUNTRYCODE");
    //    System.out.println("customerCountryCodeEDI = " + customerCountryCodeEDI);
        assertThat(customerCountryCodeFromJson, is(equalTo(customerCountryCodeEDI)));
    }


    @DisplayName("EDI - customer phoneNumber : <PHONE>31497532323</PHONE>")
    @Test
    public void test24() {

        String customerPhoneNumberFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("customerPhoneNumberFromJson = " + customerPhoneNumberFromJson);
        String customerPhoneNumberEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getBigInteger("PHONE"));
        //    System.out.println("customerPhoneNumberEDI = " + customerPhoneNumberEDI);
        assertThat(customerPhoneNumberFromJson, is(equalTo(customerPhoneNumberEDI)));
    }


    @DisplayName("EDI - customer Email : <EMAIL>vaiser@hotmail.com</EMAIL>")
    @Test
    public void test25() {

        String customerEmailFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getEmailAddress();
        //    System.out.println("customerEmailFromJson = " + customerEmailFromJson);
        String customerEmailEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("EMAIL");
        //    System.out.println("customerEmailEDI = " + customerEmailEDI);
        assertThat(customerEmailFromJson, is(equalTo(customerEmailEDI)));
    }


    @DisplayName("EDI - invoice CODE : <CODE>968888021</CODE>")
    @Test
    public void test26() {

        String invoiceCodeFromJson = sandersFritomPojoShipments.getPickupForwarderDivisionAccountCode();
        //    System.out.println("invoiceCodeFromJson = " + invoiceCodeFromJson);
        String invoiceCodeEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getInt("CODE"));
        //    System.out.println("invoiceCodeEDI = " + invoiceCodeEDI);
        assertThat(invoiceCodeFromJson, is(equalTo(invoiceCodeEDI)));
    }


    @DisplayName("EDI - invoice Name : <NAME><![CDATA[PUREF0001]]></NAME>")
    @Test
    public void test27() {

        String invoiceNameFromJson = sandersFritomPojoShipments.getAddresses().get(1).getReference();
        //    System.out.println("invoiceNameFromJson = " + invoiceNameFromJson);
        String invoiceNameEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("NAME");
        //    System.out.println("invoiceNameEDI = " + invoiceNameEDI);
        assertThat(invoiceNameFromJson, is(equalTo(invoiceNameEDI)));
    }


    @DisplayName("EDI - invoice Name2 : <NAME2><![CDATA[Pickup Name One]]></NAME2>  ")
    @Test
    public void test28() {

        String invoiceName2FromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getName();
        //    System.out.println("invoiceName2FromJson = " + invoiceName2FromJson);
        String invoiceName2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("NAME2");
        //    System.out.println("invoiceName2EDI = " + invoiceName2EDI);
        assertThat(invoiceName2FromJson, is(equalTo(invoiceName2EDI)));
    }


    @DisplayName("EDI - invoice Address : <ADDRESS><![CDATA[De Grens 27 TEST]]></ADDRESS>")
    @Test
    public void test29() {

        String invoiceAddressFromJson = sandersFritomPojoShipments.getPickupAddress().getAddressLines().get(0).getValue();
        //    System.out.println("invoiceAddressFromJson = " + invoiceAddressFromJson);
        String invoiceAddressEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("ADDRESS");
        //    System.out.println("invoiceAddressEDI = " + invoiceAddressEDI);
        assertThat(invoiceAddressFromJson, is(equalTo(invoiceAddressEDI)));
    }


    @DisplayName("EDI - invoice postalCode : <POSTALCODE>5921CC</POSTALCODE>")
    @Test
    public void test30() {

        String invoicePostalCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("invoicePostalCodeFromJson = " + invoicePostalCodeFromJson);
        String invoicePostalCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("POSTALCODE");
        //    System.out.println("invoicePostalCodeEDI = " + invoicePostalCodeEDI);
        assertThat(invoicePostalCodeFromJson, is(equalTo(invoicePostalCodeEDI)));
    }


    @DisplayName("EDI - invoice City : <CITY><![CDATA[Heijen]]></CITY>")
    @Test
    public void test31() {

        String invoiceCityFromJson = sandersFritomPojoShipments.getPickupAddress().getLocalityName();
        //    System.out.println("invoiceCityFromJson = " + invoiceCityFromJson);
        String invoiceCityEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("CITY");
        //    System.out.println("invoiceCityEDI = " + invoiceCityEDI);
        assertThat(invoiceCityFromJson, is(equalTo(invoiceCityEDI)));
    }


    @DisplayName("EDI - invoice countryCode : <COUNTRYCODE>ES</COUNTRYCODE>")
    @Test
    public void test32() {

        String invoiceCountryCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getCountryCode();
    //    System.out.println("invoiceCountryCodeFromJson = " + invoiceCountryCodeFromJson);
        String invoiceCountryCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("COUNTRYCODE");
    //    System.out.println("invoiceCountryCodeEDI = " + invoiceCountryCodeEDI);
        assertThat(invoiceCountryCodeFromJson, is(equalTo(invoiceCountryCodeEDI)));
    }


    @DisplayName("EDI - invoice phoneNumber : <PHONE>31497532323</PHONE>")
    @Test
    public void test33() {

        String invoicePhoneNumberFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("invoicePhoneNumberFromJson = " + invoicePhoneNumberFromJson);
        String invoicePhoneNumberEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getBigInteger("PHONE"));
        //    System.out.println("invoicePhoneNumberEDI = " + invoicePhoneNumberEDI);
        assertThat(invoicePhoneNumberFromJson, is(equalTo(invoicePhoneNumberEDI)));
    }


    @DisplayName("EDI - invoice Email : <EMAIL>vaiser@hotmail.com</EMAIL>")
    @Test
    public void test34() {

        String invoiceEmailFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getEmailAddress();
        //    System.out.println("invoiceEmailFromJson = " + invoiceEmailFromJson);
        String invoiceEmailEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("EMAIL");
        //    System.out.println("invoiceEmailEDI = " + invoiceEmailEDI);
        assertThat(invoiceEmailFromJson, is(equalTo(invoiceEmailEDI)));
    }


    @DisplayName("EDI - loading Restriction = PICKUP_ROOF_LOAD -> <RESTRICTION>Dak</RESTRICTION>")
    @Test
    public void test35() {

        //    System.out.println("restrictionValueFromJsonMap.get(\"PICKUP_ROOF_LOAD\") = " + restrictionValueFromJsonMap.get("PICKUP_ROOF_LOAD"));
        String loadingRestrictionEDI = (String) jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("RESTRICTIONS").getJSONArray("RESTRICTION").get(0);
        //    System.out.println("loadingRestrictionEDI = " + loadingRestrictionEDI);
        assertThat(restrictionValueFromJsonMap.get("PICKUP_ROOF_LOAD"), is(equalTo(loadingRestrictionEDI)));
    }


    @DisplayName("EDI - loading Restriction = PICKUP_HIAB -> <RESTRICTION>Kraan</RESTRICTION>")
    @Test
    public void test36() {

        //    System.out.println("restrictionValueFromJsonMap.get(\"PICKUP_HIAB\") = " + restrictionValueFromJsonMap.get("PICKUP_HIAB"));
        String loadingRestrictionEDI = (String) jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("RESTRICTIONS").getJSONArray("RESTRICTION").get(1);
        //    System.out.println("loadingRestrictionEDI = " + loadingRestrictionEDI);
        assertThat(restrictionValueFromJsonMap.get("PICKUP_HIAB"), is(equalTo(loadingRestrictionEDI)));
    }


    @DisplayName("EDI - loading Restriction = PICKUP_SIDE_LOAD -> <RESTRICTION>Zijkant</RESTRICTION>")
    @Test
    public void test37() {

        //    System.out.println("restrictionValueFromJsonMap.get(\"PICKUP_SIDE_LOAD\") = " + restrictionValueFromJsonMap.get("PICKUP_SIDE_LOAD"));
        String loadingRestrictionEDI = (String) jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("RESTRICTIONS").getJSONArray("RESTRICTION").get(2);
        //    System.out.println("loadingRestrictionEDI = " + loadingRestrictionEDI);
        assertThat(restrictionValueFromJsonMap.get("PICKUP_SIDE_LOAD"), is(equalTo(loadingRestrictionEDI)));

    }


    @DisplayName("EDI - loading Correct pick up start date")
    @Test
    public void test38() {

        String loadingCorrectPickUpStartDateFromJson = sandersFritomPojoShipments.getRequestedPickupWindowBeginDateTime().substring(0, 10);
    //    System.out.println("loadingCorrectPickUpStartDateFromJson = " + loadingCorrectPickUpStartDateFromJson);
        String loadingCorrectPickUpStartDateEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getString("DATE1");
    //    System.out.println("loadingCorrectPickUpStartDateEDI = " + loadingCorrectPickUpStartDateEDI);
        assertThat(loadingCorrectPickUpStartDateFromJson, is(equalTo(loadingCorrectPickUpStartDateEDI)));
    }


    @DisplayName("EDI - loading Correct pick up end date")
    @Test
    public void test39() {

        String loadingCorrectPickUpEndDateFromJson = sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime().substring(0, 10);
    //    System.out.println("loadingCorrectPickUpEndDateFromJson = " + loadingCorrectPickUpEndDateFromJson);
        String loadingCorrectPickUpEndDateEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getString("DATE2");
    //    System.out.println("loadingCorrectPickUpEndDateEDI = " + loadingCorrectPickUpEndDateEDI);
        assertThat(loadingCorrectPickUpEndDateFromJson, is(equalTo(loadingCorrectPickUpEndDateEDI)));
    }



    @DisplayName("EDI - loading Correct pick up start time")
    @Test
    public void test40() {

        String loadingCorrectPickUpStartTimeFromJson = sandersFritomPojoShipments.getRequestedPickupWindowBeginDateTime().substring(11, 19);
        //    System.out.println("loadingCorrectPickUpStartTimeFromJson = " + loadingCorrectPickUpStartTimeFromJson);
        String loadingCorrectPickUpStartTimeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getString("TIME1");
        //    System.out.println("loadingCorrectPickUpStartTimeEDI = " + loadingCorrectPickUpStartTimeEDI);
        assertThat(loadingCorrectPickUpStartTimeFromJson, is(equalTo(loadingCorrectPickUpStartTimeEDI)));
    }


    @DisplayName("EDI - loading Correct pick up end time")
    @Test
    public void test41() {

        String loadingCorrectPickUpEndTimeFromJson = sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime().substring(11, 19);
        //    System.out.println("loadingCorrectPickUpEndTimeFromJson = " + loadingCorrectPickUpEndTimeFromJson);
        String loadingCorrectPickUpEndTimeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getString("TIME2");
        //    System.out.println("loadingCorrectPickUpEndTimeEDI = " + loadingCorrectPickUpEndTimeEDI);
        assertThat(loadingCorrectPickUpEndTimeFromJson, is(equalTo(loadingCorrectPickUpEndTimeEDI)));
    }


    @DisplayName("EDI - loading Name : <NAME><![CDATA[PUREF0001]]></NAME>")
    @Test
    public void test42() {

        String loadingNameFromJson = sandersFritomPojoShipments.getAddresses().get(1).getReference();
        //    System.out.println("loadingNameFromJson = " + loadingNameFromJson);
        String loadingNameEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("NAME");
        //    System.out.println("loadingNameEDI = " + loadingNameEDI);
        assertThat(loadingNameFromJson, is(equalTo(loadingNameEDI)));
    }


    @DisplayName("EDI - loading Name2 : <NAME2><![CDATA[Pickup Name One]]></NAME2>")
    @Test
    public void test43() {

        String loadingName2FromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getName();
        //    System.out.println("loadingName2FromJson = " + loadingName2FromJson);
        String loadingName2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("NAME2");
        //    System.out.println("loadingName2EDI = " + loadingName2EDI);
        assertThat(loadingName2FromJson, is(equalTo(loadingName2EDI)));
    }


    @DisplayName("EDI - loading Address : <ADDRESS><![CDATA[De Grens 27 TEST]]></ADDRESS>")
    @Test
    public void test44() {

        String loadingAddressFromJson = sandersFritomPojoShipments.getPickupAddress().getAddressLines().get(0).getValue();
        //    System.out.println("loadingAddressFromJson = " + loadingAddressFromJson);
        String loadingAddressEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("ADDRESS");
        //    System.out.println("loadingAddressEDI = " + loadingAddressEDI);
        assertThat(loadingAddressFromJson, is(equalTo(loadingAddressEDI)));
    }


    @DisplayName("EDI - loading postalCode : <POSTALCODE>5921CC</POSTALCODE>")
    @Test
    public void test45() {

        String loadingPostalCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("loadingPostalCodeFromJson = " + loadingPostalCodeFromJson);
        String loadingPostalCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("POSTALCODE");
        //    System.out.println("loadingPostalCodeEDI = " + loadingPostalCodeEDI);
        assertThat(loadingPostalCodeFromJson, is(equalTo(loadingPostalCodeEDI)));
    }


    @DisplayName("EDI - loading City : <CITY><![CDATA[Heijen]]></CITY>")
    @Test
    public void test46() {

        String loadingCityFromJson = sandersFritomPojoShipments.getPickupAddress().getLocalityName();
        //    System.out.println("loadingCityFromJson = " + loadingCityFromJson);
        String loadingCityEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("CITY");
        //    System.out.println("loadingCityEDI = " + loadingCityEDI);
        assertThat(loadingCityFromJson, is(equalTo(loadingCityEDI)));
    }


    @DisplayName("EDI - loading countryCode : <COUNTRYCODE>ES</COUNTRYCODE>")
    @Test
    public void test47() {

        String loadingCountryCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getCountryCode();
    //    System.out.println("loadingCountryCodeFromJson = " + loadingCountryCodeFromJson);
        String loadingCountryCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("COUNTRYCODE");
    //    System.out.println("loadingCountryCodeEDI = " + loadingCountryCodeEDI);
        assertThat(loadingCountryCodeFromJson, is(equalTo(loadingCountryCodeEDI)));
    }


    @DisplayName("EDI - loading phoneNumber : <PHONE>31497532323</PHONE>")
    @Test
    public void test48() {

        String loadingPhoneNumberFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("loadingPhoneNumberFromJson = " + loadingPhoneNumberFromJson);
        String loadingPhoneNumberEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getBigInteger("PHONE"));
        //    System.out.println("loadingPhoneNumberEDI = " + loadingPhoneNumberEDI);
        assertThat(loadingPhoneNumberFromJson, is(equalTo(loadingPhoneNumberEDI)));
    }


    @DisplayName("EDI - loading Email : <EMAIL>vaiser@hotmail.com</EMAIL>")
    @Test
    public void test49() {

        String loadingEmailFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getEmailAddress();
        //    System.out.println("loadingEmailFromJson = " + loadingEmailFromJson);
        String loadingEmailEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("EMAIL");
        //    System.out.println("loadingEmailEDI = " + loadingEmailEDI);
        assertThat(loadingEmailFromJson, is(equalTo(loadingEmailEDI)));
    }


    @DisplayName("EDI - unloading Restriction = DELIVERY_ROOF_LOAD -> <RESTRICTION>Dak</RESTRICTION>")
    @Test
    public void test50() {

        //    System.out.println("restrictionValueFromJsonMap.get(\"DELIVERY_ROOF_LOAD\") = " + restrictionValueFromJsonMap.get("DELIVERY_ROOF_LOAD"));
        String unloadingRestrictionEDI = (String) jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("RESTRICTIONS").getJSONArray("RESTRICTION").get(0);
        //    System.out.println("unloadingRestrictionEDI = " + unloadingRestrictionEDI);
        assertThat(restrictionValueFromJsonMap.get("DELIVERY_ROOF_LOAD"), is(equalTo(unloadingRestrictionEDI)));

    }


    @DisplayName("EDI - unloading Correct delivery date")
    @Test
    public void test51() {

        String unloadingCorrectDeliveryDateFromJson = sandersFritomPojoShipments.getRequestedDeliveryDateTime().substring(0, 10);
    //    System.out.println("unloadingCorrectDeliveryDateFromJson = " + unloadingCorrectDeliveryDateFromJson);
        String unloadingCorrectDeliveryDateEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getString("DATE1");
    //    System.out.println("unloadingCorrectDeliveryDateEDI = " + unloadingCorrectDeliveryDateEDI);
        assertThat(unloadingCorrectDeliveryDateFromJson, is(equalTo(unloadingCorrectDeliveryDateEDI)));
    }


    @Disabled
    @DisplayName("EDI - unloading Correct pick up end date")
    @Test
    public void test52() {

        String unloadingCorrectPickUpEndDateFromJson = sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime().substring(0, 10);
    //    System.out.println("unloadingCorrectPickUpEndDateFromJson = " + unloadingCorrectPickUpEndDateFromJson);
        String unloadingCorrectPickUpEndDateEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getString("DATE2");
    //    System.out.println("unloadingCorrectPickUpEndDateEDI = " + unloadingCorrectPickUpEndDateEDI);
        assertThat(unloadingCorrectPickUpEndDateFromJson, is(equalTo(unloadingCorrectPickUpEndDateEDI)));
    }


    @DisplayName("EDI - unloading Correct delivery start time - <TIME1>12:00:00</TIME1> - hardcoded in composer settings")
    @Test
    public void test53() {


        String unloadingCorrectDeliveryStartTimeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getString("TIME1");
        //    System.out.println("unloadingCorrectDeliveryStartTimeEDI = " + unloadingCorrectDeliveryStartTimeEDI);
        assertThat(unloadingCorrectDeliveryStartTimeEDI, is(equalTo("12:00:00")));
    }


    @DisplayName("EDI - unloading Correct delivery end time - <TIME2>17:00:00</TIME2> - hardcoded in composer settings")
    @Test
    public void test54() {

        String unloadingCorrectDeliveryEndTimeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getString("TIME2");
    //    System.out.println("unloadingCorrectDeliveryEndTimeEDI = " + unloadingCorrectDeliveryEndTimeEDI);
        assertThat(unloadingCorrectDeliveryEndTimeEDI, is(equalTo("17:00:00")));
    }


    @DisplayName("EDI - unloading Name : <NAME><![CDATA[FLE >><<01105]]></NAME>")
    @Test
    public void test55() {

        String unloadingNameFromJson = sandersFritomPojoShipments.getAddresses().get(0).getReference();
        //    System.out.println("unloadingNameFromJson = " + unloadingNameFromJson);
        String unloadingNameEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("NAME");
        //    System.out.println("unloadingNameEDI = " + unloadingNameEDI);
        assertThat(unloadingNameFromJson, is(equalTo(unloadingNameEDI)));
    }


    @DisplayName("EDI - unloading Name2 : <NAME2><![CDATA[Delivery Co<<ntact Name 1]]></NAME2>")
    @Test
    public void test56() {

        String unloadingName2FromJson = sandersFritomPojoShipments.getAddresses().get(0).getContacts().get(0).getName();
        //    System.out.println("unloadingName2FromJson = " + unloadingName2FromJson);
        String unloadingName2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("NAME2");
        //    System.out.println("unloadingName2EDI = " + unloadingName2EDI);
        assertThat(unloadingName2FromJson, is(equalTo(unloadingName2EDI)));
    }


    @DisplayName("EDI - unloading address : <ADDRESS><![CDATA[Weena 10017 TEST]]></ADDRESS>")
    @Test
    public void test57() {

        String unloadingAddressFromJson = sandersFritomPojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue();
    //    System.out.println("unloadingAddressFromJson = " + unloadingAddressFromJson);
        String unloadingAddressEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("ADDRESS");
    //    System.out.println("unloadingAddressEDI = " + unloadingAddressEDI);
        assertThat(unloadingAddressFromJson, is(equalTo(unloadingAddressEDI)));
    }


    @DisplayName("EDI - unloading address 2 : <ADDRESS2><![CDATA[Delivery address two]]></ADDRESS2>")
    @Test
    public void test58() {

        String unloadingAddress2FromJson = sandersFritomPojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue();
    //    System.out.println("unloadingAddress2FromJson = " + unloadingAddress2FromJson);
        String unloadingAddress2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("ADDRESS2");
    //    System.out.println("unloadingAddress2EDI = " + unloadingAddress2EDI);
        assertThat(unloadingAddress2FromJson, is(equalTo(unloadingAddress2EDI)));
    }


    @DisplayName("EDI - unloading postalCode : <POSTALCODE>0001001</POSTALCODE>")
    @Test
    public void test59() {

        String unloadingPostalCodeFromJson = sandersFritomPojoShipments.getDeliveryAddress().getPostalCode();
    //    System.out.println("unloadingPostalCodeFromJson = " + unloadingPostalCodeFromJson);
        String unloadingPostalCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("POSTALCODE");
    //    System.out.println("unloadingPostalCodeEDI = " + unloadingPostalCodeEDI);
        assertThat(unloadingPostalCodeEDI, is(equalTo(unloadingPostalCodeEDI)));
    }


    @DisplayName("EDI - unloading City : <CITY><![CDATA[VITORIA]]></CITY>")
    @Test
    public void test60() {

        String unloadingCityFromJson = sandersFritomPojoShipments.getDeliveryAddress().getLocalityName();
    //    System.out.println("unloadingCityFromJson = " + unloadingCityFromJson);
        String unloadingCityEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("CITY");
    //    System.out.println("unloadingCityEDI = " + unloadingCityEDI);
        assertThat(unloadingCityFromJson, is(equalTo(unloadingCityEDI)));
    }


    @DisplayName("EDI - unloading countryCode : <COUNTRYCODE>CH</COUNTRYCODE>")
    @Test
    public void test61() {

        String unloadingCountryCodeFromJson = sandersFritomPojoShipments.getDeliveryAddress().getCountryCode();
    //    System.out.println("unloadingCountryCodeFromJson = " + unloadingCountryCodeFromJson);
        String unloadingCountryCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("COUNTRYCODE");
    //    System.out.println("unloadingCountryCodeEDI = " + unloadingCountryCodeEDI);
        assertThat(unloadingCountryCodeFromJson, is(equalTo(unloadingCountryCodeEDI)));
    }


    @DisplayName("EDI - unloading phoneNumber : <PHONE>(31)497-532-323</PHONE>")
    @Test
    public void test62() {

        String unloadingPhoneNumberFromJson = sandersFritomPojoShipments.getDeliveryAddress().getContacts().get(0).getPhoneNumber();
    //    System.out.println("unloadingPhoneNumberFromJson = " + unloadingPhoneNumberFromJson);
        String unloadingPhoneNumberEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("PHONE");
    //   System.out.println("unloadingPhoneNumberEDI = " + unloadingPhoneNumberEDI);
        assertThat(unloadingPhoneNumberFromJson, is(equalTo(unloadingPhoneNumberEDI)));
    }


    @DisplayName("EDI - unloading Email : <EMAIL>vaiser@hotmail.com</EMAIL>")
    @Test
    public void test63() {

        String unloadingEmailFromJson = sandersFritomPojoShipments.getDeliveryAddress().getContacts().get(0).getEmailAddress();
    //    System.out.println("unloadingEmailFromJson = " + unloadingEmailFromJson);
        String unloadingEmailEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("EMAIL");
    //    System.out.println("unloadingEmailEDI = " + unloadingEmailEDI);
        assertThat(unloadingEmailFromJson, is(equalTo(unloadingEmailEDI)));
    }


    @DisplayName("EDI - orderline Description : This is the description of the sUnit content value")
    @Test
    public void test64() {

        String orderlineDescriptionFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getContent();
    //    System.out.println("orderlineDescriptionFromJson = " + orderlineDescriptionFromJson);
        String orderlineDescriptionEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getString("ITEMDESCRIPTION");
    //    System.out.println("orderlineDescriptionEDI = " + orderlineDescriptionEDI);
        assertThat(orderlineDescriptionFromJson, containsString(orderlineDescriptionEDI));

    }


    @DisplayName("EDI - orderline UnitCode : <UNITCODE>PAK</UNITCODE>")
    @Test
    public void test65() {

        String orderLineUnitCodeFromJsonConverted = unitcodeValueFromJsonMap.get(unitcodeFromJson);
    //    System.out.println("orderLineUnitCodeFromJsonConverted = " + orderLineUnitCodeFromJsonConverted);
        String orderLineDescriptionEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getString("UNITCODE");
    //    System.out.println("orderLineDescriptionEDI = " + orderLineDescriptionEDI);
        assertThat(orderLineUnitCodeFromJsonConverted, is(equalTo(orderLineDescriptionEDI)));

    }


    @DisplayName("EDI - orderline Quantity : 1")
    @Test
    public void test67() {

        int orderlineQuantityFromJson = sandersFritomPojoShipments.getNumberOfShippingUnits();
        //    System.out.println("orderlineQuantityFromJson = " + orderlineQuantityFromJson);
        int orderlineQuantityEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getInt("QUANTITY");
        //    System.out.println("orderlineQuantityEDI = " + orderlineQuantityEDI);
        assertThat(orderlineQuantityFromJson, is(equalTo(orderlineQuantityEDI)));
    }


    @DisplayName("EDI - orderline GrossWeight : <GROSS_WEIGHT>12.13</GROSS_WEIGHT>")
    @Test
    public void test68() {

        double orderlineGrossWeightFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeight();
    //    System.out.println("orderlineGrossWeightFromJson = " + orderlineGrossWeightFromJson);
        double orderlineGrossWeightEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("GROSS_WEIGHT");
    //    System.out.println("orderlineGrossWeightEDI = " + orderlineGrossWeightEDI);
        assertThat(String.format("%.2f", orderlineGrossWeightFromJson), is(equalTo(String.valueOf(orderlineGrossWeightEDI))));
    }


    @DisplayName("EDI - orderline NetWeight : <NET_WEIGHT>12.13</NET_WEIGHT>")
    @Test
    public void test69() {

        double orderlineNetWeightFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getNetWeight();
    //    System.out.println("orderlineNetWeightFromJson = " + orderlineNetWeightFromJson);
        double orderlineNetWeightEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("NET_WEIGHT");
    //    System.out.println("orderlineNetWeightEDI = " + orderlineNetWeightEDI);
        assertThat(String.format("%.2f", orderlineNetWeightFromJson), is(equalTo(String.valueOf(orderlineNetWeightEDI))));
    }


    @DisplayName("EDI - orderline Length : <LENGTH>37.00</LENGTH>")
    @Test
    public void test70() {

        double orderlineLengthFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getLength();
    //    System.out.println("orderlineLengthFromJson = " + orderlineLengthFromJson);
        double orderlineLengthEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("LENGTH");
    //    System.out.println("orderlineLengthEDI = " + orderlineLengthEDI);
        assertThat(String.format("%.1f", orderlineLengthFromJson), is(equalTo(String.format("%.1f", orderlineLengthEDI))));
    }


    @DisplayName("EDI - orderline Width : <WIDTH>26.50</WIDTH>")
    @Test
    public void test71() {

        double orderlineWidthFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getWidth();
    //    System.out.println("orderlineWidthFromJson = " + orderlineWidthFromJson);
        double orderlineWidthEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("WIDTH");
    //    System.out.println("orderlineWidthEDI = " + orderlineWidthEDI);
        assertThat(String.format("%.1f", orderlineWidthFromJson), is(equalTo(String.format("%.1f", orderlineWidthEDI))));
    }


    @DisplayName("EDI - orderline Height : <HEIGHT>4.00</HEIGHT>")
    @Test
    public void test72() {

        double orderlineHeightFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getWidth();
    //    System.out.println("orderlineHeightFromJson = " + orderlineHeightFromJson);
        double orderlineHeightEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("WIDTH");
    //    System.out.println("orderlineHeightEDI = " + orderlineHeightEDI);
        assertThat(String.format("%.1f", orderlineHeightFromJson), is(equalTo(String.format("%.1f", orderlineHeightEDI))));
    }


    @DisplayName("EDI - orderline Volume : <VOLUME>0.14</VOLUME>")
    @Test
    public void test73() {

        double orderlineVolumeFromJson = volumeInCubicMetre;
    //    System.out.println("orderlineVolumeFromJson = " + orderlineVolumeFromJson);
        double orderlineVolumeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("VOLUME");
    //    System.out.println("orderlineVolumeEDI = " + orderlineVolumeEDI);
        assertThat(String.format("%.1f", orderlineVolumeFromJson), is(equalTo(String.format("%.1f", orderlineVolumeEDI))));
    }


    @DisplayName("EDI - orderline Loadingmeter : <LOADINGMETER>408.54</LOADINGMETER>")
    @Test
    public void test74() {

        double orderlineLengthFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getLength();
        double orderlineWidthFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getWidth();
        double orderlineLoadingmeterFromJson = (orderlineLengthFromJson * orderlineWidthFromJson) / 2.4;
    //    System.out.println("orderlineLoadingmeterFromJson = " + orderlineLoadingmeterFromJson);
        double orderlineLoadingmeterEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("LOADINGMETER");
    //    System.out.println("orderlineLoadingmeterEDI = " + orderlineLoadingmeterEDI);
        assertThat(String.format("%.1f", orderlineLoadingmeterFromJson), is(equalTo(String.format("%.1f", orderlineLoadingmeterEDI))));
    }


    @DisplayName("EDI - orderline 0 reference : 4706850")
    @Test
    public void test75() {

        String orderlineReferenceFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getShipperRef();
    //    System.out.println("orderlineReferenceFromJson = " + orderlineReferenceFromJson);
        String orderlineReferenceEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getInt("REFERENCE"));
    //    System.out.println("orderlineReferenceEDI = " + orderlineReferenceEDI);
        assertThat(orderlineReferenceFromJson, is(equalTo(orderlineReferenceEDI)));
    }





}
