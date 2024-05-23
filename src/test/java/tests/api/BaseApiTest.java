package tests.api;

import config.configs.StageConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

import static tests.web.BaseWebTest.BASE_URL;

public class BaseApiTest {
    @BeforeAll
    static void beforeAll() {
        StageConfig stageConfig = ConfigFactory.create(StageConfig.class);
        BASE_URL = stageConfig.baseUrl();
        printApiConfig();
    }

    private static void printApiConfig() {
        System.out.println("RUN API TESTS");
        System.out.printf("Base URL:         %s%n", BASE_URL);
    }
}
