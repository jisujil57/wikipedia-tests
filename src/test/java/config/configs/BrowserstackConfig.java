package config;

import org.aeonbits.owner.Config;

public interface BrowserStackConfig extends Config {
    @Key("platform")
    String platform();

    @Key("browserstack.url")
    String browserstackUrl();

    @Key("browserstack.username")
    String username();

    @Key("browserstack.accessKey")
    String accessKey();
}

