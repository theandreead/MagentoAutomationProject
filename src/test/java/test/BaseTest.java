package test;

import factory.WebDriverCustom;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;

import java.time.Duration;

import static factory.Constants.MAGENTO_SITE;


public class BaseTest {
    protected static WebDriver driver;
    private static final LoginPage loginPage = new LoginPage(driver);

    @BeforeTest
    public static void initialize() {
        driver = WebDriverCustom.getWebDriver();
        driver.manage().window().maximize();
        driver.get(MAGENTO_SITE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.performLogin();
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}
