package test;


import enums.Browser;
import factory.BrowserProvider;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

import java.util.List;

import static factory.Constants.EMAIL;
import static factory.Constants.PASSWORD;


public class PlaceOrderTests {


	private WebDriver driver;

	By productElements= By.xpath("//*[@class='product-item']");
	By selectSize = By.xpath("//div[@class='swatch-attribute-options clearfix']//div[@aria-label='S']");
	By selectColor = By.cssSelector("div.swatch-attribute.color");
	By colorOption = By.cssSelector("div.swatch-option.color");
	By addToCart = By.xpath(".//button[@title='Add to Cart']");


	@Before
	public void initalize() {
		driver = BrowserProvider.createDriver(Browser.CHROME);
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		LoginPage loginPage = new LoginPage(driver);
		driver.findElement(loginPage.getSignInButton()).click();
		driver.findElement(loginPage.getEmail()).sendKeys(EMAIL);
		driver.findElement(loginPage.getPassword()).sendKeys(PASSWORD);
		driver.findElement(loginPage.getLoginInButton()).click();
	}

	@SneakyThrows
	@Test
	public void userCanPlaceAnOrder() {
		List<WebElement> products = driver.findElements(productElements);
		products.stream().findAny().get().click();
		Thread.sleep(5000);
		WebElement size = driver.findElement(selectSize);
		size.click();
		WebElement colorAttribute = driver.findElement(selectColor);
		WebElement firstColorOption = colorAttribute.findElement(colorOption);
		firstColorOption.click();
		WebElement addToCartButton = driver.findElement(addToCart);
		addToCartButton.click();
	}
	@After
	public void quitDriver() {
		driver.quit();
		driver = null;
	}
}
