package mobile.mobile.po;

import mobile.mobile.config.base.BaseMethods;
import org.openqa.selenium.By;

public class ArticlePage extends BaseMethods {

    private final By firstArticle =
            By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']/android.view.ViewGroup[1]");

    private final By articleName = By.xpath("(//android.widget.TextView[@text='Appium'])[1]");

    private final By articleHeader = By.xpath("//android.view.View[@resource-id=\"Historia\"]");
    private final By cardRead = By.xpath(
            "//android.view.ViewGroup[@resource-id=\"org.wikipedia:id/view_list_card_footer\"]");

    private final By valentineArticle = By.xpath(
            "//android.widget.TextView[@resource-id=\"org.wikipedia:id/view_list_card_item_title\" and @text=\"Valentine's Day\"]");


    public ArticlePage clickFirstArticle() {
        click(firstArticle);
        return new ArticlePage();
    }

    public String getArticleName() {
        return getText(articleName);
    }

    public String getArticleHeader(){
        return getText(articleHeader);
    }

    public ArticlePage clickElementcardRead(){
        click(cardRead);
        return new ArticlePage();
    }
    public ArticlePage clickValentineArticle(){
        click(valentineArticle);
        return new ArticlePage();
    }
}
