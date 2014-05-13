package com.petstore.taa.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.petstore.taa.data.PriceVeryfication;
import com.petstore.taa.page.ItemsForProductPage;
import com.petstore.taa.page.ProductsForCategoryPage;
import com.petstore.taa.page.ShoppingCartPage;
import com.petstore.taa.page.SignInPage;
import com.petstore.taa.page.WelcomePage;

public class PriceVeryficationMultiTest extends BaseTest {

	private WelcomePage welcomePage;
	private SignInPage signInPage;
	private ProductsForCategoryPage productsForCategory;
	private ItemsForProductPage itemsForProductPage;
	private ShoppingCartPage shoppingCartPage;

	@Before
	public void setUp() {
//		welcomePage = new WelcomePage(driver);
		signInPage = new SignInPage(driver);
		productsForCategory = new ProductsForCategoryPage(driver);
		itemsForProductPage = new ItemsForProductPage(driver);
		shoppingCartPage = new ShoppingCartPage(driver);
	}

	
	//TODO - use feed4junit in order to inject PriceVerification data object 
	@Test
	public void priceVeryficationMultiTest() {
		welcomePage
			.clickLogInButton();
		signInPage
			.enterLogIn("user")
			.enterPassword("user")
			.clickSignInButton();
		welcomePage
			.selectCategory("Fish");
		productsForCategory
			.selectProduct("Angelfish");
		itemsForProductPage
			.addToCart("Thootless");
		
		Assert.assertEquals("$ 10.0", shoppingCartPage.getTotal());
	}

}
