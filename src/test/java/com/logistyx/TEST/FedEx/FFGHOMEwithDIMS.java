package com.logistyx.TEST.FedEx;


import com.logistyx.utilities.AbstractBaseClasses.FedExBase.FedExFuseBaseNotDG;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("FFG / HOME with DIMS (LABEL -> HUF)")
public class FFGHOMEwithDIMS extends FedExFuseBaseNotDG {

    static {
        FedExFuseBaseNotDG.shipmentsLabel();
    }


    @DisplayName("ShippingId is not NULL")
    @Test
    public void test1() {

        assertThat(fedExFusePojoShipments.getShipmentId(), is(notNullValue()));
//
//        validateResponseShipments.extract().response().prettyPrint();
//        System.out.println("decodedStringShipments = " + decodedStringShipments);
//        validateResponseConveyances.extract().response().prettyPrint();
//        System.out.println("jsonDataEDI = " + jsonDataEDI);
//        System.out.println("decodedStringConveyancesEDI = " + decodedStringConveyancesEDI);
//        System.out.println("decodedStringConveyancesManifest = " + decodedStringConveyancesManifest);

    }


    @DisplayName("ZPL LABEL is not NULL")
    @Test
    public void test2() {

        assertThat(encodedStringFromPostmanShipments, is(notNullValue()));
    }


    @DisplayName("ZPL LABEL size > 500 characters")
    @Test
    public void test3() {

        assertThat(encodedStringFromPostmanShipments.length(), is(greaterThan(500)));
    }


    @DisplayName("Package Size (L x W x H)")
    @Test
    public void test4() {

        int lengthRoundedFromJson = (int) ((fedExFusePojoShipments.getShippingUnits().get(0).getLength()) * 1);
        int widthRoundedFromJson = (int) ((fedExFusePojoShipments.getShippingUnits().get(0).getWidth()) * 1);
        int heightRoundedFromJson = (int) ((fedExFusePojoShipments.getShippingUnits().get(0).getHeight()) * 1);

        int dimensionsFromLabelStart = decodedStringShipments.indexOf("^FT406,93^A0N,22,22^FDDIMMED:") + 29;
        String dimensionsFromLabel = decodedStringShipments.substring(dimensionsFromLabelStart, dimensionsFromLabelStart + 9);
        //System.out.println("dimensionsFromLabel = " + dimensionsFromLabel);
        assertThat(dimensionsFromLabel, is(equalTo(" " + lengthRoundedFromJson + "x" + widthRoundedFromJson + "x" + heightRoundedFromJson + " " + fedExFusePojoShipments.getShippingUnits().get(0).getDimensionsUnitOfMeasure().trim().toUpperCase())));

    }


    @DisplayName("HUF and PDF are generated")
    @Test
    public void test5() {

        for (int i = 0; i < fedExFusePojoConveyances.getDocuments().size(); i++) {
            if (fedExFusePojoConveyances.getDocuments().get(i).getDocumentFormatCode().contains("HUF")) {
                //    System.out.println("fedExFusePojoConveyances.getDocuments().get(i).getDocumentFormatCode() = " + fedExFusePojoConveyances.getDocuments().get(i).getDocumentFormatCode());
                assertThat(decodedStringConveyancesEDI, containsString("<TrackingIdType>FEDEX</TrackingIdType>"));
                System.out.println("HUF is generated");
            } else if (fedExFusePojoConveyances.getDocuments().get(i).getDocumentFormatCode().contains("PDF")) {
                System.out.println("Label is generated");
                assertThat(fedExFusePojoConveyances.getDocuments().get(i).getContent(), is(notNullValue()));
                assertThat(fedExFusePojoConveyances.getDocuments().get(i).getContent().length(), is(greaterThan(500)));
            }
        }
    }


    @DisplayName("ZPL: Pickup Address 'ORIGIN ID:' exists")
    @Test
    public void test6() {


        String pickupAddressOriginIDFromJson = fedExFusePojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber().replace(" ", "");
        //    System.out.println("pickupAddressOriginIDFromJson = " + pickupAddressOriginIDFromJson);
        int pickupAddressOriginIDFromLabelStart = decodedStringShipments.indexOf("^FT10,27^A0N,22,22^FDORIGIN ID:                     ") + 52;
        String pickupAddressOriginIDFromLabel = decodedStringShipments.substring(pickupAddressOriginIDFromLabelStart, pickupAddressOriginIDFromLabelStart + pickupAddressOriginIDFromJson.length());
        //    System.out.println("pickupAddressContactFromLabel = " + pickupAddressOriginIDFromLabel);
        assertThat(pickupAddressOriginIDFromJson, is(equalTo(pickupAddressOriginIDFromLabel)));
    }


    @DisplayName("ZPL: Pickup Address Contact exists: Contact Name")
    @Test
    public void test7() {

        String pickupAddressContactFromJson = fedExFusePojoShipments.getPickupAddress().getContacts().get(0).getName();
        //    System.out.println("pickupAddressContactFromJson = " + pickupAddressContactFromJson);
        int pickupAddressContactFromLabelStart = decodedStringShipments.indexOf("^FT10,71^A0N,22,22^FD") + 21;
        String pickupAddressContactFromLabel = decodedStringShipments.substring(pickupAddressContactFromLabelStart, pickupAddressContactFromLabelStart + pickupAddressContactFromJson.length());
        //    System.out.println("pickupAddressContactFromLabel = " + pickupAddressContactFromLabel);
        assertThat(pickupAddressContactFromJson.toUpperCase(), is(equalTo(pickupAddressContactFromLabel)));

    }


    @DisplayName("ZPL: Pickup Address Company exists: Company Name")
    @Test
    public void test8() {

        String pickupAddressCompanyFromJson = fedExFusePojoShipments.getPickupAddress().getReference();
        //    System.out.println("pickupAddressCompanyFromJson = " + pickupAddressCompanyFromJson);
        int pickupAddressCompanyFromLabelStart = decodedStringShipments.indexOf("^FT10,49^A0N,22,22^FD") + 21;
        String pickupAddressCompanyFromLabel = decodedStringShipments.substring(pickupAddressCompanyFromLabelStart, pickupAddressCompanyFromLabelStart + pickupAddressCompanyFromJson.length());
        //    System.out.println("pickupAddressContactFromLabel = " + pickupAddressCompanyFromLabel);
        assertThat(pickupAddressCompanyFromJson.toUpperCase(), is(equalTo(pickupAddressCompanyFromLabel)));

    }


    @DisplayName("ZPL: Pickup Address Line 1 exists: Pickup Address Line 1")
    @Test
    public void test9() {

        String pickupAddressLine1FromJson = fedExFusePojoShipments.getPickupAddress().getAddressLines().get(0).getValue();
        //    System.out.println("pickupAddressLine1FromJson = " + pickupAddressLine1FromJson);
        int pickupAddressLine1FromLabelStart = decodedStringShipments.indexOf("^FT10,93^A0N,22,22^FD") + 21;
        String pickupAddressLine1FromLabel = decodedStringShipments.substring(pickupAddressLine1FromLabelStart, pickupAddressLine1FromLabelStart + pickupAddressLine1FromJson.length());
        //    System.out.println("pickupAddressLine1FromLabel = " + pickupAddressLine1FromLabel);
        assertThat(pickupAddressLine1FromJson, is(equalTo(pickupAddressLine1FromLabel)));

    }


