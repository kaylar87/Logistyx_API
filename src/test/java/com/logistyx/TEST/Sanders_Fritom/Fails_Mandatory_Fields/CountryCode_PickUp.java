package com.logistyx.TEST.Sanders_Fritom.Fails_Mandatory_Fields;



import com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom.SFBaseNotDG_CountryCode_PickUp;
import com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom.SFBaseNotDG_SU_Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class CountryCode_PickUp extends SFBaseNotDG_CountryCode_PickUp {

    static {
        SFBaseNotDG_CountryCode_PickUp.shipmentsLabel();
    }


    @DisplayName("Empty pickupAddress.CountryCode - The requested output cannot be generated without it.")
    @Test
    public void test1() {

    //    validateResponseShipments.extract().response().prettyPrint();

        String errorMessage = validateResponseShipments.extract().response().path("InvalidData[0].ValidationMessages[0]");
    //    System.out.println("errorMessage = " + errorMessage);
        assertThat(errorMessage, is(equalTo("Empty pickupAddress.CountryCode - The requested output cannot be generated without it.")));
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
