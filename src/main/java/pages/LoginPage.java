package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.time.Duration;
import static factory.Constants.EMAIL;
import static factory.Constants.PASSWORD;

public class LoginPage extends PageBase {

    private final By signInButton = By.xpath("//*[@class=\"authorization-link\"]");
    private final By email = By.id("email");
    private final By password = By.id("pass");
    private final By loginInButton = By.id("send2");
    private final By userAccountName = By.xpath("//*[@class='logged-in']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void performLogin(){
        driver.findElement(signInButton).click();
        driver.findElement(email).sendKeys(EMAIL);
        driver.findElement(password).sendKeys(PASSWORD);
        driver.findElement(loginInButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(userAccountName).isDisplayed(), "User Account is not logged-in");
    }
}