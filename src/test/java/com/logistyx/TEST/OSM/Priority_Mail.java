package com.logistyx.TEST.OSM;


import com.logistyx.utilities.AbstractBaseClasses.OSM.OSMBaseNotDG;
import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Priority_Mail extends OSMBaseNotDG {

    static {
        OSMBaseNotDG.shipmentsLabel();
    }


    @DisplayName("ShippingId is not NULL")
    @Test
    public void test1() {


        assertThat(osmPojoShipments.getShipmentId(), is(notNullValue()));
        System.out.println("decodedStringConveyances = " + decodedStringConveyances);
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
