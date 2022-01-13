package com.logistyx.pojo.fedex.fuse.NotDG;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ShippingId",
        "ShipperCode",
        "TrackAndTrace",
        "DirectDeliveryOnly",
        "DeliverySignature",
        "HoldAtLocation",
        "NumberOfAttempts",
        "Shipment",
        "InterventionalMonitoring",
        "AdditionalServices"
})

public class ForwarderServiceIndicators {

    @JsonProperty("ShippingId")
    public Integer shippingId;
    @JsonProperty("ShipperCode")
    public String shipperCode;
    @JsonProperty("TrackAndTrace")
    public Object trackAndTrace;
    @JsonProperty("DirectDeliveryOnly")
    public Boolean directDeliveryOnly;
    @JsonProperty("DeliverySignature")
    public String deliverySignature;
    @JsonProperty("HoldAtLocation")
    public String holdAtLocation;
    @JsonProperty("NumberOfAttempts")
    public Object numberOfAttempts;
    @JsonProperty("Shipment")
    public Object shipment;
    @JsonProperty("InterventionalMonitoring")
    public Object interventionalMonitoring;
    @JsonProperty("AdditionalServices")
    public Object additionalServices;

}