package com.logistyx.pojo.forwarders;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ForwarderDivisionService {

    private String forwarderServiceCode;

    @JsonProperty("name")
    private String nameForwarderDivisionService;
    private Object description;




}
