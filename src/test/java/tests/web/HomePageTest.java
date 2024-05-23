package tests.ui;


import config.extensions.UiBaseTestExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Tag("ui_test")
@ExtendWith(UiBaseTestExtension.class)
public class DevTest {
    @Test
    void uiSimpleTest() {
        open("/");
        String title = getWebDriver().getTitle();
        assertEquals("Википедия — свободная энциклопедия", title,
                "Title does not match the expected value");
    }
}
