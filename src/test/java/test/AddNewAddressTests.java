package test;

import factory.AddressFields;
import factory.WebDriverCustom;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AccountPage;

import static factory.Constants.ACCOUNT_ADDRESS;


@Test
public class AddNewAddressTests extends BaseTest {

	private WebDriver driver;
	AccountPage accountPage = new AccountPage(driver);


	@Test
	public void addNewAddressForAccount() {
		driver = WebDriverCustom.getWebDriver();
		driver.get(ACCOUNT_ADDRESS);
		accountPage.completeNewAddressFields(new AddressFields());
		accountPage.saveAddress();
		accountPage.isAddedAddressPopupDisplayed();
	}
}