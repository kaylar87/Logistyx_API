package com.logistyx.TEST;


import com.logistyx.utilities.FedExFuseBaseNotDG;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Calendar;
import java.util.Locale;

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

//        validateResponseShipments.extract().response().prettyPrint();
//        System.out.println("decodedStringShipments = " + decodedStringShipments);
//        validateResponseConveyances.extract().response().prettyPrint();
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


}





