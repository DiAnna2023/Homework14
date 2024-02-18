package mobile.test;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static mobile.mobile.config.driver.DriverInit.getDriver;
import static mobile.mobile.config.driver.DriverInit.quit;

public class BaseTest {

    protected static AppiumDriver<WebElement> driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
    }

    @AfterMethod
    public void close() {
        quit();
    }
}
