package com.logistyx.pojo.osm;

import java.util.List;
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
        "ShippingUnitId",
        "EntityCode",
        "Index",
        "ShipperRef",
        "ForwarderRef",
        "ReceiverRef",
        "AdditionalValues",
        "Value",
        "ValueCurrencyCode",
        "CollectOnDeliveryAmount",
        "CollectOnDeliveryAmountCurrencyCode",
        "InsuranceValue",
        "InsuranceValueCurrencyCode",
        "CustomsValue",
        "CustomsValueCurrencyCode",
        "Length",
        "Width",
        "Height",
        "DimensionsUnitOfMeasure",
        "Area",
        "AreaUnitOfMeasure",
        "Girth",
        "GirthUnitOfMeasure",
        "Volume",
        "VolumeUnitOfMeasure",
        "PackageType",
        "SpecificPackageType",
        "NetWeight",
        "NetWeightUnitOfMeasure",
        "TareWeight",
        "TareWeightUnitOfMeasure",
        "GrossWeight",
        "GrossWeightUnitOfMeasure",
        "Content",
        "Remark",
        "Fragile",
        "Liquids",
        "Stackable",
        "Returnable",
        "Oversize",
        "AdditionalHandling",
        "NMFCCommodityClass",
        "NMFCItemNumber",
        "NMFCSubNumber",
        "CollectOnDeliveryPaymentType",
        "SystemDependencyId",
        "ShippingId",
        "ShipperCode",
        "NumberOfShippingUnitItems",
        "ShippingUnitItems",
        "DangerousGoods",
        "Shipping",
        "Documents"
})

public class ShippingUnit {

    @JsonProperty("ShippingUnitId")
    public Integer shippingUnitId;
    @JsonProperty("EntityCode")
    public String entityCode;
    @JsonProperty("Index")
    public Integer index;
    @JsonProperty("ShipperRef")
    public String shipperRef;
    @JsonProperty("ForwarderRef")
    public String forwarderRef;
    @JsonProperty("ReceiverRef")
    public Object receiverRef;
    @JsonProperty("AdditionalValues")
    public List<AdditionalValue__1> additionalValues = null;
    @JsonProperty("Value")
    public Object value;
    @JsonProperty("ValueCurrencyCode")
    public Object valueCurrencyCode;
    @JsonProperty("CollectOnDeliveryAmount")
    public Object collectOnDeliveryAmount;
    @JsonProperty("CollectOnDeliveryAmountCurrencyCode")
    public Object collectOnDeliveryAmountCurrencyCode;
    @JsonProperty("InsuranceValue")
    public Object insuranceValue;
    @JsonProperty("InsuranceValueCurrencyCode")
    public Object insuranceValueCurrencyCode;
    @JsonProperty("CustomsValue")
    public Object customsValue;
    @JsonProperty("CustomsValueCurrencyCode")
    public Object customsValueCurrencyCode;
    @JsonProperty("Length")
    public Float length;
    @JsonProperty("Width")
    public Float width;
    @JsonProperty("Height")
    public Float height;
    @JsonProperty("DimensionsUnitOfMeasure")
    public String dimensionsUnitOfMeasure;
    @JsonProperty("Area")
    public Object area;
    @JsonProperty("AreaUnitOfMeasure")
    public Object areaUnitOfMeasure;
    @JsonProperty("Girth")
    public Object girth;
    @JsonProperty("GirthUnitOfMeasure")
    public Object girthUnitOfMeasure;
    @JsonProperty("Volume")
    public Float volume;
    @JsonProperty("VolumeUnitOfMeasure")
    public String volumeUnitOfMeasure;
    @JsonProperty("PackageType")
    public String packageType;
    @JsonProperty("SpecificPackageType")
    public String specificPackageType;
    @JsonProperty("NetWeight")
    public Float netWeight;
    @JsonProperty("NetWeightUnitOfMeasure")
    public String netWeightUnitOfMeasure;
    @JsonProperty("TareWeight")
    public Float tareWeight;
    @JsonProperty("TareWeightUnitOfMeasure")
    public Object tareWeightUnitOfMeasure;
    @JsonProperty("GrossWeight")
    public Float grossWeight;
    @JsonProperty("GrossWeightUnitOfMeasure")
    public String grossWeightUnitOfMeasure;
    @JsonProperty("Content")
    public String content;
    @JsonProperty("Remark")
    public String remark;
    @JsonProperty("Fragile")
    public Object fragile;
    @JsonProperty("Liquids")
    public Object liquids;
    @JsonProperty("Stackable")
    public Object stackable;
    @JsonProperty("Returnable")
    public Object returnable;
    @JsonProperty("Oversize")
    public Object oversize;
    @JsonProperty("AdditionalHandling")
    public Object additionalHandling;
    @JsonProperty("NMFCCommodityClass")
    public Object nMFCCommodityClass;
    @JsonProperty("NMFCItemNumber")
    public Object nMFCItemNumber;
    @JsonProperty("NMFCSubNumber")
    public Object nMFCSubNumber;
    @JsonProperty("CollectOnDeliveryPaymentType")
    public Object collectOnDeliveryPaymentType;
    @JsonProperty("SystemDependencyId")
    public Object systemDependencyId;
    @JsonProperty("ShippingId")
    public Integer shippingId;
    @JsonProperty("ShipperCode")
    public String shipperCode;
    @JsonProperty("NumberOfShippingUnitItems")
    public Integer numberOfShippingUnitItems;
    @JsonProperty("ShippingUnitItems")
    public List<ShippingUnitItem> shippingUnitItems = null;
    @JsonProperty("DangerousGoods")
    public List<Object> dangerousGoods = null;
    @JsonProperty("Shipping")
    public Object shipping;
    @JsonProperty("Documents")
    public List<Object> documents = null;

}