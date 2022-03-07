package com.logistyx.TEST.Sanders_Fritom.Fails_Mandatory_Fields;



import com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom.SFBaseNotDG_No_ShipperAddress_Reference_Or_ContactName;
import com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom.SFBaseNotDG_SU_Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class No_ShipperAddress_Reference_Or_ContactName extends SFBaseNotDG_No_ShipperAddress_Reference_Or_ContactName {

    static {
        SFBaseNotDG_No_ShipperAddress_Reference_Or_ContactName.shipmentsLabel();
    }


    @DisplayName("Missing shipperAddress or pickupAddress Contact.Name - The requested output cannot be generated without it.")
    @Test
    public void test1() {

    //    validateResponseShipments.extract().response().prettyPrint();

        String errorMessage = validateResponseShipments.extract().response().path("InvalidData[0].ValidationMessages[0]");
    //    System.out.println("errorMessage = " + errorMessage);
        assertThat(errorMessage, is(equalTo("Missing shipperAddress or pickupAddress Contact.Name - The requested output cannot be generated without it.")));
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
