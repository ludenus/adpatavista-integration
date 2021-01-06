package com.example.adaptavista.tms;


import com.example.adaptavista.tms.model.testcase.TestCase;
import com.example.adaptavista.tms.model.testresult.TestResultRequest;
import com.example.adaptavista.tms.model.testresult.TestResultResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@RequiredArgsConstructor
public class TmsClient {

    private final TmsConfig cfg;

    private final String testCaseUrl = "/testcase";
    private final String testResultUrl = "/testresult";

    ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(NON_NULL);

    private RequestSpecification tmsRequest() {
        var request = RestAssured
                .given()
                .contentType("application/json")
                .baseUri(cfg.getRootUrl())
                .auth()
                .preemptive()
                .basic(cfg.getUser(), cfg.getPass());

        return request;
    }

    @SneakyThrows
    public TestCase getTestCase(String testCaseId) {
        var response = tmsRequest()
                .when()
                .log().all()
                .get(testCaseUrl + "/" + testCaseId)
                .then()
                .log().all()
                .statusCode(200);

        var bytes = response.extract().asByteArray();
        var testCase = objectMapper.readValue(bytes, TestCase.class);
        return testCase;
    }

    @SneakyThrows
    public int postTestResult(TestResultRequest testResult) {
        var response = tmsRequest()
                // must use custom mapper and explicit body serialization to skip null fields
                // otherwise http 500 error is received
                .body(objectMapper.writeValueAsString(testResult))
                .when()
                .log().all()
                .post(testResultUrl)
                .then()
                .log().all()
                .statusCode(201);

        var bytes = response.extract().asByteArray();
        var resultResponse = objectMapper.readValue(bytes, TestResultResponse.class);
        return resultResponse.getId();
    }

    public int postTestResultSuccess(String testCaseId) {
        return postTestResultStatus(testCaseId, "Pass");
    }

    public int postTestResultFailure(String testCaseId) {
        return postTestResultStatus(testCaseId, "Fail");
    }

    public int postTestResultStatus(String testCaseId, String status) {
        var testCase = getTestCase(testCaseId);
        var projectKey = testCase.getProjectKey();

        var result = new TestResultRequest();
        result.setProjectKey(projectKey);
        result.setTestCaseKey(testCaseId);
        result.setStatus(status);
        result.setComment(new RuntimeInfo().getInfo());
        return postTestResult(result);
    }


}
