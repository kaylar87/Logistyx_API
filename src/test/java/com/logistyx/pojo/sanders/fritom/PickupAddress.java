package com.logistyx.pojo.sanders.fritom;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "SourceLevel",
        "AddressId",
        "ShippingId",
        "ShipperCode",
        "Reference",
        "AddressLines",
        "PostalCode",
        "LocalityCode",
        "LocalityName",
        "SubdivisionCode",
        "SubdivisionName",
        "CountryCode",
        "CountryName",
        "Description",
        "Remark",
        "Contacts",
        "VatNumber",
        "BankAccountNumber",
        "Residential",
        "ForwarderDivisionAccounts",
        "AddressTypes",
        "AccountNumber",
        "ProjectCode"
})
@Getter
@Setter
public class PickupAddress {

    @JsonProperty("SourceLevel")
    public String sourceLevel;
    @JsonProperty("AddressId")
    public Integer addressId;
    @JsonProperty("ShippingId")
    public Integer shippingId;
    @JsonProperty("ShipperCode")
    public String shipperCode;
    @JsonProperty("Reference")
    public String reference;
    @JsonProperty("AddressLines")
    public List<AddressLine__1> addressLines = null;
    @JsonProperty("PostalCode")
    public String postalCode;
    @JsonProperty("LocalityCode")
    public Object localityCode;
    @JsonProperty("LocalityName")
    public String localityName;
    @JsonProperty("SubdivisionCode")
    public Object subdivisionCode;
    @JsonProperty("SubdivisionName")
    public Object subdivisionName;
    @JsonProperty("CountryCode")
    public String countryCode;
    @JsonProperty("CountryName")
    public Object countryName;
    @JsonProperty("Description")
    public Object description;
    @JsonProperty("Remark")
    public String remark;
    @JsonProperty("Contacts")
    public List<Contact__1> contacts = null;
    @JsonProperty("VatNumber")
    public String vatNumber;
    @JsonProperty("BankAccountNumber")
    public Object bankAccountNumber;
    @JsonProperty("Residential")
    public Boolean residential;
    @JsonProperty("ForwarderDivisionAccounts")
    public List<Object> forwarderDivisionAccounts = null;
    @JsonProperty("AddressTypes")
    public List<AddressType__1> addressTypes = null;
    @JsonProperty("AccountNumber")
    public Object accountNumber;
    @JsonProperty("ProjectCode")
    public Object projectCode;

}
