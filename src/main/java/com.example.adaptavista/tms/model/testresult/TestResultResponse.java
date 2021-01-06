package com.example.adaptavista.tms.model.testresult;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TestResultResponse {

    @JsonProperty("id")
    private int id;

    public int getId() {
        return id;
    }
}