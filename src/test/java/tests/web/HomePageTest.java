package tests.web;


import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.web.HomePage;


@Epic("web")
@Tag("web_test")
@DisplayName("Главная страница")
public class HomePageTest extends BaseWebTest {
    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Проверка заголовка главной страницы")
    void checkTitleTest() {
        homePage.openHomePage()
                .checkTitle("Википедия — свободная энциклопедия");
    }
}
