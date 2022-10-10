package POM;

import Utility.ScreenshotHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * HomePageUser
 * This class is used to keep functions and locators about web elements after user logged in
 */
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
        customWait.waitUntilElementIsVisibleAndClickable(personalInformationButton,"personalInformationButtonNotFound");
        WebElement personalInformationButtonElement = driver.findElement(personalInformationButton);
        personalInformationButtonElement.click();
    }

    /**
     * clickOnLogout
     * Clicks on the Logout button
     */
    public void clickOnLogout() {
        customWait.waitUntilElementIsVisibleAndClickable(logoutButton,"logOutButtonNotFound");
        WebElement logoutButtonElement = driver.findElement(logoutButton);
        logoutButtonElement.click();
    }

    /**
     * checkNameText
     * Checks the Name input text with the param text
     *
     * @param text: text to compare
     * @return returns true if texts are same, false otherwise
     */
    public boolean checkNameText(String text) {
        customWait.waitUntilElementIsVisible(personalName,"nameInputNotFound");
        WebElement nameElement = driver.findElement(personalName);
        return nameElement.getAttribute("value").equals(text);
    }

    /**
     * checkSurnameText
     * Checks the Surname input text with the param text
     *
     * @param text: text to compare
     * @return returns true if texts are same, false otherwise
     */
    public boolean checkSurnameText(String text) {
        customWait.waitUntilElementIsVisible(personalSurname,"surnameInputNotFound");
        WebElement surnameElement = driver.findElement(personalSurname);
        return surnameElement.getAttribute("value").equals(text);
    }

    /**
     * checkPhoneNo
     * Checks the Phone no input text with the param text
     *
     * @param text: phone no text to compare
     * @return returns true if texts are same, false otherwise
     */
    public boolean checkPhoneNo(String text) {
        customWait.waitUntilElementIsVisible(personalPhoneNo,"phoneNoInputNotFound");
        WebElement phoneElement = driver.findElement(personalPhoneNo);
        return phoneElement.getAttribute("value").equals(text);
    }

    /**
     * checkPhoneExtension
     * Checks the Phone extension input text with the param text
     *
     * @param text: phone extension text to compare
     * @return returns true if texts are same, false otherwise
     */
    public boolean checkPhoneExtension(String text) {
        customWait.waitUntilElementIsVisible(personalPhoneExtension,"phoneExtensionSelectNotFound");
        WebElement list = driver.findElement(personalPhoneExtension);
        Select select = new Select(list);
        WebElement selection = select.getFirstSelectedOption();
        return selection.getText().equals(text);
    }

    /**
     * checkDateDay
     * Checks the day of the birthday date input text with the param text
     *
     * @param text: day of the birthday text to compare
     * @return returns true if texts are same, false otherwise
     */
    public boolean checkDateDay(String text) {
        customWait.waitUntilElementIsVisible(dateDayInput,"dateDayInputNotFound");
        WebElement dateDayElement = driver.findElement(dateDayInput);
        return dateDayElement.getAttribute("value").equals(text);
    }

    /**
     * checkDateMonth
     * Checks the month of the birthday date input text with the param text
     *
     * @param text: month of the birthday text to compare
     * @return returns true if texts are same, false otherwise
     */
    public boolean checkDateMonth(String text) {
        customWait.waitUntilElementIsVisible(dateMonthInput,"dateMonthInputNotFound");
        WebElement list = driver.findElement(dateMonthInput);
        Select select = new Select(list);
        WebElement selection = select.getFirstSelectedOption();
        return selection.getText().equals(text);
    }

    /**
     * checkDateYear
     * Checks the year of the birthday date input text with the param text
     *
     * @param text: year of the birthday text to compare
     * @return returns true if texts are same, false otherwise
     */
    public boolean checkDateYear(String text) {
        customWait.waitUntilElementIsVisible(dateYearInput,"dateYearInputNotFound");
        WebElement dateYearElement = driver.findElement(dateYearInput);
        return dateYearElement.getAttribute("value").equals(text);
    }
}
