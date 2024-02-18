package mobile.mobile.services;

import mobile.mobile.po.LanguagePage;

public class LanguageSelectService {

    private final LanguagePage languageSelectPage = new LanguagePage();
    public void spanishClick(){
        languageSelectPage.clickOnSpanish();
    }
}
