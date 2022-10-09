package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class CustomFirefoxDriver {
    WebDriver customDriver;

    public CustomFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "BrowserDrivers/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
        options.setBinary(binary);
        customDriver = new FirefoxDriver(options);
    }

    public WebDriver getDriver() {
        return this.customDriver;
    }
}
