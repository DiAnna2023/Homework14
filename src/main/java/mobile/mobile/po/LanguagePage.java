package mobile.mobile.po;

import mobile.mobile.config.base.BaseMethods;
import org.openqa.selenium.By;

public class LanguagePage extends BaseMethods {
    private final By spanishLang = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.wikipedia:id/langlinks_recycler\"]/android.widget.LinearLayout[2] ");
    public SearchPage clickOnSpanish(){
        click(spanishLang);
        return new SearchPage();
    }
}
