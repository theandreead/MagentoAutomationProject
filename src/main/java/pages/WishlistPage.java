package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage extends PageBase {

    By productToWishList= By.xpath("//*[@class='product-item']");

    public WishlistPage(WebDriver driver) {super(driver);}


    public void isProductWishlistPopupDisplayed() {
        WebElement productAddedToWishlistMessage = driver.findElement(productToWishList);
        productAddedToWishlistMessage.isDisplayed();
    }
}