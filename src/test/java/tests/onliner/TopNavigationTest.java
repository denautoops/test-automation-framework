package tests.onliner;

import com.google.common.collect.ImmutableList;
import core.test.BaseWebTest;
import onliner.web.ui.OnlinerPage;
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

}
