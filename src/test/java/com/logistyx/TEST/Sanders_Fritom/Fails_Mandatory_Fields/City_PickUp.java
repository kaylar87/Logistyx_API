package com.logistyx.TEST.Sanders_Fritom.Fails_Mandatory_Fields;



import com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom.SFBaseNotDG_City_PickUp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class City_PickUp extends SFBaseNotDG_City_PickUp {

    static {
        SFBaseNotDG_City_PickUp.shipmentsLabel();
    }


    @DisplayName("Missing shipperAddress or pickupAddress.LocalityName - The requested output cannot be generated without it.")
    @Test
    public void test1() {

        //    validateResponseShipments.extract().response().prettyPrint();

        String errorMessage1 = validateResponseShipments.extract().response().path("InvalidData[0].ValidationMessages[0]");
        String errorMessage2 = validateResponseShipments.extract().response().path("InvalidData[1].ValidationMessages[0]");
        //    System.out.println("errorMessage1 = " + errorMessage1);
        //    System.out.println("errorMessage2 = " + errorMessage2);
        assertThat(errorMessage1, is(equalTo("Missing shipperAddress or pickupAddress.LocalityName - The requested output cannot be generated without it.")));
        assertThat(errorMessage2, is(equalTo("Missing pickupAddress.LocalityName - The requested output cannot be generated without it.")));
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
