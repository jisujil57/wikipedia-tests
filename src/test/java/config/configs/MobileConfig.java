package config.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/mobile/mobile.properties"
})
public interface MobileConfig extends Config {
    @Key("execution.platform")
    @DefaultValue("browserstack")
    String executionPlatform();
}
