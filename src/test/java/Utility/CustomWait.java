package Utility;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CustomWait {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    public CustomWait(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(this.driver);
        wait.withTimeout(Duration.ofMillis(45000));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.ignoring(NoSuchElementException.class);
    }

    public void waitUntilElementIsVisible(By element, String errorText) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, errorText+".png");
            ssHandler.screenshotError();
        }
    }

    public void waitUntilElementIsVisibleAndClickable(By element, String errorText) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, errorText+".png");
            ssHandler.screenshotError();
        }
    }
}
