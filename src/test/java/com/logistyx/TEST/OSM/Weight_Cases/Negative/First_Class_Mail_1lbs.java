package com.logistyx.TEST.OSM.Weight_Cases.Negative;


import com.logistyx.utilities.AbstractBaseClasses.OSM.Weight_Cases.Negative.OSMBaseFirstClassMailNotDG1lbs;
import com.logistyx.utilities.AbstractBaseClasses.OSM.Weight_Cases.Negative.OSMBasePriorityMailNotDGLess1lbs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class First_Class_Mail_1lbs extends OSMBaseFirstClassMailNotDG1lbs {

    static {

        OSMBaseFirstClassMailNotDG1lbs.shipmentsLabel();

    }


    @DisplayName("shippingunit.Gross Weight")
    @Test
    public void test1() {

        //    validateResponseShipments.extract().response().prettyPrint();
        String errorMessage1 = validateResponseShipments.extract().response().path("InvalidData[0].ValidationMessages[0]");
        //    System.out.println("errorMessage1 = " + errorMessage1);
        assertThat(errorMessage1, is(equalTo("First Class Mail shipping unit weight [1] must be less than 1 lb.")));
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
