package com.logistyx.pojo.countries;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Country {

    private String countryCode;
    private String countryName;
    private String phoneCode;
    private String continentCode;
    private String currencyCode;




}
