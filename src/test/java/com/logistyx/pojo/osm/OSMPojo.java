package com.logistyx.pojo.osm;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
        "ShippingId",
        "ShipperCode",
        "ProjectCode",
        "ShippingFlowCode",
        "ForwarderDivisionCode",
        "ForwarderServiceCode",
        "ShipperRef",
        "ForwarderRef",
        "ReceiverRef",
        "AdditionalValues",
        "Addresses",
        "PickupAddressId",
        "PickupAddress",
        "ShipmentId",
        "EntityCode",
        "ForwarderDivision",
        "PickupForwarderDivisionAccountCode",
        "DeliveryAddressId",
        "Value",
        "DeliveryAddress",
        "ValueCurrencyCode",
        "ForwarderDivisionService",
        "DeliveryForwarderDivisionAccountCode",
        "CollectOnDeliveryAmount",
        "Shipper",
        "CustomerInvoiceNumber",
        "CollectOnDeliveryAmountCurrencyCode",
        "ConsolidationFacilityCode",
        "InsuranceValue",
        "AdmissibilityPackagingType",
        "InsuranceValueCurrencyCode",
        "CustomsValue",
        "CustomsValueCurrencyCode",
        "NonDutiable",
        "Bonded",
        "IncotermCode",
        "IncotermLocalityCode",
        "IncotermLocalityName",
        "Volume",
        "VolumeUnitOfMeasure",
        "Weight",
        "WeightUnitOfMeasure",
        "LoadingMeters",
        "CarbonNeutral",
        "Info",
        "Remark",
        "RequestedPickupDateTime",
        "RequestedPickupWindowBeginDateTime",
        "RequestedPickupWindowEndDateTime",
        "RequestedDeliveryDateTime",
        "RequestedDeliveryWindowBeginDateTime",
        "RequestedDeliveryWindowEndDateTime",
        "ServiceLevelAgreementDeliveryDateTime",
        "CollectOnDeliveryPaymentType",
        "EEIFilingMethod",
        "DangerousGoodsRegulationSet",
        "Commitment",
        "EmergencyPhoneNumber",
        "EmergencyContactName",
        "ForwarderServiceIndicators",
        "ExpectedDeliveryDateTime",
        "ConsolidationKey",
        "EeiType",
        "EeiNumber",
        "EeiReference",
        "FreightPayer",
        "DutiesPayer",
        "TaxesPayer",
        "SystemDependencyId",
        "ShippingUnits",
        "Documents",
        "SellingRate",
        "Surcharges",
        "Rates",
        "NumberOfShippingUnits",
        "DocumentDirectives"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class OSMPojo {

    @JsonProperty("ShippingId")
    public Integer shippingId;
    @JsonProperty("ShipperCode")
    public String shipperCode;
    @JsonProperty("ProjectCode")
    public String projectCode;
    @JsonProperty("ShippingFlowCode")
    public String shippingFlowCode;
    @JsonProperty("ForwarderDivisionCode")
    public String forwarderDivisionCode;
    @JsonProperty("ForwarderServiceCode")
    public String forwarderServiceCode;
    @JsonProperty("ShipperRef")
    public String shipperRef;
    @JsonProperty("ForwarderRef")
    public Object forwarderRef;
    @JsonProperty("ReceiverRef")
    public String receiverRef;
    @JsonProperty("AdditionalValues")
    public List<AdditionalValue> additionalValues = null;
    @JsonProperty("Addresses")
    public List<Address> addresses = null;
    @JsonProperty("PickupAddressId")
    public Integer pickupAddressId;
    @JsonProperty("PickupAddress")
    public PickupAddress pickupAddress;
    @JsonProperty("ShipmentId")
    public Integer shipmentId;
    @JsonProperty("EntityCode")
    public String entityCode;
    @JsonProperty("ForwarderDivision")
    public ForwarderDivision forwarderDivision;
    @JsonProperty("PickupForwarderDivisionAccountCode")
    public String pickupForwarderDivisionAccountCode;
    @JsonProperty("DeliveryAddressId")
    public Integer deliveryAddressId;
    @JsonProperty("Value")
    public Object value;
    @JsonProperty("DeliveryAddress")
    public DeliveryAddress deliveryAddress;
    @JsonProperty("ValueCurrencyCode")
    public String valueCurrencyCode;
    @JsonProperty("ForwarderDivisionService")
    public ForwarderDivisionService forwarderDivisionService;
    @JsonProperty("DeliveryForwarderDivisionAccountCode")
    public Object deliveryForwarderDivisionAccountCode;
    @JsonProperty("CollectOnDeliveryAmount")
    public Object collectOnDeliveryAmount;
    @JsonProperty("Shipper")
    public Shipper shipper;
    @JsonProperty("CustomerInvoiceNumber")
    public Object customerInvoiceNumber;
    @JsonProperty("CollectOnDeliveryAmountCurrencyCode")
    public Object collectOnDeliveryAmountCurrencyCode;
    @JsonProperty("ConsolidationFacilityCode")
    public Object consolidationFacilityCode;
    @JsonProperty("InsuranceValue")
    public Object insuranceValue;
    @JsonProperty("AdmissibilityPackagingType")
    public Object admissibilityPackagingType;
    @JsonProperty("InsuranceValueCurrencyCode")
    public Object insuranceValueCurrencyCode;
    @JsonProperty("CustomsValue")
    public Object customsValue;
    @JsonProperty("CustomsValueCurrencyCode")
    public Object customsValueCurrencyCode;
    @JsonProperty("NonDutiable")
    public Object nonDutiable;
    @JsonProperty("Bonded")
    public Object bonded;
    @JsonProperty("IncotermCode")
    public Object incotermCode;
    @JsonProperty("IncotermLocalityCode")
    public Object incotermLocalityCode;
    @JsonProperty("IncotermLocalityName")
    public Object incotermLocalityName;
    @JsonProperty("Volume")
    public Object volume;
    @JsonProperty("VolumeUnitOfMeasure")
    public Object volumeUnitOfMeasure;
    @JsonProperty("Weight")
    public Object weight;
    @JsonProperty("WeightUnitOfMeasure")
    public Object weightUnitOfMeasure;
    @JsonProperty("LoadingMeters")
    public Object loadingMeters;
    @JsonProperty("CarbonNeutral")
    public Object carbonNeutral;
    @JsonProperty("Info")
    public Object info;
    @JsonProperty("Remark")
    public Object remark;
    @JsonProperty("RequestedPickupDateTime")
    public String requestedPickupDateTime;
    @JsonProperty("RequestedPickupWindowBeginDateTime")
    public Object requestedPickupWindowBeginDateTime;
    @JsonProperty("RequestedPickupWindowEndDateTime")
    public Object requestedPickupWindowEndDateTime;
    @JsonProperty("RequestedDeliveryDateTime")
    public Object requestedDeliveryDateTime;
    @JsonProperty("RequestedDeliveryWindowBeginDateTime")
    public Object requestedDeliveryWindowBeginDateTime;
    @JsonProperty("RequestedDeliveryWindowEndDateTime")
    public Object requestedDeliveryWindowEndDateTime;
    @JsonProperty("ServiceLevelAgreementDeliveryDateTime")
    public String serviceLevelAgreementDeliveryDateTime;
    @JsonProperty("CollectOnDeliveryPaymentType")
    public Object collectOnDeliveryPaymentType;
    @JsonProperty("EEIFilingMethod")
    public String eEIFilingMethod;
    @JsonProperty("DangerousGoodsRegulationSet")
    public String dangerousGoodsRegulationSet;
    @JsonProperty("Commitment")
    public Object commitment;
    @JsonProperty("EmergencyPhoneNumber")
    public Object emergencyPhoneNumber;
    @JsonProperty("EmergencyContactName")
    public Object emergencyContactName;
    @JsonProperty("ForwarderServiceIndicators")
    public ForwarderServiceIndicators forwarderServiceIndicators;
    @JsonProperty("ExpectedDeliveryDateTime")
    public String expectedDeliveryDateTime;
    @JsonProperty("ConsolidationKey")
    public Object consolidationKey;
    @JsonProperty("EeiType")
    public Object eeiType;
    @JsonProperty("EeiNumber")
    public Object eeiNumber;
    @JsonProperty("EeiReference")
    public Object eeiReference;
    @JsonProperty("FreightPayer")
    public String freightPayer;
    @JsonProperty("DutiesPayer")
    public Object dutiesPayer;
    @JsonProperty("TaxesPayer")
    public Object taxesPayer;
    @JsonProperty("SystemDependencyId")
    public Object systemDependencyId;
    @JsonProperty("ShippingUnits")
    public List<ShippingUnit> shippingUnits = null;
    @JsonProperty("Documents")
    public List<Document> documents = null;
    @JsonProperty("SellingRate")
    public Object sellingRate;
    @JsonProperty("Surcharges")
    public List<Object> surcharges = null;
    @JsonProperty("Rates")
    public Object rates;
    @JsonProperty("NumberOfShippingUnits")
    public Integer numberOfShippingUnits;
    @JsonProperty("DocumentDirectives")
    public List<Object> documentDirectives = null;

}