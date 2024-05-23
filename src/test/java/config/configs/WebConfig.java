package config.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/web/web.properties"
})
public interface WebConfig extends Config {

    @Key("browserName")
    String browser();

    @Key("browser.version")
    int browserVersion();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("executionIsRemote")
    boolean isRemoteExecution();

    @Key("selenoidUrl")
    String selenoidUrl();
}
