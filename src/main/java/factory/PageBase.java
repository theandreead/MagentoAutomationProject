package factory;

import org.openqa.selenium.WebDriver;

public class PageBase {

        private WebDriver driver;

        public PageBase (WebDriver driver) {
            this.driver = driver;
        }

        public String getTitle() {
            return driver.getTitle();
        }
}