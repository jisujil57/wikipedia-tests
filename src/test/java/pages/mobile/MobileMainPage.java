package pages.mobile;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.configs.MobileConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class MobileMainPage {
    private final SelenideElement searchWikipediaButton = $(accessibilityId("Search Wikipedia"));
    MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());

    @Step("Нажимаем на кнопку поиска Wikipedia")
    public void clickSearchWikipedia() {
        searchWikipediaButton.click();
    }

    @Step("Пропускаем визард")
    public void skipWizard() {
            Selenide.back();
    }
}
