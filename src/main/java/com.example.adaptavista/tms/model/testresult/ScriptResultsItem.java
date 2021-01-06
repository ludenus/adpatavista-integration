package com.example.adaptavista.tms.model.testresult;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ScriptResultsItem {

    @JsonProperty("index")
    private int index;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("status")
    private String status;
}