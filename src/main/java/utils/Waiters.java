package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class Waiters {

    private static final Long DEFAULT_WAIT_TIME = 20L;
    private final WebDriverWait wait;


    public Waiters(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    public Waiters waitForElementToBeVisible(By locator) {
        return (Waiters) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Waiters waitForElementToBeClickable(By locator) {
        return (Waiters) wait.until(ExpectedConditions.elementToBeClickable(locator));
    }



}
