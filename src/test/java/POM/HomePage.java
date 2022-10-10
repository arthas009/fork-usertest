package POM;

import Utility.CustomFirefoxDriver;
import Utility.CustomWait;
import Utility.ScreenshotHandler;
import Utility.YamlReader;
import org.checkerframework.checker.units.qual.C;
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
    protected CustomWait customWait;
    By cookieAcceptButton = By.id("_evidon-accept-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        customWait = new CustomWait(driver);

        test_output_directory = YamlReader.getVariable("TEST_OUTPUT_DIRECTORY");
    }

    /**
     * acceptCookie
     * Clicks on accept button when Accept Cookie window is shown
     */
    public void acceptCookie() {
        customWait.waitUntilElementIsVisible(cookieAcceptButton,"cookieAcceptButton");
        driver.findElement(cookieAcceptButton).click();
    }
}
