package com.logistyx.TEST;


import com.logistyx.utilities.FedExFuseBaseNotDG;
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


    @DisplayName("ZPL: Delivery Address")
    @Test
    public void test4() {

        assertThat(decodedStringShipments, containsString("^FT4,204^A0N,14,14^FDTO^FS"));

        String deliveryAddressName1FromJson = fedExFusePojoShipments.getAddresses().get(0).getContacts().get(0).getName().toUpperCase();
        //System.out.println("deliveryAddressName1FromJson = " + deliveryAddressName1FromJson);
        int deliveryAddressName1FromLabelStart = decodedStringShipments.indexOf("^FT22,215^A0N,27,27^FD") + 22;
        String deliveryAddressName1FromLabel = decodedStringShipments.substring(deliveryAddressName1FromLabelStart, deliveryAddressName1FromLabelStart + deliveryAddressName1FromJson.length());
        //System.out.println("deliveryAddressName1FromLabel = " + deliveryAddressName1FromLabel);
        assertThat(deliveryAddressName1FromJson, is(equalTo(deliveryAddressName1FromLabel)));

        String deliveryAddressName2FromJson = fedExFusePojoShipments.getDeliveryAddress().getAddressLines().get(0).getValue();
        //System.out.println("deliveryAddressName2FromJson = " + deliveryAddressName2FromJson);
        int deliveryAddressName2FromLabelStart = decodedStringShipments.indexOf("^FT22,242^A0N,27,27^FD") + 22;
        String deliveryAddressName2FromLabel = decodedStringShipments.substring(deliveryAddressName2FromLabelStart, deliveryAddressName2FromLabelStart + deliveryAddressName2FromJson.length());
        //System.out.println("deliveryAddressName2FromLabel = " + deliveryAddressName2FromLabel);
        assertThat(deliveryAddressName2FromJson, is(equalTo(deliveryAddressName2FromLabel)));

        String deliveryAddressName3FromJson = fedExFusePojoShipments.getDeliveryAddress().getAddressLines().get(1).getValue();
        //System.out.println("deliveryAddressName3FromJson = " + deliveryAddressName3FromJson);
        int deliveryAddressName3FromLabelStart = decodedStringShipments.indexOf("^FT22,269^A0N,27,27^FD") + 22;
        String deliveryAddressName3FromLabel = decodedStringShipments.substring(deliveryAddressName3FromLabelStart, deliveryAddressName3FromLabelStart + deliveryAddressName3FromJson.length());
        //System.out.println("deliveryAddressName3FromLabel = " + deliveryAddressName3FromLabel);
        assertThat(deliveryAddressName3FromJson, is(equalTo(deliveryAddressName3FromLabel)));

        String deliveryAddressName4FromJson = fedExFusePojoShipments.getDeliveryAddress().getLocalityName().toUpperCase() + ", " + fedExFusePojoShipments.getDeliveryAddress().getSubdivisionCode() + " " + fedExFusePojoShipments.getDeliveryAddress().getPostalCode();
        //System.out.println("deliveryAddressName4FromJson = " + deliveryAddressName4FromJson);
        int deliveryAddressName4FromLabelStart = decodedStringShipments.indexOf("^FT22,333^A0N,27,27^FD") + 22;
        String deliveryAddressName4FromLabel = decodedStringShipments.substring(deliveryAddressName4FromLabelStart, deliveryAddressName4FromLabelStart + deliveryAddressName4FromJson.length());
        //System.out.println("deliveryAddressName4FromLabel = " + deliveryAddressName4FromLabel);
        assertThat(deliveryAddressName4FromJson, is(equalTo(deliveryAddressName4FromLabel)));

    }


    @DisplayName("ZPL: Service: FFG-HOME")
    @Test
    public void test5() {

        assertThat(decodedStringShipments, containsString("^FT664,606^A0N,87,87^FDH^FS"));

        String forwarderDivisionServiceName1FromJson = fedExFusePojoShipments.getForwarderDivisionService().getName().substring(0, 5);
        //System.out.println("forwarderDivisionServiceName1FromJson = " + forwarderDivisionServiceName1FromJson);
        int forwarderDivisionServiceName1FromLabelStart = decodedStringShipments.indexOf("^FT650,492^A0N,43,43^FD") + 23;
        String forwarderDivisionServiceName1FromLabel = decodedStringShipments.substring(forwarderDivisionServiceName1FromLabelStart, forwarderDivisionServiceName1FromLabelStart + forwarderDivisionServiceName1FromJson.length());
        //System.out.println("forwarderDivisionServiceName1FromLabel = " + forwarderDivisionServiceName1FromLabel);
        assertThat(forwarderDivisionServiceName1FromJson, is(equalTo(forwarderDivisionServiceName1FromLabel)));

        String forwarderDivisionServiceName2FromJson = fedExFusePojoShipments.getForwarderDivisionService().getName().substring(6, 19);
        //System.out.println("forwarderDivisionServiceName2FromJson = " + forwarderDivisionServiceName2FromJson);
        int forwarderDivisionServiceName2FromLabelStart = decodedStringShipments.indexOf("^FT650,515^A0N,22,18^FD") + 23;
        String forwarderDivisionServiceName2FromLabel = decodedStringShipments.substring(forwarderDivisionServiceName2FromLabelStart, forwarderDivisionServiceName2FromLabelStart + forwarderDivisionServiceName2FromJson.length());
        //System.out.println("forwarderDivisionServiceName2FromLabel = " + forwarderDivisionServiceName2FromLabel);
        assertThat(forwarderDivisionServiceName2FromJson, is(equalTo(forwarderDivisionServiceName2FromLabel)));

    }


    @DisplayName("Package Size (L x W x H)")
    @Test
    public void test6() {

        int lengthRoundedFromJson = (int) ((fedExFusePojoShipments.getShippingUnits().get(0).getLength()) * 1);
        int widthRoundedFromJson = (int) ((fedExFusePojoShipments.getShippingUnits().get(0).getWidth()) * 1);
        int heightRoundedFromJson = (int) ((fedExFusePojoShipments.getShippingUnits().get(0).getHeight()) * 1);

        int dimensionsFromLabelStart = decodedStringShipments.indexOf("^FT406,93^A0N,22,22^FDDIMMED:") + 29;
        String dimensionsFromLabel = decodedStringShipments.substring(dimensionsFromLabelStart, dimensionsFromLabelStart + 9);
        //System.out.println("dimensionsFromLabel = " + dimensionsFromLabel);
        assertThat(dimensionsFromLabel, is(equalTo(" " + lengthRoundedFromJson + "x" + widthRoundedFromJson + "x" + heightRoundedFromJson + " " + fedExFusePojoShipments.getShippingUnits().get(0).getDimensionsUnitOfMeasure().trim().toUpperCase())));

    }

}