    @DisplayName("ZPL: Pickup Address Line 2 exists: Pickup Address Line 2")
    @Test
    public void test10() {

        String pickupAddressLine2FromJson = fedExFusePojoShipments.getPickupAddress().getAddressLines().get(1).getValue();
        //    System.out.println("pickupAddressLine2FromJson = " + pickupAddressLine2FromJson);
        int pickupAddressLine2FromLabelStart = decodedStringShipments.indexOf("^FT10,114^A0N,22,22^FD") + 22;
        String pickupAddressLine2FromLabel = decodedStringShipments.substring(pickupAddressLine2FromLabelStart, pickupAddressLine2FromLabelStart + pickupAddressLine2FromJson.length());
        //    System.out.println("pickupAddressLine2FromLabel = " + pickupAddressLine2FromLabel);
        assertThat(pickupAddressLine2FromJson, is(equalTo(pickupAddressLine2FromLabel)));

    }


    @DisplayName("ZPL: Pickup Address Line 3 exists: City, State, ZIP")
    @Test
    public void test11() {

        String pickupAddressLine3FromJson = fedExFusePojoShipments.getPickupAddress().getLocalityName() + ", " + fedExFusePojoShipments.getPickupAddress().getSubdivisionCode() + " " + fedExFusePojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("pickupAddressLine3FromJson = " + pickupAddressLine3FromJson);
        int pickupAddressLine3FromLabelStart = decodedStringShipments.indexOf("^FT10,136^A0N,22,22^FD") + 22;
        String pickupAddressLine3FromLabel = decodedStringShipments.substring(pickupAddressLine3FromLabelStart, pickupAddressLine3FromLabelStart + pickupAddressLine3FromJson.length());
        //    System.out.println("pickupAddressLine3FromLabel = " + pickupAddressLine3FromLabel);
        assertThat(pickupAddressLine3FromJson.toUpperCase(), is(equalTo(pickupAddressLine3FromLabel)));

    }


    @DisplayName("ZPL: Pickup Address Country exists: Country Code")
    @Test
    public void test12() {

        String pickupAddressLine4FromJson = fedExFusePojoShipments.getPickupAddress().getCountryCode();
        //    System.out.println("pickupAddressLine4FromJson = " + pickupAddressLine4FromJson);
        int pickupAddressLine4FromLabelStart = decodedStringShipments.indexOf("^FT10,158^A0N,22,22^FD") + 22;
        String pickupAddressLine4FromLabel = decodedStringShipments.substring(pickupAddressLine4FromLabelStart, pickupAddressLine4FromLabelStart + pickupAddressLine4FromJson.length());
        //    System.out.println("pickupAddressLine4FromLabel = " + pickupAddressLine4FromLabel);
        assertThat(pickupAddressLine4FromJson, is(equalTo(pickupAddressLine4FromLabel)));
    }


    @DisplayName("ZPL: Ship Date exists: 2022-01-12T20:02:51.987Z")
    @Test
    public void test13() {

        String shipDateFromJson = fedExFusePojoShipments.getRequestedPickupDateTime();
        //    System.out.println("shipDateFromJson = " + shipDateFromJson);
        String shipDayFromJson = shipDateFromJson.substring(8, 10);
        String shipMonthFromJson = shipDateFromJson.substring(5, 7);
        String shipYearFromJson = shipDateFromJson.substring(0, 4);
        switch (shipMonthFromJson) {
            case "01":
                shipMonthFromJson = "JAN";
                break;
            case "02":
                shipMonthFromJson = "FEB";
                break;
            case "03":
                shipMonthFromJson = "MAR";
                break;
            case "04":
                shipMonthFromJson = "APR";
                break;
            case "05":
                shipMonthFromJson = "MAY";
                break;
            case "06":
                shipMonthFromJson = "JUN";
                break;
            case "07":
                shipMonthFromJson = "JUL";
                break;
            case "08":
                shipMonthFromJson = "AUG";
                break;
            case "09":
                shipMonthFromJson = "SEP";
                break;
            case "10":
                shipMonthFromJson = "OCT";
                break;
            case "11":
                shipMonthFromJson = "NOV";
                break;
            case "12":
                shipMonthFromJson = "DEC";
                break;
        }
        //    System.out.println("shipDayFromJson = " + shipDayFromJson);
        //    System.out.println("shipMonthFromJson = " + shipMonthFromJson);
        //    System.out.println("shipYearFromJson = " + shipYearFromJson);

        int shipDateFromLabelStart = decodedStringShipments.indexOf("FT406,27^A0N,22,22^FDSHIP DATE: ") + 32;
        String shipDateFromLabel = decodedStringShipments.substring(shipDateFromLabelStart, shipDateFromLabelStart + 7);
        //    System.out.println("shipDateFromLabel = " + shipDateFromLabel);
        assertThat(shipDayFromJson + shipMonthFromJson + shipYearFromJson.substring(2), is(equalTo(shipDateFromLabel)));
    }


    @DisplayName("Meter Number = 1711")
    @Test
    public void test14() {

        assertThat(decodedStringShipments, containsString("^FT406,71^A0N,22,22^FDCAD: 1711/FUSE0008^FS"));
    }


    @DisplayName("Package Weight: GrossWeight + GrossWeightUnitOfMeasure")
    @Test
    public void test15() {

        String packageWeightFromJson = String.format("%.2f", fedExFusePojoShipments.getShippingUnits().get(0).getGrossWeight());
        //    System.out.println("packageWeightFromJson = " + packageWeightFromJson);
        int packageWeightFromLabelStart = decodedStringShipments.indexOf("^FT406,49^A0N,22,22^FDACTWGT: ") + 30;
        String packageWeightFromLabel = decodedStringShipments.substring(packageWeightFromLabelStart, packageWeightFromLabelStart + (packageWeightFromJson + fedExFusePojoShipments.getShippingUnits().get(0).getGrossWeightUnitOfMeasure()).length());
        //    System.out.println("packageWeightFromLabel = " + packageWeightFromLabel);
        assertThat(packageWeightFromLabel, is(equalTo(packageWeightFromJson + " " + fedExFusePojoShipments.getShippingUnits().get(0).getGrossWeightUnitOfMeasure().toUpperCase().trim())));
    }


    @DisplayName("ZPL: Payment Type exists: BILL SENDER")
    @Test
    public void test16() {

        assertThat(decodedStringShipments, containsString("^FT406,114^A0N,22,22^FDBILL SENDER^FS"));

    }


    @DisplayName("ZPL: Vertical line at top exists")
    @Test
    public void test17() {

        assertThat(decodedStringShipments, containsString("^FO395,9^GB3,168,3,B^FS"));

    }


    @DisplayName("ZPL: Horizontal lines at top exist")
    @Test
    public void test18() {

        assertThat(decodedStringShipments, containsString("^FO3,175^GB761,3,3,B^FS"));

    }


    @DisplayName("ZPL: Delivery Address 'TO' exists")
    @Test
    public void test19() {

        assertThat(decodedStringShipments, containsString("^FT4,204^A0N,14,14^FDTO^FS"));

    }


