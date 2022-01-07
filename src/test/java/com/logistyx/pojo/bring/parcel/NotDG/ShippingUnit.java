package com.logistyx.pojo.bring.parcel.NotDG;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
    public String receiverRef;
    @JsonProperty("AdditionalValues")
    public List<Object> additionalValues = null;
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
    public Double length;
    @JsonProperty("Width")
    public Double width;
    @JsonProperty("Height")
    public Double height;
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
    public Double volume;
    @JsonProperty("VolumeUnitOfMeasure")
    public String volumeUnitOfMeasure;
    @JsonProperty("PackageType")
    public String packageType;
    @JsonProperty("SpecificPackageType")
    public Object specificPackageType;
    @JsonProperty("NetWeight")
    public Double netWeight;
    @JsonProperty("NetWeightUnitOfMeasure")
    public Object netWeightUnitOfMeasure;
    @JsonProperty("TareWeight")
    public Double tareWeight;
    @JsonProperty("TareWeightUnitOfMeasure")
    public Object tareWeightUnitOfMeasure;
    @JsonProperty("GrossWeight")
    public Double grossWeight;
    @JsonProperty("GrossWeightUnitOfMeasure")
    public String grossWeightUnitOfMeasure;
    @JsonProperty("Content")
    public String content;
    @JsonProperty("Remark")
    public Object remark;
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
    public List<Object> shippingUnitItems = null;
    @JsonProperty("DangerousGoods")
    public List<Object> dangerousGoods = null;
    @JsonProperty("Shipping")
    public Object shipping;
    @JsonProperty("Documents")
    public List<Object> documents = null;

}