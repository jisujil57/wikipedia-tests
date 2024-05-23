package pages.mobile;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static tests.BaseTest.EXECUTION_TYPE;

public class MainPage {
    private final SelenideElement searchWikipediaButton = $(accessibilityId("Search Wikipedia"));

    @Step("Нажимаем на кнопку поиска Wikipedia")
    public void clickSearchWikipedia() {
        searchWikipediaButton.click();
    }

    @Step("Пропускаем визард")
    public void slipWizard() {
        if (!Objects.equals(EXECUTION_TYPE, "browserstack")) {
            Selenide.back();
        }
    }
}
