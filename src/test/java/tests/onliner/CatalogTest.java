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
}
