package com.logistyx.TEST.BNP.BNP_BUS_PRCL.Weight_Cases_NL_NO;


import com.logistyx.utilities.abstractBaseClasses.BNPBaseNotDG;
import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@DisplayName("[+] 4d - NL-NO, weight exactly 25 KG = Medium Icon")
public class _4d_NL_NO_weight_exactly_25_KG_Medium_Icon extends BNPBaseNotDG {

    static {
        BNPBaseNotDG.shipmentsLabel();
    }


    @DisplayName("ShippingId is not NULL")
    @Test
    public void test1() {


        assertThat(bringParcelPojoShipments.getShipmentId(), is(notNullValue()));
//        validateResponseShipments.extract().response().prettyPrint();
//        System.out.println("decodedStringShipments = " + decodedStringShipments);
//        validateResponseConveyances.extract().response().prettyPrint();

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


    @DisplayName("PICKUP address details: Earl Bakkenstraat 7, NL-6422 PJ, HEERLEN")
    @Test
    public void test4() {


        String pickUpAddressName1FromJson = bringParcelPojoShipments.getAddresses().get(0).getAddressLines().get(0).getValue();
        //System.out.println("pickUpAddressName1FromJson = " + pickUpAddressName1FromJson);
        int pickUpAddressName1FromLabelStart = decodedStringShipments.indexOf("^FT30,133^A0N,27,27^FD") + 22;
        String pickUpAddressName1FromLabel = decodedStringShipments.substring(pickUpAddressName1FromLabelStart, pickUpAddressName1FromLabelStart + pickUpAddressName1FromJson.length());
        //System.out.println("pickUpAddressName1FromLabel = " + pickUpAddressName1FromLabel);
        assertThat(pickUpAddressName1FromJson, is(equalTo(pickUpAddressName1FromLabel)));

        String pickUpAddressName2FromJson = bringParcelPojoShipments.getAddresses().get(0).getCountryCode() + "-" + bringParcelPojoShipments.getAddresses().get(0).getPostalCode() + " " + bringParcelPojoShipments.getAddresses().get(0).getLocalityName();
        //System.out.println("pickUpAddressName2FromJson = " + pickUpAddressName2FromJson);
        int pickUpAddressName2FromLabelStart = decodedStringShipments.indexOf("^FT30,162^A0N,30,30^FD") + 22;
        String pickUpAddressName2FromLabel = decodedStringShipments.substring(pickUpAddressName2FromLabelStart, pickUpAddressName2FromLabelStart + pickUpAddressName2FromJson.length());
        //System.out.println("pickUpAddressName2FromLabel = " + pickUpAddressName2FromLabel);
        assertThat(pickUpAddressName2FromJson, is(equalTo(pickUpAddressName2FromLabel)));

    }


    @DisplayName("DELIVERY address details: Grand Hotel Oslo, NO-0159, OSLO")
    @Test
    public void test5() {


        String deliveryAddressName1FromJson = bringParcelPojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue();
        //System.out.println("deliveryAddressName1FromJson = " + deliveryAddressName1FromJson);
        int deliveryAddressName1FromLabelStart = decodedStringShipments.indexOf("^FT51,304^A0N,33,33^FD") + 22;
        String deliveryAddressName1FromLabel = decodedStringShipments.substring(deliveryAddressName1FromLabelStart, deliveryAddressName1FromLabelStart + deliveryAddressName1FromJson.length());
        //System.out.println("deliveryAddressName1FromLabel = " + deliveryAddressName1FromLabel);
        assertThat(deliveryAddressName1FromJson, is(equalTo(deliveryAddressName1FromLabel)));

        String deliveryAddressName2FromJson = bringParcelPojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue();
        //System.out.println("deliveryAddressName2FromJson = " + deliveryAddressName2FromJson);
        int deliveryAddressName2FromLabelStart = decodedStringShipments.indexOf("^FT51,337^A0N,33,33^FD") + 22;
        String deliveryAddressName2FromLabel = decodedStringShipments.substring(deliveryAddressName2FromLabelStart, deliveryAddressName2FromLabelStart + deliveryAddressName2FromJson.length());
        //System.out.println("deliveryAddressName2FromLabel = " + deliveryAddressName2FromLabel);
        assertThat(deliveryAddressName2FromJson, is(equalTo(deliveryAddressName2FromLabel)));

        String deliveryAddressName3FromJson = bringParcelPojoShipments.getDeliveryAddress().getCountryCode() + "-" + bringParcelPojoShipments.getDeliveryAddress().getPostalCode() + " " + bringParcelPojoShipments.getDeliveryAddress().getLocalityName();
        //System.out.println("deliveryAddressName3FromJson = " + deliveryAddressName3FromJson);
        int deliveryAddressName3FromLabelStart = decodedStringShipments.indexOf("^FT51,380^A0N,46,46^FD") + 22;
        String deliveryAddressName3FromLabel = decodedStringShipments.substring(deliveryAddressName3FromLabelStart, deliveryAddressName3FromLabelStart + deliveryAddressName3FromJson.length());
        //System.out.println("deliveryAddressName3FromLabel = " + deliveryAddressName3FromLabel);
        assertThat(deliveryAddressName3FromJson, is(equalTo(deliveryAddressName3FromLabel)));

    }


    @DisplayName("Delivery person details: DY.Contact Name")
    @Test
    public void test6() {


        String deliveryPersonDetailsFromJson = bringParcelPojoShipments.getDeliveryAddress().getContacts().get(0).getName();
        //System.out.println("deliveryPersonDetailsFromJson = " + deliveryPersonDetailsFromJson);
        int deliveryPersonDetailsFromLabelStart = decodedStringShipments.indexOf("^FT51,272^A0N,33,33^FD") + 22;
        String deliveryPersonDetailsFromLabel = decodedStringShipments.substring(deliveryPersonDetailsFromLabelStart, deliveryPersonDetailsFromLabelStart + deliveryPersonDetailsFromJson.length());
        //System.out.println("deliveryPersonDetailsFromLabel = " + deliveryPersonDetailsFromLabel);
        assertThat(deliveryPersonDetailsFromJson, is(equalTo(deliveryPersonDetailsFromLabel)));

    }


    @DisplayName("Delivery phone number: +(06)2-222222")
    @Test
    public void test7() {


        String deliveryPhoneNumberFromJson = bringParcelPojoShipments.getDeliveryAddress().getContacts().get(0).getPhoneNumber();
        //System.out.println("deliveryPhoneNumberFromJson = " + deliveryPhoneNumberFromJson);
        int deliveryPhoneNumberFromLabelStart = decodedStringShipments.indexOf("^FT559,423^A0N,27,27^FD") + 23;
        String deliveryPhoneNumberFromLabel = decodedStringShipments.substring(deliveryPhoneNumberFromLabelStart, deliveryPhoneNumberFromLabelStart + deliveryPhoneNumberFromJson.length());
        //System.out.println("deliveryPhoneNumberFromLabel = " + deliveryPhoneNumberFromLabel);
        assertThat(deliveryPhoneNumberFromJson, is(equalTo(deliveryPhoneNumberFromLabel)));

    }


    @DisplayName("Ship date (format: dd.MM.yyyy): 06.10.2020")
    @Test
    public void test8() {


        String shipDateFromJson = bringParcelPojoShipments.getRequestedPickupDateTime().substring(0, 10);
        String shipDayFromJson = shipDateFromJson.substring(8);
        String shipMonthFromJson = shipDateFromJson.substring(5, 7);
        String shipYearFromJson = shipDateFromJson.substring(0, 4);

        String shipDateFromJsonFormat = shipDayFromJson + "." + shipMonthFromJson + "." + shipYearFromJson;
        //    System.out.println("shipDateFromJsonFormat = " + shipDateFromJsonFormat);
        //    System.out.println("shipDateFromJson = " + shipDateFromJson);
        int shipDateFromLabelStart = decodedStringShipments.indexOf("^FT559,246^A0N,27,27^FD") + 23;
        String shipDateFromLabel = decodedStringShipments.substring(shipDateFromLabelStart, shipDateFromLabelStart + 10);
        //    System.out.println("shipDateFromLabel = " + shipDateFromLabel);
        assertThat(shipDateFromJsonFormat, is(equalTo(shipDateFromLabel)));

    }


    @DisplayName("Service (BNP-BUS-PRCL) on the label, destination country = NO, product = Bring Parcel Business Parcel, product code = 0330 and handling code = 2")
    @Test
    public void test9() {


        String productIdFromLabel = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT169,988^A0N,54,54^FD") + 23, decodedStringShipments.indexOf("^FT169,988^A0N,54,54^FD") + 23 + 4);
        //    System.out.println("productIdFromLabel = " + productIdFromLabel);
        String productFromJson = bringParcelPojoShipments.getForwarderDivisionService().getName();
        //    System.out.println("productFromJson = " + productFromJson);
        String productFromLabel = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT169,892^A0N,35,35^FD") + 23, decodedStringShipments.indexOf("^FT169,892^A0N,35,35^FD") + 23 + productFromJson.length());
        //    System.out.println("productFromLabel = " + productFromLabel);
        String deliveryCountryCodeFromJson = bringParcelPojoShipments.getDeliveryAddress().getCountryCode();
        //    System.out.println("deliveryCountryCodeFromJson = " + deliveryCountryCodeFromJson);
        String handlingCodeFromLabel = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT691,982^A0N,128,128^FD") + 25, decodedStringShipments.indexOf("^FT691,982^A0N,128,128^FD") + 26);
        //    System.out.println("handlingCodeFromLabel = " + handlingCodeFromLabel);
        String weightFromLabel = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT620,500^A0N,27,27^FD") + 23, decodedStringShipments.indexOf("^FT620,500^A0N,27,27^FD") + 26);
        //    System.out.println("weightFromLabel = " + weightFromLabel);

        //    System.out.println("bringParcelPojoShipments.getForwarderServiceCode() = " + bringParcelPojoShipments.getForwarderServiceCode());
        assertThat(bringParcelPojoShipments.getForwarderServiceCode(), is(equalTo("BNP-BUS-PRCL")));

        if (bringParcelPojoShipments.getForwarderServiceCode().equals("BNP-BUS-PRCL")) {
            assertThat(productIdFromLabel, is(equalTo("0330")));
            assertThat(productFromLabel, is(equalTo("Bring Parcel Business Parcel")));
            if (deliveryCountryCodeFromJson.equals("NO")) {
                assertThat(handlingCodeFromLabel, is(equalTo("2")));
                String maxWeight = "35";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
            if (deliveryCountryCodeFromJson.equals("SE")) {
                String maxWeight = "35";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
        } else if (bringParcelPojoShipments.getForwarderServiceCode().equals("BNP-BUS-PRCL-BLK")) {
            assertThat(productIdFromLabel, is(equalTo("0332")));
            assertThat(productFromLabel, is(equalTo("Bring Parcel Business Parcel Bulk")));
            if (deliveryCountryCodeFromJson.equals("NO")) {
                assertThat(handlingCodeFromLabel, is(equalTo("2")));
                String maxWeight = "35";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
            if (deliveryCountryCodeFromJson.equals("SE")) {
                String maxWeight = "35";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
        } else if (bringParcelPojoShipments.getForwarderServiceCode().equals("BNP-PICKUP-PRCL")) {
            assertThat(productIdFromLabel, is(equalTo("0340")));
            assertThat(productFromLabel, is(equalTo("Bring Parcel Pick-up Parcel")));
            if (deliveryCountryCodeFromJson.equals("NO")) {
                assertThat(handlingCodeFromLabel, is(equalTo("3")));
                String maxWeight = "35";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
            if (deliveryCountryCodeFromJson.equals("SE")) {
                String maxWeight = "20";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
        } else if (bringParcelPojoShipments.getForwarderServiceCode().equals("BNP-PICKUP-PRCL-BLK")) {
            assertThat(productIdFromLabel, is(equalTo("0342")));
            assertThat(productFromLabel, is(equalTo("Bring Parcel Pick-up Parcel Bulk")));
            if (deliveryCountryCodeFromJson.equals("NO")) {
                assertThat(handlingCodeFromLabel, is(equalTo("3")));
                String maxWeight = "35";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
            if (deliveryCountryCodeFromJson.equals("SE")) {
                String maxWeight = "20";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
        } else if (bringParcelPojoShipments.getForwarderServiceCode().equals("BNP-BUS-PALLET")) {
            assertThat(productIdFromLabel, is(equalTo("0336")));
            assertThat(productFromLabel, is(equalTo("Bring Parcel Business Pallet")));
            if (deliveryCountryCodeFromJson.equals("NO")) {
                String maxWeight = "1000";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
            if (deliveryCountryCodeFromJson.equals("SE")) {
                String maxWeight = "1000";
                assertThat(weightFromLabel, is(lessThanOrEqualTo(maxWeight)));
            }
        } else {
            System.out.println("Forwarder Service Code is " + bringParcelPojoShipments.getForwarderServiceCode());
        }
    }


    @DisplayName("Unique Shipment Identity, 12345670000019437")
    @Test
    public void test10() {


        String shipmentIdFromJson = bringParcelPojoShipments.getForwarderRef();
        //    System.out.println("shipmentIdFromJson = " + shipmentIdFromJson);
        int shipmentIdFromLabelStart = decodedStringShipments.indexOf("^FT30,567^A0N,27,27^FD") + 22;
        String shipmentIdFromLabel = decodedStringShipments.substring(shipmentIdFromLabelStart, shipmentIdFromLabelStart + shipmentIdFromJson.length());
        //    System.out.println("shipmentIdFromLabel = " + shipmentIdFromLabel);
        assertThat(shipmentIdFromJson, is(equalTo(shipmentIdFromLabel)));

    }


    @DisplayName("(Hard-coded) Customer ID check, 12BAC3DE")
    @Test
    public void test11() {


        int customerNoFromLabelStart = decodedStringShipments.indexOf("^FT620,560^A0N,27,27^FD") + 23;
        String customerNoFromLabel = decodedStringShipments.substring(customerNoFromLabelStart, customerNoFromLabelStart + 8);
        //    System.out.println("customerNoFromLabel = " + customerNoFromLabel);
        assertThat(customerNoFromLabel, is(equalTo("12BAC3DE")));
    }


    @DisplayName("Bring LOGO")
    @Test
    public void test12() {

        String bringLogoFromLabel = "^FO35,854^GFA,630,1596,12,:Z64:eJytlU1qAzEMhW20";
        assertThat(decodedStringShipments, containsString(bringLogoFromLabel));
    }


    @DisplayName("Icon, based on 1. package weight: 2 KGM --> Light, up to 15 kg, Converted weight: 2.0 kg")
    @Test
    public void test13() {

        if (weightInKilos > 25) {
            assertThat(decodedStringShipments, containsString(heavyWeightIcon));
        } else if (weightInKilos > 15 && (weightInKilos <= 25)) {
            assertThat(decodedStringShipments, containsString(mediumWeightIcon));
        } else if (weightInKilos <= 15) {
            assertThat(decodedStringShipments, containsString(upTo15kgIcon));
        }

    }


    @DisplayName("1. package's' & shipment weight: 2 KGM(package input weight), Converted (package) weight: 2.0 kg. Total (shipment) weight is 2.0 kg")
    @Test
    public void test14() {

        //    System.out.println("totalGrossWeight = " + totalGrossWeight);
        //    System.out.println("bringParcelPojoShipments.getShippingUnits().get(0).getGrossWeight() = " + (bringParcelPojoShipments.getShippingUnits().get(0).getGrossWeight()));
        //    System.out.println("grossWeight = " + grossWeight);
        //    System.out.println("((double) (totalGrossWeight)) = " + ((double) (totalGrossWeight)));
        //    System.out.println("(Precision.round(bringParcelPojoShipments.getShippingUnits().get(0).getGrossWeight(), 0)) = " + (Precision.round(bringParcelPojoShipments.getShippingUnits().get(0).getGrossWeight(), 0)));
        assertThat(bringParcelPojoShipments.getNumberOfShippingUnits(), is(equalTo(detectedNumberOfPackages)));
        assertThat(Precision.round(bringParcelPojoShipments.getShippingUnits().get(0).getGrossWeight(), 0), is(equalTo((double) (totalGrossWeight))));

    }


    @DisplayName("1. package's Unique Package Identity, (00)112345670000024094")
    @Test
    public void test15() {

        String packageIdFromJson = bringParcelPojoShipments.getShippingUnits().get(0).getForwarderRef();
        //    System.out.println("packageIdFromJson = " + packageIdFromJson);
        int packageIdFromLabelStart = decodedStringShipments.indexOf("^FT30,500^A0N,27,27^FD") + 22;
        String packageIdFromLabel = decodedStringShipments.substring(packageIdFromLabelStart, packageIdFromLabelStart + packageIdFromJson.length() + 2).replace("(", "").replace(")", "");
        //    System.out.println("packageIdFromLabel = " + packageIdFromLabel);
        assertThat(packageIdFromJson, is(equalTo(packageIdFromLabel)));

    }


    @DisplayName("1. package's Package-ID, printed under barcode, (00)112345670000024094")
    @Test
    public void test16() {

        String packageIdFromJson = bringParcelPojoShipments.getShippingUnits().get(0).getForwarderRef();
        //System.out.println("packageIdFromJson = " + packageIdFromJson);
        int packageIdFromLabelStart = decodedStringShipments.indexOf("^FT252,1560^A0N,33,33^FD") + 24;
        String packageIdFromLabel = decodedStringShipments.substring(packageIdFromLabelStart, packageIdFromLabelStart + packageIdFromJson.length() + 2).replace("(", "").replace(")", "");
        //System.out.println("packageIdFromLabel = " + packageIdFromLabel);
        assertThat(packageIdFromJson, is(equalTo(packageIdFromLabel)));
        int barcodeFromLabelStart = decodedStringShipments.indexOf("^FO172,1254^BCN,209,N^FD>;>8") + 28;
        String barcodeFromLabel = decodedStringShipments.substring(barcodeFromLabelStart, barcodeFromLabelStart + packageIdFromJson.length());
        assertThat(barcodeFromLabel, is(equalTo(packageIdFromJson)));

    }


    @DisplayName("1. package's Package number identifier, 1 / {1|1} for CEVA")
    @Test
    public void test17() {


        String numberOfShippingUnitsFromJson = String.valueOf(bringParcelPojoShipments.getNumberOfShippingUnits());
        //System.out.println("numberOfShippingUnitsFromJson = " + numberOfShippingUnitsFromJson);
        int packagesFromLabelStart = decodedStringShipments.indexOf("^FT366,500^A0N,27,27^FD") + 23;
        String packagesSuffix = " / -";
        String packagesFromLabel = decodedStringShipments.substring(packagesFromLabelStart, packagesFromLabelStart + numberOfShippingUnitsFromJson.length() + packagesSuffix.length());
        //System.out.println("packagesFromLabel = " + packagesFromLabel);
        assertThat(numberOfShippingUnitsFromJson + packagesSuffix, is(equalTo(packagesFromLabel)));
    }


    @DisplayName("1. package's sender / shipper reference, SU.ShipperRef")
    @Test
    public void test18() {


        assertThat(decodedStringShipments, containsString("^FT30,1039^A0N,22,22^FDSenders reference:^FS"));
        String shipperRefFromJson = bringParcelPojoShipments.getShippingUnits().get(0).getShipperRef();
        //System.out.println("shipperRefFromJson = " + shipperRefFromJson);
        int sendersRefFromLabelStart = decodedStringShipments.indexOf("^FT30,1077^A0N,30,30^FD") + 23;
        String sendersRefFromLabel = decodedStringShipments.substring(sendersRefFromLabelStart, sendersRefFromLabelStart + shipperRefFromJson.length());
        // System.out.println("sendersRefFromLabel = " + sendersRefFromLabel);
        assertThat(shipperRefFromJson, is(equalTo(sendersRefFromLabel)));

    }


    @DisplayName("UNB+UNOC:3+12BAC3DE:ZZZ+7080003248381:14+211222:1416+00000000002119 checks.")
    @Test
    public void test19() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //System.out.println("decodeArrList.get(1) = " + decodeArrList.get(1));

        String refStart = (String) bringParcelPojoConveyances.getDocuments().get(0).getReference();
        assertThat(decodeArrList.get(1).toString(), containsString("UNB+UNOC:3+12BAC3DE:ZZZ+7080003248381:14+" + (year - 2000) + month + day + ":" + hour + minute + "+0000000000" + refStart.substring(refStart.length() - 4)));


    }


    @DisplayName("UNH+312427+IFTMIN:D:04A:UN:BIG14 checks.")
    @Test
    public void test20() {


        //System.out.println("shipmentIdFromShipmentsRequest = " + shipmentIdFromShipmentsRequest);
        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //System.out.println("decodeArrList.get(2) = " + decodeArrList.get(2));
        assertThat(decodeArrList.get(2), is(equalTo("UNH+" + bringParcelPojoShipments.getShipmentId() + "+IFTMIN:D:04A:UN:BIG14")));

    }


    @DisplayName("BGM+610+20211222141626282+9 checks.")
    @Test
    public void test21() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //System.out.println("decodeArrList.get(3) = " + decodeArrList.get(3));

        assertThat(decodeArrList.get(3).toString(), containsString("BGM+610+" + year + month + day + hour + minute));
        assertThat(decodeArrList.get(3).toString(), containsString("+9"));

    }


    @DisplayName("DTM+137:202112221416:203 checks.")
    @Test
    public void test22() {


        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(4) = " + decodeArrList.get(4));
        assertThat(decodeArrList.get(4).toString(), containsString("DTM+137:" + year + month + day + hour + minute + ":203"));

    }


    @DisplayName("DTM+234:20211222:102 checks.")
    @Test
    public void test23() {


        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(5) = " + decodeArrList.get(5));
        assertThat(decodeArrList.get(5).toString(), containsString("DTM+234:" + year + month + day + ":102"));

    }


    @DisplayName("FTX+PRD+++0330 checks.")
    @Test
    public void test24() {


        String productIdFromLabelShipments = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT169,988^A0N,54,54^FD") + 23, decodedStringShipments.indexOf("^FT169,988^A0N,54,54^FD") + 23 + 4);
        //    System.out.println("productIdFromLabelShipments = " + productIdFromLabelShipments);
        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(6) = " + decodeArrList.get(6));
        assertThat(decodeArrList.get(6).toString(), containsString("FTX+PRD+++" + productIdFromLabelShipments));

    }


    @DisplayName("Total: 2.0, - CNT+7:2.0:KGM checks.")
    @Test
    public void test25() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(7) = " + decodeArrList.get(7));
        assertThat(decodeArrList.get(7).toString(), containsString("CNT+7:" + Precision.round(weightInKilos, 1) + ":KGM"));

    }


    @DisplayName("Total packages 1, CNT+11:1:PCE checks.")
    @Test
    public void test26() {


        //    System.out.println("bringParcelPojoShipments.getShippingUnits().get(0).getIndex() = " + bringParcelPojoShipments.getShippingUnits().get(0).getIndex());
        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(8) = " + decodeArrList.get(8));
        assertThat(decodeArrList.get(8).toString(), containsString("CNT+11:" + bringParcelPojoShipments.getShippingUnits().get(0).getIndex() + ":PCE"));

    }


    @DisplayName("Total volume 13.36, CNT+15:0.00001336:MTQ checks.")
    @Test
    public void test27() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(9) = " + decodeArrList.get(9));
        assertThat(decodeArrList.get(9).toString(), containsString("CNT+15:" + String.format("%.8f", volumeInCubicMetre) + ":MTQ"));

    }


    @DisplayName("RFF+CU:s.ShipperRef checks.")
    @Test
    public void test28() {


        //    System.out.println("bringParcelPojoShipments.getShipperRef() = " + bringParcelPojoShipments.getShipperRef());
        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(10) = " + decodeArrList.get(10));
        assertThat(decodeArrList.get(10).toString(), containsString("RFF+CU:" + bringParcelPojoShipments.getShipperRef()));

    }


    @DisplayName("RFF+SRN:12345670000020662 checks.")
    @Test
    public void test29() {


        //    System.out.println("bringParcelPojoShipments.getForwarderRef() = " + bringParcelPojoShipments.getForwarderRef());
        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(11) = " + decodeArrList.get(11));
        assertThat(decodeArrList.get(11).toString(), containsString("RFF+SRN:" + bringParcelPojoShipments.getForwarderRef()));

    }


    @DisplayName("TDT+20++++BPI::87 checks.")
    @Test
    public void test30() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(12) = " + decodeArrList.get(12));
        assertThat(decodeArrList.get(12).toString(), containsString("TDT+20++++BPI::87"));


    }


    @DisplayName("Pickup ADDRESS 1: NAD+CZ+01053548::87++CEVA pickups+Earl Bakkenstraat 7+HEERLEN++6422 PJ+NL checks.")
    @Test
    public void test31() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(13) = " + decodeArrList.get(13));
        assertThat(decodeArrList.get(13).toString(), is(equalTo("NAD+CZ+" + bringParcelPojoShipments.getPickupForwarderDivisionAccountCode() + "::87++" + bringParcelPojoShipments.getAddresses().get(0).getReference() + "+" + bringParcelPojoShipments.getAddresses().get(0).getAddressLines().get(0).getValue() + "+" + bringParcelPojoShipments.getAddresses().get(0).getLocalityName() + "++" + bringParcelPojoShipments.getAddresses().get(0).getPostalCode() + "+" + bringParcelPojoShipments.getAddresses().get(0).getCountryCode())));
    }


    @DisplayName("Pickup Contact, CTA+IC+:Randall Flagg checks.")
    @Test
    public void test32() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(14) = " + decodeArrList.get(14));
        assertThat(decodeArrList.get(14).toString(), is(equalTo("CTA+IC+:" + bringParcelPojoShipments.getAddresses().get(0).getContacts().get(0).getName())));
    }


    @DisplayName("Pickup email, COM+r?.flagg@thestand?.com:EM checks.")
    @Test
    public void test33() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(15) = " + decodeArrList.get(15));
        assertThat(decodeArrList.get(15).toString(), is(equalTo("COM+" + bringParcelPojoShipments.getAddresses().get(0).getContacts().get(0).getEmailAddress().replace(".", "?.") + ":EM")));
    }


    @DisplayName("Pickup phone COM+31688877766:AL checks.")
    @Test
    public void test34() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(16) = " + decodeArrList.get(16));
        assertThat(decodeArrList.get(16).toString(), is(equalTo("COM+" + bringParcelPojoShipments.getAddresses().get(0).getContacts().get(0).getPhoneNumber() + ":AL")));
    }


    @DisplayName("Delivery ADDRESS 1: NAD+CN+::87++DY?.REFERENCE+Grand Hotel Oslo:Karl Johans gate 31+OSLO++0159+NO checks.")
    @Test
    public void test35() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(17) = " + decodeArrList.get(17));
        assertThat(decodeArrList.get(17).toString(), is(equalTo("NAD+CN+::87++" + bringParcelPojoShipments.getAddresses().get(1).getReference().replace(".", "?.") + "+" + bringParcelPojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue() + ":" + bringParcelPojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue() + "+" + bringParcelPojoShipments.getDeliveryAddress().getLocalityName() + "++" + bringParcelPojoShipments.getDeliveryAddress().getPostalCode() + "+" + bringParcelPojoShipments.getDeliveryAddress().getCountryCode())));
    }


