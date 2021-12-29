package com.logistyx.pojo.forwarders;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString

public class ForwarderDivision {
    private String forwarderDivisionCode;
    private String forwarderDivisionName;
    private String countryCode;
    private List<ForwarderDivisionService> forwarderDivisionServices;


    public String getForwarderDivisionCode() {
        return forwarderDivisionCode;
    }
}
