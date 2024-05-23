package config.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/mobile/browserstack/ios.properties"
})
public interface BrowserstackIosConfig extends Config {

    @Key("emulator.url")
    String emulatorUrl();
    @Key("device.name")
    String deviceName();
    @Key("device.version")
    String deviceVersion();
    @Key("app.url")
    String appUrl();
}