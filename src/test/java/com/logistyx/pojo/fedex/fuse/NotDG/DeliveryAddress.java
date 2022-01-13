package com.logistyx.pojo.fedex.fuse.NotDG;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

public class DeliveryAddress {

    @JsonProperty("SourceLevel")
    public String sourceLevel;
    @JsonProperty("AddressId")
    public Integer addressId;
    @JsonProperty("ShippingId")
    public Integer shippingId;
    @JsonProperty("ShipperCode")
    public String shipperCode;
    @JsonProperty("Reference")
    public Object reference;
    @JsonProperty("AddressLines")
    public List<AddressLine__2> addressLines = null;
    @JsonProperty("PostalCode")
    public String postalCode;
    @JsonProperty("LocalityCode")
    public Object localityCode;
    @JsonProperty("LocalityName")
    public String localityName;
    @JsonProperty("SubdivisionCode")
    public String subdivisionCode;
    @JsonProperty("SubdivisionName")
    public String subdivisionName;
    @JsonProperty("CountryCode")
    public String countryCode;
    @JsonProperty("CountryName")
    public Object countryName;
    @JsonProperty("Description")
    public Object description;
    @JsonProperty("Remark")
    public Object remark;
    @JsonProperty("Contacts")
    public List<Contact__2> contacts = null;
    @JsonProperty("VatNumber")
    public Object vatNumber;
    @JsonProperty("BankAccountNumber")
    public Object bankAccountNumber;
    @JsonProperty("Residential")
    public Boolean residential;
    @JsonProperty("ForwarderDivisionAccounts")
    public List<Object> forwarderDivisionAccounts = null;
    @JsonProperty("AddressTypes")
    public List<AddressType__2> addressTypes = null;
    @JsonProperty("AccountNumber")
    public Object accountNumber;
    @JsonProperty("ProjectCode")
    public Object projectCode;

}