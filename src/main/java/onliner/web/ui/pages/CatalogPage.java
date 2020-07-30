package onliner.web.ui.pages;

import com.codeborne.selenide.SelenideElement;
import core.web.ui.BaseWebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage extends BaseWebPage {

    private final static String PAGE_NAME = "Catalog";
    private final static By PAGE_VISIBILITY_LOCATOR = By.cssSelector(".catalog-navigation__title");

    private final static By CATALOG_NAVIGATION_ITEM = By.xpath("//li[@class='catalog-navigation-classifier__item ']");

    public CatalogPage() {
        super(PAGE_NAME, PAGE_VISIBILITY_LOCATOR);
    }

    @Step("Get all catalog navigation items")
    public List<String> getAllNavigationItemsText() {
        return $$(CATALOG_NAVIGATION_ITEM).stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Verification: catalog navigation items contains '{item.value}' item")
    public boolean isNavigationItemExist(CatalogNavigationItem item) {
        List<String> actualItems = $$(CATALOG_NAVIGATION_ITEM).stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
        return actualItems.contains(item.getValue());
    }

    public enum CatalogNavigationItem {

        ELECTRONICS("Электроника"),
        COMPUTERS_AND_NETWORKS("Компьютеры и сети"),
        HOUSEHOLD_APPLIANCES("Бытовая техника"),
        CONSTRUCTION_AND_REPAIR("Стройка и ремонт"),
        HOME_AND_GARDEN("Дом и сад"),
        AUTO_AND_MOTORCYCLE("Авто и мото"),
        BEAUTY_AND_SPORTS("Красота и спорт"),
        FOR_CHILDREN_AND_MOTHERS("Детям и мамам"),
        WORK_AND_OFFICE("Работа и офис"),
        FOOD("Еда");

        private String value;

        CatalogNavigationItem(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static List<String> getListOfValues() {
            return Stream.of(CatalogNavigationItem.values())
                    .map(CatalogNavigationItem::getValue)
                    .collect(Collectors.toList());
        }
    }
}