    @DisplayName("ZPL: Delivery Address Contact exists: ENTER SANDMAN")
    @Test
    public void test20() {

        String deliveryAddressContactFromJson = fedExFusePojoShipments.getAddresses().get(0).getContacts().get(0).getName().toUpperCase();
        //    System.out.println("deliveryAddressContactFromJson = " + deliveryAddressContactFromJson);
        int deliveryAddressContactFromLabelStart = decodedStringShipments.indexOf("^FT22,215^A0N,27,27^FD") + 22;
        String deliveryAddressContactFromLabel = decodedStringShipments.substring(deliveryAddressContactFromLabelStart, deliveryAddressContactFromLabelStart + deliveryAddressContactFromJson.length());
        //    System.out.println("deliveryAddressName1FromLabel = " + deliveryAddressName1FromLabel);
        assertThat(deliveryAddressContactFromJson, is(equalTo(deliveryAddressContactFromLabel)));

    }


    @DisplayName("ZPL: Delivery Address Line 1 exists: Pickup Address Line 1")
    @Test
    public void test21() {


        String deliveryAddressLine1FromJson = fedExFusePojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue();
        //    System.out.println("deliveryAddressLine1FromJson = " + deliveryAddressLine1FromJson);
        int deliveryAddressLine1FromLabelStart = decodedStringShipments.indexOf("^FT22,242^A0N,27,27^FD") + 22;
        String deliveryAddressLine1FromLabel = decodedStringShipments.substring(deliveryAddressLine1FromLabelStart, deliveryAddressLine1FromLabelStart + deliveryAddressLine1FromJson.length());
        //    System.out.println("deliveryAddressLine1FromLabel = " + deliveryAddressLine1FromLabel);
        assertThat(deliveryAddressLine1FromJson, is(equalTo(deliveryAddressLine1FromLabel)));


    }


    @DisplayName("ZPL: Delivery Address Line 2 exists: Pickup Address Line 2")
    @Test
    public void test22() {


        String deliveryAddressLine2FromJson = fedExFusePojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue();
        //    System.out.println("deliveryAddressLine2FromJson = " + deliveryAddressLine2FromJson);
        int deliveryAddressLine2FromLabelStart = decodedStringShipments.indexOf("^FT22,269^A0N,27,27^FD") + 22;
        String deliveryAddressLine2FromLabel = decodedStringShipments.substring(deliveryAddressLine2FromLabelStart, deliveryAddressLine2FromLabelStart + deliveryAddressLine2FromJson.length());
        //    System.out.println("deliveryAddressLine2FromLabel = " + deliveryAddressLine2FromLabel);
        assertThat(deliveryAddressLine2FromJson, is(equalTo(deliveryAddressLine2FromLabel)));

    }


    @DisplayName("ZPL: Delivery Address Line 3 exists: City, State, ZIP")
    @Test
    public void test23() {


        String deliveryAddressLine3FromJson = fedExFusePojoShipments.getDeliveryAddress().getLocalityName().toUpperCase() + ", " + fedExFusePojoShipments.getDeliveryAddress().getSubdivisionCode() + " " + fedExFusePojoShipments.getDeliveryAddress().getPostalCode();
        //    System.out.println("deliveryAddressLine3FromJson = " + deliveryAddressLine3FromJson);
        int deliveryAddressLine3FromLabelStart = decodedStringShipments.indexOf("^FT22,333^A0N,27,27^FD") + 22;
        String deliveryAddressLine3FromLabel = decodedStringShipments.substring(deliveryAddressLine3FromLabelStart, deliveryAddressLine3FromLabelStart + deliveryAddressLine3FromJson.length());
        //    System.out.println("deliveryAddressLine3FromLabel = " + deliveryAddressLine3FromLabel);
        assertThat(deliveryAddressLine3FromJson, is(equalTo(deliveryAddressLine3FromLabel)));

    }


    @DisplayName("ZPL: FedEx version and diagnostic string exists vertically along side : 568C2/01EF/05A2")
    @Test
    public void test24() {

        String diagnosticStringFromJson = null;
        for (int i = 0; i < fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().size(); i++) {
            if (fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().get(i).getAdditionalValueKey().equals("Version")) {
                diagnosticStringFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().get(i).getValue();
                //    System.out.println("diagnosticString = " + diagnosticString);
            }
        }
        int diagnosticStringFromLabelStart = decodedStringShipments.indexOf("^FT747,366^A0B,19,19^FD") + 23;
        String diagnosticStringFromLabel = decodedStringShipments.substring(diagnosticStringFromLabelStart, diagnosticStringFromLabelStart + diagnosticStringFromJson.length());
        //    System.out.println("diagnosticStringFromLabel = " + diagnosticStringFromLabel);
        assertThat(diagnosticStringFromJson, is(equalTo(diagnosticStringFromLabel)));
    }


    @DisplayName("ZPL: Delivery Address Phone Number and 'REF:' exists: (306) 244-2311")
    @Test
    public void test25() {


        String deliveryAddressLine3FromJson = fedExFusePojoShipments.getDeliveryAddress().getLocalityName().toUpperCase() + ", " + fedExFusePojoShipments.getDeliveryAddress().getSubdivisionCode() + " " + fedExFusePojoShipments.getDeliveryAddress().getPostalCode();
        //    System.out.println("deliveryAddressLine3FromJson = " + deliveryAddressLine3FromJson);
        int deliveryAddressLine3FromLabelStart = decodedStringShipments.indexOf("^FT22,333^A0N,27,27^FD") + 22;
        String deliveryAddressLine3FromLabel = decodedStringShipments.substring(deliveryAddressLine3FromLabelStart, deliveryAddressLine3FromLabelStart + deliveryAddressLine3FromJson.length());
        //    System.out.println("deliveryAddressLine3FromLabel = " + deliveryAddressLine3FromLabel);
        assertThat(deliveryAddressLine3FromJson, is(equalTo(deliveryAddressLine3FromLabel)));

    }


    @DisplayName("ZPL: Delivery Address Phone Number and 'REF:' exists: (987) 654-3211")
    @Test
    public void test26() {


        String deliveryAddressPhoneNumberFromJson = fedExFusePojoShipments.getDeliveryAddress().getContacts().get(0).getPhoneNumber().replace("(", "").replace(")", "").replace(" ", "").replace("-", "");
        //    System.out.println("deliveryAddressPhoneNumberFromJson = " + deliveryAddressPhoneNumberFromJson);
        int deliveryAddressPhoneNumberFromLabelStart = decodedStringShipments.indexOf("^FT20,358^A0N,16,16^FD") + 22;
        String deliveryAddressPhoneNumberFromLabel = decodedStringShipments.substring(deliveryAddressPhoneNumberFromLabelStart, deliveryAddressPhoneNumberFromLabelStart + deliveryAddressPhoneNumberFromJson.length());
        //    System.out.println("deliveryAddressPhoneNumberFromLabel = " + deliveryAddressPhoneNumberFromLabel);
        assertThat(deliveryAddressPhoneNumberFromJson, is(equalTo(deliveryAddressPhoneNumberFromLabel)));
        assertThat(decodedStringShipments, containsString("^FT20,358^A0N,16,16^FD" + deliveryAddressPhoneNumberFromJson + "                       REF:^FS"));
    }


    @DisplayName("ZPL: 'INV:', 'PO:' and 'DEPT:' fields exist: (987) 654-3211")
    @Test
    public void test27() {

        assertThat(decodedStringShipments, containsString("^FT20,374^A0N,16,16^FDINV:^FS"));
        assertThat(decodedStringShipments, containsString("^FT20,391^A0N,16,16^FDPO:                                         DEPT:^FS"));
    }


    @DisplayName("ZPL: Horizontal lines above the PDF417 Barcode exist")
    @Test
    public void test28() {

        assertThat(decodedStringShipments, containsString("^FO3,405^GB761,3,3,B^FS"));

    }


