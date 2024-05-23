package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.configs.BrowserstackConfig;
import config.configs.MobileConfig;
import config.drivers.BrowserstackAndroidDriver;
import config.drivers.BrowserstackIOSDriver;
import config.drivers.EmulatorAndroidDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseMobileTest {
    static MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());
    static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {

        if (Objects.equals(mobileConfig.executionPlatform(), "browserstack")) {
            if (Objects.equals(browserstackConfig.platform(), "android")) {
                Configuration.browser = BrowserstackAndroidDriver.class.getName();
            } else {
                Configuration.browser = BrowserstackIOSDriver.class.getName();
            }
        } else {
            Configuration.browser = EmulatorAndroidDriver.class.getName();
        }

        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void afterEach() {
        String sessionId = Selenide.sessionId().toString();
        Attach.pageMobileSource();

        closeWebDriver();
        if (Objects.equals(mobileConfig.executionPlatform(), "browserstack")) {
            Attach.addBrowserstackVideo(sessionId);
        }
    }
}
