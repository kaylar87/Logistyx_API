package com.logistyx.TEST.Sanders_Fritom;


import com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom.SFBaseNotDG_WO_DATE2;
import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class WO_DATE2 extends SFBaseNotDG_WO_DATE2 {

    static {
        SFBaseNotDG_WO_DATE2.shipmentsLabel();
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


    @DisplayName("ZPL Carrier : Sanders Fritom")
    @Test
    public void test4() {

        String carrierFromJson = sandersFritomPojoShipments.getForwarderDivision().getName();
        //    System.out.println("carrierFromJson = " + carrierFromJson);
        int carrierFromLabelStart = decodedStringShipments.indexOf("^FT25,47^A0N,39,38^FH^FD") + 24;
        String carrierFromLabel = decodedStringShipments.substring(carrierFromLabelStart, carrierFromLabelStart + carrierFromJson.length());
        //    System.out.println("carrierFromLabel = " + carrierFromLabel);
        assertThat(carrierFromJson, is(equalTo(carrierFromLabel)));
    }


    @DisplayName("ZPL Service : SFT Standard service")
    @Test
    public void test5() {

        String serviceFromJson = sandersFritomPojoShipments.getForwarderDivisionService().getName();
        //    System.out.println("serviceFromJson = " + serviceFromJson);
        int serviceFromLabelStart = decodedStringShipments.indexOf("^FT25,103^A0N,39,38^FH^FD") + 25;
        String serviceFromLabel = decodedStringShipments.substring(serviceFromLabelStart, serviceFromLabelStart + serviceFromJson.length());
        //    System.out.println("serviceFromLabel = " + serviceFromLabel);
        assertThat(serviceFromJson, is(equalTo(serviceFromLabel)));
    }


    @DisplayName("ZPL Origin - Name : PUREF0001")
    @Test
    public void test6() {

        String nameFromJson = sandersFritomPojoShipments.getPickupAddress().getReference();
        //    System.out.println("nameFromJson = " + nameFromJson);
        int nameFromLabelStart = decodedStringShipments.indexOf("^FT786,16^A0R,23,24^FH^FD") + 25;
        String nameFromLabel = decodedStringShipments.substring(nameFromLabelStart, nameFromLabelStart + nameFromJson.length());
        //    System.out.println("nameFromLabel = " + nameFromLabel);
        assertThat(nameFromJson, is(equalTo(nameFromLabel)));
    }


    @DisplayName("ZPL Origin - Name2 : Pickup Name One")
    @Test
    public void test7() {

        String name2FromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getName();
        //    System.out.println("name2FromJson = " + name2FromJson);
        int name2FromLabelStart = decodedStringShipments.indexOf("^FT761,16^A0R,23,24^FH^FD") + 25;
        String name2FromLabel = decodedStringShipments.substring(name2FromLabelStart, name2FromLabelStart + name2FromJson.length());
        //    System.out.println("name2FromLabel = " + name2FromLabel);
        assertThat(name2FromJson, is(equalTo(name2FromLabel)));
    }


    @DisplayName("ZPL Origin - Street : De Grens 27 TEST")
    @Test
    public void test8() {

        String streetFromJson = sandersFritomPojoShipments.getPickupAddress().getAddressLines().get(0).getValue();
        //    System.out.println("streetFromJson = " + streetFromJson);
        int streetFromLabelStart = decodedStringShipments.indexOf("^FT736,16^A0R,23,24^FH^FD") + 25;
        String streetFromLabel = decodedStringShipments.substring(streetFromLabelStart, streetFromLabelStart + streetFromJson.length());
        //    System.out.println("streetFromLabel = " + streetFromLabel);
        assertThat(streetFromJson, is(equalTo(streetFromLabel)));
    }


    @DisplayName("ZPL Origin - PostalCode : 5921CC")
    @Test
    public void test9() {

        String postalCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("postalCodeFromJson = " + postalCodeFromJson);
        int postalCodeFromLabelStart = decodedStringShipments.indexOf("^FT711,16^A0R,23,24^FH^FD") + 25;
        String postalCodeFromLabel = decodedStringShipments.substring(postalCodeFromLabelStart, postalCodeFromLabelStart + postalCodeFromJson.length());
        //    System.out.println("postalCodeFromLabel = " + postalCodeFromLabel);
        assertThat(postalCodeFromJson, is(equalTo(postalCodeFromLabel)));
    }


    @DisplayName("ZPL Origin - City : Heijen")
    @Test
    public void test10() {

        String cityFromJson = sandersFritomPojoShipments.getPickupAddress().getLocalityName();
        //    System.out.println("cityFromJson = " + cityFromJson);
        int cityFromLabelStart = decodedStringShipments.indexOf("^FT711,16^A0R,23,24^FH^FD") + 32;
        String cityFromLabel = decodedStringShipments.substring(cityFromLabelStart, cityFromLabelStart + cityFromJson.length());
        //    System.out.println("cityFromLabel = " + cityFromLabel);
        assertThat(cityFromJson, is(equalTo(cityFromLabel)));
    }


    @DisplayName("ZPL Origin - countryCode converted to Spain")
    @Test
    public void test11() {

        //    System.out.println("puCountryFromCountryCodeFromJson = " + puCountryFromCountryCodeFromJson);
        int puCountryFromCountryCodeFromLabelStart = decodedStringShipments.indexOf("^FT686,16^A0R,23,24^FH^FD") + 25;
        String puCountryFromCountryCodeFromLabel = decodedStringShipments.substring(puCountryFromCountryCodeFromLabelStart, puCountryFromCountryCodeFromLabelStart + puCountryFromCountryCodeFromJson.length());
        //    System.out.println("puCountryFromCountryCodeFromLabel = " + puCountryFromCountryCodeFromLabel);
        assertThat(puCountryFromCountryCodeFromJson, is(equalTo(puCountryFromCountryCodeFromLabel)));

    }


    @DisplayName("ZPL Origin - PhoneNumber : (31)497-532-323")
    @Test
    public void test12() {

        String phoneNumberFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("phoneNumberFromJson = " + phoneNumberFromJson);
        int phoneNumberFromLabelStart = decodedStringShipments.indexOf("^FT96,285^A0N,23,24^FH^FDtel: ") + 30;
        String phoneNumberFromLabel = decodedStringShipments.substring(phoneNumberFromLabelStart, phoneNumberFromLabelStart + phoneNumberFromJson.length() + 4);
        //    System.out.println("phoneNumberFromLabel = " + phoneNumberFromLabel);
        assertThat(phoneNumberFromJson, is(equalTo(phoneNumberFromLabel.replace("(", "").replace(")", "").replace("-", ""))));
    }


    @DisplayName("ZPL Origin - Remark : Remark value")
    @Test
    public void test13() {

        String remarkFromJson = sandersFritomPojoShipments.getPickupAddress().getRemark();
        //    System.out.println("remarkFromJson = " + remarkFromJson);
        int remarkFromLabelStart = decodedStringShipments.indexOf("^FT636,16^A0R,23,24^FH^FD") + 25;
        String remarkFromLabel = decodedStringShipments.substring(remarkFromLabelStart, remarkFromLabelStart + remarkFromJson.length());
        //    System.out.println("remarkFromLabel = " + remarkFromLabel);
        assertThat(remarkFromJson, is(equalTo(remarkFromLabel)));
    }


    @DisplayName("ZPL Destination - Name : FLE >><<01105")
    @Test
    public void test14() {

        String nameFromJson = sandersFritomPojoShipments.getDeliveryAddress().getReference();
        //    System.out.println("nameFromJson = " + nameFromJson);
        int nameFromLabelStart = decodedStringShipments.indexOf("^FT96,135^A0N,23,24^FH^FD") + 25;
        String nameFromLabel = decodedStringShipments.substring(nameFromLabelStart, nameFromLabelStart + nameFromJson.length());
        //    System.out.println("nameFromLabel = " + nameFromLabel);
        assertThat(nameFromJson, is(equalTo(nameFromLabel)));
    }


    @DisplayName("ZPL Destination - Name2 : Delivery Co<<ntact Name 1")
    @Test
    public void test15() {

        String name2FromJson = sandersFritomPojoShipments.getDeliveryAddress().getContacts().get(0).getName();
        //    System.out.println("name2FromJson = " + name2FromJson);
        int name2FromLabelStart = decodedStringShipments.indexOf("^FT96,160^A0N,23,24^FH^FD") + 25;
        String name2FromLabel = decodedStringShipments.substring(name2FromLabelStart, name2FromLabelStart + name2FromJson.length());
        //    System.out.println("name2FromLabel = " + name2FromLabel);
        assertThat(name2FromJson, is(equalTo(name2FromLabel)));
    }


    @DisplayName("ZPL Destination - Street1 : Weena 10017 TEST")
    @Test
    public void test16() {

        String streetFromJson = sandersFritomPojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue();
        //    System.out.println("streetFromJson = " + streetFromJson);
        int streetFromLabelStart = decodedStringShipments.indexOf("^FT96,185^A0N,23,24^FH^FD") + 25;
        String streetFromLabel = decodedStringShipments.substring(streetFromLabelStart, streetFromLabelStart + streetFromJson.length());
        //    System.out.println("streetFromLabel = " + streetFromLabel);
        assertThat(streetFromJson, is(equalTo(streetFromLabel)));
    }


    @DisplayName("ZPL Destination - Street2 : Delivery address two")
    @Test
    public void test17() {

        String street2FromJson = sandersFritomPojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue();
        //    System.out.println("street2FromJson = " + street2FromJson);
        int street2FromLabelStart = decodedStringShipments.indexOf("^FT96,210^A0N,23,24^FH^FD") + 25;
        String street2FromLabel = decodedStringShipments.substring(street2FromLabelStart, street2FromLabelStart + street2FromJson.length());
        //    System.out.println("street2FromLabel = " + street2FromLabel);
        assertThat(street2FromJson, is(equalTo(street2FromLabel)));
    }


    @DisplayName("ZPL Destination - PostalCode : 0001001")
    @Test
    public void test18() {

        String postalCodeFromJson = sandersFritomPojoShipments.getDeliveryAddress().getPostalCode();
        //    System.out.println("postalCodeFromJson = " + postalCodeFromJson);
        int postalCodeFromLabelStart = decodedStringShipments.indexOf("^FT96,235^A0N,23,24^FH^FD") + 25;
        String postalCodeFromLabel = decodedStringShipments.substring(postalCodeFromLabelStart, postalCodeFromLabelStart + postalCodeFromJson.length());
        //    System.out.println("postalCodeFromLabel = " + postalCodeFromLabel);
        assertThat(postalCodeFromJson, is(equalTo(postalCodeFromLabel)));
    }


    @DisplayName("ZPL Destination - City : VITORIA")
    @Test
    public void test19() {

        String cityFromJson = sandersFritomPojoShipments.getDeliveryAddress().getLocalityName();
        //  System.out.println("cityFromJson = " + cityFromJson);
        int cityFromLabelStart = decodedStringShipments.indexOf("^FT96,235^A0N,23,24^FH^FD") + 33;
        String cityFromLabel = decodedStringShipments.substring(cityFromLabelStart, cityFromLabelStart + cityFromJson.length());
        //    System.out.println("cityFromLabel = " + cityFromLabel);
        assertThat(cityFromJson, is(equalTo(cityFromLabel)));
    }


    @DisplayName("ZPL Destination - countryCode converted to Switzerland")
    @Test
    public void test20() {

        //    System.out.println("dyCountryFromCountryCodeFromJson = " + dyCountryFromCountryCodeFromJson);
        int dyCountryFromCountryCodeFromLabelStart = decodedStringShipments.indexOf("^FT96,260^A0N,23,24^FH^FD") + 25;
        String dyCountryFromCountryCodeFromLabel = decodedStringShipments.substring(dyCountryFromCountryCodeFromLabelStart, dyCountryFromCountryCodeFromLabelStart + dyCountryFromCountryCodeFromJson.length());
        //    System.out.println("dyCountryFromCountryCodeFromLabel = " + dyCountryFromCountryCodeFromLabel);
        assertThat(dyCountryFromCountryCodeFromJson, is(equalTo(dyCountryFromCountryCodeFromLabel)));

    }


    @DisplayName("ZPL Destination - PhoneNumber : (31)497-532-323")
    @Test
    public void test21() {

        String phoneNumberFromJson = sandersFritomPojoShipments.getDeliveryAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("phoneNumberFromJson = " + phoneNumberFromJson);
        int phoneNumberFromLabelStart = decodedStringShipments.indexOf("^FT96,285^A0N,23,24^FH^FDtel: ") + 30;
        String phoneNumberFromLabel = decodedStringShipments.substring(phoneNumberFromLabelStart, phoneNumberFromLabelStart + phoneNumberFromJson.length());
        //    System.out.println("phoneNumberFromLabel = " + phoneNumberFromLabel);
        assertThat(phoneNumberFromJson, is(equalTo(phoneNumberFromLabel)));
    }


    @DisplayName("ZPL Reference - Ship # : 4706850")
    @Test
    public void test22() {

        String shipNumberFromJson = sandersFritomPojoShipments.getShipperRef();
        //    System.out.println("shipNumberFromJson = " + shipNumberFromJson);
        int shipNumberFromLabelStart = decodedStringShipments.indexOf("^FT107,370^A0N,23,24^FH^FD") + 26;
        String shipNumberFromLabel = decodedStringShipments.substring(shipNumberFromLabelStart, shipNumberFromLabelStart + shipNumberFromJson.length());
        //    System.out.println("shipNumberFromLabel = " + shipNumberFromLabel);
        assertThat(shipNumberFromJson, is(equalTo(shipNumberFromLabel)));
    }


    @DisplayName("ZPL Reference - Unit # : 4706850")
    @Test
    public void test23() {

        String unitNumberFromJson = sandersFritomPojoShipments.getShipperRef();
        //   System.out.println("unitNumberFromJson = " + unitNumberFromJson);
        int unitNumberFromLabelStart = decodedStringShipments.indexOf("^FT107,400^A0N,23,24^FH^FD") + 26;
        String unitNumberFromLabel = decodedStringShipments.substring(unitNumberFromLabelStart, unitNumberFromLabelStart + unitNumberFromJson.length());
        //    System.out.println("unitNumberFromLabel = " + unitNumberFromLabel);
        assertThat(unitNumberFromJson, is(equalTo(unitNumberFromLabel)));
    }


    @DisplayName("ZPL Shipping Unit - SU index / Total SU 1 OF 1")
    @Test
    public void test24() {

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


    @DisplayName("ZPL Shipping Unit - Unit Weight : 12.13 KG")
    @Test
    public void test25() {

        String unitWeightFromJson = String.valueOf(sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeight());
        //    System.out.println("unitWeightFromJson = " + unitWeightFromJson);
        String unitWeightUnitOfMeasureFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeightUnitOfMeasure();
        //    System.out.println("unitWeightUnitOfMeasureFromJson = " + unitWeightUnitOfMeasureFromJson);
        int unitWeightFromLabelStart = decodedStringShipments.indexOf("^FT309,430^A0N,23,24^FH^FD") + 26;
        String unitWeightFromLabel = decodedStringShipments.substring(unitWeightFromLabelStart, unitWeightFromLabelStart + (unitWeightFromJson + " " + unitWeightUnitOfMeasureFromJson).length());
        //    System.out.println("unitWeightFromLabel = " + unitWeightFromLabel);
        assertThat(unitWeightFromJson + " " + unitWeightUnitOfMeasureFromJson, is(equalTo(unitWeightFromLabel)));
    }

    @DisplayName("ZPL Shipment - contains INCO:")
    @Test
    public void test26() {

        assertThat(decodedStringShipments, containsString("^FT25,630^A0N,23,24^FH^FDINCO:^FS"));

    }


    @DisplayName("ZPL Shipment - IncotermCode: CPT")
    @Test
    public void test27() {

        String incotermCodeFromJson = sandersFritomPojoShipments.getIncotermCode();
        //    System.out.println("incotermCodeFromJson = " + incotermCodeFromJson);
        int incotermCodeFromLabelStart = decodedStringShipments.indexOf("^FT107,630^A0N,23,24^FH^FD") + 26;
        String incotermCodeFromLabel = decodedStringShipments.substring(incotermCodeFromLabelStart, incotermCodeFromLabelStart + incotermCodeFromJson.length());
        //    System.out.println("incotermCodeFromLabel = " + incotermCodeFromLabel);
        assertThat(decodedStringShipments, containsString("^FT25,630^A0N,23,24^FH^FDINCO:^FS"));
        assertThat(incotermCodeFromJson, is(equalTo(incotermCodeFromLabel)));
    }


    @DisplayName("ZPL Shipment - Deliver By: 2022-01-29 21:16")
    @Test
    public void test28() {

        String deliverByFromJson = sandersFritomPojoShipments.getRequestedDeliveryDateTime().replace("T", " ").substring(0, 16);
        //    System.out.println("deliverByFromJson = " + deliverByFromJson);
        int deliverByFromLabelStart = decodedStringShipments.indexOf("^FT163,630^A0N,23,24^FH^FDDeliver By: ") + 38;
        String deliverByFromLabel = decodedStringShipments.substring(deliverByFromLabelStart, deliverByFromLabelStart + deliverByFromJson.length());
        //    System.out.println("deliverByFromLabel = " + deliverByFromLabel);
        assertThat(deliverByFromJson, is(equalTo(deliverByFromLabel)));
    }


    @DisplayName("ZPL - Serial Number (Barcode): 100000350")
    @Test
    public void test29() {

        String serialNumberFromJson = sandersFritomPojoShipments.getForwarderRef();
        //    System.out.println("serialNumberFromJson = " + serialNumberFromJson);
        int serialNumberFromLabelStart = decodedStringShipments.indexOf("^FT30,880^BCN,185,Y,N^FD>:") + 26;
        String serialNumberFromLabel = decodedStringShipments.substring(serialNumberFromLabelStart, serialNumberFromLabelStart + serialNumberFromJson.length());
        //    System.out.println("serialNumberFromLabel = " + serialNumberFromLabel);
        assertThat(serialNumberFromJson, is(equalTo(serialNumberFromLabel)));
    }


    @DisplayName("ZPL - SSCC (Barcode): 00112345671000003577")
    @Test
    public void test30() {

        String sSCCFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getAdditionalValues().get(0).getValue();
        //    System.out.println("sSCCFromJson = " + sSCCFromJson);
        int sSCCFromLabelStart = decodedStringShipments.indexOf("^FT30,1134^BCN,185,N,N^FD>:") + 27;
        String sSCCFromLabel = decodedStringShipments.substring(sSCCFromLabelStart, sSCCFromLabelStart + sSCCFromJson.length()).replace("(", "").replace(")", "");
        //    System.out.println("sSCCFromLabel = " + sSCCFromLabel);
        assertThat(sSCCFromJson, is(equalTo(sSCCFromLabel)));
    }


    @DisplayName("ZPL - SSCC: 00112345671000003577")
    @Test
    public void test31() {

        String sSCCFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getAdditionalValues().get(0).getValue();
        //    System.out.println("sSCCFromJson = " + sSCCFromJson);
        int sSCCFromLabelStart = decodedStringShipments.indexOf("^FT262,1160^A0N,30,30^FD") + 24;
        String sSCCFromLabel = decodedStringShipments.substring(sSCCFromLabelStart, sSCCFromLabelStart + sSCCFromJson.length() + 2).replace("(", "").replace(")", "");
        //    System.out.println("sSCCFromLabel = " + sSCCFromLabel);
        assertThat(sSCCFromJson, is(equalTo(sSCCFromLabel)));
    }


    @DisplayName("ZPL - PostCode: CH/0001001")
    @Test
    public void test32() {

        String postCodeFromJson = sandersFritomPojoShipments.getDeliveryAddress().getCountryCode() + "/" + sandersFritomPojoShipments.getDeliveryAddress().getPostalCode();
        //    System.out.println("postCodeFromJson = " + postCodeFromJson);
        int postCodeFromLabelStart = decodedStringShipments.indexOf("^FT320,330^A0N,45,45^FH^FD") + 26;
        String postCodeFromLabel = decodedStringShipments.substring(postCodeFromLabelStart, postCodeFromLabelStart + postCodeFromJson.length());
        //    System.out.println("postCodeFromLabel = " + postCodeFromLabel);
        assertThat(postCodeFromJson, is(equalTo(postCodeFromLabel)));
    }


    @DisplayName("ZPL - 2D Barcode - UNA:+.? ")
    @Test
    public void test33() {

        //    System.out.println("decodeArrList.get(0) = " + decodeArrList.get(0));
        assertThat(decodeArrList.get(0), is(equalTo("UNA:+.? ")));
    }


    @DisplayName("ZPL - 2D Barcode - UNB+UNOC:3+VDL-NL:30+SFT+220210:2006+334819++Logistyx TME")
    @Test
    public void test34() {

        //    vSystem.out.println("decodeArrList.get(1) = " + decodeArrList.get(1));
        assertThat(decodeArrList.get(1), is(equalTo("UNB+UNOC:3+" + sandersFritomPojoShipments.getShipperCode() + ":30+" + sandersFritomPojoShipments.getForwarderDivisionCode() + "+" + String.valueOf(yearUTC).substring(2) + monthUTC + dayUTC + ":" + hourUTC + minuteUTC + "+" + sandersFritomPojoShipments.getShipmentId() + "++Logistyx TME")));
    }


    @DisplayName("ZPL - 2D Barcode - UNH+1+IFTMIN:DP:01B:UN:EAN004")
    @Test
    public void test35() {

        //    System.out.println("decodeArrList.get(2) = " + decodeArrList.get(2));
        assertThat(decodeArrList.get(2), is(equalTo("UNH+1+IFTMIN:DP:01B:UN:EAN004")));
    }


    @DisplayName("ZPL - 2D Barcode - BGM+340+100000611+9")
    @Test
    public void test36() {

        //    System.out.println("decodeArrList.get(3) = " + decodeArrList.get(3));
        assertThat(decodeArrList.get(3), is(equalTo("BGM+340+" + sandersFritomPojoShipments.getForwarderRef() + "+9")));
    }


    @DisplayName("ZPL - 2D Barcode - DTM+10:20220127:102")
    @Test
    public void test37() {

        //    System.out.println("decodeArrList.get(4) = " + decodeArrList.get(4));
        assertThat(decodeArrList.get(4), is(equalTo("DTM+10:" + sandersFritomPojoShipments.getRequestedPickupDateTime().replace("-", "").substring(0, 8) + ":102")));
    }


    @DisplayName("ZPL - 2D Barcode - DTM+63:202201292116:203")
    @Test
    public void test38() {

        //    System.out.println("decodeArrList.get(5) = " + decodeArrList.get(5));
        assertThat(decodeArrList.get(5), is(equalTo("DTM+63:" + sandersFritomPojoShipments.getRequestedDeliveryWindowEndDateTime().toString().replace("-", "").replace("T", "").replace(":", "").substring(0, 12) + ":203")));
    }


    @DisplayName("ZPL - 2D Barcode - TSR+++00:STA")
    @Test
    public void test39() {

        //    System.out.println("decodeArrList.get(6) = " + decodeArrList.get(6));
        assertThat(decodeArrList.get(6), is(equalTo("TSR+++00:" + sandersFritomPojoShipments.getForwarderServiceCode().substring(0, 3))));
    }


    @DisplayName("ZPL - 2D Barcode - TSR+++00:STA")
    @Test
    public void test40() {

        //    System.out.println("decodeArrList.get(6) = " + decodeArrList.get(6));
        assertThat(decodeArrList.get(6), is(equalTo("TSR+++00:" + sandersFritomPojoShipments.getForwarderServiceCode().substring(0, 3))));
    }


    @DisplayName("ZPL - 2D Barcode - TOD+6+PP+CPT")
    @Test
    public void test41() {

        //    System.out.println("decodeArrList.get(7) = " + decodeArrList.get(7));
        assertThat(decodeArrList.get(7), is(equalTo("TOD+6+PP+" + sandersFritomPojoShipments.getIncotermCode())));
    }


    @DisplayName("ZPL - 2D Barcode - RFF+AWB:100000611")
    @Test
    public void test42() {

        //    System.out.println("decodeArrList.get(8) = " + decodeArrList.get(8));
        assertThat(decodeArrList.get(8), is(equalTo("RFF+AWB:" + sandersFritomPojoShipments.getForwarderRef())));
    }


    @DisplayName("ZPL - 2D Barcode - RFF+CU:4706850")
    @Test
    public void test43() {

        //    System.out.println("decodeArrList.get(9) = " + decodeArrList.get(9));
        assertThat(decodeArrList.get(9), is(equalTo("RFF+CU:" + sandersFritomPojoShipments.getShipperRef())));
    }


    @DisplayName("ZPL - 2D Barcode - RFF+AAO:RR123456")
    @Test
    public void test44() {

        //    System.out.println("decodeArrList.get(10) = " + decodeArrList.get(10));
        assertThat(decodeArrList.get(10), is(equalTo("RFF+AAO:" + sandersFritomPojoShipments.getReceiverRef())));
    }


    @DisplayName("ZPL - 2D Barcode - NAD+CZ+968888021:ZZZ++PUREF0001+De Grens 27 TEST+Heijen+++5921CC+ES")
    @Test
    public void test45() {

        //    System.out.println("decodeArrList.get(11) = " + decodeArrList.get(11));
        assertThat(decodeArrList.get(11), is(equalTo("NAD+CZ+" + sandersFritomPojoShipments.getPickupForwarderDivisionAccountCode() + ":ZZZ++" + sandersFritomPojoShipments.getAddresses().get(1).getReference() + "+" + sandersFritomPojoShipments.getAddresses().get(1).getAddressLines().get(0).getValue() + "+" + sandersFritomPojoShipments.getAddresses().get(1).getLocalityName() + "+++" + sandersFritomPojoShipments.getAddresses().get(1).getPostalCode() + "+" + sandersFritomPojoShipments.getAddresses().get(1).getCountryCode())));
    }


    @DisplayName("ZPL - 2D Barcode - CTA+IC+Pickup Name One")
    @Test
    public void test46() {

        //    System.out.println("decodeArrList.get(12) = " + decodeArrList.get(12));
        assertThat(decodeArrList.get(12), is(equalTo("CTA+IC+" + sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getName())));
    }


    @DisplayName("ZPL - 2D Barcode - COM+31497532323:TE")
    @Test
    public void test47() {

        //    System.out.println("decodeArrList.get(13) = " + decodeArrList.get(13));
        assertThat(decodeArrList.get(13), is(equalTo("COM+" + sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber() + ":TE")));
    }


    @DisplayName("ZPL - 2D Barcode - COM+vaiser@hotmail?.com:EM")
    @Test
    public void test48() {

        //    System.out.println("decodeArrList.get(14) = " + decodeArrList.get(14));
        assertThat(decodeArrList.get(14), is(equalTo("COM+" + sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getEmailAddress().replace(".", "?.") + ":EM")));
    }


    @DisplayName("ZPL - 2D Barcode - NAD+CN+++FLE >><<01105+Weena 10017 TEST:Delivery address two+VITORIA+++0001001+CH'")
    @Test
    public void test49() {

        //    System.out.println("decodeArrList.get(15) = " + decodeArrList.get(15));
        assertThat(decodeArrList.get(15), is(equalTo("NAD+CN+++" + sandersFritomPojoShipments.getAddresses().get(0).getReference() + "+" + sandersFritomPojoShipments.getAddresses().get(0).getAddressLines().get(0).getValue() + ":" + sandersFritomPojoShipments.getAddresses().get(0).getAddressLines().get(1).getValue() + "+" + sandersFritomPojoShipments.getAddresses().get(0).getLocalityName() + "+++" + sandersFritomPojoShipments.getAddresses().get(0).getPostalCode() + "+" + sandersFritomPojoShipments.getAddresses().get(0).getCountryCode())));
    }


    @DisplayName("ZPL - 2D Barcode - CTA+IC+Delivery Co<<ntact Name 1")
    @Test
    public void test50() {

        //    System.out.println("decodeArrList.get(16) = " + decodeArrList.get(16));
        assertThat(decodeArrList.get(16), is(equalTo("CTA+IC+" + sandersFritomPojoShipments.getDeliveryAddress().getContacts().get(0).getName())));
    }


    @DisplayName("ZPL - 2D Barcode - COM+(31)497-532-323:TE")
    @Test
    public void test51() {

        //    System.out.println("decodeArrList.get(17) = " + decodeArrList.get(17));
        assertThat(decodeArrList.get(17), is(equalTo("COM+" + sandersFritomPojoShipments.getDeliveryAddress().getContacts().get(0).getPhoneNumber() + ":TE")));
    }


    @DisplayName("ZPL - 2D Barcode - COM+vaiser@hotmail?.com:EM")
    @Test
    public void test52() {

        //    System.out.println("decodeArrList.get(18) = " + decodeArrList.get(18));
        assertThat(decodeArrList.get(18), is(equalTo("COM+" + sandersFritomPojoShipments.getDeliveryAddress().getContacts().get(0).getEmailAddress().replace(".", "?.") + ":EM")));
    }


    @DisplayName("ZPL - 2D Barcode - GID+1+1:PC")
    @Test
    public void test53() {

        //    System.out.println("decodeArrList.get(19) = " + decodeArrList.get(19));
        assertThat(decodeArrList.get(19), is(equalTo("GID+" + sandersFritomPojoShipments.getShippingUnits().get(0).getIndex() + "+1:" + sandersFritomPojoShipments.getShippingUnits().get(0).getPackageType())));
    }


    @DisplayName("ZPL - 2D Barcode - MEA+AAI+AAW+KGM:12.1")
    @Test
    public void test54() {

        //    System.out.println("decodeArrList.get(20) = " + decodeArrList.get(20));
        assertThat(decodeArrList.get(20), is(equalTo("MEA+AAI+AAW+" + sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeightUnitOfMeasure().replace(" ", "M") + ":" + Precision.round(weightInKilos, 1))));
    }


    @DisplayName("ZPL - 2D Barcode - DIM+2+MTR:37.00:26.50:4.00")
    @Test
    public void test55() {


        //    System.out.println("decodeArrList.get(21) = " + decodeArrList.get(21));
        assertThat(decodeArrList.get(21), is(equalTo("DIM+2+MTR:" + String.format("%.2f", sandersFritomPojoShipments.getShippingUnits().get(0).getLength()) + ":" + String.format("%.2f", sandersFritomPojoShipments.getShippingUnits().get(0).getWidth()) + ":" + String.format("%.2f", sandersFritomPojoShipments.getShippingUnits().get(0).getHeight()))));
    }


    @DisplayName("ZPL - 2D Barcode - RFF+CU:4706850")
    @Test
    public void test56() {


        //    System.out.println("decodeArrList.get(22) = " + decodeArrList.get(22));
        assertThat(decodeArrList.get(22), is(equalTo("RFF+CU:" + sandersFritomPojoShipments.getShipperRef())));
    }


    @DisplayName("ZPL - 2D Barcode - RFF+AAO:3058986")
    @Test
    public void test57() {


        //    System.out.println("decodeArrList.get(23) = " + decodeArrList.get(23));
        assertThat(decodeArrList.get(23), is(equalTo("RFF+AAO:" + sandersFritomPojoShipments.getShippingUnits().get(0).getReceiverRef())));
    }


    @DisplayName("ZPL - 2D Barcode - PCI+18+100000768")
    @Test
    public void test58() {

        //    System.out.println("decodeArrList.get(24) = " + decodeArrList.get(24));
        assertThat(decodeArrList.get(24), is(equalTo("PCI+18+" + sandersFritomPojoShipments.getShippingUnits().get(0).getForwarderRef())));
    }


    @DisplayName("ZPL - 2D Barcode - UNT+24+1")
    @Test
    public void test59() {


        //    System.out.println("decodeArrList.get(25) = " + decodeArrList.get(25));
        assertThat(decodeArrList.get(25), is(equalTo("UNT+" + (decodeArrList.indexOf(decodeArrList.get(25).toString()) - 1) + "+" + sandersFritomPojoShipments.getShippingUnits().get(0).getIndex())));
    }


    @DisplayName("ZPL - 2D Barcode - UNZ+1+337075")
    @Test
    public void test60() {

        //    System.out.println("decodeArrList.get(26) = " + decodeArrList.get(26));
        assertThat(decodeArrList.get(26), is(equalTo("UNZ+" + sandersFritomPojoShipments.getNumberOfShippingUnits() + "+" + sandersFritomPojoShipments.getShipmentId())));
    }


    @DisplayName("EDI - contains - version Data : <?xml version=\"1.0\" encoding=\"UTF-8\" ?>")
    @Test
    public void test61() {

        assertThat(decodedStringConveyances, containsString("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"));
    }


    @DisplayName("EDI - contains <FRITOM_SHIPMENT_XML>")
    @Test
    public void test62() {


        assertThat(decodedStringConveyances, containsString("<FRITOM_SHIPMENT_XML>"));
    }


    @DisplayName("EDI - FritomCompany = SandersFritom")
    @Test
    public void test63() {

        String fritomCompanyEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getString("FRITOMCOMPANY");
        //    System.out.println("fritomCompanyEDI = " + fritomCompanyEDI);
        assertThat(fritomCompanyEDI, is(equalTo("SandersFritom")));

    }


    @DisplayName("EDI - TIMESTAMP: <TIMESTAMP>2022-02-04T16:04:34</TIMESTAMP>")
    @Test
    public void test64() {

        String timestampEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getString("TIMESTAMP");
        //    System.out.println("timestampEDI = " + timestampEDI);
        assertThat(timestampEDI.substring(0, 16), is(equalTo(dateTimeUTC.toString().substring(0, 16))));

    }


    @DisplayName("EDI - Version = <VERSION>1.6</VERSION>")
    @Test
    public void test65() {

        String versionEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getDouble("VERSION"));
        //    System.out.println("versionEDI = " + versionEDI);
        assertThat(versionEDI, is(equalTo("1.6")));
    }


    @Disabled
    @DisplayName("EDI - trackingID = (set to s.ShipperRef) 4706850")
    @Test
    public void test66() {

        String trackingIdFromJson = sandersFritomPojoShipments.getShipperRef();
        //    System.out.println("trackingIdFromJson = " + trackingIdFromJson);
        String trackingIdEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getInt("TRACKINGID"));
        //    System.out.println("trackingIdEDI = " + trackingIdEDI);
        assertThat(trackingIdFromJson, is(equalTo(trackingIdEDI)));
    }


    @DisplayName("EDI - REFERENCE = (set to s.ShipperRef) 4706850")
    @Test
    public void test67() {

        String referenceFromJson = sandersFritomPojoShipments.getShipperRef();
        //    System.out.println("referenceFromJson = " + referenceFromJson);
        String referenceIdEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getInt("REFERENCE"));
        //    System.out.println("referenceIdEDI = " + referenceIdEDI);
        assertThat(referenceFromJson, is(equalTo(referenceIdEDI)));
    }


    @DisplayName("EDI - COD_AMOUNT present <COD_AMOUNT/>")
    @Test
    public void test68() {

        assertThat(decodedStringConveyances, containsString("<COD_AMOUNT/>"));
    }


    @DisplayName("EDI - COD_VAL present <COD_VAL/>")
    @Test
    public void test69() {

        assertThat(decodedStringConveyances, containsString("<COD_VAL/>"));
    }


    @DisplayName("EDI - IncotermCode = <INCOTERMS>CPT</INCOTERMS>")
    @Test
    public void test70() {

        String incotermCodeFromJson = sandersFritomPojoShipments.getIncotermCode();
        //    System.out.println("incotermCodeFromJson = " + incotermCodeFromJson);
        String incotermCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getString("INCOTERMS");
        //    System.out.println("incotermCodeEDI = " + incotermCodeEDI);
        assertThat(incotermCodeFromJson, is(equalTo(incotermCodeEDI)));
    }


    @DisplayName("EDI - customer CODE : <CODE>968888021</CODE>")
    @Test
    public void test71() {

        String customerCodeFromJson = sandersFritomPojoShipments.getPickupForwarderDivisionAccountCode();
        //    System.out.println("customerCodeFromJson = " + customerCodeFromJson);
        String customerCodeEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getInt("CODE"));
        //    System.out.println("customerCodeEDI = " + customerCodeEDI);
        assertThat(customerCodeFromJson, is(equalTo(customerCodeEDI)));
    }


    @DisplayName("EDI - customer Name : <NAME><![CDATA[PUREF0001]]></NAME>")
    @Test
    public void test72() {

        String customerNameFromJson = sandersFritomPojoShipments.getAddresses().get(1).getReference();
        //    System.out.println("customerNameFromJson = " + customerNameFromJson);
        String customerNameEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("NAME");
        //    System.out.println("customerNameEDI = " + customerNameEDI);
        assertThat(customerNameFromJson, is(equalTo(customerNameEDI)));
    }


    @DisplayName("EDI - customer Name2 : <NAME2><![CDATA[Pickup Name One]]></NAME2>")
    @Test
    public void test73() {

        String customerName2FromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getName();
        //    System.out.println("customerName2FromJson = " + customerName2FromJson);
        String customerName2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("NAME2");
        //    System.out.println("customerName2EDI = " + customerName2EDI);
        assertThat(customerName2FromJson, is(equalTo(customerName2EDI)));
    }


    @DisplayName("EDI - customer Address : <ADDRESS><![CDATA[De Grens 27 TEST]]></ADDRESS>")
    @Test
    public void test74() {

        String customerAddressFromJson = sandersFritomPojoShipments.getPickupAddress().getAddressLines().get(0).getValue();
        //    System.out.println("customerAddressFromJson = " + customerAddressFromJson);
        String customerAddressEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("ADDRESS");
        //    System.out.println("customerAddressEDI = " + customerAddressEDI);
        assertThat(customerAddressFromJson, is(equalTo(customerAddressEDI)));
    }


    @DisplayName("EDI - customer postalCode : <POSTALCODE>5921CC</POSTALCODE>")
    @Test
    public void test75() {

        String customerPostalCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("customerPostalCodeFromJson = " + customerPostalCodeFromJson);
        String customerPostalCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("POSTALCODE");
        //    System.out.println("customerPostalCodeEDI = " + customerPostalCodeEDI);
        assertThat(customerPostalCodeFromJson, is(equalTo(customerPostalCodeEDI)));
    }


    @DisplayName("EDI - customer City : <CITY><![CDATA[Heijen]]></CITY>")
    @Test
    public void test76() {

        String customerCityFromJson = sandersFritomPojoShipments.getPickupAddress().getLocalityName();
        //    System.out.println("customerCityFromJson = " + customerCityFromJson);
        String customerCityEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("CITY");
        //    System.out.println("customerCityEDI = " + customerCityEDI);
        assertThat(customerCityFromJson, is(equalTo(customerCityEDI)));
    }


    @DisplayName("EDI - customer countryCode : <COUNTRYCODE>ES</COUNTRYCODE>")
    @Test
    public void test77() {

        String customerCountryCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getCountryCode();
        //    System.out.println("customerCountryCodeFromJson = " + customerCountryCodeFromJson);
        String customerCountryCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("COUNTRYCODE");
        //    System.out.println("customerCountryCodeEDI = " + customerCountryCodeEDI);
        assertThat(customerCountryCodeFromJson, is(equalTo(customerCountryCodeEDI)));
    }


    @DisplayName("EDI - customer phoneNumber : <PHONE>31497532323</PHONE>")
    @Test
    public void test78() {

        String customerPhoneNumberFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("customerPhoneNumberFromJson = " + customerPhoneNumberFromJson);
        String customerPhoneNumberEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getBigInteger("PHONE"));
        //    System.out.println("customerPhoneNumberEDI = " + customerPhoneNumberEDI);
        assertThat(customerPhoneNumberFromJson, is(equalTo(customerPhoneNumberEDI)));
    }


    @DisplayName("EDI - customer Email : <EMAIL>vaiser@hotmail.com</EMAIL>")
    @Test
    public void test79() {

        String customerEmailFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getEmailAddress();
        //    System.out.println("customerEmailFromJson = " + customerEmailFromJson);
        String customerEmailEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("CUSTOMER").getJSONObject("ADDRESS").getString("EMAIL");
        //    System.out.println("customerEmailEDI = " + customerEmailEDI);
        assertThat(customerEmailFromJson, is(equalTo(customerEmailEDI)));
    }


    @DisplayName("EDI - invoice CODE : <CODE>968888021</CODE>")
    @Test
    public void test80() {

        String invoiceCodeFromJson = sandersFritomPojoShipments.getPickupForwarderDivisionAccountCode();
        //    System.out.println("invoiceCodeFromJson = " + invoiceCodeFromJson);
        String invoiceCodeEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getInt("CODE"));
        //    System.out.println("invoiceCodeEDI = " + invoiceCodeEDI);
        assertThat(invoiceCodeFromJson, is(equalTo(invoiceCodeEDI)));
    }


    @DisplayName("EDI - invoice Name : <NAME><![CDATA[PUREF0001]]></NAME>")
    @Test
    public void test81() {

        String invoiceNameFromJson = sandersFritomPojoShipments.getAddresses().get(1).getReference();
        //    System.out.println("invoiceNameFromJson = " + invoiceNameFromJson);
        String invoiceNameEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("NAME");
        //    System.out.println("invoiceNameEDI = " + invoiceNameEDI);
        assertThat(invoiceNameFromJson, is(equalTo(invoiceNameEDI)));
    }


    @DisplayName("EDI - invoice Name2 : <NAME2><![CDATA[Pickup Name One]]></NAME2>  ")
    @Test
    public void test82() {

        String invoiceName2FromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getName();
        //    System.out.println("invoiceName2FromJson = " + invoiceName2FromJson);
        String invoiceName2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("NAME2");
        //    System.out.println("invoiceName2EDI = " + invoiceName2EDI);
        assertThat(invoiceName2FromJson, is(equalTo(invoiceName2EDI)));
    }


    @DisplayName("EDI - invoice Address : <ADDRESS><![CDATA[De Grens 27 TEST]]></ADDRESS>")
    @Test
    public void test83() {

        String invoiceAddressFromJson = sandersFritomPojoShipments.getPickupAddress().getAddressLines().get(0).getValue();
        //    System.out.println("invoiceAddressFromJson = " + invoiceAddressFromJson);
        String invoiceAddressEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("ADDRESS");
        //    System.out.println("invoiceAddressEDI = " + invoiceAddressEDI);
        assertThat(invoiceAddressFromJson, is(equalTo(invoiceAddressEDI)));
    }


    @DisplayName("EDI - invoice postalCode : <POSTALCODE>5921CC</POSTALCODE>")
    @Test
    public void test84() {

        String invoicePostalCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("invoicePostalCodeFromJson = " + invoicePostalCodeFromJson);
        String invoicePostalCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("POSTALCODE");
        //    System.out.println("invoicePostalCodeEDI = " + invoicePostalCodeEDI);
        assertThat(invoicePostalCodeFromJson, is(equalTo(invoicePostalCodeEDI)));
    }


    @DisplayName("EDI - invoice City : <CITY><![CDATA[Heijen]]></CITY>")
    @Test
    public void test85() {

        String invoiceCityFromJson = sandersFritomPojoShipments.getPickupAddress().getLocalityName();
        //    System.out.println("invoiceCityFromJson = " + invoiceCityFromJson);
        String invoiceCityEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("CITY");
        //    System.out.println("invoiceCityEDI = " + invoiceCityEDI);
        assertThat(invoiceCityFromJson, is(equalTo(invoiceCityEDI)));
    }


    @DisplayName("EDI - invoice countryCode : <COUNTRYCODE>ES</COUNTRYCODE>")
    @Test
    public void test86() {

        String invoiceCountryCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getCountryCode();
        //    System.out.println("invoiceCountryCodeFromJson = " + invoiceCountryCodeFromJson);
        String invoiceCountryCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("COUNTRYCODE");
        //    System.out.println("invoiceCountryCodeEDI = " + invoiceCountryCodeEDI);
        assertThat(invoiceCountryCodeFromJson, is(equalTo(invoiceCountryCodeEDI)));
    }


    @DisplayName("EDI - invoice phoneNumber : <PHONE>31497532323</PHONE>")
    @Test
    public void test87() {

        String invoicePhoneNumberFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("invoicePhoneNumberFromJson = " + invoicePhoneNumberFromJson);
        String invoicePhoneNumberEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getBigInteger("PHONE"));
        //    System.out.println("invoicePhoneNumberEDI = " + invoicePhoneNumberEDI);
        assertThat(invoicePhoneNumberFromJson, is(equalTo(invoicePhoneNumberEDI)));
    }


    @DisplayName("EDI - invoice Email : <EMAIL>vaiser@hotmail.com</EMAIL>")
    @Test
    public void test88() {

        String invoiceEmailFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getEmailAddress();
        //    System.out.println("invoiceEmailFromJson = " + invoiceEmailFromJson);
        String invoiceEmailEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("INVOICE").getJSONObject("ADDRESS").getString("EMAIL");
        //    System.out.println("invoiceEmailEDI = " + invoiceEmailEDI);
        assertThat(invoiceEmailFromJson, is(equalTo(invoiceEmailEDI)));
    }


    @DisplayName("EDI - loading Restriction = PICKUP_ROOF_LOAD -> <RESTRICTION>Dak</RESTRICTION>")
    @Test
    public void test89() {

        //    System.out.println("restrictionValueFromJsonMap.get(\"PICKUP_ROOF_LOAD\") = " + restrictionValueFromJsonMap.get("PICKUP_ROOF_LOAD"));
        String loadingRestrictionEDI = (String) jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("RESTRICTIONS").getJSONArray("RESTRICTION").get(0);
        //    System.out.println("loadingRestrictionEDI = " + loadingRestrictionEDI);
        assertThat(restrictionValueFromJsonMap.get("PICKUP_ROOF_LOAD"), is(equalTo(loadingRestrictionEDI)));
    }


    @DisplayName("EDI - loading Restriction = PICKUP_HIAB -> <RESTRICTION>Kraan</RESTRICTION>")
    @Test
    public void test90() {

        //    System.out.println("restrictionValueFromJsonMap.get(\"PICKUP_HIAB\") = " + restrictionValueFromJsonMap.get("PICKUP_HIAB"));
        String loadingRestrictionEDI = (String) jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("RESTRICTIONS").getJSONArray("RESTRICTION").get(1);
        //    System.out.println("loadingRestrictionEDI = " + loadingRestrictionEDI);
        assertThat(restrictionValueFromJsonMap.get("PICKUP_HIAB"), is(equalTo(loadingRestrictionEDI)));
    }


    @DisplayName("EDI - loading Restriction = PICKUP_SIDE_LOAD -> <RESTRICTION>Zijkant</RESTRICTION>")
    @Test
    public void test91() {

        //    System.out.println("restrictionValueFromJsonMap.get(\"PICKUP_SIDE_LOAD\") = " + restrictionValueFromJsonMap.get("PICKUP_SIDE_LOAD"));
        String loadingRestrictionEDI = (String) jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("RESTRICTIONS").getJSONArray("RESTRICTION").get(2);
        //    System.out.println("loadingRestrictionEDI = " + loadingRestrictionEDI);
        assertThat(restrictionValueFromJsonMap.get("PICKUP_SIDE_LOAD"), is(equalTo(loadingRestrictionEDI)));

    }


    @DisplayName("EDI - loading Correct pick up start date")
    @Test
    public void test92() {

        String loadingDate1FromJson = sandersFritomPojoShipments.getRequestedPickupDateTime().substring(0, 10);
        //    System.out.println("loadingDate1FromJson = " + loadingDate1FromJson);
        String loadingDate1EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getString("DATE1");
        //    System.out.println("loadingDate1EDI = " + loadingDate1EDI);
        assertThat(loadingDate1FromJson, is(equalTo(loadingDate1EDI)));
    }


    @DisplayName("EDI - loading Correct pick up end date")
    @Test
    public void test93() {

        if (sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime() != null) {
            if (sandersFritomPojoShipments.getRequestedPickupDateTime().equals(sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime())) {
                assertThat(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getString("DATE2"), is(equalTo("")));
            } else {
                String loadingDate2FromJson = sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime().substring(0, 10);
                //    System.out.println("loadingDate2FromJson = " + loadingDate2FromJson);
                String loadingDate2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getString("DATE2");
                //    System.out.println("loadingDate2EDI = " + loadingDate2EDI);
                assertThat(loadingDate2FromJson, is(equalTo(loadingDate2EDI)));
            }
        } else {
            String loadingDate2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getString("DATE2");
            //    System.out.println("loadingDate2EDI = " + loadingDate2EDI);
            assertThat(loadingDate2EDI, is(equalTo("")));
        }
    }


    @DisplayName("EDI - loading Correct pick up start time")
    @Test
    public void test94() {

        if (requestJsonBodyShipments.contains("RequestedPickupWindowBeginDateTime") && requestJsonBodyShipments.contains("RequestedPickupWindowEndDateTime")) {
            if (sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime() != null) {
                String loadingTime1FromJson = sandersFritomPojoShipments.getRequestedPickupWindowBeginDateTime().substring(11, 19);
                String loadingTime1FromSettings = "08:00:00";
                String loadingTime1EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getString("TIME1");

                if (sandersFritomPojoShipments.getRequestedPickupDateTime().equals(sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime())) {
                    if (sandersFritomPojoShipments.getRequestedPickupWindowBeginDateTime() != null) {
                        assertThat(loadingTime1FromJson, is(equalTo(loadingTime1EDI)));
                    } else {
                        assertThat(loadingTime1FromSettings, is(equalTo(loadingTime1EDI)));
                    }
                } else {
                    assertThat(loadingTime1EDI, is(equalTo("")));
                    System.out.println("Time1 is empty");
                }
            } else {
                assertThat(sandersFritomPojoShipments.getRequestedPickupWindowBeginDateTime(), nullValue());
                System.out.println("'RequestedPickupDateTime' or 'RequestedPickupWindowEndDateTime' are null");
            }
        } else {
            assertThat(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getString("TIME1"), is(equalTo("08:00:00")));
            System.out.println("RequestJsonBodyShipments does not contains 'RequestedPickupWindowBeginDateTime' or 'RequestedPickupWindowEndDateTime'");
        }
    }

    @DisplayName("EDI - loading Correct pick up end time")
    @Test
    public void test95() {

        if (requestJsonBodyShipments.contains("RequestedPickupWindowEndDateTime")) {
            if (sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime() != null) {
                String loadingTime2FromJson = sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime().substring(11, 19);
                String loadingTime2FromSettings = "17:00:00";
                String loadingTime2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getString("TIME2");

                if (sandersFritomPojoShipments.getRequestedPickupDateTime().equals(sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime())) {
                    if (sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime() != null) {
                        assertThat(loadingTime2FromJson, is(equalTo(loadingTime2EDI)));
                    } else {
                        assertThat(loadingTime2FromSettings, is(equalTo(loadingTime2EDI)));
                    }
                } else {
                    assertThat(loadingTime2EDI, is(equalTo("")));
                    System.out.println("Time2 is empty");
                }
            } else {
                assertThat(sandersFritomPojoShipments.getRequestedPickupWindowEndDateTime(), nullValue());
                System.out.println("'RequestedPickupWindowEndDateTime' is null");
            }
        } else {
            assertThat(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getString("TIME2"), is(equalTo("17:00:00")));
            System.out.println("RequestJsonBodyShipments does not contains 'RequestedPickupWindowEndDateTime'");
        }
    }


    @DisplayName("EDI - loading Name : <NAME><![CDATA[PUREF0001]]></NAME>")
    @Test
    public void test96() {

        String loadingNameFromJson = sandersFritomPojoShipments.getAddresses().get(1).getReference();
        //    System.out.println("loadingNameFromJson = " + loadingNameFromJson);
        String loadingNameEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("NAME");
        //    System.out.println("loadingNameEDI = " + loadingNameEDI);
        assertThat(loadingNameFromJson, is(equalTo(loadingNameEDI)));
    }


    @DisplayName("EDI - loading Name2 : <NAME2><![CDATA[Pickup Name One]]></NAME2>")
    @Test
    public void test97() {

        String loadingName2FromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getName();
        //    System.out.println("loadingName2FromJson = " + loadingName2FromJson);
        String loadingName2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("NAME2");
        //    System.out.println("loadingName2EDI = " + loadingName2EDI);
        assertThat(loadingName2FromJson, is(equalTo(loadingName2EDI)));
    }


    @DisplayName("EDI - loading Address : <ADDRESS><![CDATA[De Grens 27 TEST]]></ADDRESS>")
    @Test
    public void test98() {

        String loadingAddressFromJson = sandersFritomPojoShipments.getPickupAddress().getAddressLines().get(0).getValue();
        //    System.out.println("loadingAddressFromJson = " + loadingAddressFromJson);
        String loadingAddressEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("ADDRESS");
        //    System.out.println("loadingAddressEDI = " + loadingAddressEDI);
        assertThat(loadingAddressFromJson, is(equalTo(loadingAddressEDI)));
    }


    @DisplayName("EDI - loading postalCode : <POSTALCODE>5921CC</POSTALCODE>")
    @Test
    public void test99() {

        String loadingPostalCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("loadingPostalCodeFromJson = " + loadingPostalCodeFromJson);
        String loadingPostalCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("POSTALCODE");
        //    System.out.println("loadingPostalCodeEDI = " + loadingPostalCodeEDI);
        assertThat(loadingPostalCodeFromJson, is(equalTo(loadingPostalCodeEDI)));
    }


    @DisplayName("EDI - loading City : <CITY><![CDATA[Heijen]]></CITY>")
    @Test
    public void test100() {

        String loadingCityFromJson = sandersFritomPojoShipments.getPickupAddress().getLocalityName();
        //    System.out.println("loadingCityFromJson = " + loadingCityFromJson);
        String loadingCityEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("CITY");
        //    System.out.println("loadingCityEDI = " + loadingCityEDI);
        assertThat(loadingCityFromJson, is(equalTo(loadingCityEDI)));
    }


    @DisplayName("EDI - loading countryCode : <COUNTRYCODE>ES</COUNTRYCODE>")
    @Test
    public void test101() {

        String loadingCountryCodeFromJson = sandersFritomPojoShipments.getPickupAddress().getCountryCode();
        //    System.out.println("loadingCountryCodeFromJson = " + loadingCountryCodeFromJson);
        String loadingCountryCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("COUNTRYCODE");
        //    System.out.println("loadingCountryCodeEDI = " + loadingCountryCodeEDI);
        assertThat(loadingCountryCodeFromJson, is(equalTo(loadingCountryCodeEDI)));
    }


    @DisplayName("EDI - loading phoneNumber : <PHONE>31497532323</PHONE>")
    @Test
    public void test102() {

        String loadingPhoneNumberFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("loadingPhoneNumberFromJson = " + loadingPhoneNumberFromJson);
        String loadingPhoneNumberEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getBigInteger("PHONE"));
        //    System.out.println("loadingPhoneNumberEDI = " + loadingPhoneNumberEDI);
        assertThat(loadingPhoneNumberFromJson, is(equalTo(loadingPhoneNumberEDI)));
    }


    @DisplayName("EDI - loading Email : <EMAIL>vaiser@hotmail.com</EMAIL>")
    @Test
    public void test103() {

        String loadingEmailFromJson = sandersFritomPojoShipments.getPickupAddress().getContacts().get(0).getEmailAddress();
        //    System.out.println("loadingEmailFromJson = " + loadingEmailFromJson);
        String loadingEmailEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("ADDRESS").getString("EMAIL");
        //    System.out.println("loadingEmailEDI = " + loadingEmailEDI);
        assertThat(loadingEmailFromJson, is(equalTo(loadingEmailEDI)));
    }


    @DisplayName("EDI - unloading Restriction = DELIVERY_ROOF_LOAD -> <RESTRICTION>Dak</RESTRICTION>")
    @Test
    public void test104() {

        //    System.out.println("restrictionValueFromJsonMap.get(\"DELIVERY_ROOF_LOAD\") = " + restrictionValueFromJsonMap.get("DELIVERY_ROOF_LOAD"));
        String unloadingRestrictionEDI = (String) jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("LOADING").getJSONObject("RESTRICTIONS").getJSONArray("RESTRICTION").get(0);
        //    System.out.println("unloadingRestrictionEDI = " + unloadingRestrictionEDI);
        assertThat(restrictionValueFromJsonMap.get("DELIVERY_ROOF_LOAD"), is(equalTo(unloadingRestrictionEDI)));

    }


    @DisplayName("EDI - unloading Correct delivery date")
    @Test
    public void test105() {

        String unloadingDate1FromJson = sandersFritomPojoShipments.getRequestedDeliveryDateTime().substring(0, 10);
        //    System.out.println("unloadingDate1FromJson = " + unloadingDate1FromJson);
        String unloadingDate1EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getString("DATE1");
        //    System.out.println("unloadingDate1EDI = " + unloadingDate1EDI);
        assertThat(unloadingDate1FromJson, is(equalTo(unloadingDate1EDI)));
    }


    @DisplayName("EDI - unloading Correct pick up end date")
    @Test
    public void test106() {

        if (sandersFritomPojoShipments.getRequestedDeliveryWindowEndDateTime() != null) {
            if (sandersFritomPojoShipments.getRequestedDeliveryDateTime().equals(sandersFritomPojoShipments.getRequestedDeliveryWindowEndDateTime())) {
                assertThat(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getString("DATE2"), is(equalTo("")));
            } else {
                String unloadingDate2FromJson = sandersFritomPojoShipments.getRequestedDeliveryWindowEndDateTime().toString().substring(0, 10);
                //    System.out.println("unloadingDate2FromJson = " + unloadingDate2FromJson);
                String unloadingDate2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getString("DATE2");
                //   System.out.println("unloadingDate2EDI = " + unloadingDate2EDI);
                assertThat(unloadingDate2FromJson, is(equalTo(unloadingDate2EDI)));
            }
        } else {
            String unloadingDate2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getString("DATE2");
            //   System.out.println("unloadingDate2EDI = " + unloadingDate2EDI);
            assertThat(unloadingDate2EDI, is(equalTo("")));
        }
    }


    @DisplayName("EDI - unloading Correct delivery start time")
    @Test
    public void test107() {

        if (requestJsonBodyShipments.contains("RequestedDeliveryWindowBeginDateTime") && requestJsonBodyShipments.contains("RequestedDeliveryWindowEndDateTime")) {
            if (sandersFritomPojoShipments.getRequestedDeliveryWindowEndDateTime() != null) {
                String unloadingTime1FromJson = sandersFritomPojoShipments.getRequestedDeliveryWindowBeginDateTime().toString().substring(11, 19);
                String unloadingTime1FromSettings = "12:00:00";
                String unloadingTime1EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getString("TIME1");

                if (sandersFritomPojoShipments.getRequestedDeliveryDateTime().equals(sandersFritomPojoShipments.getRequestedDeliveryWindowEndDateTime())) {
                    if (sandersFritomPojoShipments.getRequestedDeliveryWindowBeginDateTime() != null) {
                        assertThat(unloadingTime1FromJson, is(equalTo(unloadingTime1EDI)));
                    } else {
                        assertThat(unloadingTime1FromSettings, is(equalTo(unloadingTime1EDI)));
                    }
                } else {
                    assertThat(unloadingTime1EDI, is(equalTo("")));
                    System.out.println("Time1 is empty");
                }
            } else {
                assertThat(sandersFritomPojoShipments.getRequestedDeliveryWindowBeginDateTime(), nullValue());
                System.out.println("'RequestedDeliveryDateTime' or 'RequestedDeliveryWindowEndDateTime' are null");
            }
        } else {
            assertThat(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getString("TIME1"), is(equalTo("08:00:00")));
            System.out.println("RequestJsonBodyShipments does not contains 'RequestedDeliveryWindowBeginDateTime' or 'RequestedDeliveryWindowEndDateTime'");
        }
    }


    @DisplayName("EDI - unloading Correct delivery end time - <TIME2>17:00:00</TIME2> - hardcoded in composer settings")
    @Test
    public void test108() {

        if (requestJsonBodyShipments.contains("RequestedDeliveryWindowEndDateTime")) {
            if (sandersFritomPojoShipments.getRequestedDeliveryWindowEndDateTime() != null) {
                String unloadingTime2FromJson = sandersFritomPojoShipments.getRequestedDeliveryWindowEndDateTime().toString().substring(11, 19);
                String unloadingTime2FromSettings = "17:00:00";
                String unloadingTime2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getString("TIME2");

                if (sandersFritomPojoShipments.getRequestedDeliveryDateTime().equals(sandersFritomPojoShipments.getRequestedDeliveryWindowEndDateTime())) {
                    if (sandersFritomPojoShipments.getRequestedDeliveryWindowEndDateTime() != null) {
                        assertThat(unloadingTime2FromJson, is(equalTo(unloadingTime2EDI)));
                    } else {
                        assertThat(unloadingTime2FromSettings, is(equalTo(unloadingTime2EDI)));
                    }
                } else {
                    assertThat(unloadingTime2EDI, is(equalTo("")));
                    System.out.println("Time2 is empty");
                }
            } else {
                assertThat(sandersFritomPojoShipments.getRequestedDeliveryWindowEndDateTime(), nullValue());
                System.out.println("'RequestedDeliveryWindowEndDateTime' is null");
            }
        } else {
            assertThat(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getString("TIME2"), is(equalTo("17:00:00")));
            System.out.println("RequestJsonBodyShipments does not contains 'RequestedDeliveryWindowEndDateTime'");
        }
    }


    @DisplayName("EDI - unloading Name : <NAME><![CDATA[FLE >><<01105]]></NAME>")
    @Test
    public void test109() {

        String unloadingNameFromJson = sandersFritomPojoShipments.getAddresses().get(0).getReference();
        //    System.out.println("unloadingNameFromJson = " + unloadingNameFromJson);
        String unloadingNameEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("NAME");
        //    System.out.println("unloadingNameEDI = " + unloadingNameEDI);
        assertThat(unloadingNameFromJson, is(equalTo(unloadingNameEDI)));
    }


    @DisplayName("EDI - unloading Name2 : <NAME2><![CDATA[Delivery Co<<ntact Name 1]]></NAME2>")
    @Test
    public void test110() {

        String unloadingName2FromJson = sandersFritomPojoShipments.getAddresses().get(0).getContacts().get(0).getName();
        //    System.out.println("unloadingName2FromJson = " + unloadingName2FromJson);
        String unloadingName2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("NAME2");
        //    System.out.println("unloadingName2EDI = " + unloadingName2EDI);
        assertThat(unloadingName2FromJson, is(equalTo(unloadingName2EDI)));
    }


    @DisplayName("EDI - unloading address : <ADDRESS><![CDATA[Weena 10017 TEST]]></ADDRESS>")
    @Test
    public void test111() {

        String unloadingAddressFromJson = sandersFritomPojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue();
        //    System.out.println("unloadingAddressFromJson = " + unloadingAddressFromJson);
        String unloadingAddressEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("ADDRESS");
        //    System.out.println("unloadingAddressEDI = " + unloadingAddressEDI);
        assertThat(unloadingAddressFromJson, is(equalTo(unloadingAddressEDI)));
    }


    @DisplayName("EDI - unloading address 2 : <ADDRESS2><![CDATA[Delivery address two]]></ADDRESS2>")
    @Test
    public void test112() {

        String unloadingAddress2FromJson = sandersFritomPojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue();
        //    System.out.println("unloadingAddress2FromJson = " + unloadingAddress2FromJson);
        String unloadingAddress2EDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("ADDRESS2");
        //    System.out.println("unloadingAddress2EDI = " + unloadingAddress2EDI);
        assertThat(unloadingAddress2FromJson, is(equalTo(unloadingAddress2EDI)));
    }


    @DisplayName("EDI - unloading postalCode : <POSTALCODE>0001001</POSTALCODE>")
    @Test
    public void test113() {

        String unloadingPostalCodeFromJson = sandersFritomPojoShipments.getDeliveryAddress().getPostalCode();
        //    System.out.println("unloadingPostalCodeFromJson = " + unloadingPostalCodeFromJson);
        String unloadingPostalCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("POSTALCODE");
        //    System.out.println("unloadingPostalCodeEDI = " + unloadingPostalCodeEDI);
        assertThat(unloadingPostalCodeEDI, is(equalTo(unloadingPostalCodeEDI)));
    }


    @DisplayName("EDI - unloading City : <CITY><![CDATA[VITORIA]]></CITY>")
    @Test
    public void test114() {

        String unloadingCityFromJson = sandersFritomPojoShipments.getDeliveryAddress().getLocalityName();
        //    System.out.println("unloadingCityFromJson = " + unloadingCityFromJson);
        String unloadingCityEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("CITY");
        //    System.out.println("unloadingCityEDI = " + unloadingCityEDI);
        assertThat(unloadingCityFromJson, is(equalTo(unloadingCityEDI)));
    }


    @DisplayName("EDI - unloading countryCode : <COUNTRYCODE>CH</COUNTRYCODE>")
    @Test
    public void test115() {

        String unloadingCountryCodeFromJson = sandersFritomPojoShipments.getDeliveryAddress().getCountryCode();
        //    System.out.println("unloadingCountryCodeFromJson = " + unloadingCountryCodeFromJson);
        String unloadingCountryCodeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("COUNTRYCODE");
        //    System.out.println("unloadingCountryCodeEDI = " + unloadingCountryCodeEDI);
        assertThat(unloadingCountryCodeFromJson, is(equalTo(unloadingCountryCodeEDI)));
    }


    @DisplayName("EDI - unloading phoneNumber : <PHONE>(31)497-532-323</PHONE>")
    @Test
    public void test116() {

        String unloadingPhoneNumberFromJson = sandersFritomPojoShipments.getDeliveryAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("unloadingPhoneNumberFromJson = " + unloadingPhoneNumberFromJson);
        String unloadingPhoneNumberEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("PHONE");
        //   System.out.println("unloadingPhoneNumberEDI = " + unloadingPhoneNumberEDI);
        assertThat(unloadingPhoneNumberFromJson, is(equalTo(unloadingPhoneNumberEDI)));
    }


    @DisplayName("EDI - unloading Email : <EMAIL>vaiser@hotmail.com</EMAIL>")
    @Test
    public void test117() {

        String unloadingEmailFromJson = sandersFritomPojoShipments.getDeliveryAddress().getContacts().get(0).getEmailAddress();
        //    System.out.println("unloadingEmailFromJson = " + unloadingEmailFromJson);
        String unloadingEmailEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("UNLOADING").getJSONObject("ADDRESS").getString("EMAIL");
        //    System.out.println("unloadingEmailEDI = " + unloadingEmailEDI);
        assertThat(unloadingEmailFromJson, is(equalTo(unloadingEmailEDI)));
    }


    @DisplayName("EDI - orderline Description : This is the description of the sUnit content value")
    @Test
    public void test118() {

        String orderlineDescriptionFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getContent();
        //    System.out.println("orderlineDescriptionFromJson = " + orderlineDescriptionFromJson);
        String orderlineDescriptionEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getString("ITEMDESCRIPTION");
        //    System.out.println("orderlineDescriptionEDI = " + orderlineDescriptionEDI);
        assertThat(orderlineDescriptionFromJson, containsString(orderlineDescriptionEDI));

    }


    @DisplayName("EDI - orderline UnitCode : <UNITCODE>PAK</UNITCODE>")
    @Test
    public void test119() {

        String orderLineUnitCodeFromJsonConverted = unitcodeValueFromJsonMap.get(unitcodeFromJson);
        //    System.out.println("orderLineUnitCodeFromJsonConverted = " + orderLineUnitCodeFromJsonConverted);
        String orderLineDescriptionEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getString("UNITCODE");
        //    System.out.println("orderLineDescriptionEDI = " + orderLineDescriptionEDI);
        assertThat(orderLineUnitCodeFromJsonConverted, is(equalTo(orderLineDescriptionEDI)));

    }


    @DisplayName("EDI - orderline Quantity : 1")
    @Test
    public void test120() {

        int orderlineQuantityFromJson = sandersFritomPojoShipments.getNumberOfShippingUnits();
        //    System.out.println("orderlineQuantityFromJson = " + orderlineQuantityFromJson);
        int orderlineQuantityEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getInt("QUANTITY");
        //    System.out.println("orderlineQuantityEDI = " + orderlineQuantityEDI);
        assertThat(orderlineQuantityFromJson, is(equalTo(orderlineQuantityEDI)));
    }


    @DisplayName("EDI - orderline GrossWeight : <GROSS_WEIGHT>12.13</GROSS_WEIGHT>")
    @Test
    public void test121() {

        double orderlineGrossWeightFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getGrossWeight();
        //    System.out.println("orderlineGrossWeightFromJson = " + orderlineGrossWeightFromJson);
        double orderlineGrossWeightEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("GROSS_WEIGHT");
        //    System.out.println("orderlineGrossWeightEDI = " + orderlineGrossWeightEDI);
        assertThat(String.format("%.2f", orderlineGrossWeightFromJson), is(equalTo(String.valueOf(orderlineGrossWeightEDI))));
    }


    @DisplayName("EDI - orderline NetWeight : <NET_WEIGHT>12.13</NET_WEIGHT>")
    @Test
    public void test122() {

        double orderlineNetWeightFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getNetWeight();
        //    System.out.println("orderlineNetWeightFromJson = " + orderlineNetWeightFromJson);
        double orderlineNetWeightEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("NET_WEIGHT");
        //    System.out.println("orderlineNetWeightEDI = " + orderlineNetWeightEDI);
        assertThat(String.format("%.2f", orderlineNetWeightFromJson), is(equalTo(String.valueOf(orderlineNetWeightEDI))));
    }


    @DisplayName("EDI - orderline Length : <LENGTH>37.00</LENGTH>")
    @Test
    public void test123() {

        double orderlineLengthFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getLength();
        //    System.out.println("orderlineLengthFromJson = " + orderlineLengthFromJson);
        double orderlineLengthEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("LENGTH");
        //    System.out.println("orderlineLengthEDI = " + orderlineLengthEDI);
        assertThat(String.format("%.1f", orderlineLengthFromJson), is(equalTo(String.format("%.1f", orderlineLengthEDI))));
    }


    @DisplayName("EDI - orderline Width : <WIDTH>26.50</WIDTH>")
    @Test
    public void test124() {

        double orderlineWidthFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getWidth();
        //    System.out.println("orderlineWidthFromJson = " + orderlineWidthFromJson);
        double orderlineWidthEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("WIDTH");
        //    System.out.println("orderlineWidthEDI = " + orderlineWidthEDI);
        assertThat(String.format("%.1f", orderlineWidthFromJson), is(equalTo(String.format("%.1f", orderlineWidthEDI))));
    }


    @DisplayName("EDI - orderline Height : <HEIGHT>4.00</HEIGHT>")
    @Test
    public void test125() {

        double orderlineHeightFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getWidth();
        //    System.out.println("orderlineHeightFromJson = " + orderlineHeightFromJson);
        double orderlineHeightEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("WIDTH");
        //    System.out.println("orderlineHeightEDI = " + orderlineHeightEDI);
        assertThat(String.format("%.1f", orderlineHeightFromJson), is(equalTo(String.format("%.1f", orderlineHeightEDI))));
    }


    @DisplayName("EDI - orderline Volume : <VOLUME>0.14</VOLUME>")
    @Test
    public void test126() {

        double orderlineVolumeFromJson = volumeInCubicMetre;
        //    System.out.println("orderlineVolumeFromJson = " + orderlineVolumeFromJson);
        double orderlineVolumeEDI = jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getDouble("VOLUME");
        //    System.out.println("orderlineVolumeEDI = " + orderlineVolumeEDI);
        assertThat(String.format("%.1f", orderlineVolumeFromJson), is(equalTo(String.format("%.1f", orderlineVolumeEDI))));
    }


    @DisplayName("EDI - orderline Loadingmeter : <LOADINGMETER>408.54</LOADINGMETER>")
    @Test
    public void test127() {

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
    public void test128() {

        String orderlineReferenceFromJson = sandersFritomPojoShipments.getShippingUnits().get(0).getShipperRef();
        //    System.out.println("orderlineReferenceFromJson = " + orderlineReferenceFromJson);
        String orderlineReferenceEDI = String.valueOf(jsonDataEDI.getJSONObject("FRITOM_SHIPMENT_XML").getJSONObject("SHIPMENTS").getJSONObject("SHIPMENT").getJSONObject("ORDERLINES").getJSONObject("ORDERLINE").getInt("REFERENCE"));
        //    System.out.println("orderlineReferenceEDI = " + orderlineReferenceEDI);
        assertThat(orderlineReferenceFromJson, is(equalTo(orderlineReferenceEDI)));
    }


    @DisplayName("Verify the CHECK DIGIT for 00112345671000002587 is correct. We expect: 7 for 11234567100000258")
    @Test
    public void test129() {

        //    System.out.println("sandersFritomPojoShipments.getShippingUnits().get(0).getAdditionalValues().get(0).getValue().substring(2, 19) = " + sandersFritomPojoShipments.getShippingUnits().get(0).getAdditionalValues().get(0).getValue().substring(2, 19));
        //    System.out.println("sandersFritomPojoShipments.getShippingUnits().get(0).getAdditionalValues().get(0).getValue() = " + sandersFritomPojoShipments.getShippingUnits().get(0).getAdditionalValues().get(0).getValue());
        //    System.out.println("checkDigit = " + checkDigit);
        assertThat(sandersFritomPojoShipments.getShippingUnits().get(0).getAdditionalValues().get(0).getValue().substring(19, 20), is(equalTo(String.valueOf(checkDigit))));

    }


    @DisplayName("JSON Body Request")
    @Test
    public void test130() {
        System.out.println("requestJsonBodyShipments = " + requestJsonBodyShipments);
    }


    @DisplayName("JSON Body Response")
    @Test
    public void test131() {
        validateResponseShipments.extract().response().prettyPrint();
    }


}