    @DisplayName("ZPL: Horizontal lines below the PDF417 Barcode exist")
    @Test
    public void test29() {

        assertThat(decodedStringShipments, containsString("^FO3,669^GB761,3,3,B^FS"));
    }


    @DisplayName("ZPL: 'FedEx' brand exists to right of PDF417 Barcode exist")
    @Test
    public void test30() {

        String forwarderDivisionServiceName1FromJson = fedExFusePojoShipments.getForwarderDivisionService().getName().substring(0, 5);
        //    System.out.println("forwarderDivisionServiceName1FromJson = " + forwarderDivisionServiceName1FromJson);
        int forwarderDivisionServiceName1FromLabelStart = decodedStringShipments.indexOf("^FT650,492^A0N,43,43^FD") + 23;
        String forwarderDivisionServiceName1FromLabel = decodedStringShipments.substring(forwarderDivisionServiceName1FromLabelStart, forwarderDivisionServiceName1FromLabelStart + forwarderDivisionServiceName1FromJson.length());
        //    System.out.println("forwarderDivisionServiceName1FromLabel = " + forwarderDivisionServiceName1FromLabel);
        assertThat(forwarderDivisionServiceName1FromJson, is(equalTo(forwarderDivisionServiceName1FromLabel)));
    }


    @DisplayName("ZPL: Service Name exists to right of PDF417FFG-HOME")
    @Test
    public void test31() {

        String forwarderDivisionServiceName2FromJson = fedExFusePojoShipments.getForwarderDivisionService().getName().substring(6, 19);
        //    System.out.println("forwarderDivisionServiceName2FromJson = " + forwarderDivisionServiceName2FromJson);
        int forwarderDivisionServiceName2FromLabelStart = decodedStringShipments.indexOf("^FT650,515^A0N,22,18^FD") + 23;
        String forwarderDivisionServiceName2FromLabel = decodedStringShipments.substring(forwarderDivisionServiceName2FromLabelStart, forwarderDivisionServiceName2FromLabelStart + forwarderDivisionServiceName2FromJson.length());
        //    System.out.println("forwarderDivisionServiceName2FromLabel = " + forwarderDivisionServiceName2FromLabel);
        assertThat(forwarderDivisionServiceName2FromJson, is(equalTo(forwarderDivisionServiceName2FromLabel)));
    }


    @DisplayName("ZPL: Service Indicator in box exists to right of PDF417: FFG-HOME")
    @Test
    public void test32() {

        assertThat(decodedStringShipments, containsString("^FO650,522^GB81,102,10,B^FS"));
        assertThat(decodedStringShipments, containsString("^FT664,606^A0N,87,87^FDH^FS"));

    }


    @DisplayName("ZPL: Tracking Number Tag (TrkOrMps) exists to left below PDF417: TRK#")
    @Test
    public void test33() {

        String tRKSignFromJson = null;
        for (int i = 0; i < fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().size(); i++) {
            if (fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().get(i).getAdditionalValueKey().equals("TrkOrMps")) {
                tRKSignFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().get(i).getValue();
                //            System.out.println("tRKSignFromJson = " + tRKSignFromJson);
            }
        }
        int tRKSignFromLabelStart = decodedStringShipments.indexOf("^FT41,764^A0N,27,27^FD") + 22;
        String tRKSignFromLabel = decodedStringShipments.substring(tRKSignFromLabelStart, tRKSignFromLabelStart + tRKSignFromJson.length());
        //    System.out.println("tRKSignFromLabel = " + tRKSignFromLabel);
        assertThat(tRKSignFromJson, is(equalTo(tRKSignFromLabel)));

    }


    @DisplayName("ZPL: Formatted Tracking Number exists: 1771 7774 0629")
    @Test
    public void test34() {

        String tRKNumFromJson = null;
        for (int i = 0; i < fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().size(); i++) {
            if (fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().get(i).getAdditionalValueKey().equals("FormattedTrackingNumber")) {
                tRKNumFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().get(i).getValue();
                //            System.out.println("tRKNumFromJson = " + tRKNumFromJson);
            }
        }
        int tRKNumFromLabelStart = decodedStringShipments.indexOf("^FT132,777^A0N,43,43^FD") + 23;
        String tRKNumFromLabel = decodedStringShipments.substring(tRKNumFromLabelStart, tRKNumFromLabelStart + tRKNumFromJson.length());
        //    System.out.println("tRKNumFromLabel = " + tRKNumFromLabel);
        assertThat(tRKNumFromJson, is(equalTo(tRKNumFromLabel)));
    }


    @DisplayName("ZPL: Destination Postal Code (Formatted) exists: 77378-0000")
    @Test
    public void test35() {


        String destinationPostalCodeFromJson = null;
        for (int i = 0; i < fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().size(); i++) {
            if (fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().get(i).getAdditionalValueKey().equals("DestinationPostalCode")) {
                destinationPostalCodeFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().get(i).getValue();
                //        System.out.println("destinationPostalCodeFromJson = " + destinationPostalCodeFromJson);
            }
        }
        int destinationPostalCodeFromLabelStart = decodedStringShipments.indexOf("^FT687,879^A0N,33,33^FD") + 23;
        String destinationPostalCodeFromLabel = decodedStringShipments.substring(destinationPostalCodeFromLabelStart, destinationPostalCodeFromLabelStart + destinationPostalCodeFromJson.length());
        //    System.out.println("destinationPostalCodeFromLabel = " + destinationPostalCodeFromLabel);
        assertThat(destinationPostalCodeFromJson, is(equalTo(destinationPostalCodeFromLabel)));
    }


    @DisplayName("ZPL: URSA Routing Codes exists: 9632 0804 0 (000 000 0000) 0 00 1771 7774 0607")
    @Test
    public void test36() {


        String uRSARoutingCodesFromJson = null;
        for (int i = 0; i < fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().size(); i++) {
            if (fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().get(i).getAdditionalValueKey().equals("GroundHumanReadableBarcode")) {
                uRSARoutingCodesFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().get(i).getValue();
                //        System.out.println("uRSARoutingCodesFromJson = " + uRSARoutingCodesFromJson);
            }
        }
        int uRSARoutingCodesFromLabelStart = decodedStringShipments.indexOf("^FT145,932^A0N,27,27^FD") + 23;
        String uRSARoutingCodesFromLabel = decodedStringShipments.substring(uRSARoutingCodesFromLabelStart, uRSARoutingCodesFromLabelStart + uRSARoutingCodesFromJson.length());
        //    System.out.println("uRSARoutingCodesFromLabel = " + uRSARoutingCodesFromLabel);
        assertThat(uRSARoutingCodesFromJson, is(equalTo(uRSARoutingCodesFromLabel)));
    }


    @DisplayName("ZPL: FedEx 1D Barcode exists: 9632080400677914238600177177740629")
    @Test
    public void test37() {


        String fedExBarcodeFromJson = null;
        for (int i = 0; i < fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().size(); i++) {
            if (fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().get(i).getAdditionalValueKey().equals("BarCode")) {
                fedExBarcodeFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getAdditionalValues().get(i).getValue();
                //        System.out.println("fedExBarcodeFromJson = " + fedExBarcodeFromJson);
            }
        }
        int fedExBarcodeFromLabelStart = decodedStringShipments.indexOf("^FO61,951^BCN,213,N^FD>;") + 24;
        String fedExBarcodeFromLabel = decodedStringShipments.substring(fedExBarcodeFromLabelStart, fedExBarcodeFromLabelStart + fedExBarcodeFromJson.length());
        //    System.out.println("fedExBarcodeFromLabel = " + fedExBarcodeFromLabel);
        assertThat(fedExBarcodeFromJson, is(equalTo(fedExBarcodeFromLabel)));
    }


