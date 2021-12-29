package com.logistyx.pojo.forwarders;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Forwarder {

    private String forwarderCode;
    private String name;
    private List<ForwarderDivision> forwarderDivisions;


}