    @DisplayName("Delivery contact, CTA+IC+:DY?.Contact Name checks.")
    @Test
    public void test36() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(18) = " + decodeArrList.get(18));
        assertThat(decodeArrList.get(18).toString(), is(equalTo("CTA+IC+:" + bringParcelPojoShipments.getDeliveryAddress().getContacts().get(0).getName().replace(".", "?."))));
    }


    @DisplayName("Delivery email, COM+delivery@email?.com:EM checks.")
    @Test
    public void test37() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(19) = " + decodeArrList.get(19));
        assertThat(decodeArrList.get(19).toString(), is(equalTo("COM+" + bringParcelPojoShipments.getDeliveryAddress().getContacts().get(0).getEmailAddress().replace(".", "?.") + ":EM")));
    }


    @DisplayName("Delivery phone number, COM+<PLACEHOLDER>062222222:AL checks.")
    @Test
    public void test38() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(20) = " + decodeArrList.get(20));
        assertThat(decodeArrList.get(20).toString(), is(equalTo("COM+" + bringParcelPojoShipments.getDeliveryAddress().getContacts().get(0).getPhoneNumber().replace("+", "").replace("(", "").replace(")", "").replace("-", "") + ":AL")));
    }


    @DisplayName("ACCOUNT: NAD+FP+12BAC3DE::87 checks.")
    @Test
    public void test39() {


        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(21) = " + decodeArrList.get(21));
        assertThat(decodeArrList.get(21).toString(), is(equalTo("NAD+FP+12BAC3DE::87")));

    }


    @DisplayName("Package #1, GID+1+1:PD")
    @Test
    public void test40() {


        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(22) = " + decodeArrList.get(22));
//        if (bringParcelPojoShipments.getShippingUnits().toString().contains("Quantity")) {
//            assertThat(decodeArrList.get(22).toString(), is(equalTo("GID" + "+" + validateResponseShipments.extract().jsonPath().getInt("Quantity") + "+" + bringParcelPojoShipments.getNumberOfShippingUnits() + ":" + bringParcelPojoShipments.getShippingUnits().get(0).getPackageType())));
//        } else {
        assertThat(decodeArrList.get(22).toString(), is(equalTo("GID" + "+" + "1" + "+" + bringParcelPojoShipments.getNumberOfShippingUnits() + ":" + bringParcelPojoShipments.getShippingUnits().get(0).getPackageType())));
    }
