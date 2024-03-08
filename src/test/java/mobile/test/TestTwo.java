package mobile.test;

import mobile.mobile.config.base.BaseMethods;
import mobile.mobile.po.ListSavedArticlePage;
import mobile.mobile.po.SavePage;
import mobile.mobile.po.SkipPage;
import mobile.mobile.services.ArticleService;
import mobile.mobile.services.ListSavedArticleService;
import org.testng.annotations.Test;

public class TestTwo extends BaseMethods {

    @Test
    void shouldBeListDeleted(){
        new SkipPage().clickSkip();
        new ArticleService().goToArticle();
        new ArticleService().saveImage();
        new SavePage().clickSaveButton();
        new ListSavedArticleService()
                .addToListArticle("MyList");
        new ListSavedArticlePage()
                .swipeElementRight(150);
        new ArticleService().deleteList();
    }
}
