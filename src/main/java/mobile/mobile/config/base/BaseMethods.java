package mobile.mobile.config.base;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BaseMethods extends Waiters {

    protected void click(By by) {
        middle(by, true, true).click();
    }

    protected void sendKeys(By by, String text) {
        middle(by, true).sendKeys(text);
    }

    protected void clear (By by) {middle(by, true).clear();
    }

    protected String getText(By by) {
        return middle(by, true).getText();
    }

    private WebElement middle(By by, Boolean presence, Boolean clickable) {
        if (presence) presence(by);
        if (clickable) clickable(by);
        return driver.findElement(by);
    }

    private WebElement middle(By by, Boolean presence) {
        if (presence) presence(by);
        return driver.findElement(by);
    }
    protected void swipeUp(int time) {
        Dimension dimension = driver.manage().window().getSize();

        int x = dimension.width / 2;

        int start = (int) (dimension.height * 0.8);
        int end = (int) (dimension.height * 0.2);

        new TouchAction<>(driver)
                .press(point(x, start))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(time)))
                .moveTo(point(x, end))
                .release().perform();

    }

    protected void swipeDown(int time) {
        Dimension dimension = driver.manage().window().getSize();

        int x = dimension.width / 2;

        int start = (int) (dimension.height * 0.2);
        int end = (int) (dimension.height * 0.8);

        new TouchAction<>(driver)
                .press(point(x, start))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(time)))
                .moveTo(point(x, end))
                .release().perform();
    }

    protected void swipeElementLeft(By by, int time) {
        WebElement element = middle(by, true);
//
//        int startX = element.getLocation().getX() + element.getSize().getWidth() / 2;
//        int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;
//        int endX = startX - 100;
//
//        new TouchAction<>(driver)
//                .press(point(startX, startY))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(time)))
//                .moveTo(point(endX, startY))
//                .release().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void swipeElementRight(By by, int time) {
        WebElement element = middle(by, true);

        int startX = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;
        int endX = startX + 100;

        new TouchAction<>(driver)
                .press(point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(time)))
                .moveTo(point(endX, startY))
                .release().perform();
    }

    protected void swipeToElement(By by, int time) {

        while (!(isElementVisible(by))) {
            Dimension dimension = driver.manage().window().getSize();

            int x = dimension.width / 2;

            int start = (int) (dimension.height * 0.8);
            int end = (int) (dimension.height * 0.2);

            new TouchAction<>(driver)
                    .press(point(x, start))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(time)))
                    .moveTo(point(x, end))
                    .release().perform();
        }
    }

    private boolean isElementVisible(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void getPhotoFromArticle(By by) {
        WebElement element = middle(by, true);

        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage screenshotImage = ImageIO.read(screenshotFile);

            Point location = element.getLocation();
            int width = element.getSize().getWidth();
            int height = element.getSize().getHeight();

            BufferedImage elementImage = screenshotImage.getSubimage(location.getX(), location.getY(), width, height);

            File outputFile = new File("article_photo.png");
            ImageIO.write(elementImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private WebElement getElement(By by, Boolean presence, Boolean clickable) {
        if (presence) presence(by);
        if (clickable) clickable(by);
        return driver.findElement(by);
    }

    protected void performSwipe(By by, int startX, int startY, int endX, int endY, int time) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        swipe.addAction(new Pause(finger, Duration.ofMillis(time)));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(time), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(List.of(swipe));
    }







}
