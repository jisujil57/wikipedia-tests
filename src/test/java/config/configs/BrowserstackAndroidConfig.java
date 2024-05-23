package config.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/mobile/browserstack/android.properties"
})
public interface BrowserstackAndroidConfig extends Config {

    @Key("emulator.url")
    String emulatorUrl();
    @Key("device.name")
    String deviceName();
    @Key("device.os_version")
    String deviceVersion();
    @Key("app.url")
    String appUrl();
}
