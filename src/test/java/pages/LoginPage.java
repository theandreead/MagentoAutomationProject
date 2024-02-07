package pages;

import factory.PageBase;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiters;

import static org.testng.AssertJUnit.assertTrue;
@Data
public class LoginPage extends PageBase {

    private final By signInButton = By.xpath("//*[@class=\"authorization-link\"]");
    private final By email = By.id("email");
    private final By password = By.id("pass");
    private final By loginInButton = By.id("send2");
    private final By userAccountName = By.xpath("//*[@class='logged-in']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }



}