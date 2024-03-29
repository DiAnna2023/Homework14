package mobile.mobile.services;

import mobile.mobile.config.base.BaseMethods;
import mobile.mobile.config.builders.LoginCredentials;
import mobile.mobile.po.LoginPage;

public class LoginService extends BaseMethods {

    private final LoginPage loginPage = new LoginPage();

    public void clickLoginButtons() {
        loginPage.clickMoreButton()
                .clickLoginJoinButton()
                .clickLoginButton();
    }

    public void performLogin(LoginCredentials credentials) {
        loginPage.userCredentials(credentials.getUsername(), credentials.getPassword());
        loginPage.clickMainLoginButton();

    }
    public String getWatchList(){
        return loginPage
                .clickMoreButton()
                .getWatchList();
    }
}
