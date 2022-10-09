import POM.HomePageLogin;
import POM.HomePageUser;
import Utility.CustomChromeDriver;
import Utility.CustomFirefoxDriver;
import Utility.YamlReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestMain {
    public static YamlReader configurationReader;
    static HomePageLogin homePageLogin;
    static HomePageUser homePageUser;
    static WebDriver driver;

    @BeforeSuite
    public static void InitializeBrowser() {
        // Reading configuration from yaml
        configurationReader = new YamlReader("Configuration/configuration.yaml");

        String browserType = configurationReader.getVariable("BROWSER");
        String testingMainURL = configurationReader.getVariable("BASE_URL");

        //Cross browser selection section
        if (browserType.equals("Chrome"))
            driver = new CustomChromeDriver().getDriver();
        else if (browserType.equals("Firefox"))
            driver = new CustomFirefoxDriver().getDriver();

        driver.get(testingMainURL);

        // Instantiate POM object
        homePageLogin = new HomePageLogin(driver);
        homePageLogin.acceptCookie();
    }

    @AfterSuite
    public static void CloseBrowser() {
        if (homePageUser != null)
            homePageUser.clickOnLogout();

        driver.close();
    }

    @AfterMethod
    public static void CaseTeardown() {
        if (homePageUser != null)
            homePageUser.clickOnLogout();
    }

    @Test(priority = 1)
    /*
    *
    */
    public static void TestValidUserValues() {
        homePageUser = new HomePageUser(driver);
        homePageLogin.performLogin("yusufalti1997@gmail.com", "Yusuf1234.");
        homePageUser.clickOnPersonalInformation();

        Assert.assertTrue(homePageUser.checkNameText("Yusuf"));
        Assert.assertTrue(homePageUser.checkSurnameText("Altıparmak"));
        Assert.assertTrue(homePageUser.checkPhoneNo("5464577259"));
        Assert.assertTrue(homePageUser.checkDateDay("20"));
        Assert.assertTrue((homePageUser.checkPhoneExtension("TR +90")));
        Assert.assertTrue((homePageUser.checkDateMonth("January")));
        Assert.assertTrue((homePageUser.checkDateYear("1997")));
    }

    @Test(priority = 2)
    public static void TestInvalidUserValues() {
        homePageUser = new HomePageUser(driver);
        homePageLogin.performLogin("yusufalti1997@gmail.com", "Yusuf1234.");
        homePageUser.clickOnPersonalInformation();

        Assert.assertFalse(homePageUser.checkNameText("NotYusuf"));
        Assert.assertFalse(homePageUser.checkSurnameText("NotAltıparmak"));
        Assert.assertFalse(homePageUser.checkPhoneNo("Not5464577259"));
        Assert.assertFalse(homePageUser.checkDateDay("Not20"));
        Assert.assertFalse((homePageUser.checkPhoneExtension("NotTR +90")));
        Assert.assertFalse((homePageUser.checkDateMonth("NotJanuary")));
        Assert.assertFalse((homePageUser.checkDateYear("Not1997")));
    }
}
