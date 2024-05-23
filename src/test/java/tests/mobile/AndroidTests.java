package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.MainPage;
import pages.components.SearchBar;
import pages.components.SearchSuggestions;

import static io.appium.java_client.AppiumBy.id;

public class AndroidTests extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchBar searchBar = new SearchBar();
    SearchSuggestions searchSuggestions = new SearchSuggestions();
    ArticlePage articlePage = new ArticlePage();

    @Test
    @DisplayName("Успешный поиск статьи")
    @Tag("android")
    void successfulSearchTest() {
        mainPage.slipWizard();
        mainPage.clickSearchWikipedia();
        searchBar.enterSearchText("Gradle");
        searchSuggestions.checkSuggestionsSize();
    }

    @Test
    @DisplayName("Проверка открытия страницы с статьей")
    @Tag("android")
    void errorWhenOpeningArticleTest() {
        mainPage.slipWizard();
        mainPage.clickSearchWikipedia();
        searchBar.enterSearchText("Paris");
        searchSuggestions.clickSuggestionWithText("Capital and largest city of France");
        articlePage.checkArticleText(", as well as its early and extensive system of street lighting, in the 19th century, it became known as the City of Light.");
    }
}
