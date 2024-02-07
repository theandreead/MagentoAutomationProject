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

    public WebElement findElement(WebDriver driver, String xpath) {
        try {
            return driver.findElement(By.xpath(xpath));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static List<WebElement> findElements(WebDriver driver, String xpath) {
        try {
            return driver.findElements(By.xpath(xpath));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public  WebElement waitForElementToBeVisible(WebDriver driver, String xpath, Duration timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public  WebElement waitForElementToBeVisible(WebDriver driver, String xpath) {
        return waitForElementToBeVisible(driver, xpath, Duration.ofSeconds(DEFAULT_WAIT_TIME));
    }

    public  WebElement waitForElement(WebDriver driver, String xpath, Duration timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public  WebElement waitForElement(WebDriver driver, String xpath) {
        return waitForElement(driver, xpath, Duration.ofDays(DEFAULT_WAIT_TIME));
    }

    public static List<WebElement> waitForElements(WebDriver driver, String xpath, Duration timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public  List<WebElement> waitForElements(WebDriver driver, String xpath) {
        return waitForElements(driver, xpath, Duration.ofSeconds(DEFAULT_WAIT_TIME));
    }

    public  WebElement waitForElementToBeClickable(WebDriver driver, String xpath, Duration timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public  WebElement waitForElementToBeClickable(WebDriver driver, String xpath) {
        return waitForElementToBeClickable(driver, xpath, Duration.ofSeconds(DEFAULT_WAIT_TIME));
    }


    public <T> T waitUntil(WebDriver driver, Function<? super WebDriver, T> condition, Duration timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(condition);
    }

}
