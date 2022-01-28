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


        assertThat(sandersFritomPojoShipments.getShipmentId(), is(notNullValue()));
//        System.out.println("requestJsonBodyShipments = " + requestJsonBodyShipments);
//        validateResponseShipments.extract().response().prettyPrint();
//        System.out.println("decodedStringShipments = " + decodedStringShipments);
//        validateResponseConveyances.extract().response().prettyPrint();
//        System.out.println("decodedStringConveyances = " + decodedStringConveyances);
//        System.out.println("jsonDataEDI = " + jsonDataEDI);

        System.out.println("hour = " + hour);

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


    @DisplayName("EDI - Version = <VERSION>1.5</VERSION>")
    @Test
    public void test10() {

        String versionEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getDouble("VERSION"));
        //    System.out.println("versionEDI = " + versionEDI);
        assertThat(versionEDI, is(equalTo("1.5")));
    }


    @DisplayName("EDI - trackingID = (set to s.ShipperRef) 4706850")
    @Test
    public void test11() {

        String trackingIdFromJson = sandersFritomPojoShipments.getShipperRef();
        //    System.out.println("trackingIdFromJson = " + trackingIdFromJson);
        String trackingIdEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getInt("TRACKINGID"));
        //    System.out.println("trackingIdEDI = " + trackingIdEDI);
        assertThat(trackingIdFromJson, is(equalTo(trackingIdEDI)));
    }


    @DisplayName("EDI - COD_AMOUNT present <COD_AMOUNT/>")
    @Test
    public void test12() {

        assertThat(decodedStringConveyances, containsString("<COD_AMOUNT/>"));
    }


    @DisplayName("EDI - COD_VAL present <COD_VAL/>")
    @Test
    public void test13() {

        assertThat(decodedStringConveyances, containsString("<COD_VAL/>"));
    }


    @DisplayName("EDI - IncotermCode = <INCOTERMS>CPT</INCOTERMS>")
    @Test
    public void test14() {

        String incotermCodeFromJson = sandersFritomPojoShipments.getIncotermCode();
        //    System.out.println("incotermCodeFromJson = " + incotermCodeFromJson);
        String incotermCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getString("INCOTERMS");
        //    System.out.println("incotermCodeEDI = " + incotermCodeEDI);
        assertThat(incotermCodeFromJson, is(equalTo(incotermCodeEDI)));
    }


    @DisplayName("EDI - customer CODE : <CODE>968888021</CODE>")
    @Test
    public void test15() {

        String customerCodeFromJson = sandersFritomPojoShipments.getPickupForwarderDivisionAccountCode();
        //    System.out.println("customerCodeFromJson = " + customerCodeFromJson);
        String customerCodeEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getInt("CODE"));
        //    System.out.println("customerCodeEDI = " + customerCodeEDI);
        assertThat(customerCodeFromJson, is(equalTo(customerCodeEDI)));
    }


    @DisplayName("EDI - customer Name : <NAME><![CDATA[PUREF0001]]></NAME>")
    @Test
    public void test16() {

        String customerNameFromJson = sandersFritomPojoShipments.getAddresses().get(1).getReference();
        //    System.out.println("customerNameFromJson = " + customerNameFromJson);
        String customerNameEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("NAME");
        //    System.out.println("customerNameEDI = " + customerNameEDI);
        assertThat(customerNameFromJson, is(equalTo(customerNameEDI)));
    }


    @DisplayName("EDI - customer Name2 : <NAME2><![CDATA[Pickup Name One]]></NAME2>")
    @Test
    public void test17() {

        String customerName2FromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getName();
        //    System.out.println("customerName2FromJson = " + customerName2FromJson);
        String customerName2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("NAME2");
        //    System.out.println("customerName2EDI = " + customerName2EDI);
        assertThat(customerName2FromJson, is(equalTo(customerName2EDI)));
    }


    @DisplayName("EDI - customer Address : <ADDRESS><![CDATA[De Grens 27 TEST]]></ADDRESS>")
    @Test
    public void test18() {

        String customerAddressFromJson = sandersFritomPojoShipments.getPickupAddress().getAddressLines().get(0).getValue();
        //    System.out.println("customerAddressFromJson = " + customerAddressFromJson);
        String customerAddressEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("ADDRESS");
        //    System.out.println("customerAddressEDI = " + customerAddressEDI);
        assertThat(customerAddressFromJson, is(equalTo(customerAddressEDI)));
    }


    @DisplayName("EDI - customer postalCode : <POSTALCODE>5921CC</POSTALCODE>")
    @Test
    public void test19() {

        String customerPostalCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("customerPostalCodeFromJson = " + customerPostalCodeFromJson);
        String customerPostalCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("POSTALCODE");
        //    System.out.println("customerPostalCodeEDI = " + customerPostalCodeEDI);
        assertThat(customerPostalCodeFromJson, is(equalTo(customerPostalCodeEDI)));
    }


    @DisplayName("EDI - customer City : <CITY><![CDATA[Heijen]]></CITY>")
    @Test
    public void test20() {

        String customerCityFromJson = sandersFritomPojoShipments.getPickupAddress().getLocalityName();
        //    System.out.println("customerCityFromJson = " + customerCityFromJson);
        String customerCityEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("CITY");
        //    System.out.println("customerCityEDI = " + customerCityEDI);
        assertThat(customerCityFromJson, is(equalTo(customerCityEDI)));
    }


    @DisplayName("EDI - customer phoneNumber : <PHONE>31497532323</PHONE>")
    @Test
    public void test21() {

        String customerPhoneNumberFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("customerPhoneNumberFromJson = " + customerPhoneNumberFromJson);
        String customerPhoneNumberEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getBigInteger("PHONE"));
        //    System.out.println("customerPhoneNumberEDI = " + customerPhoneNumberEDI);
        assertThat(customerPhoneNumberFromJson, is(equalTo(customerPhoneNumberEDI)));
    }


    @DisplayName("EDI - customer Email : <EMAIL>vaiser@hotmail.com</EMAIL>")
    @Test
    public void test22() {

        String customerEmailFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getEmailAddress();
        //    System.out.println("customerEmailFromJson = " + customerEmailFromJson);
        String customerEmailEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("EMAIL");
        //    System.out.println("customerEmailEDI = " + customerEmailEDI);
        assertThat(customerEmailFromJson, is(equalTo(customerEmailEDI)));
    }


    @DisplayName("EDI - invoice CODE : <CODE>968888021</CODE>")
    @Test
    public void test23() {

        String invoiceCodeFromJson = sandersFritomPojoShipments.getPickupForwarderDivisionAccountCode();
        //    System.out.println("invoiceCodeFromJson = " + invoiceCodeFromJson);
        String invoiceCodeEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getInt("CODE"));
        //    System.out.println("invoiceCodeEDI = " + invoiceCodeEDI);
        assertThat(invoiceCodeFromJson, is(equalTo(invoiceCodeEDI)));
    }


    @DisplayName("EDI - invoice Name : <NAME><![CDATA[PUREF0001]]></NAME>")
    @Test
    public void test24() {

        String invoiceNameFromJson = sandersFritomPojoShipments.getAddresses().get(1).getReference();
        //    System.out.println("invoiceNameFromJson = " + invoiceNameFromJson);
        String invoiceNameEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("NAME");
        //    System.out.println("invoiceNameEDI = " + invoiceNameEDI);
        assertThat(invoiceNameFromJson, is(equalTo(invoiceNameEDI)));
    }


    @DisplayName("EDI - invoice Name2 : <NAME2><![CDATA[Pickup Name One]]></NAME2>  ")
    @Test
    public void test25() {

        String invoiceName2FromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getName();
        //    System.out.println("invoiceName2FromJson = " + invoiceName2FromJson);
        String invoiceName2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("NAME2");
        //    System.out.println("invoiceName2EDI = " + invoiceName2EDI);
        assertThat(invoiceName2FromJson, is(equalTo(invoiceName2EDI)));
    }


    @DisplayName("EDI - invoice Address : <ADDRESS><![CDATA[De Grens 27 TEST]]></ADDRESS>")
    @Test
    public void test26() {

        String invoiceAddressFromJson = sandersFritomPojoShipments.getPickupAddress().getAddressLines().get(0).getValue();
        //    System.out.println("invoiceAddressFromJson = " + invoiceAddressFromJson);
        String invoiceAddressEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("ADDRESS");
        //    System.out.println("invoiceAddressEDI = " + invoiceAddressEDI);
        assertThat(invoiceAddressFromJson, is(equalTo(invoiceAddressEDI)));
    }


    @DisplayName("EDI - invoice postalCode : <POSTALCODE>5921CC</POSTALCODE>")
    @Test
    public void test27() {

        String invoicePostalCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("invoicePostalCodeFromJson = " + invoicePostalCodeFromJson);
        String invoicePostalCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("POSTALCODE");
        //    System.out.println("invoicePostalCodeEDI = " + invoicePostalCodeEDI);
        assertThat(invoicePostalCodeFromJson, is(equalTo(invoicePostalCodeEDI)));
    }


    @DisplayName("EDI - invoice City : <CITY><![CDATA[Heijen]]></CITY>")
    @Test
    public void test28() {

        String invoiceCityFromJson = sandersFritomPojoShipments.getPickupAddress().getLocalityName();
        //    System.out.println("invoiceCityFromJson = " + invoiceCityFromJson);
        String invoiceCityEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("CITY");
        //    System.out.println("invoiceCityEDI = " + invoiceCityEDI);
        assertThat(invoiceCityFromJson, is(equalTo(invoiceCityEDI)));
    }


    @DisplayName("EDI - invoice phoneNumber : <PHONE>31497532323</PHONE>")
    @Test
    public void test29() {

        String invoicePhoneNumberFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("invoicePhoneNumberFromJson = " + invoicePhoneNumberFromJson);
        String invoicePhoneNumberEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getBigInteger("PHONE"));
        //    System.out.println("invoicePhoneNumberEDI = " + invoicePhoneNumberEDI);
        assertThat(invoicePhoneNumberFromJson, is(equalTo(invoicePhoneNumberEDI)));
    }


    @DisplayName("EDI - invoice Email : <EMAIL>vaiser@hotmail.com</EMAIL>")
    @Test
    public void test30() {

        String invoiceEmailFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getEmailAddress();
        //    System.out.println("invoiceEmailFromJson = " + invoiceEmailFromJson);
        String invoiceEmailEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("EMAIL");
        //    System.out.println("invoiceEmailEDI = " + invoiceEmailEDI);
        assertThat(invoiceEmailFromJson, is(equalTo(invoiceEmailEDI)));
    }


    @DisplayName("EDI - loading Restriction = PICKUP_ROOF_LOAD -> <RESTRICTION>Dak</RESTRICTION>")
    @Test
    public void test31() {

    //    System.out.println("loadingRestrictionValueFromJsonMap.get(\"PICKUP_ROOF_LOAD\") = " + loadingRestrictionValueFromJsonMap.get("PICKUP_ROOF_LOAD"));
        String loadingRestrictionEDI = (String) jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("RESTRICTIONS").getJSONArray("RESTRICTION").get(0);
    //    System.out.println("loadingRestrictionEDI = " + loadingRestrictionEDI);
        assertThat(loadingRestrictionValueFromJsonMap.get("PICKUP_ROOF_LOAD"), is(equalTo(loadingRestrictionEDI)));
    }


    @DisplayName("EDI - loading Restriction PICKUP_HIAB -> <RESTRICTION>Kraan</RESTRICTION>")
    @Test
    public void test32() {

        //    System.out.println("loadingRestrictionValueFromJsonMap.get(\"PICKUP_HIAB\") = " + loadingRestrictionValueFromJsonMap.get("PICKUP_HIAB"));
        String loadingRestrictionEDI = (String) jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("RESTRICTIONS").getJSONArray("RESTRICTION").get(1);
        //    System.out.println("loadingRestrictionEDI = " + loadingRestrictionEDI);
        assertThat(loadingRestrictionValueFromJsonMap.get("PICKUP_HIAB"), is(equalTo(loadingRestrictionEDI)));
    }


    @DisplayName("EDI - loading Restriction PICKUP_SIDE_LOAD -> <RESTRICTION>Zijkant</RESTRICTION>")
    @Test
    public void test33() {

        //    System.out.println("loadingRestrictionValueFromJsonMap.get(\"PICKUP_SIDE_LOAD\") = " + loadingRestrictionValueFromJsonMap.get("PICKUP_SIDE_LOAD"));
        String loadingRestrictionEDI = (String) jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("RESTRICTIONS").getJSONArray("RESTRICTION").get(2);
        //    System.out.println("loadingRestrictionEDI = " + loadingRestrictionEDI);
        assertThat(loadingRestrictionValueFromJsonMap.get("PICKUP_SIDE_LOAD"), is(equalTo(loadingRestrictionEDI)));

    }


 }
