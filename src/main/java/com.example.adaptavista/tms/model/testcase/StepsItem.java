package com.example.adaptavista.tms.model.testcase;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StepsItem {

    @JsonProperty("expectedResult")
    private String expectedResult;

    @JsonProperty("index")
    private int index;

    @JsonProperty("description")
    private String description;

    @JsonProperty("id")
    private int id;
}