package com.logistyx.pojo.sanders.fritom;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "AddressId",
        "Index",
        "Value"
})
@Getter
@Setter
public class AddressLine__2 {

    @JsonProperty("AddressId")
    public Integer addressId;
    @JsonProperty("Index")
    public Integer index;
    @JsonProperty("Value")
    public String value;

}
