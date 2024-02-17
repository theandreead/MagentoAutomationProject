package test;

import org.testng.annotations.Test;
import pages.ProductPage;
import pages.WishlistPage;
import pages.HomePage;

@Test
public class AddToWishlistTests  extends  BaseTest{

	ProductPage productPage = new ProductPage(driver);
	WishlistPage wishListPage = new WishlistPage(driver);
	HomePage homePage = new HomePage(driver);

	@Test
	public void addProductToWishlist() {
		homePage.goToSection("Men");
		productPage.selectProduct();
		productPage.addToWishlist();
		wishListPage.isProductWishlistPopupDisplayed();
	}
}