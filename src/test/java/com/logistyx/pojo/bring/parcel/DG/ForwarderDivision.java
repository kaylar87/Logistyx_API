package com.logistyx.pojo.bring.parcel.DG;

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
        "ForwarderCode",
        "ForwarderDivisionCode",
        "Forwarder",
        "CountryCode",
        "Name",
        "SystemDependencyCode",
        "SCAC",
        "CarrierLicenseRegistrationNumber",
        "Iata2"
})

public class ForwarderDivision {

    @JsonProperty("ForwarderCode")
    public String forwarderCode;
    @JsonProperty("ForwarderDivisionCode")
    public String forwarderDivisionCode;
    @JsonProperty("Forwarder")
    public Forwarder forwarder;
    @JsonProperty("CountryCode")
    public Object countryCode;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("SystemDependencyCode")
    public Object systemDependencyCode;
    @JsonProperty("SCAC")
    public String scac;
    @JsonProperty("CarrierLicenseRegistrationNumber")
    public String carrierLicenseRegistrationNumber;
    @JsonProperty("Iata2")
    public Object iata2;

}
