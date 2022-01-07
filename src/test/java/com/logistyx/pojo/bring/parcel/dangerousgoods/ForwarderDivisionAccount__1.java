package com.logistyx.pojo.bring.parcel.dangerousgoods;

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
        "ShipperCode",
        "ProjectCode",
        "AddressId",
        "ForwarderDivisionCode",
        "AccountCode"
})

public class ForwarderDivisionAccount__1 {

    @JsonProperty("ShipperCode")
    public String shipperCode;
    @JsonProperty("ProjectCode")
    public String projectCode;
    @JsonProperty("AddressId")
    public Integer addressId;
    @JsonProperty("ForwarderDivisionCode")
    public String forwarderDivisionCode;
    @JsonProperty("AccountCode")
    public String accountCode;

}
