package tests.api;


import helpers.FieldsChecker;
import io.qameta.allure.Epic;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.steps.SearchStep;

@Epic("api")
@Tag("api_test")
@DisplayName("Поиск статьи")
public class WikipediaApiTest extends BaseApiTest {

    SearchStep searchStep = new SearchStep();
    FieldsChecker fieldsChecker = new FieldsChecker();

    @Test
    @Tag("api_test")
    @DisplayName("Проверка получения статьи по поисковому запросу")
    public void testGetWikipediaPage() {
        String pageTitle = "Синистер_2";

        Response response = searchStep.getWikipediaArticles(pageTitle);
        String responseBody = response.getBody().asString();

        fieldsChecker.checkContainsText("<title>Синистер 2 — Википедия</title>", responseBody);
        fieldsChecker.checkContainsText("Бывший помощник шерифа из первого фильма", responseBody);
        fieldsChecker.checkContainsText("Скотт Дерриксон", responseBody);
    }
}
