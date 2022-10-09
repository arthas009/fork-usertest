package Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

/**
 * ScreenshotHandler
 * This class is used when errors needed to be screenshotted
 */
public class ScreenshotHandler {
    String filename;
    String folder_path;
    WebDriver driver;

    public ScreenshotHandler(WebDriver driver, String filename) {
        this.filename = filename;
        this.driver = driver;
        folder_path = YamlReader.getVariable("TEST_OUTPUT_DIRECTORY") + "/Screenshots/";
    }

    /**
     * screenshotError
     * Screenshots the current page to given test output folder path
     */
    public void screenshotError() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File directory = new File(folder_path);

        if (!directory.exists())
            directory.mkdir();

        try {
            FileHandler.copy(source, new File(folder_path + "/" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
