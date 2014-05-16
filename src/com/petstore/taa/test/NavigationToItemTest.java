package com.petstore.taa.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.petstore.taa.page.ItemsForProductPage;
import com.petstore.taa.page.ProductsForCategoryPage;
import com.petstore.taa.page.WelcomePage;
import com.petstore.taa.test.suite.FastTests;
import com.petstore.taa.test.suite.SlowTests;

/**
 * Step 2.
 * In this class following approach/technique/patterns will be presented:
 * 	- page elements (locators) reusage in different tests
 * 	- onPage synchronization - wait until page is loaded
 * 	- introduction properties files for gathering env related stuff
 * 
 * @author michalkoz
 *
 */
@Category(FastTests.class)
public class NavigationToItemTest extends BaseTest {

	private WelcomePage welcomePage;
	private ProductsForCategoryPage productsForCategory;
	private ItemsForProductPage itemsForProductPage;
	
	@Before
	public void setUp() {
		welcomePage = new WelcomePage(webDriver);
		productsForCategory = new ProductsForCategoryPage(webDriver);
		itemsForProductPage = new ItemsForProductPage(webDriver);
	}

	@Test
	public void testNavigationToItem(){
		onPage(welcomePage)
			.selectFishCategory();
		
		onPage(productsForCategory)
			.selectProduct(1);
		onPage(itemsForProductPage)
			.selectItem(2);
		System.out.println();
	}
	
}
