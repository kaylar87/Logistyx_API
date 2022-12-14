package com.logistyx.pojo.sanders.fritom;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ShippingId",
        "ShipperCode",
        "Reference",
        "DocumentTypeCode",
        "DocumentType",
        "DocumentFormatCode",
        "DocumentFormat",
        "Content"
})
@Getter
@Setter
public class Document {

    @JsonProperty("ShippingId")
    public Integer shippingId;
    @JsonProperty("ShipperCode")
    public String shipperCode;
    @JsonProperty("Reference")
    public Object reference;
    @JsonProperty("DocumentTypeCode")
    public String documentTypeCode;
    @JsonProperty("DocumentType")
    public DocumentType documentType;
    @JsonProperty("DocumentFormatCode")
    public String documentFormatCode;
    @JsonProperty("DocumentFormat")
    public DocumentFormat documentFormat;
    @JsonProperty("Content")
    public String content;

}