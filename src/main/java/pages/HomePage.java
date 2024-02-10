package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class HomePage extends PageBase {

    private final By switchIcon = By.xpath("//*[@class='customer-menu']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openWishlist(){
        WebElement dropdown = driver.findElement(switchIcon); // Replace "dropdownId" with the actual id of the dropdown
        dropdown.click();
        // Create a Select object
        Select select = new Select(dropdown);

        // Select an option by visible text
        select.selectByVisibleText("My Wish List");
    }
    public void selectProductFromRandomTab() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> tabs = driver.findElements(By.cssSelector("a.level-top"));
        Random random = new Random();
        int randomTabIndex = random.nextInt(tabs.size()-1);
        WebElement randomTab = tabs.get(randomTabIndex);
        randomTab.click();


    // Randomly select a product from the selected tab

        List<WebElement> products = randomTab.findElements(By.cssSelector(".product-item-details"));
        int randomProductIndex = random.nextInt(products.size());
        WebElement randomProduct = products.get(randomProductIndex);
        randomProduct.click();
    }

    // Randomly select a size (if applicable)
    public void selectRandomSize() {
        Random random = new Random();
        List<WebElement> sizes = driver.findElements(By.cssSelector(".swatch-attribute.size .swatch-option"));
        if (!sizes.isEmpty()) {
            int randomSizeIndex = random.nextInt(sizes.size());
            WebElement randomSize = sizes.get(randomSizeIndex);
            randomSize.click();
        }
    }

    // Randomly select a color (if applicable)
    public void selectColor() {
        Random random = new Random();
        List<WebElement> colors = driver.findElements(By.cssSelector(".swatch-attribute.color .swatch-option"));
        if (!colors.isEmpty()) {
            int randomColorIndex = random.nextInt(colors.size());
            WebElement randomColor = colors.get(randomColorIndex);
            randomColor.click();
        }
    }
}
