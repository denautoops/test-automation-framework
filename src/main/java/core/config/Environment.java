package core.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:env/default.properties"})
public interface Environment extends Config {

    @Key("url")
    String url();
}
