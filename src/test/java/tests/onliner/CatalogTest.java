package tests.onliner;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import onliner.web.ui.pages.CatalogPage;
import onliner.web.ui.pages.OnlinerPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseWebTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Catalog Test")
public class CatalogTest extends BaseWebTest {

    @Test
    @Tag("all")
    @Tag("catalog")
    @Feature(value = "Catalog")
    @Link(value = "Link to Test Case")
    @DisplayName("Test that the verify all catalog navigations items exist")
    public void catalogNavigationItemsExistTest() {
        OnlinerPage onlinerPage = new OnlinerPage();
        onlinerPage.navigateTo(OnlinerPage.NavigationItem.CATALOG);

        CatalogPage catalogPage = new CatalogPage();
        List<String> actualNavigationItems = catalogPage.getAllNavigationItemsText();

        assertThat(actualNavigationItems).isEqualTo(CatalogPage.CatalogNavigationItem.getListOfValues());
    }

    @Test
    @Tag("all")
    @Tag("negative")
    @Feature(value = "Catalog")
    @Link(value = "Link to Test Case")
    @DisplayName("Test that the verify specific category navigation item exist. Negative")
    public void specificNavigationItemExistTest() {
        OnlinerPage onlinerPage = new OnlinerPage();
        onlinerPage.navigateTo(OnlinerPage.NavigationItem.CATALOG);

        CatalogPage catalogPage = new CatalogPage();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.ELECTRONICS)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.COMPUTERS_AND_NETWORKS)).isFalse();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.HOUSEHOLD_APPLIANCES)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.CONSTRUCTION_AND_REPAIR)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.HOME_AND_GARDEN)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.AUTO_AND_MOTORCYCLE)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.BEAUTY_AND_SPORTS)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.FOR_CHILDREN_AND_MOTHERS)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.WORK_AND_OFFICE)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.FOOD)).isTrue();
    }

    @Test
    @Tag("all")
    @Tag("negative")
    @Feature(value = "Catalog")
    @Link(value = "Link to Test Case")
    @DisplayName("Test that the verify specific category navigation item exist (Soft Assertion). Negative")
    public void softAssertionSpecificNavigationItemExistTest() {
        OnlinerPage onlinerPage = new OnlinerPage();
        onlinerPage.navigateTo(OnlinerPage.NavigationItem.CATALOG);

        CatalogPage catalogPage = new CatalogPage();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.ELECTRONICS)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.COMPUTERS_AND_NETWORKS)).isFalse();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.HOUSEHOLD_APPLIANCES)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.CONSTRUCTION_AND_REPAIR)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.HOME_AND_GARDEN)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.AUTO_AND_MOTORCYCLE)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.BEAUTY_AND_SPORTS)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.FOR_CHILDREN_AND_MOTHERS)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.WORK_AND_OFFICE)).isTrue();
        assertThat(catalogPage.isNavigationItemExist(CatalogPage.CatalogNavigationItem.FOOD)).isTrue();
    }
}
