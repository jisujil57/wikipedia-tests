package pages.mobile.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class SearchSuggestions {
    @Step("Проверяем, что список подсказок не пуст")
    public void checkSuggestionsSize() {
        $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Step("Кликаем по элементу списка с текстом '{text}'")
    public void clickSuggestionWithText(String text) {
        $$(id("org.wikipedia.alpha:id/page_list_item_description"))
                .findBy(Condition.text(text))
                .click();
    }
}
