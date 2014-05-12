package com.petstore.taa.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.petstore.taa.page.ItemsForProductPage;
import com.petstore.taa.page.ProductsForCategoryPage;
import com.petstore.taa.page.ShoppingCartPage;
import com.petstore.taa.page.SignInPage;
import com.petstore.taa.page.WelcomePage;

//TODO - apply @Inject annotation for page objects
// apply page synchronization
public class CartUpdateTestNew extends BaseTest {

	private WelcomePage welcomePage;
	private SignInPage signInPage;
	private ProductsForCategoryPage productsForCategory;
	private ItemsForProductPage itemsForProductPage;
	private ShoppingCartPage shoppingCartPage;

	@Before
	public void setUp() {
		welcomePage = new WelcomePage(driver);
		signInPage = new SignInPage(driver);
		productsForCategory = new ProductsForCategoryPage(driver);
		itemsForProductPage = new ItemsForProductPage(driver);
		shoppingCartPage = new ShoppingCartPage(driver);
	}

	@Test
	public void testCartUpdate() throws Exception {
		welcomePage.clickLogInButton();
		signInPage.enterLogIn("user").enterPassword("user").clickSignInButton();

		welcomePage.selectFishCategory();

		productsForCategory.selectProduct("Goldfish");
		itemsForProductPage.addToCart("Female Puppy");
		Assert.assertEquals("$ 12.0", shoppingCartPage.getTotal());

		shoppingCartPage.selectFishCategory();
		productsForCategory.selectProduct("Goldfish");
		itemsForProductPage.addToCart("Male Puppy");
		Assert.assertEquals("$ 24.0", shoppingCartPage.getTotal());

		shoppingCartPage.enterQuantity(1, "2").clickUpdateQuantity(1);
		Assert.assertEquals("$ 36.0", shoppingCartPage.getTotal());

		shoppingCartPage.enterQuantity(2, "2").clickUpdateQuantity(2);
		Assert.assertEquals("$ 48.0", shoppingCartPage.getTotal());

		shoppingCartPage.selectFishCategory();
		productsForCategory.selectProduct("Koi");
		itemsForProductPage.addToCart("Male Adult");
		Assert.assertEquals("$ 60.0", shoppingCartPage.getTotal());

		shoppingCartPage.clickRemove(3);
		Assert.assertEquals("$ 48.0", shoppingCartPage.getTotal());

		shoppingCartPage.logOut();
		Assert.assertEquals("Youve been logged out",
				welcomePage.getAlertMessage());

	}

}
