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
        "AddressId",
        "AddressTypeCode"
})

public class AddressType__2 {

    @JsonProperty("AddressId")
    public Integer addressId;
    @JsonProperty("AddressTypeCode")
    public String addressTypeCode;

}
