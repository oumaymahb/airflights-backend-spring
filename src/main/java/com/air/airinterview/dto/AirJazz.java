package com.air.airinterview.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirJazz {

    private String id;

    private double price;

    @JsonProperty("dtime")
    private String dTime;

    @JsonProperty("atime")
    private String aTime;
}
