package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProductPage extends PageBase {
    Waiters waiters = new Waiters(driver);

    By productElements = By.xpath("//*[@class='item product product-item'] | //*[@class='product-item']");
    By size = By.cssSelector(".swatch-option.text");
    By selectColor = By.cssSelector("div.swatch-attribute.color");
    By colorOption = By.cssSelector("div.swatch-option.color");
    By addToCart = By.xpath(".//button[@title='Add to Cart']");
    By addToWishlist = By.xpath("//*[@class='action towishlist']");
    By productName = By.xpath("//*[@class='page-title-wrapper product']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @SneakyThrows
    public void selectProduct() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        boolean clicked = false;
        for (int i = 0; i < 2; i++) {
            List<WebElement> products = driver.findElements(productElements);
            if (!products.isEmpty()) {
                WebElement firstProduct = products.get(0);
                try {
                    firstProduct.click();
                    clicked = true;
                    break;
                } catch (Exception e) {
                    System.out.println("Attempt " + (i + 1) + ": Failed to click on the first element. Retrying...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                System.out.println("Attempt " + (i + 1) + ": No products found!");
            }
        }
        if (!clicked) {
            System.out.println("Failed to click on the first element after retrying.");
        }
    }

    public void selectSize() {
        waiters.waitForVisible(productName).isDisplayed();
        Random random = new Random();
        waiters.waitForVisible(size);
        List<WebElement> availableSizes = driver.findElements(size);
        WebElement randomSize = availableSizes.get(random.nextInt(availableSizes.size() - 1));
        randomSize.click();
    }

    public void selectColor() {
        waiters.waitForVisible(selectColor);
        WebElement colorAttribute = driver.findElement(selectColor);
        WebElement firstColorOption = colorAttribute.findElement(colorOption);
        firstColorOption.click();
    }


    public void addToCard() {
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        waiters.waitForVisible(addToCart);
        waiters.waitForClickable(addToCart);
        WebElement addToCartButton = driver.findElement(addToCart);
        addToCartButton.click();
    }

    public void addToWishlist() {
        waiters.waitForClickable(addToWishlist);
        driver.findElement(addToWishlist).click();
    }
}