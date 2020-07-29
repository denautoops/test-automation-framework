package core.config;

import org.aeonbits.owner.ConfigCache;

public final class ConfigurationManager {

    private ConfigurationManager() {
    }

    public static SelenideConfig getSelenideConfig() {
        return ConfigCache.getOrCreate(SelenideConfig.class);
    }
}
