package test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

@Test
public class HomePageTests extends BaseTest {

    private WebDriver driver;
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Test
    public void performLogin() {
        loginPage.performLogin();
    }

    @Test
    public void goThroughSectionsAndSubSections() {
        homePage.goToSection("Women");
        homePage.goToFirstSubsection("Women");
    }

}