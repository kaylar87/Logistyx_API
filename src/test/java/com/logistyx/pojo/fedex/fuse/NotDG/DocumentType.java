package com.logistyx.pojo.fedex.fuse.NotDG;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "DocumentTypeCode",
        "InternalOnly",
        "Description"
})

public class DocumentType {

    @JsonProperty("DocumentTypeCode")
    public String documentTypeCode;
    @JsonProperty("InternalOnly")
    public Boolean internalOnly;
    @JsonProperty("Description")
    public String description;

}
