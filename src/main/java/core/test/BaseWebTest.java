package core.test;

import com.codeborne.selenide.Configuration;
import core.config.ConfigurationManager;
import core.config.SelenideConfig;
import core.test.extentions.CallbackExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(CallbackExtension.class)
public abstract class BaseWebTest {

    protected SelenideConfig configuration = ConfigurationManager.getSelenideConfig();

    @BeforeEach
    public void preCondition() {
        Configuration.browser = configuration.browser();
        Configuration.startMaximized = true;
        open("https://www.onliner.by/");
    }

    @AfterEach
    public void postCondition() {

    }

}
