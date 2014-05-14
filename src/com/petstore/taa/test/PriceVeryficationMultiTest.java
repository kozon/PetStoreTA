package com.petstore.taa.test;

import org.databene.benerator.anno.Source;
import org.databene.feed4junit.Feeder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.petstore.taa.data.PriceVerification;
import com.petstore.taa.page.ItemsForProductPage;
import com.petstore.taa.page.ProductsForCategoryPage;
import com.petstore.taa.page.ShoppingCartPage;
import com.petstore.taa.page.SignInPage;
import com.petstore.taa.page.WelcomePage;

@RunWith(Feeder.class)
public class PriceVeryficationMultiTest extends BaseTest {

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
	public void priceVerificationMultiTest(@Source("data/PriceVerification.xlsx") PriceVerification data) {
		welcomePage
			.clickLogInButton();
		signInPage
			.enterLogIn(data.getUser())
			.enterPassword(data.getPass())
			.clickSignInButton();
		welcomePage
			.selectCategory(data.getCategory());
		productsForCategory
			.selectProduct(data.getProduct());
		itemsForProductPage
			.addToCart(data.getItem());
		
		Assert.assertEquals(data.getExpectedPrice(), shoppingCartPage.getTotal());
	}

}