//    }


    @DisplayName("Package #1 weight ('Standard', always present; #6434), MEA+WT+G+KGM:2.0")
    @Test
    public void test41() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(23) = " + decodeArrList.get(23));
        assertThat(decodeArrList.get(23).toString(), is(equalTo("MEA+WT+G+KGM" + ":" + Precision.round(weightInKilos, 1))));
    }


    @DisplayName("Package #1 dimensions, DIM+2+CMT:33:27:15")
    @Test
    public void test42() {

        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(24) = " + decodeArrList.get(24));
        assertThat(decodeArrList.get(24).toString(), is(equalTo("DIM+2" + "+" + bringParcelPojoShipments.getShippingUnits().get(0).getDimensionsUnitOfMeasure() + ":" + String.format("%.0f", bringParcelPojoShipments.getShippingUnits().get(0).getLength()) + ":" + String.format("%.0f", bringParcelPojoShipments.getShippingUnits().get(0).getWidth()) + ":" + String.format("%.0f", bringParcelPojoShipments.getShippingUnits().get(0).getHeight()))));
    }


    @DisplayName("Verify the CHECK DIGIT for 00112345670000030125 is correct. We expect: 5 for 11234567000003012")
    @Test
    public void test43() {

        //    System.out.println("bringParcelPojoShipments.getShippingUnits().get(0).getForwarderRef().substring(2) = " + bringParcelPojoShipments.getShippingUnits().get(0).getForwarderRef().substring(2, 19));
        //    System.out.println("bringParcelPojoShipments.getShippingUnits().get(0).getForwarderRef() = " + bringParcelPojoShipments.getShippingUnits().get(0).getForwarderRef());
        //    System.out.println("checkDigit = " + checkDigit);
        assertThat(bringParcelPojoShipments.getShippingUnits().get(0).getForwarderRef().substring(19, 20), is(equalTo(String.valueOf(checkDigit))));
    }


    @DisplayName("Package #1 Tracking number, PCI+30+112345670000030125")
    @Test
    public void test44() {


        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(25) = " + decodeArrList.get(25));
        assertThat(decodeArrList.get(25).toString(), is(equalTo("PCI+30" + "+" + bringParcelPojoShipments.getShippingUnits().get(0).getForwarderRef().substring(2))));
    }


    @DisplayName("Package #1 reference number, RFF+CW:SU.ShipperRef")
    @Test
    public void test45() {


        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(26) = " + decodeArrList.get(26));
        assertThat(decodeArrList.get(26).toString(), is(equalTo("RFF+CW:" + bringParcelPojoShipments.getShippingUnits().get(0).getShipperRef())));
    }


    @DisplayName("UNT: UNT+26+314596 checks.")
    @Test
    public void test46() {


        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(27) = " + decodeArrList.get(27));
        assertThat(decodeArrList.get(27).toString(), is(equalTo("UNT" + "+" + (decodeArrList.indexOf(decodeArrList.get(27).toString()) - 1) + "+" + bringParcelPojoShipments.getShipmentId())));
    }


    @DisplayName("UNT: UNZ+1+00000000002598' checks.")
    @Test
    public void test47() {


        String[] decodeArr = decodedStringConveyances.split("\'\r\n");
        List decodeArrList = Arrays.asList(decodeArr);
        //    System.out.println("decodeArrList.get(28) = " + decodeArrList.get(28));
        assertThat(decodeArrList.get(28).toString().replace("'", ""), is(equalTo("UNZ+1" + "+" + decodeArrList.get(1).toString().substring((decodeArrList.get(1).toString().lastIndexOf("+") + 1)))));

    }


}
