package pages.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class ArticlePage {
    private final SelenideElement articleText = $(xpath("//android.view.View[@text=\", as well as its early and extensive system of street lighting, in the 19th century, it became known as the City of Light.\"]"));

    @Step("Проверяем наличие текста в статье")
    public void checkArticleText(String expectedText) {
        articleText.shouldHave(Condition.text(expectedText));
    }
}
