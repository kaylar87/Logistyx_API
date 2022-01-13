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
        "AddressId",
        "AddressTypeCode"
})

public class AddressType__1 {

    @JsonProperty("AddressId")
    public Integer addressId;
    @JsonProperty("AddressTypeCode")
    public String addressTypeCode;

}