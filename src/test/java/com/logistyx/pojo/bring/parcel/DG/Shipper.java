package com.logistyx.pojo.bring.parcel.DG;

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
        "Name"
})

public class Shipper {

    @JsonProperty("ShipperCode")
    public String shipperCode;
    @JsonProperty("Name")
    public String name;

}
