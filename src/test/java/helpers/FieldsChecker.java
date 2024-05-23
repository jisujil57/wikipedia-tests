package api.helpers.utils;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class FieldsChecker {

    @Step("Проверка поля: \"{fieldName}\" c ожидаемым значением: \"{expectedValue}\"")
    public void checkField(String expectedValue, String actualValue, String fieldName) {
        Assertions.assertEquals(expectedValue, actualValue, "Значение поля " + fieldName + " некорректно");
    }
}
