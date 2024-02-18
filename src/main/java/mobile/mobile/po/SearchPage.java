package mobile.mobile.po;

import mobile.mobile.config.base.BaseMethods;
import org.openqa.selenium.By;

public class SearchPage extends BaseMethods {

    private final By search = By.xpath("//*[@text='Search Wikipedia']");
    private final By input = By.id("org.wikipedia:id/search_src_text");

    private final By language = By.xpath("//android.widget.TextView[@content-desc=\"Language\"]");

    public SearchPage clickOnSearchField() {
        click(search);
        return new SearchPage();
    }

    public SearchPage fillInput(String text) {
        sendKeys(input, text);
        return new SearchPage();
    }
    public SearchPage clickOnLanguageButton(){
        click(language);
        return new SearchPage();
    }

}
