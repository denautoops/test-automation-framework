package onliner.web.ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.web.ui.BaseWebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class OnlinerPage extends BaseWebPage {

    private final static String PAGE_NAME = "Onliner";
    private final static By PAGE_VISIBILITY_LOCATOR = By.cssSelector(".b-tiles-outer");

    private final static By NAVIGATION_ITEM = By.cssSelector(".b-main-navigation__item");

    public OnlinerPage() {
        super(PAGE_NAME, PAGE_VISIBILITY_LOCATOR);
    }

    @Step("Get all navigation items")
    public List<String> getAllNavigationItemsText() {
        return $$(NAVIGATION_ITEM).stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }
}
