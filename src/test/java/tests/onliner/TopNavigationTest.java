package tests.onliner;

import com.google.common.collect.ImmutableList;
import tests.BaseWebTest;
import onliner.web.ui.pages.OnlinerPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Top Navigation Test")
public class TopNavigationTest extends BaseWebTest {

    private static List<String> expectedNavigationItems = ImmutableList
            .of("Каталог", "Новости", "Автобарахолка", "Дома и квартиры", "Услуги", "Барахолка", "Форум");

    @Test
    @DisplayName("Test that the verify all navigations items exist")
    public void navigationItemsExistTest() {
        OnlinerPage onlinerPage = new OnlinerPage();
        List<String> actualNavigationItems = onlinerPage.getAllNavigationItemsText();

        assertThat(actualNavigationItems).isEqualTo(expectedNavigationItems);
    }

    @Test
    @DisplayName("Test that the verify concrete navigation item exist")
    public void concreteNavigationItemExistTest() {
        OnlinerPage onlinerPage = new OnlinerPage();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.CATALOG)).isTrue();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.NEWS)).isTrue();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.AUTO_FLEA_MARKET)).isTrue();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.HOUSES_AND_APARTMENTS)).isTrue();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.SERVICES)).isTrue();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.FLEA_MARKET)).isTrue();
        assertThat(onlinerPage.isNavigationItemExist(OnlinerPage.NavigationItem.FORUM)).isTrue();
    }

    @Test
    @DisplayName("Test that the verify concrete navigation item exist (Soft Assertion).")
    public void softAssertionNavigationItemTest() {
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
