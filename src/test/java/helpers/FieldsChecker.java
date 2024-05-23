package helpers;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class FieldsChecker {

    @Step("Проверка поля: \"{fieldName}\" c ожидаемым значением: \"{expectedValue}\"")
    public void checkField(String expectedValue, String actualValue, String fieldName) {
        Assertions.assertEquals(expectedValue, actualValue, "Значение поля " + fieldName + " некорректно");
    }

    @Step("Проверка что текст содержит значение: {expectedText}")
    public void checkContainsText(String expectedText, String actualValue) {
        assertThat(actualValue, containsString(expectedText));
    }

}
