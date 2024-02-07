package test;


import enums.Browser;
import factory.BrowserProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Order;

import java.util.List;


@Test
public class PlaceOrderTests {

	private static final String EMAIL= "xiyen66487@namewok.com";
	private static final String PASSWORD = "gYCGKt!Huxn9gR9";
	private WebDriver driver;


	@BeforeSuite
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

	@Test
	public void userCanPlaceAnOrder() {
		List<WebElement> products = driver.findElements(By.xpath("//*[@class='product-item']"));
		products.stream().findAny().get().click();

	}
	@Test
	public void checkNewArrivalsProductsCanBeAddedToCart() throws InterruptedException {
		Thread.sleep(5000);
		Order order = new Order(driver);
		driver.findElement(order.getNewItemSection()).click();
		Thread.sleep(5000);
		List<WebElement> products = driver.findElements(By.xpath("//*[@class='product-item']"));
		System.out.println(products.size());
		Thread.sleep(5000);
		for (WebElement product : products) {

			// Select size (if available)
			WebElement sizeElement = product.findElement(By.xpath("//*[contains(text(),'option-label-size']"));

			if (sizeElement.isDisplayed()) {
				List<WebElement> sizeOptions = sizeElement.findElements(By.cssSelector("div.swatch-option"));
				if (!sizeOptions.isEmpty()) {
					sizeOptions.get(0).click();
				}

				WebElement colorElement = product.findElement(By.cssSelector("div.swatch-attribute.color"));
				if (colorElement.isDisplayed()) {
					List<WebElement> colorOptions = colorElement.findElements(By.cssSelector("div.swatch-option"));
					if (!colorOptions.isEmpty()) {
						colorOptions.get(0).click();
					}
				}
				WebElement addToCartButton = product.findElement(By.xpath("//*[@class='action tocart primary']"));
				addToCartButton.click();
				Thread.sleep(5000);

			}
		}

	}

	@AfterSuite
	public void quitDriver() {
		driver.quit();
		driver = null;
	}
}
