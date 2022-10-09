package POM;

import Utility.ScreenshotHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class HomePageUser extends HomePage {

    By personalInformationButton = By.xpath("//button[text() = 'My personal information']");
    By personalName = By.xpath("//input[@name = 'firstName']");
    By personalSurname = By.xpath("//input[@name = 'lastName']");
    By personalPhoneNo = By.xpath("//input[@data-testid = 'phone-input-number']");
    By personalPhoneExtension = By.id("PHONE_CODE_FIELD");
    By dateDayInput = By.xpath("//input[@data-testid = 'birthDate-input-day']");
    By dateMonthInput = By.xpath("//select[@name = 'birthDate.month']");
    By dateYearInput = By.xpath("//input[@data-testid = 'birthDate-input-year']");
    By logoutButton = By.id("user_space_logout");

    public HomePageUser(WebDriver driver) {
        super(driver);
    }

    /**
     * clickOnPersonalInformation
     * Clicks on the Personal information button
     */
    public void clickOnPersonalInformation() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(personalInformationButton));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "personalInformationButtonNotFound.png");
            ssHandler.screenshotError();
        }
        WebElement personalInformationButtonElement = driver.findElement(personalInformationButton);
        personalInformationButtonElement.click();
    }

    /**
     * clickOnLogout
     * Clicks on the Logout button
     */
    public void clickOnLogout() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "logOutButtonNotFound.png");
            ssHandler.screenshotError();

        }
        WebElement logoutButtonElement = driver.findElement(logoutButton);
        logoutButtonElement.click();
    }

    /**
     * checkNameText
     * Checks the Name input text with the param text
     * @param text: text to compare
     * @return returns true if texts are same, false otherwise
     */
    public boolean checkNameText(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(personalName));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "nameInputNotFound.png");
            ssHandler.screenshotError();
            return false;
        }
        WebElement nameElement = driver.findElement(personalName);
        return nameElement.getAttribute("value").equals(text);
    }

    w/**
     * checkSurnameText
     * Checks the Surname input text with the param text
     * @param text: text to compare
     * @return returns true if texts are same, false otherwise
     */
    public boolean checkSurnameText(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(personalSurname));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "surnameInputNotFound.png");
            ssHandler.screenshotError();

            return false;
        }
        WebElement surnameElement = driver.findElement(personalSurname);
        return surnameElement.getAttribute("value").equals(text);
    }

    public boolean checkPhoneNo(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(personalPhoneNo));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "phoneNoInputNotFound.png");
            try {
                ssHandler.screenshotError();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return false;
        }
        WebElement phoneElement = driver.findElement(personalPhoneNo);
        return phoneElement.getAttribute("value").equals(text);
    }

    public boolean checkPhoneExtension(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(personalPhoneExtension));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "phoneExtensionSelectNotFound.png");
            try {
                ssHandler.screenshotError();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return false;
        }
        WebElement list = driver.findElement(personalPhoneExtension);
        Select select = new Select(list);
        WebElement selection = select.getFirstSelectedOption();
        return selection.getText().equals(text);
    }

    public boolean checkDateDay(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dateDayInput));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "dateDayInputNotFound.png");
            try {
                ssHandler.screenshotError();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return false;
        }
        WebElement dateDayElement = driver.findElement(dateDayInput);
        return dateDayElement.getAttribute("value").equals(text);
    }

    public boolean checkDateMonth(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dateMonthInput));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "dateMonthInputNotFound.png");
            try {
                ssHandler.screenshotError();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return false;
        }
        WebElement list = driver.findElement(dateMonthInput);
        Select select = new Select(list);
        WebElement selection = select.getFirstSelectedOption();
        return selection.getText().equals(text);
    }

    public boolean checkDateYear(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dateYearInput));
        } catch (TimeoutException e) {
            ScreenshotHandler ssHandler = new ScreenshotHandler(driver, "dateYearInputNotFound.png");
            try {
                ssHandler.screenshotError();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return false;
        }
        WebElement dateYearElement = driver.findElement(dateYearInput);
        return dateYearElement.getAttribute("value").equals(text);
    }
}
