package com.logistyx.TEST.OSM.Origins_Destinations.Domestic.Negative;

import com.logistyx.utilities.AbstractBaseClasses.OSM.Origins_Destinations.Domestic.Negative.OSMBasePriorityMailNotDGFailingInternational;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Priority_Mail_Failing_International extends OSMBasePriorityMailNotDGFailingInternational {

    static {
        OSMBasePriorityMailNotDGFailingInternational.shipmentsLabel();
    }


    @DisplayName("shipment.ForwarderServiceCode")
    @Test
    public void test1() {

        //    validateResponseShipments.extract().response().prettyPrint();
        String errorMessage1 = validateResponseShipments.extract().response().path("InvalidData[0].ValidationMessages[0]");
        //    System.out.println("errorMessage1 = " + errorMessage1);
        assertThat(errorMessage1, is(equalTo("ForwarderServiceCode [OSM-PRIORITY-MAIL] does not allow international shipments")));
    }


    @DisplayName("JSON Body Request")
    @Test
    public void test2() {
        System.out.println("requestJsonBodyShipments = " + requestJsonBodyShipments);
    }


    @DisplayName("JSON Body Response")
    @Test
    public void test3() {
        validateResponseShipments.extract().response().prettyPrint();
    }


}

