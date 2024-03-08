package mobile.test;

import mobile.mobile.config.base.BaseMethods;
import mobile.mobile.config.builders.LoginCredentials;
import mobile.mobile.config.builders.LoginCredentialsBuilder;
import mobile.mobile.po.SkipPage;
import mobile.mobile.services.LoginService;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestThree extends BaseMethods {

    @Test
    void shouldBeLoggedIn(){

        new SkipPage().clickSkip();
        new LoginService().clickLoginButtons();
        LoginCredentials credentials = LoginCredentialsBuilder.fromSystemProperties().build();
        new LoginService().performLogin(credentials);

        var watchList = new LoginService().getWatchList();

        assertThat(watchList).as("Watchlist is visible for logged account").isEqualTo("Watchlist");
    }
}
