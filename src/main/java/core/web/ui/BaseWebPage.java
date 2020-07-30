package core.web.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.SelenidePageFactory;
import core.config.ConfigurationManager;
import core.config.SelenideProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public abstract class BaseWebPage {

    private static final long PAGE_TIMEOUT = ConfigurationManager.getSelenideProperties().waitTimeoutPage();

    private String pageName;
    private By locator;

    public BaseWebPage(final String pageName, final By locator) {
        this.pageName = pageName;
        this.locator = locator;
        waitForVisibility(locator, PAGE_TIMEOUT);
    }

    public String getPageName() {
        return pageName;
    }

    public By getLocator() {
        return locator;
    }

    public void waitForVisibility(final By locator, final long timeout) {
        $(locator).waitUntil(Condition.appear, timeout);
    }
}
