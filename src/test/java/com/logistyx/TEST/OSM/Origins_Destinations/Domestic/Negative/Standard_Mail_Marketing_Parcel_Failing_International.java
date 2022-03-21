package com.logistyx.TEST.OSM.Origins_Destinations.Domestic.Negative;

import com.logistyx.utilities.AbstractBaseClasses.OSM.Origins_Destinations.Domestic.Negative.OSMBasePriorityMailNotDGFailingInternational;
import com.logistyx.utilities.AbstractBaseClasses.OSM.Origins_Destinations.Domestic.Negative.OSMBaseStandardMailMarketingParcelNotDGFailingInternational;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Standard_Mail_Marketing_Parcel_Failing_International extends OSMBaseStandardMailMarketingParcelNotDGFailingInternational {

    static {
        OSMBaseStandardMailMarketingParcelNotDGFailingInternational.shipmentsLabel();
    }


    @DisplayName("shipment.ForwarderServiceCode")
    @Test
    public void test1() {

        //    validateResponseShipments.extract().response().prettyPrint();
        String errorMessage1 = validateResponseShipments.extract().response().path("InvalidData[0].ValidationMessages[0]");
        //    System.out.println("errorMessage1 = " + errorMessage1);
        assertThat(errorMessage1, is(equalTo("ForwarderServiceCode [OSM-STD-MAIL-MP] does not allow international shipments")));
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

