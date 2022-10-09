package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomChromeDriver {
    WebDriver customDriver;

    public CustomChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        customDriver = new ChromeDriver(options);
    }

    public WebDriver getDriver() {
        return this.customDriver;
    }
}
