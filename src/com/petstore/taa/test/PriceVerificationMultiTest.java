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
import com.petstore.taa.page.WelcomePage;
import com.petstore.taa.task.SignInTask;

/**
 * Step 3. - time up to 30 minutes
 * In this class following approach/technique/patterns will be presented:
 * 	- task layer introduction (for gathering similar business process test steps)
 *  - data injection from external resource files
 *  - multirun of the same business logic
 *  
 * @author michalkoz
 *
 */
@RunWith(Feeder.class)
public class PriceVerificationMultiTest extends BaseTest {

	private WelcomePage welcomePage;
	private ProductsForCategoryPage productsForCategory;
	private ItemsForProductPage itemsForProductPage;
	private ShoppingCartPage shoppingCartPage;
	
	private SignInTask signInTask;

	@Before
	public void setUp() {
		welcomePage = new WelcomePage(webDriver);
		productsForCategory = new ProductsForCategoryPage(webDriver);
		itemsForProductPage = new ItemsForProductPage(webDriver);
		shoppingCartPage = new ShoppingCartPage(webDriver);
		
		signInTask = new SignInTask(webDriver);
	}
	
	@Test
	public void priceVerificationMultiTest(@Source("data/PriceVerification.xlsx") PriceVerification data) {
		signInTask.signInAs(data.getUser(), data.getPass());
		
		welcomePage
			.selectCategory(data.getCategory());
		productsForCategory
			.selectProduct(data.getProduct());
		itemsForProductPage
			.addToCart(data.getItem());
		
		Assert.assertEquals(data.getExpectedPrice(), shoppingCartPage.getTotal());
	}

}
