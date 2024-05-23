package config.drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.configs.BrowserstackConfig;
import config.configs.BrowserstackIosConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserstackIOSDriver implements WebDriverProvider {

    BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    BrowserstackIosConfig browserstackIosConfig = ConfigFactory.create(BrowserstackIosConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities caps = new DesiredCapabilities();

        XCUITestOptions options = new XCUITestOptions();

        options.setPlatformName("iOS");
        options.setPlatformVersion(browserstackIosConfig.deviceVersion());
        options.setDeviceName(browserstackIosConfig.deviceName());
        options.setApp(browserstackIosConfig.appUrl());

        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("projectName", "BrowserStack Sample");
        browserstackOptions.put("buildName", "bstack-demo");
        browserstackOptions.put("sessionName", "first_test");
        browserstackOptions.put("userName", browserstackConfig.username());
        browserstackOptions.put("accessKey", browserstackConfig.accessKey());

        caps.setCapability("bstack:options", browserstackOptions);

        try {
            return new AndroidDriver(new URL("https://" + browserstackConfig.username() + ":" + browserstackConfig.accessKey() + "@hub.browserstack.com/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
