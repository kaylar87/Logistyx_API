package com.logistyx.TEST.OSM.Services;


import com.logistyx.utilities.AbstractBaseClasses.OSM.Services.OSMBaseBoundPrintedMatterNotDG;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Bound_Printed_Matter extends OSMBaseBoundPrintedMatterNotDG {

    static {

        OSMBaseBoundPrintedMatterNotDG.shipmentsLabel();

    }


    @DisplayName("ShippingId is not NULL")
    @Test
    public void test1() {


        assertThat(osmPojoShipments.getShipmentId(), is(notNullValue()));
        //    validateResponseShipments.extract().response().prettyPrint();
        //    System.out.println("decodedStringShipments = " + decodedStringShipments);
        //    System.out.println("decodedStringConveyances = " + decodedStringConveyances);

    }


    @DisplayName("ZPL Label is not NULL")
    @Test
    public void test2() {

        assertThat(encodedStringFromPostmanShipments, is(notNullValue()));

    }


    @DisplayName("ZPL Label size > 500 characters")
    @Test
    public void test3() {

        assertThat(encodedStringFromPostmanShipments.length(), is(greaterThan(500)));

    }

    @DisplayName("ZPL Carrier service A - 'CI'")
    @Test
    public void test4() {

        //    System.out.println("sortCode1 = " + sortCode1);
        int carrierServiceAFromLabelStart = decodedStringShipments.indexOf("^FT83,73^A0N,43,74^FD") + 21;
        String carrierServiceAFromLabel = decodedStringShipments.substring(carrierServiceAFromLabelStart, carrierServiceAFromLabelStart + sortCode1.length());
        //    System.out.println("carrierServiceAFromLabel = " + carrierServiceAFromLabel);
        assertThat(sortCode1, is(equalTo(carrierServiceAFromLabel)));

    }


    @DisplayName("ZPL Carrier service B - '20'")
    @Test
    public void test5() {

        //    System.out.println("sortCode2 = " + sortCode2);
        int sc2 = (int) Double.parseDouble(sortCode2);
        //    System.out.println("sc2 = " + sc2);
        int carrierServiceBFromLabelStart = decodedStringShipments.indexOf("^FT235,73^A0N,43,74^FD") + 22;
        String carrierServiceBFromLabel = decodedStringShipments.substring(carrierServiceBFromLabelStart, carrierServiceBFromLabelStart + String.valueOf(sc2).length());
        //    System.out.println("carrierServiceBFromLabel = " + carrierServiceBFromLabel);
        assertThat(String.valueOf(sc2), is(equalTo(carrierServiceBFromLabel)));

    }


    @DisplayName("ZPL Carrier service C - 'BP'")
    @Test
    public void test6() {

        String carrierServiceCFromJsonConverted = carrierServiceMCValueFromJsonMap.get(carrierServiceFromJson);
        //    System.out.println("carrierServiceCFromJsonConverted = " + carrierServiceCFromJsonConverted);
        int carrierServiceCFromLabelStart = decodedStringShipments.indexOf("^FT79,115^A0N,33,59^FD") + 22;
        String carrierServiceCFromLabel = decodedStringShipments.substring(carrierServiceCFromLabelStart, carrierServiceCFromLabelStart + carrierServiceCFromJsonConverted.length());
        //    System.out.println("carrierServiceCFromLabel = " + carrierServiceCFromLabel);
        assertThat(carrierServiceCFromJsonConverted, is(equalTo(carrierServiceCFromLabel)));

    }


    @DisplayName("ZPL Carrier service D - 'V23'")
    @Test
    public void test7() {

        //    System.out.println("sortCode4 = " + sortCode4);
        int carrierServiceDFromLabelStart = decodedStringShipments.indexOf("^FT227,115^A0N,33,59^FD") + 23;
        String carrierServiceDFromLabel = decodedStringShipments.substring(carrierServiceDFromLabelStart, carrierServiceDFromLabelStart + sortCode4.length());
        //    System.out.println("carrierServiceDFromLabel = " + carrierServiceDFromLabel);
        assertThat(sortCode4, is(equalTo(carrierServiceDFromLabel)));

    }


    @DisplayName("ZPL Carrier service E1 - 'PRSRT BPM'")
    @Test
    public void test8() {

        String carrierServiceE1FromJsonConverted = carrierServiceE1ValueFromJsonMap.get(carrierServiceFromJson);
        //    System.out.println("carrierServiceE1FromJsonConverted = " + carrierServiceE1FromJsonConverted);
        int carrierServiceE1FromLabelStart = decodedStringShipments.indexOf("^FT437,65^A0N,27,27^FD") + 22;
        String carrierServiceE1FromLabel = decodedStringShipments.substring(carrierServiceE1FromLabelStart, carrierServiceE1FromLabelStart + carrierServiceE1FromJsonConverted.length());
        //    System.out.println("carrierServiceE1FromLabel = " + carrierServiceE1FromLabel);
        assertThat(carrierServiceE1FromJsonConverted, is(equalTo(carrierServiceE1FromLabel)));

    }


    @DisplayName("ZPL Carrier service E2 - 'U.S POSTAGE AND FEES PAID'")
    @Test
    public void test9() {

        String carrierServiceE2FromJsonConverted = carrierServiceE2ValueFromJsonMap.get(carrierServiceFromJson);
        //    System.out.println("carrierServiceE2FromJsonConverted = " + carrierServiceE2FromJsonConverted);
        int carrierServiceE2FromLabelStart = decodedStringShipments.indexOf("^FT437,97^A0N,27,27^FD") + 22;
        String carrierServiceE2FromLabel = decodedStringShipments.substring(carrierServiceE2FromLabelStart, carrierServiceE2FromLabelStart + carrierServiceE2FromJsonConverted.length());
        //    System.out.println("carrierServiceE2FromLabel = " + carrierServiceE2FromLabel);
        assertThat(carrierServiceE2FromJsonConverted, is(equalTo(carrierServiceE2FromLabel)));

    }


    @DisplayName("ZPL Carrier service E3 - 'OSM'")
    @Test
    public void test10() {

        String carrierServiceE3Hardcoded = "OSM";
        //    System.out.println("carrierServiceE3Hardcoded = " + carrierServiceE3Hardcoded);
        int carrierServiceE3FromLabelStart = decodedStringShipments.indexOf("^FT437,130^A0N,27,27^FD") + 23;
        String carrierServiceE3FromLabel = decodedStringShipments.substring(carrierServiceE3FromLabelStart, carrierServiceE3FromLabelStart + carrierServiceE3Hardcoded.length());
        //    System.out.println("carrierServiceE3FromLabel = " + carrierServiceE3FromLabel);
        assertThat(carrierServiceE3Hardcoded, is(equalTo(carrierServiceE3FromLabel)));

    }


    @DisplayName("ZPL Carrier service E4 - 'E-VS'")
    @Test
    public void test11() {

        String carrierServiceE4Hardcoded = "E-VS";
        //    System.out.println("carrierServiceE4Hardcoded = " + carrierServiceE4Hardcoded);
        int carrierServiceE4FromLabelStart = decodedStringShipments.indexOf("^FT437,163^A0N,27,27^FD") + 23;
        String carrierServiceE4FromLabel = decodedStringShipments.substring(carrierServiceE4FromLabelStart, carrierServiceE4FromLabelStart + carrierServiceE4Hardcoded.length());
        //    System.out.println("carrierServiceE4FromLabel = " + carrierServiceE4FromLabel);
        assertThat(carrierServiceE4Hardcoded, is(equalTo(carrierServiceE4FromLabel)));

    }


    @DisplayName("ZPL Carrier service F1 - 'GEN_BERLIN'")
    @Test
    public void test12() {

        String carrierServiceF1FromJson = osmPojoShipments.getPickupAddress().getReference();
        //    System.out.println("carrierServiceF1FromJson = " + carrierServiceF1FromJson);
        int carrierServiceF1FromLabelStart = decodedStringShipments.indexOf("^FT35,337^A0N,27,27^FH^FD") + 25;
        String carrierServiceF1FromLabel = (decodedStringShipments.substring(carrierServiceF1FromLabelStart, carrierServiceF1FromLabelStart + carrierServiceF1FromJson.length() + 2)).replace("5F", "");
        //    System.out.println("carrierServiceF1FromLabel = " + carrierServiceF1FromLabel);
        assertThat(carrierServiceF1FromJson, is(equalTo(carrierServiceF1FromLabel)));

    }


    @DisplayName("ZPL Carrier service F2 - '745 E KNOPF RD'")
    @Test
    public void test13() {

        String carrierServiceF2FromJson = ((String) osmPojoShipments.getPickupAddress().getAddressLines().get(0).getValue()).toUpperCase();
        //    System.out.println("carrierServiceF2FromJson = " + carrierServiceF2FromJson);
        int carrierServiceF2FromLabelStart = decodedStringShipments.indexOf("^FT35,369^A0N,27,27^FD") + 22;
        String carrierServiceF2FromLabel = decodedStringShipments.substring(carrierServiceF2FromLabelStart, carrierServiceF2FromLabelStart + carrierServiceF2FromJson.length());
        //    System.out.println("carrierServiceF2FromLabel = " + carrierServiceF2FromLabel);
        assertThat(carrierServiceF2FromJson, is(equalTo(carrierServiceF2FromLabel)));

    }


    @DisplayName("ZPL Carrier service F3 - 'BERLIN, WI 54923'")
    @Test
    public void test14() {

        String carrierServiceF3FromJson = (osmPojoShipments.getPickupAddress().getLocalityName()).toUpperCase() + ", " + osmPojoShipments.getPickupAddress().getSubdivisionCode() + " " + osmPojoShipments.getPickupAddress().getPostalCode();
        //    System.out.println("carrierServiceF3FromJson = " + carrierServiceF3FromJson);
        int carrierServiceF3FromLabelStart = decodedStringShipments.indexOf("^FT35,402^A0N,27,27^FD") + 22;
        String carrierServiceF3FromLabel = decodedStringShipments.substring(carrierServiceF3FromLabelStart, carrierServiceF3FromLabelStart + carrierServiceF3FromJson.length());
        //    System.out.println("carrierServiceF3FromLabel = " + carrierServiceF3FromLabel);
        assertThat(carrierServiceF3FromJson, is(equalTo(carrierServiceF3FromLabel)));

    }


    @DisplayName("ZPL Carrier service G1 - 'LOWE'S COMPANIES, INC.'")
    @Test
    public void test15() {

        String carrierServiceG1FromJson = osmPojoShipments.getDeliveryAddress().getReference();
        //    System.out.println("carrierServiceG1FromJson = " + carrierServiceG1FromJson);
        int carrierServiceG1FromLabelStart = decodedStringShipments.indexOf("^FT81,536^A0N,35,35^FD") + 22;
        String carrierServiceG1FromLabel = decodedStringShipments.substring(carrierServiceG1FromLabelStart, carrierServiceG1FromLabelStart + carrierServiceG1FromJson.length());
        //   System.out.println("carrierServiceG1FromLabel = " + carrierServiceG1FromLabel);
        assertThat(carrierServiceG1FromJson, is(equalTo(carrierServiceG1FromLabel)));

    }


    @DisplayName("ZPL Carrier service G2 - 'LOWE'S COMPANIES, INC.'")
    @Test
    public void test16() {

        String carrierServiceG2FromJson = osmPojoShipments.getDeliveryAddress().getContacts().get(0).getName();
        //    System.out.println("carrierServiceG2FromJson = " + carrierServiceG2FromJson);
        int carrierServiceG2FromLabelStart = decodedStringShipments.indexOf("^FT81,579^A0N,35,35^FD") + 22;
        String carrierServiceG2FromLabel = decodedStringShipments.substring(carrierServiceG2FromLabelStart, carrierServiceG2FromLabelStart + carrierServiceG2FromJson.length());
        //    System.out.println("carrierServiceG2FromLabel = " + carrierServiceG2FromLabel);
        assertThat(carrierServiceG2FromJson, is(equalTo(carrierServiceG2FromLabel)));

    }


    @DisplayName("ZPL Carrier service G3 - '15 MAIN ST'")
    @Test
    public void test17() {

        String carrierServiceG3FromJson = (osmPojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue()).toUpperCase();
        //    System.out.println("carrierServiceG3FromJson = " + carrierServiceG3FromJson);
        int carrierServiceG3FromLabelStart = decodedStringShipments.indexOf("^FT81,621^A0N,35,35^FD") + 22;
        String carrierServiceG3FromLabel = decodedStringShipments.substring(carrierServiceG3FromLabelStart, carrierServiceG3FromLabelStart + carrierServiceG3FromJson.length());
        //    System.out.println("carrierServiceG3FromLabel = " + carrierServiceG3FromLabel);
        assertThat(carrierServiceG3FromJson, is(equalTo(carrierServiceG3FromLabel)));

    }


    @DisplayName("ZPL Carrier service G4 - 'EDGERTON, WI 53534'")
    @Test
    public void test18() {

        String carrierServiceG4FromJson = (osmPojoShipments.getDeliveryAddress().getLocalityName()).toUpperCase() + ", " + osmPojoShipments.getDeliveryAddress().getSubdivisionCode() + " " + osmPojoShipments.getDeliveryAddress().getPostalCode();
        //    System.out.println("carrierServiceG4FromJson = " + carrierServiceG4FromJson);
        int carrierServiceG4FromLabelStart = decodedStringShipments.indexOf("^FT81,663^A0N,35,35^FD") + 22;
        String carrierServiceG4FromLabel = decodedStringShipments.substring(carrierServiceG4FromLabelStart, carrierServiceG4FromLabelStart + carrierServiceG4FromJson.length());
        //   System.out.println("carrierServiceG4FromLabel = " + carrierServiceG4FromLabel);
        assertThat(carrierServiceG4FromJson, is(equalTo(carrierServiceG4FromLabel)));

    }


    @DisplayName("ZPL Carrier service H1 - 'Shipper Reference'")
    @Test
    public void test19() {

        String carrierServiceH1FromJson = osmPojoShipments.getShipperRef();
        //    System.out.println("carrierServiceH1FromJson = " + carrierServiceH1FromJson);
        int carrierServiceH1FromLabelStart = decodedStringShipments.indexOf("^FT35,783^A0N,22,22^FDRef1#: ") + 29;
        String carrierServiceH1FromLabel = decodedStringShipments.substring(carrierServiceH1FromLabelStart, carrierServiceH1FromLabelStart + carrierServiceH1FromJson.length());
        //   System.out.println("carrierServiceH1FromLabel = " + carrierServiceH1FromLabel);
        assertThat(carrierServiceH1FromJson, is(equalTo(carrierServiceH1FromLabel)));

    }


    @DisplayName("ZPL Carrier service H2 - 'Receiver Reference'")
    @Test
    public void test20() {

        String carrierServiceH2FromJson = (String) osmPojoShipments.getReceiverRef();
        //    System.out.println("carrierServiceH2FromJson = " + carrierServiceH2FromJson);
        int carrierServiceH2FromLabelStart = decodedStringShipments.indexOf("^FT35,809^A0N,22,22^FDRef2#: ") + 29;
        String carrierServiceH2FromLabel = decodedStringShipments.substring(carrierServiceH2FromLabelStart, carrierServiceH2FromLabelStart + carrierServiceH2FromJson.length());
        //   System.out.println("carrierServiceH2FromLabel = " + carrierServiceH2FromLabel);
        assertThat(carrierServiceH2FromJson, is(equalTo(carrierServiceH2FromLabel)));

    }


    @DisplayName("ZPL Carrier service I - 'USPS TRACKING #'")
    @Test
    public void test21() {

        String carrierServiceIHardcoded = "USPS TRACKING #";
        //    System.out.println("carrierServiceIHardcoded = " + carrierServiceIHardcoded);
        int carrierServiceIFromLabelStart = decodedStringShipments.indexOf("^FT286,898^A0N,33,33^FD") + 23;
        String carrierServiceIFromLabel = decodedStringShipments.substring(carrierServiceIFromLabelStart, carrierServiceIFromLabelStart + carrierServiceIHardcoded.length());
        //    System.out.println("carrierServiceIFromLabel = " + carrierServiceIFromLabel);
        assertThat(carrierServiceIHardcoded, is(equalTo(carrierServiceIFromLabel)));

    }


    @DisplayName("ZPL Carrier service J - '420535349205520220307000005826'")
    @Test
    public void test22() {

        String carrierServiceJFromJson = "420" + osmPojoShipments.getDeliveryAddress().getPostalCode() + "92" + carrierServiceSTCValueFromJsonMap.get(carrierServiceFromJson) + osmPojoShipments.getPickupForwarderDivisionAccountCode() + osmPojoShipments.getShippingUnits().get(0).getForwarderRef().substring(22, 29) + checkDigit;
        //    System.out.println("carrierServiceJFromJson = " + carrierServiceJFromJson);
        int carrierServiceJFromLabelStart = decodedStringShipments.indexOf("^FO106,935^BCN,142,N^FD>;") + 25;
        String carrierServiceJFromLabel = decodedStringShipments.substring(carrierServiceJFromLabelStart, carrierServiceJFromLabelStart + carrierServiceJFromJson.length());
        //    System.out.println("carrierServiceJFromLabel = " + carrierServiceJFromLabel);
        assertThat(carrierServiceJFromJson, is(equalTo(carrierServiceJFromLabel)));

    }


    @DisplayName("ZPL Carrier service K - '9205 5202 2030 7000 0058 26'")
    @Test
    public void test23() {

        String carrierServiceKFromJson = "92" + carrierServiceSTCValueFromJsonMap.get(carrierServiceFromJson) + osmPojoShipments.getPickupForwarderDivisionAccountCode() + osmPojoShipments.getShippingUnits().get(0).getForwarderRef().substring(22, 29) + checkDigit;
        //    System.out.println("carrierServiceKFromJson = " + carrierServiceKFromJson);
        int carrierServiceKFromLabelStart = decodedStringShipments.indexOf("^FT218,1143^A0N,33,33^FD") + 24;
        String carrierServiceKFromLabel = decodedStringShipments.substring(carrierServiceKFromLabelStart, carrierServiceKFromLabelStart + carrierServiceKFromJson.length() + 5);
        //    System.out.println("carrierServiceKFromLabel = " + carrierServiceKFromLabel);
        assertThat(carrierServiceKFromJson, is(equalTo(carrierServiceKFromLabel.replace(" ", ""))));

    }


    @DisplayName("EDI - Package Id - '9241920220307000007615'")
    @Test
    public void test24() {

        String packageIdFromJson = osmPojoShipments.getShippingUnits().get(0).getForwarderRef().substring(8);
        //    System.out.println("packageIdFromJson = " + packageIdFromJson);
        String packageIdFromEDI = decodedValuesDomestic.get(0).replace("\"", "");
        //    System.out.println("packageIdFromEDI = " + packageIdFromEDI);
        assertThat(packageIdFromEDI, is(equalTo(packageIdFromJson)));

    }


    @DisplayName("EDI - Company - 'LOWE'S COMPANIES INC.'")
    @Test
    public void test25() {

        String companyFromJson = osmPojoShipments.getDeliveryAddress().getReference();
        //    System.out.println("companyFromJson = " + companyFromJson);
        String companyFromEDI = decodedValuesDomestic.get(1);
        //    System.out.println("companyFromEDI = " + companyFromEDI);
        assertThat(companyFromEDI, is(equalTo(companyFromJson)));

    }


    @DisplayName("EDI - Full Name - 'LOWE'S COMPANIES INC.'")
    @Test
    public void test26() {

        String fullNameFromJson = osmPojoShipments.getDeliveryAddress().getContacts().get(0).getName();
        //    System.out.println("fullNameFromJson = " + fullNameFromJson);
        String fullNameFromEDI = decodedValuesDomestic.get(2);
        //    System.out.println("fullNameFromEDI = " + fullNameFromEDI);
        assertThat(fullNameFromEDI, is(equalTo(fullNameFromJson)));

    }


    @DisplayName("EDI - Address 1 - '15 Main St'")
    @Test
    public void test27() {

        String address1FromJson = osmPojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue();
        //    System.out.println("address1FromJson = " + address1FromJson);
        String address1FromEDI = decodedValuesDomestic.get(3);
        //    System.out.println("address1FromEDI = " + address1FromEDI);
        assertThat(address1FromEDI, is(equalTo(address1FromJson)));

    }


    @DisplayName("EDI - Address 2 - ''")
    @Test
    public void test28() {

        if (osmPojoShipments.getDeliveryAddress().getAddressLines().size() == 2) {
            String address2FromJson = osmPojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue();
            //    System.out.println("address2FromJson = " + address2FromJson);
            String address2FromEDI = decodedValuesDomestic.get(4);
            //    System.out.println("address2FromEDI = " + address2FromEDI);
            assertThat(address2FromEDI, is(equalTo(address2FromJson)));
        }

    }


    @DisplayName("EDI - City - 'Edgerton'")
    @Test
    public void test29() {

        String cityFromJson = osmPojoShipments.getDeliveryAddress().getLocalityName();
        //    System.out.println("cityFromJson = " + cityFromJson);
        String cityFromEDI = decodedValuesDomestic.get(5);
        //    System.out.println("cityFromEDI = " + cityFromEDI);
        assertThat(cityFromEDI, is(equalTo(cityFromJson)));

    }


    @DisplayName("EDI - State - 'WI'")
    @Test
    public void test30() {

        String stateFromJson = osmPojoShipments.getDeliveryAddress().getSubdivisionCode();
        //    System.out.println("stateFromJson = " + stateFromJson);
        String stateFromEDI = decodedValuesDomestic.get(6);
        //    System.out.println("stateFromEDI = " + stateFromEDI);
        assertThat(stateFromEDI, is(equalTo(stateFromJson)));

    }


    @DisplayName("EDI - Zip - '53534'")
    @Test
    public void test31() {

        String zipFromJson = osmPojoShipments.getDeliveryAddress().getPostalCode();
        //    System.out.println("zipFromJson = " + zipFromJson);
        String zipFromEDI = decodedValuesDomestic.get(7);
        //    System.out.println("zipFromEDI = " + zipFromEDI);
        assertThat(zipFromEDI, is(equalTo(zipFromJson)));

    }


    @DisplayName("EDI - Country - 'US'")
    @Test
    public void test32() {

        String countryFromJson = osmPojoShipments.getDeliveryAddress().getCountryCode();
        //    System.out.println("countryFromJson = " + countryFromJson);
        String countryFromEDI = decodedValuesDomestic.get(8);
        //    System.out.println("countryFromEDI = " + countryFromEDI);
        assertThat(countryFromEDI, is(equalTo(countryFromJson)));

    }


    @DisplayName("EDI - Cost Center Id - ''")
    @Test
    public void test33() {

        String costCenterIdFromEDI = decodedValuesDomestic.get(9);
        //    System.out.println("costCenterIdFromEDI = " + costCenterIdFromEDI);
        assertThat(costCenterIdFromEDI, is(equalTo("")));

    }


    @DisplayName("EDI - Reference 1 - 'Shipper Reference'")
    @Test
    public void test34() {

        String reference1FromJson = osmPojoShipments.getShipperRef();
        //    System.out.println("reference1FromJson = " + reference1FromJson);
        String reference1FromEDI = decodedValuesDomestic.get(10);
        //    System.out.println("reference1FromEDI = " + reference1FromEDI);
        assertThat(reference1FromEDI, is(equalTo(reference1FromJson)));

    }


    @DisplayName("EDI - Reference 2 - 'Receiver Reference'")
    @Test
    public void test35() {

        String reference2FromJson = (String) osmPojoShipments.getReceiverRef();
        //   System.out.println("reference2FromJson = " + reference2FromJson);
        String reference2FromEDI = decodedValuesDomestic.get(11);
        //    System.out.println("reference2FromEDI = " + reference2FromEDI);
        assertThat(reference2FromEDI, is(equalTo(reference2FromJson)));

    }


    @DisplayName("EDI - Reference 3 - ''")
    @Test
    public void test36() {

        String reference3FromEDI = decodedValuesDomestic.get(12);
        //    System.out.println("reference3FromEDI = " + reference3FromEDI);
        assertThat(reference3FromEDI, is(equalTo("")));

    }


    @DisplayName("EDI - Reference 4 - ''")
    @Test
    public void test37() {

        String reference4FromEDI = decodedValuesDomestic.get(13);
        //    System.out.println("reference4FromEDI = " + reference4FromEDI);
        assertThat(reference4FromEDI, is(equalTo("")));

    }


    @DisplayName("EDI - Weight - '5.86'")
    @Test
    public void test38() {

        String weightFromJson = String.valueOf(osmPojoShipments.getShippingUnits().get(0).getGrossWeight());
        //    System.out.println("weightFromJson = " + weightFromJson);
        String weightFromEDI = decodedValuesDomestic.get(14);
        //    System.out.println("weightFromEDI = " + weightFromEDI);
        assertThat(weightFromEDI, is(equalTo(weightFromJson)));

    }


    @DisplayName("EDI - Mail Class - 'BP'")
    @Test
    public void test39() {

        String mailClassFromJson = carrierServiceMCValueFromJsonMap.get(carrierServiceFromJson);
        //    System.out.println("mailClassFromJson = " + mailClassFromJson);
        String mailClassFromEDI = decodedValuesDomestic.get(15);
        //    System.out.println("mailClassFromEDI = " + mailClassFromEDI);
        assertThat(mailClassFromEDI, is(equalTo(mailClassFromJson)));

    }


    @DisplayName("EDI - Hazardous - '0'")
    @Test
    public void test40() {
        String hazardousFromJson;
        if (osmPojoShipments.getShippingUnits().get(0).getDangerousGoods().size() == 0 & osmPojoShipments.getShippingUnits().get(0).getShippingUnitItems().get(0).getDangerousGoods().size() == 0) {
            hazardousFromJson = "0";
        } else {
            hazardousFromJson = "1";
        }
        //    System.out.println("hazardousFromJson = " + hazardousFromJson);
        String hazardousFromEDI = decodedValuesDomestic.get(16);
        //    System.out.println("hazardousFromEDI = " + hazardousFromEDI);
        assertThat(hazardousFromEDI, is(equalTo(hazardousFromJson)));

    }


    @DisplayName("EDI - SoftPack - ''")
    @Test
    public void test41() {

        String softPackFromEDI = decodedValuesDomestic.get(17);
        //    System.out.println("softPackFromEDI = " + softPackFromEDI);
        assertThat(softPackFromEDI, is(equalTo("")));

    }


    @DisplayName("EDI - OSM BOL - ''")
    @Test
    public void test42() {

        String osmBolFromEDI = decodedValuesDomestic.get(18);
        //    System.out.println("osmBolFromEDI = " + osmBolFromEDI);
        assertThat(osmBolFromEDI.replace("\"", ""), is(equalTo("")));

    }


    @DisplayName("JSON Body Request")
    @Test
    public void test43() {
        System.out.println("requestJsonBodyShipments = " + requestJsonBodyShipments);

    }


    @DisplayName("JSON Body Response")
    @Test
    public void test44() {
        validateResponseShipments.extract().response().prettyPrint();

    }


}