    @DisplayName("EDI - AccountNumber = 677914238")
    @Test
    public void test38() {


        int accountNumber = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("Metadata").getJSONObject("ClientDetail").getInt("AccountNumber");
        //    System.out.println("accountNumber = " + accountNumber);
        assertThat(decodedStringConveyancesEDI, containsString("<AccountNumber>" + accountNumber));

    }


    @DisplayName("EDI - MeterNumber = 1711")
    @Test
    public void test39() {

        int meterNumber = 1711;

        int meterNumberEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("Metadata").getJSONObject("ClientDetail").getInt("MeterNumber");
        //    System.out.println("meterNumberEDI = " + meterNumberEDI);
        assertThat(meterNumberEDI, is(equalTo(meterNumber)));

    }


    @DisplayName("EDI - SoftwareId = PLUS")
    @Test
    public void test40() {


        String softwareIdEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("Metadata").getJSONObject("ClientDetail").getString("SoftwareId");
        //    System.out.println("softwareIdEDI = " + softwareIdEDI);
        assertThat(softwareIdEDI, is(equalTo("PLUS")));

    }


    @DisplayName("EDI - SoftwareRelease = 0008")
    @Test
    public void test41() {


        String softwareReleaseEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("Metadata").getJSONObject("ClientDetail").getString("SoftwareRelease");
        //    System.out.println("softwareReleaseEDI = " + softwareReleaseEDI);
        assertThat(softwareReleaseEDI, is(equalTo("0008")));

    }


    @DisplayName("EDI - ClientProductId = PLUS")
    @Test
    public void test42() {

        String clientProductIdEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("Metadata").getJSONObject("ClientDetail").getString("ClientProductId");
        //    System.out.println("clientProductIdEDI = " + clientProductIdEDI);
        assertThat(clientProductIdEDI, is(equalTo("PLUS")));

    }


    @DisplayName("EDI - ClientProductVersion = 0008")
    @Test
    public void test43() {

        String clientProductVersionEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("Metadata").getJSONObject("ClientDetail").getString("ClientProductVersion");
        //    System.out.println("clientProductVersionEDI = " + clientProductVersionEDI);
        assertThat(clientProductVersionEDI, is(equalTo("0008")));

    }


    @DisplayName("EDI - Timestamp = 2022-01-18T14:46:54")
    @Test
    public void test44() {

        //    System.out.println("currentDateTime = " + currentDateTime.substring(0,16));
        String timestampEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("Metadata").getJSONObject("UploadFileDetail").getString("Timestamp");
        //    System.out.println("timestampEDI = " + timestampEDI.substring(0,16));
        assertThat(timestampEDI.substring(0, 16), is(equalTo(currentDateTime.substring(0, 16))));

    }


    @DisplayName("EDI - MediaType = NORMAL_TRANSMIT")
    @Test
    public void test45() {

        String mediaTypeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("Metadata").getJSONObject("UploadFileDetail").getString("MediaType");
        //    System.out.println("mediaTypeEDI = " + mediaTypeEDI);
        assertThat(mediaTypeEDI, is(equalTo("NORMAL_TRANSMIT")));

    }


    @DisplayName("EDI - SchemaVersion = 8")
    @Test
    public void test46() {

        int schemaVersionEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("Metadata").getJSONObject("UploadFileDetail").getInt("SchemaVersion");
        //    System.out.println("schemaVersionEDI = " + schemaVersionEDI);
        assertThat(schemaVersionEDI, is(equalTo(8)));

    }


    @DisplayName("EDI - SchemaRevision = 0")
    @Test
    public void test47() {

        int schemaRevisionEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("Metadata").getJSONObject("UploadFileDetail").getInt("SchemaRevision");
        //    System.out.println("schemaRevisionEDI = " + schemaRevisionEDI);
        assertThat(schemaRevisionEDI, is(equalTo(0)));

    }


    @DisplayName("EDI - SequenceNumber = 2276")
    @Test
    public void test48() {

        int sequenceNumberEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("Metadata").getJSONObject("UploadFileDetail").getInt("SequenceNumber");
        //    System.out.println("sequenceNumberEDI = " + sequenceNumberEDI);
        assertThat(sequenceNumberEDI, is(notNullValue()));

    }


    @DisplayName("EDI - ShippingCycle = 2276")
    @Test
    public void test49() {

        int shippingCycleEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("Metadata").getJSONObject("UploadFileDetail").getInt("ShippingCycle");
        //    System.out.println("shippingCycleEDI = " + shippingCycleEDI);
        assertThat(shippingCycleEDI, is(notNullValue()));

    }


    @DisplayName("EDI - ShipTimestamp = 2022-01-18T00:00:00")
    @Test
    public void test50() {

        String shipTimestampEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getString("ShipTimestamp");
        //    System.out.println("shipTimestampEDI = " + shipTimestampEDI);
        String requestedPickupDateTimeFromJson = fedExFusePojoShipments.getRequestedPickupDateTime();
        //    System.out.println("requestedPickupDateTimeFromJson = " + requestedPickupDateTimeFromJson);
        assertThat(shipTimestampEDI, is(equalTo(requestedPickupDateTimeFromJson.substring(0, 10) + "T00:00:00")));

    }


    @DisplayName("EDI - DropoffType = REGULAR_PICKUP")
    @Test
    public void test51() {

        String dropoffTypeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getString("DropoffType");
        //    System.out.println("dropoffTypeEDI = " + dropoffTypeEDI);
        assertThat(dropoffTypeEDI, is(equalTo("REGULAR_PICKUP")));

    }


    @DisplayName("EDI - ServiceType = GROUND_HOME_DELIVERY")
    @Test
    public void test52() {

        String serviceTypeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getString("ServiceType");
        //    System.out.println("serviceTypeEDI = " + serviceTypeEDI);
        assertThat(serviceTypeEDI, is(equalTo("GROUND_HOME_DELIVERY")));

    }


    @DisplayName("EDI - PackagingType = YOUR_PACKAGING")
    @Test
    public void test53() {

        String packagingTypeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getString("PackagingType");
        //    System.out.println("packagingTypeEDI = " + packagingTypeEDI);
        assertThat(packagingTypeEDI, is(equalTo("YOUR_PACKAGING")));

    }


    @DisplayName("EDI - Shipper AccountNumber = 677914238")
    @Test
    public void test54() {

        int shipperAccountNumberEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Shipper").getInt("AccountNumber");
        //    System.out.println("shipperAccountNumberEDI = " + shipperAccountNumberEDI);
        assertThat(shipperAccountNumberEDI, is(equalTo(677914238)));

    }


    @DisplayName("EDI - Shipper Tins TinType = BUSINESS_NATIONAL")
    @Test
    public void test55() {

        String shipperTinsTinTypeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Shipper").getJSONObject("Tins").getString("TinType");
        //    System.out.println("shipperTinsTinTypeEDI = " + shipperTinsTinTypeEDI);
        assertThat(shipperTinsTinTypeEDI, is(equalTo("BUSINESS_NATIONAL")));
    }


