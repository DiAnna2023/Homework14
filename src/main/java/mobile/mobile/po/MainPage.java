package mobile.mobile.po;

import mobile.mobile.config.base.BaseMethods;
import org.openqa.selenium.By;

public class MainPage extends BaseMethods {

    private final By topRead = By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/view_card_header_title\" and @text=\"In the news\"]");
    private final By cardRead = By.xpath(
            "//android.view.ViewGroup[@resource-id=\"org.wikipedia:id/view_list_card_footer\"]");

    public void swipeUpOnPage(int time) {
        swipeUp(time);
    }

    public void swipeDownOnPage(int time) {
        swipeDown(time);
    }

    public void swipeToElementTo() {
        swipeToElement(topRead, 10000);
    }

    public void scrollToElementCardRead(){
        swipeToElement ( cardRead, 700);
    }
}
