package core.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:selenide.properties"})
public interface SelenideConfig extends Config {

    @Key("selenide.timeout")
    String selenideTimeout();

    @Key("wait.pageTimeout")
    String waitPageTimeout();

    @Key("wait.smallConditionTimeout")
    Boolean waitSmallCondition();

    @Key("polling.timeout")
    String pollingTimeout();

    @Key("log.selenide.verbose")
    String logSelenideVerbose();

    @Key("log.selenide.to.allure.verbose")
    String logSelenideToAllureVerbose();

    @Key("browser")
    String browser();
}
