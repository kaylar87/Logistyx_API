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
        "ShippingUnitId",
        "ShipperCode",
        "AdditionalValueKey",
        "Value"
})

public class AdditionalValue__1 {

    @JsonProperty("ShippingId")
    public Integer shippingId;
    @JsonProperty("ShippingUnitId")
    public Integer shippingUnitId;
    @JsonProperty("ShipperCode")
    public String shipperCode;
    @JsonProperty("AdditionalValueKey")
    public String additionalValueKey;
    @JsonProperty("Value")
    public String value;

}