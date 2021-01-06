package com.example.adaptavista.tms.model.testresult;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomFields {

    @JsonProperty("CI Server")
    private String cIServer;
}