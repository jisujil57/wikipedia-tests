package tests.mobile;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.mobile.MobileArticlePage;
import pages.mobile.MobileMainPage;
import pages.mobile.components.MobileSearchBarComponent;
import pages.mobile.components.MobileSearchSuggestionsComponent;

@Epic("mobile")
@DisplayName("Успешный поиск статьи")
@Tag("mobile_test")
public class AndroidTests extends BaseMobileTest {
    MobileMainPage mobileMainPage = new MobileMainPage();
    MobileSearchBarComponent mobileSearchBarComponent = new MobileSearchBarComponent();
    MobileSearchSuggestionsComponent mobileSearchSuggestionsComponent = new MobileSearchSuggestionsComponent();
    MobileArticlePage mobileArticlePage = new MobileArticlePage();

    @Test
    @DisplayName("Успешный поиск статьи")
    @Tag("android")
    void successfulSearchTest() {
        mobileMainPage.skipWizard();
        mobileMainPage.clickSearchWikipedia();
        mobileSearchBarComponent.enterSearchText("Gradle");
        mobileSearchSuggestionsComponent.checkSuggestionsSize();
    }

    @Test
    @DisplayName("Проверка открытия страницы с статьей")
    @Tag("android")
    void errorWhenOpeningArticleTest() {
        mobileMainPage.skipWizard();
        mobileMainPage.clickSearchWikipedia();
        mobileSearchBarComponent.enterSearchText("Paris");
        mobileSearchSuggestionsComponent.clickSuggestionWithText("Capital and largest city of France");
        mobileArticlePage.checkArticleText(", as well as its early and extensive system of street lighting, in the 19th century, it became known as the City of Light.");
    }
}
