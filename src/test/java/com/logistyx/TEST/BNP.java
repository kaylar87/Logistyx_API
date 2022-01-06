package com.logistyx.TEST;

import com.logistyx.utilities.BNPBaseVERSION2;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@DisplayName("1b - NL-NO,  weight 2 KG")
public class BNP extends BNPBaseVERSION2 {

    @DisplayName("1b - NL-NO,  weight 2 KG")
    @Test
    public void test1() {

        BNPBaseVERSION2.shipmentsLabel();

        /** "ShippingId is not NULL" */
        assertThat(bringParcelPojoShipments.getShipmentId(), is(notNullValue()));


        /** "ZPL ('Documents/0/Content') is not NULL" */
        assertThat(encodedStringFromPostmanShipments, is(notNullValue()));


        /** "ZPL size > 500 characters" */
        assertThat(encodedStringFromPostmanShipments.length(), is(greaterThan(500)));


        /** "PICKUP address details: Earl Bakkenstraat 7, NL-6422 PJ, HEERLEN" */
        String pickUpAddressName1FromJson = bringParcelPojoShipments.getAddresses().get(0).getAddressLines().get(0).getValue();
        int pickUpAddressName1FromLabelStart = decodedStringShipments.indexOf("^FT30,133^A0N,27,27^FD") + 22;
        String pickUpAddressName1FromLabel = decodedStringShipments.substring(pickUpAddressName1FromLabelStart, pickUpAddressName1FromLabelStart + pickUpAddressName1FromJson.length());
        assertThat(pickUpAddressName1FromJson, is(equalTo(pickUpAddressName1FromLabel)));
        String pickUpAddressName2FromJson = bringParcelPojoShipments.getAddresses().get(0).getCountryCode() + "-" + bringParcelPojoShipments.getAddresses().get(0).getPostalCode() + " " + bringParcelPojoShipments.getAddresses().get(0).getLocalityName();
        int pickUpAddressName2FromLabelStart = decodedStringShipments.indexOf("^FT30,162^A0N,30,30^FD") + 22;
        String pickUpAddressName2FromLabel = decodedStringShipments.substring(pickUpAddressName2FromLabelStart, pickUpAddressName2FromLabelStart + pickUpAddressName2FromJson.length());
        assertThat(pickUpAddressName2FromJson, is(equalTo(pickUpAddressName2FromLabel)));


        /** "DELIVERY address details: Grand Hotel Oslo, NO-0159, OSLO" */
        String deliveryAddressName1FromJson = bringParcelPojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue();
        int deliveryAddressName1FromLabelStart = decodedStringShipments.indexOf("^FT51,304^A0N,33,33^FD") + 22;
        String deliveryAddressName1FromLabel = decodedStringShipments.substring(deliveryAddressName1FromLabelStart, deliveryAddressName1FromLabelStart + deliveryAddressName1FromJson.length());
        assertThat(deliveryAddressName1FromJson, is(equalTo(deliveryAddressName1FromLabel)));
        String deliveryAddressName2FromJson = bringParcelPojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue();
        int deliveryAddressName2FromLabelStart = decodedStringShipments.indexOf("^FT51,337^A0N,33,33^FD") + 22;
        String deliveryAddressName2FromLabel = decodedStringShipments.substring(deliveryAddressName2FromLabelStart, deliveryAddressName2FromLabelStart + deliveryAddressName2FromJson.length());
        assertThat(deliveryAddressName2FromJson, is(equalTo(deliveryAddressName2FromLabel)));
        String deliveryAddressName3FromJson = bringParcelPojoShipments.getDeliveryAddress().getCountryCode() + "-" + bringParcelPojoShipments.getDeliveryAddress().getPostalCode() + " " + bringParcelPojoShipments.getDeliveryAddress().getLocalityName();
        int deliveryAddressName3FromLabelStart = decodedStringShipments.indexOf("^FT51,380^A0N,46,46^FD") + 22;
        String deliveryAddressName3FromLabel = decodedStringShipments.substring(deliveryAddressName3FromLabelStart, deliveryAddressName3FromLabelStart + deliveryAddressName3FromJson.length());
        assertThat(deliveryAddressName3FromJson, is(equalTo(deliveryAddressName3FromLabel)));


        /** "Delivery person details: DY.Contact Name" */
        String deliveryPersonDetailsFromJson = bringParcelPojoShipments.getDeliveryAddress().getContacts().get(0).getName();
        int deliveryPersonDetailsFromLabelStart = decodedStringShipments.indexOf("^FT51,272^A0N,33,33^FD") + 22;
        String deliveryPersonDetailsFromLabel = decodedStringShipments.substring(deliveryPersonDetailsFromLabelStart, deliveryPersonDetailsFromLabelStart + deliveryPersonDetailsFromJson.length());
        assertThat(deliveryPersonDetailsFromJson, is(equalTo(deliveryPersonDetailsFromLabel)));


        /** "Delivery phone number: +(06)2-222222" */
        String deliveryPhoneNumberFromJson = bringParcelPojoShipments.getDeliveryAddress().getContacts().get(0).getPhoneNumber();
        int deliveryPhoneNumberFromLabelStart = decodedStringShipments.indexOf("^FT559,423^A0N,27,27^FD") + 23;
        String deliveryPhoneNumberFromLabel = decodedStringShipments.substring(deliveryPhoneNumberFromLabelStart, deliveryPhoneNumberFromLabelStart + deliveryPhoneNumberFromJson.length());
        assertThat(deliveryPhoneNumberFromJson, is(equalTo(deliveryPhoneNumberFromLabel)));


        /** "Ship date (format: dd.MM.yyyy): 06.10.2020" */
        String shipDateFromJson = bringParcelPojoShipments.getRequestedPickupDateTime().substring(0, 10);
        String shipDayFromJson = shipDateFromJson.substring(8);
        String shipMonthFromJson = shipDateFromJson.substring(5, 7);
        String shipYearFromJson = shipDateFromJson.substring(0, 4);
        String shipDateFromJsonFormat = shipDayFromJson + "." + shipMonthFromJson + "." + shipYearFromJson;
        int shipDateFromLabelStart = decodedStringShipments.indexOf("^FT559,246^A0N,27,27^FD") + 23;
        String shipDateFromLabel = decodedStringShipments.substring(shipDateFromLabelStart, shipDateFromLabelStart + 10);
        assertThat(shipDateFromJsonFormat, is(equalTo(shipDateFromLabel)));


        /** "Service (BNP-BUS-PRCL) on the label, destination country = NO, product = Bring Parcel Business Parcel, product code = 0330 and handling code = 2" */
        String productIdFromLabel = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT169,988^A0N,54,54^FD") + 23, decodedStringShipments.indexOf("^FT169,988^A0N,54,54^FD") + 23 + 4);
        String productFromJson = bringParcelPojoShipments.getForwarderDivisionService().getName();
        String productFromLabel = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT169,892^A0N,35,35^FD") + 23, decodedStringShipments.indexOf("^FT169,892^A0N,35,35^FD") + 23 + productFromJson.length());
        String deliveryCountryCodeFromJson = bringParcelPojoShipments.getDeliveryAddress().getCountryCode();
        String handlingCodeFromLabel = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT691,982^A0N,128,128^FD") + 25, decodedStringShipments.indexOf("^FT691,982^A0N,128,128^FD") + 26);
        String weightFromLabel = decodedStringShipments.substring(decodedStringShipments.indexOf("^FT620,500^A0N,27,27^FD") + 23, decodedStringShipments.indexOf("^FT620,500^A0N,27,27^FD") + 26);
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


        /** "Unique Shipment Identity, 12345670000019437" */
        String shipmentIdFromJson = bringParcelPojoShipments.getForwarderRef();
        int shipmentIdFromLabelStart = decodedStringShipments.indexOf("^FT30,567^A0N,27,27^FD") + 22;
        String shipmentIdFromLabel = decodedStringShipments.substring(shipmentIdFromLabelStart, shipmentIdFromLabelStart + shipmentIdFromJson.length());
        assertThat(shipmentIdFromJson, is(equalTo(shipmentIdFromLabel)));

        /** "(Hard-coded) Customer ID check, 12BAC3DE" */
        int customerNoFromLabelStart = decodedStringShipments.indexOf("^FT620,560^A0N,27,27^FD") + 23;
        String customerNoFromLabel = decodedStringShipments.substring(customerNoFromLabelStart, customerNoFromLabelStart + 8);
        assertThat(customerNoFromLabel, is(equalTo("12BAC3DE")));


        /** "Bring LOGO" */
        String bringLogoFromLabel = "^FO35,854^GFA,630,1596,12,:Z64:eJytlU1qAzEMhW20";
        assertThat(decodedStringShipments, containsString(bringLogoFromLabel));

        /** "Unique Shipment Identity, 12345670000019437" */

        /** "Unique Shipment Identity, 12345670000019437" */

        /** "Unique Shipment Identity, 12345670000019437" */

        /** "Unique Shipment Identity, 12345670000019437" */


    }


}
