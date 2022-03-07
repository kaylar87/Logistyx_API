package com.logistyx.TEST.Sanders_Fritom.Fails_Mandatory_Fields;



import com.logistyx.utilities.AbstractBaseClasses.Sanders_Fritom.SFBaseNotDG_ContactName_And_Ref;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class ContactName_And_Ref extends SFBaseNotDG_ContactName_And_Ref {

    static {
        SFBaseNotDG_ContactName_And_Ref.shipmentsLabel();
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
