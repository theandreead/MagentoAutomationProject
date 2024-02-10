package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Waiters;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartPage extends PageBase {
    private static final String SHOPPING_CART = "Shopping Cart";
    private static final String CART = "https://magento.softwaretestingboard.com/checkout/cart/";

    private final Waiters waiters = new Waiters(driver);
    private final By cartCounterIcon = By.xpath("//*[@class='counter-number']");
    private final By cartPageTitle = By.xpath("//*[@class='page-title']");
    private final By cartQuantities = By.xpath("//*[@class='input-text qty']");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void openCart() {
        driver.get(CART);
        driver.navigate().refresh();
        waiters.waitForVisible(cartPageTitle);
        String pageTitle = driver.findElement(cartPageTitle).getText();
        Assert.assertEquals(pageTitle, SHOPPING_CART, "Page title is not as expected");

    }

    @SneakyThrows
    public int getCounterValue() {
        Thread.sleep(5000);
        WebElement cartCounter = driver.findElement(cartCounterIcon);
        return Integer.parseInt(cartCounter.getText());
    }


    public int getProductQuantity() {
        int initialQuantity = 0;
        List<WebElement> quantities = driver.findElements(cartQuantities);
        for (WebElement productQuantity : quantities) {
            int quantity = Integer.parseInt(productQuantity.getAttribute("value"));
            initialQuantity += quantity;
        }
        return initialQuantity;
    }
}