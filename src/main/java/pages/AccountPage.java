package pages;
import factory.AddressFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Waiters;

public class AccountPage extends PageBase {
    private final Waiters waiters = new Waiters(driver);

    By phoneNumber = By.id("telephone");
    By streetAddress = By.id("street_1");
    By city = By.id("city");
    By stateList = By.id("region_id");
    By zipCode = By.id("zip");
    By countryList = By.id("country");
    By saveAddressBtn = By.className("save");
    By addNewAddressBtn = By.className("add");
    By addressSavedPopup= By.className("message-success");

    public AccountPage(WebDriver driver) {
        super(driver);
    }


    public void fillAddressFields(AddressFields addressFields) {
        driver.findElement(phoneNumber).sendKeys(addressFields.getPhoneNumber());
        driver.findElement(streetAddress).sendKeys(addressFields.getStreetAddress());
        driver.findElement(city).sendKeys(addressFields.getCity());
        WebElement countryDropdown = driver.findElement(countryList);
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByValue(addressFields.getCountry());

        WebElement stateDropdown = driver.findElement(stateList);
        Select stateSelect = new Select(stateDropdown);
        stateSelect.selectByVisibleText(addressFields.getState());
        driver.findElement(zipCode).sendKeys(addressFields.getZipCode());
    }

    public void saveAddress() {
       driver.findElement((By) saveAddressBtn).click();
    }

    public void addNewAddress() {
        waiters.waitForVisible(addNewAddressBtn);
        driver.findElement(addNewAddressBtn).click();
    }

    public void isAddedAdressPopupDisplayed() {
        WebElement addressIsSavedPopup = driver.findElement(addressSavedPopup);
        addressIsSavedPopup.isDisplayed();
    }
}
        