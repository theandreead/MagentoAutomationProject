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

import static factory.Constants.CART;
import static factory.Constants.SHOPPING_CART;

public class CartPage extends PageBase {

    private final Waiters waiters = new Waiters(driver);
    private final By cartCounterIcon = By.xpath("//*[@class='counter-number']");
    private final By cartPageTitle = By.xpath("//*[@class='page-title']");
    private final By cartQuantities = By.xpath("//*[@class='input-text qty']");
    private final By productItemsInShoppingCart = By.xpath("//*[@class='item-info']");
    private final By productItemSubtotal = By.cssSelector(".subtotal .cart-price .price");

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

    public boolean checkProductCartSubTotal() {
        List<WebElement> cartItems = driver.findElements(productItemsInShoppingCart);
        for (int i = 0; i < cartItems.size(); i++) {
            WebElement productPrice = cartItems.get(i);
            double price = Double.parseDouble(productPrice.getText());
            WebElement productQuantity = getProductQuantity().get(i);
            int quantity = Integer.parseInt(productQuantity.getAttribute("value"));
            WebElement productSubtotal = productItemSubtotal.get(i);
            double subtotal = Double.parseDouble(productSubtotal.getText());
            if (price * quantity != subtotal) {
                return false;
            }
        }
        return true;
    }

    public boolean isCartSubtotalValid() {
        double expectedSubtotal = extractDouble(cartSubtotal.getText());
        double actualSubtotal = 0;
        for (WebElement productSubtotal : productSubtotals) {
            double subtotal = extractDouble(productSubtotal.getText());
            actualSubtotal += subtotal;
        }
        return actualSubtotal == expectedSubtotal;
    }
}