    @DisplayName("EDI - Shipper Contact ContactId = Lx Reception")
    @Test
    public void test56() {

        String shipperContactNameFromJson = fedExFusePojoShipments.getPickupAddress().getContacts().get(0).getName();
        //    System.out.println("shipperContactNameFromJson = " + shipperContactNameFromJson);
        String shipperContactContactIdEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Shipper").getJSONObject("Contact").getString("ContactId");
        //    System.out.println("shipperContactContactIdEDI = " + shipperContactContactIdEDI);
        assertThat(shipperContactContactIdEDI, is(equalTo(shipperContactNameFromJson)));
    }


    @DisplayName("EDI - Shipper Contact PersonName = Lx Reception")
    @Test
    public void test57() {

        String shipperContactNameFromJson = fedExFusePojoShipments.getPickupAddress().getContacts().get(0).getName();
        //    System.out.println("shipperContactNameFromJson = " + shipperContactNameFromJson);
        String shipperPersonNameEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Shipper").getJSONObject("Contact").getString("PersonName");
        //    System.out.println("shipperContactContactIdEDI = " + shipperContactContactIdEDI);
        assertThat(shipperPersonNameEDI, is(equalTo(shipperContactNameFromJson)));
    }


    @DisplayName("EDI - Shipper Contact CompanyName = L Brands")
    @Test
    public void test58() {

        String shipperContactCompanyNameFromJson = fedExFusePojoShipments.getPickupAddress().getReference();
        //    System.out.println("shipperContactCompanyNameFromJson = " + shipperContactCompanyNameFromJson);
        String shipperContactCompanyNameEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Shipper").getJSONObject("Contact").getString("CompanyName");
        //    System.out.println("shipperContactCompanyNameEDI = " + shipperContactCompanyNameEDI);
        assertThat(shipperContactCompanyNameEDI, is(equalTo(shipperContactCompanyNameFromJson)));
    }


    @DisplayName("EDI - Shipper Contact PhoneNumber = 0208080007")
    @Test
    public void test59() {

        String shipperContactPhoneNumberFromJson = fedExFusePojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber().replace(" ", "");
        //    System.out.println("shipperContactPhoneNumberFromJson = " + shipperContactPhoneNumberFromJson);
        String shipperContactPhoneNumberEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Shipper").getJSONObject("Contact").getString("PhoneNumber");
        //    System.out.println("shipperContactPhoneNumberEDI = " + shipperContactPhoneNumberEDI);
        assertThat(shipperContactPhoneNumberEDI, is(equalTo(shipperContactPhoneNumberFromJson)));
    }


    @DisplayName("EDI - Shipper Address StreetLines 1 = 3 Limited Pkwy")
    @Test
    public void test60() {

        String shipperAddressStreetLines1FromJson = fedExFusePojoShipments.getPickupAddress().getAddressLines().get(0).getValue();
        //    System.out.println("shipperAddressStreetLines1FromJson = " + shipperAddressStreetLines1FromJson);
        String shipperAddressStreetLines1EDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Shipper").getJSONObject("Address").getJSONArray("StreetLines").getString(0);
        //    System.out.println("shipperAddressStreetLines1EDI = " + shipperAddressStreetLines1EDI);
        assertThat(shipperAddressStreetLines1EDI, is(equalTo(shipperAddressStreetLines1FromJson)));
    }


    @DisplayName("EDI - Shipper Address StreetLines 2 = Stop 4")
    @Test
    public void test61() {

        String shipperAddressStreetLines2FromJson = fedExFusePojoShipments.getPickupAddress().getAddressLines().get(1).getValue();
        //    System.out.println("shipperAddressStreetLines2FromJson = " + shipperAddressStreetLines2FromJson);
        String shipperAddressStreetLines2EDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Shipper").getJSONObject("Address").getJSONArray("StreetLines").getString(1);
        //    System.out.println("shipperAddressStreetLines2EDI = " + shipperAddressStreetLines2EDI);
        assertThat(shipperAddressStreetLines2EDI, is(equalTo(shipperAddressStreetLines2FromJson)));
    }


    @DisplayName("EDI - Shipper Address City = Gahanna")
    @Test
    public void test62() {

        String shipperAddressCityFromJson = fedExFusePojoShipments.getPickupAddress().getLocalityName();
        //    System.out.println("shipperAddressCityFromJson = " + shipperAddressCityFromJson);
        String shipperAddressCityEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Shipper").getJSONObject("Address").getString("City");
        //    System.out.println("shipperAddressCityEDI = " + shipperAddressCityEDI);
        assertThat(shipperAddressCityEDI, is(equalTo(shipperAddressCityFromJson)));
    }


    @DisplayName("EDI - Shipper Address StateOrProvinceCode = OH")
    @Test
    public void test63() {

        String shipperAddressSubdivisionCodeFromJson = fedExFusePojoShipments.getPickupAddress().getSubdivisionCode();
        //    System.out.println("shipperAddressSubdivisionCodeFromJson = " + shipperAddressSubdivisionCodeFromJson);
        String shipperAddressStateOrProvinceCodeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Shipper").getJSONObject("Address").getString("StateOrProvinceCode");
        //    System.out.println("shipperAddressStateOrProvinceCodeEDI = " + shipperAddressStateOrProvinceCodeEDI);
        assertThat(shipperAddressStateOrProvinceCodeEDI, is(equalTo(shipperAddressSubdivisionCodeFromJson)));
    }


    @DisplayName("EDI - Shipper Address PostalCode = 43219")
    @Test
    public void test64() {

        int shipperAddressPostalCodeFromJson = Integer.parseInt(fedExFusePojoShipments.getPickupAddress().getPostalCode());
        //    System.out.println("shipperAddressPostalCodeFromJson = " + shipperAddressPostalCodeFromJson);
        int shipperAddressPostalCodeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Shipper").getJSONObject("Address").getInt("PostalCode");
        //    System.out.println("shipperAddressPostalCodeEDI = " + shipperAddressPostalCodeEDI);
        assertThat(shipperAddressPostalCodeEDI, is(equalTo(shipperAddressPostalCodeFromJson)));
    }


    @DisplayName("EDI - Shipper Address CountryCode = US")
    @Test
    public void test65() {

        String shipperAddressCountryCodeFromJson = fedExFusePojoShipments.getPickupAddress().getCountryCode();
        //    System.out.println("shipperAddressCountryCodeFromJson = " + shipperAddressCountryCodeFromJson);
        String shipperAddressCountryCodeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Shipper").getJSONObject("Address").getString("CountryCode");
        //    System.out.println("shipperAddressCountryCodeEDI = " + shipperAddressCountryCodeEDI);
        assertThat(shipperAddressCountryCodeEDI, is(equalTo(shipperAddressCountryCodeFromJson)));
    }


    @DisplayName("EDI - Recipient Contact ContactId = Enter Sandman")
    @Test
    public void test66() {

        String recipientContactContactIdFromJson = fedExFusePojoShipments.getDeliveryAddress().getContacts().get(0).getName();
        //    System.out.println("recipientContactContactIdFromJson = " + recipientContactContactIdFromJson);
        String recipientContactContactIdEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Recipient").getJSONObject("Contact").getString("ContactId");
        //    System.out.println("recipientContactContactIdEDI = " + recipientContactContactIdEDI);
        assertThat(recipientContactContactIdEDI, is(equalTo(recipientContactContactIdFromJson)));
    }


