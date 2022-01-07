package com.logistyx.pojo.bring.parcel.shipments;

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
        "ForwarderCode",
        "Name"
})

public class Forwarder {

    @JsonProperty("ForwarderCode")
    public String forwarderCode;
    @JsonProperty("Name")
    public String name;

}
