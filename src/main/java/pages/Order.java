package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Data
public class Order extends PageBase {

   private WebDriver driver;
   private final By newItemSection = By.xpath("//*[@id='ui-id-3']");

    public Order(WebDriver driver) {
        super(driver);
    }


    public int countNewProducts() {
        List<WebElement> newProductElements = driver.findElements(By.xpath("//*[@class=\"product-item-info\"]"));
        return newProductElements.size();
    }

    public  void selectColorAndAddToCart() {
//        driver.findElement(newItemSection).click();
        List<WebElement> newProducts = driver.findElements(By.xpath("//*[@class=\"product-item-info\"]"));
        for (WebElement product : newProducts) {
            product.findElement(By.xpath("//*[@aria-label='Color']")).click();
            product.findElement(By.xpath("//*[@aria-label='S']")).click();
            product.findElement(By.className("add-to-cart")).click();
            System.out.println("Added product to cart.");
    }
}
}
