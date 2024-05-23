package tests.api;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.configs.StageConfig;
import config.configs.WebConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

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
