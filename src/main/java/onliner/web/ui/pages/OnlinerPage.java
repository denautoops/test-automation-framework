package onliner.web.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.ImmutableList;
import core.web.ui.BaseWebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Step("Verification: top navigation items contains '{item}' item")
    public boolean isNavigationItemExist(NavigationItem item) {
        List<String> actualItems = $$(NAVIGATION_ITEM).stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
        return actualItems.contains(item.getValue());
    }

    public enum NavigationItem {
        CATALOG("Каталог"),
        NEWS("Новости"),
        AUTO_FLEA_MARKET("Автобарахолка"),
        HOUSES_AND_APARTMENTS("Дома и квартиры"),
        SERVICES("Услуги"),
        FLEA_MARKET("Барахолка"),
        FORUM("Форум");

        private String value;

        NavigationItem(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public List<String> getListOfValues() {
            return Stream.of(NavigationItem.values())
                    .map(NavigationItem::getValue)
                    .collect(Collectors.toList());
        }
    }
}
