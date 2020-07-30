package core.test.extentions;

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
        Configuration.browser = selenideProperties.browser();
        Configuration.timeout = selenideProperties.timeout();
        Configuration.headless = selenideProperties.headless();
        Configuration.startMaximized = true;
    }
}
