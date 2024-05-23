package tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.configs.StageConfig;
import config.configs.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class BaseWebTest {
    public static String BROWSER_NAME;
    public static float BROWSER_VERSION;
    public static String BROWSER_SIZE;
    public static boolean IS_REMOTE_EXECUTION;
    public static String SELENOID_URL;
    public static String BASE_URL;

    @BeforeAll
    static void beforeAll() {
        WebConfig webConfig = ConfigFactory.create(WebConfig.class);
        StageConfig stageConfig = ConfigFactory.create(StageConfig.class);

        BROWSER_NAME = webConfig.browserName();
        BROWSER_VERSION = webConfig.browserVersion();
        BROWSER_SIZE = webConfig.browserSize();
        IS_REMOTE_EXECUTION = webConfig.isRemoteExecution();
        SELENOID_URL = webConfig.selenoidUrl();
        BASE_URL = stageConfig.baseUrl();

        setupSelenide();
        printUiConfig();
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageWebSource();
        Attach.browserConsoleLogs();
        Attach.addSelenoidVideo();

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    private static void setupSelenide() {
        Configuration.browser = BROWSER_NAME;
        Configuration.browserSize = BROWSER_SIZE;
        Configuration.baseUrl = BASE_URL;
        Configuration.pageLoadStrategy = "eager";

        if (IS_REMOTE_EXECUTION) {
            Configuration.remote = SELENOID_URL;
            Configuration.browserVersion = String.valueOf(BROWSER_VERSION);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true));

            Configuration.browserCapabilities = capabilities;
        }
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    private static void printUiConfig() {
        System.out.println("RUN UI TESTS");
        System.out.printf("Base URL:         %s%n", BASE_URL);
        System.out.printf("Browser name:     %s%n", BROWSER_NAME);
        System.out.printf("Browser version: %.2f%n", BROWSER_VERSION);
        System.out.printf("Browser size:     %s%n", BROWSER_SIZE);
        System.out.printf("Selenoid URL:     %s%n", SELENOID_URL);
        System.out.printf("Remote:           %s%n", IS_REMOTE_EXECUTION ? "Yes" : "No");
    }
}
