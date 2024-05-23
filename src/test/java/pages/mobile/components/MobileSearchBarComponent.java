package pages.mobile.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class MobileSearchBarComponent {
    private final SelenideElement searchInput = $(id("org.wikipedia.alpha:id/search_src_text"));

    @Step("Вводим текст в поисковую строку")
    public void enterSearchText(String text) {
        searchInput.sendKeys(text);
    }
}