package test;


import enums.Browser;
import factory.BrowserProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import static factory.Constants.EMAIL;
import static factory.Constants.PASSWORD;

@Test
public class HomePageTests {

	private WebDriver driver;

	@BeforeSuite
	public void initalize() {
		driver = BrowserProvider.createDriver(Browser.CHROME);
		driver.manage().window().maximize();
	}

	@Test
	public void homePageCheckTitle() {
		driver.get("https://magento.softwaretestingboard.com/");
		HomePage homePage = new HomePage(driver);
        assertEquals("Home Page", homePage.getTitle());
	}

	@Test
	public void performLogin() {
		driver.get("https://magento.softwaretestingboard.com/");
		LoginPage loginPage = new LoginPage(driver);
		driver.findElement(loginPage.getSignInButton()).click();
		driver.findElement(loginPage.getEmail()).sendKeys(EMAIL);
		driver.findElement(loginPage.getPassword()).sendKeys(PASSWORD);
		driver.findElement(loginPage.getLoginInButton()).click();
	}

	@AfterSuite
	public void quitDriver() {
		driver.quit();
		driver = null;
	}
}
