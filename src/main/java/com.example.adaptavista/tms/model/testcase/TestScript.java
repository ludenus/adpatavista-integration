package com.example.adaptavista.tms.model.testcase;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TestScript {

    @JsonProperty("text")
    private String text;

    @JsonProperty("id")
    private int id;

    @JsonProperty("type")
    private String type;
}