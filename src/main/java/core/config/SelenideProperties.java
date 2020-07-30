package core.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:selenide.properties"})
public interface SelenideProperties extends Config {

    @Key("timeout")
    long timeout();

    @Key("browser")
    String browser();

    @Key("headless")
    boolean headless();

    @Key("wait.timeout.page")
    long waitTimeoutPage();
}
