package com.logistyx.pojo.osm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
    public Boolean trackAndTrace;
    @JsonProperty("DirectDeliveryOnly")
    public Object directDeliveryOnly;
    @JsonProperty("DeliverySignature")
    public String deliverySignature;
    @JsonProperty("HoldAtLocation")
    public Object holdAtLocation;
    @JsonProperty("NumberOfAttempts")
    public Object numberOfAttempts;
    @JsonProperty("Shipment")
    public Object shipment;
    @JsonProperty("InterventionalMonitoring")
    public Object interventionalMonitoring;
    @JsonProperty("AdditionalServices")
    public Object additionalServices;

}