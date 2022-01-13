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
        "ForwarderDivisionCode",
        "ForwarderServiceCode",
        "Name",
        "SupportsP2PRating"
})

public class ForwarderDivisionService {

    @JsonProperty("ForwarderDivisionCode")
    public String forwarderDivisionCode;
    @JsonProperty("ForwarderServiceCode")
    public String forwarderServiceCode;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("SupportsP2PRating")
    public Boolean supportsP2PRating;

}