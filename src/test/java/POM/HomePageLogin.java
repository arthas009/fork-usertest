package POM;

import Utility.ScreenshotHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class HomePageLogin extends HomePage {
    By logInButton = By.xpath("//button[@data-testid = 'user-space']");
    By emailInput = By.id("identification_email");
    By continueButton = By.xpath("//button[@data-testid = 'checkout-submit-email']");
    By continuePasswordButton = By.xpath("//button[@data-testid = 'submit-password']");
    By passwordInput = By.id("password");

    public HomePageLogin(WebDriver driver) {
        super(driver);
    }

    public void clickLogIn() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(logInButton));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "loginButtonNotFound.png");
            try {
                ssHandler.screenshotError();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        // To avoid stale element exception
        try {
            driver.findElement(logInButton).click();
        } catch (StaleElementReferenceException e) {
            driver.findElement(logInButton).click();
        }
    }

    public void inputEmail(String email) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "emailInputNotFound.png");
            try {
                ssHandler.screenshotError();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        driver.findElement(emailInput).sendKeys(email);
    }

    public void inputPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "passwordInputNotFound.png");
            try {
                ssHandler.screenshotError();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickContinue() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "continueButtonNotFound.png");
            try {
                ssHandler.screenshotError();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        driver.findElement(continueButton).click();
    }

    public void clickPasswordContinue() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(continuePasswordButton));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "passwordContinueButtonNotFound.png");
            try {
                ssHandler.screenshotError();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        driver.findElement(continuePasswordButton).click();
    }

    public void performLogin(String username, String password) {
        clickLogIn();
        inputEmail(username);
        clickContinue();
        inputPassword(password);
        clickPasswordContinue();

    }
}
