package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
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

//
//    // Randomly select a product from the selected tab
//
//        List<WebElement> products = randomTab.findElements(By.cssSelector(".product-item-details"));
//        int randomProductIndex = random.nextInt(products.size());
//        WebElement randomProduct = products.get(randomProductIndex);
//        randomProduct.click();
    }

    // Randomly select a size (if applicable)
    public void selectRandomSize() {
        Random random = new Random();

        if (!driver.findElements(By.cssSelector(".swatch-attribute.size .swatch-option")).isEmpty()) {
            List<WebElement> sizes = driver.findElements(By.cssSelector(".swatch-attribute.size .swatch-option"));
            int randomSizeIndex = random.nextInt(sizes.size());
            WebElement randomSize = sizes.get(randomSizeIndex);
            randomSize.click();
        } else {
            log.info("size not required");
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

    public void goToSection(String sectionName) {
        List<WebElement> categories = driver.findElements(By.cssSelector("a.level-top"));
        for (WebElement listItem : categories) {
            if (listItem.getText().contains(sectionName)) {
                listItem.click();
                break;
            }
        }
    }

    public void goToFirstSubsection(String section) {
        List<WebElement> categories = driver.findElements(By.cssSelector("a.level-top"));
        for (WebElement listItem : categories) {
            if (listItem.getText().contains(section)) {
                hoverOver(listItem);
                break;
            }
        }
        List<WebElement> subCategories= driver.findElements(By.cssSelector(".parent .category-item a"));
        if (!subCategories.isEmpty()) {
            subCategories.get(0).click();
        }
    }
}
