package com.petstore.taa.test;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.Guice;

import com.petstore.taa.page.ItemsForProductPage;
import com.petstore.taa.page.ProductsForCategoryPage;
import com.petstore.taa.page.ShoppingCartPage;
import com.petstore.taa.page.SignInPage;
import com.petstore.taa.page.WelcomePage;

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
		onPage(welcomePage)
			.clickLogInButton();
		onPage(signInPage)
			.enterLogIn("user")
			.enterPassword("user")
			.clickSignInButton();

		onPage(welcomePage)
			.selectFishCategory();

		onPage(productsForCategory)
			.selectProduct("Goldfish");
		
		onPage(itemsForProductPage)
			.addToCart("Female Puppy");
		Assert.assertEquals("$ 12.0", onPage(shoppingCartPage).getTotal());

		onPage(shoppingCartPage)
			.selectFishCategory();
		onPage(productsForCategory)
			.selectProduct("Goldfish");
		onPage(itemsForProductPage)
			.addToCart("Male Puppy");
		Assert.assertEquals("$ 24.0", onPage(shoppingCartPage).getTotal());

		onPage(shoppingCartPage)
			.enterQuantity(1, "2")
			.clickUpdateQuantity(1);
		Assert.assertEquals("$ 36.0", onPage(shoppingCartPage).getTotal());

		onPage(shoppingCartPage)
			.enterQuantity(2, "2")
			.clickUpdateQuantity(2);
		Assert.assertEquals("$ 48.0", onPage(shoppingCartPage).getTotal());

		onPage(shoppingCartPage)
			.selectFishCategory();
		onPage(productsForCategory)
			.selectProduct("Koi");
		onPage(itemsForProductPage)
			.addToCart("Male Adult");
		Assert.assertEquals("$ 60.0", onPage(shoppingCartPage).getTotal());

		onPage(shoppingCartPage)
			.clickRemove(3);
		Assert.assertEquals("$ 48.0", onPage(shoppingCartPage).getTotal());

		onPage(shoppingCartPage).logOut();
		Assert.assertEquals("Youve been logged out",
				onPage(welcomePage).getAlertMessage());

	}

}
