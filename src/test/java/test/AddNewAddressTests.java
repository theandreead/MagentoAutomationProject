package test;

import factory.AddressFields;
import factory.WebDriverCustom;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AccountPage;

import static factory.Constants.ACCOUNT_ADDRESS;
import static factory.Constants.MAGENTO_SITE;

@Test
public class AddNewAddressTests {

	private WebDriver driver;
	LoginPage loginPage = new LoginPage(driver);
	AccountPage accountPage = new AccountPage(driver);
	@BeforeSuite
	public void initalize() {
		driver = WebDriverCustom.getWebDriver();
		driver.manage().window().maximize();
		driver.get(MAGENTO_SITE);
		loginPage.performLogin();
	}

	@Test
	public void addNewAddressForAccount() {
		driver.get(ACCOUNT_ADDRESS);
		accountPage.completeNewAddressFields(new AddressFields());
		accountPage.saveAddress();
		accountPage.isAddedAddressPopupDisplayed();
	}

	@AfterSuite
	public void quitDriver() {
		driver.quit();
		driver = null;
	}
}