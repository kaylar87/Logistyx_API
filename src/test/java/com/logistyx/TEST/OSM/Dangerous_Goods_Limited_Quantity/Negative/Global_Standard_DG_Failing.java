package com.logistyx.TEST.OSM.Dangerous_Goods_Limited_Quantity.Negative;


import com.logistyx.utilities.AbstractBaseClasses.OSM.Dangerous_Goods_Limited_Quantity.Negative.OSMBaseGlobalPriorityDGFailing;
import com.logistyx.utilities.AbstractBaseClasses.OSM.Dangerous_Goods_Limited_Quantity.Negative.OSMBaseGlobalStandardDGFailing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class Global_Standard_DG_Failing extends OSMBaseGlobalStandardDGFailing {

    static {

        OSMBaseGlobalStandardDGFailing.shipmentsLabel();

    }


    @DisplayName("shipment.Dangerous Goods")
    @Test
    public void test1() {

        //    validateResponseShipments.extract().response().prettyPrint();
        String errorMessage1 = validateResponseShipments.extract().response().path("InvalidData[0].ValidationMessages[0]");
        //    System.out.println("errorMessage1 = " + errorMessage1);
        assertThat(errorMessage1, is(equalTo("Limited Quantity Dangerous Goods is not allowed for service.")));
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
