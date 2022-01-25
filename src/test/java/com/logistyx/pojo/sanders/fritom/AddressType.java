package com.logistyx.pojo.sanders.fritom;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "AddressId",
        "AddressTypeCode"
})
@Getter
@Setter
public class AddressType {

    @JsonProperty("AddressId")
    public Integer addressId;
    @JsonProperty("AddressTypeCode")
    public String addressTypeCode;

}