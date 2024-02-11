package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
@Slf4j
public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
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