package com.logistyx.TEST.OSM.Dangerous_Goods_Limited_Quantity.Negative_Dangerous_Goods_Not_LQ;


import com.logistyx.utilities.AbstractBaseClasses.OSM.Dangerous_Goods_Limited_Quantity.Negative_Dangerous_Goods_Not_LQ.OSMBaseGlobalPriorityDGNOTLQFailing;
import com.logistyx.utilities.AbstractBaseClasses.OSM.Dangerous_Goods_Limited_Quantity.Negative_Dangerous_Goods_Not_LQ.OSMBaseGlobalStandardDGNOTLQFailing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class Global_Standard_DG_NOT_LQ_Failing extends OSMBaseGlobalStandardDGNOTLQFailing {

    static {

        OSMBaseGlobalStandardDGNOTLQFailing.shipmentsLabel();

    }


    @DisplayName("shippingunititem.dg.LimitedQuantity")
    @Test
    public void test1() {

        //    validateResponseShipments.extract().response().prettyPrint();
        String errorMessage1 = validateResponseShipments.extract().response().path("InvalidData[0].ValidationMessages[0]");
        //    System.out.println("errorMessage1 = " + errorMessage1);
        assertThat(errorMessage1, is(equalTo("Non LQ Dangerous Goods are not supported.")));
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
