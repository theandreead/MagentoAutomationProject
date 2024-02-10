package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters;

public class MyWishlistPage extends PageBase {

    By productToWishList= By.xpath("//*[@class='product-item']");

    public MyWishlistPage(WebDriver driver) {super(driver);}


    public void isProductWishlistPopupDisplayed() {
        WebElement productAddedToWishlistMessage = driver.findElement(productToWishList);
        productAddedToWishlistMessage.isDisplayed();
    }
}