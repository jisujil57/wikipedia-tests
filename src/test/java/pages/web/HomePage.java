package pages.web;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {

    @AfterEach
    @Step("Открываем главную страницу")
    public HomePage openHomePage() {
        Selenide.open("/");
        return this;
    }

    @Step("Проверяем заголовок страницы")
    public void checkTitle(String title) {
        String actualTitle = getWebDriver().getTitle();
        assertEquals(title, actualTitle,
                "Заголовок страницы не соответствует ожидаемому значению");
    }
}
