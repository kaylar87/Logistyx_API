package com.logistyx.pojo.sanders.fritom;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ForwarderCode",
        "Name"
})
@Getter
@Setter
public class Forwarder {

    @JsonProperty("ForwarderCode")
    public String forwarderCode;
    @JsonProperty("Name")
    public String name;

}