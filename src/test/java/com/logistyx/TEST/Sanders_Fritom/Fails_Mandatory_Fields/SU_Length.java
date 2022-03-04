package com.logistyx.TEST.Sanders_Fritom.Fails_Mandatory_Fields;


import com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom.SFBaseNotDG_SU_Length;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SU_Length extends SFBaseNotDG_SU_Length {

    static {
        SFBaseNotDG_SU_Length.shipmentsLabel();
    }


    @DisplayName("Missing ShippingUnits.Length - The requested output cannot be generated without it")
    @Test
    public void test1() {

    //    validateResponseShipments.extract().response().prettyPrint();

        String errorMessage = validateResponseShipments.extract().response().path("InvalidData[0].ValidationMessages[0]");
    //    System.out.println("errorMessage = " + errorMessage);
        assertThat(errorMessage, is(equalTo("Missing ShippingUnits.Length - The requested output cannot be generated without it.")));
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
