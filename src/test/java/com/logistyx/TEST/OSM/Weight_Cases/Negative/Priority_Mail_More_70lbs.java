package com.logistyx.TEST.OSM.Weight_Cases.Negative;


import com.logistyx.utilities.AbstractBaseClasses.OSM.Weight_Cases.Negative.OSMBasePriorityMailNotDGMore70lbs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class Priority_Mail_More_70lbs extends OSMBasePriorityMailNotDGMore70lbs {

    static {

        OSMBasePriorityMailNotDGMore70lbs.shipmentsLabel();

    }


    @DisplayName("shippingunit.Gross Weight")
    @Test
    public void test1() {

        //    validateResponseShipments.extract().response().prettyPrint();
        String errorMessage1 = validateResponseShipments.extract().response().path("InvalidData[0].ValidationMessages[0]");
        //    System.out.println("errorMessage1 = " + errorMessage1);
        assertThat(errorMessage1, is(equalTo("Priority Mail shipping unit weight [70.1] must be between 1 and 70 lb.")));
    }


    @DisplayName("JSON Body Request")
    @Test
    public void test45() {
        System.out.println("requestJsonBodyShipments = " + requestJsonBodyShipments);

    }


    @DisplayName("JSON Body Response")
    @Test
    public void test46() {
        validateResponseShipments.extract().response().prettyPrint();

    }


}
