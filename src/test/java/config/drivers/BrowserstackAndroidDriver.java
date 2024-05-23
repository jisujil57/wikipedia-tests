package config.drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.configs.BrowserstackAndroidConfig;
import config.configs.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserstackAndroidDriver implements WebDriverProvider {

    BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    BrowserstackAndroidConfig browserstackAndroidConfig = ConfigFactory.create(BrowserstackAndroidConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities caps = new DesiredCapabilities();
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setPlatformVersion(browserstackAndroidConfig.deviceVersion());
        options.setDeviceName(browserstackAndroidConfig.deviceName());
        options.setApp(browserstackAndroidConfig.appUrl());

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