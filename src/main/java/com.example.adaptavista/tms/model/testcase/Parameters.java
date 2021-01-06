package com.example.adaptavista.tms.model.testcase;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Parameters {

    @JsonProperty("variables")
    private List<Object> variables;

    @JsonProperty("entries")
    private List<Object> entries;

}