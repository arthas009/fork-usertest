package POM;

import Utility.ScreenshotHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * HomePageUser
 * This class is used to keep functions and locators about web elements on main page and login window
 */
public class HomePageLogin extends HomePage {
    By logInButton = By.xpath("//button[@data-testid = 'user-space']");
    By emailInput = By.id("identification_email");
    By continueButton = By.xpath("//button[@data-testid = 'checkout-submit-email']");
    By continuePasswordButton = By.xpath("//button[@data-testid = 'submit-password']");
    By passwordInput = By.id("password");

    public HomePageLogin(WebDriver driver) {
        super(driver);
    }

    /**
     * clickLogIn
     * Clicks on Login button
     */
    public void clickLogIn() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(logInButton));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "loginButtonNotFound.png");
            ssHandler.screenshotError();
        }
        // To avoid stale element exception
        try {
            driver.findElement(logInButton).click();
        } catch (StaleElementReferenceException e) {
            driver.findElement(logInButton).click();
        }
    }

    /**
     * inputEmail
     * Inputs text to e-mail input element
     *
     * @param email text to input
     */
    public void inputEmail(String email) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "emailInputNotFound.png");
            ssHandler.screenshotError();
        }
        driver.findElement(emailInput).sendKeys(email);
    }

    /**
     * inputPassword
     * Inputs password to password input element
     *
     * @param password text to input
     */
    public void inputPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "passwordInputNotFound.png");
            ssHandler.screenshotError();
        }
        driver.findElement(passwordInput).sendKeys(password);
    }

    /**
     * clickContinue
     * Clicks on Continue button after e-mail is given
     */
    public void clickContinue() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "continueButtonNotFound.png");
            ssHandler.screenshotError();
        }
        driver.findElement(continueButton).click();
    }

    /**
     * clickContinue
     * Clicks on Continue button after password is given
     */
    public void clickPasswordContinue() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(continuePasswordButton));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "passwordContinueButtonNotFound.png");
            ssHandler.screenshotError();
        }
        driver.findElement(continuePasswordButton).click();
    }

    /**
     * performLogin
     * Permorms end-to-end login
     *
     * @param username username to login
     * @param password password of username
     */
    public void performLogin(String username, String password) {
        clickLogIn();
        inputEmail(username);
        clickContinue();
        inputPassword(password);
        clickPasswordContinue();
    }
}
