package com.logistyx.TEST.Sanders_Fritom.Fails_Mandatory_Fields;



import com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom.SFBaseNotDG_AddresLine_1;
import com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom.SFBaseNotDG_SU_Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class AddresLine_1 extends SFBaseNotDG_AddresLine_1 {

    static {
        SFBaseNotDG_AddresLine_1.shipmentsLabel();
    }


    @DisplayName("Empty shipperAddress or pickupAddress addressLine1")
    @Test
    public void test1() {

    //    validateResponseShipments.extract().response().prettyPrint();

        String errorMessage1 = validateResponseShipments.extract().response().path("InvalidData[0].ValidationMessages[0]");
        String errorMessage2 = validateResponseShipments.extract().response().path("InvalidData[1].ValidationMessages[0]");
    //    System.out.println("errorMessage1 = " + errorMessage1);
    //    System.out.println("errorMessage2 = " + errorMessage2);
        assertThat(errorMessage1, is(equalTo("Empty shipperAddress or pickupAddress addressLine1 - The requested output cannot be generated without it.")));
        assertThat(errorMessage2, is(equalTo("Empty pickupAddressLine1 - The requested output cannot be generated without it.")));
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
