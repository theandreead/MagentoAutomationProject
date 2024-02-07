package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageBase {

    private WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void hoverOver(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }
}