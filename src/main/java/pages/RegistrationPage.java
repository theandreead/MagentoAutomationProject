package pages;

import factory.NewUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


import static org.testng.AssertJUnit.assertEquals;

public class RegistrationPage extends PageBase {
    private static final String EXPECTED_REGISTRATION_MESSAGE = "Thank you for registering with Main Website Store.";
    private final By firstNameLocator = By.id("firstname");
    private final By lastNameLocator = By.id("lastname");
    private final By emailLocator = By.id("email_address");
    private final By passwordLocator = By.id("password");
    private final By confirmPasswordLocator = By.id("password-confirmation");
    private final By createAnAccountBtnLocator = By.className("submit");
    private final By successfulRegistrationPopup = By.xpath("//*[@class='messages']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void registerAccount(NewUser user) {
        fillRegistrationFields(user);
        driver.findElement(createAnAccountBtnLocator).click();
    }

    public void fillRegistrationFields(NewUser user) {
        driver.findElement(firstNameLocator).sendKeys(user.getFirstName());
        driver.findElement(lastNameLocator).sendKeys(user.getLastName());
        driver.findElement(emailLocator).sendKeys(user.getEmail());
        driver.findElement(passwordLocator).sendKeys(user.getPassword());
        driver.findElement(confirmPasswordLocator).sendKeys(user.getPassword());
    }

    public void successfulRegistrationPopupIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String registrationSuccessful = driver.findElement(successfulRegistrationPopup).getText();
        assertEquals(EXPECTED_REGISTRATION_MESSAGE, registrationSuccessful);
    }
}