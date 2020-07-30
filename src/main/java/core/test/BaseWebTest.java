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

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(CallbackExtension.class)
public abstract class BaseWebTest {

    protected SelenideConfig configuration = ConfigurationManager.getSelenideConfig();

    @BeforeEach
    public void preCondition() {

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--no-sandbox");
        options.addArguments("--headless"); //should be enabled for Jenkins
        options.addArguments("--disable-dev-shm-usage"); //should be enabled for Jenkins
        options.addArguments("--window-size=1920x1080"); //should be enabled for Jenkins
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;

        Configuration.browser = configuration.browser();
        open("https://www.onliner.by/");
    }

    @AfterEach
    public void postCondition() {

    }

}
