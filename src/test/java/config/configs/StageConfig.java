package config.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/stage.properties"
})
public interface StageConfig extends Config{

    @Key("base.url")
    String baseUrl();
}
