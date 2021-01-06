package com.example.adaptavista.tms.model.testcase;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TestCase {

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("updatedBy")
    private String updatedBy;

    @JsonProperty("updatedOn")
    private String updatedOn;

    @JsonProperty("priority")
    private String priority;

    @JsonProperty("majorVersion")
    private int majorVersion;

    @JsonProperty("createdOn")
    private String createdOn;

    @JsonProperty("projectKey")
    private String projectKey;

    @JsonProperty("createdBy")
    private String createdBy;

    @JsonProperty("latestVersion")
    private boolean latestVersion;

    @JsonProperty("testScript")
    private TestScript testScript;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lastTestResultStatus")
    private String lastTestResultStatus;

    @JsonProperty("parameters")
    private Parameters parameters;

    @JsonProperty("key")
    private String key;

    @JsonProperty("status")
    private String status;

}