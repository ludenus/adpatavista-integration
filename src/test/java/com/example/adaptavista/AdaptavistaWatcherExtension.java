package com.example.adaptavista;

import com.example.adaptavista.tms.TmsClient;
import com.example.adaptavista.tms.TmsConfig;
import io.qameta.allure.TmsLink;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

@Slf4j
public class AdaptavistaWatcherExtension implements TestWatcher {

    // TODO: is there a way to inject spring config into jupiter extension?

    @Getter(lazy = true)
    private final TmsClient tmsClient = new TmsClient(TmsConfig.fromEnv());

    @Override
    public void testSuccessful(ExtensionContext context) {
        try {
            var testCaseId = resolveTestCaseId(context);
            var resultId = getTmsClient().postTestResultSuccess(testCaseId);
            log.info("attached test result {} to test case {}", resultId, testCaseId);
        } catch (Exception e) {
            log.info("failed to submit test result to tms {}", e.getMessage());
        }

    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        log.info("testDisabled");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        log.info("testAborted");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        try {
            var testCaseId = resolveTestCaseId(context);
            var resultId = getTmsClient().postTestResultFailure(testCaseId);
            log.info("attached test result {} to test case {}", resultId, testCaseId);
        } catch (Exception e) {
            log.info("failed to submit test result to tms {}", e.getMessage());
        }
    }

    private String resolveTestCaseId(ExtensionContext context) {
        var annotation = context.getTestMethod().get().getAnnotation(TmsLink.class);
        return annotation.value();
    }
}
