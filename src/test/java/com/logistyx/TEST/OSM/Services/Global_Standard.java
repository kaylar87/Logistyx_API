package com.logistyx.TEST.OSM.Services;


import com.logistyx.utilities.AbstractBaseClasses.OSM.Services.OSMBaseGlobalStandardNotDG;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Global_Standard extends OSMBaseGlobalStandardNotDG {

    static {

        OSMBaseGlobalStandardNotDG.shipmentsLabel();

    }


    @DisplayName("ShippingId is not NULL")
    @Test
    public void test1() {


        assertThat(osmPojoShipments.getShipmentId(), is(notNullValue()));
//        validateResponseShipments.extract().response().prettyPrint();
//        System.out.println("decodedStringShipments = " + decodedStringShipments);

    }


    @DisplayName("ZPL Label is not NULL")
    @Test
    public void test2() {

        assertThat(encodedStringFromPostmanShipments, is(notNullValue()));
        System.out.println("decodedStringConveyancesInternational = " + decodedStringConveyancesInternational);
    }


    @DisplayName("ZPL Label size > 500 characters")
    @Test
    public void test3() {

        assertThat(encodedStringFromPostmanShipments.length(), is(greaterThan(500)));

    }


    @DisplayName("ZPL Carrier service F1 - 'GEN_BERLIN'")
    @Test
    public void test4() {

        String carrierServiceF1FromJson = osmPojoShipments.getPickupAddress().getReference();
        //    System.out.println("carrierServiceF1FromJson = " + carrierServiceF1FromJson);
        int carrierServiceF1FromLabelStart = decodedStringShipments.indexOf("^FT35,40^A0N,24,24^FH^FD") + 24;
        String carrierServiceF1FromLabel = (decodedStringShipments.substring(carrierServiceF1FromLabelStart, carrierServiceF1FromLabelStart + carrierServiceF1FromJson.length() + 2)).replace("5F", "");
        //    System.out.println("carrierServiceF1FromLabel = " + carrierServiceF1FromLabel);
        assertThat(carrierServiceF1FromJson, is(equalTo(carrierServiceF1FromLabel)));

    }


    @DisplayName("ZPL Carrier service F2 - '745 E KNOPF RD'")
    @Test
    public void test5() {

        String carrierServiceF2FromJson = ((String) osmPojoShipments.getPickupAddress().getAddressLines().get(0).getValue()).toUpperCase();
        //    System.out.println("carrierServiceF2FromJson = " + carrierServiceF2FromJson);
        int carrierServiceF2FromLabelStart = decodedStringShipments.indexOf("^FT35,66^A0N,24,24^FD") + 21;
        String carrierServiceF2FromLabel = decodedStringShipments.substring(carrierServiceF2FromLabelStart, carrierServiceF2FromLabelStart + carrierServiceF2FromJson.length());
        //    System.out.println("carrierServiceF2FromLabel = " + carrierServiceF2FromLabel);
        assertThat(carrierServiceF2FromJson, is(equalTo(carrierServiceF2FromLabel)));

    }


    @DisplayName("ZPL Carrier service F3 - 'BERLIN, WI 54923'")
    @Test
    public void test6() {

        String carrierServiceF3FromJson = (osmPojoShipments.getPickupAddress().getLocalityName()).toUpperCase() + ", " + osmPojoShipments.getPickupAddress().getSubdivisionCode() + " " + osmPojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("carrierServiceF3FromJson = " + carrierServiceF3FromJson);
        int carrierServiceF3FromLabelStart = decodedStringShipments.indexOf("^FT35,93^A0N,24,24^FD") + 21;
        String carrierServiceF3FromLabel = decodedStringShipments.substring(carrierServiceF3FromLabelStart, carrierServiceF3FromLabelStart + carrierServiceF3FromJson.length());
        //    System.out.println("carrierServiceF3FromLabel = " + carrierServiceF3FromLabel);
        assertThat(carrierServiceF3FromJson, is(equalTo(carrierServiceF3FromLabel)));

    }


    @DisplayName("ZPL Carrier service G1 - 'LOWE'S COMPANIES, INC.'")
    @Test
    public void test7() {

        String carrierServiceG1FromJson = osmPojoShipments.getDeliveryAddress().getReference();
        //    System.out.println("carrierServiceG1FromJson = " + carrierServiceG1FromJson);
        int carrierServiceG1FromLabelStart = decodedStringShipments.indexOf("^FT61,172^A0N,30,30^FD") + 22;
        String carrierServiceG1FromLabel = decodedStringShipments.substring(carrierServiceG1FromLabelStart, carrierServiceG1FromLabelStart + carrierServiceG1FromJson.length());
        //   System.out.println("carrierServiceG1FromLabel = " + carrierServiceG1FromLabel);
        assertThat(carrierServiceG1FromJson, is(equalTo(carrierServiceG1FromLabel)));

    }


    @DisplayName("ZPL Carrier service G2 - 'LOWE'S COMPANIES, INC.'")
    @Test
    public void test8() {

        String carrierServiceG2FromJson = osmPojoShipments.getDeliveryAddress().getContacts().get(0).getName();
        //    System.out.println("carrierServiceG2FromJson = " + carrierServiceG2FromJson);
        int carrierServiceG2FromLabelStart = decodedStringShipments.indexOf("^FT61,202^A0N,30,30^FD") + 22;
        String carrierServiceG2FromLabel = decodedStringShipments.substring(carrierServiceG2FromLabelStart, carrierServiceG2FromLabelStart + carrierServiceG2FromJson.length());
        //    System.out.println("carrierServiceG2FromLabel = " + carrierServiceG2FromLabel);
        assertThat(carrierServiceG2FromJson, is(equalTo(carrierServiceG2FromLabel)));

    }


    @DisplayName("ZPL Carrier service G3 - '15 MAIN ST'")
    @Test
    public void test9() {

        String carrierServiceG3FromJson = (osmPojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue()).toUpperCase();
        //    System.out.println("carrierServiceG3FromJson = " + carrierServiceG3FromJson);
        int carrierServiceG3FromLabelStart = decodedStringShipments.indexOf("^FT61,232^A0N,30,30^FD") + 22;
        String carrierServiceG3FromLabel = decodedStringShipments.substring(carrierServiceG3FromLabelStart, carrierServiceG3FromLabelStart + carrierServiceG3FromJson.length());
        //    System.out.println("carrierServiceG3FromLabel = " + carrierServiceG3FromLabel);
        assertThat(carrierServiceG3FromJson, is(equalTo(carrierServiceG3FromLabel)));

    }


    @DisplayName("ZPL Carrier service G4 - 'OSLO,  0159'")
    @Test
    public void test10() {

//        String carrierServiceG4FromJson = (osmPojoShipments.getDeliveryAddress().getLocalityName()).toUpperCase() + ", " + osmPojoShipments.getDeliveryAddress().getSubdivisionCode() + " " + osmPojoShipments.getDeliveryAddress().getPostalCode();
//        //    System.out.println("carrierServiceG4FromJson = " + carrierServiceG4FromJson);
//        int carrierServiceG4FromLabelStart = decodedStringShipments.indexOf("^FT61,262^A0N,30,30^FD") + 22;
//        String carrierServiceG4FromLabel = decodedStringShipments.substring(carrierServiceG4FromLabelStart, carrierServiceG4FromLabelStart + carrierServiceG4FromJson.length());
//        //   System.out.println("carrierServiceG4FromLabel = " + carrierServiceG4FromLabel);
//        assertThat(carrierServiceG4FromJson, is(equalTo(carrierServiceG4FromLabel)));


        if (osmPojoShipments.getDeliveryAddress().getSubdivisionCode() != null) {
            String carrierServiceG4FromJson = (osmPojoShipments.getDeliveryAddress().getLocalityName()).toUpperCase() + ", " + osmPojoShipments.getDeliveryAddress().getSubdivisionCode() + " " + osmPojoShipments.getDeliveryAddress().getPostalCode();
            //    System.out.println("carrierServiceG4FromJson = " + carrierServiceG4FromJson);
            int carrierServiceG4FromLabelStart = decodedStringShipments.indexOf("^FT61,262^A0N,30,30^FD") + 22;
            String carrierServiceG4FromLabel = decodedStringShipments.substring(carrierServiceG4FromLabelStart, carrierServiceG4FromLabelStart + carrierServiceG4FromJson.length());
            //   System.out.println("carrierServiceG4FromLabel = " + carrierServiceG4FromLabel);
            assertThat(carrierServiceG4FromJson, is(equalTo(carrierServiceG4FromLabel)));
        } else {
            String carrierServiceG4FromJson = (osmPojoShipments.getDeliveryAddress().getLocalityName()).toUpperCase() + ", " + " " + osmPojoShipments.getDeliveryAddress().getPostalCode();
            //    System.out.println("carrierServiceG4FromJson = " + carrierServiceG4FromJson);
            int carrierServiceG4FromLabelStart = decodedStringShipments.indexOf("^FT61,262^A0N,30,30^FD") + 22;
            String carrierServiceG4FromLabel = decodedStringShipments.substring(carrierServiceG4FromLabelStart, carrierServiceG4FromLabelStart + carrierServiceG4FromJson.length());
            //   System.out.println("carrierServiceG4FromLabel = " + carrierServiceG4FromLabel);
            assertThat(carrierServiceG4FromJson, is(equalTo(carrierServiceG4FromLabel)));
        }
    }


    @DisplayName("ZPL Carrier service H - 'PACKAGE ID'")
    @Test
    public void test11() {

        String carrierServiceHHardcoded = "PACKAGE ID";
        //    System.out.println("carrierServiceHHardcoded = " + carrierServiceHHardcoded);
        int carrierServiceHFromLabelStart = decodedStringShipments.indexOf("^FT327,350^A0N,33,33^FD") + 23;
        String carrierServiceHFromLabel = decodedStringShipments.substring(carrierServiceHFromLabelStart, carrierServiceHFromLabelStart + carrierServiceHHardcoded.length());
        //    System.out.println("carrierServiceHFromLabel = " + carrierServiceHFromLabel);
        assertThat(carrierServiceHHardcoded, is(equalTo(carrierServiceHFromLabel)));

    }


    @DisplayName("ZPL Carrier service I - '420001599200120220307000008159'")
    @Test
    public void test12() {

        String carrierServiceIFromJson = "420" + "0" + osmPojoShipments.getDeliveryAddress().getPostalCode() + "92" + carrierServiceSTCValueFromJsonMap.get(carrierServiceFromJson) + osmPojoShipments.getPickupForwarderDivisionAccountCode() + osmPojoShipments.getShippingUnits().get(0).getForwarderRef().substring(22, 29) + checkDigit;
        //    System.out.println("carrierServiceIFromJson = " + carrierServiceIFromJson);
        int carrierServiceIFromLabelStart = decodedStringShipments.indexOf("^FO106,376^BCN,142,N^FD>;") + 25;
        String carrierServiceIFromLabel = decodedStringShipments.substring(carrierServiceIFromLabelStart, carrierServiceIFromLabelStart + carrierServiceIFromJson.length());
        //    System.out.println("carrierServiceIFromLabel = " + carrierServiceIFromLabel);
        assertThat(carrierServiceIFromJson, is(equalTo(carrierServiceIFromLabel)));

    }


    @DisplayName("ZPL Carrier service J - '9205 5202 2030 7000 0058 26'")
    @Test
    public void test13() {

        String carrierServiceJFromJson = "92" + carrierServiceSTCValueFromJsonMap.get(carrierServiceFromJson) + osmPojoShipments.getPickupForwarderDivisionAccountCode() + osmPojoShipments.getShippingUnits().get(0).getForwarderRef().substring(22, 29) + checkDigit;
        //    System.out.println("carrierServiceJFromJson = " + carrierServiceJFromJson);
        int carrierServiceJFromLabelStart = decodedStringShipments.indexOf("^FT218,563^A0N,33,33^FD") + 23;
        String carrierServiceJFromLabel = decodedStringShipments.substring(carrierServiceJFromLabelStart, carrierServiceJFromLabelStart + carrierServiceJFromJson.length() + 5);
        //    System.out.println("carrierServiceJFromLabel = " + carrierServiceJFromLabel);
        assertThat(carrierServiceJFromJson, is(equalTo(carrierServiceJFromLabel.replace(" ", ""))));

    }


    @DisplayName("EDI - Package Id - '420535349205520220307000006656'")
    @Test
    public void test14() {

        String packageIdFromJson = osmPojoShipments.getShippingUnits().get(0).getForwarderRef();
        //    System.out.println("packageIdFromJson = " + packageIdFromJson);
        String packageIdFromEDI = decodedValuesInternational.get(0).replace("\"", "");
        //    System.out.println("packageIdFromEDI = " + packageIdFromEDI);
        assertThat(packageIdFromEDI, is(equalTo(packageIdFromJson)));

    }


    @DisplayName("EDI - Service - '1'")
    @Test
    public void test15() {

        String serviceHarcoded = carrierServiceSTCValueFromJsonMap.get(carrierServiceFromJson).substring(2);
        //    System.out.println("serviceHarcoded = " + serviceHarcoded);
        String serviceFromEDI = decodedValuesInternational.get(1);
        //    System.out.println("serviceFromEDI = " + serviceFromEDI);
        assertThat(serviceFromEDI, is(equalTo(serviceHarcoded)));

    }


    @DisplayName("EDI - Cost Center Id - ''")
    @Test
    public void test16() {

        String costCenterIdFromEDI = decodedValuesInternational.get(2);
        //    System.out.println("costCenterIdFromEDI = " + costCenterIdFromEDI);
        assertThat(costCenterIdFromEDI, is(equalTo("")));

    }


    //TODO - Mandatory based on PRD or NOT?
    @DisplayName("EDI - Total Value - ''")
    @Test
    public void test17() {


        if (osmPojoShipments.getShippingUnits().get(0).getCustomsValue() != null) {
            double totalValueFromJson = (double) osmPojoShipments.getShippingUnits().get(0).getCustomsValue();
            //    System.out.println("totalValueFromJson = " + totalValueFromJson);
            String totalValueFromEDI = decodedValuesInternational.get(3);
            //    System.out.println("totalValueFromEDI = " + totalValueFromEDI);
            assertThat(totalValueFromEDI, is(equalTo(String.valueOf(totalValueFromJson))));
        } else {
            String totalValueFromJson = "";
            //    System.out.println("totalValueFromJson = " + totalValueFromJson);
            String totalValueFromEDI = decodedValuesInternational.get(3);
            //    System.out.println("totalValueFromEDI = " + totalValueFromEDI);
            assertThat(totalValueFromEDI, is(equalTo(totalValueFromJson)));
        }
    }


    @DisplayName("EDI - Weight Lbs - '5.86'")
    @Test
    public void test18() {


        String weightFromJson = String.valueOf(osmPojoShipments.getShippingUnits().get(0).getGrossWeight());
        //    System.out.println("weightFromJson = " + weightFromJson);
        String weightFromEDI = decodedValuesInternational.get(4);
        //    System.out.println("weightFromEDI = " + weightFromEDI);
        assertThat(weightFromEDI, is(equalTo(weightFromJson)));

    }


    @DisplayName("EDI - Number of Items - '1'")
    @Test
    public void test19() {


        String numberOfItemsFromJson = String.valueOf(osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().size());
        //    System.out.println("numberOfItemsFromJson = " + numberOfItemsFromJson);
        String numberOfItemsFromEDI = decodedValuesInternational.get(5);
        //    System.out.println("numberOfItemsFromEDI = " + numberOfItemsFromEDI);
        assertThat(numberOfItemsFromEDI, is(equalTo(numberOfItemsFromJson)));

    }


    @DisplayName("EDI - Company - 'LOWE'S COMPANIES INC.'")
    @Test
    public void test20() {

        String companyFromJson = osmPojoShipments.getDeliveryAddress().getReference();
        //    System.out.println("companyFromJson = " + companyFromJson);
        String companyFromEDI = decodedValuesInternational.get(6);
        //    System.out.println("companyFromEDI = " + companyFromEDI);
        assertThat(companyFromEDI, is(equalTo(companyFromJson)));

    }


    @DisplayName("EDI - Name - 'LOWE'S COMPANIES INC.'")
    @Test
    public void test28() {

        String nameFromJson = osmPojoShipments.getDeliveryAddress().getContacts().get(0).getName();
        //    System.out.println("nameFromJson = " + nameFromJson);
        String nameFromEDI = decodedValuesInternational.get(7);
        //    System.out.println("nameFromEDI = " + nameFromEDI);
        assertThat(nameFromEDI, is(equalTo(nameFromJson)));

    }


    @DisplayName("EDI - Address 1 - '15 Main St'")
    @Test
    public void test29() {

        String address1FromJson = osmPojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue();
        //    System.out.println("address1FromJson = " + address1FromJson);
        String address1FromEDI = decodedValuesInternational.get(8);
        //    System.out.println("address1FromEDI = " + address1FromEDI);
        assertThat(address1FromEDI, is(equalTo(address1FromJson)));

    }


    @DisplayName("EDI - Address 2 - ''")
    @Test
    public void test30() {

        if (osmPojoShipments.getDeliveryAddress().getAddressLines().size() == 2) {
            String address2FromJson = osmPojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue();
            //    System.out.println("address2FromJson = " + address2FromJson);
            String address2FromEDI = decodedValuesInternational.get(9);
            //    System.out.println("address2FromEDI = " + address2FromEDI);
            assertThat(address2FromEDI, is(equalTo(address2FromJson)));
        } else {
            String address2FromJson = "";
            //    System.out.println("address2FromJson = " + address2FromJson);
            String address2FromEDI = decodedValuesInternational.get(9);
            //    System.out.println("address2FromEDI = " + address2FromEDI);
            assertThat(address2FromEDI, is(equalTo(address2FromJson)));
        }

    }


    @DisplayName("EDI - Address 3 - ''")
    @Test
    public void test31() {

        if (osmPojoShipments.getDeliveryAddress().getAddressLines().size() == 3) {
            String address3FromJson = osmPojoShipments.getDeliveryAddress().getAddressLines().get(2).getValue();
            //    System.out.println("address3FromJson = " + address3FromJson);
            String address3FromEDI = decodedValuesInternational.get(10);
            //    System.out.println("address3FromEDI = " + address3FromEDI);
            assertThat(address3FromEDI, is(equalTo(address3FromJson)));
        } else {
            String address3FromJson = "";
            //    System.out.println("address3FromJson = " + address3FromJson);
            String address3FromEDI = decodedValuesInternational.get(10);
            //    System.out.println("address3FromEDI = " + address3FromEDI);
            assertThat(address3FromEDI, is(equalTo(address3FromJson)));
        }

    }


    @DisplayName("EDI - City - 'OSLO'")
    @Test
    public void test32() {

        String cityFromJson = osmPojoShipments.getDeliveryAddress().getLocalityName();
        //    System.out.println("cityFromJson = " + cityFromJson);
        String cityFromEDI = decodedValuesInternational.get(11);
        //    System.out.println("cityFromEDI = " + cityFromEDI);
        assertThat(cityFromEDI, is(equalTo(cityFromJson)));

    }


    @DisplayName("EDI - State - ''")
    @Test
    public void test33() {

        if (osmPojoShipments.getDeliveryAddress().getSubdivisionCode() != null) {
            String stateFromJson = osmPojoShipments.getDeliveryAddress().getSubdivisionCode();
            //    System.out.println("stateFromJson = " + stateFromJson);
            String stateFromEDI = decodedValuesInternational.get(12);
            //    System.out.println("stateFromEDI = " + stateFromEDI);
            assertThat(stateFromEDI, is(equalTo(stateFromJson)));
        } else {
            String stateFromJson = "";
            //    System.out.println("stateFromJson = " + stateFromJson);
            String stateFromEDI = decodedValuesInternational.get(12);
            //    System.out.println("stateFromEDI = " + stateFromEDI);
            assertThat(stateFromEDI, is(equalTo(stateFromJson)));
        }
    }


    @DisplayName("EDI - Zip - '0159'")
    @Test
    public void test34() {

        String zipFromJson = osmPojoShipments.getDeliveryAddress().getPostalCode();
        //    System.out.println("zipFromJson = " + zipFromJson);
        String zipFromEDI = decodedValuesInternational.get(13);
        //    System.out.println("zipFromEDI = " + zipFromEDI);
        assertThat(zipFromEDI, is(equalTo(zipFromJson)));

    }


    @DisplayName("EDI - Country - 'NO'")
    @Test
    public void test35() {

        String countryFromJson = osmPojoShipments.getDeliveryAddress().getCountryCode();
        //    System.out.println("countryFromJson = " + countryFromJson);
        String countryFromEDI = decodedValuesInternational.get(14);
        //    System.out.println("countryFromEDI = " + countryFromEDI);
        assertThat(countryFromEDI, is(equalTo(countryFromJson)));

    }


    @DisplayName("EDI - EmailAddress - ''")
    @Test
    public void test36() {

        String emailAddressFromJson = osmPojoShipments.getDeliveryAddress().getContacts().get(0).getEmailAddress();
        //    System.out.println("emailAddressFromJson = " + emailAddressFromJson);
        String emailAddressFromEDI = decodedValuesInternational.get(15);
        //    System.out.println("emailAddressFromEDI = " + emailAddressFromEDI);
        assertThat(emailAddressFromEDI, is(equalTo(emailAddressFromJson)));

    }


    @DisplayName("EDI - Phone Number - '555-555-5555'")
    @Test
    public void test37() {

        String phoneNumberFromJson = osmPojoShipments.getDeliveryAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("phoneNumberFromJson = " + phoneNumberFromJson);
        String phoneNumberFromEDI = decodedValuesInternational.get(16);
        //    System.out.println("phoneNumberFromEDI = " + phoneNumberFromEDI);
        assertThat(phoneNumberFromEDI, is(equalTo(phoneNumberFromJson)));

    }


    @DisplayName("EDI - Reference 1 - 'Shipper Reference'")
    @Test
    public void test38() {

        if (osmPojoShipments.getShipperRef() != null) {
            String reference1FromJson = osmPojoShipments.getShipperRef();
            //    System.out.println("reference1FromJson = " + reference1FromJson);
            String reference1FromEDI = decodedValuesInternational.get(17);
            //    System.out.println("reference1FromEDI = " + reference1FromEDI);
            assertThat(reference1FromEDI, is(equalTo(reference1FromJson)));
        } else {
            String reference1FromJson = "";
            //    System.out.println("reference1FromJson = " + reference1FromJson);
            String reference1FromEDI = decodedValuesInternational.get(17);
            //    System.out.println("reference1FromEDI = " + reference1FromEDI);
            assertThat(reference1FromEDI, is(equalTo(reference1FromJson)));
        }
    }


    @DisplayName("EDI - Reference 2 - 'Receiver Reference'")
    @Test
    public void test39() {

        if (osmPojoShipments.getReceiverRef() != null) {
            String reference2FromJson = (String) osmPojoShipments.getReceiverRef();
            //   System.out.println("reference2FromJson = " + reference2FromJson);
            String reference2FromEDI = decodedValuesInternational.get(18);
            //    System.out.println("reference2FromEDI = " + reference2FromEDI);
            assertThat(reference2FromEDI, is(equalTo(reference2FromJson)));
        } else {
            String reference2FromJson = "";
            //   System.out.println("reference2FromJson = " + reference2FromJson);
            String reference2FromEDI = decodedValuesInternational.get(18);
            //    System.out.println("reference2FromEDI = " + reference2FromEDI);
            assertThat(reference2FromEDI, is(equalTo(reference2FromJson)));
        }
    }


    @DisplayName("EDI - Reference 3 - ''")
    @Test
    public void test40() {

        String reference3FromEDI = decodedValuesInternational.get(19);
        //    System.out.println("reference3FromEDI = " + reference3FromEDI);
        assertThat(reference3FromEDI, is(equalTo("")));

    }


    @DisplayName("EDI - Reference 4 - ''")
    @Test
    public void test41() {

        String reference4FromEDI = decodedValuesInternational.get(20);
        //    System.out.println("reference4FromEDI = " + reference4FromEDI);
        assertThat(reference4FromEDI, is(equalTo("")));

    }


    @DisplayName("EDI - Return Name - 'JOHN SILVER'")
    @Test
    public void test42() {

        if (osmPojoShipments.getAddresses().size() == 3) {
            String returnNameFromJson = osmPojoShipments.getAddresses().get(2).getReference();
            //    System.out.println("returnNameFromJson = " + returnNameFromJson);
            String returnNameFromEDI = decodedValuesInternational.get(21);
            //    System.out.println("returnNameFromEDI = " + returnNameFromEDI);
            assertThat(returnNameFromEDI, is(equalTo(returnNameFromJson)));
        } else {
            String returnNameFromJson = "";
            //    System.out.println("returnNameFromJson = " + returnNameFromJson);
            String returnNameFromEDI = decodedValuesInternational.get(21);
            //    System.out.println("returnNameFromEDI = " + returnNameFromEDI);
            assertThat(returnNameFromEDI, is(equalTo(returnNameFromJson)));
        }

    }


    @DisplayName("EDI - Return Address 1 - '111 E 21st St'")
    @Test
    public void test43() {

        if (osmPojoShipments.getAddresses().size() == 3) {
            String returnAddress1FromJson = (String) osmPojoShipments.getAddresses().get(2).getAddressLines().get(0).getValue();
            //    System.out.println("returnAddress1FromJson = " + returnAddress1FromJson);
            String returnAddress1FromEDI = decodedValuesInternational.get(22);
            //    System.out.println("returnAddress1FromEDI = " + returnAddress1FromEDI);
            assertThat(returnAddress1FromEDI, is(equalTo(returnAddress1FromJson)));
        } else {
            String returnAddress1FromJson = "";
            //    System.out.println("returnAddress1FromJson = " + returnAddress1FromJson);
            String returnAddress1FromEDI = decodedValuesInternational.get(22);
            //    System.out.println("returnAddress1FromEDI = " + returnAddress1FromEDI);
            assertThat(returnAddress1FromEDI, is(equalTo(returnAddress1FromJson)));
        }


    }


    @DisplayName("EDI - Return Address 2 - ''")
    @Test
    public void test44() {

        if (osmPojoShipments.getAddresses().size() == 3) {
            if (osmPojoShipments.getAddresses().get(2).getAddressLines().size() == 2) {
                String returnAddress2FromJson = (String) osmPojoShipments.getAddresses().get(2).getAddressLines().get(1).getValue();
                //    System.out.println("returnAddress2FromJson = " + returnAddress2FromJson);
                String returnAddress2FromEDI = decodedValuesInternational.get(23);
                //    System.out.println("returnAddress2FromEDI = " + returnAddress2FromEDI);
                assertThat(returnAddress2FromEDI, is(equalTo(returnAddress2FromJson)));
            } else {
                String returnAddress2FromJson = "";
                //    System.out.println("returnAddress2FromJson = " + returnAddress2FromJson);
                String returnAddress2FromEDI = decodedValuesInternational.get(23);
                //    System.out.println("returnAddress2FromEDI = " + returnAddress2FromEDI);
                assertThat(returnAddress2FromEDI, is(equalTo(returnAddress2FromJson)));
            }
        } else {
            String returnAddress2FromJson = "";
            //    System.out.println("returnAddress2FromJson = " + returnAddress2FromJson);
            String returnAddress2FromEDI = decodedValuesInternational.get(23);
            //    System.out.println("returnAddress2FromEDI = " + returnAddress2FromEDI);
            assertThat(returnAddress2FromEDI, is(equalTo(returnAddress2FromJson)));
        }


    }

    @DisplayName("EDI - Return Address 3 - ''")
    @Test
    public void test45() {

        if (osmPojoShipments.getAddresses().size() == 3) {
            if (osmPojoShipments.getAddresses().get(2).getAddressLines().size() == 3) {
                String returnAddress3FromJson = (String) osmPojoShipments.getAddresses().get(2).getAddressLines().get(2).getValue();
                //    System.out.println("returnAddress3FromJson = " + returnAddress3FromJson);
                String returnAddress3FromEDI = decodedValuesInternational.get(24);
                //    System.out.println("returnAddress3FromEDI = " + returnAddress3FromEDI);
                assertThat(returnAddress3FromEDI, is(equalTo(returnAddress3FromJson)));
            } else {
                String returnAddress3FromJson = "";
                //    System.out.println("returnAddress3FromJson = " + returnAddress3FromJson);
                String returnAddress3FromEDI = decodedValuesInternational.get(24);
                //    System.out.println("returnAddress3FromEDI = " + returnAddress3FromEDI);
                assertThat(returnAddress3FromEDI, is(equalTo(returnAddress3FromJson)));
            }
        } else {
            String returnAddress3FromJson = "";
            //    System.out.println("returnAddress3FromJson = " + returnAddress3FromJson);
            String returnAddress3FromEDI = decodedValuesInternational.get(24);
            //    System.out.println("returnAddress3FromEDI = " + returnAddress3FromEDI);
            assertThat(returnAddress3FromEDI, is(equalTo(returnAddress3FromJson)));
        }

    }


    @DisplayName("EDI - Return City - 'Brooklyn'")
    @Test
    public void test46() {
        if (osmPojoShipments.getAddresses().size() == 3) {
            String returnCityFromJson = osmPojoShipments.getAddresses().get(2).getLocalityName();
            //    System.out.println("returnCityFromJson = " + returnCityFromJson);
            String returnCityFromEDI = decodedValuesInternational.get(25);
            //    System.out.println("returnCityFromEDI = " + returnCityFromEDI);
            assertThat(returnCityFromEDI, is(equalTo(returnCityFromJson)));
        } else {
            String returnCityFromJson = "";
            //    System.out.println("returnCityFromJson = " + returnCityFromJson);
            String returnCityFromEDI = decodedValuesInternational.get(25);
            //    System.out.println("returnCityFromEDI = " + returnCityFromEDI);
            assertThat(returnCityFromEDI, is(equalTo(returnCityFromJson)));
        }

    }


    @DisplayName("EDI - Return State - 'NY'")
    @Test
    public void test47() {

        if (osmPojoShipments.getAddresses().size() == 3) {
            String returnStateFromJson = osmPojoShipments.getAddresses().get(2).getSubdivisionCode();
            //    System.out.println("returnStateFromJson = " + returnStateFromJson);
            String returnStateFromEDI = decodedValuesInternational.get(26);
            //    System.out.println("returnStateFromEDI = " + returnStateFromEDI);
            assertThat(returnStateFromEDI, is(equalTo(returnStateFromJson)));
        } else {
            String returnStateFromJson = "";
            //    System.out.println("returnStateFromJson = " + returnStateFromJson);
            String returnStateFromEDI = decodedValuesInternational.get(26);
            //    System.out.println("returnStateFromEDI = " + returnStateFromEDI);
            assertThat(returnStateFromEDI, is(equalTo(returnStateFromJson)));
        }

    }

    @DisplayName("EDI - Return Zip - '11230'")
    @Test
    public void test48() {

        if (osmPojoShipments.getAddresses().size() == 3) {
            String returnZipFromJson = osmPojoShipments.getAddresses().get(2).getPostalCode();
            //    System.out.println("returnZipFromJson = " + returnZipFromJson);
            String returnZipFromEDI = decodedValuesInternational.get(27);
            //    System.out.println("returnZipFromEDI = " + returnZipFromEDI);
            assertThat(returnZipFromEDI, is(equalTo(returnZipFromJson)));
        } else {
            String returnZipFromJson = "";
            //    System.out.println("returnZipFromJson = " + returnZipFromJson);
            String returnZipFromEDI = decodedValuesInternational.get(27);
            //    System.out.println("returnZipFromEDI = " + returnZipFromEDI);
            assertThat(returnZipFromEDI, is(equalTo(returnZipFromJson)));
        }

    }


    @DisplayName("EDI - Return Country - 'US'")
    @Test
    public void test49() {

        if (osmPojoShipments.getAddresses().size() == 3) {
            String returnCountryFromJson = osmPojoShipments.getAddresses().get(2).getCountryCode();
            //    System.out.println("returnCountryFromJson = " + returnCountryFromJson);
            String returnCountryFromEDI = decodedValuesInternational.get(28);
            //    System.out.println("returnCountryFromEDI = " + returnCountryFromEDI);
            assertThat(returnCountryFromEDI, is(equalTo(returnCountryFromJson)));
        } else {
            String returnCountryFromJson = "";
            //    System.out.println("returnCountryFromJson = " + returnCountryFromJson);
            String returnCountryFromEDI = decodedValuesInternational.get(28);
            //    System.out.println("returnCountryFromEDI = " + returnCountryFromEDI);
            assertThat(returnCountryFromEDI, is(equalTo(returnCountryFromJson)));
        }

    }


    @DisplayName("EDI - Recipient Tax Id - ''")
    @Test
    public void test50() {

        if (osmPojoShipments.getDeliveryAddress().getVatNumber() != null) {
            int recipientTaxIdFromJson = (int) osmPojoShipments.getDeliveryAddress().getVatNumber();
            //   System.out.println("recipientTaxIdFromJson = " + recipientTaxIdFromJson);
            String recipientTaxIdFromEDI = decodedValuesInternational.get(29);
            //    System.out.println("recipientTaxIdFromEDI = " + recipientTaxIdFromEDI);
            assertThat(recipientTaxIdFromEDI, is(equalTo(String.valueOf(recipientTaxIdFromJson))));
        } else {
            String recipientTaxIdFromJson = "";
            //    System.out.println("recipientTaxIdFromJson = " + recipientTaxIdFromJson);
            String recipientTaxIdFromEDI = decodedValuesInternational.get(29);
            //    System.out.println("recipientTaxIdFromEDI = " + recipientTaxIdFromEDI);
            assertThat(recipientTaxIdFromEDI, is(equalTo(recipientTaxIdFromJson)));
        }

    }


    @DisplayName("EDI - Sender Business Name - 'GEN_BERLIN'")
    @Test
    public void test51() {

        String senderBusinessNameFromJson = osmPojoShipments.getPickupAddress().getReference();
        //    System.out.println("senderBusinessNameFromJson = " + senderBusinessNameFromJson);
        String senderBusinessNameFromEDI = decodedValuesInternational.get(30);
        //    System.out.println("senderBusinessNameFromEDI = " + senderBusinessNameFromEDI);
        assertThat(senderBusinessNameFromEDI, is(equalTo(senderBusinessNameFromJson)));

    }


    @DisplayName("EDI - Sender Address - '745 E Knopf Rd'")
    @Test
    public void test52() {

        String senderAddressFromJson = (String) osmPojoShipments.getPickupAddress().getAddressLines().get(0).getValue();
        //    System.out.println("senderAddressFromJson = " + senderAddressFromJson);
        String senderAddressFromEDI = decodedValuesInternational.get(31);
        //    System.out.println("senderAddressFromEDI = " + senderAddressFromEDI);
        assertThat(senderAddressFromEDI, is(equalTo(senderAddressFromJson)));

    }


    //TODO fix
    @DisplayName("EDI - Sender City - ''")
    @Test
    public void test53() {

        String senderCityFromJson = (String) osmPojoShipments.getPickupAddress().getLocalityName();
        //    System.out.println("senderCityFromJson = " + senderCityFromJson);
        String senderCityFromEDI = decodedValuesInternational.get(32);
        //    System.out.println("senderCityFromEDI = " + senderCityFromEDI);
        assertThat(senderCityFromEDI, is(equalTo(senderCityFromJson)));

    }


    //TODO fix
    @DisplayName("EDI - Sender State - ''")
    @Test
    public void test54() {

        String senderStateFromJson = (String) osmPojoShipments.getPickupAddress().getSubdivisionCode();
        System.out.println("senderStateFromJson = " + senderStateFromJson);
        String senderStateFromEDI = decodedValuesInternational.get(33);
        System.out.println("senderStateFromEDI = " + senderStateFromEDI);
        assertThat(senderStateFromEDI, is(equalTo(senderStateFromJson)));

    }


    @DisplayName("EDI - Sender Zip Code - '54923'")
    @Test
    public void test55() {

        String senderZipCodeFromJson = osmPojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("senderZipCodeFromJson = " + senderZipCodeFromJson);
        String senderZipCodeFromEDI = decodedValuesInternational.get(34);
        //    System.out.println("senderZipCodeFromEDI = " + senderZipCodeFromEDI);
        assertThat(senderZipCodeFromEDI, is(equalTo(senderZipCodeFromJson)));

    }


    @DisplayName("EDI - Sender Zip Code Plus 4 - ''")
    @Test
    public void test56() {

        String senderZipCodePlus4FromJson = "";
        String senderZipCodePlus4FromEDI = decodedValuesInternational.get(35);
        //    System.out.println("senderZipCodePlus4FromEDI = " + senderZipCodePlus4FromEDI);
        assertThat(senderZipCodePlus4FromEDI, is(equalTo(senderZipCodePlus4FromJson)));

    }


    @DisplayName("EDI - Sender Phone - '262-544-4811'")
    @Test
    public void test57() {

        String senderPhoneFromJson = (String) osmPojoShipments.getPickupAddress().getContacts().get(0).getPhoneNumber();
        //    System.out.println("senderPhoneFromJson = " + senderPhoneFromJson);
        String senderPhoneFromEDI = decodedValuesInternational.get(36);
        //    System.out.println("senderPhoneFromEDI = " + senderPhoneFromEDI);
        assertThat(senderPhoneFromEDI, is(equalTo(senderPhoneFromJson)));

    }


    @DisplayName("EDI - Hazardous - '0'")
    @Test
    public void test58() {
        String hazardousFromJson;
        if (osmPojoShipments.getShippingUnits().get(0).getDangerousGoods().size() == 0 & osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().get(0).getDangerousGoods().size() == 0) {
            hazardousFromJson = "0";
        } else {
            hazardousFromJson = "1";
        }
        //    System.out.println("hazardousFromJson = " + hazardousFromJson);
        String hazardousFromEDI = decodedValuesInternational.get(37);
        //    System.out.println("hazardousFromEDI = " + hazardousFromEDI);
        assertThat(hazardousFromEDI, is(equalTo(hazardousFromJson)));

    }


    @DisplayName("EDI - SoftPack - ''")
    @Test
    public void test59() {

        String softPackFromEDI = decodedValuesInternational.get(38);
        //    System.out.println("softPackFromEDI = " + softPackFromEDI);
        assertThat(softPackFromEDI, is(equalTo("")));

    }


    @DisplayName("EDI - OSM BOL - ''")
    @Test
    public void test60() {

        String osmBolFromEDI = decodedValuesInternational.get(39);
        //    System.out.println("osmBolFromEDI = " + osmBolFromEDI);
        assertThat(osmBolFromEDI, is(equalTo("")));

    }


    @DisplayName("EDI - Item Number - '1' '2'")
    @Test
    public void test61() {

        if (osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().size() == 2) {
            String itemNumberFromEDI = decodedValuesInternational.get(40);
            //    System.out.println("itemNumberFromEDI = " + itemNumberFromEDI);
            assertThat(itemNumberFromEDI, is(equalTo("1")));
            String itemNumberFromEDI2 = decodedValuesInternational2.get(40);
            //    System.out.println("itemNumberFromEDI2 = " + itemNumberFromEDI2);
            assertThat(itemNumberFromEDI2, is(equalTo("2")));
        }
    }


    @DisplayName("EDI - Item Quantity - '2'")
    @Test
    public void test62() {

        String itemQuantityFromJson = String.valueOf(osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().get(0).getQuantity());
        //    System.out.println("itemQuantityFromJson = " + itemQuantityFromJson);
        String itemQuantityFromEDI = decodedValuesInternational.get(41);
        //    System.out.println("itemQuantityFromEDI = " + itemQuantityFromEDI);
        assertThat(itemQuantityFromEDI, is(equalTo(itemQuantityFromJson)));

    }


    @DisplayName("EDI - Item Sku - 'G0062120'")
    @Test
    public void test63() {

        String itemSkuFromJson = osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().get(0).getProductCode();
        //    System.out.println("itemSkuFromJson = " + itemSkuFromJson);
        String itemSkuFromEDI = decodedValuesInternational.get(42);
        //    System.out.println("itemSkuFromEDI = " + itemSkuFromEDI);
        assertThat(itemSkuFromEDI, is(equalTo(itemSkuFromJson)));

    }


    @DisplayName("EDI - Item Description - 'COLD WEATHER KIT A/C HSB'")
    @Test
    public void test64() {

        String itemDescriptionFromJson = osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().get(0).getDescription();
        //    System.out.println("itemDescriptionFromJson = " + itemDescriptionFromJson);
        String itemDescriptionFromEDI = decodedValuesInternational.get(43);
        //    System.out.println("itemDescriptionFromEDI = " + itemDescriptionFromEDI);
        assertThat(itemDescriptionFromEDI, is(equalTo(itemDescriptionFromJson)));

    }


    //TODO 6 = OTHER
    @DisplayName("EDI - Item Product Type - '1'")
    @Test
    public void test65() {

        String itemProductTypeFromJson = osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().get(0).getAdditionalValues().get(0).getAdditionalValueKey();
        System.out.println("itemProductTypeFromJson = " + itemProductTypeFromJson);
        String itemProductTypeFromEDI = decodedValuesInternational.get(44);
        System.out.println("itemProductTypeFromEDI = " + itemProductTypeFromEDI);
        assertThat(itemProductTypeFromEDI, is(equalTo(itemProductTypeFromJson)));

    }


    //TODO
    @DisplayName("EDI - Item Harmonized Code - '8516808000'")
    @Test
    public void test66() {

        String itemHarmonizedCodeFromJson = osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().get(0).getHarmonisedSystemCode();
        System.out.println("itemHarmonizedCodeFromJson = " + itemHarmonizedCodeFromJson);
        String itemHarmonizedCodeFromEDI = decodedValuesInternational.get(45);
        System.out.println("itemHarmonizedCodeFromEDI = " + itemHarmonizedCodeFromEDI);
        assertThat(itemHarmonizedCodeFromEDI, is(equalTo(itemHarmonizedCodeFromJson)));

    }


    //TODO
    @DisplayName("EDI - Item Value - '1.00'")
    @Test
    public void test67() {

        String itemValueFromJson = String.valueOf(osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().get(0).getValue());
        System.out.println("itemValueFromJson = " + itemValueFromJson);
        String itemValueFromEDI = decodedValuesInternational.get(46);
        System.out.println("itemValueFromEDI = " + itemValueFromEDI);
        assertThat(itemValueFromEDI, is(equalTo(itemValueFromJson)));

    }


    @DisplayName("EDI - Item Weight - '1.33'")
    @Test
    public void test68() {

        String itemWeightFromJson = String.valueOf(osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().get(0).getWeight());
        //    System.out.println("itemWeightFromJson = " + itemWeightFromJson);
        String itemWeightFromEDI = decodedValuesInternational.get(47);
        //    System.out.println("itemWeightFromEDI = " + itemWeightFromEDI);
        assertThat(itemWeightFromEDI, is(equalTo(itemWeightFromJson)));

    }


    @DisplayName("EDI - Item Country Of Origin - 'US'")
    @Test
    public void test69() {

        String itemCountryOfOriginFromJson = osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().get(0).getCountryOfOrigin();
        //    System.out.println("itemCountryOfOriginFromJson = " + itemCountryOfOriginFromJson);
        String itemCountryOfOriginFromEDI = decodedValuesInternational.get(48);
        //    System.out.println("itemCountryOfOriginFromEDI = " + itemCountryOfOriginFromEDI);
        assertThat(itemCountryOfOriginFromEDI, is(equalTo(itemCountryOfOriginFromJson)));

    }


    @DisplayName("EDI - Category Of Goods - '6'")
    @Test
    public void test70() {

        String itemCategoryOfGoodsFromJson = osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().get(0).getAdditionalValues().get(0).getValue();
        System.out.println("itemCategoryOfGoodsFromJson = " + itemCategoryOfGoodsFromJson);
        String itemCategoryOfGoodsFromEDI = decodedValuesInternational.get(49);
        System.out.println("itemCategoryOfGoodsFromEDI = " + itemCategoryOfGoodsFromEDI);
        assertThat(itemCategoryOfGoodsFromEDI, is(equalTo(itemCategoryOfGoodsFromJson)));

    }


    //TODO
    @DisplayName("EDI - Content Comments - 'Something'")
    @Test
    public void test71() {

        String contentCommentsFromJson = osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().get(0).getAdditionalValues().get(1).getValue();
        System.out.println("contentCommentsFromJson = " + contentCommentsFromJson);
        String contentCommentsFromEDI = decodedValuesInternational.get(50);
        System.out.println("contentCommentsFromEDI = " + contentCommentsFromEDI);
        assertThat(contentCommentsFromEDI, is(equalTo(contentCommentsFromJson)));

    }


    @DisplayName("JSON Body Request")
    @Test
    public void test72() {
        System.out.println("requestJsonBodyShipments = " + requestJsonBodyShipments);

    }


    @DisplayName("JSON Body Response")
    @Test
    public void test73() {
        validateResponseShipments.extract().response().prettyPrint();

    }


}
