package com.example.adaptavista;

import io.qameta.allure.TmsLink;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Slf4j
@ExtendWith({AdaptavistaWatcherExtension.class})
public class AdaptavistaTest {

    @Test
    @TmsLink("GAUT-T2")
    void checkExtensionPass() {
        log.info("checkExtensionPass");
    }

    @Test
    @TmsLink("GAUT-T2")
    void checkExtensionFail() {
        log.info("checkExtensionFail");
        throw new RuntimeException("check failed result is logged in adaptavista");
    }

    @Test
    void checkExtensionNoTmsLink() {
        log.info("checkExtensionNoTmsLink");
    }
}
