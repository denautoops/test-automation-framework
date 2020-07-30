package core.test.extentions;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.config.ConfigurationManager;
import core.config.Environment;
import core.config.SelenideProperties;
import core.report.AllureManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

public class CallbackExtension implements AfterEachCallback, BeforeEachCallback, BeforeAllCallback {

    private SelenideProperties selenideProperties = ConfigurationManager.getSelenideProperties();
    private Environment environment = ConfigurationManager.getEnvironment();

    @Override
    public void beforeAll(ExtensionContext context) {
        prepareSelenideConfig();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        open(environment.url());
    }

    @Override
    public void afterEach(ExtensionContext context) {
        AllureManager.takeScreenshotToAttachOnAllureReport();

    }

    public void prepareSelenideConfig() {
        if (selenideProperties.browser().equals(Browsers.CHROME)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1920x1080");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            Configuration.browserCapabilities = capabilities;
        }

        Configuration.browser = selenideProperties.browser();
        Configuration.startMaximized = true;
        Configuration.timeout = selenideProperties.timeout();
        Configuration.headless = selenideProperties.headless();
    }
}
