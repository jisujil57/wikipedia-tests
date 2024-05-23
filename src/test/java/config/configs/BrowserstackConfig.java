package config.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/mobile/browserstack/browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("platform")
    String platform();

    @Key("browserstack.url")
    String browserstackUrl();

    @Key("browserstack.username")
    String username();

    @Key("browserstack.accessKey")
    String accessKey();
}

