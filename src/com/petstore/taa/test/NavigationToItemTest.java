package com.petstore.taa.test;

import org.junit.Before;
import org.junit.Test;

import com.petstore.taa.page.ItemsForProductPage;
import com.petstore.taa.page.ProductsForCategoryPage;
import com.petstore.taa.page.WelcomePage;

public class NavigationToItemTest extends BaseTest {

	private WelcomePage welcomePage;
	private ProductsForCategoryPage productsForCategory;
	private ItemsForProductPage itemsForProductPage;
	
	@Before
	public void setUp() {
		welcomePage = new WelcomePage(driver);
		productsForCategory = new ProductsForCategoryPage(driver);
		itemsForProductPage = new ItemsForProductPage(driver);
	}

	
	@Test
	public void testNavigationToItem(){
		onPage(welcomePage)
			.selectFishCategory();
		
		onPage(productsForCategory)
			.selectProduct(1);
		onPage(productsForCategory)
			.selectProduct(2);
//		itemsForProductPage
//			.selectItem(2);
		System.out.println();
	}
	
}
