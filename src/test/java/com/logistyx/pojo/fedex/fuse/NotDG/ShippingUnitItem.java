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
        "ShippingUnitItemId",
        "ShippingUnitId",
        "Reference",
        "Value",
        "ValueCurrencyCode",
        "Quantity",
        "QuantityUnitOfMeasure",
        "Weight",
        "WeightUnitOfMeasure",
        "Description",
        "CountryOfOrigin",
        "HarmonisedSystemCode",
        "CommodityDescription",
        "DualUseCode",
        "ProductCode",
        "ExportControlClassificationNumber",
        "ExportLicenseNumber",
        "ExportLicenseExpiryDatetime",
        "TariffPreferenceCode",
        "LicenseExemptionSymbol",
        "ITARExemptionNumber",
        "EEISecondQuantity",
        "EEISecondUnitOfMeasure",
        "ExportInformationCode",
        "Vehicle",
        "VehicleIdentification",
        "VehicleIdentificationQualifier",
        "VehicleTitleNumber",
        "VehicleTitleStateCode",
        "DDTCRegistrationNumber",
        "DDTCSignificantMilitaryEquipment",
        "DDTCEligiblePartyCertification",
        "DDTCUSMLCategoryCode",
        "DDTCUnitOfMeasure",
        "DDTCQuantity",
        "EEIQuantity",
        "EEIValue",
        "EEIUnitOfMeasure",
        "AlcoholicBeverage",
        "NMFCCommodityClass",
        "NMFCItemNumber",
        "NMFCSubNumber",
        "SystemDependencyId",
        "Fragile",
        "Liquids",
        "DangerousGoods",
        "AdditionalValues"
})

public class ShippingUnitItem {

    @JsonProperty("ShippingUnitItemId")
    public Integer shippingUnitItemId;
    @JsonProperty("ShippingUnitId")
    public Integer shippingUnitId;
    @JsonProperty("Reference")
    public Object reference;
    @JsonProperty("Value")
    public Float value;
    @JsonProperty("ValueCurrencyCode")
    public String valueCurrencyCode;
    @JsonProperty("Quantity")
    public Integer quantity;
    @JsonProperty("QuantityUnitOfMeasure")
    public String quantityUnitOfMeasure;
    @JsonProperty("Weight")
    public Float weight;
    @JsonProperty("WeightUnitOfMeasure")
    public String weightUnitOfMeasure;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("CountryOfOrigin")
    public Object countryOfOrigin;
    @JsonProperty("HarmonisedSystemCode")
    public Object harmonisedSystemCode;
    @JsonProperty("CommodityDescription")
    public Object commodityDescription;
    @JsonProperty("DualUseCode")
    public Object dualUseCode;
    @JsonProperty("ProductCode")
    public String productCode;
    @JsonProperty("ExportControlClassificationNumber")
    public Object exportControlClassificationNumber;
    @JsonProperty("ExportLicenseNumber")
    public Object exportLicenseNumber;
    @JsonProperty("ExportLicenseExpiryDatetime")
    public Object exportLicenseExpiryDatetime;
    @JsonProperty("TariffPreferenceCode")
    public Object tariffPreferenceCode;
    @JsonProperty("LicenseExemptionSymbol")
    public Object licenseExemptionSymbol;
    @JsonProperty("ITARExemptionNumber")
    public Object iTARExemptionNumber;
    @JsonProperty("EEISecondQuantity")
    public Object eEISecondQuantity;
    @JsonProperty("EEISecondUnitOfMeasure")
    public Object eEISecondUnitOfMeasure;
    @JsonProperty("ExportInformationCode")
    public Object exportInformationCode;
    @JsonProperty("Vehicle")
    public Object vehicle;
    @JsonProperty("VehicleIdentification")
    public Object vehicleIdentification;
    @JsonProperty("VehicleIdentificationQualifier")
    public Object vehicleIdentificationQualifier;
    @JsonProperty("VehicleTitleNumber")
    public Object vehicleTitleNumber;
    @JsonProperty("VehicleTitleStateCode")
    public Object vehicleTitleStateCode;
    @JsonProperty("DDTCRegistrationNumber")
    public Object dDTCRegistrationNumber;
    @JsonProperty("DDTCSignificantMilitaryEquipment")
    public Object dDTCSignificantMilitaryEquipment;
    @JsonProperty("DDTCEligiblePartyCertification")
    public Object dDTCEligiblePartyCertification;
    @JsonProperty("DDTCUSMLCategoryCode")
    public Object dDTCUSMLCategoryCode;
    @JsonProperty("DDTCUnitOfMeasure")
    public Object dDTCUnitOfMeasure;
    @JsonProperty("DDTCQuantity")
    public Object dDTCQuantity;
    @JsonProperty("EEIQuantity")
    public Object eEIQuantity;
    @JsonProperty("EEIValue")
    public Object eEIValue;
    @JsonProperty("EEIUnitOfMeasure")
    public Object eEIUnitOfMeasure;
    @JsonProperty("AlcoholicBeverage")
    public Object alcoholicBeverage;
    @JsonProperty("NMFCCommodityClass")
    public Object nMFCCommodityClass;
    @JsonProperty("NMFCItemNumber")
    public Object nMFCItemNumber;
    @JsonProperty("NMFCSubNumber")
    public Object nMFCSubNumber;
    @JsonProperty("SystemDependencyId")
    public Object systemDependencyId;
    @JsonProperty("Fragile")
    public Boolean fragile;
    @JsonProperty("Liquids")
    public Boolean liquids;
    @JsonProperty("DangerousGoods")
    public List<Object> dangerousGoods = null;
    @JsonProperty("AdditionalValues")
    public List<Object> additionalValues = null;

}