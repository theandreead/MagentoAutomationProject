package test;

import factory.WebDriverCustom;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;

@Test
public class AddToWishlistTests {

	private WebDriver driver;
	LoginPage loginPage = new LoginPage(driver);
	ProductPage productPage = new ProductPage(driver);
	WishlistPage wishListPage = new WishlistPage(driver);
	HomePage homePage = new HomePage(driver);
	@BeforeSuite
	public void initalize() {
		driver = WebDriverCustom.getWebDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		loginPage.performLogin();
	}

	@Test
	public void addProductToWishlist() {
		homePage.goToSection("Men");
		productPage.selectProduct();
		productPage.addToWishlist();
		wishListPage.isProductWishlistPopupDisplayed();
	}

	@AfterSuite
	public void quitDriver() {
		driver.quit();
		driver = null;
	}
}