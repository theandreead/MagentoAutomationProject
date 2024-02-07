package pages;

import factory.WebDriverCustom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver =  WebDriverCustom.getWebDriver();
        PageFactory.initElements(this.driver, this);
    }

    public void hoverOver(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }
}