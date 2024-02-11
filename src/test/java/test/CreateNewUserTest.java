package test;

import factory.NewUser;
import factory.WebDriverCustom;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import static factory.Constants.CREATE_ACCOUNT;

@Test
public class CreateNewUserTest {

    private WebDriver driver;
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @BeforeSuite
    public void initalize() {
        driver = WebDriverCustom.getWebDriver();
        driver.manage().window().maximize();
        driver.get(CREATE_ACCOUNT);
    }

    @Test
    public void createNewUserTest() {
        registrationPage.registerAccount(new NewUser(NewUser.createRandomUser().getFirstName(),
                NewUser.createRandomUser().getLastName(),
                NewUser.createRandomUser().getEmail(),
                NewUser.createRandomUser().getPassword()));
        registrationPage.successfulRegistrationPopupIsDisplayed();
    }


    @AfterSuite
    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}