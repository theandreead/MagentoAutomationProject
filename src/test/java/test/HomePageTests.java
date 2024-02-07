package test;



import factory.WebDriverCustom;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;



@Test
public class HomePageTests {
	private static final String MAGENTO_SITE = "https://magento.softwaretestingboard.com/";

	private WebDriver driver;
	LoginPage loginPage = new LoginPage(driver);

	@BeforeSuite
	public void initalize() {
		driver = WebDriverCustom.getWebDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void performLogin() {
		driver.get(MAGENTO_SITE);
		loginPage.performLogin();
	}

	@AfterSuite
	public void quitDriver() {
		driver.quit();
		driver = null;
	}
}