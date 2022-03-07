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
        "Index",
        "Value"
})

public class AddressLine__1 {

    @JsonProperty("AddressId")
    public Integer addressId;
    @JsonProperty("Index")
    public Integer index;
    @JsonProperty("Value")
    public Object value;

}