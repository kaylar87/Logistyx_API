package com.logistyx.TEST.Sanders_Fritom;


import com.logistyx.utilities.AbstractBaseClasses.All_Bring_Parcel_BNP_v303_v311.Label_And_EDI_Requests.BNP_BUS_PRCL.Weight_Cases_NL_NO_Base.BNPBaseNotDG1;
import com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom.SFBaseNotDG;
import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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


    @DisplayName("EDI - contains - Check version Data : <?xml version=\"1.0\" encoding=\"UTF-8\" ?>")
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
        String customerCodeEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getInt("CODE"));
    //    System.out.println("customerCodeEDI = " + customerCodeEDI);
        assertThat(customerCodeFromJson, is(equalTo(customerCodeEDI)));
    }


    @DisplayName("EDI - customer Name : <NAME><![CDATA[PUREF0001]]></NAME>")
    @Test
    public void test16() {

        String customerNameFromJson = sandersFritomPojoShipments.getAddresses().get(1).getReference();
    //    System.out.println("customerNameFromJson = " + customerNameFromJson);
        String customerNameEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("NAME");
    //    System.out.println("customerNameEDI = " + customerNameEDI);
        assertThat(customerNameFromJson, is(equalTo(customerNameEDI)));
    }


}
