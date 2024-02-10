package test;

import factory.AddressFields;
import factory.WebDriverCustom;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyWishlistPage;
import pages.ProductPage;

@Test
public class AddNewAddressTests {

	private WebDriver driver;
	LoginPage loginPage = new LoginPage(driver);
	ProductPage productPage = new ProductPage(driver);
	MyWishlistPage wishListPage = new MyWishlistPage(driver);
	MyAccountPage accountPage = new MyAccountPage(driver);
	@BeforeSuite
	public void initalize() {
		driver = WebDriverCustom.getWebDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		loginPage.performLogin();
	}

	@Test
	public void addProductToWishlist() {
		driver.get("https://magento.softwaretestingboard.com/customer/address/new/");
		accountPage.fillAddressFields(new AddressFields());
	}

	@AfterSuite
	public void quitDriver() {
		driver.quit();
		driver = null;
	}
}