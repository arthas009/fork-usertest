package POM;

import Utility.ScreenshotHandler;
import Utility.YamlReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.IOException;
import java.time.Duration;

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

    public void acceptCookie() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookieAcceptButton));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "cookieButtonNotFound");
            try {
                ssHandler.screenshotError();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return;
        }
        driver.findElement(cookieAcceptButton).click();
    }
}
