package core.test;

import com.codeborne.selenide.Configuration;
import core.config.ConfigurationManager;
import core.config.SelenideConfig;
import core.test.extentions.CallbackExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(CallbackExtension.class)
public abstract class BaseWebTest {

    protected SelenideConfig configuration = ConfigurationManager.getSelenideConfig();

    @BeforeEach
    public void preCondition() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;

        Configuration.browser = configuration.browser();
        Configuration.startMaximized = true;
        open("https://www.onliner.by/");
    }

    @AfterEach
    public void postCondition() {

    }

}
