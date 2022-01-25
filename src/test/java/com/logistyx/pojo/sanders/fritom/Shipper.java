package com.logistyx.pojo.sanders.fritom;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ShipperCode",
        "Name"
})
@Getter
@Setter
public class Shipper {

    @JsonProperty("ShipperCode")
    public String shipperCode;
    @JsonProperty("Name")
    public String name;

}