    @DisplayName("EDI - Recipient Contact PersonName = Enter Sandman")
    @Test
    public void test67() {

        String recipientContactPersonNameFromJson = fedExFusePojoShipments.getDeliveryAddress().getContacts().get(0).getName();
        //    System.out.println("recipientContactPersonNameFromJson = " + recipientContactPersonNameFromJson);
        String recipientContactPersonNameEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Recipient").getJSONObject("Contact").getString("PersonName");
        //    System.out.println("recipientContactPersonNameEDI = " + recipientContactPersonNameEDI);
        assertThat(recipientContactPersonNameEDI, is(equalTo(recipientContactPersonNameFromJson)));
    }


    @DisplayName("EDI - Recipient Contact PhoneNumber = 9876543211")
    @Test
    public void test68() {

        String recipientContactPhoneNumberFromJson = fedExFusePojoShipments.getDeliveryAddress().getContacts().get(0).getPhoneNumber().replace("(", "").replace(")", "").replace(" ", "").replace("-", "");
        //    System.out.println("recipientContactPhoneNumberFromJson = " + recipientContactPhoneNumberFromJson);
        String recipientContactPhoneNumberEDI = String.valueOf(jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Recipient").getJSONObject("Contact").getLong("PhoneNumber"));
        //   System.out.println("recipientContactPhoneNumberEDI = " + recipientContactPhoneNumberEDI);
        assertThat(recipientContactPhoneNumberEDI, is(equalTo(recipientContactPhoneNumberFromJson)));


    }


    @DisplayName("EDI - Recipient Address StreetLines 1 = 123 Sesame St.")
    @Test
    public void test69() {

        String recipientAddressStreetLines1FromJson = fedExFusePojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue();
        //    System.out.println("recipientAddressStreetLines1FromJson = " + recipientAddressStreetLines1FromJson);
        String recipientAddressStreetLines1EDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Recipient").getJSONObject("Address").getJSONArray("StreetLines").getString(0);
        //    System.out.println("recipientAddressStreetLines1EDI = " + recipientAddressStreetLines1EDI);
        assertThat(recipientAddressStreetLines1EDI, is(equalTo(recipientAddressStreetLines1FromJson)));


    }


    @DisplayName("EDI - Recipient Address StreetLines 2 = 2nd Address Line")
    @Test
    public void test70() {

        String recipientAddressStreetLines2FromJson = fedExFusePojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue();
        //    System.out.println("recipientAddressStreetLines2FromJson = " + recipientAddressStreetLines2FromJson);
        String recipientAddressStreetLines2EDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Recipient").getJSONObject("Address").getJSONArray("StreetLines").getString(1);
        //    System.out.println("recipientAddressStreetLines2EDI = " + recipientAddressStreetLines2EDI);
        assertThat(recipientAddressStreetLines2EDI, is(equalTo(recipientAddressStreetLines2FromJson)));


    }


    @DisplayName("EDI - Recipient Address City = Jamestown")
    @Test
    public void test71() {

        String recipientAddressCityFromJson = fedExFusePojoShipments.getDeliveryAddress().getLocalityName();
        //    System.out.println("recipientAddressCityFromJson = " + recipientAddressCityFromJson);
        String recipientAddressCityEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Recipient").getJSONObject("Address").getString("City");
        //    System.out.println("recipientAddressCityEDI = " + recipientAddressCityEDI);
        assertThat(recipientAddressCityEDI, is(equalTo(recipientAddressCityFromJson)));


    }


    @DisplayName("EDI - Recipient Address StateOrProvinceCode = NM")
    @Test
    public void test72() {

        String recipientAddressStateOrProvinceCodeFromJson = fedExFusePojoShipments.getDeliveryAddress().getSubdivisionCode();
        //    System.out.println("recipientAddressStateOrProvinceCodeFromJson = " + recipientAddressStateOrProvinceCodeFromJson);
        String recipientAddressStateOrProvinceCodeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Recipient").getJSONObject("Address").getString("StateOrProvinceCode");
        //    System.out.println("recipientAddressStateOrProvinceCodeEDI = " + recipientAddressStateOrProvinceCodeEDI);
        assertThat(recipientAddressStateOrProvinceCodeEDI, is(equalTo(recipientAddressStateOrProvinceCodeFromJson)));


    }


    @DisplayName("EDI - Recipient Address PostalCode = 77378-0000")
    @Test
    public void test73() {

        String recipientAddressPostalCodeFromJson = fedExFusePojoShipments.getDeliveryAddress().getPostalCode();
        //    System.out.println("recipientAddressPostalCodeFromJson = " + recipientAddressPostalCodeFromJson);
        String recipientAddressPostalCodeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Recipient").getJSONObject("Address").getString("PostalCode");
        //    System.out.println("recipientAddressPostalCodeEDI = " + recipientAddressPostalCodeEDI);
        assertThat(recipientAddressPostalCodeEDI, is(equalTo(recipientAddressPostalCodeFromJson)));


    }


    @DisplayName("EDI - Recipient Address CountryCode = US")
    @Test
    public void test74() {

        String recipientAddressCountryCodeFromJson = fedExFusePojoShipments.getDeliveryAddress().getCountryCode();
        //    System.out.println("recipientAddressCountryCodeFromJson = " + recipientAddressCountryCodeFromJson);
        String recipientAddressCountryCodeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("Recipient").getJSONObject("Address").getString("CountryCode");
        //    System.out.println("recipientAddressCountryCodeEDI = " + recipientAddressCountryCodeEDI);
        assertThat(recipientAddressCountryCodeEDI, is(equalTo(recipientAddressCountryCodeFromJson)));

    }


    @DisplayName("EDI - PaymentType = SENDER")
    @Test
    public void test75() {
        String paymentTypeFromJson = null;
        if ((fedExFusePojoShipments.getFreightPayer()).equals("SHIPPER"))
            paymentTypeFromJson = "SENDER";

        //    System.out.println("paymentTypeFromJson = " + paymentTypeFromJson);
        String paymentTypeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("ShippingChargesPayment").getString("PaymentType");
        //    System.out.println("paymentTypeEDI = " + paymentTypeEDI);
        assertThat(paymentTypeEDI, is(equalTo(paymentTypeFromJson)));

    }


    @DisplayName("EDI - PackageCount = 1")
    @Test
    public void test76() {

        int packageCountFromJson = fedExFusePojoShipments.getNumberOfShippingUnits();
        //    System.out.println("packageCountFromJson = " + packageCountFromJson);
        int packageCountEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getInt("PackageCount");
        //    System.out.println("packageCountEDI = " + packageCountEDI);
        assertThat(packageCountEDI, is(equalTo(packageCountFromJson)));

    }


    @DisplayName("EDI - Package SequenceNumber = 1")
    @Test
    public void test77() {

        int packageSequenceNumberFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getIndex();
        //    System.out.println("packageSequenceNumberFromJson = " + packageSequenceNumberFromJson);
        int packageSequenceNumberEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("RequestedPackageLineItems").getInt("SequenceNumber");
        //    System.out.println("packageSequenceNumberEDI = " + packageSequenceNumberEDI);
        assertThat(packageSequenceNumberEDI, is(equalTo(packageSequenceNumberFromJson)));

    }


    @DisplayName("EDI - Package TrackingIdType = FEDEX")
    @Test
    public void test78() {

        String packageTrackingIdTypeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("RequestedPackageLineItems").getJSONObject("TrackingIds").getString("TrackingIdType");
        //    System.out.println("packageTrackingIdTypeEDI = " + packageTrackingIdTypeEDI);
        assertThat(packageTrackingIdTypeEDI, is(equalTo("FEDEX")));

    }


    @DisplayName("EDI - Package TrackingNumber = 177177743959")
    @Test
    public void test79() {

        String packageTrackingNumberFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getForwarderRef();
        //    System.out.println("packageTrackingNumberFromJson = " + packageTrackingNumberFromJson);
        long packageTrackingNumberEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("RequestedPackageLineItems").getJSONObject("TrackingIds").getLong("TrackingNumber");
        //    System.out.println("packageTrackingNumberEDI = " + packageTrackingNumberEDI);
        assertThat(String.valueOf(packageTrackingNumberEDI), is(equalTo(packageTrackingNumberFromJson)));

    }


    @DisplayName("EDI - Package Weight Units= LB")
    @Test
    public void test80() {

        String packageWeightUnitsFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getGrossWeightUnitOfMeasure().toUpperCase().trim();
        //    System.out.println("packageWeightUnitsFromJson = " + packageWeightUnitsFromJson);
        String packageWeightUnitsEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("RequestedPackageLineItems").getJSONObject("Weight").getString("Units");
        //    System.out.println("packageWeightUnitsEDI = " + packageWeightUnitsEDI);
        assertThat(packageWeightUnitsEDI, is(equalTo(packageWeightUnitsFromJson)));

    }


    @DisplayName("EDI - Package Weight Value = 0.99")
    @Test
    public void test81() {

        float packageWeightValueFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getGrossWeight();
    //    System.out.println("packageWeightValueFromJson = " + packageWeightValueFromJson);
        float packageWeightValueEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("RequestedPackageLineItems").getJSONObject("Weight").getFloat("Value");
    //    System.out.println("packageWeightValueEDI = " + packageWeightValueEDI);
        assertThat(packageWeightValueEDI, is(equalTo(packageWeightValueFromJson)));

    }


    @DisplayName("EDI - Package Length = 6")
    @Test
    public void test82() {

        Float packageLengthFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getLength();
    //    System.out.println("packageLengthFromJson = " + packageLengthFromJson);
        int packageLengthEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("RequestedPackageLineItems").getJSONObject("Dimensions").getInt("Length");
    //    System.out.println("packageLengthEDI = " + packageLengthEDI);
        assertThat(packageLengthEDI, is(equalTo(packageLengthFromJson.intValue())));

    }


    @DisplayName("EDI - Package Width = 5")
    @Test
    public void test83() {

        Float packageWidthFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getWidth();
    //    System.out.println("packageWidthFromJson = " + packageWidthFromJson);
        int packageWidthEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("RequestedPackageLineItems").getJSONObject("Dimensions").getInt("Width");
    //    System.out.println("packageWidthEDI = " + packageWidthEDI);
        assertThat(packageWidthEDI, is(equalTo(packageWidthFromJson.intValue())));

    }


    @DisplayName("EDI - Package Height = 4")
    @Test
    public void test84() {

        Float packageHeightFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getHeight();
    //    System.out.println("packageHeightFromJson = " + packageHeightFromJson);
        int packageHeightEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("RequestedPackageLineItems").getJSONObject("Dimensions").getInt("Height");
    //    System.out.println("packageHeightEDI = " + packageHeightEDI);
        assertThat(packageHeightEDI, is(equalTo(packageHeightFromJson.intValue())));

    }


    @DisplayName("EDI - Package Dimensions Units = IN")
    @Test
    public void test85() {

        String packageDimensionsUnitsFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getDimensionsUnitOfMeasure().toUpperCase().trim();
    //    System.out.println("packageDimensionsUnitsFromJson = " + packageDimensionsUnitsFromJson);
        String packageDimensionsUnitsEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("RequestedPackageLineItems").getJSONObject("Dimensions").getString("Units");
    //    System.out.println("packageDimensionsUnitsEDI = " + packageDimensionsUnitsEDI);
        assertThat(packageDimensionsUnitsEDI, is(equalTo(packageDimensionsUnitsFromJson)));

    }


    @DisplayName("EDI - Package Dimensions Units = IN")
    @Test
    public void test86() {

        String packageDimensionsUnitsFromJson = fedExFusePojoShipments.getShippingUnits().get(0).getDimensionsUnitOfMeasure().toUpperCase().trim();
        //    System.out.println("packageDimensionsUnitsFromJson = " + packageDimensionsUnitsFromJson);
        String packageDimensionsUnitsEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("ShipmentEffectiveData").getJSONObject("RequestedPackageLineItems").getJSONObject("Dimensions").getString("Units");
        //    System.out.println("packageDimensionsUnitsEDI = " + packageDimensionsUnitsEDI);
        assertThat(packageDimensionsUnitsEDI, is(equalTo(packageDimensionsUnitsFromJson)));

    }


    @DisplayName("EDI - CompletedShipmentDetail is UsDomestic? = true")
    @Test
    public void test87() {

        boolean isUsDomestic = true;
        boolean completedShipmentDetailEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("CompletedShipmentDetail").getBoolean("UsDomestic");
        //    System.out.println("completedShipmentDetailEDI = " + completedShipmentDetailEDI);
        assertThat(completedShipmentDetailEDI, is(equalTo(isUsDomestic)));

    }


    @DisplayName("EDI - CompletedShipmentDetail CarrierCode = FDXG")
    @Test
    public void test88() {

        String completedShipmentDetailCarrierCodeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("CompletedShipmentDetail").getString("CarrierCode");
    //    System.out.println("completedShipmentDetailCarrierCodeEDI = " + completedShipmentDetailCarrierCodeEDI);
        assertThat(completedShipmentDetailCarrierCodeEDI, is(equalTo("FDXG")));

    }


    @DisplayName("EDI - CompletedShipmentDetail MasterTrackingId TrackingIdType = FEDEX")
    @Test
    public void test89() {

        String completedShipmentDetailMasterTrackingIdTrackingIdTypeEDI = jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("CompletedShipmentDetail").getJSONObject("MasterTrackingId").getString("TrackingIdType");
        //    System.out.println("completedShipmentDetailCarrierCodeEDI = " + completedShipmentDetailCarrierCodeEDI);
        assertThat(completedShipmentDetailMasterTrackingIdTrackingIdTypeEDI, is(equalTo("FEDEX")));

    }


    @DisplayName("EDI - CompletedPackageDetails TrackingIds TrackingNumber = 177177744153")
    @Test
    public void test90() {


        String completedShipmentDetailTrackingIdsTrackingNumberFromJson = fedExFusePojoShipments.getForwarderRef();
    //    System.out.println("completedShipmentDetailTrackingIdsTrackingNumberFromJson = " + completedShipmentDetailTrackingIdsTrackingNumberFromJson);
        String completedShipmentDetailTrackingIdsTrackingNumberEDI = String.valueOf(jsonDataEDI.getJSONObject("UploadFile").getJSONObject("RecordShipmentRequests").getJSONObject("ShipmentRecord").getJSONObject("CompletedShipmentDetail").getJSONObject("MasterTrackingId").getBigInteger("TrackingNumber"));
    //    System.out.println("completedShipmentDetailTrackingIdsTrackingNumberEDI = " + completedShipmentDetailTrackingIdsTrackingNumberEDI);
        assertThat(completedShipmentDetailTrackingIdsTrackingNumberEDI, is(equalTo(completedShipmentDetailTrackingIdsTrackingNumberFromJson)));

    }








}













