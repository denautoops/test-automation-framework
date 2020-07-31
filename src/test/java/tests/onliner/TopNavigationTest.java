package tests.onliner;

import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import onliner.web.ui.pages.OnlinerPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseWebTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Top Navigation Test")
public class TopNavigationTest extends BaseWebTest {

    @Test
    @Tag("all")
    @Tag("navigation")
    @Feature(value = "Menu Navigation")
    @Link(value = "Link to Test Case")
    @DisplayName("Test that the verify all navigations items exist")
    public void navigationItemsExistTest() {
        OnlinerPage onlinerPage = new OnlinerPage();
        List<String> actualNavigationItems = onlinerPage.getAllNavigationItemsText();

        assertThat(actualNavigationItems).isEqualTo(OnlinerPage.NavigationItem.getListOfValues());
    }

    @Test
    @Tag("all")
    @Tag("negative")
    @Feature(value = "Menu Navigation")
    @Link(value = "Link to Test Case")
    @DisplayName("Test that the verify specific navigation item exist. Negative")
    public void specificNavigationItemExistTest() {
        OnlinerPage onlinerPage = new OnlinerPage();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.CATALOG)).isTrue();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.NEWS)).isFalse();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.AUTO_FLEA_MARKET)).isTrue();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.HOUSES_AND_APARTMENTS)).isTrue();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.SERVICES)).isTrue();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.FLEA_MARKET)).isTrue();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.FORUM)).isTrue();
    }

    @Test
    @Tag("all")
    @Tag("negative")
    @Feature(value = "Menu Navigation")
    @Issue(value = "123456")
    @Link(value = "Link to Test Case")
    @DisplayName("Test that the verify concrete navigation item exist (Soft Assertion). Negative")
    public void softAssertionSpecificNavigationItemExistTest() {
        OnlinerPage onlinerPage = new OnlinerPage();
        softly.assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.CATALOG)).isTrue();
        softly.assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.NEWS)).isFalse();
        softly.assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.AUTO_FLEA_MARKET)).isTrue();
        softly.assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.HOUSES_AND_APARTMENTS)).isTrue();
        softly.assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.SERVICES)).isTrue();
        softly.assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.FLEA_MARKET)).isTrue();
        softly.assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.FORUM)).isTrue();
    }

}
