package tests.web;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.web.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Tag("web_test")
@DisplayName("Главная страница")
public class HomePageTest extends BaseWebTest{
    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Проверка заголовка главной страницы")
    void checkTitleTest() {
        homePage.openHomePage()
                .checkTitle("Википедия — свободная энциклопедия");
    }
}
