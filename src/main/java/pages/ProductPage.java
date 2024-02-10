package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters;

import java.util.List;
import java.util.Random;

import static factory.Constants.EMAIL;
import static factory.Constants.PASSWORD;

public class ProductPage extends PageBase {
    Waiters waiters = new Waiters(driver);

    By productElements = By.xpath("//*[@class='product-item']");
    By size = By.cssSelector(".swatch-option.text");
    By selectColor = By.cssSelector("div.swatch-attribute.color");
    By colorOption = By.cssSelector("div.swatch-option.color");
    By addToCart = By.xpath(".//button[@title='Add to Cart']");
    By addToWishlist = By.xpath("//*[@class='action towishlist']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @SneakyThrows
    public void selectProduct() {
        Thread.sleep(5000);
        List<WebElement> products = driver.findElements(productElements);
        products.stream().findAny().get().click();
    }

    public void selectSize() {
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