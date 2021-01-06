# adpatavista-integration

sample project with junit tests attaching test execution results to testcases in adaptavista

## PREREQUISITES

* adpatavista plugin is installed on your jira instance
* testcase e.g.: GAUT-T2 exists

# How it works

When you mark test method with allure annotation @TmsLink("GAUT-T2"), After the test execution
AdaptavistaWatcherExtension finds the testcase with id: GAUT-T2 in Jira and attaches execution record with PASS/FAIL
result.

## How to run

```
export TMS_ROOT_URL="https://company.com/jira/rest/atm/1.0"
export TMS_USER="jiraUser"
export TMS_PASS="jiraPassword"
mvn -B clean test
```