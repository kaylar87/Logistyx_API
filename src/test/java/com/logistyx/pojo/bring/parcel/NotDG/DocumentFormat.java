package com.logistyx.pojo.bring.parcel.NotDG;

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
        "DocumentFormatCode",
        "MimeType",
        "CharacterEncoding",
        "Extension",
        "Description"
})

public class DocumentFormat {

    @JsonProperty("DocumentFormatCode")
    public String documentFormatCode;
    @JsonProperty("MimeType")
    public String mimeType;
    @JsonProperty("CharacterEncoding")
    public String characterEncoding;
    @JsonProperty("Extension")
    public String extension;
    @JsonProperty("Description")
    public String description;

}
