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
    private final By PRODUCT_SUBTOTALS = By.cssSelector(".subtotal .cart-price .price");
    private final By DISCOUNT = By.cssSelector("td[data-th='Discount'] .price");
    private final By TAX = By.cssSelector(".totals-tax .price");
    private final By CART_SUBTOTAL = By.xpath("//*[@class='totals sub']");
    private final By GRAND_TOTAL = By.cssSelector(".grand .price");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @SneakyThrows
    public void openCart() {
        Thread.sleep(5000);
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

    public boolean checkCartPriceSubtotal() {
        waiters.waitForVisible(CART_SUBTOTAL);
        String subtotalText = driver.findElement(CART_SUBTOTAL).getText();
        double expectedSubtotal = extractDouble(subtotalText);
        double actualSubtotal = 0;
        for (WebElement productSubtotal : driver.findElements(PRODUCT_SUBTOTALS)) {
            double subtotal = extractDouble(productSubtotal.getText());
            actualSubtotal += subtotal;
        }
        return actualSubtotal == expectedSubtotal;
    }

    public boolean checkTotalPriceIsCorrect() {
        waiters.waitForVisible(GRAND_TOTAL);
        double totalValue = getTotalValue(driver.findElement(GRAND_TOTAL));
        double subtotalValue = getTotalValue(driver.findElement(CART_SUBTOTAL));
        double discountValue = 0;
        double taxValue = 0;

        List<WebElement> discount = driver.findElements(DISCOUNT);
        if (!discount.isEmpty()) {
            discountValue = getTotalValue(discount.get(0));
        }

        List<WebElement> tax = driver.findElements(TAX);
        if (!tax.isEmpty()) {
            taxValue = getTotalValue(tax.get(0));
        }
        return subtotalValue - discountValue + taxValue == totalValue;
    }

    private double extractDouble(String text) {
        String cleanedText = text.replaceAll("[^\\d.]", "");
        return Double.parseDouble(cleanedText);
    }

    public double getTotalValue(WebElement element) {
        String text = element.getText().replaceAll("[^0-9.]+", "");
        return Double.parseDouble(text);
    }

}