package tests.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static tests.api.specs.Specifications.requestSpec;
import static tests.api.specs.Specifications.responseSpecOk200;

public class SearchStep {

    @Step("Получение страницы Википедии: {pageTitle}")
    public Response getWikipediaArticles(String pageTitle) {

        return given()
                .spec(requestSpec)
                .when()
                .get(pageTitle)
                .then()
                .spec(responseSpecOk200)
                .extract().response();

    }


}
