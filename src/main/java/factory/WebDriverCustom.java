package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Objects;

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

    public void quitDriver() {
        if (webDriver != null) {
           webDriver.quit();
        }
    }
}