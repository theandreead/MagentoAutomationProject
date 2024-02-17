package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCustom {
    private static WebDriverCustom SINGLETONE;
    private static WebDriver webDriver;

    private WebDriverCustom() {
    }

    public static WebDriverCustom getDriver() {
        if (SINGLETONE == null) {
            SINGLETONE = new WebDriverCustom();
        }
        return SINGLETONE;
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }

    public static void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}