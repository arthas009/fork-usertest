package POM;

import Utility.ScreenshotHandler;
import Utility.YamlReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

/**
 * HomePage
 * This class is used to keep functions and locators about web elements about main page
 * It also has a default Fluent wait which is used by itself and child classes to wait elements to be visible.
 * Fluent wait has 45 second timeout and polls every second
 */
public class HomePage {
    protected WebDriver driver;
    protected String test_output_directory;
    By cookieAcceptButton = By.id("_evidon-accept-button");
    FluentWait<WebDriver> wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(this.driver);
        wait.withTimeout(Duration.ofMillis(45000));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.ignoring(NoSuchElementException.class);

        test_output_directory = YamlReader.getVariable("TEST_OUTPUT_DIRECTORY");
    }

    /**
     * acceptCookie
     * Clicks on accept button when Accept Cookie window is shown
     */
    public void acceptCookie() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookieAcceptButton));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "cookieButtonNotFound");
            ssHandler.screenshotError();
            return;
        }
        driver.findElement(cookieAcceptButton).click();
    }
}
