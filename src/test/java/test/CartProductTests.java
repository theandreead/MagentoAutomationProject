package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


@Test
public class CartProductTests extends BaseTest {

    private WebDriver driver;

    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);
    HomePage homePage = new HomePage(driver);

    @Test
    public void addProductAndCheckCounterUpdate() {
        int initialCounterValue = cartPage.getCounterValue();
        homePage.goToSection("What's New");
        productPage.selectProduct();
        productPage.selectSize();
        productPage.selectColor();
        productPage.addToCard();
        int updatedCounterValue = cartPage.getCounterValue();
        assert updatedCounterValue > initialCounterValue : "Updated counter is not greater than initial counter value";
    }

    @Test
    public void checkCartProductQuantityIsCorrect() {
        cartPage.openCart();
        int initialQuantity = cartPage.getProductQuantity();
        homePage.goToSection("Women");
        homePage.goToFirstSubsection("Women");
        productPage.selectProduct();
        productPage.selectSize();
        productPage.selectColor();
        productPage.addToCard();
        cartPage.openCart();
        int updatedQuantity = cartPage.getProductQuantity();
        assert initialQuantity < updatedQuantity : "Updated quantity is not greater than initial quantity";
    }

    @Test
    public void checkCartPricesAreCorrect() {
        homePage.goToSection("What's New");
        productPage.selectProduct();
        productPage.selectSize();
        productPage.selectColor();
        productPage.addToCard();
        cartPage.openCart();
        assertTrue(cartPage.checkCartPriceSubtotal(), "Cart subtotal price is not correct");
        assertTrue(cartPage.checkTotalPriceIsCorrect(), "Cart total price is not correct");
    }
}
