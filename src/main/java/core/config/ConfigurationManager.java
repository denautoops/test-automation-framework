package core.config;

import org.aeonbits.owner.ConfigCache;

public final class ConfigurationManager {

    private ConfigurationManager() {
    }

    public static SelenideProperties getSelenideProperties() {
        return ConfigCache.getOrCreate(SelenideProperties.class);
    }

    public static Environment getEnvironment() {
        return ConfigCache.getOrCreate(Environment.class);
    }
}
