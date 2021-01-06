package com.example.adaptavista.tms.model.testresult;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TestResultRequest {

    @JsonProperty("executedBy")
    private String executedBy;

    @JsonProperty("actualEndDate")
    private String actualEndDate;

    @JsonProperty("customFields")
    private CustomFields customFields;

    @JsonProperty("scriptResults")
    private List<ScriptResultsItem> scriptResults;

    @JsonProperty("assignedTo")
    private String assignedTo;

    @JsonProperty("executionTime")
    private int executionTime;

    @JsonProperty("testCaseKey")
    private String testCaseKey;

    @JsonProperty("projectKey")
    private String projectKey;

    @JsonProperty("environment")
    private String environment;

    @JsonProperty("issueLinks")
    private List<String> issueLinks;

    @JsonProperty("actualStartDate")
    private String actualStartDate;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("status")
    private String status;
}