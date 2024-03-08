package mobile.test;
import mobile.mobile.config.base.BaseMethods;
import mobile.mobile.po.SkipPage;
import mobile.mobile.services.ArticleService;
import mobile.mobile.services.SearchService;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOne extends BaseMethods {
    @Test
    void shouldBeArticleOpened() {
        new SkipPage().clickSkip();

        new SearchService().searchTest("Appium");

        var article = new ArticleService().getArticleName();

        assertThat(article).as("The article has wrong name").isEqualTo("Appium");
    }

}
