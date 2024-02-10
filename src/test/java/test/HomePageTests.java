package test;

import factory.WebDriverCustom;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static factory.Constants.MAGENTO_SITE;

@Test
public class HomePageTests {

    private WebDriver driver;
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @BeforeSuite
    public void initalize() {
        driver = WebDriverCustom.getWebDriver();
        driver.manage().window().maximize();
        driver.get(MAGENTO_SITE);
    }

    @Test
    public void performLogin() {
        loginPage.performLogin();
    }

    @Test
    public void goThroughSectionsAndSubSections() {
        homePage.goToSection("Women");
        homePage.goToFirstSubsection("Women");
    }

    @AfterSuite
    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}